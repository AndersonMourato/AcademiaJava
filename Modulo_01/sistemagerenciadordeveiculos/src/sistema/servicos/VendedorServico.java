package sistema.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sistema.crud.ClienteCRUD;
import sistema.crud.LojaCRUD;
import sistema.crud.VendedorCRUD;
import sistema.interfaces.Cliente;
import sistema.interfaces.Loja;
import sistema.interfaces.Vendedor;

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
			new VendedorCRUD().adicionar(v);	
			System.out.println("Cadastro realizado com exito!");
		}else {
			System.err.println("CPF já cadastrado!");
		}
		
		return v;
	}
	
	public void consultarNome() {
		List<Vendedor> listaVendedor = new VendedorCRUD().consultar();
		List<Vendedor> vendedorLocalizados = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Iinforme o NOME para localizar um VENDEDOR.");
		String nomeVendedor = sc.next();
		
		for(int i=0; i < listaVendedor.size(); i++) {
			if(listaVendedor.get(i).getNome().contains(nomeVendedor)) {
				vendedorLocalizados.add(listaVendedor.get(i));
			}
		} 
		
		if(!vendedorLocalizados.isEmpty()) {
			for(Vendedor item : vendedorLocalizados) {
				System.out.println("-------------- VENDEDOR LOCALIZADO --------------");
				System.out.println( item.getNome() + " | " + item.getTelefone() + " | " + item.getCpf() );
			}
		}

	}
	
	public Vendedor consultarCPF( String cpf) {
		List<Vendedor> listaVendedores = new VendedorCRUD().consultar();
		Vendedor VendedorLocalizado = new Vendedor();
		
		for(int i=0; i < listaVendedores.size(); i++) {
			if(listaVendedores.get(i).getCpf().equalsIgnoreCase(cpf)) {
				VendedorLocalizado = listaVendedores.get(i);
			}
		} 
		
		if(VendedorLocalizado.getCpf() != null) {
			System.out.println("-------------- VENDEDOR LOCALIZADO --------------");
			System.out.println( VendedorLocalizado.getNome() + " | " + VendedorLocalizado.getTelefone() + " | " + VendedorLocalizado.getCpf() );
		}

		return VendedorLocalizado;
	}

	public void atualizar() {
		List<Vendedor> listaVendedores = new VendedorCRUD().consultar();
		Scanner sc = new Scanner(System.in);
		String op;
				
		System.out.println("Iinforme o CPF do VENDEDOR para alterar os dados: ");
		String cpfVendedor = sc.nextLine();
		
		for(int i=0; i < listaVendedores.size(); i++) {
			if(listaVendedores.get(i).getCpf().equalsIgnoreCase(cpfVendedor)) {
				int idVendedor = i;
				
				System.out.print("ALTERAR NOME [S/N]?");
				op = sc.nextLine();
				if(op.equalsIgnoreCase("s")) {
					String novaInformacao = sc.nextLine();
					listaVendedores.get(i).setNome( novaInformacao );
				}
				
				System.out.print("ALTERAR TELEFONE [S/N]? ");
				op = sc.nextLine();
				if(op.equalsIgnoreCase("s")) {
					String novaInformacao = sc.nextLine();
					listaVendedores.get(i).setTelefone( novaInformacao );
				}
				
				System.out.print("ALTERAR CPF [S/N]?");
				op = sc.nextLine();
				if(op.equalsIgnoreCase("s")) {
					String novaInformacao = sc.nextLine();
					listaVendedores.get(i).setCpf(novaInformacao);
				}
				
				Vendedor clienteAtualizado = listaVendedores.get(i);
				
				new VendedorCRUD().alterar(idVendedor, clienteAtualizado);
			}
		}
	}

	public void remover() {
		List<Vendedor> listaVendedores = new VendedorCRUD().consultar();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Iinforme o CPF do VENDEDOR para remover.");
		String cpfVendedor = sc.nextLine();

			for(int i=0; i < listaVendedores.size(); i++) {
				if (listaVendedores.get(i).getCpf().equalsIgnoreCase(cpfVendedor)) {
					new VendedorCRUD().remover(i);
					System.out.println("Vendedor removido com exito");
				}
			}

	}
		
}
