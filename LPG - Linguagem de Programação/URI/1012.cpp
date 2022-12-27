#include <stdio.h>
#include <stdlib.h>

int main (){
	double A,B,C;
	
	scanf("%lf %lf %lf", &A, &B, &C);

	printf("TRIAGULO: %.3lf\n", .5 *A*C);
	printf("CIRCULO: %.3lf\n", 3.14159*C*C);
	printf("TRAPEZIO: %.3lf\n", (A+B)*C/2.0);
	printf("QUADRADO: %.3lf\n", B*B);
	printf("RETANGULO: %.3lf\n", A*B);	
	
	return 0;
}
