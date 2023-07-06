// Victor Eduardo Requia    11/04/2023
// Trabalho sobre SOCKETS para a disciplina de Redes de Computadores

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import apresentacao.Apresentacao;
import socket.Client;

public class Main extends JFrame {
    private JPanel contentPane;
    private JButton btnEntrar;

    public Main() {
        // Icone da janela
        ImageIcon icon = new ImageIcon("images/favicon.png");
        setIconImage(icon.getImage());

        // Configurações Básicas da Janela
        setTitle("Sockets Adventure");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 550, 350);
        setLocationRelativeTo(null);

        // Instanciando a interface
        contentPane = new JPanel();
        contentPane.setBorder(null);
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        // Botão para estabelecer conexão com o servidor
        btnEntrar = new JButton("Começar Aventura");
        btnEntrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Apresentacao telaNova = new Apresentacao();
                telaNova.setVisible(true);
                Client.main(null);
            }
        });

        // Imagem Herói
        ImageIcon imageIcon = new ImageIcon("images/super-heroi.png");
        JLabel label = new JLabel(imageIcon);
        contentPane.add(label);

        // Painel para o botão
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.add(btnEntrar);
    }

    public static void main(String[] args) {
        Main telaInicial = new Main();
        telaInicial.setVisible(true);
    }
}