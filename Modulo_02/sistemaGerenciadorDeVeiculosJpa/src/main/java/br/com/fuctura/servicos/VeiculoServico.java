package br.com.fuctura.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.fuctura.dao.TipoVeiculoDAO;
import br.com.fuctura.dao.VeiculoDAO;
import br.com.fuctura.entidade.TipoVeiculo;
import br.com.fuctura.entidade.Veiculo;
import br.com.fuctura.entitymanager.Entity;

public class VeiculoServico {
	public Veiculo cadastrar() {
		Scanner sc = new Scanner(System.in);
		Veiculo v = new Veiculo();

		System.out.println("-------------- NOVO CADASTRO DE VEICULO --------------");
		System.out.print("ANO: ");
		v.setAno( sc.nextInt() );
		sc.nextLine();
		
		System.out.print("MARCA: ");
		v.setMarca( sc.nextLine() );
		
		System.out.print("MODELO: ");
		v.setModelo( sc.nextLine() );
		
		System.out.print("PLACA: ");
		v.setPlaca( sc.nextLine() );
		
		System.out.print("VALOR: ");
		v.setValor( sc.nextDouble() );

		TipoVeiculo tipo = new TipoVeiculo();
		
		System.out.print("TIPO DE VEICULO: ");
		tipo.setCategoria( sc.next() );
		
		System.out.print("DESCRIÇÃO DO TIPO: ");
		tipo.setDescricao( sc.next() );
		List<TipoVeiculo> listaTipos = new TipoVeiculoDAO().consultaTodos(Entity.getManager());
		if(!listaTipos.isEmpty()) {
			for(TipoVeiculo item: listaTipos) {
				if(item.getCategoria().equalsIgnoreCase(tipo.getCategoria())) {
					v.setTipo(item);
					break;
				}else {
					v.setTipo(tipo);
				}
			}
		}else {
			v.setTipo(tipo);
		}
		
		if( consultarPlaca(v.getPlaca()).getPlaca() == null ) {
			new VeiculoDAO().adicionarAlterar(v, Entity.getManager());	
			System.out.println("Cadastro realizado com exito!");
			return v;
		}else {
			System.err.println("PLACA já cadastrada!");
			return consultarPlaca(v.getPlaca());
		}
	}
	
	public void listarTodos() {
		List<Veiculo> lista = new ArrayList<>();
		lista = new VeiculoDAO().consultarTodos(Entity.getManager());
		
		if(!lista.isEmpty()) {
			System.out.println("-------------- IMPRIMINDO A LISTA DE VEICULOS --------------");
			for(Veiculo item : lista) {
				System.out.println(item.getCodigo()+ " | " + item.getAno() + " | " + item.getMarca() + " | " + item.getModelo() + " | " + item.getPlaca() + " | " + item.getValor() + " | " + item.getTipo().getCategoria() );
				System.out.println("------------------------------------------------------------");
			}			
		}else {
			System.err.println("A LISTA ESTA VAZIA!");
		}
		System.out.println("-----• Totalde itens: " + lista.size());
		
	}

	public void atualizar() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Iinforme a PLACA/MODELO do veiculo para alterar os dados: ");
		String placaModelo = sc.nextLine();
		
		List<Veiculo> listaVeiculos = new VeiculoDAO().consultar(placaModelo, Entity.getManager());
		
