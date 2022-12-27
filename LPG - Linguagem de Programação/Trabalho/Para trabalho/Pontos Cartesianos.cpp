//Cria arquivo
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct ponto_2D {
	float x, y;
}Ponto;

int main(){
	int n,i;
	
	printf("Quantos pontos?\n");
	scanf("%d", &n);
	
	Ponto *p = (Ponto*)malloc(sizeof(Ponto)*n);	
	
	
	for (i=0; i<n; i++){
		printf("Ponto %d:", i+1);
		scanf("%f %f", &p[i].x, &p[i].y);
	}
	
	FILE *f = fopen ("pontos.txt", "wt");

	if (f == NULL){
		printf("Erro no arquivo!\n");
		return -1;
	}
	
	for (i=0; i<n; i++){
		fprintf(f, "%.2f %.2f\n", p[i].x, p[i].y);
	}
	
	fclose (f);
	free (p);
	return 0;
	
}
