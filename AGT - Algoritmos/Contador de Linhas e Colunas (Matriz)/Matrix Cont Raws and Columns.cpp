//Conta linhas e Colunas da estrutura matricial
#include <stdio.h>
#include <stdlib.h>

struct Nodo{
	int info;
	struct Nodo *acima;
	struct Nodo *dir;
	struct Nodo *abaixo;
	struct Nodo *esq;
};

struct dim{  
	int nlinhas; 
    int nColunas; 
};

struct dim contaLC(struct Nodo *p){
		if(p!=NULL){
		Nodo *aux_linha;
		Nodo *aux_coluna;
		
		aux_linha=p;
		aux_coluna=p;
		
		struct dim resultado;
 		
		int conta_linhas=0;
		int conta_colunas=0;

		while(aux_linha!=NULL){
			conta_linhas++;
			aux_linha=aux_linha->abaixo;
		}
		
		while(aux_coluna!=NULL){
			conta_colunas++;
			aux_coluna=aux_coluna->dir;
		}
	
		
		resultado.nColunas = conta_colunas;
		resultado.nlinhas = conta_linhas;	
		return resultado;
		}else{
			printf("Não existe matriz!\n");
		}
}; 
 
 int main(){
    struct Nodo aux1,aux2,aux3;
    aux1.abaixo = &aux2;
    aux1.dir = &aux3;
   
    aux2.abaixo = NULL;
    aux3.dir = NULL;
    struct dim resultado;
    resultado = contaLC(&aux1);
    printf("[%d,%d]",resultado.nlinhas,resultado.nColunas);
}
