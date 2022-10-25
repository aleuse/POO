/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

/**
 *
 * @author Roger Vera
 */
//TipoExamen representa las clases de examenes que pueden a ver
public enum tipoExamen {
    SANGRE(12000),LABORATORIO(14000),RAYOSX(40000),CITOQUIMICO(12000);    
    
    private int valorExamen;
    //constructor
    private tipoExamen(int precio){
        this.valorExamen = precio;
    }
    //getter
    public int getValorExamen(){
        return this.valorExamen;
    }
}
