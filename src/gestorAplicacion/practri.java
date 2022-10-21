/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

import gestorAplicacion.personas.tipoMedico;

/**
 *
 * @author Roger Vera
 */
public class practri {
    
    
    // CLASE SOLO PARA SABER COMO ACCEDER AL PRECIO DE:
    //LOS MEDICOS, DE LAS CITAS,DE LOS EXAMENES, DE LOS MEDICAMENTOS
    //ELIMINAR DESPUES
    static private tipoMedicamento tipoMed;
    public static void main(String args[])
    {
        int a=tipoMed.Ibuprofeno.getValorMed();
        System.out.println("precio Ibuprofeno : "+a );
        
        int b = tipoExamen.Citoquimico.getValorExamen();
        System.out.println("costo examen Citoquimico : "+b );
        
        int c = tipoCita.Optometria.getValorCita();
        System.out.println("precio cita optometria : "+c );
        
        int d = tipoMedico.Fonoaudiologo.getComisionMed();
        System.out.println("precio especialista Fonoaudiologo : "+d );
        
    }
}
    

