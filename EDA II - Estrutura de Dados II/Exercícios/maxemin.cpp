#include <stdio.h>
 
int minSeq(int *min){
    int i, x;
    scanf("%d", min);
    for (i = 0; i < 2; i++){
        scanf("%d", &x);
        if (x < *min) *min =x;
    }
}
   
int main(void){
	int n, minimo;
    minSeq(&minimo);
	printf("%d\n", minimo);
    return 0;
}
