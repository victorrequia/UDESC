#include <stdio.h>
	
int main(){
	int x,y;
	int i;
	int soma=0;
	
	printf("Digite dois numeros\n");
	scanf("%i %i", &x, &y);
	
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
	
	printf("%i", soma);

}		
