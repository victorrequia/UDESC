package apresentacao;

import dados.CalculadoraEstatistica;
import javax.swing.table.AbstractTableModel;

public class TabelaResultados extends AbstractTableModel{

    private String[] colunas = {"Sorteado","Somatorio","Média Aritmetica","Média Geometrica","Variância","Desvio Padrão","Amplitude"};
    
    private CalculadoraEstatistica calculadora = CalculadoraEstatistica.getInstance();
    
    public TabelaResultados(){
    
    }
    
    @Override
    public String getColumnName(int column){
        return colunas[column];
    }
    
    @Override
    public int getRowCount() {
        return 1;
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(!calculadora.getValores().isEmpty()){
            switch(columnIndex){
            case 0:
                return calculadora.sortear();
            case 1:
                return calculadora.somatorio();
            case 2:
                return calculadora.mediaAritmetica();
            case 3:
                return calculadora.mediaGeometrica();
            case 4:
                return calculadora.variancia();
            case 5:
                return calculadora.desvioPadrao();
            case 6:
                return calculadora.amplitude();
            }
        }else{
            return " - ";
        }
        return null;
    }

    void atualizar() {
        fireTableStructureChanged();
    }
}
