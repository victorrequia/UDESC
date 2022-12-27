//EX 3: dados N e K, gerar os N primos a partir de K    :N=5 K=10 11,13,17,19,23:
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
	int n, k;
	
	scanf("%i %i", &n, &k);
	int cont=0, i;

	for (i=k; cont<n; i++){		
		if (eh_primo(i))
			printf("%i\n", i);
			cont++;
	}		
	

return 0;	
}
