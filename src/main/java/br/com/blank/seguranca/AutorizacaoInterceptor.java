package br.com.blank.seguranca;

import javax.inject.Inject;

import br.com.blank.controller.LoginController;
import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;

@Intercepts
public class AutorizacaoInterceptor {
	
	private UsuarioLogado usuarioLogado;
	private Result result;
	private ControllerMethod method;
	
	@Inject
	public AutorizacaoInterceptor(UsuarioLogado usuarioLogado, Result result, ControllerMethod method){
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.method = method;
	}
	
	public AutorizacaoInterceptor(){
		this(null, null, null);
	}
	
	@Accepts
	public boolean accept(){
		return !method.containsAnnotation(Aberto.class);
	}
	
	@AroundCall
	public void intercept(SimpleInterceptorStack stack){
		if(usuarioLogado.isLogado())
			stack.next();
		else
			result.redirectTo(LoginController.class).login();
	}
}
