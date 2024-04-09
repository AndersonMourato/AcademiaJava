package br.com.fuctura.menu;

import java.util.ArrayList;
import java.util.List;

public class Home {
	private Menu menu = new Menu();
	private FrenteLoja menuFrenteLoja = new FrenteLoja();
	
	public void init() {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("BEM VINDO");
		opcoes.add("FRENTE DE LOJA");
		opcoes.add("MANUTENCAO DE CADASTRO");
		opcoes.add("ENCERRAR PROGRAMA");
		menu.setOpcoes(opcoes);
		
		
		boolean loop = true;
		while (loop) {	
			int op;
			op = menu.getMenu();
			switch(op) {
				case 0: menuFrenteLoja.init();
					break;
				case 1:  System.out.println("***** Chama menu LOJAS ******"); //subMenuLoja();
					break;
				case 2:System.out.println("Programa encerrado.."); loop = false; 
					break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
	}

}
