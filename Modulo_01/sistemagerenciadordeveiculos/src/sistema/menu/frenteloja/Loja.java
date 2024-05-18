package sistema.menu.frenteloja;

import java.util.Scanner;

import sistema.menu.manutencao.ManutencaoCadastro;
import sistema.servicos.LojaServico;


public class Loja {
	public void init() {
		FrenteLoja frenteLoja = new FrenteLoja();
		ManutencaoCadastro cadastro = new ManutencaoCadastro();
		
		
		Scanner sc = new Scanner(System.in);
		boolean loop = true;
		
		while(loop) {
			System.out.println("\n\n################ GERENCIAR LOJA ################");
			System.out.println("[1] - LISTAR TODAS AS LOJAS");
			System.out.println("[2] - CONSULTAR LIJA POR NOME/TELEFONE");
			System.out.println("[3] - VOLTAR PARA O MENU SUPERIOR");
			
			int opcao = sc.nextInt();
			
			switch(opcao) {
				case 1: new LojaServico().listarTodos();
				break;
				
				case 2: new LojaServico().consultarNomeTelefone();
				break;
				
				case 3: loop = false;
				break;
				
				default: System.err.println("Opção informada não é válida!");
			}
			
		}
	}
}
