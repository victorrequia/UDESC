package dados;

import java.util.Random;

public class Retangulo extends FormaGeometrica{
    //Atributos
    private double base;
    private double altura;

    //Metodos Sobrescritos
    @Override
    public double calcularArea() {
        return base*altura;
    }

    @Override
    public double calcularPerimetro() {
        return (2*base)+(2*altura);
    }
    
    @Override
    public String mostrarPerimetro() {
        return "Figura: Retangulo" + " Perimetro: " + String.format("%.2f", this.calcularPerimetro());
    }

    @Override
    public String mostrarArea() {
        return "Figura: Retangulo" + " Area: " + String.format("%.2f", this.calcularArea());
    }

    //Metodos Especiais
    public double getBase() {
        return base;
    }

    public void setBase() {
        Random aleatorio = new Random();
        double numero = aleatorio.nextDouble() + aleatorio.nextInt(10);
        while(numero == 0){
            numero = aleatorio.nextDouble() + aleatorio.nextInt(10);
        }
        this.base = numero;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura() {
        Random aleatorio = new Random();
        double numero = aleatorio.nextDouble() + aleatorio.nextInt(10);
        while(numero == 0){
            numero = aleatorio.nextDouble() + aleatorio.nextInt(10);
        }
        this.altura = numero;
    }
}
