package exer05;

import java.util.Scanner;

public class ExercicioSwicth {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String nome;
		int idade;
		
		System.out.println("Qual seu nome?");
		nome = scan.nextLine();
		System.out.println("Qual sua idade?");
		idade = scan.nextInt();
		
		System.out.println("############## MENU ##############");
		System.out.println("1 - COMPAR");
		System.out.println("2 - OBSERVAR");
		System.out.println("3 - SAIR");
		System.out.println("__________________________________");
		
		System.out.println("Digite o numero de uma das opções do MENU.");
		
		int opcao = scan.nextInt();
		
		switch(opcao){
			case 1: 
				if(idade >= 18) {
					System.out.println("Continue COMPRANDO");
				}else {
					System.out.println("Idade não permitida");
					System.out.println("Nome: " + nome);
					System.out.println("Idade: " + idade);
				}
			break;
			
			case 2: System.out.println("Quero apenas observar");
			break;
			
			case 3: System.out.println("Obrigado pela visita.");
			break;
			
			default: System.err.println("Opção invalida, tente novamente!");
			
		}

	}

}
