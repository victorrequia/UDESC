#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
	float x,y;
}Ponto;


int main(){
	FILE *f = fopen ("pontos.txt", "rt");
	
	if (f == NULL){
		printf("Erro no arquivo!\n");
		return -1;
	}
	
Ponto *v = NULL;
Ponto aux;
int n=0, i;

while (fscanf(f, "%f %f\n", &aux.x, &aux.y)==2){
	n++;
	v = (Ponto*)realloc(v, sizeof(Ponto)*n);
	v [n-1]= aux;
}

fclose (f);
	
for (i=0; i<n; i++){
	printf("Ponto %d\n", i+1);
	printf("x=%f\ny=%f\n", v[i].x, v[i].y);
}
	
free (v);
}
