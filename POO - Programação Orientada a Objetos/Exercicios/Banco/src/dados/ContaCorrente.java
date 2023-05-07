package dados;

public class ContaCorrente extends ContaBancaria{
    //Metodo Construtor
    public ContaCorrente(){
        super();
    }

    //Metodos
    public boolean depositar(float valor){
        this.saldo += valor;
        return true;
    }
    
    @Override
    public String gerarExtrato(){
        return "Conta Corrente: \n" + "CPF: " + this.getCpf() + "\n" + super.gerarExtrato();
    }
    
    @Override
    public String toString() {
        return "ContaCorrente: " + super.toString();
    }
}
