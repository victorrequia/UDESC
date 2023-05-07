package apresentacao;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PainelCreditos extends JPanel{
    private JLabel textoCreditos = new JLabel();
    private JLabel desenvolvedor1 = new JLabel();
    private JLabel desenvolvedor2 = new JLabel();
    private JLabel desenvolvedor3 = new JLabel();
    
    public PainelCreditos(){
        this.setLayout(null);
        
        textoCreditos.setBounds(290,50,800,25);
        desenvolvedor1.setBounds(290,95,800,25);
        desenvolvedor2.setBounds(290,130,800,25);
        desenvolvedor3.setBounds(290,165,800,25);
        
        textoCreditos.setText("Projeto desevolvido por:");
        desenvolvedor1.setText("Aluno: Victor Requia");
        desenvolvedor2.setText("Monitor: Vinicius Takeo");
        desenvolvedor3.setText("Professor: Fabiano Baldo");
        
        textoCreditos.setFont(new Font("Arial",1, 19));
        desenvolvedor1.setFont(new Font("Arial",1, 19));
        desenvolvedor2.setFont(new Font("Arial",1, 19));
        desenvolvedor3.setFont(new Font("Arial",1, 19));
        
        
        this.add(textoCreditos);
        this.add(desenvolvedor1);
        this.add(desenvolvedor2);
        this.add(desenvolvedor3);
    }
}
