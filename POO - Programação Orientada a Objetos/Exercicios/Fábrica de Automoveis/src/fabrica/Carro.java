package fabrica;

public class Carro extends Veiculo{
    //Atributos
    private int numeroPortas;
    private Combustivel combustivel;

    //Metodos
    public int getNumeroPortas() {
        return numeroPortas;
    }

    public void setNumeroPortas(int numeroPortas) {
        this.numeroPortas = numeroPortas;
    }

    public Combustivel getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(Combustivel combustivel) {
        this.combustivel = combustivel;
    }
    
    @Override
    public String info() {
        return "\nCarro\n" + "Cor: "+ this.getCor() + "\n" + "Numero de portas: " + numeroPortas + "\n"
        + "Tipo de combustivel: " + combustivel + "\n";
    }
    
}
