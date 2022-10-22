package Interfaz;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.Consulta;
import gestorAplicacion.Consultorio;
import gestorAplicacion.Entrega;
import gestorAplicacion.estadoEntrega;
import gestorAplicacion.tipoCita;
import gestorAplicacion.personas.Administrador;
import gestorAplicacion.personas.Medico;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.personas.tipoDocumento;
import gestorAplicacion.personas.tipoMedico;
import gestorAplicacion.registrosMedicos.Diagnostico;

public class Interfaz {
	 public static Scanner sc = new Scanner(System.in);
	 static int opcion;
	 static ArrayList<Paciente> pacientes = Paciente.pacientes;
	 
	public static void main(String[] args) {
		loop: while(true) {
			System.out.println("	+-------------------------------------------------------------------------------+	");
			System.out.println(" 	|						Bienvenido a su Sistema Médico |   "); 
			System.out.println(" 	+-------------------------------------------------------------------------------+   ");
			System.out.println("		+-------------------------------------------------------------------------------+	");
			System.out.println(" 	|						Elija a que Apartado Desea Acceder:						|   "); 
			System.out.println("		|   --------------------------------------------------------------------------  |	"); 
			System.out.println(" 	|								1. Citas.										|   "); 
			System.out.println(" 	|								2. Exámenes.									|   "); 
			System.out.println(" 	|								3. Finanzas.									|   "); 
			System.out.println(" 	|								4. Resultados y Medicamentos.					|   "); 
			System.out.println(" 	|								5. Administración								|   "); 
			System.out.println(" 	|								0. Salir del sistema							|   "); 
			System.out.println(" 	+-------------------------------------------------------------------------------+   ");
			
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
		System.out.println("		+-------------------------------------------------------------------------------+	");
		System.out.println(" 	|								Escoja una Opción:								|   "); 
		System.out.println("		|   -------------------------------------------------------------------------   |	"); 
		System.out.println(" 	|								1. Solicitar cita								|   "); 
		System.out.println(" 	|								2. Reagendar cita								|   "); 
		System.out.println(" 	+-------------------------------------------------------------------------------+   ");
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
			System.out.println("Inserte los siguientes datos para agendar su cita");
			System.out.println("Año: ");
			int year = sc.nextInt();
			System.out.println("Mes (en numero): ");
			int mes = sc.nextInt();
			Month month = null;
			switch (mes) {
			case 1:
				month = Month.JANUARY;
			case 2:
				month = Month.FEBRUARY;
			case 3:
				month = Month.MARCH;
			case 4:
				month = Month.APRIL;
			case 5:
				month = Month.MAY;
			case 6:
				month = Month.JUNE;
			case 7:
				month = Month.JULY;
			case 8:
				month = Month.AUGUST;
			case 9:
				month = Month.SEPTEMBER;
			case 10:
				month = Month.OCTOBER;
			case 11:
				month = Month.NOVEMBER;
			case 12:
				month = Month.DECEMBER;
			}
			System.out.println("Día: ");
			int dia = sc.nextInt();
			System.out.println("Ahora inserte la hora, primero la hora y luego los minutos.");
			System.out.println("Hora: ");
			int hora = sc.nextInt();
			System.out.println("Minutos: ");
			int min = sc.nextInt();
			//Se formatea la fecha
			LocalDateTime fecha = LocalDateTime.of(year, month,dia, hora, min);
			System.out.println("Inserte el tipo de cita: ");
			//Se convierte al enum 
			tipoCita tipo = tipoCita.valueOf(sc.next());
			System.out.println("¿Cuál es el motivo de su cita?");
			String motivo = sc.next();
			paciente.pedirCita(fecha, tipo, motivo);
			main(null);
			break;
			
		
		case 2:
			//Reagendar cita
		}
	}
	static void solicitarExamen() {
		//codigo para solicitar examen
	}

