/**********INVERTE FILA*****************/
int inverteFilaPrio(struct descF *p){
	if (testaVazia(p) == SIM){
		printf("A fila esta vazia!");
		return 0;
	}else{
    	p->frente->defronte = NULL;
        p->cauda->atras = NULL;
		struct noFila *aux1 = p->frente;
		struct noFila *aux2;
		do{
			aux2 = aux1->atras;
			aux1->atras = aux1->defronte;
			aux1->defronte=aux2;
			aux1 = aux1->defronte;
		}while(aux1 != NULL);
			struct noFila *auxCauda = p->cauda;
			p->cauda = p->frente;
			p->frente = auxCauda; 
	}
		return 1;
}