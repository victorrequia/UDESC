#include <stdio.h>

int main(){
	int	array_notas[12] = {100,50,20,10,5,2,1,0.50,0.25,0.10,0.05,0.01};
	int vetor[12];
	//int	array_moedas[6] = {1,0.50,0.25,0.10,0.05,0.01};
	int N,i;
		
	scanf("%f", &N);
	
	for (i=0;i<12;i++){
		vetor[i] = N/array_notas[i];
		N = N%array_notas[i];
	}
	
	printf("%i notas de %i\n", vetor[i], array_notas[i]);
	
}
