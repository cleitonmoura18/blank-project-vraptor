package br.com.blank.seguranca;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.blank.controller.LoginController;
import br.com.caelum.brutauth.auth.handlers.RuleHandler;
import br.com.caelum.vraptor.Result;

@RequestScoped
public class RedirectHandler implements RuleHandler{
    private final Result result;

    /**
     * @deprecated CDI eyes only
     */
    protected RedirectHandler() {
        this(null);
    }

    @Inject
    public RedirectHandler(Result result) {
        this.result = result;
    }

    @Override
    public void handle() {
        result.redirectTo(LoginController.class).index();
    }
}
