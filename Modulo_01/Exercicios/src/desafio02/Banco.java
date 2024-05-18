package desafio02;

import java.util.Scanner;

public class Banco {
	private String nomeConta = "null";
	private double valor = 0.0;
	private int parcelas = 1;
	private double vlParcelas = 0.0; 
	
	public String getNomeConta() {
		return nomeConta;
	}
	public void setNomeConta(String contas) {
		this.nomeConta = contas;
	}
	public double getValor() {
		return valor;
	}
	public void setVlParcelas(double vlParcelas) {
		this.vlParcelas = vlParcelas;
	}
	public double getVlParcelas() {
		return vlParcelas;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getParcelas() {
		return parcelas;
	}
	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	
	public void pagarConta() {
		Scanner scan = new Scanner(System.in);
		System.out.println("############ PAGAR NOVA CONTA ############");
		System.out.print("Nome da Conta: ");
		setNomeConta(scan.nextLine());
		System.out.print("Valor: ");
		setValor(scan.nextDouble());
		System.out.print("N. Parcelas: ");
		setParcelas(scan.nextInt());
	}
	
	public void comprovantePag() {
		System.out.println("############ CONTA PAGA ############");
		System.out.println("Conta: " + getNomeConta());
		System.out.println("Valor: R$ " + getValor());
		System.out.println("Parcelas: " + getParcelas());
		System.out.println("Valor da Parcela: R$ " + (getVlParcelas() / getParcelas()));
	}
}
