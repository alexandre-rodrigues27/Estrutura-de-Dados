import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        ArrayList<String> vertices = new ArrayList<>();
        //populando vertices
        // vertices.add("a");
        // vertices.add("b");
        // vertices.add("c");
        // vertices.add("d");
        // vertices.add("e");

        //TRABALHO AQUI....
            //ler arquivo csv, chamado mapa.csv do tipo
                // a,b
                // b,c 
                // b,d 
                // d,a 
                // d,b 
                // d,c 
                // e,d
            //extrair os vértices presentes no csv e adiciona-los na lista de vértices (lembrar de ordenar)


        Grafo gAssimetrico = new Grafo(vertices);
        //a,b
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("a"), gAssimetrico.pegarIndice("b"));
        
        //b,c
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("b"), gAssimetrico.pegarIndice("c"));
        
        //b,d
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("b"), gAssimetrico.pegarIndice("d"));
        
        //c,e
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("c"), gAssimetrico.pegarIndice("e"));

        //d,a
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("d"), gAssimetrico.pegarIndice("a"));

        //d,b
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("d"), gAssimetrico.pegarIndice("b"));

        //d,c
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("d"), gAssimetrico.pegarIndice("c"));

        //e,d
        gAssimetrico.inserirAresta(gAssimetrico.pegarIndice("e"), gAssimetrico.pegarIndice("d"));

        gAssimetrico.mostrarMatriz();
        System.out.println();
        gAssimetrico.mostrarGrafo();
    }
}
