package gestorAplicacion.registrosMedicos;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.personas.VisualizacionDatos;

import java.util.ArrayList;

/* La clase Diagnostico tiene como atributos a paciente, un arrayList de diagnostio y otro arraylist de historia al icual que pacEncontrado que
hace referencia a paciente encontrado. En esta clase se crean los constructores y tambien los getters y setters correspondientes. (La clase no 
tiene metodos) */
public class HistoriaClinica implements VisualizacionDatos{
    private Paciente paciente;
    public static ArrayList<Diagnostico> diagnosticos;
    public static ArrayList<HistoriaClinica> historia= new ArrayList<HistoriaClinica>();
    static HistoriaClinica pacEncontrado;
    
    //constructor
    public HistoriaClinica(Paciente paciente, ArrayList<Diagnostico> diagnosticos) {
        this.paciente = paciente;
        HistoriaClinica.diagnosticos = diagnosticos;
    }
    public HistoriaClinica(){}

    //getter & setter
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public ArrayList<Diagnostico> getDiagnosticos() {
        return diagnosticos;
    }

    public void setDiagnosticos(ArrayList<Diagnostico> diagnosticos) {
        HistoriaClinica.diagnosticos = diagnosticos;
    }
    public static HistoriaClinica getPacEncontrado() {
        return pacEncontrado;
    }
    
    //METODOS

    public String visualizarDiagnostico(Diagnostico diagnosticos, int id) {
        return "El diagnostico es "+ diagnosticos + "El id del diagnostico es "+id;

    }
    public void crearHistoriaClinica(Paciente paciente, ArrayList<Diagnostico> diagnosticos){
        HistoriaClinica historia1 = new HistoriaClinica(paciente, diagnosticos);
        historia.add(historia1);
    }
    
    
    public static int buscarPaciente(int solicitado){// se ingresa el num de la cc y se busca en la lista cuantas hay
        for (HistoriaClinica ee : historia) {
            if(ee.getPaciente().getNumeroDocumento()==solicitado){
                pacEncontrado= ee.getPaciente().consultarHistorioaClinica();
                return 1;
            }
        }
        return 0;
    }
    
 
	@Override
	public String visualizarDatos() {
		return getPaciente().visualizarDatos() ;
	}
    
}
