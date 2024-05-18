package desafio04;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Livraria {
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		Scanner scan2 = new Scanner (System.in);
		List<String> livros = new ArrayList<>();
		List<Integer> estoque = new ArrayList<>();
		List<Double> preco = new ArrayList<>();
		Boolean loop = true;
		int op = 0;
		
		while (loop) {
			System.out.println();
			System.out.println("#################### MENU ####################");
			System.out.println("[1] - ADICIONAR LIVRO");
			System.out.println("[2] - EXIBIR LISTA DE LIVROS");
			System.out.println("[3] - ENCERRAR PROGRAMA");
			System.out.println("______________________________________________");
			System.out.print("Selecione uma opção: ");
			op = scan.nextInt();
			
			switch(op) {
			case 1:
				System.out.print("NOME: ");
				livros.add(scan2.nextLine());
				System.out.print("ESTOQUE: ");
				estoque.add(scan.nextInt());
				System.out.print("PREÇO: ");
				preco.add(scan.nextDouble());
			
			break;
			
			case 2:
				for(int i = 0; i < livros.size(); i++) {
					System.out.println("___________________________________________________________________________________________________________________");
					System.out.println("LIVRO: " + livros.get(i) + "	|	ESTOQUE: " + estoque.get(i) + "	|	PREÇO: " + preco.get(i) + "	|	VALOR TOTAL EM ESTOQUE: " + ( estoque.get(i) * preco.get(i) ));
				}
			break;
			
			case 3:
				System.out.println("Programa finalizado com exito.");
				loop = false;
			}
		}	
	}
}
