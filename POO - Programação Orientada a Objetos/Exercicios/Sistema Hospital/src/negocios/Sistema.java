package negocios;

import apresentacao.PainelPaciente;
import dados.Consulta;
import dados.Medico;
import dados.Paciente;
import exception.FalhaAlterarException;
import exception.FalhaAutenticarException;
import exception.FalhaBuscarException;
import exception.FalhaInserirException;
import exception.FalhaRemoverException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import persistencia.Conexao;
import persistencia.ConsultaDAO;
import persistencia.MedicoDAO;
import persistencia.PacienteDAO;

public class Sistema {
    //Atributos
    private static Sistema instance = null;
    private ConsultaDAO consultadao = null;
    private PacienteDAO pacientedao = null;
    private MedicoDAO medicodao = null;
    private Connection conexao;
    private boolean loggedUser = false;
    private PainelPaciente painelPaciente;
    
    private Sistema() throws ClassNotFoundException, SQLException{
        try{
            Conexao.setSenha("Udesc");
            conexao = Conexao.getConexao();
            medicodao = MedicoDAO.getInstance();
            pacientedao = PacienteDAO.getInstance();
            consultadao = ConsultaDAO.getInstance();
        }catch(ClassNotFoundException f){
            System.out.println("Classe nao encontrada!");
        }
        catch(SQLException e){
            System.out.println("Falha sql");
        }
    }
    
    public static Sistema getInstance() throws ClassNotFoundException, SQLException{
        if(instance == null){
            instance = new Sistema();
        }
        return instance;
    }
    
    //Metodos    
    public boolean cadastrarPaciente(Paciente paciente) throws FalhaInserirException, FalhaBuscarException{
       return pacientedao.cadastrar(paciente) == true;
    }
    
    public List<Paciente> bucarPaciente() throws FalhaBuscarException{
        return pacientedao.buscarAll();
    }
    
    public boolean removerPaciente(Paciente paciente) throws FalhaRemoverException{
        return pacientedao.remover(paciente);
    }
    
    public boolean alterarPaciente(Paciente paciente) throws FalhaAlterarException{
        return pacientedao.alterar(paciente);
    }
    
    public boolean cadastrarMedico(Medico medico) throws FalhaInserirException, FalhaBuscarException{
        return medicodao.cadastrar(medico);
    }
    
    public boolean removerMedico(Medico medico) throws FalhaRemoverException{
        return medicodao.remover(medico);
    }
    
    public boolean alterarMedico(Medico medico) throws FalhaAlterarException{
        return medicodao.alterar(medico);
    }
    
    public List<Medico> buscarMedico() throws FalhaBuscarException{
        return medicodao.buscarAll();
    }
    
    public boolean cadastrarConsulta(Consulta consulta) throws FalhaInserirException, FalhaBuscarException{
        return consultadao.cadastrar(consulta);
    }
    
    public boolean removerConsulta(Consulta consulta) throws FalhaRemoverException{
        return consultadao.remover(consulta);
    }
    
    public List<Consulta> buscarConsulta() throws FalhaBuscarException{
        return consultadao.buscarAll();
    }
    
    public boolean alterarConsulta(Consulta consulta) throws FalhaAlterarException{
        return consultadao.alterar(consulta);
    }

    public boolean isValidAutentication(String senha, String user) throws FalhaAutenticarException{
        if(senha.equals("123") && (user.equals("Root") || user.equals("Udesc"))){
            this.loggedUser = true;
            return true;
        }else{
            throw new FalhaAutenticarException("");
        }
    }
    
    public boolean isLoggedUser() {
        return loggedUser;
    }
    
    public boolean Logout(){
        if(loggedUser){
            loggedUser = false;
            return true;
        }
        return false;
    }
}
