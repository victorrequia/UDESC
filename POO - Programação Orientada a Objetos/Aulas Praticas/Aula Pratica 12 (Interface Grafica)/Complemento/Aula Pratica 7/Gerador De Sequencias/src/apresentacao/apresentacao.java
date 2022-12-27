package apresentacao;

import dados.*;
import java.util.Scanner;
import java.util.List;
import java.util.Random;

public class apresentacao {    
    public static void main(String[] args){
    Gerador gerador;
    List<Integer> resultado;
    
    //Naturais
    gerador = new Naturais();
    gerador.gerar(aleatorio(5));
    imprimir("Naturais", gerador);
    
    //Abundantes
    gerador = new Abundantes();
    gerador.gerar(aleatorio(5));
    imprimir("Abundantes", gerador);
    
    //Fibonacci
    gerador = new Fibonacci();
    gerador.gerar(aleatorio(5));
    imprimir("Fibonacci", gerador);
    
    //Fatoriais
    gerador = new Fatoriais();
    gerador.gerar(aleatorio(5));
    imprimir("Fatorial", gerador);
    
    //NumeroPrimos
    gerador = new Primos();
    gerador.gerar(aleatorio(5));
    imprimir("Primos", gerador);
    
    //Perfeitos
    gerador = new Perfeitos();
    gerador.gerar(aleatorio(5));
    imprimir("Perfeitos", gerador);
    
    //Quadrados
    gerador = new Quadrados();
    gerador.gerar(aleatorio(5));
    imprimir("Quadrados", gerador);

    }
    
    public static void imprimir(String tipo, Gerador g){
        List<Integer> sequencia = g.getSequence();
        if(sequencia.size() < 1){
            System.out.print("Lista sem numero");
        }else{
            System.out.print("\n" + tipo + " de " + sequencia.size() + ": [");
            for(int i=0; i<sequencia.size()-1;i++){
                System.out.print(sequencia.get(i)+", ");
            }
            System.out.print(sequencia.get(sequencia.size()-1)+"]");
        }
        System.out.println();
        System.out.println("Numero sorteado: " + g.sortear());
        System.out.println("Somatorio: " + g.somatorio());
        System.out.println("Media Aritmetica: " + g.mediaAritmetica());
        System.out.println("Media Geometica: " + g.mediaGeometrica());
        System.out.println("Variancia: " + g.variancia());
        System.out.println("Desvio Padrao: " + g.desvioPadrao());
        System.out.println("Amplitude: " + g.amplitude());
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