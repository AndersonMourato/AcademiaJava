package br.com.fuctura.servicos;

import java.util.Scanner;

public class Servico {

	public static String input(String texto) {
		Scanner sc = new Scanner(System.in);
		System.out.println(texto);
		String resposta = sc.nextLine();
		return resposta;
	}

}
