package exerc08;

import java.util.Scanner;

public class CalcularIMC {

	public static void main(String[] args) {
		Pessoa[] pessoa = new Pessoa[3];

		boolean loop = true;
		int i = 0;
		while(loop) {
			Scanner scan = new Scanner(System.in);
			if(i < pessoa.length) {
				pessoa[i] = new Pessoa();
				System.out.println("############## Cadastrar Nova Pessoa ##############");
				System.out.print("Nome: ");
				pessoa[i].setNome(scan.nextLine());
				System.out.print("Peso: ");
				pessoa[i].setPeso(scan.nextDouble());
				System.out.print("Altura: ");
				pessoa[i].setAltura(scan.nextDouble());
				System.out.println("____________________________________________________");
				System.out.println();

			}else {
				loop = false;
			}
			i++;
		}
		System.out.println();
		System.out.println("##################### RESULTADOS IMC #####################");
		for(int j = 0; j < pessoa.length; j++) {
			if(pessoa[j] != null) {
				System.out.println("NOME: " + pessoa[j].getNome() + " | IMC: " + pessoa[j].getImc());
			}
		}
		
	}
}
