package gestorAplicacion.registrosMedicos;
import java.util.ArrayList;
import gestorAplicacion.personas.Paciente;

public class Diagnostico {
    private Paciente persona;
    private ArrayList<String> sintomas;
    private String observacion;
    private ArrayList<String> medicamiento = new ArrayList<String>();
    private int id;
   
    public Diagnostico(Paciente persona, ArrayList<String> sintomas, String observacion, ArrayList<String> medicamiento, int id) {
        this.persona = persona;
        this.sintomas = sintomas;
        this.observacion = observacion;
        this.medicamiento = medicamiento;
        this.id = id;
    }
    

    public ArrayList<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<String> sintomas) {
        this.sintomas = sintomas;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getMedicamiento() {
        return medicamiento;
    }

    public void setMedicamiento(ArrayList<String> medicamiento) {
        this.medicamiento = medicamiento;
    }


    public Paciente getPersona() {
        return persona;
    }


    public void setPersona(Paciente persona) {
        this.persona = persona;
    }

}

