//EX gerar sequencia de numeros primos de 1 ate N (com função)
#include <stdio.h>

int eh_primo (int x){
	int i, cont=0;
	
	for(i=1;i<=x;i++){
		if (x%i == 0){
			cont++;
		}
	}
	
	if (cont == 2){
		return 1;
	}
	else{
		return 0;
	}		
}

int main(){
	int n, x;
	
	scanf("%i", &n);
	
	printf("\n\n");
	
	for (x=1; x<=n; x++){
			
		if (eh_primo(x))
			printf("%i\n", x);
	}	
	
}

