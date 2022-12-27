//Metodo Secante
#include <stdio.h>

void secant(double (*f)(double), double x0, double x1, int n);

int main(){
	/*double f(double x){
		return x * x * x - 2;
	}
	
	double x0 = 1;
	double x1 = 2;
	int n = 10;
	
	secant(f, x0, x1, n);*/
	
	double f(double x){
		return pow(x,2) - 7;
	}
	
	double x0 = 2.32523;
	double x1 = 3.45973;
	int n = 5;
	
	secant(f, x0, x1, n);
}

void secant(double (*f)(double), double x0, double x1, int n){
	int i=0;
	
	for(i=0; i<n; i++){
		double denom = f(x1) - f(x0);
		if(denom == 0){
			printf("Divisao por zero na iteracao %d", i+1);	
			return;
		}
		double x2 = (x0 * f(x1) - x1 * f(x0)) / denom;
		printf("x_%d = %.16f\t", i+2, x2);
		printf("f(%i) = %f\n", i+2, f(x2));
		x0 = x1;
		x1 = x2;
	}

}
