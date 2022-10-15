package gestorAplicacion.personas;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import gestorAplicacion.registrosMedicos.*;
import gestorAplicacion.Cita;
import gestorAplicacion.Consulta;
import gestorAplicacion.Consultorio;

public class Medico extends Persona{
    private static ArrayList<Diagnostico> listado= new ArrayList<Diagnostico>();
	private String especialidad;
	private boolean disponibilidad;
	private Map<LocalDateTime, Consulta> consultas = new TreeMap<LocalDateTime, Consulta>();
	
    public Medico(String nombre, String apellido, tipoDocumento documento, long numeroDocumento, int edad,
     String genero, long telefono, String correoElectronico, String direccion, String especialidad, boolean disponibilidad) {
		super(nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion);
		this.especialidad = especialidad;
		this.disponibilidad = disponibilidad;
		
	}

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
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
