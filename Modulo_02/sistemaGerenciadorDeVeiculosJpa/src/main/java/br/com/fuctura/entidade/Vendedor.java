package br.com.fuctura.entidade;

import jakarta.persistence.Entity;

@Entity
public class Vendedor extends Pessoa {

	public Vendedor(String nome, String cpf, String telefone) {
		super(nome, cpf, telefone);
		// TODO Auto-generated constructor stub
	}
	
	public Vendedor() {
		super();
	}
	
}
