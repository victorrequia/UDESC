package com.sditf;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Controlador extends Thread {
    private static InterfaceRemota stub = null;
    private static ArrayList<Clone> clones = new ArrayList<Clone>();

    public Controlador() {
        conexao_RMI();
    }

    public static void main(String[] args) throws RemoteException {
        new Controlador();
        System.out.println("Controlador intanciado com sucesso ...");

        while (true) {
            try {
                if (stub.keepAlive()) {
                    // Envie a mensagem de keep alive aqui
                    System.out.println("Enviando mensagem de vida ao servidor master...");

                    try {
                        Thread.sleep(30000);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                } else {
                    System.out.println("Nao existe servidor master ...");

                    try {
                        Thread.sleep(15000);
                    } catch (InterruptedException exception) {
                        exception.printStackTrace();
                    }
                }
            } catch (Exception exception) {
                try {
                    Thread.sleep(30000);
                    System.out.println("Servidor master parou de funcionar");
                    System.out.println("Aguarde para restabelecer a conexao ...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void adicionaClone(Clone clone) {
        clones.add(clone);
        System.out.println("Servidor clone adicionado a lista de servidores ...");
    }

    public void conexao_RMI() {
        try {
            // Obtem o stub para o registro
            Registry registry;
            registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
            // Obtem o stub para o objeto remoto
            stub = (InterfaceRemota) registry.lookup("InterfaceRemota");
        } catch (Exception exception) {
            System.out.println("[Erro] Falha na conexao RMI");
            System.out.println(exception.getStackTrace());
        }
    }

}
