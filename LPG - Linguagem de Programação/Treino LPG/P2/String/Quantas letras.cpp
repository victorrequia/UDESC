#include <stdio.h>
#include <string.h>


//Usando For
int main(){
	char nome[30];
	int i;
	int letras=0;
	
	printf("Digite seu nome\n");
	scanf("%s", nome);
	
	for (i=0; nome[i]!='\0'; i++){
		letras++;		
	}

	printf("Seu nome eh %s\n", nome);
	printf("Seu nome tem %i caracteres", letras);
}


/*
//Usando While
int main(){
	char nome[30];
	int i;
	int letras = 0;
	
	printf("Digite seu nome\n");
	scanf("%s", &nome);
	
	while (nome[i]!='\0'){
		letras++;
		i++;
	}
	
	printf("Seu nome eh %s\n", nome);
	printf("Seu nome tem %i caracteres", letras);
}
*/

/*
//Usando strlen
int main(){
	char nome[30];
	
	printf("Digite seu nome\n");
	scanf("%s", nome);
	

	printf("Seu nome eh %s\n", nome);
	printf("Seu nome tem %i letras", strlen(nome));

}
*/
