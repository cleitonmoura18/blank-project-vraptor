package br.com.blank.seguranca;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.caelum.brutauth.auth.annotations.HandledBy;
import br.com.caelum.brutauth.auth.rules.SimpleBrutauthRule;

@RequestScoped
@HandledBy(RedirectHandler.class)
public class PossuiAcesso implements SimpleBrutauthRule {

	private UsuarioLogado usuarioLogado;
	
	public PossuiAcesso() {
		this(null);
	}
	
	@Inject
	public PossuiAcesso(UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

	@Override
	public boolean isAllowed(long key) {
		return usuarioLogado.isRole(key);
	}

}
