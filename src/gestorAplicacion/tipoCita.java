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
    
    GENERAL(14700), PRIORITARIA(14700), OPTOMETRIA(25000), AUDIOMETRIA(25000),PEDIATRA(25000),LABORATORIO(25000);
    
    
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
