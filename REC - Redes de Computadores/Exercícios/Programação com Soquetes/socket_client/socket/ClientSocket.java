package socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.regex.Pattern;

import apresentacao.Apresentacao;

public class ClientSocket {
    private final Socket socket;
    private final InputStream in;
    private final PrintWriter out;

    /// Contrutor da classe (estabelece a conexão com o servidor)
    public ClientSocket(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream(); // Recebendo mensagem do servidor
        this.out = new PrintWriter(socket.getOutputStream(), true); // Enviando mensagem para o servidor
        Apresentacao.textArea
                .append("Cliente: " + socket.getRemoteSocketAddress() + " conectado\n START para começar!");
    }

    // Função para receber mensagem do servidor
    public String getMessage() throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead = in.read(buffer);
        String response = new String(buffer, 0, bytesRead, "utf-8");
        return treatMessage(response);
    }

    // Função para enviar mensagem para o servidor
    public void sendMensagem(String mensagem) throws IOException {
        out.println(mensagem);
    }

    // Tratar mensagem recebida
    public String treatMessage(String message_server) {
        String message_vector[] = message_server.split(Pattern.quote(";"));
        System.out.println(message_server);

        String mensagem = message_vector[0];

        // Monstro Escondido
        if (mensagem.equals("MONSTER_ATTACK")) {
            String portas = message_vector[1];
            Apresentacao.trocarImagem("images/monstro-1.png");
            return "Monstro Escondido! Escolha uma porta entre 0 e " + portas + "\n";
        }

        if (mensagem.equals("MONSTER_ATTACKED")) {
            Apresentacao.trocarImagem("images/blood.png");
            int vida_atual = Integer.parseInt(message_vector[1]);
            int vida_perdida = Client.vidaPersonagem - vida_atual;
            Client.vidaPersonagem = vida_atual;
            Apresentacao.barraVida.setString("Vida: " + Client.vidaPersonagem);
            Apresentacao.barraVida.setValue(Client.vidaPersonagem);
            return "Monstro te atacou e tirou " + vida_perdida + " pontos de vida! Vá para a próxima sala\n";
        }

        if (mensagem.equals("MONSTER_KILLED")) {
            Apresentacao.trocarImagem("images/pontos.png");
            int pontos_atuais = Integer.parseInt(message_vector[2]);
            int pontos_ganhos = pontos_atuais - Client.pontoPersonagem;
            Client.pontoPersonagem = pontos_atuais;
            Apresentacao.barraPontos.setString("Ponto: " + Client.pontoPersonagem);
            Apresentacao.barraPontos.setValue(Client.pontoPersonagem);
            return "Parabéns, você matou o monstro e recebeu " + pontos_ganhos + " pontos! Continue caminhando\n";
        }

        // Baú encontrado
        if (mensagem.equals("TAKE_CHEST")) {
            Apresentacao.trocarImagem("images/bau-de-tesouro.png");
            return "Você encontrou um baú!! Deseja aceitar ?\n";
        }

        if (mensagem.equals("CHEST_VALUE")) {
            int pontos = Integer.parseInt(message_vector[1]);
            if (pontos >= 0) {
                Client.pontoPersonagem += pontos;
                Apresentacao.barraPontos.setString("Ponto: " + Client.pontoPersonagem);
                Apresentacao.barraPontos.setValue(Client.pontoPersonagem);
                return "Você recebeu " + pontos + " pontos\n";
            } else {
                Client.pontoPersonagem += pontos;
                Apresentacao.barraPontos.setString("Ponto: " + Client.pontoPersonagem);
                Apresentacao.barraPontos.setValue(Client.pontoPersonagem);
                return "Você perdeu " + pontos + " pontos\n";
            }
        }

        if (mensagem.equals("SKIPPING_CHEST")) {
            return "Nem sempre é bom contar com a sorte! Continue caminhando\n";
        }

        // Chefão
        if (mensagem.equals("BOSS_EVENT")) {
            Apresentacao.trocarImagem("images/boss.png");
            return "Boss encontrado! Lutar ou Correr ?\n";
        }

        if (mensagem.equals("ESCAPED")) {
            Apresentacao.trocarImagem("images/scape.png");
            int vida_atual = Integer.parseInt(message_vector[1]);
            int vida_perdida = Client.vidaPersonagem - vida_atual;
            Client.vidaPersonagem = vida_atual;
            Apresentacao.barraVida.setString("Vida: " + Client.vidaPersonagem);
            Apresentacao.barraVida.setValue(Client.vidaPersonagem);
            return "Você correu do BOSS mas tomou um dano de " + vida_perdida + " pontos\n";
        }

        if (mensagem.equals("FAILED_BOSS_FIGHT")) {
            Apresentacao.trocarImagem("images/fight.png");
            int vida_atual = Integer.parseInt(message_vector[1]);
            int vida_perdida = Client.vidaPersonagem - vida_atual;
            Client.vidaPersonagem = vida_atual;
            Apresentacao.barraVida.setString("Vida: " + Client.vidaPersonagem);
            Apresentacao.barraVida.setValue(Client.vidaPersonagem);
            return "Você lutou mas sofreu " + vida_perdida + " de dano! Continue caminhando\n";
        }

        if (mensagem.equals("BOSS_DEFEATED")) {
            Apresentacao.trocarImagem("images/fight.png");
            int vida_atual = Integer.parseInt(message_vector[1]);
            int vida_perdida = Client.vidaPersonagem - vida_atual;
            Client.vidaPersonagem = vida_atual;
            Apresentacao.barraVida.setString("Vida: " + Client.vidaPersonagem);
            Apresentacao.barraVida.setValue(Client.vidaPersonagem);

            int pontos_atuais = Integer.parseInt(message_vector[2]);
            int pontos_ganhos = pontos_atuais - Client.pontoPersonagem;
            Client.pontoPersonagem = pontos_atuais;
            Apresentacao.barraPontos.setString("Ponto: " + Client.pontoPersonagem);
            Apresentacao.barraPontos.setValue(Client.pontoPersonagem);
            return "Parabéns, você matou o BOSS e ganhou " + pontos_ganhos + " pontos\nporém perdeu " + vida_perdida
                    + " pontos de vida! Continue caminhando\n";
        }

        // Nada Aconteceu
        if (mensagem.equals("NOTHING_HAPPENED")) {
            return "Nada aconteceu! Continue caminhando\n";
        }

        // Final do jogo
        if (mensagem.equals("WIN")) {
            Apresentacao.trocarImagem("images/distintivo.png");
            return "Parabéns, você venceu o jogo!\n";
        }

        if (mensagem.equals("GAME_OVER")) {
            Apresentacao.trocarImagem("images/game-over.png");
            return "Que pena, você perdeu!\n";
        }

        return "Mensagem inválida\n";
    }
}
