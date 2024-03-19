package desafio08;

public abstract class SistemaLoja {
	public abstract Carro addCarro();
	public abstract Carro updateCarro();
	public abstract Carro buscarCarroPlaca(String placa);
	public abstract boolean dellCarro();
	public abstract void listaCarros();
	
	public abstract Cliente addCliente();
	public abstract Cliente updateCliente();
	public abstract Cliente buscarClienteCpf(String cpf);
	public abstract boolean dellCliente();	
	public abstract void listaClientes();
}
