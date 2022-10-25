/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

/**
 *
 * @author Roger Vera
 */
//tipoMedicamento representa las clases de medicamentos que pueden a ver con su respectivo precio
public enum tipoMedicamento {
    Acetaminofen(140),Amoxicilina(250),Ibuprofeno(190),LagrimasArtificiales(8000);   
    //Acetaminofen,Amoxicilina,Ibuprofeno venta por unidad
    //LagrimasArtificiales venta por frasco
    
    private int valorMed;
    //constructor
    private tipoMedicamento(int precio){
        this.valorMed = precio;
    }
    //getter
    public int getValorMed(){
        return this.valorMed;
    }
    
}

