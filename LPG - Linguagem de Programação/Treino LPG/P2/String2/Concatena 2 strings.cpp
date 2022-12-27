#include <stdio.h>

int concatena (char *nome1, int lenome1, char *nome2, int lenome2){
	char nome3 [lenome1+lenome2];
	int i, j, k=0;
	
	for (i=0; i<=lenome1; i++){
		nome3[i] = nome1[i];
	}

	for (j=lenome1; j<=lenome1+lenome2; j++){
		nome3[j] = nome2[k];
		k++;
	}

	printf("Seus nomes concatenados sao %s\n", nome3);
}



int main(){
	char nome1 [30];
	char nome2 [30];
	int i,j,k;
	int lenome1=0, lenome2=0;
	int conc;
	
	
	printf("Digite o priemiro nome\n");
	scanf("%s", &nome1);
	for (i=0; nome1[i]!='\0'; i++){
		lenome1++;
	}
	
	
	printf("Digite o segundo nome\n");
	scanf("%s", &nome2);
	for (j=0; nome2[j]!='\0'; j++){
		lenome2++;
	}
	
	
	concatena (nome1, lenome1, nome2, lenome2);
}
