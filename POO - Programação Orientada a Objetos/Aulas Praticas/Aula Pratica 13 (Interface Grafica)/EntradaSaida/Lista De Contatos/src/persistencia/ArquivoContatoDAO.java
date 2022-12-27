package persistencia;

import java.util.LinkedList;
import java.util.List;
import dados.Contato;

public class ArquivoContatoDAO {
    private final String caminho = "C:/Users/Victor/Documents/NetBeansProjects/Arquivo/contatos.csv";
    private static EditorTexto arquivo = new EditorTexto();

    private String toCSV(Contato contato){
        String c = "";
        c += contato.getNome() + ",";
        c += contato.getTelefone();
        return c;
    }

    private Contato fromCSV(String linhaCSV){
        String[] atributos = linhaCSV.split(",");
        Contato contato = new Contato();
        contato.setNome(atributos[0]);
        contato.setTelefone(Integer.parseInt(atributos[1]));
        return contato;
    }
    
    public List<Contato> leContatos() {
        return stringToListaContato(arquivo.leTexto(caminho));
    }
    
    private List<Contato> stringToListaContato(List<String> contatos){
        List<Contato> listaContatos = new LinkedList();
        for(String c : contatos){
            listaContatos.add(fromCSV(c));
        }
        return listaContatos;
    }
    
    private List<String> listaContatosToString(List<Contato> contatos){
        List<String> listaContatos = new LinkedList();
        for(Contato contato : contatos){
            listaContatos.add(toCSV(contato));
        }
        return listaContatos;
    }
    
    public void salvaContatos(List<Contato> contatos){
        arquivo.gravaTexto(caminho, listaContatosToString(contatos));
    }
    
    public void salvaContato(Contato contato){
        arquivo.gravaTexto(caminho, toCSV(contato));
    }

}
