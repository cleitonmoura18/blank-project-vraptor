package br.com.blank.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

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
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Role> roles;
	
	public Usuario(String login, String senha, List<Role> roles) {
		setLogin(login);
		setSenha(senha);
		setRoles(roles);
	}
	
	public Usuario() {
		setSenha(Util.getSENHA_PADRAO());
	}
	
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
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public Role getRole(){
		return this.roles.get(0);
	}
	
}
