#include <stdio.h>

void max_min (int vetor[], int tam, int *pMin, int *pMax){
	int i,k;
	
	*pMin = vetor[0];
	*pMax = vetor[0];
	
	//Menor
	for (i=1; i<tam; i++){
		if(*pMin > vetor[i])
			*pMin = vetor[i];
	}
	
	//Maior
	for (k=1; k<tam; k++){
		if(*pMax < vetor[k])
			*pMax = vetor[k];
	}
	
	printf("O menor valor digitado foi %i\n", *pMin);
	printf("O maior valor digitado foi %i\n", *pMax);
	
	
	
}

int main(){
	int tamanhovetor;
	int i, j;
	int pMin, pMax;
	
	printf("Qual tamanho do vetor?\n");
	scanf("%i", &tamanhovetor);
	int vetor[tamanhovetor];
	
	for (i=0; i<tamanhovetor; i++){
		printf("Digite o %i valor do vetor\n", i);
		scanf("%i", &vetor[i]); 
	}
	
	for (j=0; j<tamanhovetor; j++){
		printf("O %i valor digitado foi %i\n", j, vetor[j]);
	}
	
	
	max_min (vetor, tamanhovetor, &pMin, &pMax);
	
	
}
