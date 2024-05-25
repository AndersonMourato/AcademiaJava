package br.com.fuctura.menu.frenteloja;

import java.util.Scanner;

import br.com.fuctura.menu.manutencao.ManutencaoCadastro;
import br.com.fuctura.servicos.VendaServico;



public class Venda {
	public void init() {
		FrenteLoja frenteLoja = new FrenteLoja();
		ManutencaoCadastro cadastro = new ManutencaoCadastro();
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("\n\n################ GERENCIAR VENDA ################");
			System.out.println("[1] - CADASTRAR VENDA");
			System.out.println("[2] - VOLTAR PARA O MENU SUPERIOR");
			
			int opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: new VendaServico().novaVenda();
				break;
				
				case 2: loop = false;
				break;
				
				default: System.err.println("Opção informada não é válida!");
			}
			
		}
	}
}
