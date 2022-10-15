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
    
    private String motivo;
    private tipoCita tiposCitas;
    int numeroCitas;
    
    public static ArrayList<Cita> listaCitas = new ArrayList<Cita>();
    
    //constructor

    public Cita(int id, Paciente paciente, String motivo, Medico medico, Consultorio consultorio, LocalDateTime fecha, tipoCita tiposCitas) {
        this.id = id;
        this.paciente = paciente;
        this.motivo = motivo;
        this.medico = medico;
        this.consultorio = consultorio;
        this.fecha = fecha;
        this.tiposCitas = tiposCitas;
        numeroCitas++;
        listaCitas.add(this);
    }
    public Cita(Paciente paciente, String motivo, Medico medico, Consultorio consultorio, LocalDateTime fecha, tipoCita tipoCita) {
    	this((int)(Math.random()*10000+1),paciente, motivo, medico, consultorio, fecha, tipoCita);
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
}
