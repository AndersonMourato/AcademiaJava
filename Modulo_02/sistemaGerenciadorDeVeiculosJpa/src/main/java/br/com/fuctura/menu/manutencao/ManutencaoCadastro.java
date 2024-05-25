package br.com.fuctura.menu.manutencao;

import java.util.Scanner;

public class ManutencaoCadastro {
	public void init() {
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("\n\n################ MANUTENÇÃO DE CADASTRO ################");
			System.out.println("[1] - GERENCIAR VEICULO");
			System.out.println("[2] - GERENCIAR LOJA");
			System.out.println("[3] - GERENCIAR VENDEDOR");
			System.out.println("[4] - GERENCIAR CLIENTE");
			System.out.println("[5] - GERENCIAR VENDA");
			System.out.println("[6] - VOLTAR PARA O MENU SUPERIOR");
			
			int opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: new Veiculo().init();;
				break;
				
				case 2: new Loja().init();
				break;
				
				case 3: new Vendedor().init();
				break;
				
				case 4: new Cliente().init();
				break;
				
				case 5: new Venda().init();
				break;
				
				case 6: loop = false;
				break;
				
				default: System.err.println("Opção informada não é válida!");
			}
			
		}
	}
}
