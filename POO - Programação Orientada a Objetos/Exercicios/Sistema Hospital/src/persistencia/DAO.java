package persistencia;

import exception.*;
import java.util.List;

public interface DAO<T> {
    public int selectNewId() throws FalhaBuscarException;
    public boolean cadastrar(T objeto) throws FalhaInserirException, FalhaBuscarException;
    public boolean alterar(T Objeto) throws FalhaAlterarException;
    public boolean remover(T objeto) throws FalhaRemoverException;
    public List<T> buscarAll() throws FalhaBuscarException;
}
