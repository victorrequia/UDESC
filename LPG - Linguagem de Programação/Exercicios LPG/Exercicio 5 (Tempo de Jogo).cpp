#include <stdio.h>

int main(){
	int inicio, fim;
	int horas, tarde, tarde1;
	
	printf("Digite a hora de inicio e a de fim\n");
	scanf("%i %i", &inicio, &fim);
	
	if (inicio == fim)
		printf("Total de horas: 24");
	else{
	if (inicio < 12 && fim < 12){
		tarde = 24-inicio;
		horas = tarde + fim;
	if (horas > 24)
		horas = 24-horas;
		
	}
	
	if (inicio < 12 && fim >= 12){
		tarde = 24-fim;
		if (inicio > tarde)
		horas = inicio + tarde;
		else
		horas = tarde + inicio;
	}
	
	if (inicio >= 12 && fim < 12){
		tarde = 24-inicio;
		if (tarde > fim)
		horas = tarde + fim;
		else
		horas = fim + tarde;
	}

	if (fim >=  12 && fim >= 12){
		tarde = 24-inicio;
		tarde1 = 24-fim;
		if (tarde > tarde1)
		horas = tarde - tarde1;
		else
		horas = tarde1 - tarde;
	}
	
	printf("Total de horas: %i", horas);
		
	}

}
