package apresentacao;

import dados.Paciente;
import exception.CampoVazioException;
import exception.FalhaAlterarException;
import exception.FalhaBuscarException;
import exception.FalhaInserirException;
import exception.FalhaRemoverException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
import persistencia.PacienteDAO;

public class PainelPaciente extends JPanel{
    private Sistema sistema;
    private PacienteDAO pacientedao;
    private PainelConsulta painelConsulta;
    
    //Painel
    private final JPanel painelCadastroPaciente = new JPanel();
    
    //Login
    static JLabel imagemOperacoesBloqueadas = new JLabel();
    
    //Cadastrar
    private final JLabel infoNomePaciente = new JLabel("Digite o nome do paciente");
    private JTextField nomePaciente = new JTextField();
    private final JLabel infoIdadePaciente = new JLabel("Digite a idade do paciente");
    private JTextField idadePaciente = new JTextField();
    private final JLabel infoCidadePaciente = new JLabel("Digite a cidade do paciente");
    private JTextField cidadePaciente = new JTextField();
    private final JLabel infoCpfPaciente = new JLabel("Digite o CPF do paciente");
    private JTextField cpfPaciente = new JTextField();
    private final JLabel infoDescricaoPaciente = new JLabel("Digite a descrição");
    private JTextField descricaoPaciente = new JTextField();
    private final JButton botaoCadastrarPaciente = new JButton("Cadastrar");
    
    //Remover
    private final JPanel painelRemoverPaciente = new JPanel();
    private final JButton botaoRemoverPaciente = new JButton("Remover");
    private JComboBox<Paciente> comboBoxRemover = new JComboBox();
    
    //Alterar
    private JComboBox<Paciente> comboBoxAlterar = new JComboBox();
    
    private final JPanel painelAlterarPaciente = new JPanel();
    private final JLabel infoAlterarNomePaciente = new JLabel("Nome do paciente");
    private JTextField alterarNomePaciente = new JTextField();
    private final JLabel infoAlterarIdadePaciente = new JLabel("Idade do paciente");
    private JTextField alterarIdadePaciente = new JTextField();
    private final JLabel infoAlterarCidadePaciente = new JLabel("Cidade do paciente");
    private JTextField alterarCidadePaciente = new JTextField();
    private final JLabel infoAlterarCpfPaciente = new JLabel("CPF do paciente");
    private JTextField alterarCpfPaciente = new JTextField();
    private final JLabel infoAlterarDescricaoPaciente = new JLabel("Descrição");
    private JTextField alterarDescricaoPaciente = new JTextField();
    private final JButton botaoAlterarPaciente = new JButton("Alterar");
    
