package desafio08;

public abstract class SistemaLoja {
	public abstract Carro addCarro();
	public abstract Carro updateCarro();
	public abstract void dellCarro();
	
	public abstract Cliente addCliente();
	public abstract Cliente updateCliente();
	public abstract void dellCliente();	
	public abstract Cliente buscarClienteCpf(String cpf);
}
