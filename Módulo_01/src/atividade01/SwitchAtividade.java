package atividade01;

import java.util.Scanner;

public class SwitchAtividade {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Pessoa pessoa = new Pessoa();
		int id;

		System.out.println("Informe seus dados conforme solicidados a baixo.");
		System.out.println("Nome: ");
		pessoa.nome = scan.nextLine();
		System.out.println("Idade: ");
		pessoa.idade = scan.nextInt();
		System.out.println("Sexo: ");
		pessoa.sexo = scan.next();
		System.out.println("Saldo da Conta Bancaria: ");
		pessoa.saldo = scan.nextDouble();
		
		Produto prod1 = new Produto("Camisa", 94.62);
		Produto prod2 = new Produto("Calça", 144.55);
		Produto prod3 = new Produto("Sapato", 199.99);
		Produto prod4 = new Produto("Bone", 49.52);
		Produto prod5 = new Produto("short", 79.52);
		
		System.out.println("########### LISTA DE ITENS DISPONIVEIS ###########");	
		System.out.println("ID: 1 | " + prod1.nome + "	| R$ " + prod1.preco);
		System.out.println("ID: 2 | " + prod2.nome + "	| R$ " + prod2.preco);
		System.out.println("ID: 3 | " + prod3.nome + "	| R$ " + prod3.preco);
		System.out.println("ID: 4 | " + prod4.nome + "	| R$ " + prod4.preco);
		System.out.println("ID: 4 | " + prod5.nome + "	| R$ " + prod5.preco);
		System.out.println("__________________________________________________");
		
		System.out.println("Digite o ID de um produto para compar.");
		id = scan.nextInt();
		
		switch(id) {
			case 1: 
				if(pessoa.saldo >= prod1.preco) {
					pessoa.saldo = (pessoa.saldo - prod1.preco);
					System.out.println("********** COMPRA REALIZADA COM SUCESSO **********");
					System.out.println("PRODUTO	|	" + prod1.nome + "	|	R$ " + prod1.preco);
					System.out.println("NOME:	|	" + pessoa.nome + "	|	IDADE: " + pessoa.idade + "	|	SEXO: " + pessoa.sexo);
					System.out.println("SALDO DA CONTA: " + pessoa.saldo);
					System.out.println("___________________________________________________");
				} else {
					System.out.println("********** SALDO INSUFICIENTE PARA ESTE PRODUTO **********");
				}
			break;
			
			case 2: 
				if(pessoa.saldo >= prod2.preco) {
					pessoa.saldo = (pessoa.saldo - prod2.preco);
					System.out.println("********** COMPRA REALIZADA COM SUCESSO **********");
					System.out.println("PRODUTO	| " + prod2.nome + " | R$ " + prod2.preco);
					System.out.println("NOME:	| " + pessoa.nome + " | IDADE: " + pessoa.idade + " | SEXO: " + pessoa.sexo);
					System.out.println("SALDO DA CONTA: " + pessoa.saldo);
					System.out.println("___________________________________________________");
				} else {
					System.out.println("********** SALDO INSUFICIENTE PARA ESTE PRODUTO **********");
				}
			break;
			
			case 3: 
				if(pessoa.saldo >= prod3.preco) {
					pessoa.saldo = (pessoa.saldo - prod3.preco);
					System.out.println("********** COMPRA REALIZADA COM SUCESSO **********");
					System.out.println("PRODUTO	| " + prod3.nome + " | R$ " + prod3.preco);
					System.out.println("NOME:	| " + pessoa.nome + " | IDADE: " + pessoa.idade + " | SEXO: " + pessoa.sexo);
					System.out.println("SALDO DA CONTA: " + pessoa.saldo);
					System.out.println("___________________________________________________");
				} else {
					System.out.println("********** SALDO INSUFICIENTE PARA ESTE PRODUTO **********");
				}
			break;
			
			case 4: 
				if(pessoa.saldo >= prod4.preco) {
					pessoa.saldo = (pessoa.saldo - prod4.preco);
					System.out.println("********** COMPRA REALIZADA COM SUCESSO **********");
					System.out.println("PRODUTO	| " + prod4.nome + " | R$ " + prod4.preco);
					System.out.println("NOME:	| " + pessoa.nome + " | IDADE: " + pessoa.idade + " | SEXO: " + pessoa.sexo);
					System.out.println("SALDO DA CONTA: " + pessoa.saldo);
					System.out.println("___________________________________________________");
				} else {
					System.out.println("********** SALDO INSUFICIENTE PARA ESTE PRODUTO **********");
				}
			break;
			
			case 5: 
				if(pessoa.saldo >= prod5.preco) {
					pessoa.saldo = (pessoa.saldo - prod5.preco);
					System.out.println("********** COMPRA REALIZADA COM SUCESSO **********");
					System.out.println("PRODUTO	| " + prod5.nome + " | R$ " + prod4.preco);
					System.out.println("NOME:	| " + pessoa.nome + " | IDADE: " + pessoa.idade + " | SEXO: " + pessoa.sexo);
					System.out.println("SALDO DA CONTA: " + pessoa.saldo);
					System.out.println("___________________________________________________");
				} else {
					System.out.println("********** SALDO INSUFICIENTE PARA ESTE PRODUTO **********");
				}
			break;
			
			default: System.out.println("********** O ID DO PRODUTO INFORMADO NÃO É VÁLIDO! **********");
			
		}
	}
}


class Pessoa{
	String nome;
	int idade;
	String sexo;
	double saldo;
}

class Produto{
	String nome;
	double preco;
	
	public Produto(String nome, double preco) {
		this.nome = nome;
		this.preco = preco;
	}
}
