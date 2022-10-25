/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion.personas;

import gestorAplicacion.tipoCita;
import gestorAplicacion.tipoExamen;

/**
 *
 * @author Roger Vera
 */
public enum tipoMedico {//casteamos costos
    
    
    //FALTA MULTIPLICAR POR EL NUMERO DE CONSULTAS QUE REALIZÓ
    // VALOR_CITA_X * CANTIDAD_CITAS_X * PORCENTAJE
    
    //el medico general atiende general,prioritaria y rayos x
    // el bacteriologo atiende Sangre,Laboratorio y Citoquimico
    
    GENERAL      (((int) (tipoCita.GENERAL.getValorCita()*0.5))+
                  ((int) (tipoExamen.RAYOSX.getValorExamen()*0.5))+
                  ((int) (tipoCita.PRIORITARIA.getValorCita()*0.5))),
    //Prioritario ((int) (tipoCita.Prioritaria.getValorCita()*0.5)),
    
    OPTOMETRIA    ((int) (tipoCita.OPTOMETRIA.getValorCita()*0.6)),
    FONOAUDIOLOGO((int) (tipoCita.AUDIOMETRIA.getValorCita()*0.6)),
    PEDIATRA     ((int) (tipoCita.PEDIATRIA.getValorCita()*0.7)), 

    BACTERIOLOGO (((int)(tipoExamen.SANGRE.getValorExamen()*0.7)+
                 ((int)(tipoExamen.LABORATORIO.getValorExamen()*0.7)+
                 ((int)(tipoExamen.CITOQUIMICO.getValorExamen()*0.7)))));
    
    private int ComisionMed;
    //constructor
    private tipoMedico(int precio){
        this.ComisionMed = precio;
    }
    //getter
    public int getComisionMed(){
        return this.ComisionMed;
    }
}
