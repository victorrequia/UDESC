package dados;

public class Endereco {

	private int id;
	private String rua;
	private int numero;
	private String cidade;
	private int idPessoa;

	public Endereco(int id, String rua, int numero, String cidade) {
		this.id = id;
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
	}

	public Endereco(String rua, int numero, String cidade) {
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getIdPessoa() {
		return this.idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	@Override
	public String toString() {
		StringBuilder endereco = new StringBuilder();
		endereco.append("Rua ");
		endereco.append(rua);
		endereco.append(", ");
		endereco.append(numero);
		endereco.append(" - ");
		endereco.append(cidade);
		return endereco.toString();
	}

}
