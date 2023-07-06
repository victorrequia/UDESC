import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ChatServer {
    // Atributos da classe
    private final int PORT = 4000;
    public static ServerSocket serverSocket;
    public static List<ClientSocket> clients = new LinkedList<>();
    ServidorSocket servidorSocket;

    // Inicia o servidor com a porta de origem e espera a coneção com cliente
    public void start() throws IOException {
        serverSocket = new ServerSocket(PORT);
        System.out.println("Servidor iniciado na porta: " + PORT);
        clientConnectionLoop();
    }

    // Verifica se cliente solicitou conexão com o servidor
    public void clientConnectionLoop() throws IOException {
        try {
            while (true) {
                Socket aux = serverSocket.accept();
                ClientSocket clientSocket = new ClientSocket(aux);
                logRegister(clientSocket.getRemoteSocketAddress().toString());
                clients.add(clientSocket);
                servidorSocket = new ServidorSocket(aux);
                new Thread(() -> serverMessageLoop()).start();
                new Thread(() -> clientMessageLoop(clientSocket)).start();
            }
        } catch (IOException exception) {
            System.out.println("Erro ao conectar com o servidor! " + exception);
        }
    }

    // Verifica se existe mensagem do cliente
    private void clientMessageLoop(ClientSocket clientSocket) {
        String msg;
        try {
            while ((msg = clientSocket.getMessage()) != null) {
                if ("!sair".equalsIgnoreCase(msg))
                    return;
                System.out.println("Mensagem " + clientSocket.getRemoteSocketAddress() + ": " + msg);
                sendMsgToAll(clientSocket, msg);
            }
        } finally {
            clientSocket.close();
        }
    }

    // Verifica se existe mensagem do servidor
    private void serverMessageLoop() {
        String msg;
        while (true) {
            try {
                msg = servidorSocket.in.readLine();
                servidorSocket.serverMsgToAll(serverSocket, msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Envia a mensagem de um cliente para os demais conectados
    private void sendMsgToAll(ClientSocket sender, String msg) {
        Iterator<ClientSocket> iterator = clients.iterator();
        while (iterator.hasNext()) {
            ClientSocket clientSocket = iterator.next();
            if (!sender.equals(clientSocket)) {
                if (!clientSocket.sendMsg("Cliente" + sender.getRemoteSocketAddress() + ": " + msg)) {
                    iterator.remove();
                }
            }
        }
    }

    // Log dos clientes conectados
    public void logRegister(String address) throws IOException {
        BufferedWriter logWriter = new BufferedWriter(new FileWriter("log.txt", true));
        String mensagem = "[" + new Date().toString() + "] Cliente conectado: " + address + "\n";
        logWriter.write(mensagem);
        logWriter.close();
    }

    // Método principal de execução
    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        try {
            server.start();
        } catch (IOException exception) {
            System.out.println("Erro ao iniciar servidor: " + exception.getMessage());
        }

        System.out.println("Servidor finalizado!");
    }

}
