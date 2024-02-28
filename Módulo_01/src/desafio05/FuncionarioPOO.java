package desafio05;

public class FuncionarioPOO {

	public static void main(String[] args) {
		Funcionario f1 = new Funcionario();
		f1.nome = "Jose Luiz";
		f1.cargo = "Motorista";
		f1.salario = 2600;
		
		f1.imprimirDados();
		
		f1.aumentarSalario(200);
		
		f1.imprimirDados();

	}

}
