#include <stdio.h>
#include <stdlib.h>

int main(){
	int vetor[30];
	int a=0,b=1,novo;
	int i;
	
	// Gerar Fibonacci
	for (i=0;i<=30;i++){
	novo = a+b;
	b = a;
	a = novo;
	vetor[i] = novo;
	}
	
	
	//Printar e saber se é primo
	for (i=0;i<=30;i++){
	//printf("%i = %i\n", i,vetor[i]);
		if (vetor[i]%2 == 0){
	printf("%i = %i nao primo \n", i,vetor[i]);
		}
		else{
	printf("%i = %i eh primo\n", i,vetor[i]);
		}
	}
	
	return 0;
}
