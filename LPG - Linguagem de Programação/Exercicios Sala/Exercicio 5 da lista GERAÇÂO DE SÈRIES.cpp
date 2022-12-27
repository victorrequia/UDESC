#include <stdio.h>

int main(){
	float x, e_x=0;
	int n,i,j;
	
	scanf("%f %i", &x, &n);
	
	for (i=0; i<=n; i++){
//
		float pot=1;
		int fat=1;
		for (j=1; j<=i; j++){
			pot*=x;
			fat*=j;
//
		}
	e_x += pot/fat;		
	}
	
	printf("e elevado a %.2f=%.2f\n", x,e_x);
	
	
	/*Alternativa
	e_x += pot(x,i)/fat(i)
	*/
	/*Alternativa 2
	float termo =1;
	
	for (j=1;j<=i;j++){
		termo *= x/j;
	}
	e_x += termo;
	*/	
}
