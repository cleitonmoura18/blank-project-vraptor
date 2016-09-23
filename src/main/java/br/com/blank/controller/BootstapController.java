package br.com.blank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.blank.dao.PerfilDao;
import br.com.blank.dao.UsuarioDao;
import br.com.blank.model.Role;
import br.com.blank.model.Usuario;
import br.com.blank.seguranca.Aberto;
import br.com.blank.util.AcessoUtil;
import br.com.blank.util.Util;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

@Controller
public class BootstapController {
	
	private final Result result;
	private UsuarioDao usuarioDao;
	private PerfilDao perfilDao;

	public BootstapController() {
		this(null, null, null);
	}
	
	@Inject
	public BootstapController(UsuarioDao usuarioDao, PerfilDao perfilDao, Result result) {
		this.usuarioDao = usuarioDao;
		this.perfilDao = perfilDao;
		this.result = result;
	}
	
	@Aberto
	public void primeiroAcessoAoSistema(){
		
		Role roleAdministrador = perfilDao.carregarRole(AcessoUtil.DESC_ADMINISTRADOR);
		if (roleAdministrador == null) {
			System.out.println("Criando perfil ADMINISTRADOR");
			roleAdministrador = new Role();
			roleAdministrador.setName(AcessoUtil.DESC_ADMINISTRADOR);
			perfilDao.save(roleAdministrador);
			System.out.println("Perfil ADMINISTRADOR criado");
		}
		
		Role roleGerente = perfilDao.carregarRole(AcessoUtil.DESC_GERENTE);
		if (roleGerente == null) {
			System.out.println("Criando perfil GERENTE");
			roleGerente = new Role();
			roleGerente.setName(AcessoUtil.DESC_GERENTE);
			perfilDao.save(roleGerente);
			System.out.println("Perfil GERENTE criado");
		}
		
		Role roleUsuario = perfilDao.carregarRole(AcessoUtil.DESC_USUARIO);
		if (roleUsuario == null) {
			System.out.println("Criando perfil USUARIO");
			roleUsuario = new Role();
			roleUsuario.setName(AcessoUtil.DESC_USUARIO);
			perfilDao.save(roleUsuario);
			System.out.println("Perfil USUARIO criado");
		}
		
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdministrador);

		System.out.println("Criando usuário ADMINISTRADOR");
		Usuario usuario = new Usuario();
		usuario.setNome("USUÁRIO ADMINISTRADOR");
		usuario.setLogin("admin");
		usuario.setSenha("admin");
		usuario.setDesabilitado(false);
		usuario.setRoles(roles);

		usuarioDao.salvar(usuario);
		System.out.println("Usuário ADMINISTRADOR criado");
		
		result.redirectTo(LoginController.class).login();
	}
	
}
