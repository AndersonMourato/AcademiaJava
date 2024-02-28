package teste;

public class Pessoa {
	String nome = "";
	String CPF = "";
	int idade = 0;
	
	
	void quemSou(){
		System.out.println("Meu nome é: " + this.nome);
		System.out.println("Meu CPF é: " + this.CPF);
		System.out.println("Tenho " + this.idade + " anos");
	}
	
	void calcular(int num1, int num2) {
		int soma = num1 + num2;
		System.out.println("A soma dos numeros foi: " + soma);
	}
	
	
}
