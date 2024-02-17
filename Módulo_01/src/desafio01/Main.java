package desafio01;

import java.util.List;

public class Main {

	public static void main(String[] args) {

	Turma turma1 = new Turma();
	turma1.setNome("JAVA");
	
	String[] lista = new String[10];
	
	for(int i = 0 ; i < 10; i++) {
		lista[i] = "Bloco "+i;
	}
	
	for(int i = 0 ; i < 10; i++) {
		System.out.println(i + " | " + lista[i]);
	}

		
		

	}

}
