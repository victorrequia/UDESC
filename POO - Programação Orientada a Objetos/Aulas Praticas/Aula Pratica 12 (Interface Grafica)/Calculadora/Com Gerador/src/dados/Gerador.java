package dados;

import java.util.List;
import java.util.LinkedList;

public abstract class Gerador {
    protected List<Integer> sequencia = new LinkedList();
    
    public List<Integer> getSequence(){
        return this.sequencia;
    }
    
    //Metodos
    public abstract void gerar(int quantidade);

}
