package br.com.fuctura.menu.manutencao;

import java.util.Scanner;

import br.com.fuctura.menu.frenteloja.FrenteLoja;
import br.com.fuctura.servicos.VeiculoServico;



public class Veiculo {
	public void init() {
		FrenteLoja frenteLoja = new FrenteLoja();
		ManutencaoCadastro cadastro = new ManutencaoCadastro();
		
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("\n\n################ MANUTENÇÃO GERENCIAR VEICULO ################");
			System.out.println("[1] - CADASTRAR VEICULO");
			System.out.println("[2] - EXCLUIR VEICULO");
			System.out.println("[3] - ALTERAR DADOS DO VEICULO");
			System.out.println("[4] - VOLTAR PARA O MENU SUPERIOR");
			
			int opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: new VeiculoServico().cadastrar();
				break;
				
				case 2: new VeiculoServico().remover();
				break;
				
				case 3: new VeiculoServico().atualizar();
				break;
				
				case 4: loop = false;
				break;
				
				default: System.err.println("Opção informada não é válida!");
			}
			
		}
	}
}
