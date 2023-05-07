package persistencia;

import dados.Consulta;
import dados.Medico;
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

public class ConsultaDAO implements DAO<Consulta>{
    private final Connection conexao;
    private static ConsultaDAO instance = null;
    private MedicoDAO medicodao = null;
    private PacienteDAO pacientedao = null;
    
    private ConsultaDAO() throws ClassNotFoundException, SQLException{
        conexao = Conexao.getConexao();
        medicodao = MedicoDAO.getInstance();
        pacientedao = PacienteDAO.getInstance();
        selectNewId = conexao.prepareStatement(selectNewIdString);
        sqlInsert = conexao.prepareStatement(sqlInsertString);
        sqlAlterar = conexao.prepareStatement(sqlAlterarString);
        sqlBuscar = conexao.prepareStatement(sqlBuscarString);
        sqlRemove = conexao.prepareStatement(sqlRemoveString);
    }
    
    public static ConsultaDAO getInstance() throws ClassNotFoundException, SQLException{
        if(instance == null){
            instance = new ConsultaDAO();
        }
        return instance;
    }
    
    private final PreparedStatement selectNewId;
    private final String selectNewIdString = "select nextval('id_consulta')";
    private final PreparedStatement sqlInsert; 
    private final String sqlInsertString = "insert into consulta (id,data,diagnostico,valorconsulta,id_medico,id_paciente) values (?,?,?,?,?,?)";
    private final PreparedStatement sqlAlterar;
    private final String sqlAlterarString = "update consulta set data = ?, diagnostico = ?, valorConsulta = ?, id_medico = ?, id_paciente = ? where id = ?";
    private final PreparedStatement sqlRemove;
    private final String sqlRemoveString = "delete from consulta where id = ?";
    private final PreparedStatement sqlBuscar;
    private final String sqlBuscarString = "select * from consulta";
    
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
    public boolean cadastrar(Consulta objeto) throws FalhaInserirException, FalhaBuscarException{
        try{
            objeto.setId(selectNewId());
            sqlInsert.setInt(1, objeto.getId());
            sqlInsert.setString(2, objeto.getData());
            sqlInsert.setString(3, objeto.getDiagnostico());
            sqlInsert.setFloat(4, objeto.getValorConsulta());
            sqlInsert.setInt(5, objeto.getMedico().getId());
            sqlInsert.setInt(6, objeto.getPaciente().getId());
            sqlInsert.executeUpdate();
        }catch(SQLException e){
            throw new FalhaInserirException("Falha ao cadastrar consulta!");
        }
        return true;
    }

    @Override
    public boolean alterar(Consulta objeto) throws FalhaAlterarException {
        try{
            sqlAlterar.setString(1, objeto.getData());
            sqlAlterar.setString(2, objeto.getDiagnostico());
            sqlAlterar.setFloat(3, objeto.getValorConsulta());
            sqlAlterar.setInt(4, objeto.getMedico().getId());
            sqlAlterar.setInt(5, objeto.getPaciente().getId());
            sqlAlterar.setInt(6, objeto.getId());
            sqlAlterar.executeUpdate();
        }catch(SQLException e){
            throw new FalhaAlterarException("Falha ao alterar consullta!");
        }
        return true;
    }

    @Override
    public boolean remover(Consulta objeto) throws FalhaRemoverException {
        try{
            sqlRemove.setInt(1, objeto.getId());
            sqlRemove.executeUpdate();
        }catch(SQLException e){
            throw new FalhaRemoverException("Falha ao remover consulta!");
        }
        return true;
    }

    @Override
    public List<Consulta> buscarAll() throws FalhaBuscarException {
        List<Consulta> consultas = new LinkedList();
        try{
        ResultSet rs = sqlBuscar.executeQuery();
        while(rs.next()){
            int id = rs.getInt(1);
            String data = rs.getString(2);
            String diagnostico = rs.getString(3);
            float valorConsulta = rs.getFloat(4);
            int id_medico = rs.getInt(5);
            int id_paciente = rs.getInt(6);

            Medico medico = medicodao.sqlBuscar(id_medico);
            Paciente paciente = pacientedao.sqlBuscar(id_paciente);
            
            Consulta consulta = new Consulta(id,data,diagnostico,valorConsulta,medico,paciente);
            consultas.add(consulta);
        }
        }catch(SQLException e){
            throw new FalhaBuscarException("Falha ao buscar consulta!");
        }
        return consultas;
    }
}
