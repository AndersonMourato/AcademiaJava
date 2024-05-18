package desafio07;

import java.util.Scanner;

public class Escola {
	private Scanner sc = new Scanner(System.in);
	private Professor professores = new Professor();
	private Aluno alunos = new Aluno();
	
	public void menu() {
		int op = 0;
		boolean loop = true;
		
		while (loop) {
			System.out.println("################ MENU DE OPÇÕES DA ESCOLA ################");
			System.out.println("[1] - ADICIONAR PROFESSOR");
			System.out.println("[2] - REMOVER PROFESSOR");
			System.out.println("[3] - EXIBIR LISTA DE PROFESSORES");
			System.out.println("[4] - ADICIONAR ALUNO");
			System.out.println("[5] - REMOVER ALUNO");
			System.out.println("[6] - EXIBIR LISTA DE ALUNOS");
			System.out.println("[7] - ENCERRAR PROGRAMA");
			System.out.println("___________________________________________________________\n");
			System.out.println("Digite uma opção: ");
			op = sc.nextInt();
			
			switch(op) {
				case 1: professores.addProfessor();
				break;
				case 2: professores.removerProfessor(input());
				break;
				case 3: professores.listarProfessores();
				break;
				case 4: alunos.addAluno();
				break;
				case 5: alunos.removerAluno(input());
				break;
				case 6: alunos.listarAlunos();
				break;
				case 7: System.out.println("Programa finalizado com exito."); loop = false; 
				break;
				default: System.err.println("A opção informada é Invalida!");
			}
		}
	}
	
	private int input() {
		System.out.println("Informe o ID: ");
		return sc.nextInt();
	}

}
