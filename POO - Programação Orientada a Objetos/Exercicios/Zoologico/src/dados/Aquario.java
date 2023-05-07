package dados;

public class Aquario extends Viveiro{
    //Atributos
    private float altura;
    private float temperatura;

    //Metodo Contrutor
    public Aquario(int maxPeixes){
        super(maxPeixes);
    }
    
    //Metodos
    @Override
    public float calculaEspaco(){
        return this.altura*this.comprimento*this.largura;
    }
    
    @Override
    public boolean adicionarAnimal(Animal animal){
    if(espacoDisponivel() > (animal.calculaEspacoOcupado()*0.7)){
        if(animal instanceof Peixe){
            Peixe p = (Peixe) animal;
            if((p.getTemperaturaIdeal() > temperatura+3) || (p.getTemperaturaIdeal() < temperatura-3)){
                return false;
            }
        }else{
            return false;
        }
        animais[quantAnimais] = animal;
        quantAnimais++;
        System.out.println("Animal adicionado com sucesso!");
        return true;
        }else{
            System.out.println("Nao foi possivel adicionar o animal! O viveiro está cheio!");
            return false;
        }
    }
    
    //Metodos especiais
    @Override
    public String mostraViveiro(){
        return "Tipo: Aquario\n" + "Nome: " + this.nome + "\n" + "Quantidade de animais: " + this.quantAnimais + "\n" +
               "Volume disponível: " + this.espacoDisponivel() + "\n" + "Temperatura ideal: " + this.temperatura + "\n";
    }
    
    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
    
}
