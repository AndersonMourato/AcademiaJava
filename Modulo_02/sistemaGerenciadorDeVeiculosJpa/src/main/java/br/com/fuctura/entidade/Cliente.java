package br.com.fuctura.entidade;

import jakarta.persistence.Entity;

@Entity
public class Cliente extends Pessoa {

	public Cliente(String nome, String cpf, String telefone) {
		super(nome, cpf, telefone);
		// TODO Auto-generated constructor stub
	}
	
	public Cliente(){
		super();
	}

}
