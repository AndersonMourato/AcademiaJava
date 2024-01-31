package exer01;

import java.util.Scanner;

public class Scan {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Qual seu nome: ");
		String nome = scan.nextLine();
		
		System.out.println("Olá " + nome);

		
	}
}


