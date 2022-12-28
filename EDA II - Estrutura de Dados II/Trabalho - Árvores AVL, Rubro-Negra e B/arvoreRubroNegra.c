#include <stdio.h>
#include <stdlib.h>

int interacoes = 0;

// estrutura para representar cada nó
// na arvore rubro-negra
struct node {
	int d; // data
	int c; // 1-vermelho, 0-preto
	struct node* p; // pai
	struct node* r; // filho a direira
	struct node* l; // filho a esquerda
};

struct node* root = NULL; // raiz da arvore
int *vetor; //cria uma copia ordenada da arvore para inserir como pior caso
int posicoes = 0;

// insere
struct node* bst(struct node* trav, struct node* temp)
{
	// se a arvore esta vazia
	// retorna um novo no
	if (trav == NULL)
		return temp;

	// caso contrario recua na arvore
	if (temp->d < trav->d)
	{
		trav->l = bst(trav->l, temp);
		trav->l->p = trav;
	}
	else if (temp->d > trav->d)
	{
		trav->r = bst(trav->r, temp);
		trav->r->p = trav;
	}
    interacoes++;

	// retorna o ponteiro do no (inalterado)
	return trav;
}

// funcao para realizar a rotacao a direita
// do no passado
void rightrotate(struct node* temp)
{
	struct node* left = temp->l;
	temp->l = left->r;
	if (temp->l)
		temp->l->p = temp;
	left->p = temp->p;
	if (!temp->p)
		root = left;
	else if (temp == temp->p->l)
		temp->p->l = left;
	else
		temp->p->r = left;
	left->r = temp;
	temp->p = left;
    interacoes++;
}

// funcao para realizar a rotacao a esquerda
// do no passado
void leftrotate(struct node* temp)
{
	struct node* right = temp->r;
	temp->r = right->l;
	if (temp->r)
		temp->r->p = temp;
	right->p = temp->p;
	if (!temp->p)
		root = right;
	else if (temp == temp->p->l)
		temp->p->l = right;
	else
		temp->p->r = right;
	right->l = temp;
	temp->p = right;
    interacoes++;
}

// funcao para corrigir as violacoes
// causadas pela insercao
void fixup(struct node* root, struct node* pt)
{
	struct node* parent_pt = NULL;
	struct node* grand_parent_pt = NULL;

	while ((pt != root) && (pt->c != 0)
		&& (pt->p->c == 1))
	{
		interacoes++;
        parent_pt = pt->p;
		grand_parent_pt = pt->p->p;

		/* Caso : A
			pai de pt e filho esquerdo do avo de pt*/
		if (parent_pt == grand_parent_pt->l)
		{

			struct node* uncle_pt = grand_parent_pt->r;


			/* Caso : 1
				O tio de pt tambem e vermelho
				e preciso apenas recolorir*/
			if (uncle_pt != NULL && uncle_pt->c == 1)
			{
				grand_parent_pt->c = 1;
				parent_pt->c = 0;
				uncle_pt->c = 0;
				pt = grand_parent_pt;
			}

			else {
				/* Caso : 2
					pt e o filho direito do pai
					e preciso uma rotacao a esquerda*/
				if (pt == parent_pt->r) {
					leftrotate(parent_pt);
					pt = parent_pt;
					parent_pt = pt->p;
				}

				/* Caso : 3
					pt e o filho esquedo do pai
					e preciso uma rotacao a direita*/
				rightrotate(grand_parent_pt);
				int t = parent_pt->c;
				parent_pt->c = grand_parent_pt->c;
				grand_parent_pt->c = t;
				pt = parent_pt;
			}
		}

		/* Caso : B
			pai de pt e filho direito do avo de pt*/
		else {
			struct node* uncle_pt = grand_parent_pt->l;

			/* Caso : 1
				O tio de pt e vermelho tambem
				e preciso apenas recolorir*/
			if ((uncle_pt != NULL) && (uncle_pt->c == 1))
			{
				grand_parent_pt->c = 1;
				parent_pt->c = 0;
				uncle_pt->c = 0;
				pt = grand_parent_pt;
			}
			else {
				/* Caso : 2
				pt e filho esquedo do seu pai
				e preciso uma rotacao a direita*/
				if (pt == parent_pt->l) {
					rightrotate(parent_pt);
					pt = parent_pt;
					parent_pt = pt->p;
				}
				/* Caso : 3
					pt e filho direito do seu pai
					e preciso uma rotacao a esquerda*/
				leftrotate(grand_parent_pt);
				int t = parent_pt->c;
				parent_pt->c = grand_parent_pt->c;
				grand_parent_pt->c = t;
				pt = parent_pt;
			}
		}
	}

	root->c = 0;
}

// funcao para printar inorder
void inorder(struct node* trav)
{
	if (trav == NULL)
		return;
	inorder(trav->l);
	//printf("%d ", trav->d);
    vetor[posicoes++] = trav->d;
	inorder(trav->r);
}

int main(){
    int item; //recebe o valor aleatorio para adicionar na arvore
    int tamAmostra = 63; //quantidade de nodes a serem adicionadas
    int *values; // armazena os nodes
    values = malloc(tamAmostra*sizeof(struct node));
    vetor = malloc(tamAmostra*sizeof(int));

    
    //serao geradas 10 arvores
    for (int j = 0; j < 10; j++){
        printf("---------------------------------------------\n");
        printf("\t\tCaso medio\n\n");
        printf("Tamanho dos Conjuntos | Esforco Computacional\n");

        //determina a quantidade de nodes
        int tamAmostra = rand() % 100;
        values = realloc(values, tamAmostra*sizeof(struct node));
        vetor = realloc(vetor, tamAmostra*sizeof(int));

        //para cada arvore, adiciona seus nodes com valores aleatorios
        for(int i=0; i < tamAmostra; i++){
            item = rand() % 1000;

            //prepara o node para ser inserido
            struct node* temp = (struct node*)malloc(sizeof(struct node));
            temp->r = NULL;
            temp->l = NULL;
            temp->p = NULL;
            temp->d = item; //recebe o valor aleatorio
            temp->c = 1; //cor vermelha

            //insere o node
            root = bst(root, temp);
        }
        
        printf("\t   %d         | \t%d\n", tamAmostra, interacoes);
        interacoes = 0;
        inorder(root);
        
    
        printf("---------------------------------------------\n");
        printf("\t\tPior Caso (decrescente)\n\n");
        printf("Tamanho dos Conjuntos | Esforco Computacional\n");
    
        //para cada arvore, adiciona os mesmos nodes em ordem crescente
        for(int i=0; i < tamAmostra; i++){
            item = vetor[i];
            //printf("%i ", item);

            //prepara o node para ser inserido
            struct node* temp = (struct node*)malloc(sizeof(struct node));
            temp->r = NULL;
            temp->l = NULL;
            temp->p = NULL;
            temp->d = item; //recebe o valor aleatorio
            temp->c = 1; //cor vermelha

            //insere o node
            root = bst(root, temp);
        }
        
        printf("\n\t   %d         | \t%d\n", tamAmostra, interacoes);
        interacoes = 0;
        posicoes = 0;
        root = NULL;
    }
    //inorder(raiz);

    return 0;
}
