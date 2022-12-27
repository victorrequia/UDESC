//Fgets serve pra ler a liha do aqruivo
//strtok()
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
//set locale

typedef struct{
	char *palavra;
	int ocorrencias;
	int qtd, *linhas;	
}Indice;


int main(){
	FILE *f = fopen("teste.txt", "rt");
	
	if (f==NULL){
	printf("Erro!\n");
	return -1;
	}
	
	Indice *v = NULL;
	int n, i, linha = 0;
	char buffer [1001], aux[1001];
	
	//while (fgets(buffer, 1001, f)!=NULL){
	while (fscanf(f, "%s", aux) == 1){
		linha ++;
		//while (sscanf(buffer, "%[a-zA-Z]", aux) == 1){ //nao funciona (usar strtok)		
		//while (sscanf(buffer, "%[a-zA-Z]", aux) == 1){ //nao funciona (usar strtok)	
		n++;
		v = (Indice*)realloc (v, sizeof(Indice)*n);
		v[n-1].palavra = (char*)malloc (strlen(aux)+1);
		strcpy (v[n-1].palavra, aux);
		v[n-1].ocorrencias = 1;
	
	
		v[n-1].qtd = 1;
		v[n-1].linhas = (int*)malloc(sizeof(int));
		v[n-1].linhas[0]=linha;
	}
	
	fclose (f);
	
	for (i=0; i<n; i++){
		printf("%d\n", i+1);
		printf("%s\n", v[i].palavra);
	}
}	
