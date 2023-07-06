package com.sditf;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.UUID;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class Clone implements MqttCallback {
    private static ArrayList<String> mensagens = new ArrayList<String>();
    private static String id = UUID.randomUUID().toString();
    private static InterfaceRemota stub = null;
    private MqttClient mqttClient;

    public Clone() {
        conexao_BROKER();
        System.out.println("Servidor clone conectado ao broker ...");

        conexao_RMI();
        System.out.println("Servidor clone conectado a interface RMI ...");

        System.out.println("Servidor clone {" + this.getId() + "} pronto para uso ...");
    }

    // Conexão Broker MQTT
    public void conexao_BROKER() {
        try {
            mqttClient = new MqttClient("tcp://localhost:1883", id, new MemoryPersistence());
            MqttConnectOptions option = new MqttConnectOptions();
            option.setCleanSession(true);
            mqttClient.setCallback(this);
            mqttClient.connect(option);
            mqttClient.subscribe("master/mensagem");
        } catch (MqttException exception) {
            System.out.println("[Erro] Falha na conexao com o Broker");
            System.out.println(exception.getStackTrace());
        }
    }

    // Conexão RMI
    public void conexao_RMI() {
        try {
            // Obtem o stub para o registro
            Registry registry;
            registry = LocateRegistry.getRegistry("127.0.0.1", 1099);

            // Obtem o stub para o objeto remoto
            stub = (InterfaceRemota) registry.lookup("InterfaceRemota");

            // Adiciona o histórico a lista de mensagens
            ArrayList<String> auxiliar = stub.getListOfMsg();
            for (String string : auxiliar) {
                mensagens.add(string);
            }
            System.out.println("Servidor clone recuperou o historico de mensagens ...");
        } catch (Exception exception) {
            System.out.println("[Erro] Falha na conexao RMI");
            System.out.println(exception.getStackTrace());
        }
    }

    // Métodos Broker MQTT
    @Override
    public void connectionLost(Throwable throwable) {
        System.out.println("Conexao com Broker perdida" + throwable);
    }

    @Override
    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        System.out.println("Nova mensagem: Topico {" + topic + "} Mensagem {" + mqttMessage + "}");
        String mensagem = new String(mqttMessage.getPayload());
        mensagens.add(mensagem);
        System.out.println("Hisotrico de mensagens: " + mensagens);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        System.out.println("deliveryComplete: {" + iMqttDeliveryToken + "}");
    }

    public static void main(String[] args) {
        Controlador.adicionaClone(new Clone());
    }

    // Getters
    public String getId() {
        return id;
    }
}
