#include <stdio.h>

int main(){
	int idade_dias, ano, meses;
	
	scanf("%i", &idade_dias);
	
	ano = idade_dias/365;
	idade_dias = idade_dias - (ano*365);
	
	meses = idade_dias/30;
	idade_dias = idade_dias - (meses*30);
	
	printf("%i ano(s)\n%i mes(es)\n%i dia(s)\n", ano, meses, idade_dias);
}
