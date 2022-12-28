#include <stdlib.h>
#include <stdio.h>

typedef struct no {
    struct no* pai;
    struct no* esquerda;
    struct no* direita;
    int valor;
} No;

typedef struct arvore {
    struct no* raiz;
} Arvore;

void balanceamento(Arvore*, No*);
int altura(No*);
int fb(No*);
No* rsd(Arvore*, No*);
No* rse(Arvore*, No*);
No* rdd(Arvore*, No*);
No* rde(Arvore*, No*);

Arvore* criar() {
    Arvore *arvore = malloc(sizeof(Arvore));
    arvore->raiz = NULL;
  
    return arvore;
}

int vazia(Arvore* arvore) {
    return arvore->raiz == NULL;
}

No* adicionarNo(No* no, int valor) {
    if (valor > no->valor) {
        if (no->direita == NULL) {
            printf("Adicionando %d\n",valor);
            No* novo = malloc(sizeof(No));
            novo->valor = valor;
            novo->pai = no;

            no->direita = novo;
				
            return novo;
        } else {
            return adicionarNo(no->direita, valor);
        }
    } else {
        if (no->esquerda == NULL) {
            printf("Adicionando %d\n",valor);
            No* novo = malloc(sizeof(No));
			novo->valor = valor;
            novo->pai = no;
			
            no->esquerda = novo;
			
            return novo;
        } else {
            return adicionarNo(no->esquerda, valor);
        }
    }
}

No* adicionar(Arvore* arvore, int valor) {
    if (arvore->raiz == NULL) {
        printf("Adicionando %d\n",valor);
        No* novo = malloc(sizeof(No));
        novo->valor = valor;
        
        arvore->raiz = novo;
			
        return novo;
    } else {
        No* no = adicionarNo(arvore->raiz, valor);
        balanceamento(arvore, no);
        
        return no;
    }
}

void remover(Arvore* arvore, No* no) {
    if (no->esquerda != NULL) {
        remover(arvore, no->esquerda); 
    }
  
    if (no->direita != NULL) {
        remover(arvore, no->direita);
    }
  
    if (no->pai == NULL) {
        arvore->raiz = NULL;
    } else {
        if (no->pai->esquerda == no) {
            no->pai->esquerda = NULL;
        } else {
            no->pai->direita = NULL;
        }
    }

    free(no);
}

No* localizar(No* no, int valor) {
    if (no->valor == valor) {
        return no;
    } else {
        if (valor < no->valor) {
            if (no->esquerda != NULL) {
                return localizar(no->esquerda, valor);
            }
        } else {
            if (no->direita != NULL) {
                return localizar(no->direita, valor);
            }
        }
    }

    return NULL;
}

void percorrerProfundidadeInOrder(No* no, void (*callback)(int)) {
    if (no != NULL) {
        percorrerProfundidadeInOrder(no->esquerda,callback);
        callback(no->valor);
        percorrerProfundidadeInOrder(no->direita,callback);
    }
}

void percorrerProfundidadePreOrder(No* no, void (*callback)(int)) {
    if (no != NULL) {
        callback(no->valor);
        percorrerProfundidadePreOrder(no->esquerda,callback);
        percorrerProfundidadePreOrder(no->direita,callback);
    }
}

void percorrerProfundidadePosOrder(No* no, void (callback)(int)) {
    if (no != NULL) {
        percorrerProfundidadePosOrder(no->esquerda,callback);
        percorrerProfundidadePosOrder(no->direita,callback);
        callback(no->valor);
    }
}

void visitar(int valor){
    printf("%d ", valor);
}

void balanceamento(Arvore* arvore, No* no) {
    while (no != NULL) {
        int fator = fb(no);

        if (fator > 1) { //árvore mais pesada para esquerda
            //rotação para a direita
            if (fb(no->esquerda) > 0) {
                printf("RSD(%d)\n",no->valor);
                rsd(arvore, no); //rotação simples a direita, pois o FB do filho tem sinal igual
            } else {
                printf("RDD(%d)\n",no->valor);
                rdd(arvore, no); //rotação dupla a direita, pois o FB do filho tem sinal diferente
            }
        } else if (fator < -1) { //árvore mais pesada para a direita
            //rotação para a esquerda
            if (fb(no->direita) < 0) {
                printf("RSE(%d)\n",no->valor);
                rse(arvore, no); //rotação simples a esquerda, pois o FB do filho tem sinal igual
            } else {
                printf("RDE(%d)\n",no->valor);
                rde(arvore, no); //rotação dupla a esquerda, pois o FB do filho tem sinal diferente
            }
        }

        no = no->pai; 
    }
}

int altura(No* no){
    int esquerda = 0,direita = 0;

    if (no->esquerda != NULL) {
        esquerda = altura(no->esquerda) + 1;
    }

    if (no->direita != NULL) {
        direita = altura(no->direita) + 1;
    }
  
    return esquerda > direita ? esquerda : direita; //max(esquerda,direita)
}

int fb(No* no) {
    int esquerda = 0,direita = 0;
  
    if (no->esquerda != NULL) {
        esquerda = altura(no->esquerda) + 1;
    }

    if (no->direita != NULL) {
        direita = altura(no->direita) + 1;
    }
  
    return esquerda - direita;
}

No* rse(Arvore* arvore, No* no) {
    No* pai = no->pai;
    No* direita = no->direita;
  
    no->direita = direita->esquerda;
    no->pai = direita;

    direita->esquerda = no;
    direita->pai = pai;

    if (pai == NULL) {
        arvore->raiz = direita;
    } else {
        if (pai->esquerda == no) {
            pai->esquerda = direita;
        } else {
            pai->direita = direita;
        }
    }

    return direita;
}

No* rsd(Arvore* arvore, No* no) {
    No* pai = no->pai;
    No* esquerda = no->esquerda;
  
    no->esquerda = esquerda->direita;
    no->pai = esquerda;
  
    esquerda->direita = no;
    esquerda->pai = pai;

    if (pai == NULL) {
        arvore->raiz = esquerda;
    } else {
        if (pai->esquerda == no) {
            pai->esquerda = esquerda;
        } else {
            pai->direita = esquerda;
        }
    }

    return esquerda;
}

No* rde(Arvore* arvore, No* no) {
    no->direita = rsd(arvore, no->direita);
    return rse(arvore, no);
}

No* rdd(Arvore* arvore, No* no) {
    no->esquerda = rse(arvore, no->esquerda);
    return rsd(arvore, no);
}

int main() {
    Arvore* a = criar();

    for (int i = 1; i <= 7; i++) {
        adicionar(a,i);  
    }

    printf("In-order: ");
    percorrerProfundidadeInOrder(a->raiz,visitar);
    printf("\n");
}
