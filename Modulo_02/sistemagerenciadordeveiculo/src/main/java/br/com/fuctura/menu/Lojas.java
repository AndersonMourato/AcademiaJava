package br.com.fuctura.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Lojas {
private Menu menu = new Menu();
	
	public void init() throws SQLException {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("LOJAS");
		opcoes.add("BUSCAR VEICULO POR PLACA OU MODELO");
		opcoes.add("LISTAR TODOS OS VEICULOS");
		opcoes.add("RETORNAR O MENU ANTERIOR");
		menu.setOpcoes(opcoes);
		
		boolean loop = true;
		while (loop) {	
			int op;
			op = menu.getMenu();
			switch(op) {
				case 0: //insertVehicle();
					break;
				case 1:  //getAllVehicles();
					break;
				case 2: System.out.println("Programa encerrado.."); loop = false; 
					break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
	}
}
