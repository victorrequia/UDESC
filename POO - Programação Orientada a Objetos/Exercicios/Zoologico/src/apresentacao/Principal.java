package apresentacao;

import java.util.Scanner;
import negocios.Zoologico;
import dados.Animal;
import dados.Aquario;
import dados.Peixe;
import dados.Viveiro;

public class Principal {
    private static Zoologico sistema = new Zoologico();
    private static Scanner teclado = new Scanner(System.in);
    
    
    public static void main(String[] args){
        int opc=-1;
        
        while(opc != 0){
            exibeMenu();
            opc = teclado.nextInt();
            
            switch (opc){
                case 0:
                    break;
                case 1:
                    cadastrarViveiro();
                    break;
                case 2:
                    cadastrarAnimais();
                    break;
                case 3:
                    mostrarTodosViveiros();
                    break;
                case 4:
                    animaisViveiro();
                    break;
                case 5:
                    animaisAquario();
                break;
            }
        }
    }
    
    public static void exibeMenu(){
        System.out.println("--------------------------------");
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar viveiro");
        System.out.println("2 - Cadastrar animal");
        System.out.println("3 - Mostrar viveiros cadastrados");
        System.out.println("4 - Mostrar animais do viveiro");
        System.out.println("5 - Mostrar peixes do aquario");
        System.out.println("--------------------------------");
    }
    
    
    public static void mostrarTodosViveiros(){
        if(sistema.getQuantidadeViveiros()!= 0){
            for(int i=0; i<sistema.getQuantidadeViveiros(); i++){
                System.out.println("Viveiro: " + i + "\n" + sistema.getViveiros()[i].mostraViveiro());
            }
        }else{
            System.out.println("Nenhum viveiro foi cadastrado!");
        }
    }
    
    public static void animaisViveiro(){
           mostrarViveiros();
           Viveiro viveiro_escolhido = escolherViveiro();
           sistema.mostraAnimais(viveiro_escolhido);
    }
    
    public static void animaisAquario(){
           mostrarAquarios();
           Aquario viveiro_escolhido = escolherAquario();
           sistema.mostraAnimais(viveiro_escolhido);
    }
    
    public static void cadastrarAnimais(){
        System.out.println("1 - Cadastrar Animal");
        System.out.println("2 - Cadastrar Peixe");
        int escolha = teclado.nextInt();
        
        switch (escolha){
            case 1:
                cadastraAnimal();
                break;
            case 2:
                cadastraPeixe();
                break;
        }
    }
    
    public static void alocarAnimal(Animal animal){
           if(animal instanceof Peixe){
              if(sistema.quantidadeAquarios() != 0){
                System.out.println("\n---------------------------------------\nEscolha um aquario para alocar o peixe:\n---------------------------------------\n");
                mostrarAquarios();
                Aquario aquario_escolhido = escolherAquario();
                sistema.alocarAnimal(animal, aquario_escolhido);
              }else{
                  System.out.println("Cadastro incompleto: Nenhum aquario foi cadastrado!");
              }
           }else{
               if(sistema.quantidadeViveiros() != 0){
                System.out.println("\n---------------------------------------\nEscolha um viveiro para alocar o animal:\n---------------------------------------\n");
                mostrarViveiros();
                Viveiro viveiro_escolhido = escolherViveiro();
                sistema.alocarAnimal(animal, viveiro_escolhido);
                }else{
                System.out.println("Cadastro incompleto: Nenhum viveiro foi cadastrado!");
                }
            }
    }
  
    public static void mostraAnimais(){
        for(int i=0; i<sistema.getQuantidadeAnimais(); i++){
            System.out.println("--------------------\n"+ "Animal: " + i + "\n"+ sistema.getAnimal()[i].toString() + "\n------------------\n");
        }
    }
  
    public static Animal escolherAnimal(){
        mostraAnimais();
        System.out.println("Qual numero do animal para alocar?");
        int animal = teclado.nextInt();
        if(animal < sistema.getQuantidadeAnimais()){
            return sistema.getAnimal()[animal];
        }else{
            System.out.println("Numero invalido");
            return null;
        }
    }
    
    public static void cadastrarViveiro(){
        System.out.println("1 - Cadastrar Viveiro");
        System.out.println("2 - Cadastrar Aquario");
        int opcao = teclado.nextInt();
        
        switch (opcao){
            case 1:
                sistema.cadastrarViveiro(novoViveiro());
                break;
            case 2:
                sistema.cadastrarViveiro(novoAquario());
                break;
            default:
                System.out.println("Opcao Invalida");
                break;
        }
    }
    
