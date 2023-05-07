package dados;

public class Primos extends Gerador{

    @Override
    public void gerar(int quantidade) {
        int quant = 0;
        int num=2;

        do{
            if(primo(num)){
                sequencia.add(num);
                quant++;
            }
            num++;
        }while(quant < quantidade);
    }
    
    public boolean primo(int valor){
        for(int i=2; i<valor; i++){
            if(valor%i==0){
                return false;
            }
        }
        return true;
    }
        
    
    
}
