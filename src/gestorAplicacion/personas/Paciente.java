package gestorAplicacion.personas;
import gestorAplicacion.Cita;
import gestorAplicacion.Consulta;
import gestorAplicacion.Examen;
import gestorAplicacion.estadoEntrega;
import gestorAplicacion.tipoCita;
import gestorAplicacion.tipoExamen;
import gestorAplicacion.registrosMedicos.Diagnostico;
import gestorAplicacion.registrosMedicos.HistoriaClinica;
import gestorAplicacion.Consultorio;
import gestorAplicacion.Entrega;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;



public class Paciente extends Persona{
	private static final long serialVersionUID = 1L;
	private String eps;
	private ArrayList<String> sintomas;
	private HistoriaClinica historiaClinica;
	private Map<LocalDateTime, Consulta> consultas = new TreeMap<LocalDateTime, Consulta>();
	private Map<LocalDateTime, Entrega> entregas = new TreeMap<LocalDateTime, Entrega>();
	public boolean pagado;
    public static int pacientes;

	//Constructores
	public Paciente(String nombre, String apellido, tipoDocumento documento, long numeroDocumento, int edad, String genero, long telefono, String correoElectronico, String direccion, String eps, 
			ArrayList<String> sintomas, HistoriaClinica historiaClinica, boolean pagado) {
		super(nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion);
		setEps(eps);
		setSintomas(sintomas);
		setHistoriaClinica(historiaClinica);
		this.pagado = pagado;
                pacientes++;
		
	}
	
	public Paciente() {
		this(null,null, null, 0, 0, null, 0, null, null,null, new ArrayList<String>(), null, false);
	}

	//Getters y setters
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

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
		
	public Map<LocalDateTime, Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(Map<LocalDateTime, Entrega> entregas) {
		this.entregas = entregas;
	}

	//Metodos
	public String pedirCita(LocalDateTime fecha, tipoCita tipoCita, String motivo) {
		ArrayList<Medico> medicos = Medico.medicos;
		Medico medico = null;
		for (int i = 0; i<medicos.size(); i++){
			//Se recorre la lista de los medicos creados y se va verificando si la especialidad del medico i concuerda con el tipo de cita que
			//se requiere y tambien se verifica si ese medico esta disponible.
			if ( medicos.get(i).especialidad == tipoCita && Administrador.verificarDisponibilidadMedico(fecha, medicos.get(i)) == true) {
				medico = medicos.get(i);
				break;
			}
		}
		ArrayList<Consultorio> consultorios = Consultorio.consultorios;
		Consultorio consultorio = null;
		for (int i = 0; i< consultorios.size(); i++) {
			//Se recorre la lista de los consultorios creados y se verifica si el consultorio esta disponible en la fecha que se requiere la cita
			if(Administrador.verificarDisponibilidadConsultorio(fecha, consultorios.get(i)) == true){
				consultorio = consultorios.get(i);
				break;
			}
		}
		if (medico != null && consultorio != null) {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");  
			Administrador.asignarCita(this, medico, consultorio, fecha, motivo, tipoCita);
			return "Su cita ha sido agendada exitosamente el: " + fecha.format(formato) + " con el médico: "+ medico.getNombre()+" "+ medico.getApellido()+ " en el consultorio "+ consultorio.getId()+"\n";
		}
		else {
			return "Hubo un error agendando su cita, vuelvalo a intentar. \n";
		}
	}
	
	public boolean reagendarCita(LocalDateTime fecha) {
		Cita cita = null;
		ArrayList<Cita> citas = Cita.listaCitas;
		//Se busca la cita que se quiere reagendar
		for (int i = 0; i<citas.size(); i++) {
			if (citas.get(i).getPaciente() == this) {
				cita = citas.get(i);
				break;
			}
		}
		//Se verifica que tanto el medico como el consultorio esten disponible en la nueva fecha
		if(Administrador.verificarDisponibilidadMedico(fecha,cita.getMedico()) == true && Administrador.verificarDisponibilidadConsultorio(fecha, cita.getConsultorio())==true){
			cita.setFecha(fecha);
			return true;
		}
		else {
			return false;
		}
	}
	
