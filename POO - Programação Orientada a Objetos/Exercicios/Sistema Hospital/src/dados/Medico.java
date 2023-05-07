package dados;

public class Medico {
    //Atributos
    private int id;
    private String cidade;
    private String especializacao;
    private String nome;
    private String cpf;
    private int idade;
    
    //Construtor
    public Medico(int id, String nome,String cidade,String especializacao,int idade,String cpf){
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.especializacao = especializacao;
        this.idade = idade;
        this.cpf = cpf;
    }
    
    public Medico(){};
    
    //Metodos
    @Override
    public String toString(){
        return this.nome;
    }
    
    public boolean equals(Medico medico){
        return medico.id == this.id;
    }
    
    //Metodos Especiais
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    
}
