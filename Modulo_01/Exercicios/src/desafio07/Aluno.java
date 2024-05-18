package desafio07;
import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Pessoa {
	private Scanner sc = new Scanner(System.in);
    private ArrayList<Aluno> listaAluno = new ArrayList<>();
    private int matricula;

    public Aluno(){}
    
    public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

    public void addAluno() {
        Aluno aluno = new Aluno();
        System.out.println("########### ADICIONAR ALUNO ###########");
        System.out.print("NOME: ");
        aluno.setNome(sc.nextLine());
        System.out.print("IDADE: ");
        aluno.setIdade(sc.nextInt());
        sc.nextLine(); // resolver bug scan.
        System.out.print("MATRICULA: ");
        aluno.setMatricula(sc.nextInt());
        sc.nextLine(); // resolver bug scan.
        listaAluno.add(aluno);
        System.out.println("___________________________________________\n");
    }

    public void listarAlunos() {
        System.out.println("########### LISTA DE ALUNOS ###########");
        for (int i = 0; i < listaAluno.size(); i++) {
            System.out.println("ID: " + i);
            System.out.println("NOME: " + listaAluno.get(i).getNome());
            System.out.println("IDADE: " + listaAluno.get(i).getIdade());
            System.out.println("DISCIPLINA: " + listaAluno.get(i).getMatricula());
            System.out.println("___________________________________________\n");
        }
    }

    public void removerAluno(int id) {
    	listaAluno.remove(id);
    }
}