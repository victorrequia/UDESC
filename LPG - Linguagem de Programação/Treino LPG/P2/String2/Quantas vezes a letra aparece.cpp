#include <stdio.h>

void tem_letra (char *nome, char *letra){
	int contador;
	int i;

	for (i=0; nome[i]!='\0'; i++){
		if (nome[i] == *letra)
			contador++;
	}
	
	printf("Apareceu %i vezes", contador);
}


int main(){
	char nome[30];
	char letra;
	
	printf("Digite seu nome\n");
	scanf("%s", &nome);
	printf("Digite uma letra\n");
	scanf(" %c", &letra);
	
	tem_letra  (nome, &letra);
}
