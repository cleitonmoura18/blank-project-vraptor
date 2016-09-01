package br.com.blank.dao;

import java.util.List;

import br.com.blank.model.Role;

public interface PerfilDao {
	public Role carregarRole(String role);
	public void save(Role role);
	public List<Role> listAll();
}
