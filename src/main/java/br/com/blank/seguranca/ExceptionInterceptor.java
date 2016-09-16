package br.com.blank.seguranca;

import java.util.Arrays;

import javax.inject.Inject;

import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.com.caelum.vraptor.jpa.JPATransactionInterceptor;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.view.Results;

@Intercepts(before = JPATransactionInterceptor.class)
public class ExceptionInterceptor{
	
private final Result result;
	
	 
	@Deprecated
	protected ExceptionInterceptor() {
		this(null);
	}
	
	@Inject
	public ExceptionInterceptor(Result result) {
		this.result = result;
	}
   
    @AroundCall
    public void intercept(SimpleInterceptorStack stack) {
    	try {  
		    stack.next();  
	    } catch (Exception e) {
	    	String message = exceptionRootCauseMessage(e);
	    	
	    	result
	    		.include("errors", Arrays.asList(new SimpleMessage(message, "ERRO")))
	    		.use(Results.referer())
	    		.redirect();
	    }  
    }
    
    public static String exceptionRootCauseMessage(Exception e) {
		e.printStackTrace();
		Throwable t = e.getCause();
		String errorMessage = "";
		
	    if (t != null) {			
			while (t.getCause() != null) {
		        t = t.getCause();
		    }
			errorMessage = t.getLocalizedMessage();
	    } else {
	    	errorMessage = e.getLocalizedMessage();
	    }
	    
	    return errorMessage;
	}
}
