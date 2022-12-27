//Metodo Newton
#include <stdio.h>
#include <math.h>

void newton(double (*f)(double), double (*df)(double), double x0, int n);

int main(){
	/*//Função
	double f(double x){
		return x * x * x - 2;
	}
	//Derivada da função
	double df(double x){
		return 3 * x * x;	
	}
	double x0 = 1;
	int n = 8;
	
	//newton(f, df,x0, n);
	
	double g(double x){
		return pow(x, 10) - 1;
	}
	
	double dg(double x){
		return 10 * pow(x, 9);
	}

	double x1 = 0.5;
	
	newton(g, dg, x1, 50);*/
	
	double f(double x){
		return pow(x,2) - 2;
	}
	//Derivada da função
	double df(double x){
		return 2*x;
	}
	
	double x0 = -2.01723;
	int n = 5;
	
	newton(f, df,x0, n);
	
}

void newton(double (*f)(double), double (*df)(double), double x0, int n){
	int i=0;
	for(i=0; i<n; i++){
		double dfx0 = df(x0);
		if(dfx0 == 0){
			printf("Divisao por zero. Nao foi possivel executar a iteracao %d do metodo de Newton", i+1);
			return;
		}else{
			x0 = x0 - f(x0)/dfx0;
			printf("x_%d = %.16f\t", i + 1, x0);
			printf("f(%i) = %.16f\n", i + 1, f(x0));
		}
	}
}
