package fabrica;

import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner teclado = new Scanner(System.in);
        Fabrica fabrica = new Fabrica();
        int fim = -1;
        
        do{
            System.out.println(fabrica.fabricar().info());
            System.out.println("Digite 0 para interromper a produção");
            System.out.println("Digite qualquer numero para continuar");
            fim = teclado.nextInt();
        }while(fim != 0);
    }
}
