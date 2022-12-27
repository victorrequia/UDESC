#include <stdio.h>

int main(){
	int x,y;
	int i,k;
	int testes,j,n;
	
	printf("Digite quantos teste deseja realizar:\n");
	scanf("%i", &n);
	int v[n];
	
	for (j=0; j<=n-1; j++){
	printf("\n\nDigite dois numeros\n");
	scanf("%i %i", &x, &y);
	int soma=0;
	
	if (x>0 && y>0){
		if (x<y)
			for (i=x+1 ; i<y; i++){
			if (i%2 != 0)
			soma = soma+i;
			}
		else
		if (x>y)
			for (i=x-1; i>y; i--){
				if (i%2 != 0)
				soma = soma+i;
			}
	}
	else
	if (x<0 && y<0){
		if (x<y){
			for (i=x+1; i<y; i++)
				if (i%2 != 0)
					soma = (soma+i*-1);
		}
		else
			if (y<x){
				for (i=x-1; i>y; i--)
				if (i%2 != 0)
					soma = (soma+i*-1);
		}
	}
	else							
	if (x>0 && y<0){
		for (i=x-1; i>y; i--)
			if (i%2 != 0)
				soma = soma+i;
	}
	else
	if (x<0 && y>0){
		for (i=x+1; i<y; i++)
			if (i%2 != 0)
				soma = soma+i;	
	}	
	
	printf("Soma dos impares: %i\n", soma);
	
	for (k=0; k<=n; k++)
		v[j] = soma;

}	

for (k=0; k<n; k++)
printf("\nVetor : %i ", v[k]);
}


	
