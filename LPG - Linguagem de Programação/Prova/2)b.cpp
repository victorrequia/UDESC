#include <stdio.h>
#include <stdlib.h>

void *vogais (char *s){
	char vogais[5] = {'a', 'e', 'i', 'o', 'u'};
	int i,j, k, l, m, n;
	int letras = 0;
	int qvogais = 0;
	char *ns;
	
	for (i=0; s[i]!='\0'; i++){
		letras++;
	}
	printf("Tem %i letras\n", letras);
	
	for (l=0; l<letras; l++){
		for (m=0; m<5; m++){
			if (s[l] == vogais[m])
				qvogais++;			
		}
	}
	printf("A palavra tem %i vogais", qvogais);	
	ns = (char*)malloc(sizeof(char)*qvogais);
	
	for (j=0; j<letras; j++){
		for (k=0; k<5; k++){
			if (s[j] == vogais[k]){
				ns[j] = s[j];
			}	
		}
	}
	
	printf("As vogais foram:\n");
	for (n=0; n<qvogais; n++){
		printf("%c, ", ns[n]);	
	}
	
}


int main(){
	char nome[30];
	int i;
	int letras=0;
	
	printf("Digite seu nome\n");
	scanf("%s", &nome);
	
	for (i=0; nome[i]!='\0'; i++){
		letras++;
	}
	
	/*for (i=0; i<letras; i++){
		printf("%c", nome[i]);
	}*/
	
	vogais (nome);
}
