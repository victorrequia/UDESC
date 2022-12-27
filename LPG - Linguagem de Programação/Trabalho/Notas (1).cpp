#include <stdio.h>
#include <stdlib.h>

void faz_tudo (float *p,int nnotas){
	float media;
	float soma;
	int i;
	float maior = p[0];
	float menor = p[0];
	
	for (i=0; i<nnotas; i++){
		soma = (soma + p[i]);	
	
	if (maior < p[i]){
		maior = p[i];
	}
	
	if (menor > p[i]){
		menor = p[i];
	}
	
	}
	
	media = soma/nnotas;
	
	printf("\nA media eh %f\n", media);
	printf("O maior numero digitado foi %f\n", maior);
	printf("O menor numero digitado foi %f\n", menor);
	 
	 
}



int main(){
	int nnotas;
	float *p;
	int i,j;
	
	printf("Quantas notas voce deseja?\n");
	scanf("%i", &nnotas);
	p = (float*)malloc(sizeof(float)*nnotas);
	
	printf("Digite as notas:\n");
	for (i=0; i<nnotas; i++){
		scanf("%f", &p[i]);
	}
	
	
	printf("As notas foram:\n");
	for (j=0; j<nnotas; j++){
		printf("%f ", p[j]);
	}
	

	faz_tudo (p, nnotas);

	free (p);	
}
