import java.util.ArrayList;
import java.util.Iterator;

public class Lista {

    public static void main(String[] args) {
        ArrayList<Integer> lista = new ArrayList<>();

        lista.add(45);
        lista.add(2);
        lista.add(19);
        lista.add(27);

        //PERCUSSÃO EM LISTA

        //Percussão Via Índice
        System.out.println("Percorrer via indice...");
        for(int i = 0; i<lista.size(); i++) {
            System.out.println(lista.get(i)); //lista[i]
        }


        //Percorrer Via Objeto
        System.out.println("Percorrer via objeto...");
        for (int p : lista) {
            System.out.println(p);
        }


        //Percorrer Via Iterador
        System.out.println("Percorrer via iterador...");
        Iterator<Integer> it = lista.iterator();
        while(it.hasNext()) {
            int num = it.next();
            System.out.println(num);
        }
    }
    
}
