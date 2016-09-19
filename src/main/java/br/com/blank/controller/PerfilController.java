package br.com.blank.controller;

import javax.inject.Inject;

import br.com.blank.dao.PerfilDao;
import br.com.blank.model.Role;
import br.com.blank.util.Util;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.SimpleMessage;
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
	
	@Post
	@IncludeParameters
	public void salvar(Role role){
		validaRole(role);
		validator.onErrorRedirectTo(this).form();
		try {
			perfilDao.save(role);
			result.include("sucesso", "Perfil salvo com sucesso!");
			result.redirectTo(this).lista();
		} catch (Exception e) {
			result.include("erro", Util.exceptionRootCauseMessage(e));
			result.forwardTo(this).form();
		}
	}
	
	private void validaRole(Role role) {
		validator.addIf(Util.isNuloOuVazio(role.getName()), new SimpleMessage("nome", "Nome Inválido!"));
	}

	public void lista(){
		result.include("roles", perfilDao.listAll());
	}
	
	@Get
	@Path("/perfil/editar/{nome}")
	public void editar(String nome) {
		validator.addIf(Util.isNuloOuVazio(nome), new SimpleMessage("id", "Perfil não encontrado!"));
		validator.onErrorForwardTo(this).lista();
		
		Role role = perfilDao.carregarRole(nome);
		result.include("role", role);
		
		result.redirectTo(this).form();
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
