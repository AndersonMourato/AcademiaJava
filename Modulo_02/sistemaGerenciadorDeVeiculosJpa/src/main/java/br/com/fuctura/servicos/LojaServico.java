package br.com.fuctura.servicos;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.LojaDAO;
import br.com.fuctura.entidade.Loja;
import br.com.fuctura.entitymanager.Entity;

public class LojaServico {
	public void cadastrar() {
		Scanner sc = new Scanner(System.in);
		Loja lj = new Loja();

		System.out.print("NOME: ");
		lj.setNome(sc.nextLine());

		System.out.print("TELEFONE: ");
		lj.setTelefone(sc.nextLine());

		System.out.print("ENDEREÇO: ");
		lj.setEndereco(sc.nextLine());

		new LojaDAO().adicionarAlterar(lj, Entity.getManager());
	}

	public void listarTodos() {
		List<Loja> lista = new LojaDAO().consultarTodos(Entity.getManager());

		if (!lista.isEmpty()) {
			System.out.println("-------------- IMPRIMINDO A LISTA DE LOJAS --------------");
			for (Loja item : lista) {
				System.out.println(item.getCondigo() + " | " + item.getNome() + " | " + item.getTelefone() + " | " + item.getEndereco());
				System.out.println("------------------------------------------------------");
			}
		} else {
			System.err.println("A LISTA ESTA VAZIA!");
		}
		System.out.println("-----• Totalde itens: " + lista.size());
	}

	public void atualizar() {
		Scanner sc = new Scanner(System.in);
		String op;

		System.out.println("Iinforme o NOME da LOJA ou o TELEFONE para alterar os dados: ");
		String nomeTelefone = sc.nextLine();

		List<Loja> listaLoja = new LojaDAO().consultar(nomeTelefone, Entity.getManager());

		if (!listaLoja.isEmpty()) {
			System.out.println("-------------- LOJAS LOCALIZADAS --------------");
			for (Loja item : listaLoja) {
				System.out.println(item.getCondigo() + " | " + item.getNome() + " | " + item.getTelefone() + " | " + item.getEndereco());
				System.out.println("------------------------------------------------------");
			}
			System.out.println("-----• Totalde itens: " + listaLoja.size());

			System.out.println("Digite o ID da loja para alterar: ");
			int codigo = sc.nextInt();
			sc.nextLine();

			for (int i = 0; i < listaLoja.size(); i++) {
				if (listaLoja.get(i).getCondigo() == codigo) {
					System.out.print("ALTERAR NOME [S/N]?");
					op = sc.nextLine();
					if (op.equalsIgnoreCase("s")) {
						String novaInformacao = sc.nextLine();
						listaLoja.get(i).setNome(novaInformacao);
					}

					System.out.print("ALTERAR TELEFONE [S/N]? ");
					op = sc.nextLine();
					if (op.equalsIgnoreCase("s")) {
						String novaInformacao = sc.nextLine();
						listaLoja.get(i).setTelefone(novaInformacao);
					}

					System.out.print("ALTERAR ENDEREÇO [S/N]?");
					op = sc.nextLine();
					if (op.equalsIgnoreCase("s")) {
						String novaInformacao = sc.nextLine();
						listaLoja.get(i).setEndereco(novaInformacao);
					}
					
					Loja lojaAtualizada = listaLoja.get(i);
					new LojaDAO().adicionarAlterar(lojaAtualizada, Entity.getManager());
				} else {
					System.err.println("ID invelido!");
				}
			}
		} else {
			System.err.println("Não foi possivel localizar a LOJA de NOME/TELEFONE = " + nomeTelefone);
		}
	}

	public void consultarNomeTelefone() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Iinforme a NOME ou TELEFONE para localizar uma LOJA.");
		String nomeTelefone = sc.nextLine();

		List<Loja> listaLoja = new LojaDAO().consultar(nomeTelefone, Entity.getManager());

		if (!listaLoja.isEmpty()) {
			System.out.println("-------------- LOJAS LOCALIZADAS --------------");
			for (Loja item : listaLoja) {
				System.out.println(item.getCondigo() + " | " + item.getNome() + " | " + item.getTelefone() + " | " + item.getEndereco());
				System.out.println("------------------------------------------------------");
			}
			System.out.println("-----• Totalde itens: " + listaLoja.size());
		} else {
			System.err.println("Não foi possivel localizar a LOJA de NOME/TELEFONE = " + nomeTelefone);
		}

	}

	public void remover() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Iinforme o NOME da LOJA ou o TELEFONE para remover: ");
		String nomeTelefone = sc.nextLine();

		List<Loja> listaLojas = new LojaDAO().consultar(nomeTelefone, Entity.getManager());

		if (!listaLojas.isEmpty()) {
			System.out.println("-------------- LOJAS LOCALIZADAS --------------");
			for (Loja item : listaLojas) {
				System.out.println(item.getCondigo() + " | " + item.getNome() + " | " + item.getTelefone() + " | " + item.getEndereco());
				System.out.println("------------------------------------------------------");
			}

			System.out.println("Digite o ID da loja para remover: ");
			int codigo = sc.nextInt();
			sc.nextLine();
			
			for (int i = 0; i < listaLojas.size(); i++) {
				if (listaLojas.get(i).getCondigo() == codigo) {
					new LojaDAO().remover(listaLojas.get(i), Entity.getManager());
					System.out.println("Item removido com exito");
				}
			}
		}

	}

}
