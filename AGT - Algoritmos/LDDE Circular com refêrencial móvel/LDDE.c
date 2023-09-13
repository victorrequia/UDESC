#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <locale.h>
#include<stdbool.h>

typedef struct No{
	int info;
	struct No *proximo;
	struct No *anterior;	
}Nodo;

typedef struct Desc{
	int TamInfo;
	int posLogAtual;
	Nodo *refMovel;
	Nodo *primeiraPos;
	Nodo *ultimaPos;
}Descritor;

bool listaVazia(Descritor *lista);
void iniciaLista(Descritor *lista);
void adicionaNoInicioLista(Descritor *lista, int valor);
void adicionaNaPosicao(Descritor *lista, int valor, int posicao);
void adicionaFinalLista(Descritor *lista, int valor);
int tamanhoDaLista(Descritor *lista);
int buscaNaPosicao(Descritor *lista, int posAlvo);
int removeDaPosLog(Descritor *lista, int posAlvo);
void imprimeLista(Descritor *lista);

int main (int argc, char **argv){
	setlocale(LC_ALL, "Portuguese");
	Descritor lista;
	iniciaLista(&lista);
	
	adicionaNoInicioLista(&lista, 0);
	printf("Elemento 0 adicionado no inicio da lista");
	adicionaNaPosicao(&lista, 1, 1);
	printf("\nElemento 1 adicionado no na posicao 1 da lista");
	adicionaNaPosicao(&lista, 2, 2);
	printf("\nElemento 2 adicionado no na posicao 2 da lista");
	adicionaFinalLista(&lista, 3);
	printf("\nElemento 3 adicionado no fim da lista");
	adicionaFinalLista(&lista, 4);
	printf("\nElemento 4 adicionado no fim da lista");
	adicionaNaPosicao(&lista, 5, 5);
	printf("\nElemento 5 adicionado no na posicao 5 da lista");
	adicionaNoInicioLista(&lista, 10);
	printf("\nElemento 10 adicionado no inicio da lista");
	adicionaFinalLista(&lista, 1000);
	printf("\nElemento 1000 adicionado no fim da lista\n");

	imprimeLista(&lista);
	
	printf("\n\nPos log atual = %i, tamanho da lista %i", lista.posLogAtual, lista.TamInfo);
	printf("\nElemento anterior = %i, proximo elemento = %i", lista.refMovel->anterior->info, lista.refMovel->proximo->info);
	printf("\nPrimeiro elemento da lista= %i, ultimo elemento da lista= %i", lista.primeiraPos->info, lista.ultimaPos->info);
	
	printf("\n\nElemento na posica %i = %i", lista.posLogAtual,buscaNaPosicao(&lista, 0));
	printf("\nPosicao logica atual %i", lista.posLogAtual);
	printf("\nElemento na posica %i = %i", lista.posLogAtual,buscaNaPosicao(&lista, 3));
	printf("\nPosicao logica atual %i", lista.posLogAtual);
	printf("\nElemento na posica %i = %i", lista.posLogAtual,buscaNaPosicao(&lista, 7));
	printf("\nPosicao logica atual %i", lista.posLogAtual);
	printf("\nElemento na posica %i = %i", lista.posLogAtual,buscaNaPosicao(&lista, 5));
	printf("\nPosicao logica atual %i\n", lista.posLogAtual);
	
	removeDaPosLog(&lista, 7);
	printf("\nElemento removida da posicao 7");
	imprimeLista(&lista);
	
	removeDaPosLog(&lista, 0);
	printf("\nElemento removida da posicao 0");
	imprimeLista(&lista);
	
	removeDaPosLog(&lista, 2);
	printf("\nElemento removida da posicao 2");
	imprimeLista(&lista);
	
	removeDaPosLog(&lista, 3);
	printf("\nElemento removida da posicao 3");
	imprimeLista(&lista);
	
	printf("\n");
	system("PAUSE");
}

