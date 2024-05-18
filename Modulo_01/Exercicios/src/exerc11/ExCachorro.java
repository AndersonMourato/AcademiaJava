package exerc11;

public class ExCachorro {

	public static void main(String[] args) {
		Cachorro c1 = new Cachorro("Bob", 3, "Branco");
		
		c1.comer();
		c1.latir();
		c1.detalhe();
		
		System.out.println("Alterando nome do cachorro para TOM");
		
		c1.nome = "Tom";
		c1.detalhe();
		
	}
}
