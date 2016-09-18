package br.com.blank.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.blank.dao.UsuarioDao;
import br.com.blank.model.Usuario;
import br.com.blank.util.Util;

@RequestScoped
public class UsuarioDaoImpl implements UsuarioDao {
	
	private EntityManager em;
	
	@Inject
	public UsuarioDaoImpl(EntityManager em) {
		super();
		this.em = em;
	}
	
	/**
	 * @deprecated CDI eyes only
	 */
	public UsuarioDaoImpl() {
		this(null);
	}

	@Override
	public Usuario carregar(String login, String senha) {
		String jpql = "select u from Usuario u where u.login = :login and u.senha = :senha and u.desabilitado = false ";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		query.setParameter("login", login);
		query.setParameter("senha", Util.setMD5Password(senha));
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	@Override
	public List<Usuario> listAll() {
		String jpql = "select u from Usuario u where u.desabilitado = false ";
		TypedQuery<Usuario> query = em.createQuery(jpql, Usuario.class);
		return query.getResultList();
	}

	@Override
	public void salvar(Usuario usuario){
		em.getTransaction().begin();
		if(usuario.getId() == null)
			em.persist(usuario);
		else
			em.merge(usuario);
		em.getTransaction().commit();
	}

	@Override
	public Usuario carregar(Long id) {
		return em.find(Usuario.class, id);
	}
	
}
