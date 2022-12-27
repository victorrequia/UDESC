package negocio;

import java.util.List;
import dados.Contato;
import persistencia.ContatoDAO;
import java.util.List;
import java.util.LinkedList;

public class ListaTelefonica {
    private ContatoDAO contatoDAO = new ContatoDAO();
    
    public List<Contato> buscarContatos(){
        return contatoDAO.getAll();
    }
    
    public void adicionarContato(Contato c){
        contatoDAO.insert(c);
    }
    
    public void removerContato(Contato c){
        contatoDAO.delete(c);
    }
    
    public List<Contato> buscarContato(Character letra){
        char l = Character.toUpperCase(letra);
        List<Contato> contatos = new LinkedList();
        for(Contato c : contatoDAO.getAll()){
            if(c.getNome().charAt(0) == l){
                contatos.add(c);
            }
        }
        
        return contatos;   
    }
}
