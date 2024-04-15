package br.com.fuctura.menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fuctura.conexao.Conexao;
import br.com.fuctura.dao.LojaDAO;
import br.com.fuctura.entidade.Loja;

public class Lojas {
	private Menu menu = new Menu();
	private LojaDAO lojaDAO = new LojaDAO();
	private Conexao conn = new Conexao();
	private Scanner sc = new Scanner(System.in);
	
	public void init() throws SQLException {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("LOJAS");
		opcoes.add("LISTAR LOJAS");
		opcoes.add("RETORNAR O MENU ANTERIOR");
		menu.setOpcoes(opcoes);
		
		boolean loop = true;
		while (loop) {	
			int op;
			op = menu.getMenu();
			switch(op) {
				case 0: listar();
					break;
				case 1: loop = false; 
					break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
	}
	
	public void initGerenciar() throws SQLException {
		List<String> opcoes = new ArrayList<>();
		menu.setNome("GERENCIAR LOJAS");
		opcoes.add("CADASTRAR LOJA");
		opcoes.add("EXCLUIR LOJA");
		opcoes.add("ALTERAR LOJA");
		opcoes.add("RETORNAR O MENU ANTERIOR");
		menu.setOpcoes(opcoes);
		
		boolean loop = true;
		while (loop) {	
			int op;
			op = menu.getMenu();
			switch(op) {
				case 0: cadastra();
					break;
				case 1: excluir();
					break;
				case 2: alterar();
					break;
				case 3: loop = false; 
					break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
	}
	
	public void listar() throws SQLException {
		List<Loja> lojas = lojaDAO.getAll(conn.getConexao());
		
		System.out.println("---------- LISTA DE LOJAS ----------");
		for(Loja loja : lojas) {
			System.out.println(loja.getCodigo() +" | "+ loja.getNome());
			System.out.println("-------------------------------------");
		}
	}
	
	public void cadastra() throws SQLException {
		Loja lj = new Loja();
		System.out.print("NOME DA LOJA: ");
		lj.setNome(sc.nextLine());
		lojaDAO.insert(conn.getConexao(), lj);
	}
	
	public void excluir() throws SQLException {
		System.out.print("INFORME O CODIGO DA LOJA: ");
		Loja lj = lojaDAO.getLojaCod(conn.getConexao(), sc.nextInt());

		if(lj.getNome() != null) {
			lojaDAO.delete(conn.getConexao(), lj);
			System.out.println(lj.getCodigo() +" | "+ lj.getNome());
			System.out.println("--------------- REMOVIDO ---------------");
		}else {
			System.out.println("Codigo informado não é valido.");
		}
	}
	
	public void alterar() throws SQLException {
		System.out.print("INFORME O CODIGO DA LOJA: ");
		Loja lj = lojaDAO.getLojaCod(conn.getConexao(), sc.nextInt());

		if(lj.getNome() != null) {
			System.out.print("NOVO NOME DA LOJA: ");
			lj.setNome(sc.nextLine());
			lojaDAO.update(conn.getConexao(), lj);
		}else {
			System.out.println("Codigo informado não é valido.");
		}
	}

}
