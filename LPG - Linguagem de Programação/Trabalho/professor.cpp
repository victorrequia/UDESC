#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct{
    char *palavra;
    int ocorrencias;
    int qtd, *linhas;
}Indice;

int eh_letra(char c);
char **separa_palavras(char *s);


int main(){
  FILE *f=fopen("teste.txt","rt");
  if(f==NULL){
    printf("Erro!\n");
    return -1;
  }
  
  Indice *v = NULL;

  int n=0,i,linha=0;
  char buffer[1001],aux[1001];
  
  while(fgets(buffer,1001,f)!=NULL){
    linha++;
    // Recupera uma lista de palavras da cada linha:
    char **lista = separa_palavras(buffer);
    // Percorre a lista de palavras:
    for(i=0; lista[i] != NULL; i++){
      // Aqui é preciso testar se a palavra atual ( lista[i] ) já se encontra no índice...
      // Em caso positivo, será preciso atualizar os seus dados (ocorrências e linhas... possivelmente com realocação).
      
      // Caso contrário, cria-se uma nova entrada no índice, realocando, conforme abaixo:      
      n++;
      v=realloc(v,sizeof(Indice)*n);
      // Depois, os dados da palavra são inseridos na nova entrada do índice:
      v[n-1].palavra = lista[i];
      v[n-1].ocorrencias = 1;
      v[n-1].qtd = 1;
      v[n-1].linhas = malloc(sizeof(int));
      v[n-1].linhas[0] = linha;      
    }     
    free(lista); // libera a memória da lista de palavras, para que seja alocada novamente na p´roxima iteração.
  }
  
  fclose(f);
  
  // TO DO: ordenar o vetor do índice.
  
  // TO DO: salvar num arquivo...
  for(i=0;i<n;i++){
    printf("\n- Entrada %d\n",i+1);
    printf("  - palavra: %s\n",v[i].palavra);
    printf("  - linha: %d\n",v[i].linhas[0]);
  }
  
  // Desalocando o índice:
  for(i=0;i<n;i++){
    free(v[i].palavra);
    free(v[i].linhas);
  }
  free(v);
  
  system("PAUSE");

  return 0;
}


char **separa_palavras(char *s){
   char **p = malloc(sizeof(char*));
   int cont = 0, i = 0, inicio;
   while(s[i] != '\0'){
      while(s[i] != '\0' && !eh_letra(s[i]))
         i++;
      if(s[i] != '\0'){
         inicio = i;
         while(eh_letra(s[i]))
            i++;
         
         p[cont] = malloc(sizeof(char)*(i-inicio+1));
         
         int j, k = 0;
         for(j=inicio; j<i; j++){
            p[cont][k] = s[j];
            k++;
		 }
         p[cont][k] = '\0';
         
         cont++;
         p = realloc(p, sizeof(char*)*(cont+1));         
	  }
   }
   p[cont] = NULL;
   return p;
}


int eh_letra(char c){
   return c >= 'a' && c<= 'z' || c >= 'A' && c<= 'Z';
   // Falta incluir caracteres com acentuação e cedilha...
}



