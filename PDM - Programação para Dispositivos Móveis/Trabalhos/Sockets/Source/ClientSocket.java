import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientSocket {
    // Atributos da classe
    private final Socket socket;
    private final BufferedReader in;
    public final PrintWriter out;

    // Faz a conexão com o servidor
    public ClientSocket(Socket socket) throws IOException {
        this.socket = socket;
        System.out.println("Cliente: " + socket.getRemoteSocketAddress() + " conectou");
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(socket.getOutputStream(), true);
    }

    // Recebe o endereço do socket
    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    // Recebe uma mensagem do servidor
    public String getMessage() {
        try {
            return in.readLine();
        } catch (IOException exception) {
            return null;
        }
    }

    // Envia uma mensagem para o sevidor
    public boolean sendMsg(String msg) {
        out.println(msg);
        return !out.checkError();
    }

    // Fecha a conexão com o servidor
    public void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException exception) {
            System.out.println("Erro ao fechar o socket: " + exception.getMessage());
        }
    }
}