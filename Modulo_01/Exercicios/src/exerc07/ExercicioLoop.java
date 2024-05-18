package exerc07;

import java.util.Scanner;

public class ExercicioLoop {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int cont = 1;
		while (cont <= 2) {
			System.out.println("Digite seu nome: ");
			String nome = scan.next();
			System.out.println("Digite sua idade: ");
			int idade = scan.nextInt();
			
			cont++;
		}

	}

}
