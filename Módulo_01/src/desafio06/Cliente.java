package desafio06;

public class Cliente {
	String nome;
	float valor;
	boolean devedor;
	
	Cliente(String nome, float valor){
		this.nome = nome;
		this.valor = valor;
		this.devedor = (valor > 0);
	}
}