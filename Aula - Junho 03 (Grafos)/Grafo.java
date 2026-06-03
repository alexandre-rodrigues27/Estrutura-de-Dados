import java.util.ArrayList;

public class Grafo {
    int matrizADJ[][];
    int qtdVertices;
    ArrayList<String> vertices;

    /**
     * construtor
     * @param qtdVertices para indicar a quantidade de linhas e colunas da matriz
     */
    public Grafo(ArrayList<String> vertices) {
        this.vertices = new ArrayList<>();
        this.vertices.addAll(vertices);
        this.qtdVertices = vertices.size();
        this.matrizADJ = new int[this.qtdVertices][this.qtdVertices];

        //inicializar com 0 a matriz que representa o grafo
        for (int i = 0; i < qtdVertices; i++) {            
            for (int j = 0; j < qtdVertices; j++) {
                this.matrizADJ[i][j] = 0;
            }
        }
    }

    /**
     * exibe a matrizADJ do grafo em formato de matriz
     */
    void mostrarMatriz() {
        for (String v : this.vertices) {
            System.out.print("    " + v);
        }
        System.out.println();

        for (int i = 0; i < qtdVertices; i++) {
            System.out.print(this.vertices.get(i) + "   ");
            for (int j = 0; j < qtdVertices; j++) {
                System.out.print(matrizADJ[i][j] + "    ");
            }
            System.out.println();
        }
    }

    void mostrarGrafo() {
        for (int i = 0; i < this.qtdVertices; i++) {
            System.out.print(this.vertices.get(i) + ": ");
            for (int j = 0; j < this.qtdVertices; j++) {
                if (this.matrizADJ[i][j] != 0) {
                    System.out.print(this.vertices.get(j) + "   ");
                }
            }
            System.out.println();
        }
    }

    /**
     * dado uma origem e destino é definida uma aresta
     * @param origem representa a linha
     * @param destino representa a coluna
     */
    void inserirAresta(int origem, int destino) {
        if (this.matrizADJ[origem][destino] == 0){
            this.matrizADJ[origem][destino] = 1;
        }
    }

    /**
     * retorna o indice na lista de vertices de um vertice
     * @param vertice um no ou nodo do grafo
     * @return posição do vertice
     */
    int pegarIndice(String vertice) {
        return this.vertices.indexOf(vertice);
    }
}
