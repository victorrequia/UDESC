#include <stdio.h>

int main(){
	int n;
	int i;
	
	printf("Digite um numero para saber a tabuada\n");
	scanf("%i", &n);
	
	if (n>2 && n<1000)
		for (i=1; i<=10; i++){
			printf("%i x %i = %i\n", i, n, n*i);
		}
	else
	printf("Numero invalido");
		
	
	
}
