/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;

import gestorAplicacion.personas.*;

/**
 *
 * @author Roger Vera
 */
public class Consultorio {
    
    private Medico medico;
    private Paciente paciente;
    private String tipoConsultorio;
    private final int id;
    private Map<LocalDateTime, Consulta> consultas = new TreeMap<LocalDateTime, Consulta>();
    
    //constructor

    public Consultorio(Medico medico, Paciente paciente, String tipoConsultorio, Boolean disponibilidad) {
        this.medico = medico;
        this.paciente = paciente;
        this.tipoConsultorio = tipoConsultorio;
        this.disponibilidad = disponibilidad;
        this.id = (int)(Math.random()*10000+1);
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


	public int getId() {
		return id;
	}


	public Map<LocalDateTime, Consulta> getConsultas() {
		return consultas;
	}


	public void setConsultas(Map<LocalDateTime, Consulta> consultas) {
		this.consultas = consultas;
	}
   
    //metodos
    
    
    
}
