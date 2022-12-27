#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

int main(){
	int vetor[] = {55,23,48,45,26,85,92,15,20,45};
	int i=0, j=0;
	bool switched = true;

	for(i; i<10 && switched == true; i++){
		switched = false;
		j=0;
		for(j; j<10-i-1; j++){
			if(vetor[j]>vetor[j+1]){
				switched = true;
				int hold = vetor[j];
				vetor[j] = vetor[j+1];
				vetor[j+1] = hold;
			}
		}
	
		int k=0;	
		printf("\nIteracao %i 	(", i+1);
		for(k; k<10; k++){
			printf("%i ", vetor[k]);
		}
	}
	
	
	/*int vetor[] = {55,23,48,45,26,85,92,15};
	int i=0;
	
	for(i; i<8; i++){

		for(int j=i+1; j<8; j++){
			if(vetor[i]>vetor[j]){
				int hold = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = hold;
			}
		}
	
	
		printf("\nIteracao %i 	(", i+1);
		for(int k=0; k<8; k++){
			printf("%i ", vetor[k]);
		}
		printf("\n");
	
	}*/
	
	/*	printf("\n");
		for(k=0; k<8; k++){
			printf("%i ", vetor[k]);
		}*/
}; 

