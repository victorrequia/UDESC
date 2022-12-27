//Encontrar o menor valor do vetor (e índice)

#include <stdio.h>

/*int main(){
	int v[] = {12,7,8,6,3,20,-1,9};
	int n=8,i;
	int menor = v[0];
	int i_menor = 0;
	
	for (i=1; i<n; i++){
		if(v[i]<menor){
			menor = v[i];
			i_menor = i;
		}
	}

	printf("Menor = %i\n", menor);
	printf("no indice %i\n", i_menor);
}
*/

//outra forma
int main(){
	int v[] = {12,7,8,6,3,20,-1,9};
	int n=8,i;
	int i_menor = 0;
	
	for (i=1; i<n; i++){
		if(v[i]<v[i_menor]){
			i_menor = i;
		}
	}

	printf("Menor = %i\n", v[i_menor]);
	printf("no indice %i\n", i_menor);
}



