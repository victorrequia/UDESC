#include <stdio.h>
#include <stdlib.h>

/**
 * Dado um vetor de n�meros inteiros v de tamanho n e um n�mero k, retorne
 * verdadeiro se a soma de qualquer par de n�meros em v for igual a k.
 * Exemplo: dado v = [10,15,3,7] e k = 17, a sa�da deve ser true, pois 10 + 7 � 17.
 */
int soma(int vetor[], int tamanho, int soma) {
    for (int i = 0; i < tamanho - 1; i++) { //AN - 1
        for (int j = i + 1; j < tamanho; j++) { 
            if (vetor[i] + vetor[j] == soma) {
                return 1;
            }
        }
    }
    
    return 0;
}

int main() {
    int vetor[4] = {10,15,3,7};
    int tamanho = sizeof(vetor) / sizeof(vetor[0]);

    printf("%s\n",soma(vetor,tamanho,17) ? "true" : "false");
}
