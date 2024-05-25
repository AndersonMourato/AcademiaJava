package br.com.fuctura.menu.manutencao;

import java.util.Scanner;

import br.com.fuctura.menu.frenteloja.FrenteLoja;
import br.com.fuctura.servicos.ClienteServico;



public class Cliente {
	public void init() {
		FrenteLoja frenteLoja = new FrenteLoja();
		ManutencaoCadastro cadastro = new ManutencaoCadastro();
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("\n\n################ MANUTENÇÃO GERENCIAR CLIENTE ################");
			System.out.println("[1] - CADASTRAR CLIENTE");
			System.out.println("[2] - EXCLUIR CLIENTE");
			System.out.println("[3] - ALTERAR DADOS DO CLIENTE");
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