void iniciaLista(Descritor *lista){
	lista->TamInfo = 0;
	lista->posLogAtual = -1;
	lista->refMovel = NULL;
	lista->ultimaPos = NULL;
	lista->primeiraPos = NULL;
}

bool listaVazia(Descritor *lista){
	if(lista->TamInfo == 0){
		return true;
	}else{
		return false;
	}
}

void imprimeLista(Descritor *lista){
	if(!(listaVazia(lista))){
		printf("\nLista impressa: ");
		if(lista->TamInfo == 1){
			printf("%i", lista->primeiraPos->info);
		}else{
			Nodo *aux = lista->refMovel;
			int posBefore = lista->posLogAtual;
			
			lista->refMovel  = lista->primeiraPos;
			lista->posLogAtual = 0;
			int i;
			
			for(i=0; i<lista->TamInfo; i++){
				printf("%i-%i ", i,lista->refMovel->info);
				lista->posLogAtual++;
				lista->refMovel = lista->refMovel->anterior;
			}
			
			lista->refMovel = aux;
			lista->posLogAtual = posBefore;
			
			free(aux);
		}		
	}else{
		printf("A lista esta vazia!");
	}
}

void adicionaNoInicioLista(Descritor *lista, int valor){
	Nodo *novo_no;
	novo_no = (Nodo*)malloc(sizeof(Nodo));
	novo_no->info = valor;
	
	if(lista->refMovel == NULL){
		novo_no->anterior = NULL;
		novo_no->proximo = NULL;
		lista->refMovel = novo_no;
		lista->ultimaPos = novo_no;
	}else{
		lista->ultimaPos->anterior = novo_no;
		
		lista->refMovel = lista->primeiraPos;
		lista->refMovel->proximo = novo_no;
			
		lista->refMovel = novo_no; 
		
		novo_no->anterior = lista->primeiraPos;
		novo_no->proximo = lista->ultimaPos;
	}
	
	lista->TamInfo++;
	lista->primeiraPos = novo_no;
	lista->posLogAtual = 0;
}

void adicionaNaPosicao(Descritor *lista, int valor, int posAlvo){
	if((posAlvo <= lista->TamInfo) && (posAlvo >= 0)){	
		if(posAlvo == lista->TamInfo){
			adicionaFinalLista(lista, valor);	
		}else{
			if(posAlvo == 0){
				adicionaNoInicioLista(lista, valor);		
			}else{
				Nodo *novo_no;
				novo_no = (Nodo*)(malloc(sizeof(Nodo)));
				novo_no->info = valor;
							
				if(posAlvo < lista->posLogAtual){
					while(posAlvo != lista->posLogAtual){
						lista->refMovel = lista->refMovel->proximo;
						lista->posLogAtual--;
					}
					Nodo *aux = lista->refMovel;
					lista->refMovel = lista->refMovel->proximo;
					lista->refMovel->anterior = novo_no;
					novo_no->anterior = aux;
					novo_no->proximo = lista->refMovel; 
					aux->proximo = novo_no;
					lista->refMovel = lista->refMovel->anterior;
					lista->TamInfo++;	
				}else{
					while(posAlvo != lista->posLogAtual){
						lista->refMovel = lista->refMovel->anterior;
						lista->posLogAtual++;
					}
					Nodo *aux = lista->refMovel;
					lista->refMovel = lista->refMovel->proximo;
					lista->refMovel->anterior = novo_no;
					novo_no->anterior = aux;
					novo_no->proximo = lista->refMovel; 
					aux->proximo = novo_no;
					lista->refMovel = lista->refMovel->anterior;
					lista->TamInfo++;	
				}	
			}
		}
	}else{
		printf("Erro ao adicionar elemento, posicao invalida!\n");
	}
}

