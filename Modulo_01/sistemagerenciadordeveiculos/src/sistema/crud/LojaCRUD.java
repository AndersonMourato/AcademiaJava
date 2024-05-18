package sistema.crud;

import java.util.ArrayList;
import java.util.List;

import sistema.interfaces.Loja;

public class LojaCRUD {
	static  List<Loja> listLoja = new ArrayList<>();

	public void adicionar(Loja lj) {
		listLoja.add(lj);
	}
	
	public void alterar(int id, Loja lojaoAtualizada) {	
		listLoja.set(id, lojaoAtualizada);
	}
	
	public List<Loja> consultar() {
		return listLoja;
	}
	
	public void remover(int id) {
		listLoja.remove(id);
	}
}
