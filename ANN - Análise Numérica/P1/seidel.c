//Seidel
#include <stdio.h>

#define ROWS 3
#define COLS 3

void seidel(double a[ROWS][COLS], double b[COLS], double chute[COLS], int n);

int main(){
	double a[ROWS][COLS] = 	{ {5.37792, -3.51176, 0.14537}, {0.00139, -2.00221, 0.28004}, {3.24219, 0.77253, -5.7355} };
	double b[ROWS] = {-4.87395, -3.92464, -4.62331};
	
	double chute[COLS] = {-1.50803, -2.33983, 3.60872};
	
	int n = 18;
	
	seidel(a,b,chute,n);
}

void seidel(double a[ROWS][COLS], double b[COLS], double chute[COLS], int n){
	int i,j,it=0;
	for(it=0; it<n; it++){
		for(i=0; i<ROWS; i++){
			double xi = b[i];
			for(j=0; j<COLS; j++){
				if(i != j){
					xi -= a[i][j] * chute[j];
				}
			}
			xi /= a[i][i];
			chute[i] = xi;
		}
		printf("X^(%d) -> ", it+1);
		int k=0;
		for(k=0; k<COLS; k++){
			printf("%.10f\t", chute[k]);
		}
		printf("\n");
	}
}
