package dados;

public class Pessoa {

	private int id;
	private String nome;
	private int cpf;
	private int telefone;
	private Endereco endereco;

	public Pessoa() {

	}

	public Pessoa(int id, String nome, int cpf, int telefone, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public Pessoa(String nome, int cpf, int telefone, Endereco endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCpf() {
		return cpf;
	}

	public void setCpf(int cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}

	@Override
	public String toString() {
		StringBuilder pessoa = new StringBuilder();
		pessoa.append(id);
		pessoa.append("\n");
		pessoa.append("Nome: ");
		pessoa.append(nome);
		pessoa.append("\n");
		pessoa.append("CPF: ");
		pessoa.append(cpf);
		pessoa.append("\n");
		pessoa.append("Telefone: ");
		pessoa.append(telefone);
		pessoa.append("\n");
		pessoa.append("Endereco: ");
		pessoa.append(endereco);
		pessoa.append("\n");
		return pessoa.toString();
	}

}
