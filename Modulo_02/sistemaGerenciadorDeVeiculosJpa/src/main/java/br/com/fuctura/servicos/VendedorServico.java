package br.com.fuctura.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.VendedorDAO;
import br.com.fuctura.entidade.Vendedor;
import br.com.fuctura.entitymanager.Entity;


public class VendedorServico {
	public Vendedor cadastrar() {
		Scanner sc = new Scanner(System.in);
		Vendedor v = new Vendedor();
		
		System.out.print("NOME: ");
		v.setNome( sc.nextLine() );
		
		System.out.print("TELEFONE: ");
		v.setTelefone( sc.nextLine() );
		
		System.out.print("CPF: ");
		v.setCpf( sc.nextLine() );

		if( consultarCPF(v.getCpf()).getCpf() == null ) {
			new VendedorDAO().adicionarAlterar(v, Entity.getManager());	
			System.out.println("Cadastro realizado com exito!");
		}else {
			System.err.println("CPF já cadastrado!");
		}
		
		return v;
	}
	
	public void consultarNomeCPF() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Iinforme o NOME ou CPF para localizar um VENDEDOR.");
		String nomeCPF = sc.nextLine();
		
		List<Vendedor> vendedorLocalizados = new VendedorDAO().consultar(nomeCPF, Entity.getManager());
				
		if(!vendedorLocalizados.isEmpty()) {
			for(Vendedor item : vendedorLocalizados) {
				System.out.println("-------------- VENDEDOR LOCALIZADO --------------");
				System.out.println( item.getNome() + " | " + item.getTelefone() + " | " + item.getCpf() );
			}
		}

	}
	
	public Vendedor consultarCPF( String cpf) {
		Vendedor VendedorLocalizado = new VendedorDAO().consultarCPF(cpf, Entity.getManager());
		if(VendedorLocalizado.getCpf() != null) {
			System.out.println("-------------- VENDEDOR LOCALIZADO --------------");
			System.out.println( VendedorLocalizado.getNome() + " | " + VendedorLocalizado.getTelefone() + " | " + VendedorLocalizado.getCpf() );
		}
		return VendedorLocalizado;
	}

	public void atualizar() {
		Scanner sc = new Scanner(System.in);
		String op;
				
		System.out.println("Iinforme o CPF do VENDEDOR para alterar os dados: ");
		String cpfVendedor = sc.nextLine();
		
		Vendedor vendedorLocalizado = new VendedorDAO().consultarCPF(cpfVendedor, Entity.getManager());
		
		if(vendedorLocalizado.getCpf() != null ) {
			System.out.print("ALTERAR NOME [S/N]?");
			op = sc.nextLine();
			if(op.equalsIgnoreCase("s")) {
				String novaInformacao = sc.nextLine();
				vendedorLocalizado.setNome( novaInformacao );
			}
			
			System.out.print("ALTERAR TELEFONE [S/N]? ");
			op = sc.nextLine();
			if(op.equalsIgnoreCase("s")) {
				String novaInformacao = sc.nextLine();
				vendedorLocalizado.setTelefone( novaInformacao );
			}
			
			System.out.print("ALTERAR CPF [S/N]?");
			op = sc.nextLine();
			if(op.equalsIgnoreCase("s")) {
				String novaInformacao = sc.nextLine();
				vendedorLocalizado.setCpf(novaInformacao);
			}
			
			new VendedorDAO().adicionarAlterar(vendedorLocalizado, Entity.getManager());
		}else {
			System.err.println("O CPF não foi localizado");
		}
	}

	public void remover() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Iinforme o CPF do VENDEDOR para remover.");
		String cpfVendedor = sc.nextLine();
		
		List<Vendedor> listaVendedores = new VendedorDAO().consultar(cpfVendedor, Entity.getManager());

		for(int i=0; i < listaVendedores.size(); i++) {
			if (listaVendedores.get(i).getCpf().equalsIgnoreCase(cpfVendedor)) {
				new VendedorDAO().remover(listaVendedores.get(i), Entity.getManager());
				System.out.println("Vendedor removido com exito");
			}
		}

	}
		
}
