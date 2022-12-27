#include <stdio.h>
#include <stdlib.h>

int main(){
	int i,dist,v[5];
	int matriz [6][6] ={{0,63,210,190,0,190},
					   {63,0,160,150,95,0  },
					   {210,160,0,10,0,0   },
					   {190,150,10,0,0,0   },
					   {0,95,0,0,0,80      },
					   {190,0,0,0,80,0     }};	

v[0] = matriz [2][3];
v[1] = matriz [3][1];
v[2] = matriz [1][4];	
v[3] = matriz [4][5];
v[4] = matriz [5][0];

for (i=0; i<5; i++){
	dist = dist + v[i];
}	
printf("A distancia eh: %i", dist);			
	
	return 0;
}
