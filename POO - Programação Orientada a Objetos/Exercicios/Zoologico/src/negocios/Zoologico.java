package negocios;

import dados.Animal;
import dados.Aquario;
import dados.Peixe;
import dados.Viveiro;

public class Zoologico {
    private Viveiro[] viveiros = new Viveiro[100];
    private Animal[] animais = new Animal[500];
    private int quantAnimais=0;
    private int quantViveiros=0;
    private int quantSoAquarios=0;
    private int quantSoViveiros=0;
    
    //Metodos
    public void mostraAnimais(Viveiro viveiro){
        for(int i=0; i<quantViveiros; i++){
            if(viveiros[i] == viveiro){
                System.out.println(viveiros[i].mostraAnimaisViveiro());
            }  
        }
    }
    
    public boolean alocarAnimal(Animal animal, Viveiro viveiro){
        if(animal instanceof Peixe){
            viveiro.adicionaAnimal((Peixe)animal);
            return true;
        }
        viveiro.adicionaAnimal(animal);
        return true;
    }
    
    public void cadastrarViveiro(Viveiro viveiro){
        if(quantViveiros < 100){
            viveiros[quantViveiros] = viveiro;
            quantViveiros++;
            System.out.println("Viveiro cadastrado com sucesso!");
        }else{
            System.out.println("Não é possível adicionar mais viveiros!");
        }
    }
    
    public void cadastrarAnimais(Animal animal){
        if(quantAnimais < 500){
            animais[quantAnimais] = animal;
            quantAnimais++;
        }else{
            System.out.println("Não é possível adicionar mais animais");
        }
    }
    
    public Aquario[] getSoAquarios(){
        int numAquarios = quantidadeAquarios();
        
        Aquario[] aquarios = new Aquario[numAquarios];
        int j=0;
        for(int i=0; i<quantViveiros; i++){
            if(viveiros[i] instanceof Aquario){
                aquarios[j] = (Aquario)viveiros[i];
                j++;
            }
        }
        return aquarios;
    }
    
    public Viveiro[] getSoViveiro(){
        int numViveiros= quantidadeViveiros();
        
        Viveiro[] getViveiros = new Viveiro[numViveiros];
        int j=0;
        for(int i=0; i<quantViveiros; i++){
            if(!(viveiros[i] instanceof Aquario)){
                getViveiros[j] = viveiros[i];
                j++;
            }
        }
        return getViveiros;
    }
    
    public int quantidadeAquarios(){
        int numAquarios = 0;
        for(int i=0; i<quantViveiros; i++){
            if(viveiros[i] instanceof Aquario){
                numAquarios++;
            }
        }
        return  numAquarios;
    }
    
    public int quantidadeViveiros(){
        int numAquarios = 0;
        for(int i=0; i<quantViveiros; i++){
            if(viveiros[i] instanceof Aquario){
                numAquarios++;
            }
        }
        
        int numViveiros= quantViveiros-numAquarios;
        return numViveiros;
    }
    
    public int getQuantidadeViveiros(){
        return quantViveiros;
    }
    
    public int getQuantSoAquarios(){
        return quantSoAquarios;
    }
    
    public int getQuantSoViveiros(){
        return quantSoViveiros;
    }
    
    public int getQuantidadeAnimais(){
        return quantAnimais;
    }
    
    public Animal[] getAnimal(){
        return animais;
    }
    
    public Viveiro[] getViveiros(){
        return viveiros;
    }

}
