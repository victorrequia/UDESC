package apresentacao;

import dados.Consulta;
import dados.Medico;
import dados.Paciente;
import exception.CampoVazioException;
import exception.FalhaAlterarException;
import exception.FalhaBuscarException;
import exception.FalhaInserirException;
import exception.FalhaRemoverException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import negocios.Sistema;

public class PainelConsulta extends JPanel{
    Sistema sistema;
            
    private final JPanel painelMarcarConsulta = new JPanel();
    private final JPanel painelRemoverConsulta = new JPanel();
    private final JPanel painelAlterarConsulta = new JPanel();
    
    //Login
    static JLabel imagemOperacoesBloqueadas = new JLabel();
    
    //Marcar//
    private final JLabel infoPacienteConsulta = new JLabel("Escolha o paciete da consulta");
    static JComboBox<Paciente> comboBoxPacienteConsulta = new JComboBox();
    private final JLabel infoMedicoConsulta = new JLabel("Escolha o medico da consulta");
    static JComboBox<Medico> comboBoxMedicoConsulta = new JComboBox();
    private final JLabel infoDataConsulta = new JLabel("Informe a data da consulta");
    private JTextField dataConsulta = new JTextField();
    private final JLabel infoDiagnosticoConsulta = new JLabel("Informe o diagnostico");
    private JTextField diagnosticoConsulta = new JTextField();
    private final JLabel infoValorConsulta = new JLabel("Digite o valor da consulta");
    private JTextField valorConsulta = new JTextField();
    private final JButton botaoMarcarConsulta = new JButton("Marcar");
    
    //Remover//
    private JComboBox<Consulta> comboBoxRemover = new JComboBox();
    private final JButton botaoRemover = new JButton("Remover");
    
    //Alterar//
    private JComboBox<Consulta> comboBoxAlterar = new JComboBox();
    static JComboBox<Paciente> comboBoxAlterarPaciente = new JComboBox();
    static JComboBox<Medico> comboBoxAlterarMedico = new JComboBox();
    
    private final JLabel infoAlteraDataConsulta = new JLabel("Data");
    private JTextField alterarDataConsulta = new JTextField();
    private final JLabel infoAlteraDiagnosticoConsulta = new JLabel("Diagnostico");
    private JTextField alterarDiagnosticoConsulta = new JTextField();
    private final JLabel infoAlterarValorConsulta = new JLabel("Valor");
    private JTextField alterarValorConsulta = new JTextField();
    
    private final JButton botaoAlterarConsulta = new JButton("Alterar");
    
