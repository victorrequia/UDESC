#include <stdio.h>

int soma2 (int x, int y){
	int soma;
	soma = x+y;
}

int main(){
	int n1, n2;
	int soma;
	
	scanf("%i %i", &n1, &n2);
	soma =	soma2 (n1, n2);
	printf("%i", soma);	
}
