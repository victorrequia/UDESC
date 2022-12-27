//Newton
#include <stdio.h>
#include <math.h>

int main(){
	double f1(double x, double y){
		return 4*pow(x,2) + pow(y,2) - 5;
	}
	
	double f2(double x, double y){
		return pow(x,2) + pow(y,3) - 4;
	}
	
	double f1x(double x, double y){
		return 8*x;
	}
	
	double f1y(double x, double y){
		return 2*y;
	}
	
	double f2x(double x, double y){
		return 2*x;
	}
	
	double f2y(double x, double y){
		return 3*pow(y,2);
	}
	
	double x0 = 0.9176;
	double y0 = 1.8942;

	int n = 4;
	
	//Não alterar a partir daqui para sistemas 2x2
	double det(double x, double y){
		//det da matriz jacobiana de F
		return f1x(x,y) * f2y(x,y) - f1y(x,y) * f2x(x,y);
	}
	
	double eq1(double x, double y){
		return x - (1 / det(x,y)) * (f2y(x,y) * f1(x,y) - f1y(x,y) * f2(x,y));
	}
	
	double eq2(double x, double y){
		return y - (1 / det(x,y)) * (-f2x(x,y) * f1(x,y) + f1x(x,y) * f2(x,y));
	}
	
	int i=0;
	for(i=0; i<n; i++){
		double x1 = eq1(x0,y0);
		double y1 = eq2(x0,y0);
		printf("x_%d = %.16f\t y_%d = %.16f\n", i+1, x1, i+1, y1);
		x0 = x1;
		y0 = y1;
	}
}
