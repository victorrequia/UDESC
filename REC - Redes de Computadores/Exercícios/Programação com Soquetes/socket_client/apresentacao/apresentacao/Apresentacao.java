package apresentacao;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import socket.Client;
import socket.ClientSocket;

public class Apresentacao extends JFrame {
    public static ClientSocket clientSocket;
    public static JTextArea textArea;
    public static JProgressBar barraVida;
    public static JProgressBar barraPontos;
    public static JProgressBar barraSalas;

    public static JPanel painelImagens;
    public static JLabel label;
    public static ImageIcon imageIcon;

    private JButton btnSTART;
    private JButton btnWALK;
    private JButton btnRUN;
    private JButton btnFIGHT;
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btnYES;
    private JButton btnNO;

    public Apresentacao() {
        // Icone da janela
        ImageIcon icon = new ImageIcon("images/favicon.png");
        setIconImage(icon.getImage());

        // Configurações Básicas da Janela
        setTitle("Sockets Adventure");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 450);
        setLocationRelativeTo(null);

        // Instanciando a interface
        painelImagens = new JPanel();
        Container contentPane = getContentPane();
        JPanel painelBarras = new JPanel();
        JPanel painelButtons1 = new JPanel();
        JPanel painelButtons2 = new JPanel();
        JPanel painelButtons3 = new JPanel();

