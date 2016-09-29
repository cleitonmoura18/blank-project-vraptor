package br.com.blank.model;

import java.util.Date;

public class Exemplo {
	private int id;
	private String descricao;
	private Date data;
	
	public Exemplo(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
		this.data = new Date();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