    public static void mostrarViveiros(){
        if(sistema.getQuantidadeViveiros()!= 0){
            for(int i=0; i<sistema.getQuantidadeViveiros(); i++){
                System.out.println("Viveiro: " + i + "\n" + sistema.getSoViveiro()[i].mostraViveiro());
            }
        }else{
            System.out.println("Nenhum viveiro foi cadastrado!");
        }
    }
    
    public static Viveiro escolherViveiro(){
        System.out.println("Qual o numero do viveiro?");
        int numViveiro = teclado.nextInt();
        
        if(numViveiro < sistema.getQuantidadeViveiros()){
            return sistema.getSoViveiro()[numViveiro];
        }else{
            return null;
        }
    }
    
    public static void mostrarAquarios(){
        for(int i=0; i<sistema.getQuantidadeViveiros(); i++){
            System.out.println("Aquario: " + i + "\n" + sistema.getSoAquarios()[i].mostraViveiro());
        }
    }
    
    public static Aquario escolherAquario(){
        System.out.println("Qual o numero do aquario?");
        int numAquario = teclado.nextInt();
        
        if(numAquario < sistema.getQuantidadeViveiros()){
            return sistema.getSoAquarios()[numAquario];
        }else{
            return null;
        }
    }
    
    
        public static void cadastraAnimal(){
        Animal animal = new Animal();
        System.out.println("Nome do animal");
        teclado.nextLine();
        animal.setNome(teclado.nextLine());
        teclado.nextLine();
        System.out.println("Cor do animal");
        animal.setCor(teclado.nextLine());
        teclado.nextLine();
        System.out.println("Especie do animal");
        animal.setEspecie(teclado.nextLine());
        System.out.println("Idade do animal");
        animal.setIdade(teclado.nextInt());
        System.out.println("Largura do animal");
        animal.setLargura(teclado.nextFloat());
        System.out.println("Comprimento do animal");
        animal.setComprimento(teclado.nextFloat());
        
        sistema.cadastrarAnimais(animal);
        alocarAnimal(animal);
    }
    
    public static void cadastraPeixe(){
        Peixe peixe = new Peixe();
        System.out.println("Nome do peixe");
        teclado.nextLine();
        peixe.setNome(teclado.nextLine());
        teclado.nextLine();
        System.out.println("Cor do peixe");
        peixe.setCor(teclado.nextLine());
        teclado.nextLine();
        System.out.println("Especie do peixe");
        peixe.setEspecie(teclado.nextLine());
        System.out.println("Idade do peixe");
        peixe.setIdade(teclado.nextInt());
        System.out.println("Largura do peixe");
        peixe.setLargura(teclado.nextFloat());
        System.out.println("Comprimento do peixe");
        peixe.setComprimento(teclado.nextFloat());
        System.out.println("Altura do peixe");
        peixe.setAltura(teclado.nextFloat());
        System.out.println("Temperatura ideal");
        peixe.setTemperaturaIdeal(teclado.nextFloat());
        
        sistema.cadastrarAnimais(peixe);
        alocarAnimal(peixe);
    }
    
    public static Viveiro novoViveiro(){
        System.out.println("Quantos animais o viveiro podera abrigar?");
        int maxAnimais = teclado.nextInt();
        Viveiro viveiro = new Viveiro(25);
        teclado.nextLine();
        System.out.println("Qual o nome do viveiro: ");
        viveiro.setNome(teclado.nextLine());
        System.out.println("Qual a largura do viveiro");
        viveiro.setLargura(teclado.nextFloat());
        System.out.println("Qual o comprimento do viveiro");
        viveiro.setComprimento(teclado.nextFloat());
        return viveiro;
    }
    
    public static Aquario novoAquario(){
        System.out.println("Quantos peixes o aquario podera abrigar?");
        int maxPeixes = teclado.nextInt();
        Aquario aquario = new Aquario(25);
        teclado.nextLine();
        System.out.println("Digite o nome do aquario");
        aquario.setNome(teclado.nextLine());
        System.out.println("Digite a largura do aquario");
        aquario.setLargura(teclado.nextFloat());
        System.out.println("Digite o comprimento do aquario");
        aquario.setComprimento(teclado.nextFloat());
        System.out.println("Digita a altura do aquario");
        aquario.setAltura(teclado.nextFloat());
        System.out.println("Qual a temperatura ideal do aquario");
        aquario.setTemperatura(teclado.nextFloat());
        return aquario;
    }   
}