//Fechamento de Tags HTML
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define PILHA_MAX 100
typedef struct{
	int topo;
	char vetor[100][51];
}Pilha;


void Pilha_Inicia(Pilha *tags){
	tags->topo = -1;
}

int Pilha_Cheia(Pilha *tags){
	if(tags->topo == PILHA_MAX-1){ 		
		return 1; //Retorna 1 para pilha cheia
	}else{
		return 0; //Retorna 0 para pilha nao cheia
	}
}

int Pilha_Vazia(Pilha *tags){
	if(tags->topo == -1){ 
		return 1;	//Retorna 1 para Pilha vazia
	}else{
		return 0;   //Retorna 0 para pilha não vazia
	}
}

void Pilha_Push(char *elemento, Pilha *tags){
	if(Pilha_Cheia(tags) == 0){
		tags->topo++;
		strcpy(tags->vetor[tags->topo], elemento);
	}else{
		printf("Impossivel empilhar, a pilha esta cheia!\n");
	}
}

void Pilha_Pop(Pilha *tags){
	if(Pilha_Vazia(tags) == 0){
		tags->topo--;
	}else{
		printf("Impossivel desempilhar, a pilha esta vazia!\n");
	}
}

void Pilha_Erros(Pilha *tags, char *string){
	if(Pilha_Vazia(tags) == 0){
			printf("ERRO: Tag esperada %s tag recebida %s\n", tags->vetor[tags->topo], string);
}
}

int verifica(char *string){
	for(int i=0; i<strlen(string); i++){	
	if(string[i] == '<'){
		if((strcmp("<!DOCTYPE>", string) == 0) || (strcmp("<input>", string) == 0)
		|| (strcmp("<img>", string) == 0) || (strcmp("<frame>", string) == 0)
		|| (strcmp("<br>", string) == 0))
		{
			return 1;
		}
	}
	}

}

int main(int argc, char *argv[]){
	if(argc > 1){
		Pilha tag;
		Pilha_Inicia(&tag);
		
		char nome_arquivo[50];
		
		FILE *arquivo;
		
		if(arquivo != NULL){
		arquivo = fopen(argv[1], "r");
		int verificador = 0;
		char c;
		char string[50];
		
		while(!feof(arquivo)){
			if(verificador == 1)break;
			fscanf(arquivo, "%s", string);
					if(verifica(string) != 1){
					for(int i=0; i<=strlen(string+1);i++){
					if((string[i] == '<') && (string[i+1] == '/' && (string[strlen(string)-1] == '>'))){
						for(int j=i+1; j<strlen(string);j++)
						string[j] = string[j+1]; 
						if(strcmp(tag.vetor[tag.topo], string) == 0){
							Pilha_Pop(&tag);
						}else {
							Pilha_Erros(&tag, string);
							verificador = 1;
							break;
						}
					}else if(string[i] == '<'){
						Pilha_Push(string, &tag);
					}
		
				}	
					}
		}
		
		
			if(Pilha_Vazia(&tag) == 1){
				printf("\nTodas as tags foram fechadas corretamente!\n");
			}else if(Pilha_Vazia(&tag) == 0){
				printf("Existem elementos a serem fechados corretamente");
			}	
		}else{
			printf("Falha ao abrir aquivo!\n");
		}	
	}else{
		printf("Faltam argumentos!\n");
		printf("\"program\" \"nome_do_arquivo.txt\"");
	}
	
}

