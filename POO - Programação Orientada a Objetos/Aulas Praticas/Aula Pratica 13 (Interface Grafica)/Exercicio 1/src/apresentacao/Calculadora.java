package apresentacao;

import dados.CalculadoraEstatistica;
import dados.Fatoriais;
import dados.Fibonacci;
import dados.GerarTipo;
import dados.Naturais;
import exceptions.CleanException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Calculadora extends JFrame{
    
    private JPanel painel = new JPanel();
    
    private JPanel painelEntrada = new JPanel();
    private JPanel painelGeradores = new JPanel();
    private JScrollPane painelScrollTabelaResultado = new JScrollPane();
    private JScrollPane painelScrollTabelaValores = new JScrollPane();
    
    private JTextField caixaEntrada = new JTextField();
    
    private JTextField caixaEntradaGeradores = new JTextField();

    private JButton botaoAdicionar = new JButton("Adicionar");
    private JButton botaoLimpar = new JButton("Limpar");
    private JButton botaoTirar = new JButton("Tirar ultimo");
    private JButton botaoGerar = new JButton("Gerar");

    private JTable tabelaResultados;
    private JTable tabelaValores;

    private TabelaValores valores = new TabelaValores();
    private TabelaResultados resultados = new TabelaResultados();   
    
    private Naturais naturais = new Naturais();
    private Fibonacci fibonacci = new Fibonacci();
    private Fatoriais fatoriais = new Fatoriais();

    public Calculadora(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,900,320);
        setTitle("Calculadora Estatística");
    
        setContentPane(painel);
        painel.setLayout(null);
        
        painelEntrada.setBounds(35,80,280,190);
        painelEntrada.setBorder(BorderFactory.createTitledBorder("Digite um valor"));
        painelEntrada.setLayout(null);
        painel.add(painelEntrada);
        
        painelGeradores.setBounds(520,80,280,190);
        painelGeradores.setBorder(BorderFactory.createTitledBorder("Gerar Valores"));
        painelGeradores.setLayout(null);
        painel.add(painelGeradores);
        
        caixaEntrada.setBounds(30,50,200,20);
        caixaEntrada.setColumns(10);
        painelEntrada.add(caixaEntrada);
        
        caixaEntradaGeradores.setBounds(50,50,200,20);
        caixaEntradaGeradores.setColumns(10);
        painelGeradores.add(caixaEntradaGeradores);
        
        botaoAdicionar.setBounds(77,85,117,25);
        painelEntrada.add(botaoAdicionar);
        
        botaoLimpar.setBounds(77,115,117,25);
        painelEntrada.add(botaoLimpar);
        
        botaoTirar.setBounds(77,145,117,25);
        painelEntrada.add(botaoTirar);
        
        botaoGerar.setBounds(70,135,150,20);
        painelGeradores.add(botaoGerar);
    
        painelScrollTabelaResultado.setBounds(10,10,880,50);
        painel.add(painelScrollTabelaResultado);
        
        tabelaResultados = new JTable(resultados);
        painelScrollTabelaResultado.setViewportView(tabelaResultados);
        
        painelScrollTabelaValores.setBounds(330,100,173,173);
        painel.add(painelScrollTabelaValores);
        
        tabelaValores = new JTable(valores);
        painelScrollTabelaValores.setViewportView(tabelaValores);
        
        JComboBox<GerarTipo> comboBox = new JComboBox<GerarTipo>(GerarTipo.values());
        comboBox.setBounds(70,90,150,20);
        painelGeradores.add(comboBox);
        
        botaoAdicionar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                try{
                    valores.adicionarValor(Integer.parseInt(caixaEntrada.getText()));
                    resultados.atualizar();
                    caixaEntrada.setText("");
                    caixaEntradaGeradores.setText("");
                }catch(NumberFormatException ex){
                    JOptionPane.showMessageDialog(null,"Digite uma entrada válida!", "Erro ao ler valor",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        );
        
        botaoLimpar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                try {   
                    valores.limpar();
                } catch (CleanException ex) {
                    JOptionPane.showMessageDialog(null, "Não há valores a serem removidos", "Erro ao limpar", JOptionPane.ERROR_MESSAGE);
                }
                resultados.atualizar();
                caixaEntrada.setText("");   
                caixaEntradaGeradores.setText("");
                naturais.getSequence().clear();
                fibonacci.getSequence().clear();
                fatoriais.getSequence().clear();
            }
        }
        );
        
        botaoTirar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                try{
                    valores.tirar();
                    resultados.atualizar();
                    caixaEntrada.setText("");   
                }catch(CleanException ex){
                    JOptionPane.showMessageDialog(null,"Não há valores a serem removidos", "Erro ao limpar",JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        );
        
        botaoGerar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                try{
                    valores.gerar((GerarTipo)comboBox.getSelectedItem() , Integer.parseInt(caixaEntradaGeradores.getText()));
                    resultados.atualizar();
                    caixaEntradaGeradores.setText("");
                    caixaEntrada.setText("");
                }catch(NumberFormatException e){
                    JOptionPane.showMessageDialog(null, "Digite uma entrada válida!", "Erro ao ler valor", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    
    public static void main(String[] args){
        Calculadora calculadora = new Calculadora();
        calculadora.setVisible(true);
    }
}
