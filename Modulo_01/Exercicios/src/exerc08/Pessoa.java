package exerc08;

public class Pessoa {
	private String nome;
	private double peso;
	private double altura;
	private double imc;
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getImc() {
		imc = ( (this.peso * this.peso) / this.altura);
		return imc;
	}

	public void setImc(double imc) {
		this.imc = imc;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
}
