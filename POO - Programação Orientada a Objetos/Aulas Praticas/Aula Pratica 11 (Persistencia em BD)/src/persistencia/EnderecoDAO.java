package persistencia;

import dados.Endereco;
import exception.DeleteException;
import exception.InsertException;
import exception.SelectException;
import exception.UpdateException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class EnderecoDAO implements DAO<Endereco>{
    private Connection conexao;
    private static EnderecoDAO instance = null;
    
    private EnderecoDAO() throws ClassNotFoundException, SQLException{
        Connection conexao  = Conexao.getConexao();
        selectNewId = conexao.prepareStatement(selectNewIdString);
        sqlSelect = conexao.prepareStatement(sqlSelectString);
        sqlInsert = conexao.prepareStatement(sqlInsertString);
        sqlUpdate = conexao.prepareStatement(sqlUpadteString);
        sqlDelete = conexao.prepareStatement(sqlDeleteString);
    }
    
    public static EnderecoDAO getInstance() throws ClassNotFoundException, SQLException{
        if(instance == null){
            instance = new EnderecoDAO();
        }
        return instance;
    }
    
    private PreparedStatement selectNewId;
    private String selectNewIdString = "select nextval('id_endereco')";
    private PreparedStatement sqlSelect;
    private final String sqlSelectString = "select * from endereco where id_pessoa = ?";
    private PreparedStatement sqlInsert;
    private final String sqlInsertString = "insert into endereco (id,rua,numero,cidade,id_pessoa) values (?,?,?,?,?)";
    private PreparedStatement sqlUpdate;
    private final String sqlUpadteString = "update endereco set rua = ?, numero = ?, cidade = ? where id_pessoa = ?";
    private PreparedStatement sqlDelete;
    private final String sqlDeleteString = "delete from endereco where id_pessoa = ?";

    public int selectNewId() throws SelectException{
        try{
            ResultSet rs = selectNewId.executeQuery();
            if(rs.next()){
                return rs.getInt(1); //??????????
            }
        }catch(SQLException e){
            throw new SelectException ("Erro ao buscar novo id da tabela endereco!");
        }
        return 0;
    }

    @Override
    public void inserir(Endereco object) throws InsertException, SelectException{
        try{
            sqlInsert.setInt(1, selectNewId());
            sqlInsert.setString(2, object.getRua());
            sqlInsert.setInt(3, object.getNumero());
            sqlInsert.setString(4,object.getCidade());
            sqlInsert.setInt(5, object.getIdPessoa());
            sqlInsert.executeUpdate();
        } catch(SQLException e){
            throw new InsertException ("Erro ao inserir enderco!");
        }
    }

    @Override
    public void remover(Endereco object) throws DeleteException{
        try{
            sqlDelete.setInt(1, object.getIdPessoa());
            sqlDelete.executeUpdate();
        }catch(SQLException e){
            throw new DeleteException("Erro ao deletar endereco");
        }
    }

    @Override
    public void alterar(Endereco object) throws UpdateException{
        try{    
            sqlUpdate.setString(1, object.getRua());
            sqlUpdate.setInt(2, object.getNumero());
            sqlUpdate.setString(3, object.getCidade());
            sqlUpdate.setInt(4, object.getIdPessoa());
            sqlUpdate.executeUpdate();
        }catch (SQLException e){
            throw new UpdateException("Erro ao atulizar endedero!");
        }
    }

    public Endereco select(int pessoa) throws SelectException{
        try{
            sqlSelect.setInt(1, pessoa);
            ResultSet rs = sqlSelect.executeQuery();
            if(rs.next()){
                int id = rs.getInt(1);
                String rua = rs.getString(2);
                int numero = rs.getInt(3);
                String cidade = rs.getString(4);
                return new Endereco(id, rua, numero, cidade);
            }
        }catch (SQLException e){
            throw new SelectException("Erro ao buscar endereco da pessoa!");
        }
        return null;
    }
    
    
}
