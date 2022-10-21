/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

/**
 *
 * @author Roger Vera
 */
public enum tipoExamen {
    Sangre(12000),Laboratorio(14000),RayosX(40000),Citoquimico(12000);    
    
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
