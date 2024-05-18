package sistema.crud;

import java.util.ArrayList;
import java.util.List;

import sistema.interfaces.Veiculo;
import sistema.interfaces.Venda;

public class VendaCRUD {
	static  List<Venda> listVenda = new ArrayList<>();

	public void adicionar(Venda v) {
		listVenda.add(v);
	}
	
	public void alterar(int id, Venda vendaAtualizada) {	
		listVenda.set(id, vendaAtualizada);
	}
	
	public List<Venda> consultar() {
		return listVenda;
	}
	
	public void remover(int id) {
		listVenda.remove(id);
	}
}
