package dados;

import exceptions.CleanException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CalculadoraEstatistica implements ISequencia {
    
    private Gerador geradores[] = new Gerador[] {new Fibonacci(), new Naturais(), new Fatoriais()};
    private static CalculadoraEstatistica instance = null;
    protected List<Integer> sequencia = new LinkedList();
    
    private CalculadoraEstatistica(){
        
    }
    
    public void gerar(GerarTipo tipo, int n){
        switch(tipo){
            case FIBONACCI:
                geradores[0].gerar(n);
                this.sequencia.addAll(geradores[0].getSequence());
                break;
            case NATURAL:
                geradores[1].gerar(n);
                this.sequencia.addAll(geradores[1].getSequence());
                break;
            case FATORIAL:
                geradores[2].gerar(n);
                this.sequencia.addAll(geradores[2].getSequence());
                break;
        }
    }
    
    public static CalculadoraEstatistica getInstance(){
        if(instance == null){
            instance = new CalculadoraEstatistica();
        }
        return instance;
    }
    
    public List<Integer> getValores(){
        return this.sequencia;
    }
    
    //Metodos
    public void adicionarValor(int valor){
        sequencia.add(valor);
    }
    
    public void adicionarValores(int valor){
        sequencia.add(valor);
    }
    
    public void limparValores() throws CleanException{
        if(sequencia.size() > 0){
            sequencia.clear();
        }else{
            throw new CleanException();
        }
    }
    
    public void tirar() throws CleanException{
        if(sequencia.size()>0){
            sequencia.remove(sequencia.size()-1);
        }else{
            throw new CleanException();
        }
    }
    
    @Override
    public int sortear(){
       Random r = new Random();
       return sequencia.get(r.nextInt(sequencia.size()));
    }
    
    @Override
    public long somatorio(){
        long soma = 0;
        for(int num : sequencia){
            soma += num;
        }
        return soma;
    }
    
    @Override
    public long produtorio(){
        long produto = 1;
        for(int num : sequencia){
            produto *= num;
        }
        return produto;
    }
    
    @Override
    public double mediaGeometrica(){
        double resultado;
        resultado = Math.pow(produtorio(), 1.0/(double)(sequencia.size()));
        return resultado;
    }
    
    @Override
    public double mediaAritmetica(){
        return somatorio()/sequencia.size();
    }
    
    @Override
    public double variancia(){
        double media = mediaAritmetica();
        
        double soma = 0;
        
        for(int num : sequencia){
            soma += Math.pow(num-media, 2);
        }
        return soma / (double)(sequencia.size());
    }
    
    @Override
    public double desvioPadrao(){
        return Math.sqrt(variancia());
    }
    
    @Override
    public int amplitude(){
        return Collections.max(sequencia) - Collections.min(sequencia);
    }
}
