package br.com.fuctura.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private static Connection conn;
	
	public Connection getConexao() throws SQLException {
		if(conn == null) {
			String url = "jdbc:postgresql://localhost:5432/postgres";
			String user = "postgres";
			String password = "321";
			conn =  DriverManager.getConnection(url, user, password);
		}
		return conn;
	}
}
