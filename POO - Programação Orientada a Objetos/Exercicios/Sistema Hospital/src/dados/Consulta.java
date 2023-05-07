package dados;

public class Consulta {    
    //Atributos
    private int id;
    private Medico medico = new Medico();
    private Paciente paciente = new Paciente();
    private String data;
    private String diagnostico;
    private float valorConsulta;
    
    //Construtor
    public Consulta(int id,String data, String diagnostico, float valorConsulta, Medico medico, Paciente paciente){
        this.id = id;
        this.data = data;
        this.diagnostico = diagnostico;
        this.valorConsulta = valorConsulta;
        this.medico = medico;
        this.paciente = paciente;
    }
    
    public Consulta(){};
    
    //Metodos
    @Override
    public String toString(){
        return this.paciente + "    " + this.data;
    }
    
    public boolean equals(Consulta consulta){
        return consulta.id == this.id;
    }
    
    //Metodos Especiais    
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public float getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(float valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
