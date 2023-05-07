package apresentacao;

import dados.Medico;
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
import persistencia.MedicoDAO;

public class PainelMedico extends JPanel{
    private Sistema sistema;
    private MedicoDAO medicodao;
    private PainelConsulta painelConsulta;

    //Login
    static JLabel imagemOperacoesBloqueadas = new JLabel();
    
    //Cadastrar//
    private final JPanel painelCadastroMedico = new JPanel();
    private final JLabel infoNomeMedico = new JLabel("Digite o nome do médico");
    private JTextField nomeMedico = new JTextField();
    private final JLabel infoIdadeMedico = new JLabel("Digite a idade do médico");
    private JTextField idadeMedico = new JTextField();
    private final JLabel infoCidadeMedico = new JLabel("Digite a cidade do médico");
    private JTextField cidadeMedico = new JTextField();
    private final JLabel infoCpfMedico = new JLabel("Digite o cpf do médico");
    private JTextField cpfMedico = new JTextField();
    private final JLabel infoEspecializacaoMedico = new JLabel("Digite a especialização");
    private JTextField especializacaoMedico = new JTextField();
    private final JButton botaoCadastrarMedico = new JButton("Cadastrar");
    
    //Remover//
    private final JPanel painelRemoverMedico = new JPanel();
    private final JButton botaoRemoverMedico = new JButton("Remover");
    private JComboBox<Medico> comboBoxRemover = new JComboBox();
    
    //Alterar//
    private JComboBox<Medico> comboBoxAlterar = new JComboBox();
    
    private final JPanel painelAlterarMedico = new JPanel();
    private final JLabel infoAlterarNomeMedico = new JLabel("Nome do medico");
    private JTextField alterarNomeMedico = new JTextField();
    private final JLabel infoAlterarIdadeMedico = new JLabel("Idade do medico");
    private JTextField alterarIdadeMedico = new JTextField();
    private final JLabel infoAlterarCidadeMedico = new JLabel("Cidade do medico");
    private JTextField alterarCidadeMedico = new JTextField();
    private final JLabel infoAlterarCpfMedico = new JLabel("CPF do medico");
    private JTextField alterarCpfMedico = new JTextField();
    private final JLabel infoAlterarEspecializacaoMedico = new JLabel("Especializacao");
    private JTextField alterarEspecializacaoMedico = new JTextField();
    private final JButton botaoAlterarMedico = new JButton("Alterar");
    
