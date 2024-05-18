package desafio08;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Loja loja = new Loja();
		loja.aplicarDadosTeste();
		
		int op = 0;
		boolean loop = true;
		
		while (loop) {
			System.out.println("\n\n################ MENU DE OPÇÕES DA LOJA ################");
			System.out.println("[1] - CADASTRAR CARRO");
			System.out.println("[2] - CADASTRAR CLIENTE");
			System.out.println("[3] - PESQUISAR CARRO POR PLACA E ALTERAR");
			System.out.println("[4] - PESQUISAR CLIENTE POR CPF E ALTERAR");
			System.out.println("[5] - REMOVER CARRO POR PLACA");
			System.out.println("[6] - REMOVER CLIENTE POR CPF/TEL");
			System.out.println("[7] - LISTAR TODOS OS CARROS");
			System.out.println("[8] - LISTAR TODOS OS CLIENTES");
			System.out.println("[9] - ENCERRAR PROGRAMA");
			System.out.println("___________________________________________________________\n");
			System.out.println("Digite uma opção: ");
			op = sc.nextInt();
			
			switch(op) {
				case 1: loja.addCarro();
				break;
				case 2: loja.addCliente();
				break;
				case 3: loja.updateCarro();
				break;
				case 4: loja.updateCliente();
				break;
				case 5: loja.dellCarro();
				break;
				case 6: loja.dellCliente();
				break;
				case 7: loja.listaCarros();
				break;
				case 8: loja.listaClientes();
				break;
				case 9: System.out.println("Programa finalizado com exito."); loop = false; 
				break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
		sc.close();
	}
}