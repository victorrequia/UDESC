#include <stdio.h>
#include <stdlib.h>
#include <math.h>

//#define PI 3.14159

int main (){
	double raio, area, PI = 3.14159;
	
	scanf("%lf", &raio);
	
	area = PI*(pow(raio,2));
	
	printf("A=%.4lf\n", area);
	
	return 0;
}
