package pkg;

public class Arvore {
    
    private class No {
        Figura figura;
        No esquerdo;
        No direito;

        No(Figura figura) {
            this.figura = figura;
            this.esquerdo = null;
            this.direito = null;
        }
    }

    private No raiz;

    public ArvoreFiguras() {
        this.raiz = null;
    }

    public void inserir(Figura novaFigura) {
        raiz = inserirRecursivo(raiz, novaFigura);
    }

    private No inserirRecursivo(No atual, Figura novaFigura) {
        if (atual == null) {
            return new No(novaFigura);
        }

        if (novaFigura.getNumeroFigura() < atual.figura.getNumeroFigura()) {
            atual.esquerdo = inserirRecursivo(atual.esquerdo, novaFigura);
        } 
        else if (novaFigura.getNumeroFigura() > atual.figura.getNumeroFigura()) {
            atual.direito = inserirRecursivo(atual.direito, novaFigura);
        } 
        else {
            atual.figura.setQuantidade(atual.figura.getQuantidade() + novaFigura.getQuantidade());
        }

        return atual;
    }

    public void listarEmOrdem() {
        if (raiz == null) {
            System.out.println("Nenhuma figurinha cadastrada nesta lista.");
            return;
        }
        listarRecursivo(raiz);
    }

    private void listarRecursivo(No atual) {
        if (atual != null) {
            listarRecursivo(atual.esquerdo);  
            System.out.println(atual.figura); 
            listarRecursivo(atual.direito);   
        }
    }

    public Figura buscar(int numeroFigura) {
        return buscarRecursivo(raiz, numeroFigura);
    }

    private Figura buscarRecursivo(No atual, int numeroFigura) {
        if (atual == null || atual.figura.getNumeroFigura() == numeroFigura) {
            return atual != null ? atual.figura : null;
        }

        if (numeroFigura < atual.figura.getNumeroFigura()) {
            return buscarRecursivo(atual.esquerdo, numeroFigura);
        }

        return buscarRecursivo(atual.direito, numeroFigura);
    }
}
