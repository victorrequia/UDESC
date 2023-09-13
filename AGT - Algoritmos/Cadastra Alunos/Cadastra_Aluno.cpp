//Cadastrar aluno
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define MAX_ALUNOS 50

typedef struct{
	char nome[50];
	float notas[4];
	int ativo;
}Aluno;
Aluno alunos[MAX_ALUNOS];

void menu();
void cadastrar();
void remover();
void pesquisar();
void listar();
void aprovados();


int main(int argc, char const *argv[]){
	menu();
	return 0;	
}

void menu(){
	int op;
	do{
		system("cls");
		printf("\n-----MENU------\n");
		printf("1 CADASTRAR\n");
		printf("2 REMOVER\n");
		printf("3 PESQUISAR\n");
		printf("4 LISTAR\n");
		printf("5 APROVADOS\n");
		printf("0 SAIR\n");
		printf("---------------\n");
		scanf("%i", &op);
		
		switch (op){
			case 1:
				cadastrar();
			break;
			case 2:
				remover();
			break;
			case 3:
				pesquisar();
			break;
			case 4:
				listar();
			break;
			case 5:
				aprovados();
			break;
			case 0:
				system("exit");
			break;
			default: 
				printf("Opcao invalida\n");
				system("pause");
				menu();
			break;
		}
		
	}while(op!=0);
}

void cadastrar(){
	char nomes[50];
	float notas[4];
	int op;
	do{
		system("cls");
		printf("NOME: ");
		scanf("%s", nomes);
		printf("1 Bimestre: ");
		scanf("%f", &notas[0]);
		printf("2 Bimestre: ");
		scanf("%f", &notas[1]);
		printf("3 Bimestre: ");
		scanf("%f", &notas[2]);
		printf("4 Bimestre: ");
		scanf("%f", &notas[3]);
		for(int i=0; i<MAX_ALUNOS; i++){
			if(alunos[i].ativo == 0){
				alunos[i].notas[0] = notas[0];
				alunos[i].notas[1] = notas[1];
				alunos[i].notas[2] = notas[2];
				alunos[i].notas[3] = notas[3];
				strcpy(alunos[i].nome, nomes);
				alunos[i].ativo = 1;
				break;
			}
		}
		printf("Aluno cadastrado com sucesso!\n");
		printf("Deseja cadastrar mais aluno(s)? (1)sim\n");
		scanf("%d", &op);
		getchar();
	}while(op==1);
	
}

void aprovados(){
	int media;
	system("cls");
	printf("--------APROVADOS---------\n");
	for(int i=0; i<MAX_ALUNOS; i++){
		media = (alunos[i].notas[0]+alunos[i].notas[1]+alunos[i].notas[2]+alunos[i].notas[3])/4;
		if (media >= 7){
			printf("\n%s\n\n", alunos[i].nome);
			printf("1 Bimestre: %.2f\n",alunos[i].notas[0]);	
			printf("2 Bimestre: %.2f\n",alunos[i].notas[1]);
			printf("3 Bimestre: %.2f\n",alunos[i].notas[2]);
			printf("4 Bimestre: %.2f\n",alunos[i].notas[3]);
			printf("---------------------------------\n");
			
		}
	}
	system("pause");
}

void remover(){
	int matricula;
	int op;
	do{
		listar();
		printf("Digite o numero da matricula a ser cancelada: ");
		scanf("%i", &matricula);
		--matricula;
		alunos[matricula].ativo = 0;
		printf("Matrciula cancelada com sucesso!\n");
		printf("Deseja realizar outra operacao? (1)sim\n");
		scanf("%i", &op);
	}while(op==1);
}

void pesquisar(){
	char nome[50];
	int op;
	
	do{
		system("cls");
		printf("Digite o nome do aluno: ");
		scanf("%s", nome);
		for(int i=0; i<MAX_ALUNOS; i++){
			if(strstr(alunos[i].nome, nome) != NULL){
					printf("\nMatricula: %d\n", i+1);
					printf("Nome: %s\n", alunos[i].nome);
					printf("\n1 Bim %0.2f\n", alunos[i].notas[0]);
					printf("2 Bim %0.2f\n", alunos[i].notas[1]);
					printf("3 Bim %0.2f\n", alunos[i].notas[2]);
					printf("4 Bim %0.2f\n", alunos[i].notas[3]);
					printf("-------------\n");
					printf("\nDeseja realizar nova buscar (1)sim\n");
					scanf("%i", &op);
			}
		}		
	}while(op==1);
	
}

void listar(){
	system("cls");
	for(int i=0;i<MAX_ALUNOS;i++){
		if(alunos[i].ativo == 1){
			printf("--------------------------------\n");
			printf("MATRICULA %i\n", i+1);
			printf("%s\n\n", alunos[i].nome);
			printf("1 Bimestre: %.2f\n",alunos[i].notas[0]);	
			printf("2 Bimestre: %.2f\n",alunos[i].notas[1]);
			printf("3 Bimestre: %.2f\n",alunos[i].notas[2]);
			printf("4 Bimestre: %.2f\n",alunos[i].notas[3]);
			printf("---------------------------------\n");
		}
	}
	getchar();
	getchar();
}
