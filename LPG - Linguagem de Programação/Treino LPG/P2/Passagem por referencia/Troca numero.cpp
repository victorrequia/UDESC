#include <stdio.h>

void troca_valor(float *x, float *y){
	int aux;
	aux = *x;
	*x = *y;
	*y = aux;

	printf("n1 = %f\n", *x);
	printf("n2 = %f", *y);
	
	return;
}

int main(){
	float n1, n2;
	
	printf("Digite n1\n");
	scanf("%f", &n1);
	printf("Digite n2\n");
	scanf("%f", &n2);
	
	printf("Antes da troca");
	printf("n1 = %f\n", n1);
	printf("n1 = %f\n", n2);
	printf("Depois da troca\n");
	troca_valor (&n1, &n2);
}
