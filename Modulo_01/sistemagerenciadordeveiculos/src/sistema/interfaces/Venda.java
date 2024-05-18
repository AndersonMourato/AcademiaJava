package sistema.interfaces;

public class Venda {
	private Veiculo veiculo;
	private Vendedor vendedor;
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

}
