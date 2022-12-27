#include <stdio.h>
#include <stdlib.h>

int main(){
	int qcidades, cidades=1;
	int i,j, validade_da_rota;
	int distancia = 0;
	int matriz [6][6] ={{0,63,210,190,0,190},
					   {63,0,160,150,95,0  },
					   {210,160,0,10,0,0   },
					   {190,150,10,0,0,0   },
					   {0,95,0,0,0,80      },
					   {190,0,0,0,80,0     }};
	int vetor[7] = {-1,-1,-1,-1,-1,-1,-1};

	printf("Digite quantas cidades voce quer passar: ");
	scanf("%i", &qcidades);
	
	printf("Digite as cidades da sua rota:\n0 para Caceres\n1 para BBugres\n2 para Cuiaba\n3 para VGrande\n4 para Tangara\n5 para PLacerda\n");
	
	while (cidades <= qcidades){
		scanf("\n%i", &vetor[cidades]);	
		cidades++;
	}
	
	for (i=1; i<=qcidades; i++){
		if (vetor[i+1] != -1){
			distancia = distancia + matriz[vetor[i]][vetor[i+1]];
			if (distancia == 0){
				printf("Rota invalida!");
				i = qcidades+1;
				validade_da_rota = 0;
			} else {
				validade_da_rota = 1;
			}
		}
	}
	
	if (validade_da_rota == 1) {
		printf("a distancia eh %i", distancia);
	}


	return 0;
}
