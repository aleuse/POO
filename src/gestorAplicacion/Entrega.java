package gestorAplicacion;
import java.util.ArrayList;
import gestorAplicacion.personas.Paciente;

public class Entrega {
    private int id;
    private String paciente;
    private String domicilio;
    private ArrayList<String> medicamentos;
    private estadoEntrega estado;
    public static ArrayList<Entrega> lista= new ArrayList<Entrega>();
    public Entrega(int id, String paciente, String domicilio, ArrayList<String> medicamentos, estadoEntrega estado) {
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
    public String getPaciente() {
        return paciente;
    }
    public void setPaciente(String paciente) {
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
    public static void crearEntrega(int id, String paciente,String domicilio, ArrayList<String> medicamentos,estadoEntrega estado){
        Entrega entrega = new Entrega (id, paciente, domicilio, medicamentos, estado);
        lista.add(entrega);
    }
    
    
}
