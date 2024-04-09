package br.com.fuctura.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.github.javafaker.Faker;

import br.com.fuctura.conexao.Conexao;
import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.entidade.Veiculo;

public class Veiculos {
	private Conexao conn = new Conexao();
	private VeiculoDAO veiculoDAO = new VeiculoDAO();

	public void getAllVehicles() throws SQLException  {
		List<Veiculo> listVeiculos = new ArrayList<>();
		
		listVeiculos = veiculoDAO.getAll(conn.getConexao());
		System.out.println("---------------- LISTA DE VEICULOS ----------------");
		for(Veiculo veiculo : listVeiculos) {
			System.out.println(veiculo.getCodigo() +"  |  "+ veiculo.getModelo() +"  |  "+ veiculo.getPlaca() + "  |  "+ veiculo.getAno() +"  |  R$ "+ String.format("%.2f", veiculo.getValor()));
			System.out.println("---------------------------------------------------");
		}
		System.out.println(listVeiculos.size() + " Registros.");
	}
	
	public void searcheVehicles() throws SQLException {
		Scanner sc = new Scanner(System.in);
		List<Veiculo> listVeiculos = new ArrayList<>();

		System.out.print("Informe a PLACA ou o MODELO: ");
		String str = "%"+ sc.nextLine() +"%";
		
		listVeiculos = this.veiculoDAO.getVehicle(conn.getConexao(), str);
		System.out.println("------------------ BUSCA POR "+str+" ------------------");
		for(Veiculo veiculo : listVeiculos) {
			System.out.println(veiculo.getCodigo() +"  |  "+ veiculo.getModelo() +"  |  "+ veiculo.getPlaca() + "  |  "+ veiculo.getAno() +"  |  R$ "+ String.format("%.2f", veiculo.getValor()));
			System.out.println("---------------------------------------------------");
		}				
	}
	public void insertVehicle() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Veiculo v = new Veiculo();
		System.out.println("------------ CADASTRO DE VEICULO ------------");
		System.out.println("Gerar informações automaticas? [S]/[N]");
		
		if(sc.next().equalsIgnoreCase("S")) {
			Faker fk = new Faker();
			v.setPlaca( fk.letterify(fk.numerify( "???-###" ), true) );
			v.setModelo( fk.cat().name() );
			v.setAno( Integer.parseInt(fk.numerify("201#")) );
			v.setValor( Float.parseFloat(fk.numerify("###.###")) );
			
			System.out.println("-------------------------------------------");
			System.out.println(v.getModelo() +"  |  " + v.getPlaca() +"  |  " + v.getAno() +"  |  R$ "+ String.format("%.2f", v.getValor()));
			System.out.println("-------------------------------------------");	
			this.veiculoDAO.insert(conn.getConexao(), v);
		}else {
			System.out.println("Prencha os campos");
			System.out.print("PLACA: ");
			v.setPlaca(sc.next());
			System.out.print("MODELO: ");
			v.setModelo(sc.next());
			System.out.print("ANO: ");
			v.setAno(sc.nextInt());
			sc.nextLine();
			System.out.print("VALOR: ");
			v.setValor(sc.nextFloat());
			this.veiculoDAO.insert(conn.getConexao(), v);
		}
	}
	public void updateVehicle() throws SQLException{
		Scanner sc = new Scanner(System.in);
		searcheVehicles();
		System.out.println("Confirme informando o ID do Veiculo a ser alterado.");
		Veiculo v = new Veiculo();
		v = this.veiculoDAO.getVehicleId(conn.getConexao(), sc.nextInt());
		
		this.veiculoDAO.update(conn.getConexao(), v);
	}
	public void deleteVehicle() throws SQLException{
		
	}
}
