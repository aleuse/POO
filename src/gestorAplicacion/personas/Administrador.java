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
	
	/* Metodo para sumar el dinero total disponible en el administrador, el cual recibe la cantidad 
	 * de dinero que se desea agregar al momento en que se paga una consulta y este se le suma
	 * posteriormente a la suma total de dinero disponible
	 */
	public static void sumarDinero(long cantidad) {
		Administrador.dinero += cantidad;
	}
	/* Metodo para restar el dinero disponible en el administrador, el cual recibe
	 * el dinero que se le debera restar al dinero disponible luego de realizar algun
	 * pago
	 */
	public static void restarDinero(long cantidad) {
		Administrador.dinero -= cantidad;
	}
	
	/*Método para verificar si el medico ingresado es de la especialidad indicada, 
	 *  el cual recibe el tipo de medico y el medico al que se le realizará la 
	 *  verificación, el metodo retornara true si el medico es de este tipo y false
	 *  en caso contrario
	 */
	public static boolean verificarTipoMedico(tipoMedico tipo, Medico medico) {
		if(medico.especialista == tipo  ) {
			// Verificar si el médico es de la especialidad indicada
			return true; // Significa que es de esa especialidad
		}
		else {
			return false; // Significa que NO es de esa especialidad
		}
	}
	
	/* Método para verificar si un medico esta disponible o no, este recibe la fecha y
	 * el medico al que se le desea hacer la verficacion, el cual retorna un booleano,
	 * donde true es si el medico esta disponible y false en el caso contrario
	 */
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
	
	/*Metodo para verificar si un consultorio está disponible o no, este recibe la fecha y
	 * el consultorio al que se desea hacer la verificación, el cual retorna un booleano,
	 * donde true es si el consultorio esta disponible y false en caso contrario 
	 */
	
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
	
	/*Metodo para buscar la fecha en la que se puede asignar un examen, el cual recibe
	 * la lista de las fechas, el tipo de médico para el examen, la lista de todos los
	 * medicos en plantilla y los consultorios creados, el cual retorna la fecha mas cercana que
	 * cumple con tener un consultorio disponible, un medico disponible, un medico y que
	 * este ultimo si sea del tipo necesrio
	 */
	public static LocalDateTime verificarDisponibilidadFechaExamen(ArrayList<LocalDateTime> fechas, tipoMedico tipoMed, ArrayList<Medico> medicos, ArrayList<Consultorio> consultorios) {

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
	
	/* Metodo para asignar la cita que es pedida por un paciente, el cual recibe
	 * el paciente que la esta pidoendo, el medico con el que se asignara esta,
	 * el consultorio, la fecha  en que se va a asignar, el motivo y el tipo de la
	 * cita y no retorna nada, ya que el metodo se encarga unicamente de asignaciones
	 * correspondientes 
	 */
	public static void asignarCita(Paciente paciente, Medico medico, Consultorio consultorio, LocalDateTime fecha,String motivo, tipoCita tipo) {
		Cita cita = new Cita(paciente, motivo, medico, consultorio, fecha, tipo);
		Pago pago = new Pago(14700, false);
		cita.setPago(pago);
		pago.setConsulta(cita);
        medico.consultas.put(fecha, cita);
        consultorio.consultas.put(fecha, cita);
	}
	
	/*Metodo para autorizar Examenes, el cual recibe el examen que se desea autorizar,
	 * el tipo de medico necesario para realiazr el examen y la lista de medicos en 
	 * plantilla, el cual devuelve un numero enteor entre el 0 y el 2, donde retorna
	 * 0 en caso de que no hayan medicos con la especialidad necesaria para realizar el examen,
	 * 1 en caso de que este examen sea autorizado con exito y 2 en caso de que por algun 
	 * otro caso no se haya podido autorizar el examen 
	 */
	
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
	/* Metodo para asignar un examen, el cual recibe el examen a asignar, el paciente
	 * al que se le va a asignar, la lista de medicos en plantilla, la lista de consultorios
	 * la fecha a asignar el examen, el tipo de medico y el tipo de examen a asignar, retorna
	 * un String, el cual puede ser de exito y que contiene la fecha en la que se asigno el examen,
	 * el nombre y apellido dek medico al que se le asignó el examen y el id del consultorio 
	 * en que se asigno el examen o un mensaje de error en caso de que el examen no se puede agendar
	 */
	
	public static String asignarExamen(Examen examen, Paciente paciente, ArrayList<Medico> medicos, ArrayList<Consultorio> consultorios, LocalDateTime fecha, tipoMedico tipoMed, tipoExamen tipoExa) {
		if (examen.isAutorizado() == true) {
			for (Medico m: medicos) {
				if(m.getEspecialista() == tipoMed) {
					if(Administrador.verificarDisponibilidadMedico(fecha, m)) {
						examen.setMedico(m);
						for (Consultorio c: consultorios) {
							if(Administrador.verificarDisponibilidadConsultorio(fecha, c)) {
								examen.setConsultorio(c);
								examen.setFecha(fecha);
								examen.setPago(new Pago(tipoExa.getValorExamen(), examen, false));
								paciente.getConsultas().put(fecha, examen);
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