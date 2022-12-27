#include <stdio.h>

void inc_dec (int *num,int *a, int *b){
	int novo;
	
	novo = (*num+*a)-*b;
	printf("%i", novo);
	return;
}


int main(){
	int num;
	int a,b;
	
	printf("Digite um numero\n");
	scanf("%i", &num);
	printf("Digite um numero a ser incrementado\n");
	scanf("%i", &a);
	printf("Digite um numero a ser decrementado\n");
	scanf("%i", &b);
	
	inc_dec (&num, &a, &b);
}
