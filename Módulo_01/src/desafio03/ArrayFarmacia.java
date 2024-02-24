package desafio03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayFarmacia {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		Scanner scan2 = new Scanner (System.in);
		List<String> medicamentos = new ArrayList<>();
		List<Integer> estoque = new ArrayList<>();
		Boolean op = true;
		int resposta = 0;
		
		while (op) {
			System.out.println();
			System.out.println("#################### MENU ####################");
			System.out.println("[1] - ADICIONAR MEDICAMENTO");
			System.out.println("[2] - EXIBIR LISTA DE MEDICAMENTOS COM ESTOQUE");
			System.out.println("[3] - BUSCAR POR NOME");
			System.out.println("[4] - ENCERRAR PROGRAMA");
			System.out.println("______________________________________________");
			System.out.print("Selecione uma opção: ");
			resposta = scan.nextInt();
			
			if(resposta == 1) {
				System.out.println("INFORME O NOME DO MEDICAMENTO: ");
				medicamentos.add(medicamentos.size(), scan2.nextLine());
				System.out.print("INFORME A QUANTIDADE DE ESTOQUE: ");
				estoque.add(estoque.size(), scan.nextInt());
				
			}else if(resposta == 2) {
				for(int i=0; i< medicamentos.size(); i++) {
					System.out.println("__________________________________________");
					System.out.println("NOME: " + medicamentos.get(i));
					System.out.println("ESTOQUE: " + estoque.get(i));
				}				
			}else if(resposta == 3){
				System.out.println("Digite o nome para pesquisar: ");
				String seach = scan2.nextLine();
				if(seach != "") {
					for(int i=0; i < medicamentos.size(); i++) {
						if(medicamentos.get(i).contentEquals(seach)) {
							System.out.println("MEDICAMENTO: " + medicamentos.get(i));
							System.out.println("ESTOQUE: " + estoque.get(i));
						}
					}
				}else {
					System.err.println("Invalido");
				}
			}else if(resposta == 4) {
				System.out.println("Programa finalizado com exito!");
				op = false;
			}else {
				System.out.println("Opção invalida, tente novamente");
			}
		}
			
	}

}
