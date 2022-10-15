package gestorAplicacion.personas;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import gestorAplicacion.registrosMedicos.*;
import gestorAplicacion.Cita;
import gestorAplicacion.Consulta;
import gestorAplicacion.Consultorio;
import gestorAplicacion.tipoCita;

public class Medico extends Persona{
    private static ArrayList<Diagnostico> listado= new ArrayList<Diagnostico>(); 
	private boolean disponibilidad;
	private Map<LocalDateTime, Consulta> consultas = new TreeMap<LocalDateTime, Consulta>();

    static ArrayList<Medico>  medicos = new ArrayList<Medico>();
	
    public Medico(String nombre, String apellido, tipoDocumento documento, long numeroDocumento, int edad,
     String genero, long telefono, String correoElectronico, String direccion, tipoCita especialidad, boolean disponibilidad) {
		super(nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion);
		this.especialidad = especialidad;
		this.disponibilidad = disponibilidad;
        medicos.add(this);
		
	}

    public tipoCita getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(tipoCita especialidad) {
        this.especialidad = especialidad;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Map<LocalDateTime, Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(Map<LocalDateTime, Consulta> consultas) {
        this.consultas = consultas;
    }
    
    public static ArrayList<Diagnostico> getListado() {
        return listado;
    }

    public static void setListado(ArrayList<Diagnostico> listado) {
        Medico.listado = listado;
    }
    
    public void crearDiagnostico(ArrayList<String> sintomas, String observacion, String medicamiento, int id){
        Diagnostico diag = new Diagnostico (sintomas, observacion, medicamiento, id);
        listado.add(diag);
    }


}
