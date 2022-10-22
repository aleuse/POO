package Interfaz;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.Consulta;
import gestorAplicacion.Entrega;
import gestorAplicacion.estadoEntrega;
import gestorAplicacion.personas.Administrador;
import gestorAplicacion.personas.Medico;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.registrosMedicos.Diagnostico;

public class Interfaz {
	 public static Scanner sc = new Scanner(System.in);
	 static int opcion;
	 static ArrayList<Paciente> pacientes = Paciente.pacientes;
	public static void main(String[] args) {
		loop: while(true) {
			System.out.println("Bienvenido a su sistema médico. \nElija a que apartado desea acceder");
			System.out.println("1. Citas.");
			System.out.println("2. Exámenes.");
			System.out.println("3. Finanzas.");
			System.out.println("4. Resultados y Medicamentos.");
			System.out.println("5. Administración");
			System.out.println("0. Salir del sistema");
			
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 1:
				opcionesCitas();
			case 2:
				solicitarExamen();
			case 3:
				finanzas();
			case 4:
				resultados();
			case 5:
				administracion();
			case 0:
				System.out.println("Se ha terminado");
				break loop;
			}

				
		}
			
		}

	static void opcionesCitas() {
		System.out.println("Escoja una opción: \n 1. Solicitar cita \n 2. Reagendar cita");
		opcion = sc.nextInt();
		switch (opcion){
		case 1:
			
			//Se pide el documento de identidad para buscar el paciente
			System.out.println("Inserte su documento de identidad");
			long id = sc.nextLong();
			Paciente paciente = null;
			for (int i = 0; i < pacientes.size(); i++) {
				if (id == pacientes.get(i).getNumeroDocumento()) {
					paciente = pacientes.get(i);
				}
			}
			System.out.println("Inserte la fecha en la que");
		
		case 2:
			//Reagendar cita
		}
	}
	static void solicitarExamen() {
		//codigo para solicitar examen
	}


	
	static void resultados() {
		System.out.println("Escoja una opción: \n 1. Crear diagnostico \n 2. Mostrar diagnosticos \n 3. Solicitar entrega de medicamentos");
		opcion = sc.nextInt();
		switch (opcion){
		case 1:
		case 2:
		case 3:
		Scanner input= new Scanner(System.in);
			System.out.println("Ingrese el nombre del paciente Prueba: ");
			String nombre = input.nextLine();
			ArrayList<Diagnostico> lis = Medico.listado;
			//System.out.println(Medico.listado.size());
			int cont = 1;
	
			for (Diagnostico medi : lis) {
				if (medi.getPersona().getNombre().equals(nombre)){
					System.out.println(medi.getMedicamiento());
	
					String option;
					while (true) {
						System.out.println("¿Deseas confirmar el envio de medicamentos?");
						System.out.println("1. Si");
						System.out.println("2. No");
						option = input.next();
						if (option.equals("1")) {
							if (medi.getConsulta().getPago().isPagado() == true){
								System.out.println("Por Favor ingrese su direccion de domicilio: ");
								//System.out.println(medi.getPersona().getNombre());
								//System.out.println(medi.getPersona().pagado);
								String domicilio = input.nextLine();
								//Entrega.crearEntrega(cont, medi.getPersona().getNombre(), domicilio, null, null);
								Entrega.crearEntrega(cont, medi.getPersona().getNombre(),domicilio,medi.getMedicamiento(), estadoEntrega.En_camino);
								cont++;
								System.out.println("el proceso ha sido exitoso");
	
							}
							if (medi.getPersona().pagado == false){
								System.out.println("Debes pagar la consulta antes de pedir los medicamentos");
						
							}
						}
						if (option.equals("2")) {
							break;
						}
					}
				}
			}
		}
	}
	
	static void administracion() {
	
}
	

}