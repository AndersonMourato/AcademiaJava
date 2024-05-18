package sistema.menu.frenteloja;

import java.util.Scanner;

import sistema.menu.manutencao.ManutencaoCadastro;
import sistema.servicos.ClienteServico;
import sistema.servicos.Servico;


public class Cliente {
	public void init() {
		FrenteLoja frenteLoja = new FrenteLoja();
		ManutencaoCadastro cadastro = new ManutencaoCadastro();
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("\n\n################ GERENCIAR CLIENTE ################");
			System.out.println("[1] - CONSULTAR CLIENTE POR CPF");
			System.out.println("[2] - VOLTAR PARA O MENU SUPERIOR");
			
			int opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: new ClienteServico().consultarCPF( Servico.input("Informe o CPF do cliente?") );
				break;
				
				case 2: loop = false;
				break;
				
				default: System.err.println("Opção informada não é válida!");
			}
			
		}
	}
}
