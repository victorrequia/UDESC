//EX gerar sequencia de numeros primos de 1 ate N
#include <stdio.h>

int main(){
	int n, x;
	
	scanf("%i", &n);
	
	printf("\n\n");
	
	for (x=1; x<=n; x++){
		int i, cont=0;
		for(i=1;i<=x;i++){
			if (x%i==0){
				cont++;
			}
		} 	
	if (cont==2)
		printf("%i\n", x);
	}	
	
}
