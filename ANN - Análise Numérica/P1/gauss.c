//Eliminacao Gausiana - (Não é exatamente um metodo exato)
#include <stdio.h>

#define ROWS 4
#define COLS 5

void print_matriz(double m[ROWS][COLS]);

void gauss(double m[ROWS][COLS]){
	printf("\n\n");
	int j=0;
	for(j=0; j<ROWS-1; j++){
		int p=0;
		for(p=j; p<ROWS; p++){
			if (m[p][j] != 0){
				if(p != j){
					//Troque as linhas p e j
					double temp = 0;
					int k = 0;
					for(k=0; k<COLS; k++){
						temp = m[j][k];
						m[j][k] = m[p][k];
						m[p][k] = temp;
					}
				}
				//a_ij * Lj + Li -> Li
				int i=0;
				for(i=j+1; i<ROWS; i++){
					double a = 0;
					a = -m[i][j] / m[j][j];
					int q=0;
					for(q=0; q<COLS; q++){
						m[i][q] = a * m[j][q] + m[i][q];
					}
				}
			}
		}
		print_matriz(m);
		printf("\n\n");
	}
}

int main(){
	double m[ROWS][COLS] = { {1,2,3,1,2}, {1,5,3,1,4}, {2,4,-1,1,2}, {4,3,1,2,5} };
	
	print_matriz(m);
	gauss(m);
}

void print_matriz(double m[ROWS][COLS]){
	int i,j=0;
	for(i=0; i<ROWS; i++){
		for(j=0; j<COLS; j++){
			printf("%.8f\t", m[i][j]);
		}
		printf("\n");
	}
}
