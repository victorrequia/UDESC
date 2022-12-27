package apresentacao;

import javax.swing.table.AbstractTableModel;
import dados.CalculadoraEstatistica;
import dados.GerarTipo;
import exceptions.CleanException;

public class TabelaValores extends AbstractTableModel{
    
    private String[] colunas = {"Valores"};
    private CalculadoraEstatistica calculadora = CalculadoraEstatistica.getInstance();

    public void gerar(GerarTipo tipo, int n){
        calculadora.getValores().clear();
        calculadora.gerar(tipo, n);
        fireTableStructureChanged();
    }
    
    @Override
    public int getRowCount() {
        return calculadora.getValores().size();
    }

    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return calculadora.getValores().get(rowIndex);
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    public void adicionarValor(int valor){
        calculadora.adicionarValor(valor);
        fireTableStructureChanged();
    }
    
    public void limpar() throws CleanException{
        calculadora.limparValores();
        fireTableStructureChanged();
    }
    
    public void tirar()throws CleanException{
        calculadora.tirar();
        fireTableStructureChanged();
    }
    
}
