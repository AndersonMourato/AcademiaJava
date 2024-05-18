package sistema.menu.manutencao;

import java.util.Scanner;

import sistema.menu.frenteloja.FrenteLoja;
import sistema.servicos.ClienteServico;

public class Loja {
	public void init() {
		FrenteLoja frenteLoja = new FrenteLoja();
		ManutencaoCadastro cadastro = new ManutencaoCadastro();
		
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("\n\n################ MANUTENÇÃO GERENCIAR LOJA ################");
			System.out.println("[1] - CADASTRAR LOJA");
			System.out.println("[2] - EXCLUIR LOJA");
			System.out.println("[3] - ALTERAR DADOS DA LOJA");
			System.out.println("[4] - VOLTAR PARA O MENU SUPERIOR");
			
			int opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: new ClienteServico().cadastrar();
				break;
				
				case 2: new ClienteServico().remover();
				break;
				
				case 3: new ClienteServico().atualizar();
				break;
				
				case 4: loop = false;
				break;
				
				default: System.err.println("Opção informada não é válida!");
			}
			
		}
	}
}