void adicionaFinalLista(Descritor *lista, int valor){	
	if(lista->refMovel == NULL){
		adicionaNoInicioLista(lista, valor);
	}else{
		Nodo *novo_no;
		novo_no = (Nodo*)malloc(sizeof(Nodo));
		novo_no->info = valor;
		
		lista->primeiraPos->proximo = novo_no;
		
		lista->refMovel = lista->ultimaPos;
		lista->refMovel->anterior = novo_no;
		novo_no->proximo = lista->refMovel;
		
		lista->refMovel = novo_no;
		
		lista->TamInfo++;
		
		novo_no->anterior = lista->primeiraPos;
		lista->posLogAtual = lista->TamInfo-1;
		lista->ultimaPos = novo_no;
	}
}

int tamanhoDaLista(Descritor *lista){
	return lista->TamInfo;
}

int buscaNaPosicao(Descritor *lista, int posAlvo){
	if((posAlvo < lista->TamInfo) && (posAlvo >= 0)){ //Verifica se a posicao e valida
		if(posAlvo <= lista->posLogAtual){ //Alvo esta a esqueda do referencial movel
			if((fabs(lista->TamInfo-lista->posLogAtual) + posAlvo) < (fabs(lista->posLogAtual-posAlvo))){  //Percorre atual-direita (verificado logicamente)
				while(lista->posLogAtual != posAlvo){
					lista->refMovel = lista->refMovel->anterior;
					lista->posLogAtual++;
					if(lista->posLogAtual == lista->TamInfo){
						lista->posLogAtual = 0;
					}
				}
				return lista->refMovel->info;
			}else{ //Percorre atual-esquerda (verificado logicamente)
				while(lista->posLogAtual != posAlvo){
					lista->refMovel = lista->refMovel->proximo;
					lista->posLogAtual --;
				}
				return lista->refMovel->info;
			}
		}else{ //Alvo esta  a direita do referencial movel (verificada logicamente)
			if((lista->posLogAtual+(fabs(lista->TamInfo-posAlvo))) < (fabs(posAlvo-lista->posLogAtual))){ //Percorre atual-esquerda
				while(lista->posLogAtual != posAlvo){
					lista->refMovel = lista->refMovel->proximo;
					lista->posLogAtual--;
					if(lista->posLogAtual == -1){
						lista->posLogAtual = lista->TamInfo-1;
					}
				}
				
				return lista->refMovel->info;
			}else{ //Percorre atual-direita
			while(lista->posLogAtual != posAlvo){
				lista->refMovel = lista->refMovel->anterior;
				lista->posLogAtual++;
			}
			
			return lista->refMovel->info;
			}
		}
		}else{
			printf("\nPosicao invalida! Posicao inicial = 0 e final = %i\n", lista->TamInfo-1);
			return 0;
		}
}

int removeDaPosLog(Descritor *lista, int posAlvo){
	if((posAlvo < lista->TamInfo) && (posAlvo >= 0)){
		int valorBuscado;
		
		if (posAlvo != lista->posLogAtual){
			valorBuscado = buscaNaPosicao(lista, posAlvo);	
		}else{
			valorBuscado = lista->refMovel->info;
		}
		
		Nodo *auxProximo = lista->refMovel->proximo;
		Nodo *auxAnterior = lista->refMovel->anterior;
		Nodo *aux = lista->refMovel;
		
		if(posAlvo == lista->TamInfo-1){
			lista->refMovel = auxProximo;
			lista->posLogAtual--;	
		}else{
			lista->refMovel = auxAnterior;
		}
		
		free(aux);
		
		auxProximo->anterior = auxAnterior;
		auxAnterior->proximo = auxProximo;
		
		lista->TamInfo--;
		
		if(posAlvo == lista->TamInfo-1){
            lista->ultimaPos = lista->refMovel;
        }

        if(posAlvo == 0){
            lista->primeiraPos = lista->refMovel;
        }
	}else{
		printf("\nPosicao invalida!\n");
		return 0;
	}
}
