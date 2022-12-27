#include <stdio.h>

int main(){
	int n;
	int i,j;
	float n1, n2, n3;
	float mediap;
	
	printf("Quantos testes deseja realizar\n");
	scanf("%i", &n);
	float v[n];

	printf("*************************\n");	
	for (i=0; i<=n-1; i++){
			printf("Digite o 1 valor da %i sequencia\n", i);
			scanf("%f", &n1);
			printf("Digite o 2 valor da %i sequencia\n", i);
			scanf("%f", &n2);
			printf("Digite o 3 valor da %i sequencia\n", i);
			scanf("%f", &n3);
			mediap = ((n1*2)/10) + ((n2*3)/10) + ((n3*5)/10);
			v[i] = mediap;
			//printf("%.1f \n", v[i]);
			//printf("A media ponderada eh: %.1f\n", mediap);
			printf("*************************\n");
	}
	
		for (j=0; j<=n-1; j++)
		printf("As media foram %.1f	", v[j]);
}
