package gestorAplicacion.personas;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

import gestorAplicacion.Cita;
import gestorAplicacion.Consulta;

public class Medico extends Persona{
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

}
