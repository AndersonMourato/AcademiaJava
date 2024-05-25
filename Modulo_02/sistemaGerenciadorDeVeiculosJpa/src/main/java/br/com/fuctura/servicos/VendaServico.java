package br.com.fuctura.servicos;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.VendaDAO;
import br.com.fuctura.entidade.Cliente;
import br.com.fuctura.entidade.Veiculo;
import br.com.fuctura.entidade.Venda;
import br.com.fuctura.entidade.Vendedor;
import br.com.fuctura.entitymanager.Entity;

public class VendaServico {
	public void novaVenda() {
		Venda venda = new Venda();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Informe o CPF do cliente? ");
		String cpf = sc.nextLine();
		
		Cliente cliente = new ClienteServico().consultarCPF(cpf);

		if(cliente.getCpf() == null) {
			System.err.println("O CPF " + cpf + " não foi cadastrado!");
			cliente = new ClienteServico().cadastrar();
			venda.setCliente(cliente);
		}else {
			venda.setCliente(cliente);
		}
		
		
		System.out.println("Informe a PLACA do veiculo? ");
		String placa = sc.nextLine();
		
		Veiculo veiculo = new VeiculoServico().consultarPlaca(placa);
		if(veiculo.getPlaca() == null) {
			System.err.println("Não foi possivel localizar o veiculo de placa = " + placa);	
			veiculo = new VeiculoServico().cadastrar();
			venda.setVeiculo(veiculo);
		}else {
			venda.setVeiculo(veiculo);
		}
		
		
		System.out.println("Informe o CPF do vendedor? ");
		String cpfVendedor = sc.nextLine();
		
		Vendedor vendedor = new VendedorServico().consultarCPF(cpfVendedor);
		if(vendedor.getCpf() == null) {
			System.err.println("O CPF " + cpfVendedor + " não foi cadastrado!");
			vendedor = new VendedorServico().cadastrar();
			venda.setVendedor(vendedor);
		}else {
			venda.setVendedor(vendedor);
		}
		
		Date dataAtual = new Date();
		String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataAtual);
		venda.setData(dataFormatada);
		
		new VendaDAO().adicionarAlterar(venda, Entity.getManager());
		System.out.println("Venda realizada com exito!");
		
	}
	
	public List<Venda> listarVendas() {
		List<Venda> listaVenda = new VendaDAO().consultar(Entity.getManager());
		Scanner sc = new Scanner(System.in);
		double somaVendas = 0;
		int i = 0;
		System.out.println("-------------- IMPRIMINDO A LISTA VENDAS --------------");
		for(Venda venda : listaVenda) {	
			somaVendas += venda.getVeiculo().getValor();
			System.out.println("["+ i +"] | " + venda.getData() + " | " + venda.getVendedor().getNome() + " | " + venda.getVeiculo().getModelo() + " | " + venda.getCliente().getNome()  + " | " + venda.getVeiculo().getValor());
			i++;
		}
		System.out.println("---------------------------------------------------------------------");
		System.out.println("Total de VENDAS: " + listaVenda.size()  + " | " + "Total acumulado em VENDAS: R$" + somaVendas);
		
		return listaVenda;
	}

	public void atualizar() {
		List<Venda> listaVenda = listarVendas();
		Scanner sc = new Scanner(System.in);
		String op;
		
		System.out.println("Iinforme o ID do pedido para alterar.");
		int idPedido = sc.nextInt();
		sc.nextLine();
		
		Venda vendaLocalizada = listaVenda.get(idPedido);
		
		if(vendaLocalizada.getCliente().getNome() != null) {
			
			System.out.print("ALTERAR CLIENTE [S/N]?");
			op = sc.nextLine();
			if(op.equalsIgnoreCase("s")) {
				vendaLocalizada.setCliente( new ClienteServico().cadastrar() );
			}
			
			System.out.print("ALTERAR VEICULO [S/N]?");
			op = sc.nextLine();
			if(op.equalsIgnoreCase("s")) {
				vendaLocalizada.setVeiculo( new VeiculoServico().cadastrar() );
			}
			
			System.out.print("ALTERAR VENDEDOR [S/N]?");
			op = sc.nextLine();
			if(op.equalsIgnoreCase("s")) {
				vendaLocalizada.setVendedor( new VendedorServico().cadastrar() );
			}
			
			Date dataAtual = new Date();
			String dataFormatada = new SimpleDateFormat("dd/MM/yyyy").format(dataAtual);
			vendaLocalizada.setData(dataFormatada);
			
			new VendaDAO().adicionarAlterar(vendaLocalizada, Entity.getManager());
			
		}else {
			System.err.println("O ID da venda informada não é valido.");
		}		
		
	}
			
	
	public void remover() {
		List<Venda> listaVenda = listarVendas();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Iinforme o ID do pedido para remover.");
		int idPedido = sc.nextInt();
		
		for(int i=0; i < listaVenda.size(); i++) {
			if(idPedido == i) {
				new VendaDAO().remover(listaVenda.get(i) ,Entity.getManager());
				System.out.println("Item removido com exito");
			}
		}
	}
		
}
