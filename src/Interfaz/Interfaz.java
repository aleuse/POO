package Interfaz;
import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.personas.Paciente;

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
	static void finanzas() {
		System.out.println("Escoja una opción: \n 1.Pagar consultas y entregas \n 2. Consultar dinero disponible");
		opcion = sc.nextInt();
		switch (opcion){
		case 1:
			//codigo de paciente
		case 2:
			//codigo de administrador
		}
	}
	
	static void resultados() {
		System.out.println("Escoja una opción: \n 1. Crear diagnostico \n 2. Mostrar diagnosticos \n 3. Solicitar entrega de medicamentos");
		opcion = sc.nextInt();
		switch (opcion){
		case 1:
		case 2:
		case 3:
		}
	}
	
	static void administracion() {
	
}
	

}
