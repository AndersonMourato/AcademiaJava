package br.com.fuctura.aplicacao;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "321";
		
		if(DriverManager.getConnection(url, user, password) != null) {
			System.out.println("Conectou!");
		}else {
			System.out.println("Falha");
		}
	}

}
