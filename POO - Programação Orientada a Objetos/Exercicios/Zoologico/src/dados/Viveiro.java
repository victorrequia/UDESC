package dados;

public class Viveiro {
    //Atributos
    protected Animal[] animais;
    protected int quantAnimais;
    protected int maxAnimais;
    protected String nome;
    protected float comprimento;
    protected float largura;
    
    //Metodo Construtor
    public Viveiro(int maxAnimais){
        this.animais = new Animal[maxAnimais];
        quantAnimais=0;
        this.maxAnimais = maxAnimais;
    }
    
    //Metodos   
    public String mostraAnimaisViveiro(){
        for(int i=0; i<quantAnimais;i++){
            return animais[i].toString();
        }return null;
    }
    
    public boolean adicionaAnimal(Animal animal){
        if(quantAnimais<maxAnimais){
                animais[quantAnimais] = animal;
                quantAnimais++;
                System.out.println("Animal cadastrado com sucesso!");
                return true;
            }else{
            System.out.println("Não é possivel cadastrar mais animais");
            return false;
        }
    }
    
    public float calculaEspaco(){
        return this.comprimento*this.largura;
    }
    
    private float espacoOcupado(){
        float area=0;
        for(int i=0; i<quantAnimais; i++){
            area += calculaEspaco() - animais[i].calculaEspacoOcupado();
        }
        return area;
    }
    
    public float espacoDisponivel(){
        float espDiponivel = (calculaEspaco())-espacoOcupado();
        return espDiponivel;
    }
    
    public boolean adicionarAnimal(Animal animal){
        if(espacoDisponivel() > espacoOcupado()){
            animais[quantAnimais] = animal;
            quantAnimais++;
            return true;
        }else{
            return false;
        }
    }
    
    //Metodos especiais
    public String mostraViveiro(){
        return "Tipo: Viveiro\n" + "Nome: " + this.nome + "\n" + "Quantidade de animais: " + this.quantAnimais + "\n" +
               "Area disponível: " + this.espacoDisponivel() + "\n";
    }
    
    @Override
    public String toString(){
        StringBuffer string = new StringBuffer();
        string.append("Nome: " + this.nome + "\n");
        for(int i=0; i<quantAnimais;i++){
            string.append("\t"+animais[i].toString() + "\n");
        }
        return string.toString();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }
    
    public Animal[] getAnimais() {
        return animais;
    }

    public void setAnimais(Animal[] animais) {
        this.animais = animais;
    }

    public int getQuantAnimais() {
        return quantAnimais;
    }

    public void setQuantAnimais(int quantAnimais) {
        this.quantAnimais = quantAnimais;
    }
}
