import java.util.Map;

public class Main {
    public static void main(String[] args) {
        GerenciadorAlunos gerenciador = new GerenciadorAlunos();

        gerenciador.carregarCSV("C:\\Users\\laboratorio\\Desktop\\alunos.csv");

        System.out.println("\nOrdenado por nome:");
        gerenciador.ordenarPorNome();
        gerenciador.exibirAlunos();

        System.out.println("\nOrdenado por ano:");
        gerenciador.ordenarPorAno();
        gerenciador.exibirAlunos();

        String nomeBusca = "Paulo Freire";
        Aluno encontrado = gerenciador.buscarPorNome(nomeBusca);

        if (encontrado != null) {
            System.out.println("\nAluno encontrado:");
            System.out.println(encontrado);
        } else {
            System.out.println("\nAluno não encontrado.");
        }

        System.out.println("\nQuantidade de alunos por ano:");
        Map<Integer, Integer> contagem = gerenciador.contarPorAno();
        for (Map.Entry<Integer, Integer> entry : contagem.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " aluno(s)");
        }
	}
}
