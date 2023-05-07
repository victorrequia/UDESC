package dados;

import java.util.Random;

public class Cilindro {
    //Atributos
    private Circulo circulo = new Circulo();
    private Retangulo retangulo = new Retangulo();
    
    //Metodos
    public double calcularArea() {
        double area_base = circulo.calcularArea();
        double area_lateral = retangulo.getAltura()*retangulo.getBase();
        return (area_base*2)+area_lateral;
    }

    public double calcularVolume() {
        double area_base = circulo.calcularArea();
        double area_lateral = retangulo.getAltura()*retangulo.getBase();
        return area_base*area_lateral;
    }
    
    //Metodos Especiais
    public void setMedidas(){
        circulo.setRaio();  
        retangulo.setAltura();
        retangulo.setBase();
    }
    
    public String getMedidas(){
        return "Raio do circulo: " + String.format("%.2f", circulo.getRaio()) + " base do retangulo: " + String.format("%.2f", retangulo.getBase()) +
               " altura do retangulo: " + String.format("%.2f", retangulo.getAltura());
    }

    public String mostrarCilindro() {
        return "Figura: Cilindro" + " Volume: " + String.format("%.2f", this.calcularVolume()) + 
               "\nFigura: Cilindro Area: " + String.format("%.2f", this.calcularArea());
    }
}
