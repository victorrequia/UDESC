package dados;

public class Fatoriais extends Gerador{

    @Override
    public void gerar(int quantidade) {
        sequencia.add(1);
        int quant=0;
        int valor=1;
        
        do{
            int fatorial = valor*sequencia.get(sequencia.size()-1);
            sequencia.add(fatorial);
            quant++;
            valor++;
        }while(quant < quantidade);   
    }
}
