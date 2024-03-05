package desafio07;
import java.util.ArrayList;
import java.util.Scanner;

public class Professor extends Pessoa {
	private Scanner sc = new Scanner(System.in);
    private ArrayList<Professor> listaProf = new ArrayList<>();
    private String disciplina;

    public Professor(){}

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public void addProfessor() {
        Professor prof = new Professor();
        System.out.println("########### ADICIONAR PROFESSOR ###########");
        System.out.print("NOME: ");
        prof.setNome(sc.nextLine());
        System.out.print("IDADE: ");
        prof.setIdade(sc.nextInt());
        sc.nextLine(); // resolve bug do scan.
        System.out.print("DISCIPLINA: ");
        prof.setDisciplina(sc.nextLine());
        listaProf.add(prof);
        System.out.println("___________________________________________\n");
    }

    public void listarProfessores() {
        System.out.println("########### LISTA DE PROFESSORES ###########");
        for (int i = 0; i < listaProf.size(); i++) {
            System.out.println("ID: " + i);
            System.out.println("NOME: " + listaProf.get(i).getNome());
            System.out.println("IDADE: " + listaProf.get(i).getIdade());
            System.out.println("DISCIPLINA: " + listaProf.get(i).getDisciplina());
            System.out.println("___________________________________________\n");
        }
    }

    public void removerProfessor(int id) {
        listaProf.remove(id);
    }
}