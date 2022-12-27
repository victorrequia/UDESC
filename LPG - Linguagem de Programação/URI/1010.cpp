#include <stdio.h>
#include <stdlib.h>

int main(){
	int npeca1,npeca2, qpeca1, qpeca2;
	float preco1,preco2, tpagar;
	
	scanf("%i %i %f", &npeca1, &qpeca1, &preco1);
	scanf("%i %i %f", &npeca2, &qpeca2, &preco2);
	
	tpagar = (preco1*qpeca1) + (preco2*qpeca2);
	
	printf("VALOR A PAGAR: R$ %.2f\n", tpagar);

	return 0;
}