    public PainelPaciente(){
        try {
            sistema = sistema.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Contate o adminitrador", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        try {
            pacientedao = PacienteDAO.getInstance();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Contate o adminitrador", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        setLayout(null);
        
        //Login//
        imagemOperacoesBloqueadas.setBounds(730,0,50,50);
        imagemOperacoesBloqueadas.setIcon(new ImageIcon("images/cadeadoLoginFechado.png"));
        add(imagemOperacoesBloqueadas);
        
        //Cadastrar//
        add(painelCadastroPaciente);
        
        painelCadastroPaciente.setBounds(45,20,200,300);
        painelCadastroPaciente.setLayout(null);
        painelCadastroPaciente.setBorder(BorderFactory.createTitledBorder(null, "Cadastrar", TitledBorder.TOP, TitledBorder.CENTER));
        
        infoNomePaciente.setBounds(25,30,170,15);
        nomePaciente.setBounds(25,45,155,20);
        
        infoIdadePaciente.setBounds(25,75,170,15);
        idadePaciente.setBounds(25,90,155,20);
        
        infoCidadePaciente.setBounds(25,120,170,15);
        cidadePaciente.setBounds(25,135,155,20);
        
        infoCpfPaciente.setBounds(25,165,170,15);
        cpfPaciente.setBounds(25,180,155,20);
        
        infoDescricaoPaciente.setBounds(25,210,170,15);
        descricaoPaciente.setBounds(25,225,155,20);
        
        painelCadastroPaciente.add(nomePaciente);
        painelCadastroPaciente.add(infoNomePaciente);
        painelCadastroPaciente.add(infoIdadePaciente);
        painelCadastroPaciente.add(idadePaciente);
        painelCadastroPaciente.add(infoCidadePaciente);
        painelCadastroPaciente.add(cidadePaciente);
        painelCadastroPaciente.add(infoCpfPaciente);
        painelCadastroPaciente.add(cpfPaciente);
        painelCadastroPaciente.add(infoDescricaoPaciente);
        painelCadastroPaciente.add(descricaoPaciente);
        
        botaoCadastrarPaciente.setBounds(50,265,100,20);
        painelCadastroPaciente.add(botaoCadastrarPaciente);
        
        botaoCadastrarPaciente.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                if(!sistema.isLoggedUser()){
                    JOptionPane.showMessageDialog(null, "Usuario não está logado", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    verificarCampoCadastrar();
                    Paciente paciente = new Paciente();
                    paciente.setNome(nomePaciente.getText());
                    paciente.setIdade(Integer.parseInt(idadePaciente.getText()));
                    paciente.setCidade(cidadePaciente.getText());
                    paciente.setCpf(cpfPaciente.getText());
                    paciente.setDescricao(descricaoPaciente.getText());
                    sistema.cadastrarPaciente(paciente);
                    comboBoxRemover.addItem(paciente);
                    comboBoxAlterar.addItem(paciente);
                    painelConsulta.comboBoxPacienteConsulta.addItem(paciente);
                    painelConsulta.comboBoxAlterarPaciente.addItem(paciente);
                    limparCaixaCadastrar();
                    JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!", "Novo Paciente", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images/check.png"));
                } catch (FalhaInserirException | FalhaBuscarException ex) {
                    JOptionPane.showMessageDialog(null, "Contate o adminitrador", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (CampoVazioException e){
                    JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Remover//
        add(painelRemoverPaciente);
        painelRemoverPaciente.setBounds(300,20,315,70);
        painelRemoverPaciente.setLayout(null);
        painelRemoverPaciente.setBorder(BorderFactory.createTitledBorder(null, "Remover", TitledBorder.TOP, TitledBorder.CENTER));
        comboBoxRemover.setBounds(25,30,150,20);
        
        painelRemoverPaciente.add(comboBoxRemover);
        
        botaoRemoverPaciente.setBounds(195,30,95,20);
        painelRemoverPaciente.add(botaoRemoverPaciente);
        
        botaoRemoverPaciente.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                try {
                    if(!sistema.isLoggedUser()){
                        JOptionPane.showMessageDialog(null, "Usuario não está logado", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    sistema.removerPaciente((Paciente)comboBoxRemover.getSelectedItem());
                    comboBoxAlterar.removeItem((Paciente)comboBoxRemover.getSelectedItem());
                    painelConsulta.comboBoxPacienteConsulta.removeItem((Paciente)comboBoxRemover.getSelectedItem());
                    painelConsulta.comboBoxAlterarPaciente.removeItem((Paciente)comboBoxRemover.getSelectedItem());
                    comboBoxRemover.removeItem((Paciente)comboBoxRemover.getSelectedItem());
                    JOptionPane.showMessageDialog(null, "Paciente removido com sucesso!", "Remove Paciente", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images/check.png"));
                } catch (FalhaRemoverException ex) {
                    JOptionPane.showMessageDialog(null, "Verifique se o paciente está em uma consulta", "Erro Remover", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        //Alterar//
        add(painelAlterarPaciente);
        
        painelAlterarPaciente.setBounds(300,90,360,230);
        painelAlterarPaciente.setLayout(null);
        painelAlterarPaciente.setBorder(BorderFactory.createTitledBorder(null,"Alterar / Buscar",TitledBorder.TOP,TitledBorder.CENTER));
        
        infoAlterarNomePaciente.setBounds(25,70,170,15);
        alterarNomePaciente.setBounds(25,85,155,20);
        
        infoAlterarIdadePaciente.setBounds(25,120,170,15);
        alterarIdadePaciente.setBounds(25,135,155,20);
        
        infoAlterarCidadePaciente.setBounds(190,70,170,15);
        alterarCidadePaciente.setBounds(190,85,155,20);
        
        infoAlterarCpfPaciente.setBounds(190,120,170,15);
        alterarCpfPaciente.setBounds(190,135,155,20);
        
        infoAlterarDescricaoPaciente.setBounds(25,170,170,15);
        alterarDescricaoPaciente.setBounds(25,185,320,20);
        
        painelAlterarPaciente.add(alterarNomePaciente);
        painelAlterarPaciente.add(infoAlterarNomePaciente);
        painelAlterarPaciente.add(infoAlterarIdadePaciente);
        painelAlterarPaciente.add(alterarIdadePaciente);
        painelAlterarPaciente.add(infoAlterarCidadePaciente);
        painelAlterarPaciente.add(alterarCidadePaciente);
        painelAlterarPaciente.add(infoAlterarCpfPaciente);
        painelAlterarPaciente.add(alterarCpfPaciente);
        painelAlterarPaciente.add(infoAlterarDescricaoPaciente);
        painelAlterarPaciente.add(alterarDescricaoPaciente);
        
        comboBoxAlterar.setBounds(25,35,150,20);
        painelAlterarPaciente.add(comboBoxAlterar);
        
        botaoAlterarPaciente.setBounds(200,35,95,20);
        painelAlterarPaciente.add(botaoAlterarPaciente);
        
        comboBoxAlterar.addPopupMenuListener(new PopupMenuListener(){
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
                Paciente pacienteAlterar;
                pacienteAlterar = (Paciente)comboBoxAlterar.getSelectedItem();
                alterarNomePaciente.setText(pacienteAlterar.getNome());
                alterarIdadePaciente.setText(Integer.toString(pacienteAlterar.getIdade()));
                alterarCidadePaciente.setText(pacienteAlterar.getCidade());
                alterarCpfPaciente.setText(pacienteAlterar.getCpf());
                alterarDescricaoPaciente.setText(pacienteAlterar.getDescricao());
            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent e) {
            }
        });
        
        botaoAlterarPaciente.addActionListener((ActionEvent arg0) -> {
            if(!sistema.isLoggedUser()){
                JOptionPane.showMessageDialog(null, "Usuario não está logado", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                verificarCampoAlterar();
                Paciente paciente = (Paciente)comboBoxAlterar.getSelectedItem();
                paciente.setNome(alterarNomePaciente.getText());
                paciente.setIdade(Integer.parseInt(alterarIdadePaciente.getText()));
                paciente.setCidade(alterarCidadePaciente.getText());
                paciente.setCpf(alterarCpfPaciente.getText());
                paciente.setDescricao(alterarDescricaoPaciente.getText());
                sistema.alterarPaciente(paciente);
                limparCaixaAlterar();
                JOptionPane.showMessageDialog(null, "Paciente alterado com sucesso!", "Alterar Paciente", JOptionPane.PLAIN_MESSAGE, new ImageIcon("images/check.png"));
            } catch(FalhaAlterarException ex) {
                JOptionPane.showMessageDialog(null, "Falhao ao alterar paciente", "Error", JOptionPane.ERROR_MESSAGE);
            } catch(CampoVazioException e){
                JOptionPane.showMessageDialog(null, "Preencha todos os campos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
                
        //Buscar//
        try {
            for(Paciente p : sistema.bucarPaciente()){
                comboBoxRemover.addItem(p);
                comboBoxAlterar.addItem(p);
                PainelConsulta.comboBoxPacienteConsulta.addItem(p);
                PainelConsulta.comboBoxAlterarPaciente.addItem(p);
            }
        } catch (FalhaBuscarException ex) {
            JOptionPane.showMessageDialog(null, "Falhao ao alterar paciente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Verificar campos de entrada
    private void verificarCampoCadastrar() throws CampoVazioException{
        if(nomePaciente.getText()==null || nomePaciente.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(idadePaciente.getText()==null || idadePaciente.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(cidadePaciente.getText()==null || cidadePaciente.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(cpfPaciente.getText()==null || cpfPaciente.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(descricaoPaciente.getText()==null || descricaoPaciente.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
    }
    
    private void verificarCampoAlterar() throws CampoVazioException{
        if(alterarNomePaciente.getText()==null || alterarNomePaciente.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(alterarIdadePaciente.getText()==null || alterarIdadePaciente.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(alterarCidadePaciente.getText()==null || alterarCidadePaciente.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(alterarCpfPaciente.getText()==null || alterarCpfPaciente.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
        if(alterarDescricaoPaciente.getText()==null || alterarDescricaoPaciente.getText().trim().equals("")){
            throw new CampoVazioException("");
        }
    }
    
    //Limpar caixas de entrada
    private void limparCaixaCadastrar(){
        nomePaciente.setText("");
        idadePaciente.setText("");
        cidadePaciente.setText("");
        cpfPaciente.setText("");
        descricaoPaciente.setText("");
    }
    
    private void limparCaixaAlterar(){
        alterarNomePaciente.setText("");
        alterarIdadePaciente.setText("");
        alterarCidadePaciente.setText("");
        alterarCpfPaciente.setText("");
        alterarDescricaoPaciente.setText("");
    }
}