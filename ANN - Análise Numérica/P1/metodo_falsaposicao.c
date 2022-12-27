//metodo da posição falsa
#include<stdio.h>

void fpos(double (*f)(double), double a, double b, int n);

int main(){
	/*double f(double x){
		return x * x - 2.0;
	}
	double a = 1.0;
	double b = 2.0;
	int n = 10;
	
	fpos(f, a, b, n);*/
	
	double f(double x){
		return 2*(x+1) * (x-0.5) * (x-1);
	}
	double a = 0.6514;
	double b = 1.3433;
	int n = 5;
	
	fpos(f, a, b, n);
}

void fpos(double (*f)(double), double a, double b, int n){
	int i = 0;
	double fa = f(a);
	double fb = f(b);
	
	if(fa * fb >= 0){
		printf("Nao sei dizer se f possui raiz no intervalo [%f,%f]", a, b);
		return;
	}else{
		for(i=0; i<n; i++){
			double x = (a*fb - b * fa)/(fb - fa);
			printf("x_%d = %.16f\t", i+1, x);
			printf("f(%d) = %.16f\n", i+1, f(x));
			double fx = f(x);
			if(fx == 0){
				printf("A raiz procurada e: x = %.16f", x);
				return;
			}
			if(fa*fx < 0){
				b = x;
				fb = fx;
			}else{
				a = x;
				fa = fx;
			}
		}	
	}
}
