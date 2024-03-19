package desafio02;

import java.util.Scanner;

public class Pessoa extends Banco{
	private String nome;
	private String cpf;
	private String conta;
	private double saldo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getConta() {
		return conta;
	}
	public void setConta(String conta) {
		this.conta = conta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void cadastrarUsuario() {
		Scanner scan = new Scanner(System.in);
		System.out.println("################# CADASTRA NOVO USUARIO #################");
		System.out.print("Nome: ");
		setNome(scan.nextLine());
		System.out.print("CPF: ");
		setCpf(scan.nextLine());
		System.out.print("N. Conta Bancaria: ");
		setConta(scan.nextLine());
		System.out.print("Saldo da conta: ");
		setSaldo(scan.nextInt());
		System.out.println();
	}
	
	public void relatorioUsuario() {
		System.out.println("############### RELATORIO DE DADOS PESSOAIS ###############");
		System.out.println("Nome: " + getNome());
		System.out.println("CPF: " + getCpf());
		System.out.println("N. Conta Bancaria: " + getConta());
		System.out.println("Saldo da conta: " + getSaldo());
		System.out.println();
	}
}
