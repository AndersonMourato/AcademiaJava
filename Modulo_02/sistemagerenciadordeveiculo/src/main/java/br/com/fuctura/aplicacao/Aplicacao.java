package br.com.fuctura.aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.entidade.Veiculo;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
				
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "321";
		Connection conn = DriverManager.getConnection(url, user, password);
		
		Veiculo v = new Veiculo();
		System.out.println("Prencha os campos");
		System.out.print("PLACA: ");
		v.setPlaca(sc.next());
		System.out.print("MODELO: ");
		v.setModelo(sc.next());
		System.out.print("ANO: ");
		v.setAno(sc.nextInt());
		System.out.print("VALOR: ");
		v.setValor(sc.nextFloat());
		
		VeiculoDAO dao = new VeiculoDAO();
		dao.insert(conn, v);
		
		
	}

}
