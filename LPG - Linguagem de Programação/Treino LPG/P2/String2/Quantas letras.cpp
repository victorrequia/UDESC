#include <stdio.h>

void quantas_letras (int *letras, char *nome){
	int i;
	*letras=0;
	int contador = 0;
	
	for (i=0; nome[i]!='\0'; i++){
		contador++;
	}
	
	*letras = contador;
	
	printf("\nSeu nome tem %i letras", *letras);
	
}

int main(){
	char nome[30];
	int letras;
	int i,j;

	printf ("Digite seu nome\n");
	scanf("%s",&nome);
	
	for (i=0; nome[i]!='\0'; i++){
		printf("%c", nome[i]);	
	}
	
	quantas_letras (&letras, nome);
	
}