    public PainelConsulta(){
        try {
            sistema = sistema.getInstance();
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Contate o adminitrador", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Contate o adminitrador", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        setLayout(null);
        
        //Login//
        imagemOperacoesBloqueadas.setBounds(730,0,50,50);
        imagemOperacoesBloqueadas.setIcon(new ImageIcon("images/cadeadoLoginFechado.png"));
        add(imagemOperacoesBloqueadas);
        
        //Marcar//
        painelMarcarConsulta.setBounds(45,20,230,310);
        painelMarcarConsulta.setLayout(null);
        painelMarcarConsulta.setBorder(BorderFactory.createTitledBorder(null, "Cadastrar", TitledBorder.TOP, TitledBorder.CENTER));
        add(painelMarcarConsulta);
        
        infoDataConsulta.setBounds(25,130,185,15);
        dataConsulta.setBounds(25,145,185,20);
        
        infoDiagnosticoConsulta.setBounds(25,175,185,15);
        diagnosticoConsulta.setBounds(25,190,185,20);
        
        infoValorConsulta.setBounds(25,220,185,15);
        valorConsulta.setBounds(25,235,185,20);
        
        painelMarcarConsulta.add(infoDataConsulta);
        painelMarcarConsulta.add(dataConsulta);
        painelMarcarConsulta.add(infoDiagnosticoConsulta);
        painelMarcarConsulta.add(diagnosticoConsulta);
        painelMarcarConsulta.add(infoValorConsulta);
        painelMarcarConsulta.add(valorConsulta);
        
        infoPacienteConsulta.setBounds(25,25,185,20);
        comboBoxPacienteConsulta.setBounds(25,45,185,20);
        painelMarcarConsulta.add(infoPacienteConsulta);
        painelMarcarConsulta.add(comboBoxPacienteConsulta);
        
        infoMedicoConsulta.setBounds(25,75,185,20);
        comboBoxMedicoConsulta.setBounds(25,95,185,20);
        painelMarcarConsulta.add(infoMedicoConsulta);
        painelMarcarConsulta.add(comboBoxMedicoConsulta);
        
        botaoMarcarConsulta.setBounds(25,270,185,25);
        painelMarcarConsulta.add(botaoMarcarConsulta);
        
        botaoMarcarConsulta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                if(!sistema.isLoggedUser()){
                    JOptionPane.showMessageDialog(null, "Usuario não está logado", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    verificarCampoMarcar();
                    Consulta consulta = new Consulta();
                    consulta.setMedico((Medico)comboBoxMedicoConsulta.getSelectedItem());
                    consulta.setPaciente((Paciente)comboBoxPacienteConsulta.getSelectedItem());
                    consulta.setData(dataConsulta.getText());
                    consulta.setDiagnostico(diagnosticoConsulta.getText());
                    consulta.setValorConsulta(Float.parseFloat(valorConsulta.getText()));
                    sistema.cadastrarConsulta(consulta);
                    limparCaixaMarcar();
                    comboBoxRemover.addItem(consulta);
                    comboBoxAlterar.addItem(consulta);
                    JOptionPane.showMessageDialog(null, "Consulta marcada com sucesso!", "Nova Consulta", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images/check.png"));
                } catch (FalhaInserirException | FalhaBuscarException ex) {
                    JOptionPane.showMessageDialog(null, "Contate o adminitrador", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (CampoVazioException e){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Remover//
        painelRemoverConsulta.setBounds(330,25,280,110);
        painelRemoverConsulta.setLayout(null);
        painelRemoverConsulta.setBorder(BorderFactory.createTitledBorder(null, "Remover", TitledBorder.TOP, TitledBorder.CENTER));
        add(painelRemoverConsulta);
        
        comboBoxRemover.setBounds(25,30,230,20);
        painelRemoverConsulta.add(comboBoxRemover);
        
        botaoRemover.setBounds(25,65,230,20);
        painelRemoverConsulta.add(botaoRemover);
        
        botaoRemover.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                if(!sistema.isLoggedUser()){
                    JOptionPane.showMessageDialog(null, "Usuario não está logado", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    sistema.removerConsulta((Consulta)comboBoxRemover.getSelectedItem());
                    comboBoxAlterar.removeItem(comboBoxRemover.getSelectedItem());
                    comboBoxRemover.removeItem(comboBoxRemover.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "Consulta removida com sucesso!", "Remove Consulta", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images/check.png"));
                }catch (FalhaRemoverException ex) {
                    JOptionPane.showMessageDialog(null, "Erro ao remover consulta", "Erro Remover", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        try {
            for(Consulta c : sistema.buscarConsulta()){
                comboBoxRemover.addItem(c);
                comboBoxAlterar.addItem(c);
            }
        } catch (FalhaBuscarException ex) {
            Logger.getLogger(PainelConsulta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //Alterar//
        painelAlterarConsulta.setBounds(330,140,320,190);
        painelAlterarConsulta.setLayout(null);
        painelAlterarConsulta.setBorder(BorderFactory.createTitledBorder(null, "Alterar / Buscar", TitledBorder.TOP, TitledBorder.CENTER));
        add(painelAlterarConsulta);
        
        comboBoxAlterar.setBounds(35,25,250,20);
        painelAlterarConsulta.add(comboBoxAlterar);
        
        comboBoxAlterarPaciente.setBounds(35,55,120,20);
        painelAlterarConsulta.add(comboBoxAlterarPaciente);
        
        comboBoxAlterarMedico.setBounds(165,55,120,20);
        painelAlterarConsulta.add(comboBoxAlterarMedico);
        
        infoAlteraDataConsulta.setBounds(35,75,115,20);
        alterarDataConsulta.setBounds(35,95,115,20);
        
        infoAlterarValorConsulta.setBounds(170,75,200,20);
        alterarValorConsulta.setBounds(170,95,115,20);
        
        infoAlteraDiagnosticoConsulta.setBounds(35,115,200,20);
        alterarDiagnosticoConsulta.setBounds(35,135,250,20);
        
        painelAlterarConsulta.add(infoAlteraDataConsulta);
        painelAlterarConsulta.add(alterarDataConsulta);
        painelAlterarConsulta.add(infoAlteraDiagnosticoConsulta);
        painelAlterarConsulta.add(alterarDiagnosticoConsulta);
        painelAlterarConsulta.add(infoAlterarValorConsulta);
        painelAlterarConsulta.add(alterarValorConsulta);
        
        botaoAlterarConsulta.setBounds(60,160,200,20);
        painelAlterarConsulta.add(botaoAlterarConsulta);
        
        comboBoxAlterar.addPopupMenuListener(new PopupMenuListener(){
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                if(comboBoxAlterar.getItemCount() > 0){
                    Consulta consultaAlterar = (Consulta)comboBoxAlterar.getSelectedItem();
                    
                    for(int i=0; i<comboBoxPacienteConsulta.getItemCount(); i++){
                        if(comboBoxPacienteConsulta.getItemAt(i).getNome().contains(consultaAlterar.getPaciente().getNome())){
                            comboBoxAlterarPaciente.setSelectedIndex(i);
                            break;
                        }
                    }
                    
                    for(int i=0; i<comboBoxMedicoConsulta.getItemCount(); i++){
                        if(comboBoxMedicoConsulta.getItemAt(i).getNome().contains(consultaAlterar.getMedico().getNome())){
                            comboBoxAlterarMedico.setSelectedIndex(i);
                            break;
                        }
                    }
                    
                    alterarDataConsulta.setText(consultaAlterar.getData());
                    alterarDiagnosticoConsulta.setText(consultaAlterar.getDiagnostico());
                    alterarValorConsulta.setText(Float.toString(consultaAlterar.getValorConsulta()));
                }else{
                    
                }
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });
        
        botaoAlterarConsulta.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                if(!sistema.isLoggedUser()){
                    JOptionPane.showMessageDialog(null, "Usuario não está logado", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    verificarCampoAlterar();
                    Consulta consulta = (Consulta)comboBoxAlterar.getSelectedItem();
                    consulta.setMedico((Medico)comboBoxAlterarMedico.getSelectedItem());
                    consulta.setPaciente((Paciente)comboBoxAlterarPaciente.getSelectedItem());
                    consulta.setData(alterarDataConsulta.getText());
                    consulta.setDiagnostico(alterarDiagnosticoConsulta.getText());
                    consulta.setValorConsulta(Float.parseFloat(alterarValorConsulta.getText()));
                    sistema.alterarConsulta(consulta);
                    limparCaixaAlterar();
                    JOptionPane.showMessageDialog(null, "Consulta alterada com sucesso!", "Altera Consulta", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images/check.png"));
                } catch (FalhaAlterarException ex) {
                    JOptionPane.showMessageDialog(null, "Contate o adminitrador", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (CampoVazioException e){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }


    //Verificar campos de entrada
    private void verificarCampoMarcar() throws CampoVazioException{
        if(dataConsulta.getText()==null || dataConsulta.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(diagnosticoConsulta.getText()==null || diagnosticoConsulta.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(valorConsulta.getText()==null || valorConsulta.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
    }
    
    private void verificarCampoAlterar() throws CampoVazioException{
        if(alterarDataConsulta.getText()==null || alterarDataConsulta.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(alterarDiagnosticoConsulta.getText()==null || alterarDiagnosticoConsulta.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(alterarValorConsulta.getText()==null || alterarValorConsulta.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
    }
    
    //Limpar caixas de entrada
    private void limparCaixaMarcar(){
        dataConsulta.setText("");
        diagnosticoConsulta.setText("");
        valorConsulta.setText("");
    }
    
    private void limparCaixaAlterar(){
        alterarDataConsulta.setText("");
        alterarDiagnosticoConsulta.setText("");
        alterarValorConsulta.setText("");
    }
}
