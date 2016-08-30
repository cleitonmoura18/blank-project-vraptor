package br.com.blank.controller;

import javax.inject.Inject;

import br.com.blank.dao.UsuarioDao;
import br.com.blank.model.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
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
	
	@Path("/")
	public void login() {
	}
	
	@Post
	public void logar(String login, String senha) {
		result.redirectTo(LoginController.class).index();
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