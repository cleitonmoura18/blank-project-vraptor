package br.com.blank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.blank.dao.PerfilDao;
import br.com.blank.dao.UsuarioDao;
import br.com.blank.model.Role;
import br.com.blank.model.Usuario;
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
	
	@Post
	@IncludeParameters
	public void salvar(Usuario usuario, Role role){
		
		validaUsuario(usuario);
		validator.onErrorForwardTo(this).form();
		adicionaRole(usuario, role);
		
		try {
			usuarioDao.salvar(usuario);
			result.include("sucesso", "Usuário salvo com sucesso!");
			result.redirectTo(this).lista();
		} catch (RuntimeException e) {
			result.include("erro", Util.exceptionRootCauseMessage(e));
			result.forwardTo(this).form();
		}
		
	}

	private void validaUsuario(Usuario usuario) {
		validator.addIf(Util.isNuloOuVazio(usuario.getNome()), new SimpleMessage("nome", "Nome Inválido!"));
		validator.addIf(Util.isNuloOuVazio(usuario.getLogin()), new SimpleMessage("login", "Login Inválido!"));
	}

	private void adicionaRole(Usuario usuario, Role role) {
		List<Role> roles = new ArrayList<Role>();
		roles.add(perfilDao.carregarRole(role.getName()));
		usuario.setRoles(roles);
	}
	
	public void lista(){
		result.include("usuarios", usuarioDao.listAll());
	}
	
	@Get
	@Path("/usuario/{id}")
	public void editar(Long id) {
		
		validator.addIf(id == null, new SimpleMessage("id", "Usuário não encontrado!"));
		validator.onErrorForwardTo(this).lista();
		
		Usuario usuario = usuarioDao.carregar(id);
		result.include("usuario", usuario);
		result.include("role", usuario.getRole());
		
		result.redirectTo(this).form();
	}
	
	@Get
	@Path("/usuario/excluir/{id}")
	public void excluir(Long id) {
		
		try {
			Usuario usuario = usuarioDao.carregar(id);
			usuarioDao.desabilitar(usuario);
			result.include("sucesso", "Usuário excluído com sucesso!");
			result.redirectTo(this).lista();
		} catch (RuntimeException e) {
			result.include("erro", Util.exceptionRootCauseMessage(e));
			result.forwardTo(this).lista();
		}
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
