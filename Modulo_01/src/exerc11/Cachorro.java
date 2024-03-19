package exerc11;

public class Cachorro {
	String nome;
	double peso;
	String corDoPelo;
	
	public Cachorro(String nome, double peso, String corDoPelo) {
		this.nome = nome;
		this.peso = peso;
		this.corDoPelo = corDoPelo;
	}
	
	void latir(){
		System.out.println("AUU AUU AUU");
	}
	void comer(){
		System.out.println("Comendo...");
	}
	void detalhe(){
		System.out.println("NOME: " + this.nome);
		System.out.println("PESO: " + this.peso);
		System.out.println("COR: " + this.corDoPelo);
	}
}