package sistema.crud;

import java.util.ArrayList;
import java.util.List;

import sistema.interfaces.Cliente;
import sistema.interfaces.Loja;

public class ClienteCRUD {
	static  List<Cliente> listClientes = new ArrayList<>();

	public void adicionar(Cliente c) {
		listClientes.add(c);
	}
	
	public void alterar(int id, Cliente clienteAtualizado) {	
		listClientes.set(id, clienteAtualizado);
	}
	
	public List<Cliente> consultar() {
		return listClientes;
	}
	
	public void remover(int id) {
		listClientes.remove(id);
	}
}
