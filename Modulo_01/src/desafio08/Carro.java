package desafio08;

public class Carro {
	private String placa;
	private String marca;
	private String modelo;
	private int ano;
	private float valorAproximado;
	private Cliente dono;
	
	public Carro(){}
	public Carro(String placa, String marca, String modelo, int ano, float valorAproximado, Cliente dono) {
		this.placa = placa;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.valorAproximado = valorAproximado;
		this.dono = dono;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public float getValorAproximado() {
		return valorAproximado;
	}
	public void setValorAproximado(float valorAproximado) {
		this.valorAproximado = valorAproximado;
	}
	public Cliente getDono() {
		return dono;
	}
	public void setDono(Cliente dono) {
		this.dono = dono;
	}
	
}
