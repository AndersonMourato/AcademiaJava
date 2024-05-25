package br.com.fuctura.entidade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Venda {
	@Id
	@GeneratedValue
	private int codigo;
	
	@ManyToOne
	@JoinColumn
	private Veiculo veiculo;
	
	@ManyToOne
	@JoinColumn
	private Vendedor vendedor;
	
	@ManyToOne
	@JoinColumn
	private Cliente cliente;
	private String data;
	
	public Venda(){}
	
	public Venda(Veiculo veiculo, Vendedor vendedor, Cliente cliente, String data) {
		super();
		this.veiculo = veiculo;
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.data = data;
	}
	
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	public Vendedor getVendedor() {
		return vendedor;
	}
	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}

	public int getCodigo() {
		return codigo;
	}

}
