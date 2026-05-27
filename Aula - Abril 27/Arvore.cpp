#include <iostream>
#include <cstdlib>
using namespace std;
 
typedef struct no {
    int valor;
    struct no *esq;
    struct no *dir;
} Arvore;
 
Arvore *inserir(int valor, Arvore *raiz) {
    if (raiz) {
        if (valor < raiz->valor) {
            raiz->esq = inserir(valor, raiz->esq);
        } else {
            raiz->dir = inserir(valor, raiz->dir);            
        }
        return raiz;
    } else {
        //alocar memoria
        Arvore *novo = (Arvore*)malloc(sizeof(Arvore));
        //depositar valores
        novo->valor = valor;
        novo->esq = NULL;
        novo->dir = NULL;
        //retornar o elemento criado
        return novo;
    }
}
 
void red(Arvore *raiz) {
    if (raiz) {
        cout << raiz->valor << endl;
        red(raiz->esq);
        red(raiz->dir);
    }
}
 
void erd(Arvore *raiz) {
    if (raiz) {
        erd(raiz->esq);
        cout << raiz->valor << endl;
        erd(raiz->dir);
    }
}
 
void edr(Arvore *raiz) {
    if (raiz) {
        edr(raiz->esq);
        edr(raiz->dir);
        cout << raiz->valor << endl;
    }
}
 
void exibir(Arvore *raiz, int nivel) {
    if (raiz) {
        //tudo para direita
        exibir(raiz->dir, nivel + 1);
 
        //exibir o nodo dentro de seu nivel
        for (int i = 0; i < nivel; i++) {
            cout << "   ";
        }
        cout << raiz->valor << "(" << nivel << ")" << endl;
 
        //tudo para esquerda
        exibir(raiz->esq, nivel + 1);
    }
}
 
int contarNos(Arvore *raiz) {
    if (raiz) {
        return 1 + contarNos(raiz->esq) + contarNos(raiz->dir);
    }
    return 0;
}

int contarPares(Arvore *raiz) {
    if (raiz) {
        int atual;
        if (raiz->valor % 2 == 0) {
            atual = 1;
        } else {
           atual = 0;
          }
        return atual + contarPares(raiz->esq) + contarPares(raiz->dir);
    }
    return 0;
}
 
int contarFolhas(Arvore *raiz) {
    if (raiz == NULL)
        return 0;

    if (raiz->esq == NULL && raiz->dir == NULL)
        return 1;

    return contarFolhas(raiz->esq) + contarFolhas(raiz->dir);
}

int contido(int valor, Arvore *raiz) {
    if (raiz == NULL)
        return 0;

    if (raiz->valor == valor)
        return 1;

    if (valor < raiz->valor)
        return contido(valor, raiz->esq);
    else
        return contido(valor, raiz->dir);
}

int contarNaoFolhas(Arvore *raiz) {
    if (raiz == NULL)
        return 0;

    if (raiz->esq == NULL && raiz->dir == NULL)
        return 0;

    return 1 + contarNaoFolhas(raiz->esq) + contarNaoFolhas(raiz->dir);
}

int main() {
    Arvore *raiz = NULL;
 
    raiz = inserir(100, raiz);
    raiz = inserir(50, raiz);
    raiz = inserir(200, raiz);
    raiz = inserir(20, raiz);
    raiz = inserir(70, raiz);
    raiz = inserir(250, raiz);
    raiz = inserir(150, raiz);
 
    //red(raiz);
    //erd(raiz);
    //edr(raiz);
 
    exibir(raiz, 0);
    cout << "Total de elementos: " << contarNos(raiz) << endl;
    cout << "Total de pares: " << contarPares(raiz) << endl;
    cout << "Total de folhas: " << contarFolhas(raiz) << endl;
    cout << contido(70, raiz) << endl;
    cout << "Total de nao folhas: " << contarNaoFolhas(raiz) << endl;

    return 1;
}
