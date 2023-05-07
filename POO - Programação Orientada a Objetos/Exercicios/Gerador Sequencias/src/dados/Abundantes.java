package dados;

import java.util.List;
import java.util.List;
import java.util.ArrayList;

public class Abundantes extends Gerador{
    
    @Override
    public void gerar(int quantidade) {
        int quant = 0;
        int num = 1;
        
        do{
           if(abundante(num)){
               sequencia.add(num);
               quant++;
           }
           num++;
        }while(quant < quantidade);
    }
    
    public boolean abundante(int valor){
        int soma = 0;
            
        for(int i=1; i<valor; i++){
            if(valor%i == 0){
                soma += i;
            }
        }
        
        if(valor < soma) {
            return true;
        }else{
            return false;
        }
    }
}
