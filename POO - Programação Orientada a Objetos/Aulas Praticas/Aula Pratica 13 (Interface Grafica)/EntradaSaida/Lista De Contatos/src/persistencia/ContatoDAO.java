package persistencia;

import java.util.List;
import dados.Contato;

public class ContatoDAO {
    private ArquivoContatoDAO arquivoContatoDAO = new ArquivoContatoDAO();
 
    public void insert(Contato contato){
        arquivoContatoDAO.salvaContato(contato);
    }

    public void delete(Contato contato){
        List<Contato> contatos = arquivoContatoDAO.leContatos();
        contatos.remove(contato);
        arquivoContatoDAO.salvaContatos(contatos);
    }
    
    public List<Contato> getAll(){
        return arquivoContatoDAO.leContatos();
    }
}
