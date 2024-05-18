package sistema.menu.manutencao;

import java.util.Scanner;

import sistema.menu.frenteloja.FrenteLoja;
import sistema.servicos.VendaServico;

public class Venda {
	public void init() {
		FrenteLoja frenteLoja = new FrenteLoja();
		ManutencaoCadastro cadastro = new ManutencaoCadastro();
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("\n\n################ MANUTENÇÃO GERENCIAR VENDA ################");
			System.out.println("[1] - LISTAR VENDAS");
			System.out.println("[2] - EXCLUIR VENDA");
			System.out.println("[3] - ALTERAR DADOS DA VENDA");
			System.out.println("[4] - VOLTAR PARA O MENU SUPERIOR");
			
			int opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: new VendaServico().listarVendas();
				break;
				
				case 2: new VendaServico().remover();
				break;
				
				case 3: new VendaServico().atualizar();
				break;
				
				case 4: loop = false;
				break;
				
				default: System.err.println("Opção informada não é válida!");
			}
			
		}
	}
}
