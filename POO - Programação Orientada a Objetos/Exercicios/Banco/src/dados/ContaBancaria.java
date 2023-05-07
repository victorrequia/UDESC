package dados;

public class ContaBancaria {
    //Atributos
    private int cpf;
    protected float saldo;
    
    //Metodo Contrutor
    public void ContaBancaria(){
        this.saldo = 0;
    }
    
    public float sacar(float valor){
        if(valor <= this.saldo){
            this.saldo -= valor;         
        }else{
            System.out.println("Erro ao sacar, você não possui saldo suficiente!");
        }
        return valor;   
    }
    
    public String gerarExtrato(){
        return "Saldo da conta: R$ " + this.saldo;
    }
    
    //Metodos especiais
    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CPF: " + this.cpf;
    }
}
