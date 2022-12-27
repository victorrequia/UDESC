#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

void doces(int escolha){
	if (escolha == 1){
		printf("\nVoce escolheu choco. Voce ganhou uma sanduicheira\n");
	}
		if (escolha == 2){
		printf("\nVoce escolheu bala\n");
	}
		if (escolha == 3){
		printf("\nVoce escolheu danoninho\n");
	}
	
}


float calcular_media (float n1, float n2){
	float media;
	
	media = (n1+n2)/2;
	
	return media;
}

int main(){
	float m,a,b;
	int doce;
	
	
	printf("escolha o seu doce\n1:chocolate\n2:balinha\n3:danoninho\n");
	scanf("%i", &doce);
	doces(doce);

	printf("Digite 2 numeros\n");
	scanf("%f %f", &a, &b);
	
	m = calcular_media (a,b);
	
	printf("%f", m);
	
	m = calcular_media (5,7);
	
	printf("\n%f", m);
	return 0;
}


