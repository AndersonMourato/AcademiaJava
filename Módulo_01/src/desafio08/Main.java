package desafio08;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Loja loja = new Loja();
		int op = 0;
		boolean loop = true;
		
		while (loop) {
			System.out.println("\n\n################ MENU DE OPÇÕES DA ESCOLA ################");
			System.out.println("[1] - CADASTRAR CARRO");
			System.out.println("[2] - CADASTRAR CLIENTE");
			System.out.println("[3] - PESQUISAR CARRO POR PLACA");
			System.out.println("[4] - PESQUISAR CLIENTE POR CPF");
			System.out.println("[5] - REMOVER CARRO POR PLACA");
			System.out.println("[6] - LISTAR TODOS OS CLIENTES");
			System.out.println("[7] - LISTAR TODOS OS CARROS");
			System.out.println("[8] - ENCERRAR PROGRAMA");
			System.out.println("___________________________________________________________\n");
			System.out.println("Digite uma opção: ");
			op = sc.nextInt();
			
			switch(op) {
				case 1: loja.addCarro();
				break;
				case 2: loja.addCliente();
				break;
				case 3: System.err.println("Falta implementar!");
				break;
				case 4: System.err.println("Falta implementar!");
				break;
				case 5: System.err.println("Falta implementar!");
				break;
				case 6: System.err.println("Falta implementar!");
				break;
				case 7: System.err.println("Falta implementar!");
				break;
				case 8: System.out.println("Programa finalizado com exito."); loop = false; 
				break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
		sc.close();
	}
}