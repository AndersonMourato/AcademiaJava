package desafio01;

public class Turma extends Aluno{
	private String nome;
	private int totalAlunos;
	private double mediaGeral;
	
	public Turma() {
		super();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getTotalAlunos() {
		return totalAlunos;
	}
	public void setTotalAlunos(int totalAlunos) {
		this.totalAlunos = totalAlunos;
	}
	public double getMediaGeral() {
		return mediaGeral;
	}
	public void setMediaGeral(double mediaGeral) {
		this.mediaGeral = mediaGeral;
	}
}
