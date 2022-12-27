#include <stdio.h>
#include <stdlib.h>

int main(){
	int X;
	float Y, cmedio;
	
	scanf("%i", &X);
	scanf("%f", &Y);
	
	cmedio = X/Y;
	
	printf("%.3f km/l\n", cmedio);
	
	return 0;
}
