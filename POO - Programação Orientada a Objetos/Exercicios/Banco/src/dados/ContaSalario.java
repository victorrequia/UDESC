package dados;

public class ContaSalario extends ContaBancaria{
    //Atributo
    private int cnpjEmpresa;
    
    //Metodo Construtor
    public ContaSalario(){
        super();
    }
    
    //Metodos
    public boolean depositar(float valor, int cnpjEmpesa){
        if(cnpjEmpresa == this.cnpjEmpresa){
            this.saldo += valor;
            return true;
        }
        return false;
    }
    
    //Metodos Especias
    @Override
    public String gerarExtrato(){
        return "Conta Salario: \n" + "CPF: " + this.getCpf() + "\n" + super.gerarExtrato() + "\n" + "CNPJ: " + this.cnpjEmpresa;
    }
    
    @Override
    public String toString() {
        return "ContaSalario: \n" + super.toString() + "\n" + "CNPJ: " + this.cnpjEmpresa;
    }

    public int getCnpjEmpresa() {
        return cnpjEmpresa;
    }

    public void setCnpjEmpresa(int cnpjEmpresa) {
        this.cnpjEmpresa = cnpjEmpresa;
    }
    
}
