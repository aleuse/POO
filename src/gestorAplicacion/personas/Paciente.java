package gestorAplicacion.personas;
import gestorAplicacion.Cita;
import gestorAplicacion.registrosMedicos.HistoriaClinica;

import java.util.ArrayList;
import java.util.Map;



public class Paciente extends Persona{
	private String eps;
	private ArrayList<String> sintomas;
	private HistoriaClinica historiaClinica;
	private ArrayList<Cita> citas;
	
	public Paciente(String nombre, String apellido, tipoDocumento documento, long numeroDocumento, int edad, String genero, long telefono, String correoElectronico, String direccion, String eps, 
			ArrayList<String> sintomas, HistoriaClinica historiaClinica, ArrayList<Cita> citas) {
		super(nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion);
		setEps(eps);
		setSintomas(sintomas);
		setHistoriaClinica(historiaClinica);
		setCitas(citas);
		
	}
	
	public Paciente() {
		this(null,null, null, 0, 0, null, 0, null, null,null, new ArrayList<String>(), null, new ArrayList<Cita>());
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

	public ArrayList<Cita> getCitas() {
		return citas;
	}
	public void setCitas(ArrayList<Cita> citas) {
		this.citas = citas;
	}
	
//	public Boolean piderCita(String fecha, tipoCita tipoCita) {
//	
//	}
	
//	public void actualizarDatos(Map <Object, String> datos) {
//		for (int i = 0; i< datos.size(); i++) {
//
//		}
//	}
	
	
}
