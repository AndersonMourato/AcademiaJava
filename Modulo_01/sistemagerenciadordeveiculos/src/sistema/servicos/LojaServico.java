package sistema.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sistema.crud.LojaCRUD;
import sistema.interfaces.Loja;

public class LojaServico {
	public void cadastrar() {
		Scanner sc = new Scanner(System.in);
		Loja lj = new Loja();
		
		System.out.print("NOME: ");
		lj.setNome( sc.nextLine() );
		
		System.out.print("TELEFONE: ");
		lj.setTelefone( sc.nextLine() );
		
		System.out.print("ENDEREÇO: ");
		lj.setEndereco( sc.nextLine() );

		new LojaCRUD().adicionar(lj);	
	}
	
	public void listarTodos() {
		List<Loja> lista = new ArrayList<>();
		lista = new LojaCRUD().consultar();
		
		if(!lista.isEmpty()) {
			System.out.println("-------------- IMPRIMINDO A LISTA DE LOJAS --------------");
			for(Loja item : lista) {
				System.out.println( item.getNome() + " | " + item.getTelefone() + " | " + item.getEndereco() );
			}			
		}else {
			System.err.println("A LISTA ESTA VAZIA!");
		}
		System.out.println("-----• Totalde itens: " + lista.size());
		
	}

	public void atualizar() {
		List<Loja> listaLoja = new LojaCRUD().consultar();
		Scanner sc = new Scanner(System.in);
		String op;
				
		System.out.println("Iinforme o NOME da LOJA para alterar os dados: ");
		String nomeLoja = sc.nextLine();
		
		for(int i=0; i < listaLoja.size(); i++) {
			if(listaLoja.get(i).getNome().equalsIgnoreCase(nomeLoja)) {
				int idLoja = i;
				
				System.out.print("ALTERAR NOME [S/N]?");
				op = sc.nextLine();
				if(op.equalsIgnoreCase("s")) {
					String novaInformacao = sc.nextLine();
					listaLoja.get(i).setNome( novaInformacao );
				}
				
				System.out.print("ALTERAR TELEFONE [S/N]? ");
				op = sc.nextLine();
				if(op.equalsIgnoreCase("s")) {
					String novaInformacao = sc.nextLine();
					listaLoja.get(i).setTelefone( novaInformacao );
				}
				
				System.out.print("ALTERAR ENDEREÇO [S/N]?");
				op = sc.nextLine();
				if(op.equalsIgnoreCase("s")) {
					String novaInformacao = sc.nextLine();
					listaLoja.get(i).setEndereco( novaInformacao );
				}
				
				Loja lojaAtualizada = listaLoja.get(i);
				
				new LojaCRUD().alterar(idLoja, lojaAtualizada);
			}
		}
	}
			
	public void consultarNomeTelefone() {
		List<Loja> listaLoja = new LojaCRUD().consultar();
		List<Loja> lojasLocalizadas = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Iinforme a NOME ou TELEFONE para localizar uma LOJA.");
		String nomeTelefone = sc.next();
		
		for(int i=0; i < listaLoja.size(); i++) {
			if(listaLoja.get(i).getNome().equalsIgnoreCase(nomeTelefone) || listaLoja.get(i).getTelefone().equalsIgnoreCase(nomeTelefone)) {
				lojasLocalizadas.add(listaLoja.get(i));
			}
		}
		
		if(!lojasLocalizadas.isEmpty()) {
			for(Loja item : lojasLocalizadas) {
				System.out.println("-------------- LOJAS LOCALIZADAS --------------");
				System.out.println( item.getNome() + " | " + item.getTelefone() + " | " + item.getEndereco() );
			}
			
		}else {
			System.err.println("Não foi possivel localizar a LOJA de NOIME/TELEFONE = " + nomeTelefone);			
		}

	}
	
	public void remover() {
		List<Loja> listaLojas = new LojaCRUD().consultar();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Iinforme o NOME da LOJA para remover.");
		String nomeLoja = sc.nextLine();
		
		for(int i=0; i < listaLojas.size(); i++) {
			if(listaLojas.get(i).getNome().equalsIgnoreCase(nomeLoja)) {
				new LojaCRUD().remover(i);
				System.out.println("Item removido com exito");
			}
		}
	}
		
}
