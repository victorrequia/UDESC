//Prototipo trabalho
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){


FILE *f = fopen ("palavras.txt", "rt");

if (f==NULL){
	return -1;
}


char str [1001];

while (fscanf(f, "%s", str) == 1){
	printf("%s\n", str);
}

fclose (f);
}
