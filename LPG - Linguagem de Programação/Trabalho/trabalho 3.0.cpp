#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include <ctype.h>
#include <locale.h>

typedef struct{
    char *palavra;
    int ocorrencias;
    int qtd, *linhas;
}Indice;

int eh_letra(char c);
char **separa_palavras(char *s);
int j,k;
char ordena (char palavra);


int main(){
	setlocale (LC_ALL, "Portuguese");	
	
	char string[100];
	scanf ("%s", string);
  	FILE *f=fopen(string,"rt");
  		
 	if(f==NULL){
    printf("Erro!\n");
	return -1;
 	}
	 		
  Indice *v = NULL;

  int n=0,i,linha=0;
  char buffer[1001],aux[1001];
  
  while(fgets(buffer,1001,f)!= NULL){
    linha++;
    // Recupera uma lista de palavras de cada linha:
    char **lista = separa_palavras(buffer);
    // Percorre a lista de palavras:
    for(i=0; lista[i] != NULL; i++){
      // Aqui √© preciso testar se a palavra atual ( lista[i] ) j√° se encontra no √≠ndice...
      //MODIFICADO:
      //for (j=1; lista[j] != NULL; j++){
      //	if (strcmp(lista[j], Indice.palavra)==0){
      //		printf("Essa palavra ja se encontra");
	  //	  }
	  
	  
      
      
      
      // Em caso positivo, ser√° preciso atualizar os seus dados (ocorr√™ncias e linhas... possivelmente com realoca√ß√£o).
      
      // Caso contr√°rio, cria-se uma nova entrada no √≠ndice, realocando, conforme abaixo:      
      n++;
      v=(Indice*)realloc(v,sizeof(Indice)*n);
      // Depois, os dados da palavra s√£o inseridos na nova entrada do √≠ndice:
      //Deixando tudo minusculo
      int tamanho = strlen(lista[i]);
      for(j = 0; j<tamanho; j++){
        lista[i][j] = tolower(lista[i][j]);
      }
      v[n-1].palavra = lista[i];
      v[n-1].ocorrencias = 1;
      v[n-1].qtd = 1;
      v[n-1].linhas = (int*)malloc(sizeof(int));
      v[n-1].linhas[0] = linha;     
    }     
    free(lista); // libera a mem√≥ria da lista de palavras, para que seja alocada novamente na p¬¥roxima itera√ß√£o.
  }
  fclose(f);
  
  //Para verificar quantas vezes cada palavra aparece e remover as repeticoes (Funcioanndo)
  char stringAux[50];
  for(i=0; i<n; i++){
    strcpy(stringAux, v[i].palavra);
    for(j=0; j<n; j++){
      if(strcmp(stringAux,v[j].palavra)== 0 && i!=j){
	 	for(k=j; k<n-1; k++){
	 		strcpy(v[k].palavra, v[k+1].palavra);
		}
        n--;
        //if(j== n-1)
          //free(Indice[j]);
        v[i].linhas[v[i].qtd] = v[j].linhas[0];
        v[i].qtd++;
		j--;
      }
    }
  //linhas: 1, 2, 3 
  }
  
  // TO DO: ordenar o vetor do √≠ndice.
  //i=0 e j=0 -- i √© pra palavra e j pro caractere da palavra
  //usar strcpy ou memcpy
  //char aux[60];
  //aux = campo[i]
  //campo[i] = campo[i+1]
  //campo [i+1] = aux;
  //ex da funÁ„o
  /*
  for(i=0;i<n-1;i++){
  	for(j=0;j<n;j++){
  		if(strcmp(v[i].palavra[j], v[i+1].palavra[j]) == 1){
  			strcpy(stringAux, v[i].palavra);
  			strcpy(v[i].palavra, v[i+1].palavra);
  			strcpy(v[i+1].palavra,stringAux);
		  }
	  }
  }
  */
  
  
  //ordena (Indice.palavra, lista);
  
  
  
  
  // TO DO: salvar num arquivo...
  for(i=0;i<n;i++){
    printf("\n- Entrada %d\n",i+1);
    printf("  - palavra: %s\n",v[i].palavra);
    //printa "linha: "
    //for(j=0; j<v[i].qtd)
      //printa %d, 
      //if(j == v[i].qtd - 1)
     //%d
    printf("  - Ocorrencias: %d\n", v[i].qtd);
	printf("  - linha(s): %d\n",v[i].linhas[0]);
	//arrumar bonitinho aqui
  }
  
  // fopen com w ou wt
  // for 0 a n
  // fprintf(f, "- Entrada %d\nscanf", entrada);
  // fprintf (f,"\t- palavra: %s\n", v[i].palavra);
  // fprintf (f,"\t- linha: ")
  // for j pra printar cada linha
    //if n√£o √© ultima palavra
    //fprintf(f, " %d,",v[i].linhas[j]);
    //else
    //fprintf (f, " %d",v[i].linhas[j]);
  
  // Desalocando o √≠ndice:
  for(i=0;i<n;i++){
    free(v[i].palavra);
    free(v[i].linhas);
  }
  free(v);
  
  system("PAUSE");

  return 0;
}

//FunÁıes:
char **separa_palavras(char *s){
   char **p = (char**)malloc(sizeof(char*));
   int cont = 0, i = 0, inicio;
   while(s[i] != '\0'){
      while(s[i] != '\0' && !eh_letra(s[i]))
         i++;
      if(s[i] != '\0'){
         inicio = i;
         while(eh_letra(s[i]))
            i++;
         
         p[cont] = (char*)malloc(sizeof(char)*(i-inicio+1));
         
         int j, k = 0;
         for(j=inicio; j<i; j++){
            p[cont][k] = s[j];
            k++;
		 }
         p[cont][k] = '\0';
         
         cont++;
         p = (char**)realloc(p, sizeof(char*)*(cont+1));         
	  }
   }
   p[cont] = NULL;
   return p;
}


int eh_letra(char c){
   return c >= 'a' && c<= 'z' || c >= 'A' && c<= 'Z' 
   || c == '·' || c == '‡' || c == 'È' || c == '@' || c == '‚' || c == 'ı' || c == 'Ì' || c == '¡'|| c == '√' || c == '¿'
   || c == '«' || c == 'Á' || c == '”' || c == '‘';
}


/*
void ordena (char Indice.palavra, char lista){
	int x, y, r;
	char aux[80];
	for (x=0; Indice.palavra != NULL; x++){
		for (y = x+1; Indice.palavra != NULL; y++){
			r = strcmp (Indice.palavra[x], lista[y]);
			if (r < 0){
				strcpy (aux, Indice.palavra[x]);
				strcpy (Indice.palavra[x], lista[y]);
				strcpy (lista[y], aux);
			}
		}
	}
}
*/
