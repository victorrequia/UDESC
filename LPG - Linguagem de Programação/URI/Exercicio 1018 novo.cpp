#include <stdio.h>

int main(){
	int array[7] = {100,50,20,10,5,2,1}; 
	int vetor[7];
	int N,i,j;
	
	scanf("%d", &N);
	printf("%d\n", &N);
	
	for(i=0;i<7;i++){
		vetor[i] = N/array[i];
		N = N%array[i];
	}	
	
	for (j=0;j<7;j++){
		printf("%d nota(s) de R$ %d,00\n", vetor[j], array[j]);
	}

return 0;	
}
