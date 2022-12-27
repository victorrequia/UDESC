//EX Determinar a qauntidade de divisores de um numero, quais e se é primo
#include <stdio.h>



int main(){
	int x;
	int i,cont = 0;
	
	scanf("%i", &x);
	
	printf("Divisores\n");
	for (i=1; i<=x;i++){
		if (x%i == 0){
			cont++;
			printf("%i ",i);
	
		}
			}
	
	printf("\n%i tem %i divisores", x,cont);
	
	if (cont == 2){
		printf("\nO numero eh primo");
	}
	else{
		printf("\nNao primo");
	}
	
	
}
