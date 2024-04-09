package br.com.fuctura.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.github.javafaker.Faker;

import br.com.fuctura.conexao.Conexao;
import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.entidade.Veiculo;

public class ControleMenu {
	private Scanner sc = new Scanner(System.in);
	private Conexao conn = new Conexao();
	private VeiculoDAO veiculoDAO = new VeiculoDAO();
	
	//************************** MENUS **************************
	public void menuLoja() throws SQLException {
		int op = 0;
		boolean loop = true;
		
		while (loop) {
			System.out.println("\n\n################ MENU LOJA ################");
			System.out.println("[1] - FRENTE DE LOJA");
			System.out.println("[2] - MANUTENCAO DE CADASTRO");
			System.out.println("[3] - ENCERRAR PROGRAMA");
			System.out.println("________________________________________________\n");
			System.out.println("Digite uma opção: ");
			op = this.sc.nextInt();  this.sc.nextLine();
			
			switch(op) {
				case 1: menuFrenteLoja();
					break;
				case 2: menuManutencaoCadastro();
					break;
				case 3: System.out.println("Programa finalizado com exito."); loop = false; 
					break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
	}	
	private void menuFrenteLoja() throws SQLException {
		int op = 0;
		boolean loop = true;
		
		while (loop) {
			System.out.println("\n\n################ FRENTE DE LOJA ################");
			System.out.println("[1] - VEICULOS");
			System.out.println("[2] - LOJAS");
			System.out.println("[3] - VENDEDORES");
			System.out.println("[4] - CLIENTES");
			System.out.println("[5] - VENDAS");
			System.out.println("[6] - RETORNAR O MENU ANTERIOR");
			System.out.println("___________________________________________________\n");
			System.out.println("Digite uma opção: ");
			op = this.sc.nextInt();  this.sc.nextLine();
			
			switch(op) {
				case 1: subMenuVeiculo();
					break;
				case 2: subMenuLoja();
					break;
				case 3: subMenuVendedor();
					break;
				case 4: subMenuCliente();
					break;
				case 5: subMenuVendas();
					break;
				case 6: loop = false; 
					break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
	}	
	private void menuManutencaoCadastro() throws SQLException {
		int op = 0;
		boolean loop = true;
		
		while (loop) {
			System.out.println("\n\n################ MANUTENCAO DE CADASTRO ################");
			System.out.println("[1] - GERENCIAR VEICULOS");
			System.out.println("[2] - GERENCIAR LOJA");
			System.out.println("[3] - GERENCIAR VENDEDOR");
			System.out.println("[4] - GERENCIAR CLIENTE");
			System.out.println("[5] - GERENCIAR VENDAS");
			System.out.println("[6] - RETORNAR O MENU ANTERIOR");
			System.out.println("___________________________________________________________\n");
			System.out.println("Digite uma opção: ");
			op = this.sc.nextInt();  this.sc.nextLine();
			
			switch(op) {
				case 1: subMenuGerenciarVeiculo();
					break;
				case 2: subMenuGerenciarLoja();
					break;
				case 3: subMenuGerenciarVendedor();
					break;
				case 4: subMenuGerenciarCliente();
					break;
				case 5: subMenuGerenciarVendas();
					break;
				case 6: loop = false; 
					break;
				default: System.err.println("A opção informada é Invalida!");
			}
		} 
	}
		
	//************************** SUB-MENUS **************************
	private void subMenuVeiculo() throws SQLException{
		int op = 0;
		boolean loop = true;
		
		while (loop) {
			System.out.println("\n\n################ VEICULOS ################");
			System.out.println("[1] - BUSCAR VEICULO POR PLACA OU MODELO");
			System.out.println("[2] - LISTAR TODOS OS VEICULOS");
			System.out.println("[3] - RETORNAR O MENU ANTERIOR");
			System.out.println("______________________________________________\n");
			System.out.println("Digite uma opção: ");
			op = this.sc.nextInt();  this.sc.nextLine();
			
			switch(op) {
			case 1: searcheVehicles();
			break;
			case 2: getAllVehicles();
			break;
			case 3: loop = false; 
			break;
			default: System.err.println("A opção informada é Invalida!");
			}
		} 
	}	
	private void subMenuLoja(){System.err.println("Falta Implementar");}
	private void subMenuVendedor(){System.err.println("Falta Implementar");}
	private void subMenuCliente(){System.err.println("Falta Implementar");}
	private void subMenuVendas(){System.err.println("Falta Implementar");}
	
	private void subMenuGerenciarVeiculo() throws SQLException{
		int op = 0;
		boolean loop = true;
		
		while (loop) {
			System.out.println("\n\n################ GERENCIAR VEICULOS ################");
			System.out.println("[1] - CADASTRAR VEICULO");
			System.out.println("[2] - ALTERAR VEICULO");
			System.out.println("[3] - REMOVER VEICULO");
			System.out.println("[4] - RETORNAR O MENU ANTERIOR");
			System.out.println("______________________________________________\n");
			System.out.println("Digite uma opção: ");
			op = this.sc.nextInt();  this.sc.nextLine();
			
			switch(op) {
			case 1: insertVehicle();
			break;
			case 2: updateVehicle();
			break;
			case 3: deleteVehicle();
			break;
			case 4: loop = false; 
			break;
			default: System.err.println("A opção informada é Invalida!");
			}
		} 
	}
	private void subMenuGerenciarLoja(){System.err.println("Falta Implementar");}
	private void subMenuGerenciarVendedor(){System.err.println("Falta Implementar");}
	private void subMenuGerenciarCliente(){System.err.println("Falta Implementar");}
	private void subMenuGerenciarVendas(){System.err.println("Falta Implementar");}
	
	//************************** METODOS / FUNCOES **************************
	private void getAllVehicles() throws SQLException  {
		List<Veiculo> listVeiculos = new ArrayList<>();
		
		listVeiculos = this.veiculoDAO.getAll(conn.getConexao());
		System.out.println("---------------- LISTA DE VEICULOS ----------------");
		for(Veiculo veiculo : listVeiculos) {
			System.out.println(veiculo.getCodigo() +"  |  "+ veiculo.getModelo() +"  |  "+ veiculo.getPlaca() + "  |  "+ veiculo.getAno() +"  |  R$ "+ String.format("%.2f", veiculo.getValor()));
			System.out.println("---------------------------------------------------");
		}
		System.out.println(listVeiculos.size() + " Registros.");
	}
	private void searcheVehicles() throws SQLException {
		List<Veiculo> listVeiculos = new ArrayList<>();

		System.out.print("Informe a PLACA ou o MODELO: ");
		String str = "%"+this.sc.nextLine()+"%";
		
		listVeiculos = this.veiculoDAO.getVehicle(conn.getConexao(), str);
		System.out.println("------------------ BUSCA POR "+str+" ------------------");
		for(Veiculo veiculo : listVeiculos) {
			System.out.println(veiculo.getCodigo() +"  |  "+ veiculo.getModelo() +"  |  "+ veiculo.getPlaca() + "  |  "+ veiculo.getAno() +"  |  R$ "+ String.format("%.2f", veiculo.getValor()));
			System.out.println("---------------------------------------------------");
		}				
	}
	private void insertVehicle() throws SQLException {
		Veiculo v = new Veiculo();
		System.out.println("------------ CADASTRO DE VEICULO ------------");
		System.out.println("Gerar informações automaticas? [S]/[N]");
		
		if(this.sc.next().equalsIgnoreCase("S")) {
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
			v.setPlaca(this.sc.next());
			System.out.print("MODELO: ");
			v.setModelo(this.sc.next());
			System.out.print("ANO: ");
			v.setAno(this.sc.nextInt());
			this.sc.nextLine();
			System.out.print("VALOR: ");
			v.setValor(this.sc.nextFloat());
			this.veiculoDAO.insert(conn.getConexao(), v);
		}
	}
	private void updateVehicle() throws SQLException{
		searcheVehicles();
		System.out.println("Confirme informando o ID do Veiculo a ser alterado.");
		Veiculo v = new Veiculo();
		v = this.veiculoDAO.getVehicleId(conn.getConexao(), this.sc.nextInt());
		
		this.veiculoDAO.update(conn.getConexao(), v);
	}
	private void deleteVehicle() throws SQLException{
		
	}
}
