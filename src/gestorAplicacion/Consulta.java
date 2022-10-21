/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

import gestorAplicacion.personas.*;
import java.time.*;

/**
 *
 * @author Roger Vera
 */
public abstract class Consulta {
    protected int id;
    protected Paciente paciente;
    protected Medico medico;
    protected Consultorio consultorio;
    protected LocalDateTime fecha;
    protected Pago pago;
    
    public Consulta(int id, Paciente paciente, Medico medico, Consultorio consultorio, LocalDateTime fecha, Pago pago) {
    	this.id= id;
    	this.paciente = paciente;
    	this.medico = medico;
    	this.consultorio = consultorio;
    	this.fecha = fecha;
    	this.pago = pago;
    }
    
    public Consulta(Paciente paciente, Medico medico, Consultorio consultorio, LocalDateTime fecha, Pago pago) {
    	this.id= (int)(Math.random()*10000+1);
    	this.paciente = paciente;
    	this.medico = medico;
    	this.consultorio = consultorio;
    	this.fecha = fecha;
    	this.pago = pago;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Consultorio getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(Consultorio consultorio) {
        this.consultorio = consultorio;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
    
    public Pago getPago() {
    	return pago;
    }
    
    public void setPago(Pago pago) {
    	this.pago = pago;
    }
}
