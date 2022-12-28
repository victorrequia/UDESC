#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * Run-length encoding (RLE) � uma forma simples de compress�o de textos. A
 * ideia desta t�cnica � representar caracteres repetidos sucessivamente com um
 * contador seguido pelo caractere. Dada uma string, retorne o texto resultante
 * da aplica��o da t�cnica RLE.
 * Exemplo, dada a string "AAAABBBCCDAA", a sa�da compactada deve ser "4A3B2C1D2A"
 */

char* rle(char* s) {
   	char *r = malloc(sizeof(char) * 50);

    char u = s[0];
    int c = 1;
    int i = 0;

    int tamanho = strlen(s);
    
    for (int j = 1; j < tamanho; j++) {
        if (s[j] == u) {
            c++;
        } else {
            char cc[50];
            sprintf(cc, "%d", c);

            int num = strlen(cc);

            for (int k = 0; k < num; k++) {
                r[i++] = cc[k];
            }
            
            r[i++] = u;
            
            u = s[j];
            c = 1;
        }
    }

    char cc[50];
    sprintf(cc, "%d", c);

    int num = strlen(cc);

    for (int k = 0; k < num; k++) {
        r[i++] = cc[k];
    }
    
    r[i++] = u;
 
    return r;
}

int main() {
	char* s = "AAAABBBCCDAA";
	
    printf("%s\n",s);
    printf("%s\n",rle(s));
}
