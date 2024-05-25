package br.com.fuctura.menu.frenteloja;

import java.util.Scanner;

import br.com.fuctura.menu.manutencao.ManutencaoCadastro;
import br.com.fuctura.servicos.VeiculoServico;



public class Veiculo {
	public void init() {
		FrenteLoja frenteLoja = new FrenteLoja();
		ManutencaoCadastro cadastro = new ManutencaoCadastro();
		
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("\n\n################ GERENCIAR VEICULO ################");
			System.out.println("[1] - CONSULTAR VEICULO POR PLACA/MODELO");
			System.out.println("[2] - LISTAR TODOS OS VEICULOS");
			System.out.println("[3] - VOLTAR PARA O MENU SUPERIOR");
			
			int opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: new VeiculoServico().consultarPlacaModelo();
				break;
				
				case 2: new VeiculoServico().listarTodos();
				break;
				
				case 3: loop = false;
				break;
				
				default: System.err.println("Opção informada não é válida!");
			}
			
		}
	}
}
