package br.com.blank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import br.com.blank.util.Util;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nome;
	@NotEmpty
	@Column(nullable = false, unique = true)
	private String login;
	@NotEmpty
	@Column(nullable = false)
	private String senha;
	private boolean desabilitado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = Util.setMD5Password(senha);
	}
	public boolean isDesabilitado() {
		return desabilitado;
	}
	public void setDesabilitado(boolean desabilitado) {
		this.desabilitado = desabilitado;
	}
	
}
