package desafio05;

public class Funcionario {
	String nome;
	String cargo;
	float salario;
	
	void aumentarSalario(float valor) {
		this.salario = this.salario + valor;
	}
	
	void imprimirDados() {
		System.out.println("########## DADOS DO FUNCIONARIO ##########");
		System.out.println("NOME: " + this.nome);
		System.out.println("CARGO: " + this.cargo);
		System.out.println("SALARIO: R$" + this.salario);
		System.out.println("___________________________________________");
	}
}
