package apresentacao;

import dados.CalculadoraEstatistica;
import dados.Fatoriais;
import dados.Fibonacci;
import dados.Naturais;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    
    private JLabel infoCaixaEntrada = new JLabel("Digite um valor:");
    private JTextField caixaEntrada = new JTextField();
    
    private JLabel infoCaixaGeradores = new JLabel("Gerar Valores:");
    private JTextField caixaEntradaGeradores = new JTextField();

    private JButton botaoAdicionar = new JButton("Adicionar");
    private JButton botaoLimpar = new JButton("Limpar");
    private JButton botaoTirar= new JButton("Tirar ultimo");
    
    private JButton botaoFibonacci = new JButton("Fibonacci");
    private JButton botaoNaturais = new JButton("Naturais");
    private JButton botaoFatoriais = new JButton("Fatoriais");

    private JTable tabelaResultados;
    private JTable tabelaValores;

    private TabelaValores valores = new TabelaValores();
    private TabelaResultados resultados = new TabelaResultados();   
    
    private Naturais naturais = new Naturais();
    private Fibonacci fibonacci = new Fibonacci();
    private Fatoriais fatoriais = new Fatoriais();

    public Calculadora(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,900,300);
        setTitle("Calculadora Estatística");
    
        setContentPane(painel);
        painel.setLayout(null);
        
        painelEntrada.setBounds(15,80,280,173);
        painelEntrada.setLayout(null);
        painel.add(painelEntrada);
        
        painelGeradores.setBounds(550,100,300,200);
        painelGeradores.setLayout(null);
        painel.add(painelGeradores);
        
        infoCaixaEntrada.setBounds(30,30,200,15);
        painelEntrada.add(infoCaixaEntrada);
        
        caixaEntrada.setBounds(30,50,200,20);
        caixaEntrada.setColumns(10);
        painelEntrada.add(caixaEntrada);
        
        infoCaixaGeradores.setBounds(0,0,200,40);
        painelGeradores.add(infoCaixaGeradores);
        
        caixaEntradaGeradores.setBounds(0,30,200,20);
        caixaEntradaGeradores.setColumns(10);
        painelGeradores.add(caixaEntradaGeradores);
        
        botaoAdicionar.setBounds(77,85,117,25);
        painelEntrada.add(botaoAdicionar);
        
        botaoLimpar.setBounds(77,115,117,25);
        painelEntrada.add(botaoLimpar);
        
        botaoTirar.setBounds(77,145,117,25);
        painelEntrada.add(botaoTirar);
        
        botaoFibonacci.setBounds(45,65,117,25);
        painelGeradores.add(botaoFibonacci);
        
        botaoNaturais.setBounds(45,95,117,25);
        painelGeradores.add(botaoNaturais);
        
        botaoFatoriais.setBounds(45,125,117,25);
        painelGeradores.add(botaoFatoriais);
    
        painelScrollTabelaResultado.setBounds(10,10,880,50);
        painel.add(painelScrollTabelaResultado);
        
        tabelaResultados = new JTable(resultados);
        painelScrollTabelaResultado.setViewportView(tabelaResultados);
        
        painelScrollTabelaValores.setBounds(307,80,173,173);
        painel.add(painelScrollTabelaValores);
        
        tabelaValores = new JTable(valores);
        painelScrollTabelaValores.setViewportView(tabelaValores);
        
        botaoAdicionar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                valores.adicionarValor(Integer.parseInt(caixaEntrada.getText()));
                resultados.atualizar();
                caixaEntrada.setText("");
            }
        }
        );
        
        botaoLimpar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                valores.limpar();   
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
                valores.tirar();
                resultados.atualizar();
                caixaEntrada.setText("");   
            }
        }
        );
        
        botaoNaturais.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                naturais.gerar(Integer.parseInt(caixaEntradaGeradores.getText())-1);
                for(int i=0; i<naturais.getSequence().size(); i++){
                    valores.adicionarValor(naturais.getSequence().get(i));
                }
                resultados.atualizar();
            } 
        }
        );
        
        botaoFibonacci.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                fibonacci.gerar(Integer.parseInt(caixaEntradaGeradores.getText()));
                for(int i=0; i<fibonacci.getSequence().size(); i++){
                    valores.adicionarValor(fibonacci.getSequence().get(i));
                }
                resultados.atualizar();
            }
        }
        );
        
        botaoFatoriais.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0){
                fatoriais.gerar(Integer.parseInt(caixaEntradaGeradores.getText())-1);
                for(int i=0; i<fatoriais.getSequence().size(); i++){
                    valores.adicionarValor(fatoriais.getSequence().get(i));
                }
                resultados.atualizar();
            }
        }
        );
        
    }
    
    public static void main(String[] args){
        Calculadora calculadora = new Calculadora();
        calculadora.setVisible(true);
    }
}
