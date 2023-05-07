package dados;

import java.util.Random;

public class Pentagono extends FormaGeometrica{
    //Atributos
    private double lado;
    
    //Metodos Sobrescrito
    @Override
    public double calcularArea() {
        return (Math.pow(lado, 2)*(Math.sqrt(25+10*Math.sqrt(5))))/4;
    }

    @Override
    public double calcularPerimetro() {
        return lado*5;
    }

    @Override
    public String mostrarPerimetro() {
        return "Figura: Penagono" + " Perimetro: " + String.format("%.2f", this.calcularPerimetro());
    }

    @Override
    public String mostrarArea() {
        return "Figura: Pentagono" + " Area: " + String.format("%.2f", this.calcularArea());
    }

    //Metodos Especiais
    public double getLado() {
        return lado;
    }

    public void setLado() {
        Random aleatorio = new Random();
        double numero = aleatorio.nextDouble() + aleatorio.nextInt(10);
        while(numero == 0){
            numero = aleatorio.nextDouble() + aleatorio.nextInt(10);
        }
        this.lado = numero;
    }
}
