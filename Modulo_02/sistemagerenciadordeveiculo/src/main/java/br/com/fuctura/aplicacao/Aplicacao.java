package br.com.fuctura.aplicacao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fuctura.menu.ControleMenu;
import br.com.fuctura.menu.Home;
import br.com.fuctura.menu.Menu;

public class Aplicacao {

	public static void main(String[] args) throws SQLException{

		Home menu = new Home();
		menu.init();
		
	}

}
