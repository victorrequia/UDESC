//1 - Coordenadas de um Plano

#include <stdio.h>

int main(){
	float x, y;
	
	printf ("Digite as coordenadas x e y respectivamente:\n");
	scanf ("%f %f", &x, &y);
	
	if (x==0 & y==0)
		printf("Origem");
	else
	if (y==0 & x!=0)
		printf("Eixo y");
	else
	if (y!=0 & x==0)
		printf("Eixo x");
	else
	if (x<0){
		if (y<0)
		printf("3ro quadrante");
		else
		printf("2do quadrante");
	}
	else
	if (x>0){
		if (y>0)
		printf("1ro quadrante");
		else
		printf("4to quadrante");
	}
}
