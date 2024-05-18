package sistema.servicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import sistema.crud.ClienteCRUD;
import sistema.crud.VeiculoCRUD;
import sistema.interfaces.TipoVeiculo;
import sistema.interfaces.Veiculo;

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
		
		v.setTipo(tipo);
		
		if( consultarPlaca(v.getPlaca()).getPlaca() == null ) {
			new VeiculoCRUD().adicionar(v);	
			System.out.println("Cadastro realizado com exito!");
			return v;
		}else {
			System.err.println("PLACA já cadastrada!");
			return consultarPlaca(v.getPlaca());
		}
		
		
	}
	
	public void listarTodos() {
		List<Veiculo> lista = new ArrayList<>();
		lista = new VeiculoCRUD().consultar();
		
		if(!lista.isEmpty()) {
			System.out.println("-------------- IMPRIMINDO A LISTA DE VEICULOS --------------");
			for(Veiculo item : lista) {
				System.out.println( item.getAno() + " | " + item.getMarca() + " | " + item.getModelo() + " | " + item.getPlaca() + " | " + item.getValor() + " | " + item.getTipo().getCategoria() );
			}			
		}else {
			System.err.println("A LISTA ESTA VAZIA!");
		}
		System.out.println("-----• Totalde itens: " + lista.size());
		
	}

	public void atualizar() {
		List<Veiculo> listaVeiculos = new VeiculoCRUD().consultar();
		Scanner sc = new Scanner(System.in);
				
		System.out.println("Iinforme a placa do veiculo para alterar os dados: ");
		String placa = sc.next();
		
		for(int i=0; i < listaVeiculos.size(); i++) {
			if(listaVeiculos.get(i).getPlaca().equalsIgnoreCase(placa)) {
				int idVeiculo = i;
				
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
				
				new VeiculoCRUD().alterar(idVeiculo, veiculoAtualizado);
			}
		}
	}
			
	public void consultarPlacaModelo() {
		List<Veiculo> listaVeiculos = new VeiculoCRUD().consultar();
		List<Veiculo> veiculosLocalizados = new ArrayList<Veiculo>();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Iinforme a PLACA ou o MODELO para localizar um veiculo.");
		String placaModelo = sc.next();
		
		for(int i=0; i < listaVeiculos.size(); i++) {
			if(listaVeiculos.get(i).getPlaca().equalsIgnoreCase(placaModelo) || listaVeiculos.get(i).getModelo().equalsIgnoreCase(placaModelo)) {
				veiculosLocalizados.add(listaVeiculos.get(i));
			}
		}
		
		if(!veiculosLocalizados.isEmpty()) {
			for(Veiculo item : veiculosLocalizados) {
				System.out.println("-------------- VEICULO LOCALIZADO --------------");
				System.out.println( item.getAno() + " | " + item.getMarca() + " | " + item.getModelo() + " | " + item.getPlaca() + " | " + item.getValor() + " | " + item.getTipo().getCategoria()  );	
			}
			
		}else {
			System.err.println("Não foi possivel localizar o veiculo de placa/modelo = " + placaModelo);			
		}

	}
	
	public Veiculo consultarPlaca(String placa) {
		List<Veiculo> listaVeiculos = new VeiculoCRUD().consultar();
		Veiculo veiculosLocalizado = new Veiculo();
		
		for(int i=0; i < listaVeiculos.size(); i++) {
			if(listaVeiculos.get(i).getPlaca().equalsIgnoreCase(placa)) {
				veiculosLocalizado = listaVeiculos.get(i);
			}
		}
		
		if(veiculosLocalizado.getPlaca() != null) {
			System.out.println("-------------- VEICULO LOCALIZADO --------------");
			System.out.println( veiculosLocalizado.getAno() + " | " + veiculosLocalizado.getMarca() + " | " + veiculosLocalizado.getModelo() + " | " + veiculosLocalizado.getPlaca() + " | " + veiculosLocalizado.getValor() + " | " + veiculosLocalizado.getTipo().getCategoria()  );	
		}

		return veiculosLocalizado;
	}
	
	public void remover() {
		List<Veiculo> listaVeiculos = new VeiculoCRUD().consultar();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Iinforme a PLACA para remover.");
		String placa = sc.next();
		
		for(int i=0; i < listaVeiculos.size(); i++) {
			if(listaVeiculos.get(i).getPlaca().equalsIgnoreCase(placa)) {
				new VeiculoCRUD().remover(i);
				System.out.println("Item removido com exito");
			}
		}
	}
		
}
