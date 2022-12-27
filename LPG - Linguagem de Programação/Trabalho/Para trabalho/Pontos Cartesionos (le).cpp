//le arquivo
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
	float x, y;
}Ponto;

int main(){
	FILE *f = fopen ("pontos.txt", "rt");
	
	if (f == NULL){
		printf("Erro no arquivo!\n");
		return -1;
	}
	
	Ponto p;
	
	while (fscanf(f,"%f %f\n",  &p.x, &p.y)== 2){
		printf ("x = %.2f, y = %.2f\n", p.x, p.y);
	}
	
	fclose (f);
	return 0;
	


}



