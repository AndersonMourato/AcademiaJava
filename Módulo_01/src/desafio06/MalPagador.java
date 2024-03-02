package desafio06;

import java.util.ArrayList;

public class MalPagador {
	public static void main(String[] args) {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		clientes.add(new Cliente("Jose", -50));
		clientes.add(new Cliente("Paulo", 50));
		clientes.add(new Cliente("Heitor", 80));
		clientes.add(new Cliente("Gabriel", -15));
		clientes.add(new Cliente("Maria", -3.45f));
		clientes.add(new Cliente("Junior", 180));

		System.out.println("\n######### BOM PAGADORES #########");
		for(int i=0; i < clientes.size(); i++) {
			if(clientes.get(i).devedor) {
				System.out.println(clientes.get(i).nome + "	| R$ " + clientes.get(i).valor);
			}
		}
		System.out.println("____________");
		
		System.out.println("\n######### MAL PAGADORES #########");
		for(int i=0; i < clientes.size(); i++) {
			if(!clientes.get(i).devedor) {
				System.out.println(clientes.get(i).nome + "	| R$ " + clientes.get(i).valor);
			}
		}
	}
}