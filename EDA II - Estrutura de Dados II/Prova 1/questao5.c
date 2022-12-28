// Dado um conjunto de N números inteiros representando o tamanho de luvas,
//faça um programa para contar o máximo possível de pares de luvas existentes no conjunto.
//Note que uma luva só pode ser par de outra luva do mesmo tamanho e só pode fazer parte de um único par.
//Exemplo: entrada = {6, 5, 2, 3, 5, 2, 2, 1}, saída = 2 pares (tamanho 5 e tamanho 2).

#include <stdio.h>
#include <stdlib.h>

 void contaPares(int *luvas, int n){

    if (n == 0){
        printf("Array vazio.");
        break;
    }

    int *luvasaux[0];
    int *count[n];

    for(int i = 0; i < n; i++){
        if(count[luvas[i]] > 0){
            
        }
    }


    printf("%d pares (", n);
    for (int i = 0; i < n; i++) printf("tamanho %d ", &luvas[i]);
    printf(")");
 }

void main(){
    int n = 0;

    printf("Digite o número de luvas a ser avaliado: ");
    scanf("%d", &n);
    int *luvas = malloc(n * sizeof(int));

    printf("Digite os números das luvas: ");
    for (int i = 0; i < n; i++) scanf("%d", &luvas[i]);
    for (int i = 0; i < n; i++) printf("%d", luvas[i]);
    //contaPares(*luvas);

    contaPares(*luvas, n);

}
