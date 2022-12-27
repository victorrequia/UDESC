#include <stdio.h>
	
int main(){
	int n,i;
	scanf("%d", &n);
	
	if (n<2)
		printf("Digite pelo menos 3 numeros\n");
	else{
		long long int a=1, b=1, atual;
		printf("1 : 1\n2 : 1\n");
		for(i=3;i<=n;i++){
			atual = a+b;
			printf("%lld : %lld\n",i, atual);
			a = b;
			b = atual;
		}
	}
	
}
