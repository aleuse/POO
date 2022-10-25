package Interfaz;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;

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
import gestorAplicacion.personas.Persona;
import gestorAplicacion.personas.tipoDocumento;
import gestorAplicacion.personas.tipoMedico;
import gestorAplicacion.registrosMedicos.Diagnostico;
import gestorAplicacion.registrosMedicos.HistoriaClinica;

public class Interfaz {
	 public static Scanner sc = new Scanner(System.in);
	 static int opcion;
	 static ArrayList<Paciente> pacientes = Administrador.pacientes;
	 static ArrayList<Medico> medicos = Administrador.medicos;
	 static ArrayList<Consultorio> consultorios = Administrador.consultorios;
	 static ArrayList<LocalDateTime> fechas = new ArrayList<LocalDateTime>();
	 static {
		 	Administrador.medicos = new ArrayList<Medico>();
			Administrador.consultorios = new ArrayList<Consultorio>();
			Administrador.pacientes = new ArrayList<Paciente>();
			Administrador.fechas = new ArrayList<LocalDateTime>();
			medicos = new ArrayList<Medico>();
			consultorios = new ArrayList<Consultorio>();
			pacientes = new ArrayList<Paciente>();
			fechas = new ArrayList<LocalDateTime>();
			
			Administrador admin = new Administrador(123, "Jaime");
			Administrador.dinero = 500000;
			
			LocalDateTime fecha1 = LocalDateTime.of(2022, 10, 15, 12, 30);
			LocalDateTime fecha2 = LocalDateTime.of(2022, 10, 15, 13, 00);
			LocalDateTime fecha3 = LocalDateTime.of(2022, 10, 15, 13, 30);
			LocalDateTime fecha4 = LocalDateTime.of(2022, 10, 15, 14, 00);
			LocalDateTime fecha5 = LocalDateTime.of(2022, 10, 15, 14, 30);
			LocalDateTime fecha6 = LocalDateTime.of(2022, 10, 15, 15, 00);
			LocalDateTime fecha7 = LocalDateTime.of(2022, 10, 15, 15, 30);
			
			LocalDateTime fecha8 = LocalDateTime.of(2022, 10, 16, 12, 30);
			LocalDateTime fecha9 = LocalDateTime.of(2022, 10, 16, 13, 00);
			LocalDateTime fecha10 = LocalDateTime.of(2022, 10, 16, 13, 30);
			LocalDateTime fecha11 = LocalDateTime.of(2022, 10, 16, 14, 00);
			LocalDateTime fecha12 = LocalDateTime.of(2022, 10, 16, 14, 30);
			LocalDateTime fecha13 = LocalDateTime.of(2022, 10, 16, 15, 00);
			LocalDateTime fecha14 = LocalDateTime.of(2022, 10, 16, 15, 30);
			
			LocalDateTime nomina9 = LocalDateTime.of(2022, 9, 1, 00, 00);
			LocalDateTime nomina10 = LocalDateTime.of(2022, 10, 1, 00, 00);
			
			
			Paciente paciente1 = new Paciente("Maria", "Jaramillo", tipoDocumento.CEDULA, 9403862, 43,
					"Femenino", 301762849,"mj@gmail.com", "calle 36 #89 53", "SURA", false);
			Paciente paciente2 = new Paciente( "Juan",  "Pérez",  tipoDocumento.CEDULA,  1000,  23,
					 "Masculino",  245687523,  "juanper@gmail.com",  "Carrera 68 # 54 12",  "SURA" , false);
			Paciente paciente3 = new Paciente("Camilo", "Martinez", tipoDocumento.CEDULA, 1074074689, 25,
					"Masculino", 300762957,"mcm@gmail.com", "cra87#12-34", "SURA", false);
			
			
			Medico medico1 = new Medico("Susana", "Perez", tipoDocumento.CEDULA, 1000758374, 25, "Masculino", 1000758374, 
					"susper@gmail.com", "Cra 77 #45 04", tipoCita.GENERAL, tipoMedico.BACTERIOLOGO ,true);
			Medico medico2 = new Medico("Andres", "Lopez", tipoDocumento.CEDULA, 1254687950, 29, "Masculino", 1254687950, 
					"andlop@gmail.com", "Calle 113 #55 05", tipoCita.GENERAL, tipoMedico.OPTOMETRIA, true);
			Medico medico3 = new Medico("Mariana", "Garcia", tipoDocumento.CEDULA, 656502354, 28, "Femenino", 656502354, 
					"margar@gmail.com", "Avenida 7 #8 07", tipoCita.GENERAL, tipoMedico.OPTOMETRIA, true);
			Medico medico4 = new Medico("Mauricio", "Fernandez", tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284,
					"mp@hotmail.com", "carrera 78", tipoCita.AUDIOMETRIA, tipoMedico.FONOAUDIOLOGO, true);
			
			
			Consultorio consultorio1 = new Consultorio(1, null, null, "Laboratorio", true);
			Consultorio consultorio2 = new Consultorio(2, null, null, "Consultorio Optometría", true);
			Consultorio consultorio3 = new Consultorio(3, null, null, "Consultorio Optometría", true);
			Consultorio consultorio4 = new Consultorio(4, null, null, "Consultorio Audiometría", true);
			
			
			Cita cita1 = new Cita(paciente1, "Un laboratorio", medico1, consultorio1, fecha1, tipoCita.LABORATORIO);
			Cita cita6 = new Cita(paciente3, "Un laboratorio", medico1, consultorio1, fecha4, tipoCita.LABORATORIO);
			Cita cita11 = new Cita(paciente2, "Un laboratorio", medico1, consultorio1, fecha5, tipoCita.LABORATORIO);
			Cita cita16 = new Cita(null, "Un laboratorio", medico1, consultorio1, fecha6, tipoCita.LABORATORIO);
			cita1.setPago(new Pago(15000, true));
			cita6.setPago(new Pago(15000, false));
			cita11.setPago(new Pago(15000, false));
			
			Cita cita2 = new Cita(null, "Revisión visual", medico2, consultorio2, fecha1, tipoCita.OPTOMETRIA);
			Cita cita3 = new Cita(null, "Problemas visuales", medico2, consultorio2, fecha2, tipoCita.OPTOMETRIA);
			Cita cita7 = new Cita(null, "Revisión visual", medico2, consultorio2, fecha4, tipoCita.OPTOMETRIA);
			Cita cita8 = new Cita(paciente1, "Problemas visuales", medico2, consultorio2, fecha5, tipoCita.OPTOMETRIA);
			cita8.setPago(new Pago(15000, false));
			
			
			Cita cita12 = new Cita(paciente2, "Revisión visual", medico3, consultorio3, fecha8, tipoCita.OPTOMETRIA);
			Cita cita13 = new Cita(null, "Problemas visuales", medico3, consultorio3, fecha9, tipoCita.OPTOMETRIA);
			Cita cita17 = new Cita(paciente3, "Revisión visual", medico3, consultorio3, fecha10, tipoCita.OPTOMETRIA);
			Cita cita18 = new Cita(null, "Problemas visuales", medico3, consultorio3, fecha5, tipoCita.OPTOMETRIA);
			cita12.setPago(new Pago(15000, false));
			cita17.setPago(new Pago(15000, false));

			
			Cita cita4 = new Cita(null, "Problemas en los oídos", medico4, consultorio4, fecha2, tipoCita.AUDIOMETRIA);
			Cita cita5 = new Cita(null, "No escucha", medico4, consultorio4, fecha3, tipoCita.AUDIOMETRIA);
			Cita cita9 = new Cita(null, "Problemas en los oídos", medico4, null, fecha6, tipoCita.AUDIOMETRIA);
			Cita cita10 = new Cita(null, "No escucha", medico4, consultorio4, fecha7, tipoCita.AUDIOMETRIA);
			Cita cita14 = new Cita(null, "Problemas en los oídos", medico4, null, fecha11, tipoCita.AUDIOMETRIA);
			Cita cita15 = new Cita(paciente1, "No escucha", medico4, consultorio4, fecha12, tipoCita.AUDIOMETRIA);
			Cita cita19 = new Cita(null, "Problemas en los oídos", medico4, null, fecha13, tipoCita.AUDIOMETRIA);
			Cita cita20 = new Cita(paciente3, "No escucha", medico4, consultorio4, fecha14, tipoCita.AUDIOMETRIA);
			cita15.setPago(new Pago(15000, false));
			cita20.setPago(new Pago(15000, false));

			cita1.setId(1);
			cita2.setId(2);
			cita3.setId(3);
			cita4.setId(4);
			cita5.setId(5);
			cita6.setId(6);
			cita7.setId(7);
			cita8.setId(8);
			cita9.setId(9);
			cita10.setId(10);
			cita11.setId(11);
			cita12.setId(12);
			cita13.setId(13);
			cita14.setId(14);
			cita15.setId(15);
			cita16.setId(16);
			cita17.setId(17);
			cita18.setId(18);
			cita19.setId(19);
			cita20.setId(20);
			
			
			Entrega entrega1 = new Entrega(paciente1, "calle 36 #89 53", null, estadoEntrega.EN_CAMINO);
			Entrega entrega2 = new Entrega(paciente1, "calle 36 #89 53", null, estadoEntrega.EN_CAMINO);
			Entrega entrega3 = new Entrega(paciente2, "Carrera 68 # 54 12", null, estadoEntrega.EN_CAMINO);
			Entrega entrega4 = new Entrega(paciente3, "cra87#12-34", null, estadoEntrega.EN_CAMINO);

			entrega1.setPago(new Pago(10000, false));
			entrega2.setPago(new Pago(10000, false));
			entrega3.setPago(new Pago(10000, false));
			entrega4.setPago(new Pago(10000, false));
			
			paciente1.getEntregas().put(fecha10, entrega1);
			paciente1.getEntregas().put(fecha11, entrega2);
			paciente2.getEntregas().put(fecha13, entrega3);
			paciente3.getEntregas().put(fecha14, entrega4);
			
			Medicamentos medicamentos = new Medicamentos(tipoMedicamento.Acetaminofen, paciente1, 2, 3);
			Diagnostico.sintomas.add("gripa");
			Diagnostico diagnostico = new Diagnostico(paciente1, Diagnostico.sintomas, "Dolor de cabeza", medicamentos, 1, cita1);
			Medico.listado.add(diagnostico);
			
			medico1.getConsultas().put(fecha1, cita1);
			medico1.getConsultas().put(fecha2, null);
			medico1.getConsultas().put(fecha3, null);
			medico1.getConsultas().put(fecha4, cita6);
			medico1.getConsultas().put(fecha5, cita11);
			medico1.getConsultas().put(fecha6, cita16);
			medico1.getConsultas().put(fecha7, null);
			medico1.getConsultas().put(fecha8, null);
			medico1.getConsultas().put(fecha9, null);
			medico1.getConsultas().put(fecha10, null);
			medico1.getConsultas().put(fecha11, null);
			medico1.getConsultas().put(fecha12, null);
			medico1.getConsultas().put(fecha13, null);
			medico1.getConsultas().put(fecha14, null);
			
			medico2.getConsultas().put(fecha1, cita2);
			medico2.getConsultas().put(fecha2, cita3);
			medico2.getConsultas().put(fecha3, null);
			medico2.getConsultas().put(fecha4, cita7);
			medico2.getConsultas().put(fecha5, cita8);
			medico2.getConsultas().put(fecha6, null);
			medico2.getConsultas().put(fecha7, null);
			medico2.getConsultas().put(fecha8, null);
			medico2.getConsultas().put(fecha9, null);
			medico2.getConsultas().put(fecha10, null);
			medico2.getConsultas().put(fecha11, null);
			medico2.getConsultas().put(fecha12, null);
			medico2.getConsultas().put(fecha13, null);
			medico2.getConsultas().put(fecha14, null);
			
			medico3.getConsultas().put(fecha1, null);
			medico3.getConsultas().put(fecha2, null);
			medico3.getConsultas().put(fecha3, null);
			medico3.getConsultas().put(fecha4, null);
			medico3.getConsultas().put(fecha5, cita18);
			medico3.getConsultas().put(fecha6, null);
			medico3.getConsultas().put(fecha7, null);
			medico3.getConsultas().put(fecha8, cita12);
			medico3.getConsultas().put(fecha9, cita13);
			medico3.getConsultas().put(fecha10, cita17);
			medico3.getConsultas().put(fecha11, null);
			medico3.getConsultas().put(fecha12, null);
			medico3.getConsultas().put(fecha13, null);
			medico3.getConsultas().put(fecha14, null);
			
			medico4.getConsultas().put(fecha1, null);
			medico4.getConsultas().put(fecha2, cita4);
			medico4.getConsultas().put(fecha3, cita5);
			medico4.getConsultas().put(fecha4, null);
			medico4.getConsultas().put(fecha5, null);
			medico4.getConsultas().put(fecha6, cita9);
			medico4.getConsultas().put(fecha7, cita10);
			medico4.getConsultas().put(fecha8, null);
			medico4.getConsultas().put(fecha9, null);
			medico4.getConsultas().put(fecha10, null);
			medico4.getConsultas().put(fecha11, cita14);
			medico4.getConsultas().put(fecha12, cita15);
			medico4.getConsultas().put(fecha13, cita19);
			medico4.getConsultas().put(fecha14, cita20);
		
			medico1.setSueldo(70000);
			medico2.setSueldo(60000);
			medico3.setSueldo(60000);
			medico4.setSueldo(80000);
			
			TreeMap<LocalDateTime, Pago> nominaMedico1 = new TreeMap<LocalDateTime, Pago>();
			nominaMedico1.put(nomina9, new Pago(1, (int) medico1.getSueldo(), medico1, true));
			nominaMedico1.put(nomina10, new Pago(2, (int) medico1.getSueldo(), medico1, true));
			
			TreeMap<LocalDateTime, Pago> nominaMedico2 = new TreeMap<LocalDateTime, Pago>();
			nominaMedico2.put(nomina9, new Pago(3, (int) medico2.getSueldo(), medico2, true));
			nominaMedico2.put(nomina10, new Pago(4, (int) medico2.getSueldo(), medico2, false));
			
			TreeMap<LocalDateTime, Pago> nominaMedico3 = new TreeMap<LocalDateTime, Pago>();
			nominaMedico3.put(nomina9, new Pago(5, (int) medico3.getSueldo(), medico3, true));
			nominaMedico3.put(nomina10, new Pago(6, (int) medico3.getSueldo(), medico3, true));
			
			TreeMap<LocalDateTime, Pago> nominaMedico4 = new TreeMap<LocalDateTime, Pago>();
			nominaMedico4.put(nomina9, new Pago(7, (int) medico4.getSueldo(), medico4, true));
			nominaMedico4.put(nomina10, new Pago(8, (int) medico4.getSueldo(), medico4, false));
			
			medico1.setNomina(nominaMedico1);
			medico2.setNomina(nominaMedico2);
			medico3.setNomina(nominaMedico3);
			medico4.setNomina(nominaMedico4);
			
			consultorio1.getConsultas().put(fecha1, cita1);
			consultorio1.getConsultas().put(fecha2, null);
			consultorio1.getConsultas().put(fecha3, null);
			consultorio1.getConsultas().put(fecha4, cita6);
			consultorio1.getConsultas().put(fecha5, cita11);
			consultorio1.getConsultas().put(fecha6, cita16);
			consultorio1.getConsultas().put(fecha7, null);
			consultorio1.getConsultas().put(fecha8, null);
			consultorio1.getConsultas().put(fecha9, null);
			consultorio1.getConsultas().put(fecha10, null);
			consultorio1.getConsultas().put(fecha11, null);
			consultorio1.getConsultas().put(fecha12, null);
			consultorio1.getConsultas().put(fecha13, null);
			consultorio1.getConsultas().put(fecha14, null);
			
			consultorio2.getConsultas().put(fecha1, cita2);
			consultorio2.getConsultas().put(fecha2, cita3);
			consultorio2.getConsultas().put(fecha3, null);
			consultorio2.getConsultas().put(fecha4, cita7);
			consultorio2.getConsultas().put(fecha5, cita8);
			consultorio2.getConsultas().put(fecha6, null);
			consultorio2.getConsultas().put(fecha7, null);
			consultorio2.getConsultas().put(fecha8, null);
			consultorio2.getConsultas().put(fecha9, null);
			consultorio2.getConsultas().put(fecha10, null);
			consultorio2.getConsultas().put(fecha11, null);
			consultorio2.getConsultas().put(fecha12, null);
			consultorio2.getConsultas().put(fecha13, null);
			consultorio2.getConsultas().put(fecha14, null);
			
			consultorio3.getConsultas().put(fecha1, null);
			consultorio3.getConsultas().put(fecha2, null);
			consultorio3.getConsultas().put(fecha3, null);
			consultorio3.getConsultas().put(fecha4, null);
			consultorio3.getConsultas().put(fecha5, cita18);
			consultorio3.getConsultas().put(fecha6, null);
			consultorio3.getConsultas().put(fecha7, null);
			consultorio3.getConsultas().put(fecha8, cita12);
			consultorio3.getConsultas().put(fecha9, cita13);
			consultorio3.getConsultas().put(fecha10, cita17);
			consultorio3.getConsultas().put(fecha11, null);
			consultorio3.getConsultas().put(fecha12, null);
			consultorio3.getConsultas().put(fecha13, null);
			consultorio3.getConsultas().put(fecha14, null);
			
			consultorio4.getConsultas().put(fecha1, null);
			consultorio4.getConsultas().put(fecha2, cita4);
			consultorio4.getConsultas().put(fecha3, cita5);
			consultorio4.getConsultas().put(fecha4, null);
			consultorio4.getConsultas().put(fecha5, null);
			consultorio4.getConsultas().put(fecha6, cita9);
			consultorio4.getConsultas().put(fecha7, cita10);
			consultorio4.getConsultas().put(fecha8, null);
			consultorio4.getConsultas().put(fecha9, null);
			consultorio4.getConsultas().put(fecha10, null);
			consultorio4.getConsultas().put(fecha11, cita14);
			consultorio4.getConsultas().put(fecha12, cita15);
			consultorio4.getConsultas().put(fecha13, cita19);
			consultorio4.getConsultas().put(fecha14, cita20);
			

			paciente1.getConsultas().put(fecha1, cita1);
			paciente1.getConsultas().put(fecha5, cita8);
			paciente1.getConsultas().put(fecha12, cita15);
			
			paciente2.getConsultas().put(fecha5, cita11);
			paciente2.getConsultas().put(fecha8, cita12);
			
			paciente3.getConsultas().put(fecha4, cita6);
			paciente3.getConsultas().put(fecha10, cita17);
			paciente3.getConsultas().put(fecha14, cita20);
			
			Administrador.pacientes.add(paciente1);
			Administrador.pacientes.add(paciente2);
			Administrador.pacientes.add(paciente3);
			
			
			Administrador.medicos.add(medico1);
			Administrador.medicos.add(medico2);
			Administrador.medicos.add(medico3);
			Administrador.medicos.add(medico4);
			
			Administrador.consultorios.add(consultorio1);
			Administrador.consultorios.add(consultorio2);
			Administrador.consultorios.add(consultorio3);
			Administrador.consultorios.add(consultorio4);		
			
			Administrador.fechas.add(fecha1);
			Administrador.fechas.add(fecha2);
			Administrador.fechas.add(fecha3);
			Administrador.fechas.add(fecha4);
			Administrador.fechas.add(fecha5);
			Administrador.fechas.add(fecha6);
			Administrador.fechas.add(fecha7);
			Administrador.fechas.add(fecha8);
			Administrador.fechas.add(fecha9);
			Administrador.fechas.add(fecha10);
			Administrador.fechas.add(fecha11);
			Administrador.fechas.add(fecha12);
			Administrador.fechas.add(fecha13);
			Administrador.fechas.add(fecha14);
			Administrador.fechas.add(nomina9);
			Administrador.fechas.add(nomina10);
			
			
			pacientes.add(paciente1);
			pacientes.add(paciente2);
			pacientes.add(paciente3);
			
			
			medicos.add(medico1);
			medicos.add(medico2);
			medicos.add(medico3);
			medicos.add(medico4);
			
			consultorios.add(consultorio1);
			consultorios.add(consultorio2);
			consultorios.add(consultorio3);
			consultorios.add(consultorio4);		
			
			fechas.add(fecha1);
			fechas.add(fecha2);
			fechas.add(fecha3);
			fechas.add(fecha4);
			fechas.add(fecha5);
			fechas.add(fecha6);
			fechas.add(fecha7);
			fechas.add(fecha8);
			fechas.add(fecha9);
			fechas.add(fecha10);
			fechas.add(fecha11);
			fechas.add(fecha12);
			fechas.add(fecha13);
			fechas.add(fecha14);
			fechas.add(nomina9);
			fechas.add(nomina10);
			
	 }
	public static void main(String[] args) {
		
		
		
		loop: while(true) {
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|	Bienvenido a su Sistema Médico		  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|	Elija a que apartado desea acceder	  |%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("+-------------------------------------------------+%n");
			System.out.format("|		1. Citas			  |%n");
			System.out.format("|		2. Exámenes			  |%n");
			System.out.format("|		3. Finanzas			  |%n");
			System.out.format("|		4. Resultados y Medicamentos	  |%n");
			System.out.format("|		5. Administración		  |%n");
			System.out.format("|		0. Salir del sistema		  |%n");
			System.out.format("+-------------------------------------------------+%n");
			
			
//			System.out.println("-------------------------------------" + "\n"+
//			"Bienvenido a su Sistema Médico" + "\n"+
//			"-------------------------------------" + "\n"+
//			"Elija a que Apartado Desea Acceder: " + "\n"+
//			"1. Citas"  + "\n"+
//			"2. Exámenes"+ "\n"+
//			"3. Finanzas"+ "\n"+
//			"4. Resultados y Medicamentos"+ "\n"+
//			"5. Administración	"+ "\n"+
//			"0. Salir del sistema"+ "\n");
					
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
		System.out.format("+-------------------------------------------------+%n");
		System.out.format("|		Escoja una opción  		  |%n");
		System.out.format("+-------------------------------------------------+%n");
		System.out.format("+-------------------------------------------------+%n");
		System.out.format("|		1. Solicitar cita		  |%n");
		System.out.format("|		2. Reagendar cita		  |%n");
		System.out.format("+-------------------------------------------------+%n");

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
				break;
			case 2:
				month = Month.FEBRUARY;
				break;
			case 3:
				month = Month.MARCH;
				break;
			case 4:
				month = Month.APRIL;
				break;
			case 5:
				month = Month.MAY;
				break;
			case 6:
				month = Month.JUNE;
				break;
			case 7:
				month = Month.JULY;
				break;
			case 8:
				month = Month.AUGUST;
				break;
			case 9:
				month = Month.SEPTEMBER;
				break;
			case 10:
				month = Month.OCTOBER;
				break;
			case 11:
				month = Month.NOVEMBER;
				break;
			case 12:
				month = Month.DECEMBER;
				break;
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
			tipoMedico tipoMed = null;
			
			switch(tipo) {
			case GENERAL:
				tipoMed = tipoMedico.GENERAL;
				break;
			case PRIORITARIA:
				tipoMed = tipoMedico.GENERAL;
				break;
			case OPTOMETRIA:
				tipoMed = tipoMedico.OPTOMETRIA;
				break;
			case AUDIOMETRIA:
				tipoMed = tipoMedico.FONOAUDIOLOGO;
				break;
			case PEDIATRIA:
				tipoMed = tipoMedico.PEDIATRA;
				break;
			case LABORATORIO:
				tipoMed = tipoMedico.BACTERIOLOGO;
				break;
			}
			
			System.out.println("¿Cuál es el motivo de su cita?");
			String motivo = sc.next();
			System.out.println(paciente.pedirCita(fecha, tipo, motivo, tipoMed));
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
			
			System.out.println("Inserte el id de la cita que desea modificar");
			int idCita = sc.nextInt();
			System.out.println("Inserte nueva fecha de su cita: ");
			System.out.println("Año: ");
			year = sc.nextInt();
			System.out.println("Mes (en numero): ");
			mes = sc.nextInt();
			month = null;
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
			dia = sc.nextInt();
			System.out.println("Ahora inserte la hora, primero la hora y luego los minutos.");
			System.out.println("Hora: ");
			hora = sc.nextInt();
			System.out.println("Minutos: ");
			min = sc.nextInt();
			//Se formatea la fecha
			fecha = LocalDateTime.of(year, month,dia, hora, min);
			String out = paciente.reagendarCita(idCita, fecha);
			System.out.println(out);
			
			System.out.println("¿Desea continuar en la sección de citas?");
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
		}
	}
	static void solicitarExamen() {
		//System.out.println(medicos);
		//System.out.println(Administrador.medicos);
		/*	Colocar esto en Main para testing
		medicos = new ArrayList<Medico>();
		consultorios = new ArrayList<Consultorio>();
		pacientes = new ArrayList<Paciente>();
		fechas = new ArrayList<LocalDateTime>();
		LocalDateTime fecha1 = LocalDateTime.of(2022, 10, 15, 12, 30);
		LocalDateTime fecha2 = LocalDateTime.of(2022, 10, 15, 13, 00);
		LocalDateTime fecha3 = LocalDateTime.of(2022, 10, 16, 12, 30);
		LocalDateTime fecha4 = LocalDateTime.of(2022, 10, 16, 13, 00);
		Cita cita1 = new Cita(null, "Un laboratorio", null, null, fecha1, tipoCita.laboratorio);
		Cita cita2 = new Cita(null, "Revisión visual", null, null, fecha2, tipoCita.Optometria);
		Cita cita3 = new Cita(null, "Problemas visuales", null, null, fecha1, tipoCita.Optometria);
		Paciente paciente1 = new Paciente( "Juan",  "Pérez",  tipoDocumento.CEDULA,  1000,  23,
				 "masculino",  245687523,  "juanper@gmail.com",  "Carrera 68 # 54",  "Sura" , true);
		
		Medico medico1 = new Medico("Susana", "Perez", tipoDocumento.CEDULA, 1000758374, 25, "Mujer", 1000758374, 
				"susper@gmail.com", "Cra 77 #45 04", tipoCita.General, tipoMedico.Bacteriologo ,true);
		Medico medico2 = new Medico("Andres", "Lopez", tipoDocumento.CEDULA, 1254687950, 29, "Hombre", 1254687950, 
				"andlop@gmail.com", "Calle 113 #55 05", tipoCita.General, tipoMedico.Optometra, true);
		Medico medico3 = new Medico("Mariana", "Garcia", tipoDocumento.CEDULA, 656502354, 28, "Mujer", 656502354, 
				"margar@gmail.com", "Avenida 7 #8 07", tipoCita.General, tipoMedico.Pediatra, true);
		medico1.getConsultas().put(fecha1, cita1);
		medico1.getConsultas().put(fecha2, null);
		medico1.getConsultas().put(fecha3, null);
		medico1.getConsultas().put(fecha4, null);
		
		medico2.getConsultas().put(fecha1, cita3);
		medico2.getConsultas().put(fecha2, cita2);
		medico2.getConsultas().put(fecha3, null);
		medico2.getConsultas().put(fecha4, null);
		
		medico3.getConsultas().put(fecha1, null);
		medico3.getConsultas().put(fecha2, null);
		medico3.getConsultas().put(fecha3, null);
		medico3.getConsultas().put(fecha4, null);
		
		medicos.add(medico1);
		medicos.add(medico2);
		medicos.add(medico3);
		
		Consultorio consultorio1 = new Consultorio(null, null, "Laboratorio", true);
		Consultorio consultorio2 = new Consultorio(null, null, "Consultorio Optometría", true);
		Consultorio consultorio3 = new Consultorio(null, null, "Consultorio Optometría", true);
		
		consultorio1.getConsultas().put(fecha1, cita1);
		consultorio1.getConsultas().put(fecha2, null);
		consultorio1.getConsultas().put(fecha3, null);
		consultorio1.getConsultas().put(fecha4, null);
		
		consultorio2.getConsultas().put(fecha1, cita3);
		consultorio2.getConsultas().put(fecha2, cita2);
		consultorio2.getConsultas().put(fecha3, null);
		consultorio2.getConsultas().put(fecha4, null);
		
		consultorio3.getConsultas().put(fecha1, null);
		consultorio3.getConsultas().put(fecha2, null);
		consultorio3.getConsultas().put(fecha3, null);
		consultorio3.getConsultas().put(fecha4, null);
		
		consultorios.add(consultorio1);
		consultorios.add(consultorio2);
		consultorios.add(consultorio3);
		
		pacientes.add(paciente1);
		fechas.add(fecha1);
		fechas.add(fecha2);
		fechas.add(fecha3);
		fechas.add(fecha4);
		*/
		
		/* 	Documento = 1000
			Se pueden agendar 3 exámenes ya sea de Sangre, Laboratorio o Citoquímico y estos se agendarán con la médica Susana Pérez
			No se puede agendar examen de Rayos X por disponibilidad médica
		*/
		
		//codigo para solicitar examen
		// Paciente
		// Medico especialista bacteriólogo
		// Medico especialista optometra
		// Fechas
		// Consultas
		// Agregar consultas a medicos
		// Agregar consultas a consultorios
		
		System.out.format("+-------------------------------------------------+%n");
		System.out.format("|		Bienvenido a exámenes  		  |%n");
		System.out.format("+-------------------------------------------------+%n");
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
		System.out.format("+-------------------------------------------------------+%n");
		System.out.format("|	Escoja el tipo de examen que desea solicitar	|%n");
		System.out.format("+-------------------------------------------------------+%n");
		System.out.format("+-------------------------------------------------------+%n");
		System.out.format("|		1. Sangre			  	|%n");
		System.out.format("|		2. Laboratorio				|%n");
		System.out.format("|		3. Rayos X			  	|%n");
		System.out.format("|		4. Citoquímico		  	  	|%n");
		System.out.format("|		5. Ir hacia atrás			|%n");
		System.out.format("+-------------------------------------------------------+%n");
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
		
		tipoExamen tipoEx = null;
		tipoMedico tipoMed = null;
		//System.out.println(tipoEx);
		//System.out.println(tipoMed);
		do {
            opcion = sc.nextInt();
        } while (opcion != 1 && opcion != 2 && opcion != 3 && opcion != 4 && opcion != 5);
	
		switch(opcion) {
		case 1:
			tipoEx = tipoExamen.SANGRE;
			tipoMed = tipoMedico.BACTERIOLOGO;
			break;
		case 2:
			tipoEx = tipoExamen.LABORATORIO;
			tipoMed = tipoMedico.BACTERIOLOGO;
			break;
		case 3:
			tipoEx = tipoExamen.RAYOSX;
			tipoMed = tipoMedico.GENERAL;
			break;
		case 4: 
			tipoEx = tipoExamen.CITOQUIMICO;
			tipoMed = tipoMedico.BACTERIOLOGO;
			break;
		case 5:
			main(null);
			break;
		}
		//System.out.println(tipoEx);
		//System.out.println(tipoMed);
		//System.out.println(medicos);
		System.out.println("A continuación se procederá a autorizar su examen");
		Examen examen = new Examen((int)(Math.random()*10000+1), paciente, tipoEx, false);
		int solicitudExamen = paciente.solicitarExamen(examen, tipoMed, medicos);
		// Autorizar el examen
		if (solicitudExamen == 1) {
			System.out.println("Examen autorizado con éxito");
			// Buscar fecha más cercana con disponibilidad
			LocalDateTime fechaExamen = Administrador.verificarDisponibilidadFechaExamen(fechas, tipoMed, medicos, consultorios);
			if(fechaExamen == null) {
				System.out.println("Lo sentimos, en este momento no tenemos disponibilidad");
				solicitarExamen();
			}
			else {
				System.out.println("La fecha más cercana es: " + fechaExamen + ". ¿Desea agendar la cita en esta fecha?");
				System.out.println("1. Sí");
				System.out.println("2. No");
				do {
		            
		            opcion = sc.nextInt();
		        } while (opcion != 1 & opcion != 2);
				switch(opcion) {
				case 1:
					// Agendar examen
					System.out.println(medicos);
					System.out.println(Administrador.asignarExamen(examen, paciente, medicos, consultorios, fechaExamen, tipoMed));
					System.out.println("¿Desea solicitar otro examen?");
					System.out.println("Si la respuesta es sí, presione 1");
					System.out.println("Si desea volver al menu principal, presione 2");
					opcion = sc.nextInt();
					switch(opcion) {
					case 1:
						solicitarExamen();
					case 2:
						main(null);
						break;
					}
				case 2:
					// Pedirle una fecha al paciente
					System.out.println("Inserte los siguientes datos para agendar su examen");
					System.out.println("Año: ");
					int year = sc.nextInt();
					System.out.println("Mes (en número): ");
					int mes;
					do {
			            
			            mes = sc.nextInt();
			        } while (mes != 1 & mes != 2 & mes != 3 & mes != 4 & mes != 5 & mes != 6 & mes != 7 & mes != 8 & mes != 9 & mes != 10 & mes != 11 & mes != 12);
					Month month = null;
					switch (mes) {
					case 1:
						month = Month.JANUARY;
						break;
					case 2:
						month = Month.FEBRUARY;
						break;
					case 3:
						month = Month.MARCH;
						break;
					case 4:
						month = Month.APRIL;
						break;
					case 5:
						month = Month.MAY;
						break;
					case 6:
						month = Month.JUNE;
						break;
					case 7:
						month = Month.JULY;
						break;
					case 8:
						month = Month.AUGUST;
						break;
					case 9:
						month = Month.SEPTEMBER;
						break;
					case 10:
						month = Month.OCTOBER;
						break;
					case 11:
						month = Month.NOVEMBER;
						break;
					case 12:
						month = Month.DECEMBER;
						break;
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
					System.out.println(Administrador.asignarExamen(examen, paciente, medicos, consultorios, fechaExamen, tipoMed));
					System.out.println("¿Desea solicitar otro examen?");
					System.out.println("Si la respuesta es sí, presione 1");
					System.out.println("Si desea volver al menu principal, presione 2");
					opcion = sc.nextInt();
					switch(opcion) {
					case 1:
						solicitarExamen();
					case 2:
						main(null);
						break;
					}
				}
			}
		}
		
		else if (solicitudExamen == 2) {
			System.out.println("Lo sentimos ha ocurrido un problema y no se ha podido autorizar el examen");
			solicitarExamen();
			
		}
		else {
			System.out.println("Lo sentimos, en este momento no tenemos médicos que puedan atender su tipo de examen");
			solicitarExamen();
			
		}
		
		
		
		
		
	}

	static void finanzas() {

		/*
		 * Administrador admin = new Administrador(123, "Julian");
		 * //Administrador.dinero = 100000;
		 * 
		 * Paciente paciente1 = new Paciente("Nancy", "Gutierrez", tipoDocumento.CEDULA,
		 * 1212, 25, "Mujer", 7589, "nanguti@gmail.com", "Calle 88b #54", null, null,
		 * null, new TreeMap<LocalDateTime, Consulta>(), new TreeMap<LocalDateTime,
		 * Entrega>(), false);
		 * 
		 * LocalDateTime fecha1 = LocalDateTime.of(2022, 10, 2, 00, 00); LocalDateTime
		 * fecha2 = LocalDateTime.of(2022, 10, 3, 00, 00); LocalDateTime fecha3 =
		 * LocalDateTime.of(2022, 10, 5, 00, 00);
		 * 
		 * Medico medico1 = new Medico("Ana", "Marin", tipoDocumento.CEDULA, 5671, 45,
		 * "Mujer", 3128, "Anamarin@gmail.com", "Carrera 34 #03", tipoCita.GENERAL,
		 * tipoMedico.GENERAL, true, null, null, 50000, null);
		 * 
		 * Medico medico2 = new Medico("Juan", "Gomez", tipoDocumento.CEDULA, 3416, 45,
		 * "Hombre", 3128, "Anamarin@gmail.com", "Carrera 34 #03", tipoCita.GENERAL,
		 * tipoMedico.GENERAL, true, null, null, 50000, null);
		 * 
		 * Consultorio consultorio1 = new Consultorio(medico1, paciente1, "xd", true);
		 * Consultorio consultorio2 = new Consultorio(medico2, paciente1, "xd", true);
		 * 
		 * Cita cita1 = new Cita(paciente1, "gripa", medico1, consultorio1, fecha1,
		 * tipoCita.GENERAL); Cita cita2 = new Cita(paciente1, "gripa", medico2,
		 * consultorio2, fecha2, tipoCita.GENERAL); Cita cita3 = new Cita(paciente1,
		 * "gripa", medico1, consultorio1, fecha3, tipoCita.GENERAL);
		 * 
		 * cita1.setPago(new Pago(15000, false)); cita2.setPago(new Pago(15000, false));
		 * cita3.setPago(new Pago(15000, false));
		 * 
		 * paciente1.getConsultas().put(fecha1, cita1);
		 * paciente1.getConsultas().put(fecha2, cita2);
		 * paciente1.getConsultas().put(fecha3, cita3);
		 * 
		 * pacientes.add(paciente1);
		 * 
		 * Entrega entrega1 = new Entrega(paciente1, "Calle 88b #54", null,
		 * estadoEntrega.EN_CAMINO); Entrega entrega2 = new Entrega(paciente1,
		 * "Calle 88b #54", null, estadoEntrega.EN_CAMINO);
		 * 
		 * paciente1.getEntregas().put(fecha1, entrega1);
		 * paciente1.getEntregas().put(fecha2, entrega2); entrega1.setPago(new
		 * Pago(10000, false)); entrega2.setPago(new Pago(10000, false));
		 */

		//Se pide el documento de identidad para buscar el paciente
		System.out.println("\n"+"Inserte su documento de identidad: ");
		long id = sc.nextLong();
		Paciente paciente = null;

		for (int i = 0; i < pacientes.size(); i++) {
			if (id == pacientes.get(i).getNumeroDocumento()) {
				paciente = pacientes.get(i);
			}
		}

		System.out.format("+-------------------------------------------------------+%n");
		System.out.format("|	Escoja la accion que desea realizar		|%n");
		System.out.format("+-------------------------------------------------------+%n");
		System.out.format("+-------------------------------------------------------+%n");
		System.out.format("|		1. Pagar consultas		  	|%n");
		System.out.format("|		2. Pagar entregas			|%n");
		System.out.format("|		3. Consultar dinero disponibles	  	|%n");
		System.out.format("|		4. Pago de nomina	  	  	|%n");
		System.out.format("|		5. Ir hacia atrás			|%n");
		System.out.format("+-------------------------------------------------------+%n");
		

		opcion = sc.nextInt();
		
		switch (opcion){

		case 1:
		
			ArrayList<Consulta>consultas_paciente= new ArrayList<>(paciente.getConsultas().values());
				//System.out.println("\n");
			while(true) {

				for (Consulta c: consultas_paciente) {
					if (c.getPago().isPagado() == false) {
						System.out.println("La consulta numero " + c.getId() + " esta sin pagar");
					}
				}
	
				System.out.println("Ingrese el ID de la consulta que desea pagar (Para ir hacia atras ingrese el numero -1): ");
				int id_entrega = sc.nextInt();
				if (id_entrega == -1) {
					finanzas();
				}
	
				else{
					for (Consulta c: consultas_paciente) {
						if (c.getId() == id_entrega) {
							c.getPago().setPagado(true);
							Administrador.sumarDinero(c.getPago().getValor());
							System.out.println("La consulta numero " + c.getId() + " ha sido pagada exitosamente");
						}
					} 
				}
			}
			

		case 2:
			
			ArrayList<Entrega>entregas_paciente=new ArrayList<> (paciente.getEntregas().values());

			while(true) {
				for (Entrega e: entregas_paciente) {
					if (e.getPago().isPagado() == false) {
						System.out.println("La entrega numero " + e.getId() + " esta sin pagar");
					}
				}
	
				System.out.println("Ingrese el ID de la entrega que desea pagar (Para ir hacia atras ingrese el numero -1): ");
				int id_entrega = sc.nextInt();
				if (id_entrega == -1) {
					finanzas();
				}
	
				else {
					for (Entrega e: entregas_paciente) {
						if (e.getId() == id_entrega) {
							e.getPago().setPagado(true);
							Administrador.sumarDinero(e.getPago().getValor());
							System.out.println("La entrega numero " + e.getId() + " ha sido pagada exitosamente");
						}
					}
				}
				 
			}
			 

			
		case 3:

			System.out.println("\n" + "----------------------------------" + "\n"+
			"     Bienvenido Administrador	" + "\n"+
			"----------------------------------" + "\n"+
			"Actualmente el Dinero Disponible es: $" + Administrador.dinero );

			System.out.println("\n" + "Para ir hacia atras ingrese el numero -1 ");
			int opcion = sc.nextInt();
			if (opcion == -1) {
				finanzas();
			} 

		case 4:

			LocalDateTime fecha = LocalDateTime.of(2022, 10, 1, 00, 00);
			for (Medico m: Administrador.medicos) {
				if (m.getNomina().get(fecha).isPagado() == false) {
					System.out.println("El medico " + m.getNombre() + " con documento " + m.getNumeroDocumento() + " no ha recibido su pago desde la fecha " + fecha);
				}
			}

			System.out.println("Ingrese el numero del documento del medico al que le deseas pagar (Para ir hacia atras ingrese el numero -1): ");
			int numeroDocumento = sc.nextInt();
			if (numeroDocumento == -1) {
				finanzas();
			}

			for (Medico m: Administrador.medicos) {
				if(Administrador.dinero < m.getNomina().get(fecha).getValor()) {
					System.out.println("No hay suficiente dinero en el sistema para pagarle al medico " + m.getNombre() + " con documento " + m.getNumeroDocumento() );
				}
				else if (m.getNumeroDocumento() == numeroDocumento) {
					m.getNomina().get(fecha).setPagado(true);
					Administrador.restarDinero(m.getNomina().get(fecha).getValor());
					System.out.println("El medico " + m.getNombre() + " con documento " + m.getNumeroDocumento() + " ha sido pagado exitosamente");
				}
			}

		case 5:
			main(null);
			break;

		}
	}
	
	static void resultados() {
		/*
		 * LocalDateTime fecha = LocalDateTime.of(2022, Month.NOVEMBER, 25, 15,30);
		 * Paciente paciente = new Paciente("Camilo", "Martinez", tipoDocumento.CEDULA,
		 * 1074074689, 25, "masculino", 300762957,"mcm@gmail.com", "cra87#12-34",
		 * "SURA", false); Paciente paciente1 = new Paciente("Maria", "Jaramillo",
		 * tipoDocumento.CEDULA, 9403862, 43, "femenino", 301762849,"mj@gmail.com",
		 * "calle 3", "SURA", false); Medico m1 = new Medico("Sara", "Perez",
		 * tipoDocumento.CEDULA, 12345678, 50, "femenino", 6048742, "sp@yahoo.com",
		 * "calle 43", tipoCita.GENERAL, tipoMedico.GENERAL, true); Medico m2 = new
		 * Medico("Mauricio", "Fernandez", tipoDocumento.CEDULA, 98765432, 60,
		 * "Masculino", 388030284 ,"mp@hotmail.com", "carrera 78", tipoCita.AUDIOMETRIA,
		 * tipoMedico.FONOAUDIOLOGO, true); Medico m3 = new Medico("Carlos", "Munera",
		 * tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284 ,"mp@hotmail.com",
		 * "carrera 78", tipoCita.GENERAL, tipoMedico.GENERAL, true); Consultorio c1 =
		 * new Consultorio(null, null, null, true, fecha, null); Consultorio c2 = new
		 * Consultorio(null, null, null, true, fecha, null); Medicamentos medic = new
		 * Medicamentos(tipoMedicamento.Acetaminofen, paciente, 2, 3); Cita cita = new
		 * Cita(paciente, "gripa", tipoCita.GENERAL); cita.setPago(new Pago(200000,
		 * true)); Diagnostico.sintomas.add("gripa"); Diagnostico dia = new
		 * Diagnostico(paciente, Diagnostico.sintomas, "Dolor de cabeza", medic, 1,
		 * cita); Medico.listado.add(dia);
		 */
			System.out.format("+-------------------------------------------------------+%n");
			System.out.format("|		Escoja una opción			|%n");
			System.out.format("+-------------------------------------------------------+%n");
			System.out.format("+-------------------------------------------------------+%n");
			System.out.format("|		1. Crear diagnostico		  	|%n");
			System.out.format("|		2. Mostrar diagnósticos			|%n");
			System.out.format("|		3. Solicitar entra de medicamentos  	|%n");
			System.out.format("|		4. Ir hacia atrás			|%n");
			System.out.format("+-------------------------------------------------------+%n");
			
			
		opcion = sc.nextInt();
		Scanner input= new Scanner(System.in);
		switch (opcion){
		case 1:
		System.out.println("Por favor dijite la cedula del medico que creara el diagnostico: ");
		int cedula = input.nextInt();
		ArrayList<Medico> medicos = Administrador.medicos;
		int contador = 1;
		for (Medico medico : medicos) {
			if(medico.getNumeroDocumento() == cedula){
				System.out.println("Por favor dijite la cedula del paciente");
				int cedulaPa = input.nextInt();
				Paciente paciente5 = null;
				ArrayList<Paciente> paciente2 = Administrador.pacientes;
				for (Paciente pacientes : paciente2) {
					if (pacientes.getNumeroDocumento() == cedulaPa){
						paciente5=pacientes;
					}
					else{
						System.out.println("El documento del paciente no se encuentra en la base de datos");
						resultados();
					}
				}
					System.out.println("Inserte los siguientes datos para la fecha de la consulta");
					LocalDateTime fechaCita = null;
					System.out.println("Año: ");
					int year = sc.nextInt();
					System.out.println("Mes (en número): ");
					int mes;
					do {
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
					fechaCita = LocalDateTime.of(year, month, day, hour, min);
					Consulta consul = paciente5.getConsultas().get(fechaCita);
				System.out.println("Por favor dijite el medicamento a recetar para el paciente"+ "\n" +
				"-----------------------------------------------------------------"+ "\n" +
				"1. Acetaminofen" + "\n" + 
				"2. Amoxicilina" + "\n" +
				"3. Ibuprofeno"+ "\n" +
				"4. Lagrimas Artificiales");
				tipoMedicamento medicamento = null;
				int  opcion2 = sc.nextInt();
				switch (opcion2){
					case 1:
					medicamento = tipoMedicamento.Acetaminofen;
					case 2:
					medicamento = tipoMedicamento.Amoxicilina;
					case 3:
					medicamento = tipoMedicamento.Ibuprofeno;
					case 4:
					medicamento = tipoMedicamento.LagrimasArtificiales;
				}
				System.out.println("Por favor dijite cuantas dosis recetara al paciente");
				int dosis = input.nextInt();
				System.out.println("Por favor dijite el modo de uso que recomienda al paciente");
				int uso = input.nextInt();
				System.out.println("Por favor dijite los sintomas del paciente");
				String sintomas = input.next();
				ArrayList<String> lista = new ArrayList<String>();
				lista.add(sintomas);
				System.out.println("Por favor dijite la observacion del paciente");
				String observacion = input.next();

				Medicamentos medica = new Medicamentos(medicamento, paciente5, dosis, uso);
				medico.crearDiagnostico(paciente5,lista,observacion,medica,contador, consul);
				contador++;
				System.out.println("El diagnostico ha sido creado con exito");
				resultados();
			}else{
				System.out.println("El docuemto no se encuentra en la base de datos");
				resultados();
			}
			
		}
		case 2:
			System.out.println("Por favor dijite la cedula del paciente: ");
			int cedulaPa1 = input.nextInt();
			Paciente paciente6 = null;
			ArrayList<Paciente> paciente2 = pacientes;
			for (Paciente pacientes : paciente2) {
				if (pacientes.getNumeroDocumento() == cedulaPa1){
					paciente6=pacientes;
				}
				else{
					System.out.println("El documento del paciente no se encuentra en la base de datos");
					resultados();
				}
			}
			ArrayList<HistoriaClinica> histo = HistoriaClinica.historia;
			for (HistoriaClinica historia : histo) {
				if (historia.getPaciente().getNumeroDocumento() == paciente6.getNumeroDocumento()){
					System.out.println(historia.getDiagnosticos());
					resultados();
				}
			}
		break;
			
		case 3:
		System.out.println("Ingrese el documento del paciente: ");
		int docu = input.nextInt();
		ArrayList<Diagnostico> lis = Medico.listado;
		int cont = 1;

		for (Diagnostico medi : lis) {
			if (medi.getPersona().getNumeroDocumento() == (docu)){
				System.out.println("Sus medicamentos son: " + medi.medicamiento.getTipoMed());

				String option;
				while (true) {
					System.out.println("¿Deseas confirmar el envio de medicamentos?");
					System.out.println("1. Si");
					System.out.println("2. No");
					option = input.next();
					if (option.equals("1")) {
						if (medi.getConsulta().getPago().isPagado() == true){
							System.out.println("Por favor ingrese su direccion de domicilio: ");
							String domicilio1 = input.next();
							Entrega.crearEntrega(cont,medi.getPersona(), domicilio1, medi.getMedicamiento(), estadoEntrega.EN_CAMINO);
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
									System.out.println("Se le redirigira al menu de finanzas");
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