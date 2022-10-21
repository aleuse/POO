/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.personas.Medico;
import gestorAplicacion.Consultorio;
import gestorAplicacion.personas.tipoMedico;
import gestorAplicacion.registrosMedicos.HistoriaClinica;
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
        System.out.println("Se tiene un total de "+ Medico.medicos.size() + " medicos y "+ Consultorio.consultorios.size() + " consultorios");
        System.out.println("Se han atendido a "+ Paciente.pacientes + " pacientes");
        System.out.println("Y se ha facturado hasta ahora "+ "$" + " pesos");
        System.out.println("--------------------------------------");
        
        System.out.println("Desea visualizar las citas, examanes y entregas realizadas? [1]si  [0]no");
        do{System.out.print("Ingrese una opcion valida: ");
            opcion=dato.nextInt();
        } while (opcion!=1 & opcion!=0);
        if(opcion==1){
            System.out.println("Citas realizadas");
            int cant = Cita.informeCitas(tipoCita.General);
            int costoUnitario=(tipoCita.General.getValorCita());
            System.out.println("General: "+ cant + " citas recaudando" + cant*costoUnitario + " pesos");
            
            cant = Cita.informeCitas(tipoCita.Prioritaria);
            costoUnitario=(tipoCita.Prioritaria.getValorCita());
            System.out.println("Prioritaria: "+ cant + " citas recaudando" + cant*costoUnitario + " pesos");
            
            cant = Cita.informeCitas(tipoCita.Optometria);
            costoUnitario=(tipoCita.Optometria.getValorCita());
            System.out.println("Optometría: "+ cant + " citas recaudando" + cant*costoUnitario + " pesos");
            
            cant = Cita.informeCitas(tipoCita.Audiometria);
            costoUnitario=(tipoCita.Audiometria.getValorCita());
            System.out.println("Audiometria: "+ cant + " citas recaudando" + cant*costoUnitario + " pesos");
            
            cant = Cita.informeCitas(tipoCita.laboratorio);
            costoUnitario=(tipoCita.laboratorio.getValorCita());
            System.out.println("laboratorio: "+ cant + " citas recaudando" + cant*costoUnitario + " pesos");
            
            cant = Cita.informeCitas(tipoCita.Pediatria);
            costoUnitario=(tipoCita.Pediatria.getValorCita());
            System.out.println("Pediatria: "+ cant + " citas recaudando" + cant*costoUnitario + " pesos");
            System.out.println("--------------------------------------");
            
            System.out.println("Examenes realizados");
            cant = Examen.informeExamenes(tipoExamen.Sangre);
            costoUnitario=(tipoExamen.Sangre.getValorExamen());
            System.out.println("Sangre: "+ cant + " examenes recaudando" + cant*costoUnitario + " pesos");
            
            cant = Examen.informeExamenes(tipoExamen.Laboratorio);
            costoUnitario=(tipoExamen.Laboratorio.getValorExamen());
            System.out.println("Laboratorio: "+ cant + " examenes recaudando" + cant*costoUnitario + " pesos");
            
            cant = Examen.informeExamenes(tipoExamen.RayosX);
            costoUnitario=(tipoExamen.RayosX.getValorExamen());
            System.out.println("Rayos X: "+ cant + " examenes recaudando" + cant*costoUnitario + " pesos");
            
            cant = Examen.informeExamenes(tipoExamen.Citoquimico);
            costoUnitario=(tipoExamen.Citoquimico.getValorExamen());
            System.out.println("Citoquimico: "+ cant + " examenes recaudando" + cant*costoUnitario + " pesos");
            System.out.println("--------------------------------------");
            
            System.out.println("Estado de la entrega");
            cant = Entrega.informeEntregas(estadoEntrega.Procesada);
            System.out.println("Procesada: "+ cant + " entregas");
            
            cant = Entrega.informeEntregas(estadoEntrega.En_camino);
            System.out.println("En camino: "+ cant + " entregas");
            
            cant = Entrega.informeEntregas(estadoEntrega.Realizada);
            System.out.println("Realizada: "+ cant + " entregas");

        }
        System.out.println("--------------------------------------");
        System.out.println("Se tiene un total de "+HistoriaClinica.historia.size() +" historias clinicas");
        System.out.println("Desea buscar la historia clinica de un paciente? [1]si  [0]no");
        do{System.out.print("Ingrese una opcion valida: ");
            opcion=dato.nextInt();
        } while (opcion!=1 & opcion!=0);
        if(opcion==1){
            int cc;
            do{
                System.out.print("Ingrese numero de intedificacion: ");
                cc=dato.nextInt();
                HistoriaClinica resp=HistoriaClinica.buscarPaciente(cc);
                if(resp == new HistoriaClinica()){// no se encontró historiaClinica
                    System.out.println("Paciente no encontrado");
                    System.out.println("¿Desea volver a buscar paciente? [1]si  [0]no");
                    cc=dato.nextInt();
                }else{
                    System.out.println("paciente encontrado");
                    System.out.print(resp);
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
                    System.out.println("Se tiene un total de "+ Medico.medicos.size() + " medicos");
                    System.out.println("A cada medico se le paga un porcentaje por consulta");
                    
                    //int com=(tipoMedico.General.getComisionMed());
                    int med = Medico.informesMedicos(tipoMedico.General);
                    System.out.println("General: "+ med + " especialistas. Comision del 50%");

                    med = Medico.informesMedicos(tipoMedico.Optometra);
                    System.out.println("Optometra: "+ med + " especialistas. Comision del 60%");
                    
                    med = Medico.informesMedicos(tipoMedico.Fonoaudiologo);
                    System.out.println("Fonoaudiologo: "+ med + " especialistas. Comision del 60%");
                    
                    med = Medico.informesMedicos(tipoMedico.Pediatra);
                    System.out.println("Pediatra: "+ med + " especialistas. Comision del 70%");
                    
                    med = Medico.informesMedicos(tipoMedico.Bacteriologo);
                    System.out.println("Bacteriologo: "+ med + " especialistas. Comision del 70%");
                                        
                    System.out.println("Que especialistas desea contratar");
                    System.out.println("1. General");
                    System.out.println("2. Optometra");
                    System.out.println("3. Fonoaudiologo");
                    System.out.println("4. Pediatra");
                    System.out.println("5. Bacteriologo");

                    do {
                        System.out.print("Ingrese un numero valido: ");
                        opcion = dato.nextInt();
                    } while (opcion != 1 & opcion != 2 & opcion != 3 & opcion != 4 & opcion != 5);

                    int nuevosMedicos;
                    int mn;
                    tipoMedico nuevo;
                    switch (opcion) {
                        case 1:
                            nuevo = tipoMedico.General;
                            break;
                        case 2:
                            nuevo = tipoMedico.Optometra;
                            break;
                        case 3:
                            nuevo = tipoMedico.Fonoaudiologo;
                            break;
                        case 4:
                            nuevo = tipoMedico.Pediatra;
                            break;
                        case 5:
                            nuevo = tipoMedico.Bacteriologo;
                            break;
                    }//finaliza el switch para elegir que medico contratar
                    System.out.println("¿Cuantos medicos generales desea contratar?");
                    System.out.print("Ingrese un numero: ");
                    nuevosMedicos = dato.nextInt();
                    mn = 0;
                    for (int i = 0; i < nuevosMedicos; i++) {
                        double x = Math.random();
                        if (x > 0.3) {
                            mn++;
                            //agg nuevo en el tipoMedico

                            //Medico(String nombre, String apellido, tipoDocumento documento, long numeroDocumento, int edad,String genero,
                            //long telefono, String correoElectronico, String direccion, tipoMedico nuevo, boolean disponibilidad)
                        }
                    }
                    if (mn > 0) {
                        System.out.println("Se han podido contratar " + mn + " especialistas ");
                        System.out.println("Ahora hay" + Medico.medicos.size() + " medicos");
                    } else {
                        System.out.println("No se han podido adquirir nuevos especialistas. Lo sentimos");
                    }
                    break;
                case 2:
                    int cConsultorio=100000;
                    int totalDinero=1000000;// borrar despues
                    System.out.println("Se tiene un total de " + Consultorio.consultorios.size() + " consultorios");
                    System.out.println("Cada consultorio tiene un precio de " + cConsultorio + " pesos");
                    System.out.println("¿Cuantos consultorios desea contratar?");
                    System.out.print("Ingrese un numero: ");
                    int nuevosConsultorios = dato.nextInt();
                    
                    if(totalDinero<(nuevosConsultorios*cConsultorio)){
                        System.out.println("No hay suficiente dinero");
                        break;
                    }
                    int cn = 0;
                    for (int i = 0; i < nuevosConsultorios; i++) {
                        double x = Math.random();
                        if (x > 0.7) {
                            cn++;
                        }
                    }
                    totalDinero=totalDinero-(cn*cConsultorio);
                    if (cn > 0) {
                        System.out.println("Se han podido adquirir " + cn + " consultorios");
                        System.out.println("Ahora hay " + Consultorio.consultorios.size() + " consultorios");
                    } else {
                        System.out.println("No se han podido adquirir nuevos consultorios");
                    }
                    break;
                case 3:
                    System.out.println("Actualmente se dispone de los siguienes medicamentos");
                    //mostrar medicamentos
                    // falta atributo cantidad de medicamentos para cada medicamento
                    int a=tipoMedicamento.Acetaminofen.getValorMed();
                    System.out.println("hay en inventario " + " unidades de acetaminofen, a precio unitario de: "+a+" pesos" );
                    //colocar toda las unidades de medicamentos en inventario
                    
                    System.out.println("Que medicamentos desea comprar");
                    System.out.println("1. Acetaminofen");
                    System.out.println("2. Amoxicilina");
                    System.out.println("3. Ibuprofeno");
                    System.out.println("4. Lagrimas Artificiales");   
                    int comprar = dato.nextInt();
                    
                    //TERMINAR
                    switch(comprar){
                        case 1:
                            System.out.println("¿Cuantos unidades de acetaminofen desea comprar?");
                            System.out.print("Ingrese un numero: ");
                            comprar= dato.nextInt();
                            break;
                        case 2:
                            System.out.println("¿Cuantos unidades de Amoxicilina desea comprar?");
                            System.out.print("Ingrese un numero: ");
                            comprar= dato.nextInt();
                            break;
                        case 3:
                            System.out.println("¿Cuantos unidades de Ibuprofeno desea comprar?");
                            System.out.print("Ingrese un numero: ");
                            comprar= dato.nextInt();
                            break;
                        case 4:
                            System.out.println("¿Cuantos frascos de lagrimas artificiales desea comprar?");
                            System.out.print("Ingrese un numero: ");
                            comprar= dato.nextInt();
                            break;
                            
                    }
                    break;
            }//finaliza el switch de utilizar dinero
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


