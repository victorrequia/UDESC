#include <stdio.h>

int main(){
	int N;
	int minutos, horas;
	
	scanf("%i", &N);
	
	horas = N/3600;
	N = N-(horas*3600);
	
	minutos = N/60;
	N = N-(minutos*60);
	
	printf("%i:%i:%i\n", horas, minutos, N);	
	
	return 0;
}
