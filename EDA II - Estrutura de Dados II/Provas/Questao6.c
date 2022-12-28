//Victor Eduardo Requia
//Questão 6 P1 EDAII

#include<stdio.h>
#include<stdlib.h>

int verificadorString(char *palavra1, char *palavra2);
int minimo(int *valor1,int *valor2);

int main(){
	char palavra1[5];
	char palavra2[5];
	
	printf("Informe a primeira palavra: ");
	scanf(" %s", &palavra1);
	printf("Informe a segunda palavra: ");
	scanf(" %s", &palavra2);

	printf("Palavra1 = %s\n", palavra1);
	printf("Palavra2 = %s", palavra2);	
	
	int contador = 0;
	contador = verificadorString(palavra1,palavra2);
	printf(">> %i", contador);
}

int verificadorString(char *palavra1, char *palavra2){
	int tamanho1 = 5;
	int tamanho2 = 5;
	int verificador[tamanho1+1][tamanho2+1];
	
    // Atribuir ordem numérica resultante das palavras ao vetor de modo, respectivamente, "vertical" e "horizontal" 
    int i=0;
    while(i <= tamanho1){
    	verificador[i][0] = i++;
	}
	
	int j=0;
	while(j <= tamanho2){
		verificador[0][j] = j++;
	}
	
	//Verificação
	//int k=0;
	//int l=0;
	
	for(int i=1; i <= tamanho1; i++){
		for(int j=1; j <= tamanho2; j++){
			int custo = palavra2[j-1] == palavra1[i-1] ? 0 : 1;
			
			int menor1 = 0;
			if(verificador[i-1][j]+1<verificador[i][j-1]+1){
				menor1 = verificador[i-1][j]+1;
			}else{
				menor1 = verificador[i][j-1]+1;
			}
			
			int menor2 = 0;
			if(menor1<verificador[i-1][j-1]+custo){
				menor2 = menor1;
			}else{
				menor2 = verificador[i-1][j-1]+custo;
			}
			
			verificador[i][j] = menor2;
			printf("%i\n", verificador[i][j]);
		}
	}
    return verificador[tamanho1][tamanho2];
}

/*int minimo(int *valor1,int *valor2){
	if(valor1<valor2){
		return valor1;
	}else{
		return valor2;
	}
}*/
