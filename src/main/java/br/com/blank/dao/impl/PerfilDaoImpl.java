package br.com.blank.dao.impl;

import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.blank.dao.PerfilDao;
import br.com.blank.model.Role;

@RequestScoped
public class PerfilDaoImpl implements PerfilDao {

	private EntityManager em;
	
	@Inject
	public PerfilDaoImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	/**
	 * @deprecated CDI eyes only
	 */
	public PerfilDaoImpl() {
		this(null);
	}
	
	@Override
	public Role carregarRole(String role) {
		return em.find(Role.class, role);
	}

	@Override
	public void save(Role role) {
		em.persist(role);
	}

}
