#include <stdio.h>
#include <stdlib.h>

int main(){
	char nome[10];
	double salario, vendas, salario_f;
	
	scanf("%s", &nome);
	scanf("%lf", &salario);
	scanf("%lf", &vendas);
	
	salario_f = salario + (vendas*0.15);
	
	printf("TOTAL = R$ %.2lf\n", salario_f);
	
	return 0;
}
