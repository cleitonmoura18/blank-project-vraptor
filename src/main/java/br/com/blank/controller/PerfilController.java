package br.com.blank.controller;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.blank.dao.PerfilDao;
import br.com.blank.model.Role;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class PerfilController {
	private final Result result;
	private PerfilDao perfilDao;
	private Validator validator;
	
	@Inject
	public PerfilController(Result result, PerfilDao perfilDao, Validator validator) {
		super();
		this.result = result;
		this.perfilDao = perfilDao;
		this.validator = validator;
	}
	
	public PerfilController() {
		this(null, null, null);
	}
	
	public void form(){}
	
	@IncludeParameters
	public void adiciona(@Valid Role role){
		
		validator.onErrorRedirectTo(this).form();
		result.redirectTo(this).lista();
	}
	
	public void lista(){
		result.include("roles", perfilDao.listAll());
	}
	
	public void edita(Role role) {
		result.of(this).form();
	}

	public PerfilDao getPerfilDao() {
		return perfilDao;
	}

	public void setPerfilDao(PerfilDao perfilDao) {
		this.perfilDao = perfilDao;
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
