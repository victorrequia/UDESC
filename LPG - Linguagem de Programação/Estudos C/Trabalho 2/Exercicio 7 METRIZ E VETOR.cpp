#include <stdio.h>
#include <stdlib.h>

int fibonacci(int N) {
	
	int vfibonacci[4] = {0,1,0,0};   // vetor em que as duas primeiras posi��es s�o termos de fibonacci, a terceira posi��o � o n�mero base para compara��o e a quarta � o n�mero fornecido
	int i, pertence;
	
	vfibonacci[3] = N; 

	for(i=0;i<=N;i++) {
		
		if(vfibonacci[2] > vfibonacci[3]) {
			return 3;
		}
		else {
			vfibonacci[2] = vfibonacci[1] + vfibonacci[2];   // f�rmula geral da sequencia de fibonacci		
			if(vfibonacci[2] == vfibonacci[3]) {
				return 4;							 			// se N for termo da sequencia de fibonacci, assume o valor 1 (true). Se n�o, mant�m o valor 0 (false)
			}
			vfibonacci[0] = vfibonacci[1];
			vfibonacci[1] = vfibonacci[2];	
		} 
	}
	
	return pertence;  									// se n�o for 1 (true), o valor inicial, 0, ir� se manter (false) 
	
}


int main(){
	int n, teste;
	
	printf("Digite um numero para saber se faz parte da sequencia de fibonacci: \n");
	scanf("%i", n);	
	
	teste = fibonacci(n);
	
	if(teste == 4) {
		printf("O valor %i esta contido na sequencia de fibonacci",n);		
	}
	else {
		printf("O valor %i NAO esta contido na sequencia de fibonacci",n);		
	}
	
	return 0;
}