	static void finanzas() {

		//Se pide el documento de identidad para buscar el paciente
		System.out.println("Inserte su documento de identidad");
		long id = sc.nextLong();
		Paciente paciente = null;

		for (int i = 0; i < pacientes.size(); i++) {
			if (id == pacientes.get(i).getNumeroDocumento()) {
				paciente = pacientes.get(i);
			}
		}

		System.out.println("		+-------------------------------------------------------------------------------+	");
		System.out.println("		|						Escoja la accion que desea realizar:					|   "); 
		System.out.println("		|   --------------------------------------------------------------------------  |	"); 
		System.out.println(" 	|								1. Pagar consultas								|   "); 
		System.out.println(" 	|								2. Pagar entregas								|   "); 
		System.out.println(" 	|								3. Consultar dinero disponible					|   "); 
		System.out.println(" 	|								4. Pago de Nomina								|   "); 
		System.out.println(" 	|								5. Ir hacia atras								|   "); 
		System.out.println(" 	+-------------------------------------------------------------------------------+   ");
		opcion = sc.nextInt();
		
		switch (opcion){

		case 1:

			ArrayList<Consulta>consultas_paciente=(ArrayList<Consulta>)paciente.getConsultas().values();

			for (Consulta c: consultas_paciente) {
				if (c.getPago().isPagado() == false) {
					System.out.println("La consulta" + c.getId() + "en la fecha" + c.getFecha() + "esta sin pagar");
				}
			}

			System.out.println("Ingrese el ID de la cita que desea pagar (Para ir hacia atras ingrese el numero -1): ");
			int id_consulta = sc.nextInt();
			if (id_consulta == -1) {
				break;
			}

			for (Consulta c: consultas_paciente) {
				if (c.getId() == id_consulta) {
					c.getPago().setPagado(true);
					Administrador.sumarDinero(c.getPago().getValor());
					System.out.println("La consulta" + c.getId() + "en la fecha" + c.getFecha() + "ha sido pagada existosamente");
				}
			}


		case 2:

			ArrayList<Entrega>entregas_paciente=(ArrayList<Entrega>)paciente.getEntregas().values();

			for (Entrega e: entregas_paciente) {
				if (e.getPago().isPagado() == false) {
					System.out.println("La entrega" + e.getId() + "esta sin pagar");
				}
			}

			System.out.println("Ingrese el ID de la entrega que desea pagar (Para ir hacia atras ingrese el numero -1): ");
			int id_entrega = sc.nextInt();
			if (id_entrega == -1) {
				break;
			}

			for (Entrega e: entregas_paciente) {
				if (e.getId() == id_entrega) {
					e.getPago().setPagado(true);
					Administrador.sumarDinero(e.getPago().getValor());
					System.out.println("La entrega" + e.getId() + "ha sido pagada existosamente");
				}
			}  

			
		case 3:

			System.out.println("		+-------------------------------------------------------------------------------+	");
			System.out.println(" 	|							Bienvenido Administrador							|   "); 
			System.out.println(" 	+-------------------------------------------------------------------------------+   ");
			System.out.println("		+-------------------------------------------------------------------------------+	");
			System.out.println(" 		|		Actualmente el Dinero Disponible es: $" + Administrador.dinero + " 		|   "); 
			System.out.println(" 	+-------------------------------------------------------------------------------+   ");

			System.out.println("Para ir hacia atras ingrese el numero -1 ");
			int opcion = sc.nextInt();
			if (opcion == -1) {
				break;
			}

		case 4:

			LocalDateTime fecha = LocalDateTime.of(2022, 10, 1, 00, 00);
			for (Medico m: Medico.medicos) {
				if (m.getNomina().get(fecha).isPagado() == false) {
					System.out.println("El medico" + m.getNombre() + "con documento" + m.getNumeroDocumento() + "no ha recibido su pago desde la fecha" + fecha);
				}
			}

			System.out.println("Ingrese el numero del documento del medico al que le deseas pagar (Para ir hacia atras ingrese el numero -1): ");
			int numeroDocumento = sc.nextInt();
			if (numeroDocumento == -1) {
				break;
			}

			for (Medico m: Medico.medicos) {
				if (m.getNumeroDocumento() == numeroDocumento) {
					m.getNomina().get(fecha).setPagado(true);
					Administrador.restarDinero(m.getNomina().get(fecha).getValor());
					System.out.println("El medico" + m.getNombre() + "con documento" + m.getNumeroDocumento() + "ha sido pagado existosamente");
				}
			}

		case 5:

			System.out.println("\n");
			break;

		}
	}
	
	static void resultados() {
		System.out.println("		+-------------------------------------------------------------------------------+	");
		System.out.println(" 	|								Escoja una Opción:								|   "); 
		System.out.println("		|   --------------------------------------------------------------------------  |	"); 
		System.out.println(" 	|							1. Crear Diagnostico								|   "); 
		System.out.println(" 	|							2. Mostrar Diagnosticos								|   "); 
		System.out.println(" 	|							3. Solicitar Entrega de Medicamentos				|   "); 
		System.out.println(" 	+-------------------------------------------------------------------------------+   ");
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
								System.out.println("Por favor ingrese su direccion de domicilio: ");
								//System.out.println(medi.getPersona().getNombre());
								//System.out.println(medi.getPersona().pagado);
								String domicilio = input.nextLine();
								//Entrega.crearEntrega(cont, medi.getPersona().getNombre(), domicilio, null, null);
								Entrega.crearEntrega(cont, medi.getPersona().getNombre(),domicilio,medi.getMedicamiento(), estadoEntrega.En_camino);
								cont++;
								System.out.println("El proceso ha sido exitoso");
	
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