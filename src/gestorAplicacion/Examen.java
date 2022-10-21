/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

import java.time.LocalDateTime;

import gestorAplicacion.personas.Medico;
import gestorAplicacion.personas.Paciente;
import java.util.ArrayList;

/**
 *
 * @author Roger Vera
 */
public class Examen extends Consulta {
	private static final long serialVersionUID = 1L;
    private tipoExamen tipo;
    private boolean autorizado;
    public static ArrayList<Examen> listaExamenes=new ArrayList<Examen>();
    
    // Constructor
    public Examen(int id, Paciente paciente, tipoExamen tipo, boolean autorizado) {
    	super(id, paciente, null, null, null, null);
    	this.tipo = tipo;
    	this.autorizado = autorizado;
    	listaExamenes.add(this);
    }
    
    public Examen(Paciente paciente, tipoExamen tipo, boolean autorizado) {
    	super(paciente, null, null, null, null);
    	this.tipo = tipo;
    	this.autorizado = autorizado;
    	listaExamenes.add(this);
    }
    
    public Examen(int id, Paciente paciente, Medico medico, Consultorio consultorio, LocalDateTime fecha, 
    		Pago pago, tipoExamen tipo, boolean autorizado) {
    	super(id, paciente, medico, consultorio, fecha, pago);
    	this.tipo = tipo;
    	this.autorizado = autorizado;
        listaExamenes.add(this);
    }
    
    public Examen(Paciente paciente, Medico medico, Consultorio consultorio, LocalDateTime fecha, 
    		Pago pago, tipoExamen tipo, boolean autorizado) {
    	super(paciente, medico, consultorio, fecha, pago);
    	this.tipo = tipo;
    	this.autorizado = autorizado;
        listaExamenes.add(this);
    }
    
    
    
    // Getters y Setters
    public tipoExamen getTipo() {
        return tipo;
    }

    public void setTipo(tipoExamen tipo) {
        this.tipo = tipo;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    public void setAutorizado(boolean autorizado) {
        this.autorizado = autorizado;
    }

    //metodo
    public static int informeExamenes(tipoExamen solicitado) {// se ingresa el tipo de examen y se busca en la lista cuantos hay
        int teSolicitado = 0;
        for (Examen te : listaExamenes) {
            if (te.getTipo() == solicitado) {
                teSolicitado++;
            }
        }
        return teSolicitado;
    }
}
