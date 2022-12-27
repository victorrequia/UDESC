//02 - Sort Simples
#include <stdio.h>

int main(){
	int n1, n2, n3;
	
	printf("Digite os numeros a serem postos em ordem crescente\n");
	scanf("%i %i %i", &n1, &n2, &n3);
	
	//n1 maior
	if (n1 > n2 & n1 > n3){
		if (n2 > n3){
			printf("%i %i %i",n3, n2, n1);
		}
		else
			printf("%i %i %i", n2,n3,n1);
	}
		
	//n2 maior
	if (n2 > n1 & n2 > n3){
		if (n1 > n3){
			printf("%i %i %i",n3, n1, n2);
		}else
			printf ("%i %i %i", n1, n3, n2);
	}
	
	//n3 maior
	if (n3 > n2 & n3> n1){
		if (n2 > n1){
			printf("%i %i %i", n1, n2, n3);
		}else
			printf("%i %i %i", n2, n1, n3);
	}
	
	printf("\n%i %i %i", n1, n2, n3);
	
}
