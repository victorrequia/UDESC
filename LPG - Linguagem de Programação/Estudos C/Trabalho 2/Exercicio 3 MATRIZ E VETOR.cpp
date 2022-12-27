#include <stdio.h>
#include <stdlib.h>

int main(){
	int i,j,k;
	int vetor[8];
	int matriz [2][2];

	for (i=0;i<=2;i++){
		printf("\nLinha %i\n", i);
			for (j=0;j<=2;j++){
				printf("\nColuna %i\n", j);
				scanf("%i", &vetor[j]);
			}
	}

	for (j=0;j<=2;j++){
		printf("%i ", vetor[j]);
	}
	
	
	return 0;
}
