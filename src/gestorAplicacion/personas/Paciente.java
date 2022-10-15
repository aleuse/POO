package gestorAplicacion.personas;
import gestorAplicacion.Cita;
import gestorAplicacion.Consulta;
import gestorAplicacion.Examen;
import gestorAplicacion.tipoExamen;
import gestorAplicacion.registrosMedicos.Diagnostico;
import gestorAplicacion.registrosMedicos.HistoriaClinica;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;



public class Paciente extends Persona{
	private String eps;
	private ArrayList<String> sintomas;
	private HistoriaClinica historiaClinica;
	private Map<LocalDateTime, Consulta> consultas = new TreeMap<LocalDateTime, Consulta>();
	
	public Paciente(String nombre, String apellido, tipoDocumento documento, long numeroDocumento, int edad, String genero, long telefono, String correoElectronico, String direccion, String eps, 
			ArrayList<String> sintomas, HistoriaClinica historiaClinica) {
		super(nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion);
		setEps(eps);
		setSintomas(sintomas);
		setHistoriaClinica(historiaClinica);
		
	}
	
	public Paciente() {
		this(null,null, null, 0, 0, null, 0, null, null,null, new ArrayList<String>(), null);
	}
	
	public String getEps() {
		return eps;
	}
	public void setEps(String eps) {
		this.eps = eps;
	}
	
	public ArrayList<String> getSintomas() {
		return sintomas;
	}
	public void setSintomas(ArrayList<String> sintomas) {
		this.sintomas = sintomas;
	}
	
	public HistoriaClinica getHistoriaClinica() {
		return historiaClinica;
	}
	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}
	public Map<LocalDateTime, Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(Map<LocalDateTime, Consulta> consultas) {
		this.consultas = consultas;
	}
	
	
	public void piderCita(LocalDateTime fecha, tipoCita tipoCita, String motivo) {
		Cita cita = new Cita((int)(Math.random()*10000+1), paciente(this), motivo,)
	}
	
//	public void actualizarDatos(Map <Object, String> datos) {
//		for (int i = 0; i< datos.size(); i++) {
//
//		}
//	}
	
	public void solicitarExamen(tipoExamen tipo, LocalDateTime fecha) {
		Examen examen = new Examen((int)(Math.random()*10000+1), this, tipo, false);
		Administrador.autorizarExamen(examen);
		// Filtrar médicos disponibles para la fecha
		// Filtrar consultorios disponibles para la fecha
		Administrador.asignarExamen(examen, this, medicos, consultorios, fecha);

	}

	//public ArrayList<Diagnostico> solicitarEnvioMedicamento (String direccion ){
	//	return Diagnostico.getListado();
	//}


}
