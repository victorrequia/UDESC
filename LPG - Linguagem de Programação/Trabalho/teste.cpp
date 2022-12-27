#include <stdio.h>

void mostra_strings (char **v, int n, char c){
	int i;
	
	//printf("%s", *v[1]);
	//printf("%s", &v);
		
	for (i=0; i<=n; i++){
		printf("%s", &v[i]);
		}
	}
	
}


int main(){
	int i, j;
	char letra;
	int qstrings;
	
	
	printf("Digite a quantidade de strings ");
	scanf("%i", &qstrings);
	char *strings [qstrings][30];
	//printf("%p\n", strings);
	//printf("%p\n", &qstrings);
	
	printf("Digite as strings\n");
	for (j=0; j<qstrings; j++){
		scanf("%s", strings[j]);
	}
	
	for (i=0; i<qstrings; i++){
		printf("%s ", strings[i]);
	}
	
	printf("\nPosicao %s\n", strings[1]);
	printf("\nDigite uma letra ");
	scanf(" %c", &letra);
	
	mostra_strings (*strings, qstrings, letra);
	
}
