import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Iterator;

public class ServidorSocket {
    // Atributos da classe
    public final PrintWriter out;
    public BufferedReader in;

    // Contrutor da classe ServidorSocket instânciando o PrintWriter
    public ServidorSocket(Socket socket) throws IOException {
        this.out = new PrintWriter(socket.getOutputStream(), true);
        this.in = new BufferedReader(new InputStreamReader(System.in));
    }

    // Servidor envia as mensagens para os clientes
    public void serverMsgToAll(ServerSocket server, String msg) {
        Iterator<ClientSocket> iterator = ChatServer.clients.iterator();
        while (iterator.hasNext()) {
            out.println(msg);
            iterator.next();
        }
    }

}