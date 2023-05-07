package persistencia;

import dados.Paciente;
import exception.FalhaAlterarException;
import exception.FalhaBuscarException;
import exception.FalhaInserirException;
import exception.FalhaRemoverException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PacienteDAO implements DAO<Paciente>{
    private final Connection conexao;
    private static PacienteDAO instance = null;
    
    private PacienteDAO() throws ClassNotFoundException, SQLException{
        conexao = Conexao.getConexao();
        selectNewId = conexao.prepareStatement(selectNewIdString);
        sqlInsert = conexao.prepareStatement(sqlInsertString);
        sqlAlterar = conexao.prepareStatement(sqlAlterarString);
        sqlRemover = conexao.prepareStatement(sqlRemoverString);
        sqlBuscarAll = conexao.prepareStatement(sqlBuscarAllString);
        sqlBuscar = conexao.prepareStatement(sqlBuscarString);
    };
    
    public static PacienteDAO getInstance() throws ClassNotFoundException, SQLException{
        if(instance == null){
            instance = new PacienteDAO();
        }
        return instance;
    }
    
    private final PreparedStatement selectNewId;
    private final String selectNewIdString = "select nextval('id_paciente')";
    private final PreparedStatement sqlInsert; 
    private final String sqlInsertString = "insert into paciente (id,nome,cidade,descricao,cpf,idade) values (?,?,?,?,?,?)";
    private final PreparedStatement sqlAlterar;
    private final String sqlAlterarString = "update paciente set nome = ?,cidade = ?,descricao = ?,cpf = ?,idade = ? where id = ?";
    private final PreparedStatement sqlRemover;
    private final String sqlRemoverString = "delete from paciente where id = ?";
    private final PreparedStatement sqlBuscarAll;
    private final String sqlBuscarAllString = "select * from paciente";
    private final PreparedStatement sqlBuscar;
    private final String sqlBuscarString = "select * from paciente where id = ?";
    
    @Override
    public int selectNewId() throws FalhaBuscarException{
        try{
            ResultSet rs = selectNewId.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
        }catch(SQLException e){
            throw new FalhaBuscarException("Erro ao selecionar novo id para o paciente!");
        }
        return 0;
    }
    
    @Override
    public boolean cadastrar(Paciente objeto) throws FalhaInserirException, FalhaBuscarException {
        try{
            objeto.setId(selectNewId());
            sqlInsert.setInt(1, objeto.getId());
            sqlInsert.setString(2, objeto.getNome());
            sqlInsert.setString(3, objeto.getCidade());
            sqlInsert.setString(4, objeto.getDescricao());
            sqlInsert.setString(5, objeto.getCpf());
            sqlInsert.setInt(6, objeto.getIdade());
            sqlInsert.executeUpdate();
        }catch(SQLException e){
            throw new FalhaInserirException("Erro ao cadastrar paciente!");
        }
        return true;
    }

    @Override
    public boolean alterar(Paciente objeto) throws FalhaAlterarException {
        try{    
            sqlAlterar.setString(1, objeto.getNome());
            sqlAlterar.setString(2, objeto.getCidade());
            sqlAlterar.setString(3, objeto.getDescricao());
            sqlAlterar.setString(4, objeto.getCpf());
            sqlAlterar.setInt(5, objeto.getIdade());
            sqlAlterar.setInt(6, objeto.getId());
            sqlAlterar.executeUpdate();
        }catch(SQLException e){
            throw new FalhaAlterarException("Falha ao alterar paciente!");
        }
        return true;
    }

    @Override
    public boolean remover(Paciente objeto) throws FalhaRemoverException {
        
        try{
            sqlRemover.setInt(1, objeto.getId());
            sqlRemover.executeUpdate();
        }catch(SQLException e){
            throw new FalhaRemoverException("Falha ao remover paciente!");
        }
        return true;
    }

    @Override
    public List<Paciente> buscarAll() throws FalhaBuscarException {
        List<Paciente> pacientes = new LinkedList();
        try{
            ResultSet rs = sqlBuscarAll.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String cidade = rs.getString(3);
                String descricao = rs.getString(4);
                String cpf = rs.getString(5);
                int idade = rs.getInt(6);
                
                Paciente paciente = new Paciente(id,nome,cidade,descricao,cpf,idade);
                pacientes.add(paciente);
            }
        }catch(SQLException e){
            throw new FalhaBuscarException("Falha ao buscar pacientes!");
        }
        return pacientes;
    }   
    
    public Paciente sqlBuscar(int id_medico) throws FalhaBuscarException{
        try{
            sqlBuscar.setInt(1, id_medico);
            ResultSet rs = sqlBuscar.executeQuery();
            if(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String cidade = rs.getString(3);
                String descricao = rs.getString(4);
                String cpf = rs.getString(5);
                int idade = rs.getInt(6);

                Paciente p = new Paciente(id,nome,cidade,descricao,cpf,idade);
                return p;
            }else{
                throw new FalhaBuscarException("Paciente nao encontrado!");
            }
        }catch(SQLException e){
            throw new FalhaBuscarException("Falha ao buscar paciente!");
        }
    }
}
