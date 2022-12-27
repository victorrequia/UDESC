package apresentacao;

import java.util.Scanner;
import dados.Contato;
import negocio.ListaTelefonica;

public class Main {
    public static void main(String[] args){
        menu();
    }
    
    private static ListaTelefonica sistema = new ListaTelefonica();
    private static Scanner teclado = new Scanner(System.in);

    private static Contato novoContato(){
        Contato c = new Contato();
        
        System.out.println("Digite o nome: ");
        c.setNome(teclado.nextLine());
        System.out.println("Digite o telefone: ");
        c.setTelefone(Integer.parseInt(teclado.nextLine()));
        
        return c;
    }

    private static void mostrarContatos(){
        for(int i=0; i<sistema.buscarContatos().size(); i++){
            System.out.println("Contato " + i);
            System.out.println(sistema.buscarContatos().get(i));
            System.out.println();
        }
    }
    
    private static Contato escolherContato(){
        mostrarContatos();
        System.out.println("Escolha um contato");
        int escolha = Integer.parseInt(teclado.nextLine());
        if(escolha < sistema.buscarContatos().size()){
            return sistema.buscarContatos().get(escolha);
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
                    Contato c1 = novoContato();
                    boolean jaExiste = false;
                    for(int i=1; i<sistema.buscarContatos().size(); i++){
                    Contato c2 = sistema.buscarContatos().get(i);
                        if(c1.equals(c2)){
                            jaExiste = true;
                        }
                    }
                    if(jaExiste){
                        System.out.println("ERRO:O contato ja existe no cadastro");
                    }else{
                        sistema.adicionarContato(c1);   
                    }
                    break;
                case 2:
                    sistema.removerContato(escolherContato());
                    break;
                case 3:
                    mostrarContatos();
                    break;
                case 4:
                    System.out.println("Digite a primeira letra do contato");
                    char letra = teclado.nextLine().charAt(0);
                    if(sistema.buscarContato(letra).size()>0){
                        for(Contato c : sistema.buscarContato(letra)){
                            System.out.println(c.toString());
                        }
                    }else{
                        System.out.println("Nenhum contato com essa letra");
                    }
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
        System.out.println("1 - Cadastrar Contato");
        System.out.println("2 - Remover Contato");
        System.out.println("3 - Mostrar Contatos");
        System.out.println("4 - Buscar Contato");
    }
}
