package persistencia;

import dados.Endereco;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;
import java.util.List;

public interface DAO<T> {
    
    public int selectNewId() throws SelectException;
    
    public void inserir(T object) throws SelectException, InsertException;
    
    public void remover(T object) throws DeleteException;
    
    public void alterar(T object) throws UpdateException;
}
