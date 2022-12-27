package apresentacao;

import dados.CalculadoraEstatistica;
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
    private JScrollPane painelScrollTabelaResultado = new JScrollPane();
    private JScrollPane painelScrollTabelaValores = new JScrollPane();
    
    private JLabel infoCaixaEntrada = new JLabel("Digite um valor:");
    private JTextField caixaEntrada = new JTextField();

    private JButton botaoAdicionar = new JButton("Adicionar");
    private JButton botaoLimpar = new JButton("Limpar");
    private JButton botaoTirar= new JButton("Tirar ultimo");

    private JTable tabelaResultados;
    private JTable tabelaValores;

    private TabelaValores valores = new TabelaValores();
    private TabelaResultados resultados = new TabelaResultados();   

    public Calculadora(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,900,300);
        setTitle("Calculadora Estatística");
    
        setContentPane(painel);
        painel.setLayout(null);
        
        painelEntrada.setBounds(15,80,280,173);
        painelEntrada.setLayout(null);
        painel.add(painelEntrada);
        
        infoCaixaEntrada.setBounds(30,30,200,15);
        painelEntrada.add(infoCaixaEntrada);
        
        caixaEntrada.setBounds(30,50,200,20);
        caixaEntrada.setColumns(10);
        painelEntrada.add(caixaEntrada);
        
        botaoAdicionar.setBounds(77,85,117,25);
        painelEntrada.add(botaoAdicionar);
        
        botaoLimpar.setBounds(77,115,117,25);
        painelEntrada.add(botaoLimpar);
        
        botaoTirar.setBounds(77,145,117,25);
        painelEntrada.add(botaoTirar);
    
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
        
    }
    
    public static void main(String[] args){
        Calculadora calculadora = new Calculadora();
        calculadora.setVisible(true);
    }
}
