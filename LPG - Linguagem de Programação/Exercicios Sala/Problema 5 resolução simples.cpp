#include <stdio.h>

int main(){
/*	float x,e_x=0,num=1;
	int n,i,den=1;
	
	scanf("%f %i", &x, &n);
	
	for (i=0; i<=n; i++){
		e_x += num/den;
		num*=x;
		den*=(i+1);
	}
	
	printf("e elevado a %.2f = %.2f\n", x, e_x);
	
	//1/1 + x/1 + xx/1.2 + xxx/1.2.3 + ...
}
*/

//Ultima versão
float x, e_x=0, termo=1;
int n,i;

scanf("%f %i", &x, &n);

for (i=0; i<=n; i++){
	e_x += termo;
	termo *= x/(i+1);
}

printf("e elevado a %.2f = %.8f \n", x, e_x);

//1/1 . x/1 . x/2 . x/3 . ...

}



