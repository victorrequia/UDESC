import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient implements Runnable {
    // Atributos da classe
    private final String SERVER_ADDRESS = "127.0.0.1"; // Endereço do servidor
    private final int PORT = 4000; // Porta do servidor
    private ClientSocket clientSocket; // Instância socket do cliente
    private Scanner scanner; // Instância da classe leitora do teclado

    // Construtor da classe, inicializa um objeto Scanner para leitura das entradas
    // do usuário.
    public ChatClient() {
        scanner = new Scanner(System.in);
    }

    // Inicia o cliente de chat conectando ao servidor com o endereço IP e porta
    public void start() throws IOException {
        try {
            clientSocket = new ClientSocket(new Socket(SERVER_ADDRESS, PORT));
            System.out.println("Cliente conectado ao servidor " + SERVER_ADDRESS + ":" + PORT);
            new Thread(this).start();
            messageLoop();
        } finally {
            clientSocket.close();
        }
    }

    // Thread utilizada para receber as mensagens enviadas pelo servidor
    @Override
    public void run() {
        String msg;
        while ((msg = clientSocket.getMessage()) != null)
            System.out.printf("Mensagem recebida: %s\n", msg);
    }

    // Envia as mensagens enviadas pelo servidor
    private void messageLoop() throws IOException {
        String msg;
        do {
            System.out.println("Digite uma mensagem (!sair para finalizar): ");
            msg = scanner.nextLine();
            clientSocket.sendMsg(msg);
        } while (!msg.equalsIgnoreCase("!sair"));
    }

    // Método principal de execução
    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        try {
            chatClient.start();
        } catch (IOException exception) {
            System.out.println("Erro ao iniciar cliente: " + exception);
        }

        System.out.println("Cliente finalizado");
    }

}
