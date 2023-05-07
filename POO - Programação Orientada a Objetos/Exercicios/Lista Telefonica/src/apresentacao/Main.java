package apresentacao;

import java.util.Scanner;
import dados.Contato;
import negocio.ListaTelefonica;

public class Main {
    public static void main(String args[]){
        int opcao = -1;
        
        while(opcao != 0){
            System.out.println("Escolha uma opção:");
            System.out.println("0 - Sair");
            System.out.println("1 - Cadastrar Contato");
            System.out.println("2 - Remover Contato");
            System.out.println("3 - Mostrar todos os contatos");
            opcao = Integer.parseInt(teclado.nextLine());
            
            switch (opcao){
                case 0:
                    break;
                case 1:
                    lista.adicionaContato(novoContato());
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    exibirContatos();
                    break;
                default:
                    System.out.println("Numero Invalido");
                    break;
            }
        }
    }
    
    
    private static Scanner teclado = new Scanner(System.in);
    private static ListaTelefonica lista = new ListaTelefonica();

    public static Contato novoContato(){
        Contato c = new Contato();
        System.out.println("Digite o nome do contato:");
        c.setNome(teclado.nextLine());
        
        System.out.println("Digite o telefone do contato:");
        c.setTelefone(Long.parseLong(teclado.nextLine()));
        
        return c;
    }
    
    public static void exibirContatos(){
        lista.buscarContato().forEach(
                (chave, lista) -> {
                    System.out.println(chave + ":");
                
                    for(Contato contato : lista){
                        System.out.println(" " + contato.toString());
                    }
                }
        );
    }
    
    public static void exibirContatos(char letra){
        for(int i=0; i< lista.buscarContatos(letra).size();i++){
            System.out.println("------------------------------\nCodigo: " + i);
            System.out.println(lista.buscarContatos(letra).get(i).toString() + "\n------------------------------\n");
        }
    }
    
    public static void removerContato(){
        System.out.println("Escolha a primeira letra do nome da pessoa que deseja remover:");
        String letra = teclado.nextLine().toUpperCase();
        
        if(lista.buscarContatos(letra.charAt(0)).size() > 0){
            exibirContatos(letra.charAt(0));
            System.out.println("Escolha um contato que deseja remover");
            int cont = Integer.parseInt(teclado.nextLine());
            
            if(cont < lista.buscarContatos(letra.charAt(0)).size()){
                lista.removerContato(lista.buscarContatos(letra.charAt(0)).get(cont));
            }
        }else{
            System.out.println("Não existem contatos para serem removidos");
        }
    }
}
