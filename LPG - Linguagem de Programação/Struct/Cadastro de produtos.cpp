#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct produtos{
	int codigo;
	char descricao [50];
	float preco;
	char raridade [50];
};


int main(){
	char animal[50];
	int i;
	
	struct produtos rat, hydra, demon;
	
	//Desenvolvendo STRUCT
	rat.codigo = 207;
	strcpy (rat.descricao, "little and easy to kill");
	rat.preco = 5;
	strcpy (rat.raridade, "Common");
	
	hydra.codigo = 509;
	strcpy (hydra.descricao, "A dangerous and heavy animal");
	hydra.preco = 208.7;
	strcpy (hydra.raridade, "Rare");
	
	demon.codigo = 1097;
	strcpy (demon.descricao, "Pray for him not to kill you");
	demon.preco = 509;
	strcpy (demon.raridade, "Very Rare");
	//
	
	printf("Digite o animal para saber suas caracteristicas:\n");
	scanf("%s", &animal);
	
	char nomerat [30] = "rat";
	char nomehydra [30] = "hydra";
	char nomedemon [30] = "demon";  

	
	if (strcmp (animal, "rat") == 0){
			printf("Codigo %i\n", rat.codigo);
			printf("Descricao %s\n", rat.descricao);
			printf("Preco %f\n", rat.preco);
			printf("Raridade %s\n", rat.raridade);
	}		
	
	

	
	
}
