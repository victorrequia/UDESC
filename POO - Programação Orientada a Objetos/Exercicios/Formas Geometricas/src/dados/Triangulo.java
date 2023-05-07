package dados;

import java.util.Random;

public class Triangulo extends FormaGeometrica{
    //Atributos
    private double lados[] = new double[3];

    //Metodos Sobrescritos
    @Override
    public double calcularArea() {
        double semiPerimetro = calcularPerimetro()/2;
        return Math.sqrt(semiPerimetro*(semiPerimetro-lados[0])*(semiPerimetro-lados[1])*(semiPerimetro-lados[2]));
    }

    @Override
    public double calcularPerimetro() {
        return lados[0]+lados[1]+lados[2];
    }
    
    @Override
    public String mostrarPerimetro() {
        return "Figura: Triangulo" + " Perimetro: " + String.format("%.2f", this.calcularPerimetro());
    }

    @Override
    public String mostrarArea() {
        return "Figura: Triangulo" + " Area: " + String.format("%.2f", this.calcularArea());
    }

    //Metodos Especiais
    public double[] getLados() {
        return lados;
    }

    public void setLados() {
        Random aleatorio = new Random();
        for(int i=0; i<3; i++){
            double lados = aleatorio.nextDouble() + aleatorio.nextInt(10);
            while(lados == 0){
            lados = aleatorio.nextDouble() + aleatorio.nextInt(10);
            }   
         this.lados[i] = lados;
        }   
    }
}
