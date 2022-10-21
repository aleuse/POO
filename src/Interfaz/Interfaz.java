package Interfaz;
import java.util.Scanner;

public class Interfaz {
	 public static Scanner sc = new Scanner(System.in);
	 static int opcion;
	public static void main(String[] args) {
//		while(true) {
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
			}
			
			
		}
	static void opcionesCitas() {
		System.out.println("Escoja una opción: \n 1. Solicitar cita \n 2. Reagendar cita");
		opcion = sc.nextInt();
		switch (opcion){
		case 1:
			
		}
	}
//	}

}
