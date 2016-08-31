package br.com.blank.dao;

import java.util.List;

import br.com.blank.model.Usuario;

public interface UsuarioDao {
	public Usuario carregar(String login, String senha);
	public List<Usuario> listAll();
}
