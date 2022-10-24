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
    //el medico general atiende general,prioritaria y rayos x
    // el bacteriologo atiende Sangre,Laboratorio y Citoquimico
    General      (((int) (tipoCita.General.getValorCita()*0.5))+
                  ((int) (tipoExamen.RayosX.getValorExamen()*0.5))+
                  ((int) (tipoCita.Prioritaria.getValorCita()*0.5))),
    //Prioritario ((int) (tipoCita.Prioritaria.getValorCita()*0.5)),
    
    Optometra    ((int) (tipoCita.Optometria.getValorCita()*0.6)),
    Fonoaudiologo((int) (tipoCita.Audiometria.getValorCita()*0.6)),
    Pediatra     ((int) (tipoCita.Pediatria.getValorCita()*0.7)), 

    Bacteriologo (((int)(tipoExamen.Sangre.getValorExamen()*0.7)+
                 ((int)(tipoExamen.Laboratorio.getValorExamen()*0.7)+
                 ((int)(tipoExamen.Citoquimico.getValorExamen()*0.7)))));
    
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
