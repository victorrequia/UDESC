#include <stdio.h>

char concatena (int letras1, int letras2, char *nome1, char *nome2){
	int i,j;
	int k=0;
	
	int nome3[letras1+letras2];
	
	for (i=0; i<letras1; i++)
		nome3[i] = nome1[i];
	
	for (j=letras1; i<letras2; j++){
		nome3[j] = nome2[k];
		k++;
	}
	

	return *nome3;	
}


int main(){
	char nome1 [20];
	char nome2 [30];
	int letras1=0;
	int letras2=0;
	int i,j,k;
	int conc;
	
	printf("Digite o primeiro nome\n");
	scanf("%s", nome1);
	for (i=0; nome1[i]!='\0'; i++)
		letras1++;
		
		
	printf("Digite o segundo nome\n");
	scanf("%s", nome2);
	for (j=0; nome2[j]!='\0'; j++)
		letras2++;
	
	
	conc = concatena (letras1, letras2 , nome1, nome2);
	
	
	for (k=0; k<=letras1+letras2; k++)
		printf("%s", conc[k]);
}
