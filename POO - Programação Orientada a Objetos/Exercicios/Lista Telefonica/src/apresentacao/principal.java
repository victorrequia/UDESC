package apresentacao;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class principal {
    public static void main(String args[]){
        Map<Integer, List<Integer>> todasAsTabuadas = new HashMap();
        
        for(int i=1; i<=10; i++){
         todasAsTabuadas.put(i,tabuada(i));   
        }
        
        todasAsTabuadas.forEach(
                (chave, tabuada) ->{
                    System.out.print("\nTabuada de " + chave + ": ");
                    
                    for(int x : tabuada){
                     System.out.print(x + " ");   
                    }
                }
        );
    }
    
    public static List<Integer> tabuada(int num){
        List<Integer> tabuada = new ArrayList();
        
        for(int i=0; i<=10; i++){
            tabuada.add(i*num);
        }
        return tabuada;
    }
}
