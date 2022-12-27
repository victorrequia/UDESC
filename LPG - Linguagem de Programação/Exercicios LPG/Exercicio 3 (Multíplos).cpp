#include <stdio.h>

int main(){
	int a, b;
	float mod;
	
	printf("Digite dois numeros para saber se sao multiplos entre si \n");
	scanf("%i %i", &a, &b);
	
	if (a > b){
		if (a%b != 0)
		printf ("Nao sao multiplos");
		else
		printf("Sao multiplos");
		}
	
	if (b > a){
		if (b%a != 0)
			printf ("Nao sao multiplos");		
		else
		printf("Sao multiplos");
	}
	
	
	}
