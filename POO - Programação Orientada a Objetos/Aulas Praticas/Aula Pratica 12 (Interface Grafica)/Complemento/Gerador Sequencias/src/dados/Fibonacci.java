package dados;

public class Fibonacci extends Gerador{

    @Override
    public void gerar(int quantidade) {
        sequencia.add(0);
        sequencia.add(1);
        
        for(int i=0; i<quantidade-2; i++){
            int n1 = sequencia.get(sequencia.size()-1);
            int n2 = sequencia.get(sequencia.size()-2);
            sequencia.add(n1+n2);
        }
    }
    
}
