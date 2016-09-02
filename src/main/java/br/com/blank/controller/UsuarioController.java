package br.com.blank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.blank.dao.PerfilDao;
import br.com.blank.dao.UsuarioDao;
import br.com.blank.model.Role;
import br.com.blank.model.Usuario;
import br.com.blank.seguranca.UsuarioLogado;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class UsuarioController {
	
	private final Result result;
	private UsuarioDao usuarioDao;
	private PerfilDao perfilDao;
	private Validator validator;
	
	@Inject
	public UsuarioController(Result result, UsuarioDao usuarioDao, 
			PerfilDao perfilDao, Validator validator) {
		super();
		this.result = result;
		this.usuarioDao = usuarioDao;
		this.validator = validator;
		this.perfilDao = perfilDao;
	}
	
	public UsuarioController() {
		this(null, null, null, null);
	}
	
	public void form(){
		result.include("roles", perfilDao.listAll());
	}
	
	@IncludeParameters
	public void adiciona(@Valid Usuario usuario, Role role){
		validator.onErrorRedirectTo(this).form();
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(perfilDao.carregarRole(role.getName()));
		usuario.setRoles(roles);
		
		usuarioDao.salvar(usuario);
		result.redirectTo(this).lista();
	}
	
	public void lista(){
		result.include("usuarios", usuarioDao.listAll());
	}
	
	@Get
	@Path("/usuario/edita/{usuario.id}")
	public void edita(Usuario usuario) {
		
		usuario = usuarioDao.carregar(usuario.getId());
		result.include("usuario", usuario);
		result.include("role", usuario.getRole());
		
		result.redirectTo(this).form();
	}

	public UsuarioDao getUsuarioDao() {
		return usuarioDao;
	}

	public void setUsuarioDao(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
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
