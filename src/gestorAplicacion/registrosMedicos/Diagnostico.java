package gestorAplicacion.registrosMedicos;
import java.util.ArrayList;

import gestorAplicacion.Consulta;
import gestorAplicacion.Medicamentos;
import gestorAplicacion.personas.Paciente;

public class Diagnostico {
    private Paciente persona;
    public  ArrayList<String> sintomas;
    private String observacion;
    public  ArrayList<Medicamentos> medicamiento = new ArrayList<Medicamentos>();
    private int id;
    public Consulta consulta;
   
    public Diagnostico(Paciente persona, ArrayList<String> sintomas, String observacion, ArrayList<Medicamentos> medicamiento, int id) {
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

    


    public ArrayList<Medicamentos> getMedicamiento() {
        return medicamiento;
    }


    public void setMedicamiento(ArrayList<Medicamentos> medicamiento) {
        this.medicamiento = medicamiento;
    }


    public Paciente getPersona() {
        return persona;
    }


    public void setPersona(Paciente persona) {
        this.persona = persona;
    }


    public Consulta getConsulta() {
        return consulta;
    }


    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

}

