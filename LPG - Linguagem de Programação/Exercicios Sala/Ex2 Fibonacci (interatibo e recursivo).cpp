//Ex2: Fibonacci (recursiva)
//*CONSOME MUITO PROCESSAMENTO
#include <stdio.h>

int fib(int n, int v[]){
	if(v[n] != 0)
	   return v[n];
	   
	if (n==1 || n==2){
		v[n] = 1;
	}else{
		v[n] = fib(n-1, v)+fib(n-2, v);	
	}
	return v[n];
}

long long int fibo (int n){
	if (n==1 || n==2)
		return 1;
	else{
		long long int a=1, b=0, atual;
		int i;
		for (i=3; i<=n; i++){
			atual = a+b;
			a=b;
			b=atual;
		}
		return atual;
		}
}

int main(){
	int i,k, tipo;
	int v[100] = {0};
	printf("Quantos termos?\n");
	scanf("%i", &k);
	printf("1-Interativo\n2-Recusrivo\n");
	scanf("%i", &tipo);
	
	if(tipo==1)
		for(i=1; i<=k; i++)
			printf("%i : %lli\n", i, fibo(i));
	else
		for(i=1; i<=k; i++)
			printf("%i : %lli\n", i, fib(i, v));
}

	
	























