
import java.util.ArrayList;
import java.util.Scanner;

//no se en que clase va a ir la interfaz, puse consulta pero no tengo idea :(
public class Consulta {
    public static Scanner input = new Scanner(system.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Bienveniedo al Sistema Medico");
            System.out.println("Elija la opcion que desea realizar");
            System.out.println("1. Pedir Cita");
            System.out.println("2. Solicitar Examen");
            System.out.println("3. Solicitar Envio de Medicamentos");
            System.out.println("4. Pagar Consulta");
            System.out.println("5. Mostrar Balance de Citas Medicas");
            System.out.println("0. Terminar");

            String option = input.next();

            if (opcion.equals("1")) {
                PedirCita();
            }

            if (opcion.equals("2")) {
                SolicitarExamen();
            }

            if (opcion.equals("3")) {
                SolicitarMedicamentos();
            }

            if (opcion.equals("4")) {
                PagarConsulta();
            }

            if (opcion.equals("5")) {
                MostrarBalance();
            }

            if (opcion.equals("0")) {
                break;
            }
        }
    }

    public static void PagarConsulta() {
        System.out.println("Ingrese su nombre");
        String nombre = input.next();

        System.out.println("Elija la consulta que desea pagar");
        System.out.println("1. Cita");
        System.out.println("2. Examen");

        String option2 = input.next();

        if (pagado == false) {
            if (opcion2.equals("1")) {
                //cambiar el atributo pagado a true
                pagado == true;
                System.out.println("Se ha realizado correctamente el pago de la Cita");
            }
    
            if (opcion2.equals("2")) {
                //cambiar el atributo pagado a true
                pagado == true;
                System.out.println("Se ha realizado correctamente el pago del Examen");
            }
        }

        else if (pagado == true) {
            System.out.println("Ya se ha realizado el pago de la Consulta");
        }
    }

    //faltaria definir las otras 4 funcionalidades
}
