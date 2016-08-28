package br.com.blank.controller;

import javax.inject.Inject;

import br.com.blank.model.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;

@Controller
public class LoginController {

	private final Result result;
	private UsuarioLogado usuarioLogado;

	/**
	 * @deprecated CDI eyes only
	 */
	protected LoginController() {
		this(null);
	}
	
	@Inject
	public LoginController(Result result) {
		this.result = result;
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
}