		if(!listaVeiculos.isEmpty()) {
			System.out.println("-------------- IMPRIMINDO A LISTA DE VEICULOS --------------");
			for(Veiculo item : listaVeiculos) {
				System.out.println(item.getCodigo()+ " | " + item.getAno() + " | " + item.getMarca() + " | " + item.getModelo() + " | " + item.getPlaca() + " | " + item.getValor() + " | " + item.getTipo().getCategoria() );
			
				System.out.println("Iinforme o ID do veiculo para alterar os dados: ");
				int codigo = sc.nextInt();
				sc.nextLine();
				
				for(int i=0; i < listaVeiculos.size(); i++) {
					if(listaVeiculos.get(i).getCodigo() == codigo) {
						System.out.print("ALTERAR ANO [S/N]?");
						listaVeiculos.get(i).setAno( sc.next().equalsIgnoreCase("s")? sc.nextInt() : listaVeiculos.get(i).getAno() );
						sc.nextLine();
						
						System.out.print("ALTERAR MARCA [S/N]? ");
						listaVeiculos.get(i).setMarca( sc.next().equalsIgnoreCase("s")? sc.next() : listaVeiculos.get(i).getMarca() );
						
						System.out.print("ALTERAR MODELO [S/N]?");
						listaVeiculos.get(i).setModelo( sc.next().equalsIgnoreCase("s")? sc.next() : listaVeiculos.get(i).getModelo() );
						
						System.out.print("ALTERAR VALOR [S/N]?");
						listaVeiculos.get(i).setValor( sc.next().equalsIgnoreCase("s")? sc.nextDouble() : listaVeiculos.get(i).getValor() );
						
						Veiculo veiculoAtualizado = listaVeiculos.get(i);
						
						new VeiculoDAO().adicionarAlterar(veiculoAtualizado, Entity.getManager());
					}
				}
			}			
		}else {
			System.err.println("Não foi possivel localizar a PLACA/MODELO " + placaModelo);
		}
		
		
	}
			
	public void consultarPlacaModelo() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Iinforme a PLACA/MODELO para localizar um veiculo.");
		String placaModelo = sc.nextLine();
		
		List<Veiculo> listaVeiculos = new VeiculoDAO().consultar(placaModelo, Entity.getManager());
		
		if(!listaVeiculos.isEmpty()) {
			for(Veiculo item : listaVeiculos) {
				System.out.println("-------------- VEICULO LOCALIZADO --------------");
				System.out.println( item.getAno() + " | " + item.getMarca() + " | " + item.getModelo() + " | " + item.getPlaca() + " | " + item.getValor() + " | " + item.getTipo().getCategoria()  );	
			}
		}else {
			System.err.println("Não foi possivel localizar o veiculo de placa/modelo = " + placaModelo);			
		}
	}
	
	public Veiculo consultarPlaca(String placa) {
		List<Veiculo> listaVeiculos = new VeiculoDAO().consultar(placa, Entity.getManager());
		Veiculo veiculosLocalizado = new Veiculo();
		
		for(int i=0; i < listaVeiculos.size(); i++) {
			if(listaVeiculos.get(i).getPlaca().equalsIgnoreCase(placa)) {
				veiculosLocalizado = listaVeiculos.get(i);
			}
		}
		
		if(veiculosLocalizado.getPlaca() != null) {
			System.out.println("-------------- VEICULO LOCALIZADO --------------");
			System.out.println( veiculosLocalizado.getAno() + " | " + veiculosLocalizado.getMarca() + " | " + veiculosLocalizado.getModelo() + " | " + veiculosLocalizado.getPlaca() + " | " + veiculosLocalizado.getValor() + " | " + veiculosLocalizado.getTipo().getCategoria()  );	
			System.out.println("------------------------------------------------------------");
		}
		return veiculosLocalizado;
	}
	
	public void remover() {
		Scanner sc = new Scanner(System.in);

		System.out.println("Iinforme o PLACA/MODELO do VEICULO para remover.");
		String placaModelo = sc.nextLine();

		List<Veiculo> listaVeiculos = new VeiculoDAO().consultar(placaModelo, Entity.getManager());
		
		if (!listaVeiculos.isEmpty()) {
			System.out.println("-------------- VEICULO LOCALIZADO --------------");
			for(Veiculo item : listaVeiculos) {
				System.out.println(item.getCodigo()+ " | " + item.getAno() + " | " + item.getMarca() + " | " + item.getModelo() + " | " + item.getPlaca() + " | " + item.getValor() + " | " + item.getTipo().getCategoria() );
				System.out.println("------------------------------------------------------------");
			}
			
			System.out.println("Digite o ID do VEICULO para remover: ");
			int codigo = sc.nextInt();
			sc.nextLine();
			
			for (int i = 0; i < listaVeiculos.size(); i++) {
				if (listaVeiculos.get(i).getCodigo() == codigo) {
					new VeiculoDAO().remover(listaVeiculos.get(i), Entity.getManager());
					System.out.println("Item removido com exito");
				}
			}
		}
	}
		
}
