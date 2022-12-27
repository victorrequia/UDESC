#include <stdio.h>
#include <stdlib.h>

int main(){
	int NUMBER, HOURS;
	double SALARYPH, SALARY;
	
	scanf("%i", &NUMBER);
	scanf("%i", &HOURS);
	scanf("%lf", &SALARYPH);
	
	SALARY = SALARYPH*HOURS;
	
	printf("NUMBER = %i\n", NUMBER);
	printf("SALARY = U$ %.2lf\n", SALARY);
	
	return 0;
}
