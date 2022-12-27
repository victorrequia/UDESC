//Jacobi
#include <stdio.h>

#define ROWS 3
#define COLS 3

void jacobi(double a[ROWS][COLS], double b[COLS], double chute[COLS], int n);

int main(){
	double a[ROWS][COLS] = 	{ {-5.58574, 2.303, -1.28452}, {1.5548, 5.5827, 2.02969}, {-1.16822, 1.38188, 4.54833} };
	double b[ROWS] = {-2.11978, -4.58271, -4.02957};
	
	double chute[COLS] = {1.25834, -4.48144, -4.51524};
	
	int n = 18;
	
	jacobi(a,b,chute,n);
}

void jacobi(double a[ROWS][COLS], double b[COLS], double chute[COLS], int n){
	int i,j,it=0;
	for(it=0; it<n; it++){
		double temp[COLS]; 
		for(i=0; i<ROWS; i++){
			double xi = b[i];
			for(j=0; j<COLS; j++){
				if(i != j){
					xi -= a[i][j] * chute[j];
				}
			}
			xi /= a[i][i];
			temp[i] = xi;
		}
		printf("X^(%d) -> ", it+1);
		int k=0;
		for(k=0; k<COLS; k++){
			chute[k] = temp[k];
			printf("%.10f\t", chute[k]);
		}
		printf("\n");
	}
}
