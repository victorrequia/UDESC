package apresentacao;

import java.util.Scanner;
import dados.Pessoa;
import negocio.Sistema;

public class Main {
    public static void main(String[] args){
        menu();
    }
    
    private static Sistema sistema = new Sistema();
    private static Scanner teclado = new Scanner(System.in);

    private static Pessoa novaPessoa(){
        Pessoa p = new Pessoa();
        
        System.out.println("Digite o nome: ");
        p.setNome(teclado.nextLine());
        System.out.println("Digite a idade: ");
        p.setIdade(Integer.parseInt(teclado.nextLine()));
        System.out.println("Digite a altura: ");
        p.setAltura(Float.parseFloat(teclado.nextLine()));
        System.out.println("Digite a massa: ");
        p.setMassa(Float.parseFloat(teclado.nextLine()));
        
        return p;
    }

    private static void mostrarPessoas(){
        for(int i=0; i<sistema.getLista().size(); i++){
            System.out.println("Pessoa " + i);
            System.out.println(sistema.getLista().get(i));
            System.out.println();
        }
    }
    
    private static Pessoa escolherPessoa(){
        mostrarPessoas();
        System.out.println("Escolha uma pessoa");
        int escolha = Integer.parseInt(teclado.nextLine());
        if(escolha < sistema.getLista().size()){
            return sistema.getLista().get(escolha);
        }else{
            return null;
        }
        
    }
    
    public static void menu(){
        int opcao = -1;
        while(opcao != 0){
            imprimeMenu();
            opcao = Integer.parseInt(teclado.nextLine());
            
            switch (opcao){
                case 0:
                    break;
                case 1:
                    Pessoa p1 = novaPessoa();
                    boolean jaExiste = false;
                    for(int i=1; i<sistema.getLista().size(); i++){
                    Pessoa p2 = sistema.getLista().get(i);
                        if(p1.equals(p2)){
                            jaExiste = true;
                        }
                    }
                    if(jaExiste){
                        System.out.println("ERRO:A pessoa ja existe no cadastro");
                    }else{
                        sistema.adicionarPessoa(p1);   
                    }
                    break;
                case 2:
                    sistema.removerPessoa(escolherPessoa());
                    break;
                case 3:
                    mostrarPessoas();
                    break;
                default:
                    System.out.println("Opcão inválida");
                    break;
            }
            
        }
    }
    
    public static void imprimeMenu(){
        System.out.println("Escolha uma opcão");
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar Pessoa");
        System.out.println("2 - Remover Pessoa");
        System.out.println("3 - Mostrar Pessoas");
    }
}
