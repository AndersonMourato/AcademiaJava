package sistema.crud;

import java.util.ArrayList;
import java.util.List;

import sistema.interfaces.Cliente;
import sistema.interfaces.Loja;
import sistema.interfaces.Vendedor;

public class VendedorCRUD {
	static  List<Vendedor> listVendedores = new ArrayList<>();

	public void adicionar(Vendedor v) {
		listVendedores.add(v);
	}
	
	public void alterar(int id, Vendedor vendedorAtualizado) {	
		listVendedores.set(id, vendedorAtualizado);
	}
	
	public List<Vendedor> consultar() {
		return listVendedores;
	}
	
	public void remover(int id) {
		listVendedores.remove(id);
	}
}
