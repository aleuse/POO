package gestorAplicacion.registrosMedicos;
import java.util.ArrayList;

import gestorAplicacion.Consulta;
import gestorAplicacion.Medicamentos;
import gestorAplicacion.personas.Paciente;

public class Diagnostico {
    private Paciente persona;
    public static  ArrayList<String> sintomas = new ArrayList<String>();
    private String observacion;
    public  Medicamentos medicamiento;
    private int id;
    public Consulta consulta;
   
    public Diagnostico(Paciente persona, ArrayList<String> sintomas, String observacion, Medicamentos medicamiento, int id,Consulta consulta) {
        this.persona = persona;
        this.sintomas = sintomas;
        this.observacion = observacion;
        this.medicamiento = medicamiento;
        this.id = id;
        this.consulta = consulta;
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

    public Medicamentos getMedicamiento() {
        return medicamiento;
    }


    public void setMedicamiento(Medicamentos medicamiento) {
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

