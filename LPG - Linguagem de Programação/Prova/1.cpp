#include <stdio.h>
#include <stdlib.h>

void faz_tudo (float *p, int qvalores){
	int i, j, k, l;
	float media1;
	float soma1;
	int maioresmedia=0;
	float *pnovo;
	int y=0;
	
	for (i=0; i<qvalores; i++){
		printf("%f ", p[i]);
		soma1 = soma1 + p[i];
	}
	
	media1 = soma1/qvalores;
	printf("\nA media eh %f\n", media1);
	
	
	for (j=0; j<qvalores; j++){
		if (p[j] >= media1)
		maioresmedia++;
	}
	
	pnovo = (float*)malloc(sizeof(float)*maioresmedia);
	
	for (k=0; k<qvalores; k++){
		if (p[k] >= media1){
		pnovo[y] = p[k];
		y++;
		}
	}
	
	printf("Os valores maiores ou iguas a media sao:\n");
	for (l=0; l<maioresmedia; l++){
		printf("%.2f ", pnovo[l]);
	}
}

int main(){
	int qvalores;
	float *p;
	int i;
	
	printf("Quantos valores deseja?\n");
	scanf("%i", &qvalores);
	p = (float*)malloc(sizeof(float)*qvalores);
		
	printf("Digite os valores:\n");
	for (i=0; i<qvalores; i++){
		scanf("%f", &p[i]);		
	}
	
	faz_tudo (p, qvalores);
}
