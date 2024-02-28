package teste;

public class TstePOO {

	public static void main(String[] args) {

		Pessoa p1 = new Pessoa();
		Pessoa p2 = new Pessoa();
		
		p1.nome = "Andre";
		p1.CPF = "878.745.546-55";
		p1.idade = 12;
		
		p2.nome = "Jose";
		p2.CPF = "5464546456";
		p2.idade = 33;
		
		p2.quemSou();
		System.out.println("______________________________________");
		p2.calcular(25, 33);

	}

}
