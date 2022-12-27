#include <stdio.h>

float potencia(float b, int e){
	float p;
	int i;
	
	for(i=1;i<=e;i++){
		p*=i;
	}
	
return p;
}


int main(){
	float base,pot;
	int expo;
	scanf("%f %d", &base, &expo);
	
	if (expo<0){
		pot = potencia(1/base, -expo);
	}
	else{
		pot = potencia (base,expo);
	}
	
	printf("%.2f elevado a %d = %.2f\n", base,expo,pot);
	
}
