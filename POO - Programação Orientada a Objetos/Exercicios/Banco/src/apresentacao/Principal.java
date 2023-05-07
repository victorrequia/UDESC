package apresentacao;

import java.util.Scanner;
import dados.ContaBancaria;
import dados.ContaCorrente;
import dados.ContaSalario;
import negocios.Sistema;

public class Principal {
    private static Sistema sistema = new Sistema();
    private static Scanner teclado = new Scanner(System.in);
    
    public static void main(String[] args){
        int opcao = -1;
        while(opcao != 0){
            imprimeMenu();
            opcao = teclado.nextInt();
            
            switch (opcao){
                case 0:
                    break;
                case 1:
                    cadastrarConta();
                    break;
                case 2:
                    realizarSaque();
                    break;
                case 3:
                    realizarDeposito();
                    break;
                case 4:
                    exibirExtrato();
                    break;
                default:
                    System.out.println("Opcao invalida");
                    break;
            }
        }
    }
    
    public static void imprimeMenu(){
        System.out.println("-------------------------------");
        System.out.println("Escolha uma operação: ");
        System.out.println("0 - Sair");
        System.out.println("1 - Cadastrar Conta");
        System.out.println("2 - Realizar Saque");
        System.out.println("3 - Realizar Deposito");
        System.out.println("4 - Exibir Extrato");
        System.out.println("-------------------------------");
    }
    public static void cadastrarConta(){
        System.out.println("Que tipo de conta voce deseja cadastrar: ");
        System.out.println("1 - Conta Corrente");
        System.out.println("2 - Conta Salario");
        int opcao = teclado.nextInt();

        switch (opcao){
            case 1:
                sistema.cadastrarConta(novaContaCorrente());
                break;
            case 2:
                sistema.cadastrarConta(novaContaSalario());
                break;
            default:
                System.out.println("Opcao inválida!");
            break;
        }
    }
    
    public static void realizarSaque(){
        ContaBancaria conta = escolherConta();
        if(conta != null){
            System.out.println("Digite o valor a ser sacado");
            float valor= teclado.nextFloat();
            System.out.println(sistema.realizarSaque(conta, valor));
        }else{
            System.out.println("Opcao invalida");
        }
    }
    
    public static void realizarDeposito(){
        ContaBancaria conta = escolherConta();
        
        if(conta != null){
            if(conta instanceof ContaCorrente){
                System.out.println("Digite o valor a ser depositado");
                float valor = teclado.nextFloat();
                sistema.realizarDepositor((ContaCorrente)(conta), valor);
                System.out.println("Deposito realizado com sucesso");
                System.out.println(sistema.obterExtrato((ContaCorrente)(conta)));
            }
            else{
                if(conta instanceof ContaSalario){
                    System.out.println("Digite o valor a ser depositado");
                    float valor = teclado.nextFloat();
                    System.out.println("Digite o cnpj da empresa");
                    int cnpj = teclado.nextInt();
                    
                    if(sistema.realizarDeposito((ContaSalario)(conta), valor, cnpj)){
                        System.out.println("Deposito realizado com sucesso");
                        sistema.obterExtrato(conta);
                    }else{
                        System.out.println("Falha ao realizar a operação");
                    }
                }
            }
        }else{
            System.out.println("Esta conta não existe");
        }
    }
    
    public static void exibirExtrato(){
        ContaBancaria conta = escolherConta();
        
        if(conta!=null){
            System.out.println(sistema.obterExtrato(conta));
        }else{
            System.out.println("Esta conta não existe");
        }
    }
    
    public static ContaCorrente novaContaCorrente(){
        ContaCorrente conta = new ContaCorrente();
        
        System.out.println("Digite seu cpf: ");
        conta.setCpf(teclado.nextInt());
        return conta;
    }
    
    public static ContaSalario novaContaSalario(){
        ContaSalario conta = new ContaSalario();
        
        System.out.println("Digite seu cpf");
        conta.setCpf(teclado.nextInt());
        System.out.println("Digite o cnpj da empresa");
        conta.setCnpjEmpresa(teclado.nextInt());
        return conta;
    }
    
    public static void exibirContas(){
        for (int i=0; i<sistema.getQuantidadeContas(); i++){
            System.out.println("Conta " + i + ":\n" + sistema.getContas()[i].toString() + "\n");
        }
    }
    
    public static ContaBancaria escolherConta(){
        exibirContas();
        
        System.out.println("Digite o numero da conta");
        int nconta = teclado.nextInt();
        if(nconta < sistema.getQuantidadeContas()){
            return sistema.getContas()[nconta];
        }else{
            System.out.println("Opcao invalida");
            return null;
        }   
    }
}
