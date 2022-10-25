package gestorAplicacion;
import java.io.Serializable;
import java.util.ArrayList;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.Pago;


public class Entrega implements Serializable{
    private static final long serialVersionUID = 1L;
	private int id;
    private Paciente paciente;
    private String domicilio;
    private Medicamentos medicamentos;
    private estadoEntrega estado;
    public static ArrayList<Entrega> lista= new ArrayList<Entrega>();
    private Pago pago;
    
    //constructor
    public Entrega(int id, Paciente paciente, String domicilio, Medicamentos medicamentos, estadoEntrega estado) {
        this.id = id;
        this.paciente = paciente;
        this.domicilio = domicilio;
        this.medicamentos = medicamentos;
        this.estado = estado;
        lista.add(this);
    }
    
    public Entrega(Paciente paciente, String domicilio, Medicamentos medicamentos, estadoEntrega estado) {
        this.id = (int)(Math.random()*10000+1);
        this.paciente = paciente;
        this.domicilio = domicilio;
        this.medicamentos = medicamentos;
        this.estado = estado;
        lista.add(this);
    }
    
    //getter & setter
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
    public Medicamentos getMedicamentos() {
        return medicamentos;
    }
    public void setMedicamentos(Medicamentos medicamentos) {
        this.medicamentos = medicamentos;
    }
    public estadoEntrega getEstado() {
        return estado;
    }
    public void setEstado(estadoEntrega estado) {
        this.estado = estado;
    }

    public Pago getPago() {
        return pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }

    
    //metodos
    public static void crearEntrega(int id, Paciente paciente,String domicilio, Medicamentos medicamentos,estadoEntrega estado){
        new Entrega (id, paciente, domicilio, medicamentos, estado);
        
    }
    
    public static int informeEntregas(estadoEntrega solicitado){// se ingresa el tipo de entrega y se busca en la lista cuantas hay
        int eeSolicitada=0;
        for (Entrega ee : lista) {
            if(ee.getEstado()==solicitado){
                eeSolicitada++;
            }
        }
        return eeSolicitada;
    }
    
    
}
