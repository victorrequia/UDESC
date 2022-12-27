// Nome Do Arquivo: quick.c
// File Name: quick.c
//
// Descri��o: Implementa��o do algoritmo quicksort
// Description: Quick sort Algorithm
//================================================================
 
// Libs
#include <stdio.h>
#include <stdlib.h>
 
// Define uma constante
// Define a constant
#define MAX 10
 
// Prot�tipo da fun��o de ordena��o
// Ordination function prototype
void quick_sort(int *a, int left, int right);
 
// Fun��o main
// Main Function
int main(int argc, char** argv)
{
 int i, vet[MAX];
 
 // L� MAX ou 10 valores
 // Read MAX or 10 values
 for(i = 0; i < MAX; i++)
 {
  printf("Digite um valor: ");
  scanf("%d", &vet[i]);
 }
 
 // Ordena os valores
 // Order values
 quick_sort(vet, 0, MAX - 1);
 
 // Imprime os valores ordenados
 // Print values in order ascendant
 printf("\nnValores ordenados\n");
 for(i = 0; i < MAX; i++)
 {
  printf("%d\n", vet[i]);
 }
 system("pause");
 return 0;
}
 
// Fun��o de Ordena��o por Sele��o
// Quick sort function
void quick_sort(int *a, int left, int right) {
    int i, j, x, y;
     
    i = left;
    j = right;
    x = a[(left + right) / 2];
     
    while(i <= j) {
        while(a[i] < x && i < right) {
            i++;
        }
        while(a[j] > x && j > left) {
            j--;
        }
        if(i <= j) {
            y = a[i];
            a[i] = a[j];
            a[j] = y;
            i++;
            j--;
        }
    }
     
    if(j > left) {
        quick_sort(a, left, j);
    }
    if(i < right) {
        quick_sort(a, i, right);
    }
}

