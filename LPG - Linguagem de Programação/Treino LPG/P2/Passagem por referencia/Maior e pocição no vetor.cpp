#include <stdio.h>

void max_vetor (float vet[], int tam, float *pMax, int *pindice){
	int i;
	int maior;
	
	maior = vet[0];
	*pindice = 0;
	
	for (i=1; i<tam; i++){
		if (maior < vet[i]){
		maior = vet[i];
		*pindice = i;	
		}
		
	}
	printf("O maior valor do vetor eh: %i\n", maior);
	printf("O valor esta na posicao %i do vetor", *pindice);
}

int main(){
	int tvetor;
	float pMax;
	int pindice;
	int i;
		
	printf("Digite o tamanho do vetor\n");
	scanf("%i", &tvetor);
	float vetor[tvetor];
	
	for (i=0; i<tvetor; i++){
		printf("Digite o %i valor do vetor\n", i);
		scanf("%f", &vetor[i]);
		
	}
	
	max_vetor (vetor, tvetor, &pMax, &pindice);
	
}