        // Painel para troca de mensagem entre servidor e cliente
        JScrollPane scrollPane = new JScrollPane();
        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);

        // Barra de vida
        barraVida = new JProgressBar(0, 100);
        barraVida.setStringPainted(true);
        barraVida.setString("Vida: " + Client.vidaPersonagem + "%");
        painelBarras.add(barraVida);

        // Barra de pontos
        barraPontos = new JProgressBar(0, 500);
        barraPontos.setStringPainted(true);
        barraPontos.setString("Ponto: " + Client.pontoPersonagem);
        painelBarras.add(barraPontos);

        // Barra de salas
        barraSalas = new JProgressBar(0, 20);
        barraSalas.setStringPainted(true);
        barraSalas.setString("Sala: " + Client.salaPersonagem);
        painelBarras.add(barraSalas);

        // Imagem Herói
        imageIcon = new ImageIcon("images/super-heroi-captain.png");
        label = new JLabel(imageIcon);
        painelImagens.add(label);

        // Botões1
        JPanel buttonPanel1 = new JPanel();
        painelButtons1.add(buttonPanel1);

        btnSTART = new JButton("START");
        btnSTART.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                clientSocket = Client.clientSocket;
                try {
                    clientSocket.sendMensagem("`START`");
                } catch (IOException send_exception) {
                    textArea.setText("Erro ao enviar mensagem (" + send_exception.getMessage() + ")\n");
                }
                try {
                    textArea.setText(Client.clientSocket.getMessage());
                } catch (IOException receive_exception) {
                    textArea.setText("Erro ao receber mensagem (" + receive_exception.getMessage() + ")\n");
                }
            }
        });
        buttonPanel1.add(btnSTART);

        btnWALK = new JButton("WALK");
        btnWALK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    Client.salaPersonagem += 1;
                    barraSalas.setString("Sala: " + Client.salaPersonagem);
                    barraSalas.setValue(Client.salaPersonagem);
                    clientSocket.sendMensagem("`WALK`");
                } catch (IOException send_exception) {
                    textArea.append("Erro ao enviar mensagem (" + send_exception.getMessage() + ")\n");
                }
                try {
                    textArea.append(Client.clientSocket.getMessage());
                } catch (IOException receive_exception) {
                    textArea.append("Erro ao receber mensagem (" + receive_exception.getMessage() + ")\n");
                }
            }
        });
        buttonPanel1.add(btnWALK);

        btnRUN = new JButton("RUN");
        btnRUN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clientSocket.sendMensagem("`RUN`");
                } catch (IOException send_exception) {
                    textArea.append("Erro ao enviar mensagem (" + send_exception.getMessage() + ")\n");
                }
                try {
                    textArea.append(Client.clientSocket.getMessage());
                } catch (IOException receive_exception) {
                    textArea.append("Erro ao receber mensagem (" + receive_exception.getMessage() + ")\n");
                }
            }
        });
        buttonPanel1.add(btnRUN);

        btnFIGHT = new JButton("FIGHT");
        btnFIGHT.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clientSocket.sendMensagem("`FIGHT`");
                } catch (IOException send_exception) {
                    textArea.append("Erro ao enviar mensagem (" + send_exception.getMessage() + ")\n");
                }
                try {
                    textArea.append(Client.clientSocket.getMessage());
                } catch (IOException receive_exception) {
                    textArea.append("Erro ao receber mensagem (" + receive_exception.getMessage() + ")\n");
                }
            }
        });
        buttonPanel1.add(btnFIGHT);

        // Botões2
        JPanel buttonPanel2 = new JPanel();
        painelButtons2.add(buttonPanel2);

        btn0 = new JButton("0");
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clientSocket.sendMensagem("0");
                } catch (IOException send_exception) {
                    textArea.append("Erro ao enviar mensagem (" + send_exception.getMessage() + ")\n");
                }
                try {
                    textArea.append(Client.clientSocket.getMessage());
                } catch (IOException receive_exception) {
                    textArea.append("Erro ao receber mensagem (" + receive_exception.getMessage() + ")\n");
                }
            }
        });
        buttonPanel2.add(btn0);

        btn1 = new JButton("1");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clientSocket.sendMensagem("1");
                } catch (IOException send_exception) {
                    textArea.append("Erro ao enviar mensagem (" + send_exception.getMessage() + ")\n");
                }
                try {
                    textArea.append(Client.clientSocket.getMessage());
                } catch (IOException receive_exception) {
                    textArea.append("Erro ao receber mensagem (" + receive_exception.getMessage() + ")\n");
                }
            }
        });
        buttonPanel2.add(btn1);

        btn2 = new JButton("2");
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clientSocket.sendMensagem("2");
                } catch (IOException send_exception) {
                    textArea.append("Erro ao enviar mensagem (" + send_exception.getMessage() + ")\n");
                }
                try {
                    textArea.append(Client.clientSocket.getMessage());
                } catch (IOException receive_exception) {
                    textArea.append("Erro ao receber mensagem (" + receive_exception.getMessage() + ")\n");
                }
            }
        });
        buttonPanel2.add(btn2);

        btn3 = new JButton("3");
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clientSocket.sendMensagem("3");
                } catch (IOException send_exception) {
                    textArea.append("Erro ao enviar mensagem (" + send_exception.getMessage() + ")\n");
                }
                try {
                    textArea.append(Client.clientSocket.getMessage());
                } catch (IOException receive_exception) {
                    textArea.append("Erro ao receber mensagem (" + receive_exception.getMessage() + ")\n");
                }
            }
        });
        buttonPanel2.add(btn3);

        btn4 = new JButton("4");
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clientSocket.sendMensagem("4");
                } catch (IOException send_exception) {
                    textArea.append("Erro ao enviar mensagem (" + send_exception.getMessage() + ")\n");
                }
                try {
                    textArea.append(Client.clientSocket.getMessage());
                } catch (IOException receive_exception) {
                    textArea.append("Erro ao receber mensagem (" + receive_exception.getMessage() + ")\n");
                }
            }
        });
        buttonPanel2.add(btn4);

        btn5 = new JButton("5");
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clientSocket.sendMensagem("5");
                } catch (IOException send_exception) {
                    textArea.append("Erro ao enviar mensagem (" + send_exception.getMessage() + ")\n");
                }
                try {
                    textArea.append(Client.clientSocket.getMessage());
                } catch (IOException receive_exception) {
                    textArea.append("Erro ao receber mensagem (" + receive_exception.getMessage() + ")\n");
                }
            }
        });
        buttonPanel2.add(btn5);

        // Botões3
        JPanel buttonPanel3 = new JPanel();
        painelButtons3.add(buttonPanel3);

        btnYES = new JButton("YES");
        btnYES.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clientSocket.sendMensagem("`YES`");
                } catch (IOException send_exception) {
                    textArea.append("Erro ao enviar mensagem (" + send_exception.getMessage() + ")\n");
                }
                try {
                    textArea.append(Client.clientSocket.getMessage());
                } catch (IOException receive_exception) {
                    textArea.append("Erro ao receber mensagem (" + receive_exception.getMessage() + ")\n");
                }
            }
        });
        buttonPanel3.add(btnYES);

        btnNO = new JButton("NO");
        btnNO.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    clientSocket.sendMensagem("NO");
                } catch (IOException send_exception) {
                    textArea.append("Erro ao enviar mensagem (" + send_exception.getMessage() + ")\n");
                }
                try {
                    textArea.append(Client.clientSocket.getMessage());
                } catch (IOException receive_exception) {
                    textArea.append("Erro ao receber mensagem (" + receive_exception.getMessage() + ")\n");
                }
            }
        });
        buttonPanel3.add(btnNO);

        contentPane.setLayout(new GridLayout(6, 1));
        contentPane.add(painelBarras);
        contentPane.add(painelImagens);
        contentPane.add(scrollPane);
        contentPane.add(painelButtons1);
        contentPane.add(painelButtons2);
        contentPane.add(painelButtons3);
    }

    public static void main(String[] args) {
        Apresentacao frame = new Apresentacao();
        frame.setVisible(true);
    }

    public static void trocarImagem(String caminho) {
        painelImagens.removeAll();
        imageIcon = new ImageIcon(caminho);
        label = new JLabel(imageIcon);
        painelImagens.add(label);
        painelImagens.revalidate();
        painelImagens.repaint();
    }
}
