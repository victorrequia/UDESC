package dados;

public class Quadrados extends Gerador{

    @Override
    public void gerar(int quantidade) {
        for(int i=0; i<quantidade; i++){
            sequencia.add(i*i);
        }
    }
    
}
