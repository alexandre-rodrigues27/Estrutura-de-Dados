package pkg;

import java.io.*;
import java.util.Scanner;

public class Menu {
    private static final String ARQUIVO_REPETIDAS = "figuras_repetidas_pessoais.csv";
    private static final String ARQUIVO_DESEJADAS = "figuras_desejadas_pessoais.csv";

    private static ArvoreFiguras arvoreRepetidasPessoais = new ArvoreFiguras();
    private static ArvoreFiguras arvoreDesejadasPessoais = new ArvoreFiguras();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        carregarArquivoPessoal(ARQUIVO_REPETIDAS, arvoreRepetidasPessoais);
        carregarArquivoPessoal(ARQUIVO_DESEJADAS, arvoreDesejadasPessoais);

        int opcao = 0;
        do {
            exibirMenu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        cadastrarFigura(ARQUIVO_REPETIDAS, arvoreRepetidasPessoais);
                        break;
                    case 2:
                        System.out.println("\n--- FIGURAS REPETIDAS PESSOAIS ---");
                        arvoreRepetidasPessoais.listarEmOrdem();
                        break;
                    case 3:
                        cadastrarFigura(ARQUIVO_DESEJADAS, arvoreDesejadasPessoais);
                        break;
                    case 4:
                        System.out.println("\n--- FIGURAS DESEJADAS PESSOAIS ---");
                        arvoreDesejadasPessoais.listarEmOrdem();
                        break;
                    case 5:
                        processarArquivoOutro(true); // Outro Repetidas vs Minhas Desejadas (Match)
                        break;
                    case 6:
                        processarArquivoOutro(false); // Outro Desejadas vs Minhas Repetidas (Match)
                        break;
                    case 7:
                        System.out.println("A sair do programa... Boa sorte com o álbum da Copa 2026!");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, digite um número válido para a opção.");
            }
            System.out.println("\nPressione ENTER para continuar...");
            scanner.nextLine();
        } while (opcao != 7);
    }

    private static void exibirMenu() {
        System.out.println("\n================ MENU FIGURAS COPA 2026 ================");
        System.out.println("1 - Cadastrar figuras repetidas pessoais");
        System.out.println("2 - Listar figuras repetidas pessoais");
        System.out.println("3 - Cadastrar figuras desejadas pessoais");
        System.out.println("4 - Listar figuras desejadas pessoais");
        System.out.println("5 - Carregar figuras repetidas OUTRO");
        System.out.println("6 - Carregar figuras desejadas OUTRO");
        System.out.println("7 - Sair");
        System.out.print("Opção: ");
    }

    private static void cadastrarFigura(String nomeArquivo, ArvoreFiguras arvore) {
        System.out.println("\n--- Cadastro de Figura ---");
        System.out.print("Nome da Seleção: ");
        String selecao = scanner.nextLine();
        System.out.print("Número da Figura: ");
        int numero = Integer.parseInt(scanner.nextLine());
        System.out.print("Descrição (Nome jogador/Brasão/Bandeira): ");
        String descricao = scanner.nextLine();
        System.out.print("Quantidade: ");
        int qtd = Integer.parseInt(scanner.nextLine());
        System.out.print("É rara? (true/false): ");
        boolean rara = Boolean.parseBoolean(scanner.nextLine());

        Figura f = new Figura(selecao, numero, descricao, qtd, rara);
        
        arvore.inserir(f);

        try (FileWriter fw = new FileWriter(nomeArquivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(f.toCSV());
            System.out.println("Figura cadastrada e salva com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao gravar no arquivo: " + e.getMessage());
        }
    }

    private static void carregarArquivoPessoal(String nomeArquivo, ArvoreFiguras arvore) {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) return; 

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    Figura f = Figura.fromCSV(linha);
                    if (f != null) {
                        arvore.inserir(f); 
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar o arquivo " + nomeArquivo);
        }
    }

    private static void processarArquivoOutro(boolean ehRepetidaDoOutro) {
        System.out.print("\nDigite o nome do arquivo CSV da outra pessoa (ex: amigo.csv): ");
        String nomeArquivo = scanner.nextLine();
        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            System.out.println("Arquivo não encontrado!");
            return;
        }

        System.out.println("\n--- Figuras encontradas no arquivo do outro ---");
        ArvoreFiguras correspondenciaMatch = new ArvoreFiguras();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                if (!linha.trim().isEmpty()) {
                    Figura fOutro = Figura.fromCSV(linha);
                    if (fOutro != null) {
                        System.out.println(fOutro);

                        if (ehRepetidaDoOutro) {
                            if (arvoreDesejadasPessoais.buscar(fOutro.getNumeroFigura()) != null) {
                                correspondenciaMatch.inserir(fOutro);
                            }
                        } else {
                            if (arvoreRepetidasPessoais.buscar(fOutro.getNumeroFigura()) != null) {
                                correspondenciaMatch.inserir(fOutro);
                            }
                        }
                    }
                }
            }

            System.out.println("\n=================================");
            System.out.println("   FIGURAS DE MATCH PARA TROCA   ");
            System.out.println("=================================");
            correspondenciaMatch.listarEmOrdem();

        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo da outra pessoa: " + e.getMessage());
        }
    }
}
