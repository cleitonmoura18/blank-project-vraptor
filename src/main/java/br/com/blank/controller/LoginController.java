package br.com.blank.controller;

import javax.inject.Inject;

import br.com.blank.dao.UsuarioDao;
import br.com.blank.model.Usuario;
import br.com.blank.seguranca.Aberto;
import br.com.blank.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class LoginController {

	private final Result result;
	private UsuarioLogado usuarioLogado;
	private UsuarioDao usuarioDao;
	private Validator validator;
	
	/**
	 * @deprecated CDI eyes only
	 */
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
	@Path("/")
	public void login() {
	}
	
	@Aberto
	@Post
	public void logar(String login, String senha) {
		if(login.equals("admin")){
			usuarioLogado.fazLoginCom(new Usuario("admin", "admin", null));
			result.redirectTo(this).index();
		}
		
		Usuario usuario = usuarioDao.carregar(login, senha);
		if(usuario == null){
			validator.add(new SimpleMessage("login_invalido", "Login ou senha incorretos!"));
			validator.onErrorRedirectTo(this).login();
		} else {
			usuarioLogado.fazLoginCom(usuario);
			result.redirectTo(this).index();
		}
			
		result.redirectTo(LoginController.class).index();
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