	//En caso de que el medico no este disponible
	public boolean reagendarCitaMedico(LocalDateTime fecha) {
		Cita cita = null;
		ArrayList<Cita> citas = Cita.listaCitas;
		for (int i = 0; i<citas.size(); i++) {
			if (citas.get(i).getPaciente() == this) {
				cita = citas.get(i);
				break;
			}
		}
		//Se busca un medico con disponibilidad
		ArrayList<Medico> medicos = Medico.medicos;
		Medico medico = null;
		for(int i = 0; i<medicos.size(); i++) {
			if(medicos.get(i).especialidad ==  cita.getTiposCitas() && Administrador.verificarDisponibilidadMedico(fecha, medicos.get(i)) == true){
				medico = medicos.get(i);
				cita.setMedico(medico);
				cita.setFecha(fecha);
				break;
			}
			else if(Administrador.verificarDisponibilidadMedico(fecha, medicos.get(i)) == false && i== medicos.size()){
				return false;
			}
		}
		//Se verifica si el consultorio esta disponible para la nueva fecha
		if (Administrador.verificarDisponibilidadConsultorio(fecha, cita.getConsultorio())==true && medico != null) {
			return true;
		}
		//Si el consultorio no esta disponible, se busca un nuevo consultorio
		else {
			ArrayList<Consultorio> consultorios = Consultorio.consultorios;
			Consultorio consultorio = null;
			for (int i = 0; i< consultorios.size(); i++) {
				//Se recorre la lista de los consultorios creados y se verifica si el consultorio esta disponible en la fecha que se requiere la cita
				if(Administrador.verificarDisponibilidadConsultorio(fecha, consultorios.get(i)) == true){
					consultorio = consultorios.get(i);
					cita.setConsultorio(consultorio);
					break;
				}
			}
			return true;
		}
	}

	
	public String solicitarExamen(tipoExamen tipo, LocalDateTime fecha) {
		Examen examen = new Examen((int)(Math.random()*10000+1), this, tipo, false);
		Administrador.autorizarExamen(examen);
		// Filtrar médicos disponibles para la fecha
		// Filtrar consultorios disponibles para la fecha
		return Administrador.asignarExamen(examen, this, Medico.medicos, Consultorio.consultorios, fecha);
	}
	
	
//	public String cancelarCita(LocalDateTime fecha, tipoCita tipoCita) {
//		Cita cita = null;
//		ArrayList<Cita> citas = Cita.listaCitas;
//		//Se busca la cita que se quiere reagendar
//		for (int i = 0; i<citas.size(); i++) {
//			if (citas.get(i).getPaciente() == this && citas.get(i).getFecha() == fecha && citas.get(i).getTiposCitas() == tipoCita) {
//				cita = citas.get(i);
//				break;
//			}
//		}
//		cita.cia
//	}
	
	public HistoriaClinica consultarHistorioaClinica() {
		return getHistoriaClinica();
	}
//	public void solicitarExamen(tipoExamen tipo, LocalDateTime fecha) {
//		Examen examen = new Examen((int)(Math.random()*10000+1), this, tipo, false);
//		Administrador.autorizarExamen(examen);
//		// Filtrar médicos disponibles para la fecha
//		// Filtrar consultorios disponibles para la fecha
//		Administrador.asignarExamen(examen, this, medicos, consultorios, fecha);
//
//	}

	public static String solicitarEnvioMedicamento (String nombre, String domicilio){
		ArrayList<Diagnostico> lis = Medico.listado;
		int cont = 1;
		for (Diagnostico medi : lis) {
			if (medi.getPersona().getNombre().equals(nombre)){
				String option;
				if (medi.getPersona().pagado == true){
					Entrega.crearEntrega(cont, medi.getPersona().getNombre(),domicilio,medi.getMedicamiento(), estadoEntrega.En_camino);
					cont++;
					return "el proceso ha sido exitoso";
				}
				else{
					return ("Debes pagar la consulta antes de pedir los medicamentos");
				}
			}
		}
		return domicilio;
			
	}
}
