package com.sditf;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private static InterfaceRemota stub = null;

    public Cliente() {
        stub = conexao_RMI("127.0.0.1", 1099);
    }

    private static InterfaceRemota conexao_RMI(String host, int port) {
        try {
            // Obtem o stub para o registro
            Registry registry = LocateRegistry.getRegistry(host, port);
            // Obtem o stub para o objeto remoto
            InterfaceRemota stub = (InterfaceRemota) registry.lookup("InterfaceRemota");
            System.out.println("Cliente conectado ao servidor master ...");
            return stub;
        } catch (Exception exception) {
            System.out.println("[Erro] Falha ao obter registro ou stub");
            System.out.println(exception.getStackTrace());
            return null;
        }
    }

    public static void main(String[] args) throws RemoteException {
        Scanner teclado = new Scanner(System.in);
        new Cliente();

        while (true) {
            System.out.println("(1) Enviar mensagem (2) Visualizar historico (3) Sair");
            int opcao = teclado.nextInt();

            if (opcao == 1) {
                System.out.println("Digite a mensagem:");
                String mensagem_cliente = teclado.next();
                String resposta_servidor = stub.echo(mensagem_cliente);
                System.out.println("Mensagem do servidor: " + resposta_servidor);
            }

            if (opcao == 2) {
                ArrayList<String> lista_resposta_servidor = stub.getListOfMsg();
                System.out.println("Hisotrico de mensagens: " + lista_resposta_servidor);
            }

            if (opcao == 3) {
                break;
            }
        }
        teclado.close();
    }
}
