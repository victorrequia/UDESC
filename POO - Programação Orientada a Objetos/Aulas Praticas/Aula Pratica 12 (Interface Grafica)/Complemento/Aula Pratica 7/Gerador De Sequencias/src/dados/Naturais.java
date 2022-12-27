package dados;

import java.util.List;
import java.util.ArrayList;

public class Naturais extends Gerador{

    @Override
    public void gerar(int quantidade) {
        for(int i=0; i<=quantidade; i++){
            sequencia.add(i);
        }
        
    }
    

}
