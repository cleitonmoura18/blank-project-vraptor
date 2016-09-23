package br.com.blank.controller;

import javax.inject.Inject;

import br.com.blank.dao.UsuarioDao;
import br.com.blank.model.Usuario;
import br.com.blank.seguranca.Aberto;
import br.com.blank.seguranca.UsuarioLogado;
import br.com.blank.util.AcessoUtil;
import br.com.blank.util.Util;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.caelum.vraptor.view.Results;

@Controller
public class LoginController {

	private final Result result;
	private UsuarioLogado usuarioLogado;
	private UsuarioDao usuarioDao;
	private Validator validator;
	
	protected LoginController() {
		this(null, null, null, null);
	}
	
	@Inject
	public LoginController(Result result, UsuarioLogado usuarioLogado, UsuarioDao usuarioDao, Validator validator) {
		this.result = result;
		this.usuarioLogado = usuarioLogado;
		this.usuarioDao = usuarioDao;
		this.validator = validator;
	}

	@Path("/index")
	public void index() {
		result.include("variable", "VRaptor!");
	}
	
	@Aberto
	@Path(value="/", priority=Path.HIGHEST)
	public void login() {
		if(usuarioDao.listAll().size() == 0)
			result.use(Results.logic()).redirectTo(BootstapController.class).primeiroAcessoAoSistema();
		if(usuarioLogado.isLogado())
			result.redirectTo(this).index();
	}
	
	@Aberto
	public void edita() {
		if(usuarioLogado.isLogado())
			result.redirectTo(this).index();
	}
	
	@Aberto
	@Post
	public void logar(String login, String senha) {
		Usuario usuario = usuarioDao.carregar(login, senha);
		validator.addIf(usuario == null, new SimpleMessage("login_invalido", "Login ou senha incorretos!"));
		validator.onErrorRedirectTo(this).login();
		
		if(AcessoUtil.isSenhaPadrao(senha)){
			result.redirectTo(this).edita();
			return;
		}
		
		usuarioLogado.fazLoginCom(usuario);
		result.redirectTo(this).index();
			
	}
	
	@Aberto
	@Post
	public void alterarSenha(String login, String senha, String novoLogin, String novaSenha, String confirmeSenha) {
		Usuario usuario = usuarioDao.carregar(login, senha);
		validaAlteracaoDeSenha(novaSenha, confirmeSenha, usuario);
		validator.onErrorRedirectTo(this).edita();
		
		usuario.setLogin(novoLogin);
		usuario.setSenha(novaSenha);
		usuarioDao.salvar(usuario);
		
		result.include("sucesso", "Senha alterada com sucesso!");
		result.redirectTo(this).login();
	}

	private void validaAlteracaoDeSenha(String novaSenha, String confirmeSenha, Usuario usuario) {
		validator.addIf(usuario == null, new SimpleMessage("login_invalido", "Login ou senha incorretos!"));
		validator.addIf(AcessoUtil.isSenhaPadrao(novaSenha), new SimpleMessage("senha_padrao", "A nova senha deser ser diferente da senha atual!"));
		validator.addIf(!novaSenha.equals(confirmeSenha), new SimpleMessage("nova_senha", "A nova senha incorreta!"));
	}
	
	@Aberto
	public void desloga(){
		usuarioLogado.desloga();
		result.redirectTo(this).login();
	}

	public UsuarioLogado getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}

	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public Result getResult() {
		return result;
	}
}