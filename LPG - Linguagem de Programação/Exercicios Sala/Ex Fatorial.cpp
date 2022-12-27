//RECURSIVIDADE
//EX Fatorial
#include <stdio.h>


int fat (int x){
	if(x==0)
		return 1;
	else{
		return x*fat(x-1);
	}
}
	

int main(){
	int n;
	scanf("%i", &n);
	printf("%i!%i\n", n, fat(n));
	return 0;
}
