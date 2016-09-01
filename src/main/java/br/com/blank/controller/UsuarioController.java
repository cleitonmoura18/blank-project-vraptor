package br.com.blank.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.blank.dao.UsuarioDao;
import br.com.blank.model.Usuario;
import br.com.blank.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuarioController {
	
	private final Result result;
	private UsuarioLogado usuarioLogado;
	private UsuarioDao usuarioDao;
	private Validator validator;
	
	@Inject
	public UsuarioController(Result result, UsuarioLogado usuarioLogado,
			UsuarioDao usuarioDao, Validator validator) {
		super();
		this.result = result;
		this.usuarioLogado = usuarioLogado;
		this.usuarioDao = usuarioDao;
		this.validator = validator;
	}
	
	public UsuarioController() {
		this(null, null, null, null);
	}
	
	public void form(){}
	
	@IncludeParameters
	public void adiciona(@Valid Usuario usuario){
		
		validator.onErrorRedirectTo(this).form();
		result.redirectTo(this).lista();
	}
	
	public void lista(){
		result.include("usuarios", usuarioDao.listAll());
	}
	
	public void edita(Usuario usuario) {
		result.of(this).form();
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
