package gestorAplicacion.personas;

import gestorAplicacion.personas.*;
import gestorAplicacion.Cita;
import gestorAplicacion.Consulta;
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
	// Lista de médicos en el sistema médico
	public static ArrayList<Medico> medicos = new ArrayList<Medico>();
	// Lista de consultorios en el sistema médico
	public static ArrayList<Consultorio> consultorios = new ArrayList<Consultorio>();
	// Lista de pacientes en el sistema médico
	public static ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
	public static ArrayList<LocalDateTime> fechas = new ArrayList<LocalDateTime>();
	//public static ArrayList<Cita> citas = new ArrayList<Cita>();
	//public static ArrayList<Examen> examenes = new ArrayList<Examen>();
	
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

	public static boolean verificarTipoMedico(tipoMedico tipo, Medico medico) {
		if(medico.especialista == tipo  ) {
			// Verificar si el médico es de la especialidad indicada
			return true; // Significa que es de esa especialidad
		}
		else {
			return false; // Significa que NO es de esa especialidad
		}
	}
	
	
	public static boolean verificarDisponibilidadMedico(LocalDateTime fecha, Medico medico) {
		if(medico.getConsultas().get(fecha) == null  ) {
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
	public static LocalDateTime verificarDisponibilidadFechaExamen(ArrayList<LocalDateTime> fechas, tipoMedico tipoMed, ArrayList<Medico> medicos, ArrayList<Consultorio> consultorios) {
		// Devuelve la fecha más cercana que cumple con tener un consultorio disponible, un médico disponible y que sea especialista
		// del tipo necesario
		for(LocalDateTime fecha: fechas) {
			// Buscar un médico disponible
			for (Medico m: medicos) {
				// Verificar que el médico es un especialista adecuado para dicho examen
				if (Administrador.verificarTipoMedico(tipoMed, m)) {
					// Verificar que el médico tenga disponibilidad
					if(Administrador.verificarDisponibilidadMedico(fecha, m)) {
						// Buscar un consultorio disponible
						for (Consultorio c: consultorios) {
							if(Administrador.verificarDisponibilidadConsultorio(fecha, c)) {
								return fecha;
							}
						}
					}
				}	
			}
		}
		return null;
	}
	public static void asignarCita(Paciente paciente, Medico medico, Consultorio consultorio, LocalDateTime fecha,String motivo, tipoCita tipo) {
		Cita cita = new Cita(paciente, motivo, medico, consultorio, fecha, tipo);
		Pago pago = new Pago(14700, false);
		cita.setPago(pago);
		pago.setConsulta(cita);
        medico.consultas.put(fecha, cita);
        consultorio.consultas.put(fecha, cita);
	}
	
	public static int autorizarExamen(Examen examen, tipoMedico tipoMed, ArrayList<Medico> medicos) {
		for (Medico m: medicos) {
			// Si hay al menos un médico con la especialidad necesaria para el examen
			if(m.getEspecialista() == tipoMed){
				// Se genera un número aleatorio para simular posibles fallos a la hora de autorizar el examen
				double x = Math.random();
				// Si el número aleatorio es mayor a 0.4 entonces se asigna el examen
		        if (x > 0.2) {
		        	examen.setAutorizado(true);
		        	// Autorizado con éxito
		        	return 1;
		        }
		        else {
		        	// Lo sentimos ha ocurrido un problema y no se ha podido autorizar el examen
		        	return 2;
		        }
			}
		}
		// Lo sentimos, en este momento no tenemos médicos que puedan atender su tipo de examen
		return 0;
		
			
	}
	
	public static String asignarExamen(Examen examen, Paciente paciente, ArrayList<Medico> medicos, ArrayList<Consultorio> consultorios, LocalDateTime fecha, tipoMedico tipoMed) {
		if (examen.isAutorizado() == true) {
			for (Medico m: medicos) {
				if(m.getEspecialista() == tipoMed) {
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
					}
				}
				m.getConsultas().put(fecha, examen);
				return "Examen agendado exitosamente el " + fecha + " con el médico " + examen.getMedico().getNombre() + " " + examen.getMedico().getApellido() + " en el consultorio " + examen.getConsultorio().getId();
			}
		}
		return "No se pudo agendar el examen";
	}
}