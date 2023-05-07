package dados;

public class Contato {
    //Atributos
    private String nome;
    private long  telefone;
    
    //Metodos Especiais
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
        this.telefone = telefone;
    }
    
    public String toString(){
        return this.nome + " - " + this.telefone;
    }
}
