package dados;

public class Perfeitos extends Gerador{

    @Override
    public void gerar(int quantidade) {
        int quant = 0;
        int num = 1;
        
        do{
            if(perfeito(num)){
                sequencia.add(num);
                quant++;
            }
            num++;
        }while(quant<quantidade);
        
    }
    
    public boolean perfeito(int valor){
        int soma = 0;
        for(int i=1; i<valor; i++){
            if(valor%i == 0){
                soma += i;
            }
        }
        
        if(soma == valor){
            return true;
        }else{
            return false;
        }
    }
    
}
