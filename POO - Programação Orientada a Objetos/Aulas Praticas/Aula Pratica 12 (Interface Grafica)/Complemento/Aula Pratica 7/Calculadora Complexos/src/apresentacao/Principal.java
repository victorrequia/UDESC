package apresentacao;

import java.util.Scanner;
import java.util.Random;
import dados.CalculadoraComplexos;
import dados.CalculadoraInteiros;
import dados.Complexo;

public class Principal {
    
    private static Scanner s = new Scanner(System.in);
    public static Random r = new Random();
    
    private static CalculadoraInteiros c1 = new CalculadoraInteiros();
    private static CalculadoraComplexos c2 = new CalculadoraComplexos();
    
    public static void main(String args[]){
        int opcao = 0;
        
        do{
            if(r.nextInt(2) == 1){ //Para calculadora de inteiros
                Integer v1 = r.nextInt(100);
                Integer v2 = r.nextInt(100);
                if(r.nextInt(2) == 1){ //Para soma de inteiros
                    System.out.println(v1 + " + " + v2 + " = " + c1.soma(v1,v2));
                }else{ //Para a subtração de inteiros
                    System.out.println(v1 + " - " + v2 + " = " + c1.subtracao(v1,v2));
                }
            }else{ //Para calculadora de Complexos
                Complexo a = new Complexo();
                Complexo b = new Complexo();
                if(r.nextInt(2) == 1){ //Para soma de Complexos
                    System.out.println(a + " + " + b + " = " + c2.soma(a,b));
                }else{ //Para a subtração de Complexos
                    System.out.println(a + " - " + b + " = " + c2.subtracao(a,b));
                }
            }
            
            System.out.println("Digite 0 para encerrar programa");
            opcao = s.nextInt();
        }while(opcao != 0);
    }
}
