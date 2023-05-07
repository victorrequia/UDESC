package dados;

public class Peixe extends Animal{
    //Atributos
    private float temperaturaIdeal;

    //Metodos
    public float calculaEspacoOcupado(){
        return this.altura*this.comprimento*this.largura;
    }
    
    //Metodos Especiais
    public float getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }
    
}
