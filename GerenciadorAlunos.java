import java.io.*;
import java.util.*;

public class GerenciadorAlunos {
    private List<Aluno> listaAlunos = new ArrayList<>();

    public void carregarCSV(String caminhoArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                String curso = dados[1];
                String sexo = dados[2];
                int ano = Integer.parseInt(dados[3]);

                Aluno aluno = new Aluno(nome, curso, sexo, ano);
                listaAlunos.add(aluno);
            }
            
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public void ordenarPorNome() {
        listaAlunos.sort(Comparator.comparing(Aluno::getNome));
    }

    public void ordenarPorAno() {
        listaAlunos.sort(Comparator.comparingInt(Aluno::getAnoIngresso));
    }

    public Aluno buscarPorNome(String nomeBusca) {
        for (Aluno aluno : listaAlunos) {
            if (aluno.getNome().equals(nomeBusca)) {
                return aluno;
            }
        }
        return null;
    }

    public Map<Integer, Integer> contarPorAno() {
        Map<Integer, Integer> contagem = new HashMap<>();

        for (Aluno aluno : listaAlunos) {
            int ano = aluno.getAnoIngresso();
            contagem.put(ano, contagem.getOrDefault(ano, 0) + 1);
        }

        return contagem;
    }

    public void exibirAlunos() {
        for (Aluno aluno : listaAlunos) {
            System.out.println(aluno);
        }
    }
}
