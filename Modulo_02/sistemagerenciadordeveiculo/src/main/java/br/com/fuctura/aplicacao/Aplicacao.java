package br.com.fuctura.aplicacao;

import java.sql.SQLException;

import br.com.fuctura.controle.ControleLoja;

public class Aplicacao {

	public static void main(String[] args) throws SQLException{

		ControleLoja lj = new ControleLoja();
		
		lj.menuLoja();
		
		/*
		
		// Cadastrar informacoes manual
		Veiculo v = new Veiculo();
		System.out.println("Prencha os campos");
		System.out.print("PLACA: ");
		v.setPlaca(sc.next());
		System.out.print("MODELO: ");
		v.setModelo(sc.next());
		System.out.print("ANO: ");
		v.setAno(sc.nextInt());
		System.out.print("VALOR: ");
		v.setValor(sc.nextFloat());
		
		// Gerar informacoes automaticas
		Veiculo v = new Veiculo();
		Faker fk = new Faker();
		v.setPlaca( fk.letterify(fk.numerify( "???-###" ), true) );
		v.setModelo( fk.cat().name() );
		v.setAno( Integer.parseInt(fk.numerify("201#")) );
		v.setValor( Float.parseFloat(fk.numerify("###.###")) );
		v.setCodigo(1);
		
		*/
		
	}

}
