package fabrica;

public class Bicicleta extends Veiculo{
    //Atributos
    private int numeroMarchas;
    
    //Metodos
    public int getNumeroMarchas() {
        return numeroMarchas;
    }

    public void setNumeroMarchas(int numeroMarchas) {
        this.numeroMarchas = numeroMarchas;
    }
    
    @Override
    public String info() {
        return "\nBicicletra\n" + "Cor: " + this.getCor() + "\n" + "Numero de marchas: " + this.numeroMarchas + "\n";
    }
    
}
