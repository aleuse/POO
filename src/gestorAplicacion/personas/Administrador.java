package gestorAplicacion.personas;

import gestorAplicacion.personas.*;
import gestorAplicacion.Cita;
import gestorAplicacion.Consultorio;
import gestorAplicacion.Examen;
import gestorAplicacion.Pago;
import gestorAplicacion.tipoCita;
import gestorAplicacion.tipoExamen;
import gestorAplicacion.registrosMedicos.*;

import java.time.*;
import java.util.ArrayList;

public class Administrador {
	private int id;
	private String nombre;
	
	// Constructor
	public Administrador(int id, String nombre) {
		this.setId(id);
		this.setNombre(nombre);
	}

	//Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Métodos
	public void asignarCita(Paciente paciente, Medico medico, Consultorio consultorio, LocalDateTime fecha, String motivo, tipoCita tipo) {
		Cita cita = new Cita(paciente, medico, consultorio, fecha, motivo, tipo);
		Pago pago = new Pago(14700, false);
		cita.setPago(pago);
		pago.setConsulta(cita);
	}
	
	public void autorizarExamen(Examen examen) {
			examen.setAutorizado(true);		
	}
	
	public String asignarExamen(Examen examen, Paciente paciente, ArrayList<Medico> medicos, ArrayList<Consultorio> consultorios, LocalDateTime fecha) {
		if (examen.isAutorizado() == true) {
			for (Medico m: medicos) {
				if(m.getConsultas().get(fecha) == null) {
					examen.setMedico(m);
					for (Consultorio c: consultorios) {
						if(c.getConsultas().get(fecha) == null) {
							examen.setConsultorio(c);
							examen.setFecha(fecha);
							examen.setPago(new Pago(37000, examen, false));
							c.getConsultas().put(fecha, examen);
						}
					}
					m.getConsultas().put(fecha, examen);
				}
			}
			
			return "Examen agendado exitosamente el " + fecha + " con el médico " + examen.getMedico().getNombre() + "" + examen.getMedico().getApellido() + " en el consultorio " + examen.getConsultorio().getId();
		}
		return "No se pudo agendar el examen";
	}
}