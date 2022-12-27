#include <stdio.h>

void calcula_hora (int totalminutos, int *ph, int *pm){
	*ph = totalminutos/60;
	*pm = totalminutos%60;
	printf("Se passou %i horas\n", *ph);
	printf("E %i minutos\n", *pm);
	return;
}

int main(){
	int totalminutos;
	int ph, pm;
	
	printf("Digite o total de minutos passados\n");
	scanf("%i", &totalminutos);
	
	calcula_hora (totalminutos, &ph, &pm);
	
}
