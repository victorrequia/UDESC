#include <stdio.h>
#include <stdlib.h>

float *maior_valor (float *p, int tvetor){
	int i;
	float maior = 0;
	float *pmaior;
	int indice = 0;
	
	for (i=0; i<tvetor; i++){
		if (maior < p[i]){
			maior = p[i];
			indice = i;
			pmaior = &p[i];
		}
	}
	
	
	
	printf("Maior valor %f na posicao %i\n", maior, indice+1);
	return pmaior;
}



int main(){
	int tvetor;
	float *p;
	float *maiorvalor;
	int i;
	int indice;
	
	printf("Tamanho do vetor?\n");
	scanf("%i", &tvetor);
	p = (float*)malloc(tvetor*sizeof(float));
	
	printf("Digite os valores do vetor\n");
	for (i=0; i<tvetor; i++){
		scanf("%f", &p[i]);
	} 
	
	maiorvalor = maior_valor(p, tvetor);
	
	indice = (maiorvalor-p);
	
	printf("O maior valor eh %f\n", *maiorvalor);
	printf("No indice %i", indice);
}
