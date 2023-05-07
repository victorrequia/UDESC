package apresentacao;

import java.util.List;
import java.util.ArrayList;
import dados.FormaGeometrica;
import dados.Circulo;
import dados.Retangulo;
import dados.Triangulo;
import dados.Pentagono;
import dados.Cilindro;


public class Main {
    private static List<FormaGeometrica> lista = new ArrayList();
    private static Pentagono pentagono = new Pentagono();
    private static Cilindro cilindro = new Cilindro();
    
    public static void main(String args[]){
        System.out.println("------------------------CRIACAO---------------------------");
        adicionarFormaGeometrica(1);
        adicionarFormaGeometrica(2);
        adicionarFormaGeometrica(3);
        System.out.println("-----------------------PERIMETROS-------------------------");
        mostrarPerimetro();
        System.out.println("----------------------------------------------------------");
        System.out.println("--------------------------AREA----------------------------");
        mostrarArea();
        System.out.println("----------------------------------------------------------");
    
        System.out.println("PENTAGONO(Exercicio 6)");
        pentagono.setLado();
        System.out.println("PENTAGONO com triangulos de lado: " + String.format("%.2f", pentagono.getLado()));
        System.out.println(pentagono.mostrarArea());
        System.out.println(pentagono.mostrarPerimetro());
        System.out.println("----------------------------------------------------------");
        System.out.println("CILINDRO(Exercicio 7)");
        cilindro.setMedidas();
        System.out.println("Medidas: " + cilindro.getMedidas());
        System.out.println(cilindro.mostrarCilindro());
        System.out.println("----------------------------------------------------------");
    }
    
    public static void adicionarFormaGeometrica(int opcao){
        switch(opcao){
            case 1:
                Circulo circulo = new Circulo();
                circulo.setRaio();
                System.out.println("Figura CIRCULO com raio de " + String.format("%.2f", circulo.getRaio()) + " adicionada");
                lista.add(circulo);
                break;
            case 2:
                Triangulo triangulo = new Triangulo();
                triangulo.setLados();
                System.out.println("Figura TRIANGULO de lados: " + String.format("%.2f",triangulo.getLados()[0]) + " , " +
                        String.format("%.2f",triangulo.getLados()[1]) + " e " + String.format("%.2f", triangulo.getLados()[2]) + " adicionada");
                lista.add(triangulo);
                break;
            case 3:
                Retangulo retangulo = new Retangulo();
                retangulo.setAltura();
                retangulo.setBase();
                System.out.println("Figura RETANGULO de base " +String.format("%.2f", retangulo.getBase()) + 
                                   " e altura " + String.format("%.2f", retangulo.getAltura()) + " adicionado");
                lista.add(retangulo);
                break;
            default:
                System.out.println("Opcao invalida");
                break;
        }
    }
    
    public static void mostrarPerimetro(){
        for(int i=0; i<lista.size(); i++){
            System.out.println(lista.get(i).mostrarPerimetro());
        }
    }
    
    public static void mostrarArea(){
        for(int i=0; i<lista.size(); i++){
            System.out.println(lista.get(i).mostrarArea());
        }
    }
    
    public static boolean isCirculo(FormaGeometrica forma){
        if(forma instanceof Circulo){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isRetangulo(FormaGeometrica forma){
        if(forma instanceof Retangulo){
            return true;
        }else{
            return false;
        }
    }
    
    public static boolean isTriangulo(FormaGeometrica forma){
        if(forma instanceof Triangulo){
            return true;
        }else{
            return false;
        }
    }
}
