//Arvore Binária C
#include <stdio.h>
#include <stdlib.h>

typedef struct no{
	struct no* pai;			//ponteiro para o nó pai
	struct no* esquerda;	//ponteiro para o nó filho esquerda
	struct no* direita; 	//ponteiro para o nó filho direita
	int valor;				//conteúdo de um nó arbitrário da árvore
} No;

typedef struct arvore{
	struct no* raiz;
}Arvore;

Arvore* criar(){
	Arvore *arvore = malloc(sizeof(Arvore));
	arvore->raiz = NULL;
	return arvore;
}

int vazia(Arvore* arvore){
	return arvore->raiz == NULL;
}

No* adicionar(Arvore* arvore, No* pai, int valor){
	No *no = malloc(sizeof(No));
	
	no->pai = pai;
	no->esquerda = NULL;
	no->direita = NULL;
	no->valor = valor;
	
	if(pai == NULL){
		arvore->raiz = no;
	}
	
	return no;
}

void remover(Arvore* arvore, No* no){
	if(no->esquerda != NULL){
		remover(arvore, no->esquerda);
	}
	if(no->direita != NULL){
		remover(arvore, no->direita);
	}
	if(no->pai == NULL){ //Este nó é a raiz da árvore?
		arvore->raiz = NULL;
	}else{
		if(no->pai->esquerda == no)
			no->pai->esquerda = NULL;
		else
			no->pai->direita = NULL;
	}
	free(no);
}

void percorrer(No* no){
	if(no != NULL){
		printf("%d", no->valor);
	
		percorrer(no->esquerda);
		percorrer(no->direita);
	}
}

void main(){
	Arvore* arvore = criar();
	
	No* no4 = adicionar(arvore, NULL, 4);
	
	No* no2 = adicionar(arvore, no4, 2);
	no4->esquerda = no2;
	
	No* no6 = adicionar(arvore, no4, 6);
	no4->direita = no6;
	
	No* no1 = adicionar(arvore, no2, 1);
	no2->esquerda = no1;
	
	No* no3 = adicionar(arvore, no2, 3);
	no2->direita = no3;
	
	No* no5 = adicionar(arvore, no6, 5);
	no6->esquerda = no5;
	
	percorrer(arvore->raiz);
	printf("\n");
	remover(arvore, no2);
	percorrer(arvore->raiz);
}
