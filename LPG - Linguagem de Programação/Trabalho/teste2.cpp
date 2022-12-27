#include <stdio.h>

int main(){
	int *p;
	int i;
	
	i = 5;
	
	p = &i;

	printf("%i", p[1]);
}
