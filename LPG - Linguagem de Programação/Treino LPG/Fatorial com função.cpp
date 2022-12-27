#include <stdio.h>

int fatorial (int x){
	int fat=1;
	int i;
	
	for (i=x; i>0; i--){
		fat*=i;
	}
	
	return fat;
}


int main(){
	int n1;
	int fat;
	
	printf("Digite um numero para saber seu fatorial:\n");
	scanf("%i", &n1);
	
	fat = fatorial (n1);
	printf("%i", fat);
	
}
