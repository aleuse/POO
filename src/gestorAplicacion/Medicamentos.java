/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;
import gestorAplicacion.personas.Paciente;
import java.util.ArrayList;
/**
 *
 * @author Roger Vera
 */
public class Medicamentos {
    private tipoMedicamento tipoMed;
    private Paciente paciente;
    private int dosis;//cantidad a consumir
    private int modoUso;//consumir cada x horas
    private ArrayList<Medicamentos> medicamiento = new ArrayList<>();
    
    public static int cantAcetaminofen=100;
    public static int cantAmoxicilina=100;
    public static int cantIbuprofeno=100;
    public static int cantLagrimasArtificiales=20;
    
    //constructor
    public Medicamentos(tipoMedicamento tipoMed, Paciente paciente, int dosis, int modoUso) {
        this.tipoMed = tipoMed;
        this.paciente = paciente;
        this.dosis = dosis;
        this.modoUso = modoUso;
        medicamiento.add(this);
    }
    
        
    
    //getter & setter
    public tipoMedicamento getTipoMed() {
        return tipoMed;
    }
    public void setTipoMed(tipoMedicamento tipoMed) {
        this.tipoMed = tipoMed;
    }
    
    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public int getDosis() {
        return dosis;
    }
    public void setDosis(int dosis) {
        this.dosis = dosis;
    }

    public int getModoUso() {
        return modoUso;
    }
    public void setModoUso(int modoUso) {
        this.modoUso = modoUso;
    }

    public ArrayList<Medicamentos> getMedicamiento() {
        return medicamiento;
    }

    public void setMedicamiento(ArrayList<Medicamentos> medicamiento) {
        this.medicamiento = medicamiento;
    }
    
    //metodos
    
    //resta la cantidad de medicamento asignado del inventario de medicamentos
    public static void asignarMed(tipoMedicamento eleccion,int cantidad){
        switch (eleccion) {
            case Acetaminofen:
                cantAcetaminofen=cantAcetaminofen-cantidad;
                break;
            case Amoxicilina:
                cantAmoxicilina=cantAmoxicilina-cantidad;
                break;
            case Ibuprofeno:
                cantIbuprofeno=cantIbuprofeno-cantidad;
                break;
            default:
                cantLagrimasArtificiales=cantLagrimasArtificiales-cantidad;
                break;
        }        
    }

}
