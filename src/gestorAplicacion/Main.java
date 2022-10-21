/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;
import gestorAplicacion.*;
import gestorAplicacion.personas.Medico;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.personas.tipoDocumento;
import gestorAplicacion.registrosMedicos.Diagnostico;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Roger Vera
 */
public class Main {
    static Scanner input = new Scanner(System.in);
    static int opcion;
    
    
    public static void Menu() {
             
        System.out.println("                  (0 0)           ");
        System.out.println("          ---oOO-- (_) ----oOO---        ");
        System.out.println("  ╔════════════════════════════════════════╗   ");
        System.out.println("  ║ Bienveniedo al Sistema Medico! ♥       ║   ");
        System.out.println("  ╚════════════════════════════════════════╝   ");
        System.out.println("           -------------------           ");
        System.out.println("                 |__|__|       ");
        System.out.println("                  || ||   ");
        System.out.println("                 ooO Ooo");
        
        System.out.println("Bienveniedo al Sistema Medico");
        System.out.println("Elija la opcion que desea realizar");
        System.out.println("1. Pedir Cita");
        System.out.println("2. Solicitar Examen");
        System.out.println("3. Solicitar Envio de Medicamentos");
        System.out.println("4. Pagar Consulta");
        System.out.println("5. Opciones de administrador");
        System.out.println("0. Terminar");
        
        do{System.out.print("Ingrese una opcion valida: ");
            opcion=input.nextInt();
        } while (opcion<0 || opcion>5);
        
        switch (opcion) {
            case 1:               
                System.out.println(" elegiste  opcion 1");
                break;
            case 2:
                System.out.println(" elegiste  opcion 2");
                break;
            case 3:
                Scanner input= new Scanner(System.in);
                System.out.println(" elegiste  opcion 3");
                System.out.println("Ingrese el nombre del paciente Prueba: ");
		        String nombre = input.nextLine();
                ArrayList<Diagnostico> lis = Medico.listado;
                //System.out.println(Medico.listado.size());
                int cont = 1;
                for (Diagnostico medi : lis) {
                    if (medi.getPersona().getNombre().equals(nombre)){
                        String option;
                        while (true) {
                            System.out.println("¿Deseas confirmar el envio de medicamentos?");
                            System.out.println("1. Si");
                            System.out.println("2. No");
                            option = input.next();
                            if (option.equals("1")) {
                                if (medi.getPersona().pagado == true){
                                    System.out.println("Por Favor ingrese su direccion de domicilio: ");
                                    String domicilio = input.nextLine();
                                    Paciente.solicitarEnvioMedicamento(nombre , domicilio);
                                }
                            }
                            else if (option.equals("2")) {
                                break;
                            }
                        }
                    }else{
                        System.out.println("El nombre no se encuentra en la base de datos");
                    }
                

                }
                break;
            case 4:
                System.out.println(" elegiste  opcion 4");
                break;
            case 5:
                System.out.println(" elegiste  opcion 5");
                break;
            case 0:
                System.out.println(" elegiste  opcion 0. salida del sistema");
                break;
        }
    }

    
    public static void main(String[] args){
        Menu();
    }
}