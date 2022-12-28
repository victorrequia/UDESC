//Victor Eduardo Requia 
//Questão 5 P1 EDAII

#include <stdlib.h>
#include <stdio.h>

int vetor[0];
void quick_sort(int *a, int esquerda, int direita);

int main(){
	int tamanhoLuva = NULL;
	int tamanhoVetor = NULL;
	
	printf("Quantas luvas deseja adicionar? ");
	scanf(" %i", &tamanhoVetor);
	
	int i = NULL;
	for(i=0; i<tamanhoVetor; i++){
		tamanhoLuva = NULL;
		printf("Numero da %i luva: \n", i);
		scanf(" %i", &tamanhoLuva);
		vetor[i] = tamanhoLuva;
	}
	
	printf("\nLista de luvas: [");
	for(i=0; i<tamanhoVetor; i++){
		printf("%i ", vetor[i]);
	}
	printf("]");
	
	//Função para ordenar o vetor
	quick_sort(vetor, 0, tamanhoVetor-1);
	
	//Como o vetor está ordenado, basta comparar cada posição do vetor com sua sucessora e se for igual, formara um par!
	int pares = 0;
	int j = 0;
	for(i=0; i<tamanhoVetor; i++){
		j = i+1;
		if(vetor[i] == vetor[j]){
			pares++;
		}
	}
	
	printf("\nExistem %i pares de luva, sao eles:", pares);
	
	int vetor_pares[pares];
	for(i=0; i<tamanhoVetor; i++){
		j = i+1;
		if(vetor[i] == vetor[j]){
			printf(" %i", vetor[i]);
		}
	}
}

//Algoritmo QuickSort para ordenar o vetor de tamanho das luvas
void quick_sort(int *a, int esquerda, int direita) {
    int i, j, x, y;
     
    i = esquerda;
    j = direita;
    x = a[(esquerda + direita) / 2];
     
    while(i <= j) {
        while(a[i] < x && i < direita) {
            i++;
        }
        while(a[j] > x && j > esquerda) {
            j--;
        }
        if(i <= j) {
            y = a[i];
            a[i] = a[j];
            a[j] = y;
            i++;
            j--;
        }
    }
     
    if(j > esquerda) {
        quick_sort(a, esquerda, j);
    }
    if(i < direita) {
        quick_sort(a, i, direita);
    }
}
