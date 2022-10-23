package gestorAplicacion.personas;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import gestorAplicacion.registrosMedicos.*;
//import gestorAplicacion.Cita;
import gestorAplicacion.Consulta;
import gestorAplicacion.Consultorio;
import gestorAplicacion.Medicamentos;
import gestorAplicacion.Pago;
import gestorAplicacion.tipoCita;

public class Medico extends Persona{
	private static final long serialVersionUID = 1L;
    public static ArrayList<Diagnostico> listado = new ArrayList<Diagnostico>();
    public tipoCita especialidad;
    public tipoMedico especialista;
    private boolean disponibilidad;
    public Map<LocalDateTime, Consulta> consultas = new TreeMap<LocalDateTime, Consulta>();
    public static ArrayList<Medico> medicos = new ArrayList<Medico>();
    public static ArrayList<Consulta> listado_consulta = new ArrayList<Consulta>(); //crea la consulta
    public Map<LocalDateTime, Pago> nomina = new TreeMap<LocalDateTime, Pago>();
    private long sueldo;
    public  ArrayList<Medicamentos> medicamiento = new ArrayList<Medicamentos>();

    
    //constructor

    public Medico(String nombre, String apellido, tipoDocumento documento, long numeroDocumento, int edad,
            String genero, long telefono, String correoElectronico, String direccion, tipoCita especialidad,
            tipoMedico especialista, boolean disponibilidad, Map<LocalDateTime, Consulta> consultas,
            Map<LocalDateTime, Pago> nomina, long sueldo, ArrayList<Medicamentos> medicamiento) {
        super(nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion);
        this.especialidad = especialidad;
        this.especialista = especialista;
        this.disponibilidad = disponibilidad;
        this.consultas = consultas;
        medicos.add(this);
        this.nomina = nomina;
        this.sueldo = sueldo;
        this.medicamiento = medicamiento;

    }
   
    public Medico(tipoCita especialidad, tipoMedico especialista, boolean disponibilidad,
            Map<LocalDateTime, Consulta> consultas) {
        this.especialidad = especialidad;
        this.especialista = especialista;
        this.disponibilidad = disponibilidad;
        this.consultas = consultas;
        medicos.add(this);
    }

    public Medico(String nombre, String apellido, tipoDocumento documento, int numeroDocumento, int edad, String genero, int telefono,
			String correoElectronico, String direccion, tipoCita especialidad, tipoMedico especialista, boolean disponibilidad) {
    	super(nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion);
    	this.especialidad = especialidad;
        this.especialista = especialista;
        this.disponibilidad = disponibilidad;
        medicos.add(this);
    	
    }
    	

    public Medico(tipoCita especialidad, tipoMedico especialista, boolean disponibilidad,
            Map<LocalDateTime, Consulta> consultas, Map<LocalDateTime, Pago> nomina, long sueldo,
            ArrayList<Medicamentos> medicamiento) {
        this.especialidad = especialidad;
        this.especialista = especialista;
        this.disponibilidad = disponibilidad;
        this.consultas = consultas;
        this.nomina = nomina;
        this.sueldo = sueldo;
        this.medicamiento = medicamiento;
        medicos.add(this);
    }

    public Medico(){super();};

    
		// TODO Auto-generated constructor stub
	

	public Medico(String nombre, String apellido, tipoDocumento documento, long numeroDocumento , int edad, String genero, long telefono,
			String correoElectronico, String direccion, tipoCita especialidad, boolean disponibilidad) {
		 super(nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion);
	        this.especialidad = especialidad;
	        this.disponibilidad = disponibilidad;
	        medicos.add(this);
	}

	//getter & setter
    public long getSueldo() {
        return sueldo;
    }
    public void setSueldo(long sueldo) {
        this.sueldo = sueldo;
    }

    public Map<LocalDateTime, Pago> getNomina() {
        return nomina;
    }

    public void setNomina(Map<LocalDateTime, Pago> nomina) {
        this.nomina = nomina;
    }

    public tipoCita getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(tipoCita especialidad) {
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

    public tipoMedico getEspecialista() {
        return especialista;
    }

    public void setEspecialista(tipoMedico especialista) {
        this.especialista = especialista;
    }
    
    
    
    //metodos
    public void crearDiagnostico(Paciente persona, ArrayList<String> sintomas, String observacion, Medicamentos medicamiento, int id, Consulta consulta){
        Diagnostico diag = new Diagnostico (persona, sintomas, observacion, medicamiento, id, consulta);
        listado.add(diag);
    }
    public static int informesMedicos(tipoMedico solicitado) {// se ingresa el tipo de examen y se busca en la lista cuantos hay
        int tmSolicitado = 0;
        for (Medico tm : medicos) {
            if (tm.getEspecialista() == solicitado) {
                tmSolicitado++;
            }
        }
        return tmSolicitado;
    }


}
