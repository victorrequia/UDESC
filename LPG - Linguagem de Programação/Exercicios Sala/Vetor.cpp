#include <stdio.h>

int main(){
	float v[8];
	int i, n=8;
	
	for (i=0; i<n; i++){
	//	printf("v[%i] = ", i);
		printf("v[%i] %p = ", i, &v[i]);
		scanf("%f", &v[i]);
	}
	
	printf("Dados do vetor:\n");
	for (i=0;i<n;i++){
		printf("%i : %.2f\n", i,v[i]);
	}


printf("\n%i", v); // printa o endereço de memeoria do vetor
}
	
