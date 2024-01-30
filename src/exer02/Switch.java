package exer02;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int dia;
		String reposta;
		System.out.println("Informe o dia da semana de 1 a 7");
		dia = scan.nextInt();
		
		switch(dia) {
			case 1:
				reposta = "Segunda-Feira";
				break;
			case 2:
				reposta = "Terça-Feira";
				break;
			case 3:
				reposta = "Quarta-Feira";
				break;
			case 4:
				reposta = "Quinta-Feira";
				break;
			case 5:
				reposta = "Sexta-Feira";
				break;
			case 6:
				reposta = "Sabado";
				break;
			case 7:
				reposta = "Domingo";
				break;
			default: reposta = "O dia informado [" + dia + "] não foi reconhecido, entre com um numero de 1 a 7.";
		}
		System.out.println("//###############// " + reposta + " //###############//");

	}

}
