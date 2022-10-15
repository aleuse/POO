package gestorAplicacion;
import java.util.ArrayList;
import gestorAplicacion.personas.Paciente;

public class Entrega {
    private int id;
    private Paciente paciente;
    private String domicilio;
    private ArrayList<String> medicamentos;
    private estadoEntrega estado;
    public Entrega(int id, Paciente paciente, String domicilio, ArrayList<String> medicamentos, estadoEntrega estado) {
        this.id = id;
        this.paciente = paciente;
        this.domicilio = domicilio;
        this.medicamentos = medicamentos;
        this.estado = estado;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    public ArrayList<String> getMedicamentos() {
        return medicamentos;
    }
    public void setMedicamentos(ArrayList<String> medicamentos) {
        this.medicamentos = medicamentos;
    }
    public estadoEntrega getEstado() {
        return estado;
    }
    public void setEstado(estadoEntrega estado) {
        this.estado = estado;
    }
    
    
}
