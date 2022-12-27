//Metodo Bisseção
#include <stdio.h>
#include <math.h>

void bissection(double (*f)(double), double a, double b, int n);

int main(){
	/*double f(double x){
		return x*x*x - 2;
	}
	
	double a = 0; //Inicio Intervalo
	double b = 2; //Final intervalo
	int n = 70; //Numero de interações

	bissection(f, a, b, n);
	
	double g(double k){
		return 1000000.0 * exp(k) + (537142.0 / k) * (exp(k) - 1.0) - 1863961.0;
	}
	
	double a2 = 0.001;
	double b2 = 2;
	int m = 20;
	
	//bissection(g, a2, b2, m);*/
	
	/*double f(double x){
		return x * x - 3;
	}
	
	double a = -2.31337;
	double b = -0.82266;
	
	int n = 5;
	
	bissection(f, a, b, n);*/
	
	double f(double t){
		double n = 114247547;
		double delta = 1.41*pow(10,-10);
		
		return (n+1)/(1+n*exp(-delta*(n+1)*t));
	}
	
	double a = 0;
	double b = 2304;
	
	int n = 15;
	
	bissection(f, a, b, n);
}

void bissection(double (*f)(double), double a, double b, int n){
	double fa = f(a);
	
	if (fa * f(b) >= 0){
		printf("Nao sei dizer se f possui raiz no intervalo [%f, %f]", a,b);
		return;
	}else{
		double m=0;
		int i=0;
		for(i=0; i<n; i++){
			m = 0.5 * (a + b);
			double fm = f(m);
			printf("x_%d = %.16f\t f(%i)%.16f\n", i+1, m, i+1, fm);
			if(fm == 0){
				printf("%f e uma raiz", m);
				return;
			}
			if(fa * fm < 0){
				b = m;
			}else{ 
				a = m;
				fa = fm;
			}
		}
	}
}
