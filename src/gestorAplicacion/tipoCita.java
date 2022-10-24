/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

/**
 *
 * @author Roger Vera
 */
public enum tipoCita {
    
    General(14700), 
    Prioritaria(14700), 
    Optometria(25000), 
    Audiometria(25000),
    Pediatria(25000),
    Laboratorio(25000);
    
    
    private int valorCita;
    //constructor
    private tipoCita(int precio){
        this.valorCita = precio;
    }
    //getter
    public int getValorCita(){
        return this.valorCita;
    }
}
