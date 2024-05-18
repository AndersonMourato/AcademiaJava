package sistema.menu.principal;

import java.util.Scanner;

import sistema.menu.frenteloja.FrenteLoja;
import sistema.menu.manutencao.ManutencaoCadastro;

public class MenuPrincipal {
	
	public void init() {
		FrenteLoja frenteLoja = new FrenteLoja();
		ManutencaoCadastro manutencao = new ManutencaoCadastro();
		
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("\n\n################ INTERFACE COM O USUARIO ################");
			System.out.println("[1] - FRENTE DE LOJA");
			System.out.println("[2] - MANUTENÃO DE CADASTRO");
			System.out.println("[3] - SAIR DO SISTEMA");
			
			int opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: frenteLoja.init();
				break;
				
				case 2: manutencao.init();
				break;
				
				case 3: loop = false; System.out.println("Programa Encerrado!");
				break;
				
				default: System.err.println("Opção informada não é válida!");
			}
			
		}
	}
	
}
