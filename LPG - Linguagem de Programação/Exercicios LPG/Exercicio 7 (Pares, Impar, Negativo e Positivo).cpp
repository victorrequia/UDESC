#include <stdio.h>

int main(){
	int i,k;
	int v[4];
	int snegativos=0, spositivos=0, spar=0, simpar=0;
	
	for (i=0; i<=4; i++){
		printf("Digite %i numeros\n", 5-i);
		scanf("%i", &v[i]);
	}
	

	for (i=0; i<=4; i++){ 
		printf("%i", v[i]);	
	
	if (v[i] > 0)
		spositivos++;
	
	if (v[i] < 0)
		snegativos++;
		
	if (v[i] % 2 ==0)
		spar++;
	else
		simpar++;
	
	}	

	printf("\nNumeros positivos %i", spositivos);
	printf("\nNumeros negativos %i", snegativos);
	printf("\nNumeros pares %i", spar);
	printf("\nNumeros impares %i", simpar);

}
	

