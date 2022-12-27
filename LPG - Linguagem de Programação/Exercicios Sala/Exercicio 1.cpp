#include <stdio.h>

int main(){
	/*int x,y;
	int i;
	int result_pot;
	
	printf("Digite x e y\n");
	scanf("%i %i", &x,&y);
	
	for(i=y;i>0;i--){
		x = x*i;
	}
	
	printf("O resultado eh %i", x);
	*/
	
	
	float base,base2;
	int expo,i,expo2,negativo=0;
	scanf("%f %d", &base, &expo);
	
	if( expo <0){
		base2=base;	base=1/base;
		expo2=expo;	expo=-expo; negativo=1;
	}
	
	float pot = 1;
	for (i=1;i<=expo;i++){
		pot*=base;
	}
	
		
	if (negativo){
		base=base2;
		expo=expo2;
	}	
		

	printf("%.2f elevado a %d = %.2f \n", base,expo,pot);

}


	

