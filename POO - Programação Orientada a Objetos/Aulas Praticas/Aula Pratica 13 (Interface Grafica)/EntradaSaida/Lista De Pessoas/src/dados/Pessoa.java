package dados;

public class Pessoa {
    //Atributos
    private String nome;
    private int idade;
    private float massa;
    private float altura;
    
    //Metodos
    @Override
    public boolean equals(Object o){
        Pessoa p = (Pessoa) o;
        if(p.getNome().equals(this.nome)){
            return true;
        }
        return false;
    }
    
    public String toString(){
        return "Nome: " + this.nome + "\nIdade: " + this.idade + "\nMassa: " + this.massa + "\nAltura: " + this.altura;
    }
    
    //Metodos Especias
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getMassa() {
        return massa;
    }

    public void setMassa(float massa) {
        this.massa = massa;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
}
