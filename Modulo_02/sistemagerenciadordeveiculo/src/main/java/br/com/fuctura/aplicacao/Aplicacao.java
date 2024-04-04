package br.com.fuctura.aplicacao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.github.javafaker.Faker;

import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.entidade.Veiculo;

public class Aplicacao {

	public static void main(String[] args) throws SQLException {
		Scanner sc = new Scanner(System.in);
				
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String password = "321";
		Connection conn = DriverManager.getConnection(url, user, password);
		/*
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
		 */
		
		Veiculo v = new Veiculo();
		Faker fk = new Faker();
		v.setPlaca( fk.letterify(fk.numerify( "???-###" ), true) );
		v.setModelo( fk.cat().name() );
		v.setAno( Integer.parseInt(fk.numerify("201#")) );
		v.setValor( Float.parseFloat(fk.numerify("###.###")) );
		v.setCodigo(1);
		
		VeiculoDAO dao = new VeiculoDAO();
		//dao.insert(conn, v);
		//dao.update(conn, v);
		//dao.delete(conn, v);
		dao.getVehicle(conn, "%A%");
		//dao.getAll(conn);

		
		
	}

}
