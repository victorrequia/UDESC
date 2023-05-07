package persistencia;

import dados.Medico;
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

public class MedicoDAO implements DAO<Medico>{
    private final Connection conexao;
    private static MedicoDAO instance = null;
    
    private MedicoDAO() throws ClassNotFoundException, SQLException{
        conexao = Conexao.getConexao();
        selectNewId = conexao.prepareStatement(selecNewIdString);
        sqlCadastrar = conexao.prepareStatement(sqlCadastrarString);
        sqlAlterar = conexao.prepareStatement(sqlAlterarString);
        sqlRemover = conexao.prepareStatement(sqlRemoverString);
        sqlBuscarAll = conexao.prepareStatement(sqlBuscarAllString);
        sqlBuscar = conexao.prepareStatement(sqlBuscarString);
    };

    public static MedicoDAO getInstance() throws ClassNotFoundException, SQLException{
        if(instance == null){
            instance = new MedicoDAO();
        }
        return instance;
    }
    
    private final PreparedStatement selectNewId;
    private final String selecNewIdString = "select nextval('id_medico')";
    private final PreparedStatement sqlCadastrar;
    private final String sqlCadastrarString = "insert into medico (id,nome,cidade,especializacao,idade,cpf) values (?,?,?,?,?,?)";
    private final PreparedStatement sqlAlterar;
    private final String sqlAlterarString = "update medico set nome = ?,cidade = ?,especializacao = ?,idade = ?, cpf = ? where id = ?";
    private final PreparedStatement sqlRemover;
    private final String sqlRemoverString = "delete from medico where id = ?";
    private final PreparedStatement sqlBuscarAll;
    private final String sqlBuscarAllString = "select * from medico";
    private final PreparedStatement sqlBuscar;
    private final String sqlBuscarString = "select * from medico where id = ?";
    
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
    public boolean cadastrar(Medico objeto) throws FalhaInserirException, FalhaBuscarException {
        try{
            objeto.setId(selectNewId());
            sqlCadastrar.setInt(1, objeto.getId());
            sqlCadastrar.setString(2, objeto.getNome());
            sqlCadastrar.setString(3, objeto.getCidade());
            sqlCadastrar.setString(4, objeto.getEspecializacao());
            sqlCadastrar.setInt(5, objeto.getIdade());
            sqlCadastrar.setString(6, objeto.getCpf());
            sqlCadastrar.executeUpdate();
        }catch(SQLException e){
            throw new FalhaInserirException("Falha ao cadastrar medico!");
        }
        return true;
    }

    @Override
    public boolean alterar(Medico objeto) throws FalhaAlterarException{
        try{
            sqlAlterar.setString(1, objeto.getNome());
            sqlAlterar.setString(2, objeto.getCidade());
            sqlAlterar.setString(3, objeto.getEspecializacao());
            sqlAlterar.setInt(4, objeto.getIdade());
            sqlAlterar.setString(5, objeto.getCpf());
            sqlAlterar.setInt(6, objeto.getId());
            sqlAlterar.executeUpdate();
        }catch(SQLException e){
            throw new FalhaAlterarException("Falha ao alterar medico!");
        }
        return true;
    }

    @Override
    public boolean remover(Medico objeto) throws FalhaRemoverException {
        try{
            sqlRemover.setInt(1, objeto.getId());
            sqlRemover.executeUpdate();
        }catch(SQLException e){
            throw new FalhaRemoverException("Falha ao remover medico!");
        }
        return true;
    }

    @Override
    public List<Medico> buscarAll() throws FalhaBuscarException {
        List<Medico> medicos = new LinkedList();
        try{
            ResultSet rs = sqlBuscarAll.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String cidade = rs.getString(3);
                String especializacao = rs.getString(4);
                int idade = rs.getInt(5);
                String cpf = rs.getString(6);
                
                Medico medico = new Medico(id,nome,cidade,especializacao,idade,cpf);
                medicos.add(medico);
            }
        }catch(SQLException e){
            throw new FalhaBuscarException("Falha ao buscar medico!");
        }
        return medicos;
    }
    
    public Medico sqlBuscar(int id_medico) throws FalhaBuscarException{
        try{
            sqlBuscar.setInt(1, id_medico);
            ResultSet rs = sqlBuscar.executeQuery();
            if(rs.next()){
               int id = rs.getInt(1);
               String nome = rs.getString(2);
               String cidade = rs.getString(3);
               String especializacao = rs.getString(4);
               int idade = rs.getInt(5);
               String cpf = rs.getString(6);

               Medico me = new Medico(id, nome, cidade, especializacao, idade, cpf);
               return me;   
            }else{
                throw new FalhaBuscarException("Medico nao encontrado!");
            }
        }catch(SQLException e){
            throw new FalhaBuscarException("Falha ao buscar medico!");
        }
    }
}
