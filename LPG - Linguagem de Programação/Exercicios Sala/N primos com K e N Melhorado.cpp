//EX 3: dados N e K, gerar os N primos a partir de K    :N=5 K=10 11,13,17,19,23: MELHORADO
#include <stdio.h>
#include <math.h>

int eh_primo (int x){
	float r=sqrt(x);
	int i;
	
	for(i=2;i<=r;i++){
		if (x%i == 0){
			return 0;
		}
	}
	return 1;
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
