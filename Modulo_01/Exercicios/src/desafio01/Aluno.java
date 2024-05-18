package desafio01;

public class Aluno extends Disciplina{
	private String nome;
	private int idade;
	private double mediaGeral;
	private String situacao;
	
	public Aluno () {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public double getMediaGeral() {
		return mediaGeral;
	}
	public void setMediaGeral(double mediaGeral) {
		this.mediaGeral = mediaGeral;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	
}
