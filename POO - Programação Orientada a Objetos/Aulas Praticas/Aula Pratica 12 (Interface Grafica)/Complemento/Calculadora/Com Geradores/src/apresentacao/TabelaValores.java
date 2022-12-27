package apresentacao;

import javax.swing.table.AbstractTableModel;
import dados.CalculadoraEstatistica;

public class TabelaValores extends AbstractTableModel{
    
    private String[] colunas = {"Valores"};
    private CalculadoraEstatistica calculadora = CalculadoraEstatistica.getInstance();

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
    
    /*public void adicionarValores(int[] valores){
        for(int i=0; i<valores.length; i++){
            calculadora.adicionarValor(valores[i]);
            fireTableStructureChanged();
        }
    }*/
    
    public void limpar(){
        calculadora.limparValores();
        fireTableStructureChanged();
    }
    
    public void tirar(){
        calculadora.tirar();
        fireTableStructureChanged();
    }
    
}
