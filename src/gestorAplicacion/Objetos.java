package gestorAplicacion;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.TreeMap;

import gestorAplicacion.personas.Administrador;
import gestorAplicacion.personas.Medico;
import gestorAplicacion.personas.Paciente;
import gestorAplicacion.personas.tipoDocumento;
import gestorAplicacion.personas.tipoMedico;
import gestorAplicacion.registrosMedicos.Diagnostico;
import gestorAplicacion.registrosMedicos.HistoriaClinica;

public class Objetos {

	public static void main(String[] args) {
		
		// Citas
		LocalDateTime fecha = LocalDateTime.of(2022, Month.NOVEMBER, 25, 15,30);
		Paciente paciente = new Paciente("Camilo", "Martinez", tipoDocumento.CEDULA, 1074074689, 25, "masculino", 300762957,"mcm@gmail.com", "cra87#12-34", "SURA", false);
		Paciente paciente1 = new Paciente("Maria", "Jaramillo", tipoDocumento.CEDULA, 9403862, 43, "femenino", 301762849,"mj@gmail.com", "calle 3", "SURA", false);
		Medico m1 = new Medico("Sara", "Perez", tipoDocumento.CEDULA, 12345678, 50, "femenino", 6048742, "sp@yahoo.com", "calle 43", 
					tipoCita.GENERAL, tipoMedico.GENERAL, true);
		Medico m2 = new Medico("Mauricio", "Fernandez", tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284 ,"mp@hotmail.com", "carrera 78", 
					tipoCita.AUDIOMETRIA, tipoMedico.FONOAUDIOLOGO, true);
		Medico m3 = new Medico("Carlos", "Munera", tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284 ,"mp@hotmail.com", "carrera 78", 
					tipoCita.GENERAL, tipoMedico.GENERAL, true);
		Consultorio c1 = new Consultorio(null, null, null, true, fecha, null);
		Consultorio c2 = new Consultorio(null, null, null, true, fecha, null);
		Consultorio c3 = new Consultorio(null, null, null, true, fecha, null);
		System.out.println(paciente1.pedirCita(LocalDateTime.of(2022, Month.NOVEMBER, 25, 15,30), tipoCita.GENERAL, null));
		System.out.println(paciente.pedirCita(LocalDateTime.of(2022, Month.NOVEMBER, 25, 16,30), tipoCita.GENERAL, null));
		System.out.println(paciente.pedirCita(LocalDateTime.of(2022, Month.NOVEMBER, 25, 16,30), tipoCita.AUDIOMETRIA, null)); 
		int id = Cita.listaCitas.get(0).getId();
		int id2 = Cita.listaCitas.get(1).getId();
		System.out.println(paciente1.reagendarCita(id, LocalDateTime.of(2022, Month.NOVEMBER, 25, 16,30)));
		
		System.out.println(paciente.reagendarCita(id2, LocalDateTime.of(2022, Month.DECEMBER, 25, 20,00)));
		System.out.println(paciente.visualizarDatos());
		System.out.println(paciente3.reagendarCita(id2, LocalDateTime.of(2022, Month.DECEMBER, 25, 20,00)));
		System.out.println(c1.consultas);
		
		
		
		
		// Solicitar exámenes
		Administrador.medicos = new ArrayList<Medico>();
		Administrador.consultorios = new ArrayList<Consultorio>();
		Administrador.pacientes = new ArrayList<Paciente>();
		Administrador.fechas = new ArrayList<LocalDateTime>();
		
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
		Diagnostico diagnostico1 = new Diagnostico(paciente1, Diagnostico.sintomas, "Dolor de cabeza", 2, cita8);
		Diagnostico diagnostico2 = new Diagnostico(paciente1, Diagnostico.sintomas, "Rodilla Rota", 3, cita15);
		ArrayList<Diagnostico> diagnosticos = new ArrayList<>();
		diagnosticos.add(diagnostico1);
		diagnosticos.add(diagnostico2);
		HistoriaClinica historiaClinica = new HistoriaClinica(paciente1, diagnosticos);
		diagnostico1.setPersona(paciente1);
		diagnostico1.setPersona(paciente1);
		paciente1.setHistoriaClinica(historiaClinica);
		
		
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
		
		
		
		// Finanzas
		
		Administrador admin = new Administrador(123, "Julian");
		//Administrador.dinero = 100000;

		Paciente paciente1 = new Paciente("Nancy", "Gutierrez", tipoDocumento.CEDULA,
		1212, 25, "Mujer", 7589, "nanguti@gmail.com", "Calle 88b #54",
		null, null, null, new TreeMap<LocalDateTime, Consulta>(), new TreeMap<LocalDateTime, Entrega>(), false);

		LocalDateTime fecha1 = LocalDateTime.of(2022, 10, 2, 00, 00);
		LocalDateTime fecha2 = LocalDateTime.of(2022, 10, 3, 00, 00);
		LocalDateTime fecha3 = LocalDateTime.of(2022, 10, 5, 00, 00);

		Medico medico1 = new Medico("Ana", "Marin", tipoDocumento.CEDULA,
		5671, 45, "Mujer", 3128, "Anamarin@gmail.com", "Carrera 34 #03",
		tipoCita.GENERAL, tipoMedico.GENERAL, true, null, null, 50000, null);

		Medico medico2 = new Medico("Juan", "Gomez", tipoDocumento.CEDULA,
		3416, 45, "Hombre", 3128, "Anamarin@gmail.com", "Carrera 34 #03",
		tipoCita.GENERAL, tipoMedico.GENERAL, true, null, null, 50000, null);

		Consultorio consultorio1 = new Consultorio(medico1, paciente1, "xd", true);
		Consultorio consultorio2 = new Consultorio(medico2, paciente1, "xd", true);

		Cita cita1 = new Cita(paciente1, "gripa", medico1, consultorio1, fecha1, tipoCita.GENERAL);
		Cita cita2 = new Cita(paciente1, "gripa", medico2, consultorio2, fecha2, tipoCita.GENERAL);
		Cita cita3 = new Cita(paciente1, "gripa", medico1, consultorio1, fecha3, tipoCita.GENERAL);

		cita1.setPago(new Pago(15000, false));
		cita2.setPago(new Pago(15000, false));
		cita3.setPago(new Pago(15000, false));

		paciente1.getConsultas().put(fecha1, cita1);
		paciente1.getConsultas().put(fecha2, cita2);
		paciente1.getConsultas().put(fecha3, cita3);

		pacientes.add(paciente1);

		Entrega entrega1 = new Entrega(paciente1, "Calle 88b #54", null, estadoEntrega.EN_CAMINO);
		Entrega entrega2 = new Entrega(paciente1, "Calle 88b #54", null, estadoEntrega.EN_CAMINO);

		entrega1.setPago(new Pago(10000, false));
		entrega2.setPago(new Pago(10000, false));
		
		paciente1.getEntregas().put(fecha1, entrega1);
		paciente1.getEntregas().put(fecha2, entrega2);
		
		
		
		// Diagnosticos 
		LocalDateTime fecha = LocalDateTime.of(2022, Month.NOVEMBER, 25, 15,30);
		 Paciente paciente = new Paciente("Camilo", "Martinez", tipoDocumento.CEDULA, 1074074689, 25, "masculino", 300762957,"mcm@gmail.com", "cra87#12-34", "SURA", false);
			Paciente paciente1 = new Paciente("Maria", "Jaramillo", tipoDocumento.CEDULA, 9403862, 43, "femenino", 301762849,"mj@gmail.com", "calle 3", "SURA", false);
			Medico m1 = new Medico("Sara", "Perez", tipoDocumento.CEDULA, 12345678, 50, "femenino", 6048742, "sp@yahoo.com", "calle 43", 
					tipoCita.GENERAL, tipoMedico.GENERAL, true);
			Medico m2 = new Medico("Mauricio", "Fernandez", tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284 ,"mp@hotmail.com", "carrera 78", tipoCita.AUDIOMETRIA, tipoMedico.FONOAUDIOLOGO, true);
			Medico m3 = new Medico("Carlos", "Munera", tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284 ,"mp@hotmail.com", "carrera 78", tipoCita.GENERAL, tipoMedico.GENERAL, true);
			Consultorio c1 = new Consultorio(null, null, null, true, fecha, null);
			Consultorio c2 = new Consultorio(null, null, null, true, fecha, null);
			Medicamentos medic = new Medicamentos(tipoMedicamento.Acetaminofen, paciente, 2, 3);
	   		Cita cita = new Cita(paciente, "gripa", tipoCita.GENERAL);
			cita.setPago(new Pago(200000, true));
			Diagnostico.sintomas.add("gripa");
			Diagnostico dia = new Diagnostico(paciente, Diagnostico.sintomas, "Dolor de cabeza", medic, 1, cita);
			Medico.listado.add(dia);
	}

}


