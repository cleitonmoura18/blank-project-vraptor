package br.com.blank.dao;

import java.util.List;

import br.com.blank.model.Usuario;

public interface UsuarioDao {
	public Usuario carregar(String login, String senha);
	public Usuario carregar(Long id);
	public List<Usuario> listAll();
	public void salvar(Usuario usuario);
	public void desabilitar(Usuario usuario);
}
