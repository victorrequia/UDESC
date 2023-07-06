package socket;

import java.io.IOException;
import java.net.Socket;

import apresentacao.Apresentacao;

public class Client {
    public final static String SERVER_ADDRESS = "127.0.0.1"; // Endereço IP do servidor
    public final static int PORT = 12000; // Porta do servidor
    public static ClientSocket clientSocket; // Socket do cliente
    public static int vidaPersonagem = 100;
    public static int pontoPersonagem = 0;
    public static int salaPersonagem = 0;

    /// Inicializa a conexão do cliente com o servidor
    public void main() {
        try {
            clientSocket = new ClientSocket(new Socket(SERVER_ADDRESS, PORT));
            Apresentacao.barraVida.setValue(vidaPersonagem);
            ;
        } catch (IOException e) {
            Apresentacao.textArea.append("Erro ao estabelecer conexão com o servidor\n");
            Apresentacao.textArea
                    .append("Verifique se o servidor está online ou recebendo conexão com a porta 12000\n");
        }
    };

    public static void main(String[] args) {
        Client client = new Client();
        client.main();
    }
}