/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package registrosMedicos;
import java.util.ArrayList;
/**
 *
 * @author Roger Vera
 */
public class Cita extends Consulta{
    
    private int id;
    private Paciente paciente;
    private String motivo;
    private Medico medico;
    private Consultorio consultorio;
    private String fecha;
    private tipoCita tiposCitas;
    int numeroCitas;
    
    private static ArrayList<Cita> listaCitas = new ArrayList<Cita>();
    
    //constructor

    public Cita(int id, Paciente paciente, String motivo, Medico medico, Consultorio consultorio, String fecha, tipoCita tiposCitas) {
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

    //getter & setter
    
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

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
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
