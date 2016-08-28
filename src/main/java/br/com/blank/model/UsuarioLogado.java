package br.com.blank.model;

import java.io.Serializable;

public class UsuarioLogado implements Serializable{
	
	private Usuario usuario;
	
	public void logadoCom(Usuario usuario){
		this.usuario = usuario;
	}
	
	public void desloga() {
		this.usuario = null;
	}
	
	public boolean isLogado() {
		return this.usuario != null;
	}
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
}
