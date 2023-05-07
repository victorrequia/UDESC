package fabrica;

public abstract class Veiculo {
    //Atributos
    private Cor cor;
    
    //Metodos
    public Cor getCor(){
        return this.cor;
    }
    
    public void setCor(Cor cor){
        this.cor = cor;
    }
    
    public abstract String info();
}
