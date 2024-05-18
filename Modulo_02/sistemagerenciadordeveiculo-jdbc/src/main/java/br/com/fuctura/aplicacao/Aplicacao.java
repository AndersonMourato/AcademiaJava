package br.com.fuctura.aplicacao;

import java.sql.SQLException;

import br.com.fuctura.menu.Home;

public class Aplicacao {

	public static void main(String[] args) throws SQLException{

		Home menu = new Home();
		menu.init();
		
	}

}
