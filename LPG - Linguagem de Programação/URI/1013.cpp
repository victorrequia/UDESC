#include <stdio.h>
#include <stdlib.h>
#include <math.h>

int main(){
	int n1,n2,n3, m1, m2;
	
	scanf("%i", &n1);
	scanf("%i", &n2);
	scanf("%i", &n3);

	m1 = (n1+n2+abs(n1-n2))/2;
	m2 = (m1+n3+abs(m1-n3))/2;
	
	printf("%i eh o maior\n", m2);
	
	return 0;
}
