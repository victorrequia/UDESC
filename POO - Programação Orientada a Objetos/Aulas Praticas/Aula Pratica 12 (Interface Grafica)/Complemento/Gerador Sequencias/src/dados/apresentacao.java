package dados;

import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class apresentacao {    
    public static void main(String[] args){
    Gerador gerador;
    List<Integer> resultado;
    
    //Naturais
    gerador = new Naturais();
    gerador.gerar(aleatorio(30));
    resultado = gerador.getSequence();
    imprimir("Naturais", resultado);
    
    //Abundantes
    gerador = new Abundantes();
    gerador.gerar(aleatorio(4));
    resultado = gerador.getSequence();
    imprimir("Abundantes", resultado);
    
    //Fibonacci
    gerador = new Fibonacci();
    gerador.gerar(aleatorio(10));
    resultado = gerador.getSequence();
    imprimir("Fibonacci", resultado);
    
    //Fatoriais
    gerador = new Fatoriais();
    gerador.gerar(aleatorio(9));
    resultado = gerador.getSequence();
    imprimir("Fatorial", resultado);
    
    //NumeroPrimos
    gerador = new Primos();
    gerador.gerar(aleatorio(10));
    resultado = gerador.getSequence();
    imprimir("Primos", resultado);
    
    //Perfeitos
    gerador = new Perfeitos();
    gerador.gerar(aleatorio(5));
    resultado = gerador.getSequence();
    imprimir("Perfeitos", resultado);
    
    //Quadrados
    gerador = new Quadrados();
    gerador.gerar(aleatorio(10));
    resultado = gerador.getSequence();
    imprimir("Quadrados", resultado);

    }
    
    public static void imprimir(String tipo, List<Integer> sequencia){
        if(sequencia.size() < 1){
            System.out.print("Lista sem numero");
        }else{
            System.out.print("\n" + tipo + " de " + sequencia.size() + ": [");
            for(int i=0; i<sequencia.size()-1;i++){
                System.out.print(sequencia.get(i)+", ");
            }
            System.out.print(sequencia.get(sequencia.size()-1)+"]");
        }
    }
    
    public static int aleatorio(int n){
        Random aleatorio = new Random();
        int numero = aleatorio.nextInt(n);
        while(numero == 0){
            numero = aleatorio.nextInt(n);
        }
        return numero;
    }
}