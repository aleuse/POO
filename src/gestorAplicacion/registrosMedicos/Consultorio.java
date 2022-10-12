/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrosMedicos;

/**
 *
 * @author Roger Vera
 */
public class Consultorio {
    
    private Medico medico;
    private Paciente paciente;
    private String tipoConsultorio;
    private Boolean disponibilidad;
    private final int id;
    
    //constructor

    public Consultorio(Medico medico, Paciente paciente, String tipoConsultorio, Boolean disponibilidad, int id) {
        this.medico = medico;
        this.paciente = paciente;
        this.tipoConsultorio = tipoConsultorio;
        this.disponibilidad = disponibilidad;
        this.id = id;
    }
       
    
    //getter & setter     
        
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getTipoConsultorio() {
        return tipoConsultorio;
    }

    public void setTipoConsultorio(String tipoConsultorio) {
        this.tipoConsultorio = tipoConsultorio;
    }

    public Boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
   
    //metodos
    
    
    
}
