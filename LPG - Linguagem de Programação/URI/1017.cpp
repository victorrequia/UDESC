#include <stdio.h>
#include <stdlib.h>

int main(){
	int horas, vmedia;
	float gasto,kmrodados;
	
	scanf("%i", &horas);
	scanf("%i", &vmedia);
	
	kmrodados = horas*vmedia;
	gasto = kmrodados/12;
	
	printf("%.3f\n", gasto);
	
	return 0;
}
