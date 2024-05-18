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
	private Menu menu = new Menu();

	public void init() throws SQLException {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("VEICULOS");
		opcoes.add("BUSCAR VEICULO POR PLACA OU MODELO");
		opcoes.add("LISTAR TODOS OS VEICULOS");
		opcoes.add("RETORNAR O MENU ANTERIOR");
		menu.setOpcoes(opcoes);

		boolean loop = true;
		while (loop) {
			int op;
			op = menu.getMenu();
			switch (op) {
				case 0:
					getModeloPlaca();
					break;
				case 1:
					getAll();
					break;
				case 2:	loop = false;
					break;
				default:
					System.err.println("A opção informada é Invalida!");
			}
		}
	}

	public void initGerenciar() throws SQLException {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("GERENCIAR VEICULOS");
		opcoes.add("CADASTRAR VEICULO");
		opcoes.add("ALTERAR VEICULO");
		opcoes.add("REMOVER VEICULO");
		opcoes.add("RETORNAR O MENU ANTERIOR");
		menu.setOpcoes(opcoes);

		boolean loop = true;
		while (loop) {
			int op;
			op = menu.getMenu();
			switch (op) {
			case 0:
				setVeiculo();
				break;
			case 1:
				updateVeiculo();
				break;
			case 2:
				deleteVeiculo();
				break;
			case 3:
				System.out.println("Programa encerrado..");
				loop = false;
				break;
			default:
				System.err.println("A opção informada é Invalida!");
			}
		}
	}

	public void getAll() throws SQLException {
		List<Veiculo> listVeiculos = new ArrayList<>();

		listVeiculos = veiculoDAO.getAll(conn.getConexao());
		System.out.println("---------------- LISTA DE VEICULOS ----------------");
		for (Veiculo veiculo : listVeiculos) {
			System.out.println(veiculo.getCodigo() + "  |  " + veiculo.getModelo() + "  |  " + veiculo.getPlaca()+ "  |  " + veiculo.getAno() + "  |  R$ " + String.format("%.2f", veiculo.getValor()));
			System.out.println("---------------------------------------------------");
		}
		System.out.println(listVeiculos.size() + " Registros.");
	}

	public void getModeloPlaca() throws SQLException {
		Scanner sc = new Scanner(System.in);
		List<Veiculo> listVeiculos = new ArrayList<>();

		System.out.print("Informe a PLACA ou o MODELO: ");
		String str = "%" + sc.nextLine() + "%";

		listVeiculos = veiculoDAO.getModeloPlaca(conn.getConexao(), str);
		System.out.println("------------------ BUSCA POR " + str + " ------------------");
		for (Veiculo veiculo : listVeiculos) {
			System.out.println(veiculo.getCodigo() + "  |  " + veiculo.getModelo() + "  |  " + veiculo.getPlaca()+ "  |  " + veiculo.getAno() + "  |  R$ " + String.format("%.2f", veiculo.getValor()));
			System.out.println("---------------------------------------------------");
		}
	}

	public void setVeiculo() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Veiculo v = new Veiculo();
		System.out.println("------------ CADASTRO DE VEICULO ------------");
		System.out.println("Gerar informações automaticas? [S]/[N]");

		if (sc.next().equalsIgnoreCase("S")) {
			Faker fk = new Faker();
			v.setPlaca(fk.letterify(fk.numerify("???-###"), true));
			v.setModelo(fk.cat().name());
			v.setAno(Integer.parseInt(fk.numerify("201#")));
			v.setValor(Float.parseFloat(fk.numerify("###.###")));

			System.out.println("-------------------------------------------");
			System.out.println(v.getModelo() + "  |  " + v.getPlaca() + "  |  " + v.getAno() + "  |  R$ "
					+ String.format("%.2f", v.getValor()));
			System.out.println("-------------------------------------------");
			veiculoDAO.insert(conn.getConexao(), v);
		} else {
			System.out.println("Prencha os campos");
			System.out.print("PLACA: ");
			v.setPlaca(sc.next());
			System.out.print("MODELO: ");
			v.setModelo(sc.nextLine());
			System.out.print("ANO: ");
			v.setAno(sc.nextInt());
			sc.nextLine();
			System.out.print("VALOR: ");
			v.setValor(sc.nextFloat());
			veiculoDAO.insert(conn.getConexao(), v);
		}
	}

	public void updateVeiculo() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Veiculo v = new Veiculo();
		int cont = 0;
		
		System.out.println("Informe a PLACA do Veiculo a ser alterado.");
		do {
			v = veiculoDAO.getPlaca(conn.getConexao(), sc.next());
			if (v != null) {
				System.out.println("---------------------------------------------------");
				System.out.println(v.getCodigo() + "  |  " + v.getModelo() + "  |  " + v.getPlaca() + "  |  " + v.getAno() + "  |  R$ " + String.format("%.2f", v.getValor()));
				System.out.println("---------------------------------------------------");
				System.out.println("Digite [s] ou [n] para alterar os campos: \n");
				
				System.out.println("Alterar PLACA? ");
				v.setPlaca(sc.next().equalsIgnoreCase("s") ? sc.next() : v.getPlaca());
				
				System.out.println("Alterar MODELO? ");
				v.setModelo(sc.next().equalsIgnoreCase("s") ? sc.next() : v.getModelo());
				
				System.out.println("Alterar ANO? ");
				v.setAno(sc.next().equalsIgnoreCase("s") ? sc.nextInt() : v.getAno());
				
				System.out.println("Alterar VALOR? ");
				v.setValor(sc.next().equalsIgnoreCase("s") ? sc.nextFloat() : v.getValor());
				
				veiculoDAO.update(conn.getConexao(), v);
			} else {
				cont++;
				System.out.println("Placa não encontrada, tente novamente. *" + cont);
				if (cont == 3) {
					break;
				}
			}
		} while (v == null);
	}

	public void deleteVeiculo() throws SQLException {
		Scanner sc = new Scanner(System.in);
		Veiculo v = new Veiculo();
		int cont = 0;
		
		System.out.println("Informe a PLACA do Veiculo a ser removido.");
		do {
			v = veiculoDAO.getPlaca(conn.getConexao(), sc.next());
			if (v != null) {
				System.out.println("---------------------------------------------------");
				System.out.println(v.getCodigo() + "  |  " + v.getModelo() + "  |  " + v.getPlaca() + "  |  " + v.getAno() + "  |  R$ " + String.format("%.2f", v.getValor()));
				System.out.println("---------------------------------------------------");
				System.out.println("Digite [s] para confirmar. \n");
				
				if(sc.next().equalsIgnoreCase("s")) {
					System.out.println("Excluindo...");
					veiculoDAO.delete(conn.getConexao(), v);
				}
			} else {
				cont++;
				System.out.println("Placa não encontrada, tente novamente. *" + cont);
				if (cont == 3) {
					break;
				}
			}
		} while (v == null);
	}
}
