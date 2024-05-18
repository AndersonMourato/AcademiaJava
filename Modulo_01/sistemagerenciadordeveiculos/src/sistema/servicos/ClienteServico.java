package sistema.servicos;

import java.util.List;
import java.util.Scanner;
import sistema.crud.ClienteCRUD;
import sistema.interfaces.Cliente;

public class ClienteServico {
	public Cliente cadastrar() {
		Scanner sc = new Scanner(System.in);
		Cliente c = new Cliente();
		
		System.out.println("-------------- NOVO CADASTRO DE CLIENTE --------------");

		System.out.print("NOME: ");
		c.setNome( sc.nextLine() );
		
		System.out.print("TELEFONE: ");
		c.setTelefone( sc.nextLine() );
		
		System.out.print("CPF: ");
		c.setCpf( sc.nextLine() );

		if( consultarCPF(c.getCpf()).getCpf() == null ) {
			new ClienteCRUD().adicionar(c);	
			System.out.println("Cadastro realizado com exito!");
		}else {
			System.err.println("CPF já cadastrado!");
		}
		
		return c;
	}
	
	public Cliente consultarCPF( String cpf) {
		List<Cliente> listaCliente = new ClienteCRUD().consultar();
		Cliente clienteLocalizado = new Cliente();
		
		for(int i=0; i < listaCliente.size(); i++) {
			if(listaCliente.get(i).getCpf().equalsIgnoreCase(cpf)) {
				clienteLocalizado = listaCliente.get(i);
			}
		} 
		
		if(clienteLocalizado.getCpf() != null) {
			System.out.println("-------------- CLIENTE LOCALIZADO --------------");
			System.out.println( clienteLocalizado.getNome() + " | " + clienteLocalizado.getTelefone() + " | " + clienteLocalizado.getCpf() );
		}

		return clienteLocalizado;
	}

	public void atualizar() {
		List<Cliente> listaLoja = new ClienteCRUD().consultar();
		Scanner sc = new Scanner(System.in);
		String op;
				
		System.out.println("Iinforme o CPF do Cliente para alterar os dados: ");
		String cpfCliente = sc.nextLine();
		
		for(int i=0; i < listaLoja.size(); i++) {
			if(listaLoja.get(i).getCpf().equalsIgnoreCase(cpfCliente)) {
				int idCliente = i;
				
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
				
				System.out.print("ALTERAR CPF [S/N]?");
				op = sc.nextLine();
				if(op.equalsIgnoreCase("s")) {
					String novaInformacao = sc.nextLine();
					listaLoja.get(i).setCpf(novaInformacao);
				}
				
				Cliente clienteAtualizado = listaLoja.get(i);
				
				new ClienteCRUD().alterar(idCliente, clienteAtualizado);
			}
		}
	}

	
	public void remover() {
		List<Cliente> listaLojas = new ClienteCRUD().consultar();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Iinforme o CPF do CLIENTE para remover.");
		String cpfCLiente = sc.nextLine();
		
		for(int i=0; i < listaLojas.size(); i++) {
			if(listaLojas.get(i).getCpf().equalsIgnoreCase(cpfCLiente)) {
				new ClienteCRUD().remover(i);
				System.out.println("Item removido com exito");
			}
		}
	}
		
}
