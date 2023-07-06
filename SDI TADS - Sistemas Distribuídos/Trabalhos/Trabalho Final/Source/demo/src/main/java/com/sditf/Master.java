package com.sditf;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttClient;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Master implements InterfaceRemota {
    private static ArrayList<String> mensagens = new ArrayList<String>();
    private static IMqttClient client = null;
    private static String id = UUID.randomUUID().toString();

    public Master() {
        System.out.println("Servidor master {" + this.getId() + "} criado ...");

        conexao_BROKER();
        System.out.println("Servidor master conectado ao broker MQTT ...");

        conexao_RMI(this);
        System.out.println("Interface RMI pronta para uso ...");

        System.out.println("Servidor master pronto para uso ...");
    }

    // Conexão com Broker MQTT
    private static void conexao_BROKER() {
        try {
            client = new MqttClient("tcp://127.0.0.1:1883", id, new MemoryPersistence());
            MqttConnectOptions option = new MqttConnectOptions();
            option.setCleanSession(true);
            client.connect(option);
        } catch (Exception exception) {
            System.out.println("[Erro] Falha na conexao com o Broker");
            System.out.println(exception.getStackTrace());
        }
    }

    // Conexão RMI
    private static void conexao_RMI(Master master) {
        try {
            // Criação e exportação do Objeto Remoto
            Master obj = master;
            InterfaceRemota stub = (InterfaceRemota) UnicastRemoteObject.exportObject(obj, 0);

            // Registro do Objeto Remoto com Java RMI Registry
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("InterfaceRemota", stub);
        } catch (Exception exception) {
            System.out.println("[Erro] Falha na conexao RMI");
            System.out.println(exception.getStackTrace());
        }
    }

    // Métodos RMI
    @Override
    public String echo(String mensagem) throws RemoteException {
        mensagens.add(mensagem);

        // Publicando mensagem no Broker
        MqttMessage message = new MqttMessage(mensagem.getBytes());
        message.setQos(2);

        // Envia mensagem para o broker
        try {
            client.publish("master/mensagem", message);
        } catch (Exception exception) {
            System.out.println("[Erro] Falha ao enviar mensagem para o broker");
            System.out.println(exception.getStackTrace());
        }

        System.out.println("Mensagem do cliente " + client.getClientId() + " enviada ao broker ...");
        System.out.println("Historico de mensagens: " + mensagens);
        return mensagem;
    }

    @Override
    public ArrayList<String> getListOfMsg() throws RemoteException {
        return mensagens;
    }

    public static void main(String[] args) {
        new Master();
    }

    public boolean keepAlive(){
        return true;
    }

    // Getters
    public String getId() {
        return id;
    }
}
