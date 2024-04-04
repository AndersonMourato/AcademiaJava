package br.com.fuctura.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexcao {
	private String url;
	private String user;
	private String password;
	
	public Conexcao() {
		this.url = "jdbc:postgresql://localhost:5432/postgres";
		this.user = "postgres";
		this.password = "321";
		//return DriverManager.getConnection(this.url, this.user, this.password);
	}
	
	public Connection conect() throws SQLException {
		return DriverManager.getConnection(this.url, this.user, this.password);
	}
}
