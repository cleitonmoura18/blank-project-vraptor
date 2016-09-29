package br.com.blank.controller;

import java.util.List;

import javax.inject.Inject;

import com.google.common.collect.Lists;

import br.com.blank.model.Exemplo;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;

@Controller
public class ExemploController {
	
	private final Result result;

	@Inject
	public ExemploController(Result result) {
		super();
		this.result = result;
	}
	
	public ExemploController() {
		this(null);
	}
	
	public void form(){
		result.include("exemplo1", new Exemplo(1, "um"));
		result.include("exemplos", listaDeExemplos());
	}
	
	@Post("/exemplo/enviar")
	public void enviarPost(Exemplo exemplo){
		result.include("sucesso", "Exemplo "+exemplo.getDescricao()+" post enviado!");
		result.include("erro", "Exemplo "+exemplo.getDescricao()+" post enviado!");
		result.redirectTo(this).lista();
	}
	
	@Put("/exemplo/enviar")
	public void enviarPut(Exemplo exemplo){
		result.include("sucesso", "Exemplo "+exemplo.getDescricao()+" put enviado!");
		result.include("erro", "Exemplo "+exemplo.getDescricao()+" put enviado!");
		result.redirectTo(this).lista();
	}
	
	@Get("/exemplo/{id}")
	public void editar(Long id) {
		result.include("sucesso", "Exemplo editar enviado!");
		result.include("erro", "Exemplo editar enviado!");
		result.redirectTo(this).form();
	}
	
	@Get("/exemplo/excluir/{id}")
	public void excluir(Long id) {
		result.include("sucesso", "Exemplo excluir enviado!");
		result.include("erro", "Exemplo excluir enviado!");
		result.redirectTo(this).lista();
	}
	
	
	public void lista(){
		result.include("exemplos", listaDeExemplos());
	}
		
	private List<Exemplo> listaDeExemplos() {
		return Lists.newArrayList(new Exemplo(1, "um"), new Exemplo(2, "dois"), new Exemplo(3, "tres"));
	}

	public Result getResult() {
		return result;
	}
	
	
}
