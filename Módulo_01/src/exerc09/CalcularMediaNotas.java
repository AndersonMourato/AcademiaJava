package exerc09;

import java.util.Scanner;

public class CalcularMediaNotas {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Informe a quantidade de Aluno: ");
		int qtd = scan.nextInt();
		double[] notas = new double[qtd];
		
		double soma =0;
		System.out.println("Informe as notas:");
		for(int i=0; i < notas.length; i++) {
			System.out.print("Nota " + i + ": ");
			notas[i] = scan.nextDouble();
			soma += notas[i];
		}
		
		System.out.println("############## MEDIA GERAL É: " + (soma/qtd) + " ##############");
	}

}
