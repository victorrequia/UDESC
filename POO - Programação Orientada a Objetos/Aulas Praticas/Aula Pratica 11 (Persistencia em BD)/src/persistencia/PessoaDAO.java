package persistencia;

import dados.Endereco;
import dados.Pessoa;
import exception.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PessoaDAO implements DAO<Pessoa>{
    private Connection conexao;
    private static EnderecoDAO enderecoDAO = null;
    private static PessoaDAO instance = null;
    
    private PessoaDAO() throws ClassNotFoundException, SQLException{
        Connection conexao = Conexao.getConexao();
        selectNewId = conexao.prepareStatement(selectNewIdString);
        sqlInsert = conexao.prepareStatement(sqlInsertString);
        sqlSelect = conexao.prepareStatement(sqlSelectString);
        sqlDelete = conexao.prepareStatement(sqlDeleteString);
        sqlUpdate = conexao.prepareStatement(sqlUpdateString);
        enderecoDAO = EnderecoDAO.getInstance();
    } 
    
    public static PessoaDAO getInstance() throws ClassNotFoundException, SQLException{
        if(PessoaDAO == null){
            instance = new PessoaDAO();
        }
        return instance;
    }
    
    private PreparedStatement selectNewId;
    private final String selectNewIdString = "select nextval('id_pessoa')";
    private PreparedStatement sqlInsert;
    private final String sqlInsertString = "insert into pesssoa (id,nome,cpf,telefone) values (?,?,?,?)";
    private PreparedStatement sqlSelect;
    private final String sqlSelectString = "select * from pessoa";
    private PreparedStatement sqlDelete;
    private final String sqlDeleteString = "delete from pessoa where id = ?";
    private final PreparedStatement sqlUpdate;
    private String sqlUpdateString = "update pessoa set nome = ?, cpf = ?, telefone = ? where id = ?";
    
    
    @Override
    public int selectNewId()  throws SelectException{
        try{
            ResultSet rs = selectNewId.executeQuery();
            if(rs.next()) {
                return rs.getInt(1);
            }
        }catch(SQLException e){
            throw new SelectException("Erro ao buscar na tabela pessoa!");
        }
        return 0;
    }

    @Override
    public void inserir(Pessoa object) throws InsertException, SelectException{
        try{
            object.setId(selectNewId());
            sqlInsert.setInt(1, object.getId());
            sqlInsert.setString(2, object.getNome());
            sqlInsert.setInt(3, object.getCpf());
            sqlInsert.setInt(4, object.getTelefone());
            sqlInsert.executeUpdate();
            object.getEndereco().setIdPessoa(object.getId());
            enderecoDAO.inserir(object.getEndereco());
        }catch(SQLException e){
            throw new InsertException("Erro ao inserir pessoa!");
        }
    }

    @Override
    public void remover(Pessoa object) throws DeleteException{
        enderecoDAO.remover(object.getEndereco());
        try{
            sqlDelete.setInt(1, object.getId());
            sqlDelete.executeUpdate();
        }catch(SQLException e){
            throw new DeleteException("Erro ao deletar pessoa!");
        }
    }

    @Override
    public void alterar(Pessoa object) throws UpdateException{
        try{
            enderecoDAO.alterar(object.getEndereco());
            sqlUpdate.setString(1, object.getNome());
            sqlUpdate.setInt(2, object.getCpf());
            sqlUpdate.setInt(3, object.getTelefone());
            sqlUpdate.setInt(4, object.getId());
            sqlUpdate.executeUpdate();
        }catch(SQLException e){
            throw new UpdateException("Erro ao alterar pessoa!");
        }
    }

    public List<Pessoa> selectAll() throws SelectException{
        List<Pessoa> pessoas = new LinkedList();
        try{
            ResultSet rs = sqlSelect.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                int cpf = rs.getInt(3);
                int telefone = rs.getInt(4);

                Endereco endereco = enderecoDAO.select(rs.getInt(1));
                pessoas.add(new Pessoa(id, nome, cpf, telefone, endereco));
            }
        }catch(SQLException e){
                throw new SelectException("Erro ao bucar pessoa!");
        }
        return pessoas;
    }
    
}