    public PainelMedico(){
        try {
            sistema = sistema.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Contate o adminitrador", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            medicodao = MedicoDAO.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Contate o adminitrador", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        setLayout(null);
        add(painelCadastroMedico);
        
        //Login//
        imagemOperacoesBloqueadas.setBounds(730,0,50,50);
        imagemOperacoesBloqueadas.setIcon(new ImageIcon("images/cadeadoLoginFechado.png"));
        add(imagemOperacoesBloqueadas);
        
        //Cadastrar//
        painelCadastroMedico.setBounds(45,20,200,300);
        painelCadastroMedico.setLayout(null);
        painelCadastroMedico.setBorder(BorderFactory.createTitledBorder(null,"Cadastrar",TitledBorder.TOP,TitledBorder.CENTER));
        
        infoNomeMedico.setBounds(25,30,170,15);
        nomeMedico.setBounds(25,45,155,20);
        nomeMedico.setColumns(10);
        
        infoIdadeMedico.setBounds(25,75,170,15);
        idadeMedico.setBounds(25,90,155,20);
        idadeMedico.setColumns(10);
        
        infoCidadeMedico.setBounds(25,120,170,15);
        cidadeMedico.setBounds(25,135,155,20);
        cidadeMedico.setColumns(10);
        
        infoCpfMedico.setBounds(25,165,170,15);
        cpfMedico.setBounds(25,180,155,20);
        cpfMedico.setColumns(10);
        
        infoEspecializacaoMedico.setBounds(25,210,170,15);
        especializacaoMedico.setBounds(25,225,155,20);
        especializacaoMedico.setColumns(10);        
        
        painelCadastroMedico.add(infoNomeMedico);
        painelCadastroMedico.add(nomeMedico);
        painelCadastroMedico.add(infoIdadeMedico);
        painelCadastroMedico.add(idadeMedico);
        painelCadastroMedico.add(infoCidadeMedico);
        painelCadastroMedico.add(cidadeMedico);
        painelCadastroMedico.add(infoCpfMedico);
        painelCadastroMedico.add(cpfMedico);
        painelCadastroMedico.add(infoEspecializacaoMedico);
        painelCadastroMedico.add(especializacaoMedico);
        
        botaoCadastrarMedico.setBounds(50,265,100,20);
        painelCadastroMedico.add(botaoCadastrarMedico);
        
        botaoCadastrarMedico.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                if(!sistema.isLoggedUser()){
                    JOptionPane.showMessageDialog(null, "Usuario não está logado", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    verificarCampoCadastrar();
                    Medico medico = new Medico();
                    medico.setNome(nomeMedico.getText());
                    medico.setIdade(Integer.parseInt(idadeMedico.getText()));
                    medico.setCidade(cidadeMedico.getText());
                    medico.setCpf(cpfMedico.getText());
                    medico.setEspecializacao(especializacaoMedico.getText());
                    sistema.cadastrarMedico(medico);
                    limparCaixaCadastrar();
                    comboBoxRemover.addItem(medico);
                    painelConsulta.comboBoxMedicoConsulta.addItem(medico);
                    painelConsulta.comboBoxAlterarMedico.addItem(medico);
                    comboBoxAlterar.addItem(medico);
                    JOptionPane.showMessageDialog(null, "Medico cadastrado com sucesso!", "Cadastro Medico", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images/check.png"));
                } catch (FalhaInserirException | FalhaBuscarException ex) {
                    JOptionPane.showMessageDialog(null, "Contate o adminitrador", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (CampoVazioException e){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Remover//
        add(painelRemoverMedico);
        painelRemoverMedico.setBounds(300,20,315,70);
        painelRemoverMedico.setLayout(null);
        painelRemoverMedico.setBorder(BorderFactory.createTitledBorder(null, "Remover", TitledBorder.TOP, TitledBorder.CENTER));
        comboBoxRemover.setBounds(25,30,150,20);
        
        painelRemoverMedico.add(comboBoxRemover);
        
        botaoRemoverMedico.setBounds(195,30,95,20);
        painelRemoverMedico.add(botaoRemoverMedico);
        
        botaoRemoverMedico.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                if(!sistema.isLoggedUser()){
                    JOptionPane.showMessageDialog(null, "Usuario não está logado", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    sistema.removerMedico((Medico)comboBoxRemover.getSelectedItem());
                    painelConsulta.comboBoxAlterarMedico.removeItem((Medico)comboBoxRemover.getSelectedItem());
                    painelConsulta.comboBoxMedicoConsulta.removeItem((Medico)comboBoxRemover.getSelectedItem());
                    comboBoxAlterar.removeItem((Medico)comboBoxRemover.getSelectedItem());
                    comboBoxRemover.removeItem((Medico)comboBoxRemover.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "Medico removido com sucesso!", "Remove Medico", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images/check.png"));
                } catch (FalhaRemoverException ex) {
                    JOptionPane.showMessageDialog(null, "Verifique se o medico está em uma consulta", "Erro Remover", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Alterar//
        add(painelAlterarMedico);
        
        painelAlterarMedico.setBounds(300,90,360,230);
        painelAlterarMedico.setLayout(null);
        painelAlterarMedico.setBorder(BorderFactory.createTitledBorder(null,"Alterar / Buscar",TitledBorder.TOP,TitledBorder.CENTER));
        
        infoAlterarNomeMedico.setBounds(25,70,170,15);
        alterarNomeMedico.setBounds(25,85,155,20);
        
        infoAlterarIdadeMedico.setBounds(25,120,170,15);
        alterarIdadeMedico.setBounds(25,135,155,20);
        
        infoAlterarCidadeMedico.setBounds(190,70,170,15);
        alterarCidadeMedico.setBounds(190,85,155,20);
        
        infoAlterarCpfMedico.setBounds(190,120,170,15);
        alterarCpfMedico.setBounds(190,135,155,20);
        
        infoAlterarEspecializacaoMedico.setBounds(25,170,170,15);
        alterarEspecializacaoMedico.setBounds(25,185,320,20);
        
        painelAlterarMedico.add(alterarNomeMedico);
        painelAlterarMedico.add(infoAlterarNomeMedico);
        painelAlterarMedico.add(infoAlterarIdadeMedico);
        painelAlterarMedico.add(alterarIdadeMedico);
        painelAlterarMedico.add(infoAlterarCidadeMedico);
        painelAlterarMedico.add(alterarCidadeMedico);
        painelAlterarMedico.add(infoAlterarCpfMedico);
        painelAlterarMedico.add(alterarCpfMedico);
        painelAlterarMedico.add(infoAlterarEspecializacaoMedico);
        painelAlterarMedico.add(alterarEspecializacaoMedico);
        
        comboBoxAlterar.setBounds(25,35,150,20);
        painelAlterarMedico.add(comboBoxAlterar);
        
        botaoAlterarMedico.setBounds(200,35,95,20);
        painelAlterarMedico.add(botaoAlterarMedico);
        
        comboBoxAlterar.addPopupMenuListener(new PopupMenuListener(){
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                Medico medicoAlterar = new Medico();
                medicoAlterar = (Medico)comboBoxAlterar.getSelectedItem();
                alterarNomeMedico.setText(medicoAlterar.getNome());
                alterarIdadeMedico.setText(Integer.toString(medicoAlterar.getIdade()));
                alterarCidadeMedico.setText(medicoAlterar.getCidade());
                alterarCpfMedico.setText(medicoAlterar.getCpf());
                alterarEspecializacaoMedico.setText(medicoAlterar.getEspecializacao());
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });
        
        botaoAlterarMedico.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                if(!sistema.isLoggedUser()){
                    JOptionPane.showMessageDialog(null, "Usuario não está logado", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    verificarCampoAlterar();
                    Medico medico = (Medico)comboBoxAlterar.getSelectedItem();
                    medico.setNome(alterarNomeMedico.getText());
                    medico.setIdade(Integer.parseInt(alterarIdadeMedico.getText()));
                    medico.setCidade(alterarCidadeMedico.getText());
                    medico.setCpf(alterarCpfMedico.getText());
                    medico.setEspecializacao(alterarEspecializacaoMedico.getText());
                    sistema.alterarMedico(medico);
                    limparCaixaAlterar();
                    JOptionPane.showMessageDialog(null, "Medico alterado com sucesso!", "Alterar Medico", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images/check.png"));
                } catch (FalhaAlterarException ex) {
                    JOptionPane.showMessageDialog(null, "Contate o adminitrador", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (CampoVazioException e) {
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Buscar//
        try {
            for(Medico m : sistema.buscarMedico()){
                comboBoxRemover.addItem(m);
                comboBoxAlterar.addItem(m);
                painelConsulta.comboBoxMedicoConsulta.addItem(m);
                painelConsulta.comboBoxAlterarMedico.addItem(m);
            }
        } catch (FalhaBuscarException ex) {
            JOptionPane.showMessageDialog(null, "Contate o adminitrador", "Error", JOptionPane.ERROR_MESSAGE);
        }
    
    }
    
    //Verificar campos de entrada
    private void verificarCampoCadastrar() throws CampoVazioException{
        if(nomeMedico.getText()==null || nomeMedico.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(idadeMedico.getText()==null || idadeMedico.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(cidadeMedico.getText()==null || cidadeMedico.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(cpfMedico.getText()==null || cpfMedico.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(especializacaoMedico.getText()==null || especializacaoMedico.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
    }
    
    private void verificarCampoAlterar() throws CampoVazioException{
        if(alterarNomeMedico.getText()==null || alterarNomeMedico.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(alterarIdadeMedico.getText()==null || alterarIdadeMedico.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(alterarCidadeMedico.getText()==null || alterarCidadeMedico.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(alterarCpfMedico.getText()==null || alterarCpfMedico.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(alterarEspecializacaoMedico.getText()==null || alterarEspecializacaoMedico.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
    }
    
    //Limpar caixas de entrada
    private void limparCaixaCadastrar(){
        nomeMedico.setText("");
        idadeMedico.setText("");
        cidadeMedico.setText("");
        cpfMedico.setText("");
        especializacaoMedico.setText("");
    }
    
    private void limparCaixaAlterar(){
        alterarNomeMedico.setText("");
        alterarIdadeMedico.setText("");
        alterarCidadeMedico.setText("");
        alterarCpfMedico.setText("");
        alterarEspecializacaoMedico.setText("");
    }
    
}
