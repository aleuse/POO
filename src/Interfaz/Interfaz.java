package Interfaz;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import gestorAplicacion.Cita;
import gestorAplicacion.Consulta;
import gestorAplicacion.Consultorio;
import gestorAplicacion.Entrega;
import gestorAplicacion.Examen;
import gestorAplicacion.Medicamentos;
import gestorAplicacion.Pago;
import gestorAplicacion.estadoEntrega;
import gestorAplicacion.tipoCita;
import gestorAplicacion.tipoExamen;
import gestorAplicacion.tipoMedicamento;
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
	 static ArrayList<LocalDateTime> fechas = new ArrayList<LocalDateTime>();
	 
	public static void main(String[] args) {
		LocalDateTime fecha = LocalDateTime.of(2022, Month.NOVEMBER, 25, 15,30);
		 Paciente paciente = new Paciente("Camilo", "Martinez", tipoDocumento.CEDULA, 1074074689, 25, "masculino", 300762957,"mcm@gmail.com", "cra87#12-34", "SURA", false);
			Paciente paciente1 = new Paciente("Maria", "Jaramillo", tipoDocumento.CEDULA, 9403862, 43, "femenino", 301762849,"mj@gmail.com", "calle 3", "SURA", false);
			Medico m1 = new Medico("Sara", "Perez", tipoDocumento.CEDULA, 12345678, 50, "femenino", 6048742, "sp@yahoo.com", "calle 43", 
					tipoCita.General, tipoMedico.General, true);
			Medico m2 = new Medico("Mauricio", "Fernandez", tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284 ,"mp@hotmail.com", "carrera 78", tipoCita.Audiometria, tipoMedico.Fonoaudiologo, true);
			Medico m3 = new Medico("Carlos", "Munera", tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284 ,"mp@hotmail.com", "carrera 78", tipoCita.General, tipoMedico.General, true);
			Consultorio c1 = new Consultorio(null, null, null, true, fecha, null);
			Consultorio c2 = new Consultorio(null, null, null, true, fecha, null);
		loop: while(true) {
			
			System.out.println("-------------------------------------" + "\n"+
			"Bienvenido a su Sistema Médico" + "\n"+
			"-------------------------------------" + "\n"+
			"Elija a que Apartado Desea Acceder: " + "\n"+
			"1. Citas"  + "\n"+
			"2. Exámenes"+ "\n"+
			"3. Finanzas"+ "\n"+
			"4. Resultados y Medicamentos"+ "\n"+
			"5. Administración	"+ "\n"+
			"0. Salir del sistema");
			/*System.out.println("	+-------------------------------------------------------------------------------+	");
			System.out.println(" 	|						Bienvenido a su Sistema Médico |   "); 
			System.out.println(" 	+-------------------------------------------------------------------------------+   ");
			System.out.println("		+-------------------------------------------------------------------------------+	");
			System.out.println(" 	|						Elija a que Apartado Desea Acceder:						|   "); 
			System.out.println("		|   --------------------------------------------------------------------------  |	"); 
			System.out.println(" 	|								1. Citas										|   "); 
			System.out.println(" 	|								2. Exámenes									|   "); 
			System.out.println(" 	|								3. Finanzas									|   "); 
			System.out.println(" 	|								4. Resultados y Medicamentos					|   "); 
			System.out.println(" 	|								5. Administración								|   "); 
			System.out.println(" 	|								0. Salir del sistema							|   "); 
			System.out.println(" 	+-------------------------------------------------------------------------------+   ");
			*/
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
		System.out.println("-----------------------------" + "\n"+
			"     Escoja una Opción:	" + "\n"+
			"-----------------------------" + "\n"+
			"1. Solicitar cita " + "\n"+
			"2. Reagendar cita	" );
		/*System.out.println("		+-------------------------------------------------------------------------------+	");
		System.out.println(" 	|								Escoja una Opción:								|   "); 
		System.out.println("		|   -------------------------------------------------------------------------   |	"); 
		System.out.println(" 	|								1. Solicitar cita								|   "); 
		System.out.println(" 	|								2. Reagendar cita								|   "); 
		System.out.println(" 	+-------------------------------------------------------------------------------+   ");
		*/
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
					break;
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
			System.out.println(paciente.pedirCita(fecha, tipo, motivo));
			System.out.println("¿Desea pedir otra cita?");
			System.out.println("Si la respuesta es sí, presione 1");
			System.out.println("Si desea volver al menu principal, presione 2");
			opcion = sc.nextInt();
			switch(opcion) {
			case 1:
				opcionesCitas();
			case 2:
				main(null);
				break;
			}
			
		
		case 2:
			//Se pide el documento de identidad para buscar el paciente
			System.out.println("Inserte su documento de identidad");
			id = sc.nextLong();
			paciente = null;
			for (int i = 0; i < pacientes.size(); i++) {
				if (id == pacientes.get(i).getNumeroDocumento()) {
					paciente = pacientes.get(i);
					break;
				}
			}
			System.out.println("Inserte la fecha en la que desea cambiar su ");
		}
	}
	static void solicitarExamen() {
		//codigo para solicitar examen
		
		//Se pide el documento de identidad para buscar el paciente
		System.out.println("Inserte su documento de identidad");
		long id = sc.nextLong();
		Paciente paciente = null;
		for (int i = 0; i < pacientes.size(); i++) {
			if (id == pacientes.get(i).getNumeroDocumento()) {
				paciente = pacientes.get(i);
			}
		}
		
		// Pedir el tipo de examen que desea solicitar
		System.out.println("------------------------------------------------" + "\n"+
			"Escoja el tipo de examen que desea solicitar:" + "\n"+
			"------------------------------------------------" + "\n"+
			"1. Sangre " + "\n"+
			"2. Laboratorio"  + "\n"+
			"3. RayosX"+ "\n"+
			"3. Finanzas"+ "\n"+
			"4. Citoquimico"+ "\n"+
			"5. Ir hacia atrás	");
		/*System.out.println("	+-------------------------------------------------------------------------------+	");
		System.out.println("	|					Escoja el tipo de examen que desea solicitar:				|   "); 
		System.out.println("	|   --------------------------------------------------------------------------  |	"); 
		System.out.println(" |								1. Sangre										|   "); 
		System.out.println(" |								2. Laboratorio									|   "); 
		System.out.println(" |								3. RayosX										|   "); 
		System.out.println(" |								4. Citoquimico									|   "); 
		System.out.println(" |								5. Ir hacia atrás								|   "); 
		System.out.println(" +-------------------------------------------------------------------------------+   ");
		*/
		do {
            System.out.print("Ingrese un número válido: ");
            opcion = sc.nextInt();
        } while (opcion != 1 & opcion != 2 & opcion != 3 & opcion != 4 & opcion != 5);
		
		tipoExamen tipoEx = null;
		tipoMedico tipoMed = null;
		switch(opcion) {
		case 1:
			tipoEx = tipoExamen.Sangre;
			tipoMed = tipoMedico.Bacteriologo;
		case 2:
			tipoEx = tipoExamen.Laboratorio;
			tipoMed = tipoMedico.Bacteriologo;
		case 3:
			tipoEx = tipoExamen.RayosX;
			tipoMed = tipoMedico.General;
		case 4: 
			tipoEx = tipoExamen.Citoquimico;
			tipoMed = tipoMedico.Bacteriologo;
		case 5:
			System.out.println("\n");
			break;
		}
		
		System.out.println("A continuación se procederá a autorizar su examen");
		Examen examen = new Examen((int)(Math.random()*10000+1), paciente, tipoEx, false);
		// Autorizar el examen
		System.out.println(paciente.solicitarExamen(examen, tipoEx, tipoMed));
		
		
		// Buscar fecha más cercana con disponibilidad
		LocalDateTime fechaExamen = Administrador.verificarDisponibilidadFechaExamen(fechas, tipoMed);
		if(fechaExamen == null) {
			System.out.println("Lo sentimos, en este momento no tenemos disponibilidad");
		}
		else {
			System.out.println("La fecha más cercana es: " + fechaExamen + ". ¿Desea agendar la cita en esta fecha?");
			System.out.println("1. Sí");
			System.out.println("2. No");
			do {
	            System.out.print("Ingrese un número válido: ");
	            opcion = sc.nextInt();
	        } while (opcion != 1 & opcion != 2);
			switch(opcion) {
			case 1:
				// Agendar examen
				System.out.println(Administrador.asignarExamen(examen, paciente, Medico.medicos, Consultorio.consultorios, fechaExamen));
			case 2:
				// Pedirle una fecha al paciente
				System.out.println("Inserte los siguientes datos para agendar su examen");
				System.out.println("Año: ");
				int year = sc.nextInt();
				System.out.println("Mes (en número): ");
				int mes;
				do {
		            System.out.print("Ingrese un número válido: ");
		            mes = sc.nextInt();
		        } while (mes != 1 & mes != 2 & mes != 3 & mes != 4 & mes != 5 & mes != 6 & mes != 7 & mes != 8 & mes != 9 & mes != 10 & mes != 11 & mes != 12);
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
				int day = sc.nextInt();
				System.out.println("Ahora inserte la hora, primero la hora y luego los minutos (en intervalos de 30 minutos).");
				System.out.println("Hora: ");
				int hour = sc.nextInt();
				System.out.println("Minutos: ");
				int min = sc.nextInt();
				fechaExamen = LocalDateTime.of(year, month, day, hour, min);
				// Agendar el examen
				System.out.println(Administrador.asignarExamen(examen, paciente, Medico.medicos, Consultorio.consultorios, fechaExamen));
			}
		}
		
		
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

		System.out.println("-------------------------------------" + "\n"+
			"Escoja la accion que desea realizar:" + "\n"+
			"-------------------------------------" + "\n"+
			"Elija a que Apartado Desea Acceder: " + "\n"+
			"1. Pagar consultas"  + "\n"+
			"2. Pagar entregas"+ "\n"+
			"3. Consultar dinero disponible"+ "\n"+
			"4. Pago de Nomina"+ "\n"+
			"5. Ir hacia atras	");

		/*System.out.println("		+-------------------------------------------------------------------------------+	");
		System.out.println("		|						Escoja la accion que desea realizar:					|   "); 
		System.out.println("		|   --------------------------------------------------------------------------  |	"); 
		System.out.println(" 	|								1. Pagar consultas								|   "); 
		System.out.println(" 	|								2. Pagar entregas								|   "); 
		System.out.println(" 	|								3. Consultar dinero disponible					|   "); 
		System.out.println(" 	|								4. Pago de Nomina								|   "); 
		System.out.println(" 	|								5. Ir hacia atras								|   "); 
		System.out.println(" 	+-------------------------------------------------------------------------------+   ");
		*/
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
				System.out.println("Todas las consultas han sido pagadas");
			}


		case 2:

			ArrayList<Entrega>entregas_paciente=(ArrayList<Entrega>)paciente.getEntregas().values();

			for (Entrega e: entregas_paciente) {
				if (e.getPago().isPagado() == false) {
					System.out.println("La entrega" + e.getId() + "esta sin pagar");
				}
				System.out.println("Todas las entregas han sido pagadas");
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
				System.out.println("Todas las entregas han sido pagadas");
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
					System.out.println("El medico" + m.getNombre() + "con documento" + m.getNumeroDocumento() + "ha sido pagado exitosamente");
				}
			}

		case 5:

			System.out.println("\n");
			break;

		}
	}
	
	static void resultados() {
		
		System.out.println("    Escoja una Opción: " + "\n" + 
        "-------------------------------------"+ "\n" +
        "1. Crear Diagnostico" + "\n" + 
        "2. Mostrar Diagnosticos" + "\n" +
        "3. Solicitar Entrega de Medicamentos" + "\n" +
		"4. Ir hacia atras");
		/*System.out.println("		+-------------------------------------------------------------------------------+	");
		System.out.println(" 	|								Escoja una Opción:								|   "); 
		System.out.println("		|   --------------------------------------------------------------------------  |	"); 
		System.out.println(" 	|							1. Crear Diagnostico								|   "); 
		System.out.println(" 	|							2. Mostrar Diagnosticos								|   "); 
		System.out.println(" 	|							3. Solicitar Entrega de Medicamentos				|   "); 
		System.out.println(" 	+-------------------------------------------------------------------------------+   ");
		*/
		opcion = sc.nextInt();
		switch (opcion){
		case 1:
		case 2:
		case 3:
		
		Scanner input= new Scanner(System.in);
		System.out.println("Ingrese el documento del paciente: ");
		int docu = input.nextInt();
		ArrayList<Diagnostico> lis = Medico.listado;
		int cont = 1;

		for (Diagnostico medi : lis) {
            //System.out.println(medi);
			if (medi.getPersona().getNumeroDocumento() == (docu)){
				System.out.println(medi.medicamiento.getTipoMed());

				String option;
				while (true) {
					System.out.println("¿Deseas confirmar el envio de medicamentos?");
					System.out.println("1. Si");
					System.out.println("2. No");
					option = input.next();
					if (option.equals("1")) {
						//System.out.println(medi.getPersona().isPagado());
						if (medi.getConsulta().getPago().isPagado() == true){
							//System.out.println(medi.getPersona().isPagado());
							System.out.println("Por favor ingrese su direccion de domicilio: ");
						
							
							String domicilio1 = input.next();
                            System.out.println(domicilio1);
							Entrega.crearEntrega(cont,medi.getPersona().getNombre(), domicilio1, medi.getMedicamiento(), estadoEntrega.En_camino);
							cont++;
							Medicamentos.asignarMed(medi.medicamiento.getTipoMed(), 1);
							System.out.println("El proceso ha sido exitoso");
							Interfaz.main(null);
						}
						else if (medi.getConsulta().getPago().isPagado() == false){
							System.out.println("Debes pagar la consulta antes de pedir los medicamentos");
							
							String option1;
							while (true) {
								System.out.println("¿Deseas pagar la consulta?");
								System.out.println("1. Si");
								System.out.println("2. No");
								option1 = input.next();
								if (option1.equals("1")) {
									finanzas();
								
								}
								if (option1.equals("2")) {
                                    System.out.println("Proceso finalizado");
                                    resultados();
								}
							
							}
						}
					}
					if (option.equals("2")) {
						resultados();
					}
				}
			}
			else{
				System.out.println("El documento no se encuentara en la base de datos");
                resultados();
				
			}
		}
		case 4:
			System.out.println("\n");
			Interfaz.main(null);
		
		}
	}
	
	static void administracion() {
	
	}
	

}