/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;
import java.time.LocalDateTime;
import java.util.ArrayList;

import gestorAplicacion.personas.*;
/**
 *
 * @author Roger Vera
 */
public class Cita extends Consulta{
	private static final long serialVersionUID = 1L;
    private String motivo;
    private tipoCita tiposCitas;
    int numeroCitas;
    
    public static ArrayList<Cita> listaCitas = new ArrayList<Cita>();
    
    //constructor

    public Cita(int id, Paciente paciente, String motivo, Medico medico, Consultorio consultorio, LocalDateTime fecha, Pago pago, tipoCita tiposCitas) {
        super(id, paciente, medico, consultorio, fecha, pago);
        this.motivo = motivo;
        this.tiposCitas = tiposCitas;
        numeroCitas++;
        listaCitas.add(this);
    }
    public Cita(Paciente paciente, String motivo, Medico medico, Consultorio consultorio, LocalDateTime fecha, Pago pago, tipoCita tiposCitas) {
    	super(paciente, medico, consultorio, fecha, pago);
    	this.motivo = motivo;
    	this.tiposCitas = tiposCitas;
    	listaCitas.add(this);
    }
    
    public Cita(int id, Paciente paciente, String motivo, Medico medico, Consultorio consultorio, LocalDateTime fecha, tipoCita tiposCitas) {
        super(id, paciente, medico, consultorio, fecha, null);
        this.motivo = motivo;
        this.tiposCitas = tiposCitas;
        numeroCitas++;
        listaCitas.add(this);
    }
    public Cita(Paciente paciente, String motivo, Medico medico, Consultorio consultorio, LocalDateTime fecha, tipoCita tiposCitas) {
    	super(paciente, medico, consultorio, fecha, null);
    	this.motivo = motivo;
    	this.tiposCitas = tiposCitas;
    	listaCitas.add(this);
    }
    
    public Cita(int id, Paciente paciente, String motivo, tipoCita tiposCitas) {
    	super(id, paciente, null, null, null, null);
    	this.motivo = motivo;
    	this.tiposCitas = tiposCitas;
    	listaCitas.add(this);
    }
    
    public Cita(Paciente paciente, String motivo, tipoCita tiposCitas) {
    	super(paciente, null, null, null, null);
    	this.motivo = motivo;
    	this.tiposCitas = tiposCitas;
    	listaCitas.add(this);
    }

    //getter & setter
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public tipoCita getTiposCitas() {
        return tiposCitas;
    }

    public void setTiposCitas(tipoCita tiposCitas) {
        this.tiposCitas = tiposCitas;
    }

    public int getNumeroCitas() {
        return numeroCitas;
    }

    public void setNumeroCitas(int numeroCitas) {
        this.numeroCitas = numeroCitas;
    }
    
    //metodos
    
    public static int totalCitasAgendadas(){
        return listaCitas.size();
    }
    
    public int numeroCitasAgendadas(){
        return numeroCitas;
    }
    public String datosCita() {
        return "Paciente: " + getPaciente() + "\nMotivo: " + getMotivo() + 
                "\nMedico: " + getMedico() + "\nConsultorio: " + getConsultorio() +
                "\nFecha: " + getFecha();
    }
    public static int informeCitas(tipoCita solicitado){// se ingresa el tipo de Cita y se busca en la lista cuantas hay
        int tcSolicitada=0;
        for (Cita tc : listaCitas) {
            if(tc.getTiposCitas()==solicitado){
                tcSolicitada++;
            }
        }
        return tcSolicitada;
    }
}
