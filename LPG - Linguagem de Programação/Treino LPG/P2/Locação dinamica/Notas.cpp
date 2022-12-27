#include <stdio.h>
#include <stdlib.h>

void faz_tudo (int nnotas, float *p){
	int i,j;
	float soma=0;
	float media;	
	float maior=0;
	float menor=p[0];
	
	for (i=0; i<nnotas; i++){
		soma = soma+p[i];
		if (maior < p[i]){
			maior = p[i];
		} 	
		
		if (menor > p[i]){
			menor = p[i];
		}
	}

	media = soma/nnotas;
	
	printf("\nA media eh %f", media);
	printf("\nO maior numero digitado foi %f", maior);
	printf("\nO menor numero digitado foi %f", menor);
	
}


int main(){
	int nnotas;
	float *p;
	int i,j;
	float nota;
	
	printf("Quantas notas?");
	scanf("%i", &nnotas);
	
	p = (float*)malloc(nnotas*sizeof(int));
	
	printf("Digite as notas\n");
	for (i=0; i<nnotas; i++){
		scanf("%f", &p[i]);
	}
	
	printf("As notas foram:");
	for (i=0; i<nnotas; i++){
		printf("%f, ", p[i]);
	}
	
	
	faz_tudo (nnotas, p);
}
