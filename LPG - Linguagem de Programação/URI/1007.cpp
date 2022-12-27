#include <stdio.h>
#include <stdlib.h>

int main(){
	int A,B,C,D,DIFERENCA;
	
	scanf("%i", &A);
	scanf("%i", &B);
	scanf("%i", &C);
	scanf("%i", &D);
	
	DIFERENCA = (A*B - C*D);
	
	printf("DIFERENCA = %i\n", DIFERENCA);	
	
	return 0;
}
