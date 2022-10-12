package gestorAplicacion.personas;

import gestorAplicacion.Cita;
import gestorAplicacion.Consultorio;
import gestorAplicacion.tipoCita;
import gestorAplicacion.registrosMedicos.*;

import java.time.*;

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
		pago.setCita(cita);
	}
}