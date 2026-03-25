import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Estruturas {

    public static void gerarProcesso(ArrayList<Processo>lista) {

        int id;
        String descricao;
        Scanner teclado = new Scanner(System.in);
        Random gerador = new Random();
        Processo tmp;

        while (true) {
            id = gerador.nextInt(500);
            System.out.println("Descricao do processo: ");
            descricao = teclado.nextLine().toUpperCase();
            if(descricao.equals("SAIR")) {
                break;
            }
            tmp = new Processo(id, descricao);
            if(!lista.contains(tmp)) {
                lista.add(tmp);
            }
        }
    }

    public static void exibirProcesso(ArrayList<Processo>lista) {
       
        System.out.println("Quantidade de processos: "+lista.size());

        lista.sort((p1, p2) -> p1.descricao.compareTo(p2.descricao));
        //System.out.println(lista);
        for (Processo p : lista) {
            System.out.println(p);
        }
    }
    
    public static void localizarProcesso(ArrayList<Processo>lista) {
        
        String descricao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite palavra ou expressao que deseja localizar: ");
        descricao = teclado.nextLine().toUpperCase();

         for (Processo p : lista) {
            if(p.descricao.contains(descricao)) {
                System.out.println(p);
            }
        }
    }
        
    public static void removerProcesso(ArrayList<Processo>lista) {
        
        String descricao;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite palavra ou expressao que deseja remover: ");
        descricao = teclado.nextLine().toUpperCase();

        lista.removeIf(p -> p.descricao.toUpperCase().contains(descricao));
        
        for (Processo p : lista) {
            System.out.println(p);
        }
    }

    public static void main(String[] args) {
        ArrayList <Processo> lista = new ArrayList<>();

        //lista.add(new Processo(1,descricao,"abertura"));
        //lista.add(new Processo(500,descricao,"teste de clock"));
        //lista.add(new Processo(45,descricao,"fechamento de válvula"));
        //lista.add(new Processo(1,descricao,"outro processo"));

        Estruturas.gerarProcesso(lista);
        Estruturas.exibirProcesso(lista);
        Estruturas.localizarProcesso(lista);
        Estruturas.removerProcesso(lista);
    }        
}

//Desafio: Fazer o remover processos dos que tenham uma palavra ou expressao

//Pesquisar, entender e anotar no seu github a diferença entre Vector, list, Arraylist e Linkedlist. Quando usar uma ou outra

