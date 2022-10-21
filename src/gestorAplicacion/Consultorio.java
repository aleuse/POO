/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import java.util.ArrayList;

import gestorAplicacion.personas.*;

/**
 *
 * @author Roger Vera
 */
public class Consultorio implements Serializable{
	private static final long serialVersionUID = 1L;
    private Medico medico;
    private Paciente paciente;
    private String tipoConsultorio;
    private final int id;
    private boolean disponibilidad;
    public Map<LocalDateTime, Consulta> consultas = new TreeMap<LocalDateTime, Consulta>();
    public static ArrayList<Consultorio> consultorios = new ArrayList<Consultorio>();
    
    //constructor

    public Consultorio(Medico medico, Paciente paciente, String tipoConsultorio, boolean disponibilidad, LocalDateTime fecha, Consulta consulta) {
        this.medico = medico;
        this.paciente = paciente;
        this.tipoConsultorio = tipoConsultorio;
        this.id = (int)(Math.random()*10000+1);
        this.disponibilidad = disponibilidad;
        consultorios.add(this);
        consultas.put(fecha, consulta);
    }
       
  
        
    public Consultorio(Medico medico, Paciente paciente, String tipoConsultorio, boolean disponibilidad) {
    	this.medico = medico;
        this.paciente = paciente;
        this.tipoConsultorio = tipoConsultorio;
        this.disponibilidad = disponibilidad;
    	this.id = (int)(Math.random()*10000+1);
    	consultorios.add(this);
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

	public int getId() {
		return id;
	}


	public Map<LocalDateTime, Consulta> getConsultas() {
		return consultas;
	}


	public void setConsultas(Map<LocalDateTime, Consulta> consultas) {
		this.consultas = consultas;
	}


	public boolean isDisponibilidad() {
		return disponibilidad;
	}


	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
   
    //metodos
    
    
    
}
