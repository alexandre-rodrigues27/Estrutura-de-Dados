import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Aluno {
    String cpf;
    String nome;

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Aluno(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Aluno other = (Aluno) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Aluno [cpf=" + cpf + ", nome=" + nome + "]";
    }
}

public class ExemploMaria {  
    public static void main(String[] args) {
        List<Aluno> alunos = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        String cpf, nome;
        Aluno alunoTMP;
        boolean flagSair;

        do {
            do {
                System.out.print("Digite o cpf: ");
                cpf = teclado.nextLine().toUpperCase();
                if (cpf.equals("FIM")) {
                    alunos.sort((a1, a2) -> a1.getNome().compareTo(a2.getNome()));
                    System.out.println("Alunos cadastrados....");
                    for (Aluno a : alunos) {
                        System.out.println(a);
                    }
                    System.exit(1);
                }
                if (Util.cpfValido(cpf)) {
                    break;
                } else {
                    System.out.println("CPF invalido!!!");
                }
            } while (true);
            System.out.print("Nome: ");
            nome = teclado.nextLine().toLowerCase();
            alunoTMP = new Aluno(cpf, nome);
            if (!alunos.contains(alunoTMP)) {
                alunos.add(alunoTMP);
            } else {
                System.out.println("Aluno com este cpf ja cadastrado!!");
            }
        } while (true);
    }
}




