package br.com.blank.util;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.blank.dao.UsuarioDao;
import br.com.blank.model.Role;
import br.com.blank.model.Usuario;
import br.com.blank.seguranca.Aberto;

public class Bootstap {
	
	private UsuarioDao usuarioDao;

	public Bootstap() {
		this(null);
	}
	
	@Inject
	public Bootstap(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;
	}
	
	@Aberto
	public void primeiroAcessoAoSistema(){
		Role roleAdministrador = new Role(Util.getADMINISTRADOR());
		Role roleGerente = new Role(Util.getGERENTE());
		Role roleUsuario = new Role(Util.getUSUARIO());
		List<Role> lista = new ArrayList<Role>();
		lista.add(roleAdministrador);
		Usuario usuario = new Usuario("admin", "admin", lista);
	}
	
}
