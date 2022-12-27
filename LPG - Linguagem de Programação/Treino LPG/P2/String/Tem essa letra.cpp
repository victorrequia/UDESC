#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int compara (char *nome, char letra){
	int i;
	int contador=0;
	
	for (i=0; nome[i]!='0'; i++){
		if (nome[i] == letra)
			contador++; 
	}
	return contador;
}


int main(){
	char nome[30];
	char letra;
	int repete;
	
	printf("Digite seu nome\n");
	scanf("%s", nome);
	
	printf("Qual letra voce deseja saber se tem no seu nome\n");
	scanf(" %c", &letra);
	
	printf("Seu nome eh %s\n", nome);
	printf("A letra que voce escolheu foi %c\n", letra);	

	repete = compara(nome,letra);	

	printf("A letra se repete %i vezes em seu nome", repete);
}
