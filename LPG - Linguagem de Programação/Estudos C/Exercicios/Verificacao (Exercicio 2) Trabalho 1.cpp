#include <stdio.h>
#include <stdlib.h>

int main(){
	int m,num;
	int i;
	
	printf("Digite quantos valores inteiros e positivos voce deseja analisar:\n");
	scanf("%i", &m);
	
	if (m>=1){
		for (i=0; i<=m; i++){
			printf("Digite o %i numero", i);
			scanf("%i", &num);
		
		if (num%2 == 0){
			printf("M eh par: verificar divisores");
			//divisores
			if (m%)
		}		
	}		
	}else{
		printf("Erro!");
	}

	
	return 0;
}
