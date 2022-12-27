//Exemplo2 Problema de ordenação com SELECTION SORT
//sizeof = da o tanto de byte que ocupa
#include <stdio.h>

int main(){
	int v[] = {12,99,3,4,-1,12,10,5};
	int i,n = sizeof (v)/sizeof (int); //pra saber quantos elementos possui 

for (i=0;i<n-1;i++){
	int i_menor = i,j;
	
	for (j=i+1;j<n;j++){
	if(v[j] < v[i_menor]){
			i_menor = j;
		}
	}
	
	int temp=v[i];
	v[i] = v[i_menor];
	v[i_menor] = temp;
		
}	


	for(i=0; i<n; i++)
		printf("%i : %i\n",i,v[i]);
	
	
	
	
}
