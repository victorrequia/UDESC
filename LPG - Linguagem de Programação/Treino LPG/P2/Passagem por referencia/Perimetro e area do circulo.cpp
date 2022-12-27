#include <stdio.h>
#define pi 3.1415

void calcula_circulo (float raio, float *pPerimetro, float *pArea){
	*pPerimetro = 2*pi*raio;
	*pArea = pi*raio*raio;
	
	printf("O perimetro do circulo eh: %f\n", *pPerimetro);
	printf("A area do circulo eh: %f", *pArea);

}

int main(){
	float pPerimetro;
	float pArea;
	float raio;
	
	printf("Digite o raio da circunferencia\n");
	scanf("%f", &raio);
	
	calcula_circulo (raio, &pPerimetro, &pArea);
}
