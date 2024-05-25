package br.com.fuctura.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class TipoVeiculo {
	@Id
	@GeneratedValue
	private int codigo;
	private String categoria;
	private String descricao;
	
	public TipoVeiculo(){}
	
	public TipoVeiculo(String categoria, String descricao) {
		super();
		this.categoria = categoria;
		this.descricao = descricao;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getCodigo() {
		return codigo;
	}
}
