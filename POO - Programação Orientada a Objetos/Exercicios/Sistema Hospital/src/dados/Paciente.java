package dados;

public class Paciente{
    //Atributos
    int id;
    private String cidade;
    private String descricao;
    private String nome;
    private String cpf;
    private int idade;
    
    //Construtor
    public Paciente(int id,String nome,String cidade,String descricao,String cpf,int idade){
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.descricao = descricao;
        this.cpf = cpf;
        this.idade = idade;
    }
    
    public Paciente(){}
    @Override
    public String toString(){
        return this.nome;
    }
    
    public boolean equals(Paciente paciente){
        return paciente.id == this.id;
    }
    
    //Metodos Especiais
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String Cidade) {
        this.cidade = Cidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
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
