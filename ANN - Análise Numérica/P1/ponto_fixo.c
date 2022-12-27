//Metodo do ponto fixo
#include <stdio.h>

void fixed_point(double (*f)(double), double x0, int n);

int main(){
	double g1(double x){
		return (x*x - 1.0) / 3.0;
	}
	
	double x0 = 0.56;
	
	double g2(double x){
		return x / 2.0 + 1 / x;
	}
	
	double y0 = 1.78;
	
	int n = 10;
	
	fixed_point(g1, x0, n);
}

void fixed_point(double (*f)(double), double x0, int n){
	int i=0;
	for(i=0; i<n; i++){
		double x1 = f(x0);
		printf("x_%d = %.16f\tf(%i) = %.16f\n", i+1, x1, x1, f(x1));
		x0 = x1;
	}
}
