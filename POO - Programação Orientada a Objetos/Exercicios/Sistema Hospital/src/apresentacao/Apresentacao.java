package apresentacao;

import java.awt.Image;
import java.awt.Toolkit;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import negocios.Sistema;

public class Apresentacao extends JFrame{
    private static Sistema sistema;
        
    private final JTabbedPane tabbedcontainer = new JTabbedPane();
    private final PainelConsulta painelConsulta = new PainelConsulta();
    private final PainelMedico painelMedico = new PainelMedico();
    private final PainelPaciente painelPaciente = new PainelPaciente();
    private final PainelLogin painelLogin = new PainelLogin();
    private final PainelCreditos painelCreditos = new PainelCreditos();
    
    public Apresentacao(){
        Image iconeJanela = Toolkit.getDefaultToolkit().getImage("images/iconeJanela.png");
        this.setIconImage(iconeJanela);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(320,170,800,450);
        
        add(tabbedcontainer);
        setTitle("Hospital");
        
        tabbedcontainer.addTab("Login ",new ImageIcon("images/cadeado.png"), painelLogin);
        tabbedcontainer.addTab("Consultas", new ImageIcon("images/consulta.png"), painelConsulta);
        tabbedcontainer.addTab("Medicos", new ImageIcon("images/medico.png"),painelMedico);
        tabbedcontainer.addTab("Pacientes",new ImageIcon("images/paciente.png"), painelPaciente);
        tabbedcontainer.addTab("Creditos", new ImageIcon("images/creditos.png"), painelCreditos);
    }
    
    public static void main(String[] args){
        try {
            sistema = sistema.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Contate o administrador", "Error", JOptionPane.QUESTION_MESSAGE);
        }
        
        Apresentacao apresentacao = new Apresentacao();
        apresentacao.setVisible(true);
    }
}
