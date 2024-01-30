package exer01;

import java.util.Scanner;

public class MediaAluno {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String aluno;
		double nota1;
		double nota2;
		
		System.out.println("Qual seu NOME: ");
		aluno = scan.nextLine();
		System.out.println("Digite a NOTA 1: ");
		nota1 = scan.nextDouble();
		System.out.println("Digite a NOTA 2: ");
		nota2 = scan.nextDouble();
		
		double media = (nota1 + nota2) / 2;
		
		System.out.println("Sua média é: " + media);
		
		if(media >= 7 && media <= 10) {
			System.out.println("Parabéns, você foi APROVADO!");
		} else if(media >= 3 && media <= 6.9) {
			System.out.println("Ops, você ficou em RECUPERAÇÃO!");
		} else if(media < 3) {
			System.out.println("Você foi REPROVADO!");
		}
	}

}
