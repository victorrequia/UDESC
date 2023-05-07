package dados;

import java.util.Random;

public class Circulo extends FormaGeometrica{
    //Atributos
    private double raio;
    
    //Metodos Sobrescritos
    @Override
    public double calcularArea() {
        return Math.PI*Math.pow(raio, 2);
    }

    @Override
    public double calcularPerimetro() {
        return 2*Math.PI*raio;
    }
    
    @Override
    public String mostrarPerimetro() {
        return "Figura: Circulo" + " Perimetro: " + String.format("%.2f", this.calcularPerimetro());
    }

    @Override
    public String mostrarArea() {
        return "Figura: Circulo" + " Area: " + String.format("%.2f", this.calcularArea());
    }

    //Metodos especiais
    public double getRaio() {
        return raio;
    }

    public void setRaio() {
        Random aleatorio = new Random();
        double numero = aleatorio.nextDouble() + aleatorio.nextInt(10);
        while(numero == 0){
            numero = aleatorio.nextDouble() + aleatorio.nextInt(10);
        }
        this.raio = numero;
    }
}
