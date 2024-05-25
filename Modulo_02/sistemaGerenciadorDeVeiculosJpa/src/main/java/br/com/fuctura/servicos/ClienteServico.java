package br.com.fuctura.servicos;

import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.ClienteDAO;
import br.com.fuctura.entidade.Cliente;
import br.com.fuctura.entitymanager.Entity;

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
			new ClienteDAO().adicionarAlterar(c, Entity.getManager());	
			System.out.println("Cadastro realizado com exito!");
		}else {
			System.err.println("CPF já cadastrado!");
		}
		
		return c;
	}
	
	public Cliente consultarCPF( String cpf) {
		List<Cliente> listaCliente = new ClienteDAO().consultar(cpf, Entity.getManager());
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
		Scanner sc = new Scanner(System.in);
		String op;
				
		System.out.println("Iinforme o NOME ou CPF do Cliente para alterar os dados: ");
		String nomeCPF = sc.nextLine();
		
		List<Cliente> listaCliente = new ClienteDAO().consultar(nomeCPF, Entity.getManager());
		
		if (!listaCliente.isEmpty()) {
			System.out.println("-------------- CLIENTES LOCALIZADAS --------------");
			for (Cliente cliente : listaCliente) {
				System.out.println(cliente.getCodigo()+ " | " + cliente.getNome() + " | " + cliente.getTelefone() + " | " + cliente.getCpf() );
				System.out.println("------------------------------------------------------");
			}
			System.out.println("-----• Totalde de Clientes: " + listaCliente.size());

			System.out.println("Digite o ID do CLIENTE para alterar: ");
			int codigo = sc.nextInt();
			sc.nextLine();
			
			for(int i=0; i < listaCliente.size(); i++) {
				if(listaCliente.get(i).getCodigo() == codigo) {
					System.out.print("ALTERAR NOME [S/N]?");
					op = sc.nextLine();
					if(op.equalsIgnoreCase("s")) {
						String novaInformacao = sc.nextLine();
						listaCliente.get(i).setNome( novaInformacao );
					}
					
					System.out.print("ALTERAR TELEFONE [S/N]? ");
					op = sc.nextLine();
					if(op.equalsIgnoreCase("s")) {
						String novaInformacao = sc.nextLine();
						listaCliente.get(i).setTelefone( novaInformacao );
					}
					
					System.out.print("ALTERAR CPF [S/N]?");
					op = sc.nextLine();
					if(op.equalsIgnoreCase("s")) {
						String novaInformacao = sc.nextLine();
						listaCliente.get(i).setCpf(novaInformacao);
					}
					
					Cliente clienteAtualizado = listaCliente.get(i);
					new ClienteDAO().adicionarAlterar(clienteAtualizado, Entity.getManager());
				}
			}
		}
		
	}
	
	public void remover() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Iinforme o NOME/CPF do CLIENTE para remover.");
		String nomeCPF = sc.nextLine();

		List<Cliente> listaCliente = new ClienteDAO().consultar(nomeCPF, Entity.getManager());
		
		if (!listaCliente.isEmpty()) {
			System.out.println("-------------- CLIENTES LOCALIZADAS --------------");
			for (Cliente cliente : listaCliente) {
				System.out.println(cliente.getCodigo()+ " | " + cliente.getNome() + " | " + cliente.getTelefone() + " | " + cliente.getCpf() );
				System.out.println("------------------------------------------------------");
			}

			System.out.println("Digite o ID do CLIENTE para remover: ");
			int codigo = sc.nextInt();
			sc.nextLine();
			
			for (int i = 0; i < listaCliente.size(); i++) {
				if (listaCliente.get(i).getCodigo() == codigo) {
					new ClienteDAO().remover(listaCliente.get(i), Entity.getManager());
					System.out.println("Item removido com exito");
				}
			}
		}

	}
		
}
