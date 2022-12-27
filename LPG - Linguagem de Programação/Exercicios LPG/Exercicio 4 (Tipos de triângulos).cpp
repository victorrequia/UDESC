//Tipos de Tringulos
#include <stdio.h>

int main(){
	float a, b, c;
	float x;
	
	printf("Digite os lados do triangulo\n");
	scanf("%f %f %f", &a, &b, &c);
	
	if (b > a & b > c){
		x = a;a = b;b = x;
	}
	
	if (c > a & c > b){
		x = a;
		a = c;
		c = x;
	}
	
	
	if (a >= b + c)
		printf("Nao forma triangulo");
	else
	if (a*a == b*b + c*c)
		printf("Triangulo Retangulo");
	else
	if (a*a > b*b + c*c)
	printf("Triangulo obtusangulo");
	else
	if (a*a < b*b + c*c)
	printf("Triangulo acutangulo");
	else
	printf("Triangulo isoceles");
	
	
	
	printf("\n%f %f %f", a, b ,c);	
}
