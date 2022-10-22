package gestorAplicacion.personas;

import gestorAplicacion.personas.*;
import gestorAplicacion.Cita;
import gestorAplicacion.Consultorio;
import gestorAplicacion.Examen;
import gestorAplicacion.Pago;
import gestorAplicacion.tipoCita;
import gestorAplicacion.tipoExamen;
import gestorAplicacion.registrosMedicos.*;

import java.io.Serializable;
import java.time.*;
import java.util.ArrayList;

public class Administrador implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	public static long dinero; 
	
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

	public static void sumarDinero(long cantidad) {
		Administrador.dinero += cantidad;
	}

	public static void restarDinero(long cantidad) {
		Administrador.dinero -= cantidad;
	}

	public static boolean verificarDisponibilidadMedico(LocalDateTime fecha, Medico medico) {
		if(medico.getConsultas().get(fecha) == null) {
			// Para Medico, en su diccionario de Consultas (Key = fecha, value = Consulta) verifica si para la fecha 
			// especificada el value asociado es igual a null, o sea, NO tiene una consulta asociada y eso significa
			// que está disponible
			return true; // Significa que está disponible
		}
		else {
			return false; // Significa que NO está disponible
		}
	}
	
	public static boolean verificarDisponibilidadConsultorio(LocalDateTime fecha, Consultorio consultorio) {
		if(consultorio.getConsultas().get(fecha) == null) {
			// Para Consultorio, en su diccionario de Consultas (Key = fecha, value = Consulta) verifica si para la
			// fecha especificada (key) el value asociado es igual a null, o sea, NO tiene una consulta asociada y
			// eso significa que está disponible
			return true; // Significa que está disponible
		}
		else {
			return false; // Significa que NO está disponible
		}
	}
	
	public static void asignarCita(Paciente paciente, Medico medico, Consultorio consultorio, LocalDateTime fecha,String motivo, tipoCita tipo) {
		Cita cita = new Cita(paciente, motivo, medico, consultorio, fecha, tipo);
		Pago pago = new Pago(14700, false);
		cita.setPago(pago);
		pago.setConsulta(cita);
        medico.consultas.put(fecha, cita);
        consultorio.consultas.put(fecha, cita);
	}
	
	public static void autorizarExamen(Examen examen) {
			examen.setAutorizado(true);		
	}
	
	public static String asignarExamen(Examen examen, Paciente paciente, ArrayList<Medico> medicos, ArrayList<Consultorio> consultorios, LocalDateTime fecha) {
		if (examen.isAutorizado() == true) {
			for (Medico m: medicos) {
				if(Administrador.verificarDisponibilidadMedico(fecha, m)) {
					examen.setMedico(m);
					for (Consultorio c: consultorios) {
						if(Administrador.verificarDisponibilidadConsultorio(fecha, c)) {
							examen.setConsultorio(c);
							examen.setFecha(fecha);
							examen.setPago(new Pago(37000, examen, false));
							c.getConsultas().put(fecha, examen);
							break;
						}
					}
					m.getConsultas().put(fecha, examen);
					break;
				}
			}
			
			return "Examen agendado exitosamente el " + fecha + " con el médico " + examen.getMedico().getNombre() + "" + examen.getMedico().getApellido() + " en el consultorio " + examen.getConsultorio().getId();
		}
		return "No se pudo agendar el examen";
	}
}