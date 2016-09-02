package br.com.blank.seguranca;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.blank.model.Usuario;

@Named
@SessionScoped
public class UsuarioLogado implements Serializable{
	
	private Usuario usuario;
	private String role;
	
	public void fazLoginCom(Usuario usuario){
		this.usuario = usuario;
		this.role = usuario.getRole().getName();
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

	public String getRole() {
		return role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioLogado other = (UsuarioLogado) obj;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
	
}
