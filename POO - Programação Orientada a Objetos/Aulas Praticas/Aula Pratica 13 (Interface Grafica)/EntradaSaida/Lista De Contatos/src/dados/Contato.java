package dados;

public class Contato {
    private String nome;
    private int telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    
    @Override
   public String toString(){
       return this.nome + " - " + this.telefone;
   }
   
   @Override
   public boolean equals(Object o){
       Contato c = (Contato) o;
       if(this.telefone == c.getTelefone()){
           return true;
       }else{
           return false;
       }
   }
}
