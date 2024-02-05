package exer06;

import java.util.Scanner;

public class ExercicioDoWhile {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String nome = "Maria";
		String sos = "salvar";
		String resposta;
		
		System.out.println("Entre com o codigo para ajudar: " + nome);
		resposta = scan.nextLine();
		
		while (!resposta.equals(sos)) {
					
			System.out.println("Socorro, estou me afogando...");
			resposta = scan.nextLine();
			
			if(resposta.equalsIgnoreCase(sos)) {
				System.out.println("Voce me salvou!");
				break;
			}else {
				System.out.println("Continuo me afogando");
			}
		}
			
		System.out.println("OK, o sistema funcionou perfeitamente!");
	}

	
	
	
}
