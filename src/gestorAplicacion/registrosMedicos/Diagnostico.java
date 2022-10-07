package registrosMedicos;
import java.util.ArrayList;

public class Diagnostico {
    private ArrayList<String> sintomas = new ArrayList<String>();
    private String observacion;
    private String medicamiento;
    private int id;
   
    public Diagnostico(ArrayList<String> sintomas, String observacion, String medicamiento, int id) {
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

    public String getMedicamiento() {
        return medicamiento;
    }

    public void setMedicamiento(String medicamiento) {
        this.medicamiento = medicamiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}

