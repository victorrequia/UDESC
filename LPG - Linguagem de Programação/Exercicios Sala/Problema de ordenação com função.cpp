//Ex: ordenando utilizando função
#include <stdio.h>

void le_vetor (int*v, int n);
void mostra_vetor (int*v, int n);
void ordena_vetor (int*v, int n);


int main(){
	int vet[10];
	le_vetor (vet,10);
	mostra_vetor (vet,10);
	ordena_vetor (vet,10);
	mostra_vetor (vet,10);
	
	
	return 0;
}

void ordena_vetor (int v[], int n){
	int i; //printf("%i\n",sizeof(v));	
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
}

void mostra_vetor (int*v, int n){
	int i;
	for(i=0; i<n; i++)
		printf("%i : %i\n",i,v[i]);
}

void le_vetor (int*v, int n){
	int i;
	for (i=0; i<n; i++){
		printf("v[%i] = ", i);
	}
}




