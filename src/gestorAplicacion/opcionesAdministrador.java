/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

import java.util.Scanner;

/**
 *
 * @author Roger Vera
 */

public class opcionesAdministrador {
    static Scanner dato = new Scanner(System.in);
    static int opcion;
    static void opcionesAdministrador(){
        
        System.out.println("Datos del sistema"); 
        System.out.println("Se tiene un total de "+ "y" + " medicos y "+ "z" + " consultorios");
        System.out.println("Se han atendido a "+ "x" + " pacientes");
        System.out.println("Y se ha facturado hasta ahora "+ "$" + " pesos");
        System.out.println("--------------------------------------");
        
        System.out.println("Desea visualizar las citas, examanes y entregas realizadas? [1]si  [0]no");
        do{System.out.print("Ingrese una opcion valida: ");
            opcion=dato.nextInt();
        } while (opcion!=1 & opcion!=0);
        if(opcion==1){
        /*
            System.out.println("Citas realizadas");
            System.out.println("General: "+ "f" + " citas recaudando" + "$" + " pesos");
            System.out.println("Prioritaria: "+ "f" + " citas recaudando" + "$" + " pesos");
            System.out.println("Optometria: "+ "f" + " citas recaudando" + "$" + " pesos");
            System.out.println("Audiometria: "+ "f" + " citas recaudando" + "$" + " pesos");
            System.out.println("Pediatria: "+ "f" + " citas recaudando" + "$" + " pesos");

            System.out.println("--------------------------------------");

            System.out.println("Examenes realizados");
            System.out.println("Sangre: "+ "f" + " citas recaudando" + "$" + " pesos");
            System.out.println("Laboratorio: "+ "f" + " citas recaudando" + "$" + " pesos");
            System.out.println("Rayos X: "+ "f" + " citas recaudando" + "$" + " pesos");
            System.out.println("Citoquímico: "+ "f" + " citas recaudando" + "$" + " pesos");

            System.out.println("--------------------------------------");

            System.out.println("Estado de la entrega");
            System.out.println("Procesada: "+ "f" + " entregas recaudando" + "$" + " pesos");
            System.out.println("En camino: "+ "f" + " entregas recaudando" + "$" + " pesos");
            System.out.println("Realizada: "+ "f" + " entregas recaudando" + "$" + " pesos");      
            */
        }
        System.out.println("--------------------------------------");
        System.out.println("Se tiene un total de "+"x"+" historias clinicas");
        System.out.println("Desea buscar la historia clinica de un paciente? [1]si  [0]no");
        do{System.out.print("Ingrese una opcion valida: ");
            opcion=dato.nextInt();
        } while (opcion!=1 & opcion!=0);
        if(opcion==1){
            int cc;
            do{
                System.out.print("Ingrese numero de intedificacion: ");
                cc=dato.nextInt();
                
                int pacientePedido=-1;//borrar linea
                //HistoriaClinica pacientePedido=NULL;//debe estar vacio
                /*un for que recorra la lista de historias clinica y compare con las cc y devuelva la coincidencia
                for (HistoriaClinica HC : listado.get(0)) {
                    if (cc== HC.cedula()) {
                    pacientePedido = HC;
                */
                if(pacientePedido==-1){//cambiar -1 por vacio
                    System.out.println("Paciente no encontrado");
                    System.out.println("¿Desea volver a buscar paciente? [1]si  [0]no");
                    cc=dato.nextInt();

                }else{
                    System.out.println("paciente encontrado");
                    //devolver datos del paciente
                    cc=0;
                }
            }while(cc!=0);

        }
        
        do{
            System.out.println("--------------------------------------");
            System.out.println("Con el dinero obtenido hasta ahora "+ "x" + " $ se puede:");
            System.out.println("1. Contratar más medicos");
            System.out.println("2. Adquirir más consultorios");
            System.out.println("3. Comprar más medicamentos");
            System.out.println("0. No utilizar el dinero");
            System.out.println("¿Que desea hacer?");
        
            do{System.out.print("Ingrese una opcion valida: ");
                opcion=dato.nextInt();
            }while (opcion!=1 & opcion!=2 & opcion!=3 & opcion!=0);
            
            switch (opcion){
                case 1:
                    System.out.println("Se tiene un total de "+ "y" + " medicos");
                    System.out.println("¿Cuantos médicos desea contratar?");
                    System.out.print("Ingrese un numero: ");
                    int nuevosMedicos=dato.nextInt();
                    int mn=0;
                    for(int i=0;i<nuevosMedicos;i++){
                        double x = Math.random();
                        if(x>0.3){
                            mn++;
                            //crear nuevo medico
                            //añadir medico a la lista de medicos
                        }
                    }
                    if(mn>0){System.out.println("Se han podido contratar "+mn+" medicos");
                    System.out.println("Ahora hay"+ "nuevoy" + " medicos");}
                    else{System.out.println("No se han podido adquirir nuevos medicos");}
                    break;
                case 2: 
                    System.out.println("Se tiene un total de "+ "z" + " consultorios");
                    System.out.println("Cada consultorio tiene un precio de "+ "x"+ " pesos");
                    System.out.println("¿Cuantos consultorios desea contratar?");
                    System.out.print("Ingrese un numero: ");
                    int nuevosConsultorios=dato.nextInt();
                    int cn=0;
                    for(int i=0;i<nuevosConsultorios;i++){
                        double x = Math.random();
                        if(x>0.7){cn++;}
                    }
                    //restar totalDinero-(cn*precioConsultorio)
                    if(cn>0){System.out.println("Se han podido adquirir "+cn+" consultorios");
                    System.out.println("Ahora hay "+ "nuevoz" + " consultorios");}
                    else{System.out.println("No se han podido adquirir nuevos consultorios");}
                    break;
                case 3:
                    // no hay cantidad fija de medicamentos, sino un array


                    break;
            }
        }while(opcion!=0);
        /*
        MEJORAR:
        - tipos de medicamentos con valores fijos
        - asignar los tipos de cita y examen, consultorios para cada caso
        - no se especifica la cantidad de aparatos que hay 
        */
        
        System.out.println();
        System.out.println("________00000000000___________000000000000_________");
        System.out.println("______00000000_____00000___000000_____0000000______");
        System.out.println("____0000000_____________000______________00000_____");
        System.out.println("___0000000_______________0_________________0000____");
        System.out.println("__000000____________________________________0000___");
        System.out.println("__00000_____________________________________ 0000__");
        System.out.println("_00000______________________________________00000__");
        System.out.println("_00000_____________________________________000000__");
        System.out.println("__000000_________________________________0000000___");
        System.out.println("___0000000______________________________0000000____");
        System.out.println("_____000000____________________________000000______");
        System.out.println("_______000000________________________000000________");
        System.out.println("__________00000_____________________0000___________");
        System.out.println("_____________0000_________________0000_____________");
        System.out.println("_______________0000_____________000________________");
        System.out.println("_________________000_________000___________________");
        System.out.println("_________________ __000_____00_____________________");
        System.out.println("______________________00__00_______________________");
        System.out.println("________________________00_________________________");
  
    }
    
    public static void main(String[] args){
        opcionesAdministrador();
    }
    
}


