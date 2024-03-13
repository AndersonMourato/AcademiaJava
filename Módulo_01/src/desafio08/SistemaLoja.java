package desafio08;

public abstract class SistemaLoja {
	public abstract Carro addCarro();
	public abstract Carro updateCarro();
	public abstract Carro buscarCarroPlaca(String placa);
	public abstract void listaCarros();
	public abstract void dellCarro();
	
	public abstract Cliente addCliente();
	public abstract Cliente updateCliente();
	public abstract void dellCliente();	
	public abstract Cliente buscarClienteCpf(String cpf);
}
