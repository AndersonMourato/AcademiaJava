package desafio02;

import java.util.Scanner;

public class Menus {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String op;
		Boolean loopCadastro = true;
		Pessoa[] usuarios = new Pessoa[5];
		
		System.out.println("*Permitido cadastrar até 5 usuarios!");
		System.out.println("____________________________________");
		int i = 0;
		while (loopCadastro == true) {
			System.out.println("Cadastrar Novo Usuario?  [s]/[n]");
			op = scan.next();
			if(i <=5 && op.equalsIgnoreCase("S")) {
				usuarios[i] = new Pessoa();
				usuarios[i].cadastrarUsuario();
				i++;
			}else {
				loopCadastro = false;
			}
		}
		
		System.out.println("###### LISTA DE USUARIOS CADASTRADOS ######");
		for(int c=0; c < usuarios.length; c++) {
			if(usuarios[c] != null) {
				System.out.println("ID: " + c + "|	Nome: " + usuarios[c].getNome());
			}
		}
		
		System.out.println("Selecione um Usuario digitando o ID");
		int idUser = scan.nextInt();
		if(usuarios[idUser] != null) {
			System.out.println("Usuario Selecionado: " + usuarios[idUser].getNome());
		}else {
			System.err.println("O ID informado não é válido!");
		}
		
		boolean loppMenu = true;
		while(loppMenu == true) {
			System.out.println();
			System.out.println("############# MENU ###############");
			System.out.println("[1] PAGAR CONTA");
			System.out.println("[2] COMPROVANTE DE PAGAMENTO");
			System.out.println("[3] TROCAR DE USUARIO");
			System.out.println("[4] SAIR");
			System.out.println("__________________________________");
			
			System.out.println("Selecione uma das opções: ");
			int opMenu = scan.nextInt();
			
			switch(opMenu) {
			case 1:{
				usuarios[idUser].pagarConta();
			}
			break;
			case 2:{
				usuarios[idUser].comprovantePag();
			}
			break;
			case 3:{
				System.out.println("###### LISTA DE USUARIOS CADASTRADOS ######");
				for(int c=0; c < usuarios.length; c++) {
					if(usuarios[c] != null) {
						System.out.println("ID: " + c + "|	Nome: " + usuarios[c].getNome());
					}
				}
				System.out.println("Selecione um Usuario digitando o ID");
				idUser = scan.nextInt();
				if(usuarios[idUser] != null) {
					System.out.println("Usuario Selecionado: " + usuarios[idUser].getNome());
				}else {
					System.err.println("O ID informado não é válido!");
				}
			}
				case 4:{
					System.out.println("Sistema encerrado com exito!");
					loppMenu = false;
				}
			break;
			default: System.err.println("Opção selecionada INVALIDA.");
			}
		}
	}
	
	
}
