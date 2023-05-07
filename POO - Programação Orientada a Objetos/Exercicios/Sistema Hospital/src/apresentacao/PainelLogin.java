package apresentacao;

import exception.FalhaAutenticarException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import negocios.Sistema;

public class PainelLogin extends JPanel{
    private Sistema sistema;
    private PainelPaciente painelPaciente;
    private PainelMedico painelMedico;
    private PainelConsulta painelConsulta;
    
    private final JPanel telaLogin = new JPanel();
    private final JPanel painelLogin = new JPanel();
    private final JLabel infoLogin = new JLabel("Login");
    private JTextField login = new JTextField();
    private final JLabel infoSenha = new JLabel("Senha");
    private JPasswordField senha = new JPasswordField();
    
    private JButton botaoLogin = new JButton("Login");
    private JButton botaoLogout = new JButton("Logout");
    
    public PainelLogin(){
        try {
            sistema = Sistema.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Contate o administrador", "Error", JOptionPane.QUESTION_MESSAGE);
        }
        
        setLayout(null);
        telaLogin.setBounds(10,5,500,250);
        telaLogin.setLayout(null);
        
        painelLogin.setBounds(275,15,200,220);
        painelLogin.setLayout(null);
        
        telaLogin.setBorder(BorderFactory.createTitledBorder(""));
        add(telaLogin);
        
        painelLogin.setBorder(BorderFactory.createTitledBorder(""));
        telaLogin.add(painelLogin);
        
        JLabel imagemLogin = new JLabel(new ImageIcon("images/iconeLogin.png"));
        imagemLogin.setBounds(-20, 30, 300, 200);
        telaLogin.add(imagemLogin);
        
        infoLogin.setBounds(15,-15,100,100);
        login.setBounds(15,45,150,25);
        painelLogin.add(infoLogin);
        painelLogin.add(login);
        
        infoSenha.setBounds(15,40,100,100);
        senha.setBounds(15,100,150,25);
        painelLogin.add(infoSenha);
        painelLogin.add(senha);
        
        botaoLogin.setBounds(45,155,100,30);
        botaoLogin.setVisible(true);
        painelLogin.add(botaoLogin);
        
        botaoLogout.setBounds(45,155,100,30);
        botaoLogout.setVisible(false);
        painelLogin.add(botaoLogout);
        
        botaoLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                try {
                    if(sistema.isValidAutentication(senha.getText(), login.getText())){
                        botaoLogin.setVisible(false);
                        botaoLogout.setVisible(true);
                        login.setText("");
                        senha.setText("");
                        JOptionPane.showMessageDialog(null, "Login feito com sucesso", "Login", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images/check.png"));
                        painelPaciente.imagemOperacoesBloqueadas.setIcon(new ImageIcon("images/cadeadoLoginAberto.png"));
                        painelMedico.imagemOperacoesBloqueadas.setIcon(new ImageIcon("images/cadeadoLoginAberto.png"));
                        painelConsulta.imagemOperacoesBloqueadas.setIcon(new ImageIcon("images/cadeadoLoginAberto.png"));
                    }
                } catch (FalhaAutenticarException ex) {
                    login.setText("");
                    senha.setText("");
                    JOptionPane.showMessageDialog(null, "Usuario ou senha invalido", "Erro Autenticacao", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        botaoLogout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                botaoLogin.setVisible(true);
                botaoLogout.setVisible(false);
                sistema.Logout();
                JOptionPane.showMessageDialog(null, "Logou feito com suceso", "Logout", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images/check.png"));
                painelPaciente.imagemOperacoesBloqueadas.setIcon(new ImageIcon("images/cadeadoLoginFechado.png"));
                painelMedico.imagemOperacoesBloqueadas.setIcon(new ImageIcon("images/cadeadoLoginFechado.png"));
                painelConsulta.imagemOperacoesBloqueadas.setIcon(new ImageIcon("images/cadeadoLoginFechado.png"));
            }
        });
    }
}
