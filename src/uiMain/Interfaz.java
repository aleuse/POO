package uiMain;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

import baseDatos.Deserializador;
import baseDatos.Serializador;

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

public class Interfaz implements Serializable{
	 private static final long serialVersionUID = 1L;
	public static Scanner sc = new Scanner(System.in);
	 static int opcion;
	 static ArrayList<Paciente> pacientes = Administrador.pacientes;
	 static ArrayList<Medico> medicos = Administrador.medicos;
	 static ArrayList<Consultorio> consultorios = Administrador.consultorios;
	 static ArrayList<LocalDateTime> fechas = Administrador.fechas;
	 static ArrayList<Consulta> consultas = Administrador.consultas;
	 static ArrayList<String> listaSintomas = Administrador.listaSintomas;
	 static ArrayList<Medicamentos> medicamentos = Administrador.medicamentos;
	 static ArrayList<Diagnostico> diagnosticos = Administrador.diagnosticos;
	 static ArrayList<HistoriaClinica> historiasClinicas = Administrador.historiasClinicas;
	 static {
		 	Administrador.medicos = new ArrayList<Medico>();
			Administrador.consultorios = new ArrayList<Consultorio>();
			Administrador.pacientes = new ArrayList<Paciente>();
			Administrador.fechas = new ArrayList<LocalDateTime>();
			Administrador.consultas = new ArrayList<Consulta>();
			Administrador.medicamentos = new ArrayList<Medicamentos>();
			Administrador.diagnosticos = new ArrayList<Diagnostico>();
			Administrador.historiasClinicas = new ArrayList<HistoriaClinica>();
			Administrador.listaSintomas = new ArrayList<String>();
			
			diagnosticos = new ArrayList<Diagnostico>();
			historiasClinicas = new ArrayList<HistoriaClinica>();
			listaSintomas = new ArrayList<String>();
			medicamentos = new ArrayList<Medicamentos>();
			medicos = new ArrayList<Medico>();
			consultorios = new ArrayList<Consultorio>();
			pacientes = new ArrayList<Paciente>();
			fechas = new ArrayList<LocalDateTime>();
			consultas = new ArrayList<Consulta>();
			Serializador.main(null);
			
	 }
	public static void main(String[] args) {
		// Deserialización de los objetos
		// Deserializar administrador
		ArrayList<Administrador> administrador = Deserializador.<Administrador> deserializar("administrador");
		Administrador admin = administrador.get(0);

		// Deserializar fechas
		fechas = (Deserializador.<LocalDateTime> deserializar("fechas"));
		LocalDateTime fecha1 = fechas.get(0);
		LocalDateTime fecha2 = fechas.get(1);
		LocalDateTime fecha3 = fechas.get(2);
		LocalDateTime fecha4 = fechas.get(3);
		LocalDateTime fecha5 = fechas.get(4);
		LocalDateTime fecha6 = fechas.get(5);
		LocalDateTime fecha7 = fechas.get(6);
		LocalDateTime fecha8 = fechas.get(7);
		LocalDateTime fecha9 = fechas.get(8);
		LocalDateTime fecha10 = fechas.get(9);
		LocalDateTime fecha11 = fechas.get(10);
		LocalDateTime fecha12 = fechas.get(11);
		LocalDateTime fecha13 = fechas.get(12);
		LocalDateTime fecha14 = fechas.get(13);
		LocalDateTime nomina9 = fechas.get(14);
		LocalDateTime nomina10 = fechas.get(15);

		// Deserializar consultas
		consultas = Deserializador.<Consulta> deserializar("consultas");
		Cita cita1 = (Cita) consultas.get(0);
		Cita cita2 = (Cita) consultas.get(1);
		Cita cita3 = (Cita) consultas.get(2);
		Cita cita4 = (Cita) consultas.get(3);
		Cita cita5 = (Cita) consultas.get(4);
		Cita cita6 = (Cita) consultas.get(5);
		Cita cita7 = (Cita) consultas.get(6);
		Cita cita8 = (Cita) consultas.get(7);
		Cita cita9 = (Cita) consultas.get(8);
		Cita cita10 = (Cita) consultas.get(9);
		Cita cita11 = (Cita) consultas.get(10);
		Cita cita12 = (Cita) consultas.get(11);
		Cita cita13 = (Cita) consultas.get(12);
		Cita cita14 = (Cita) consultas.get(13);
		Cita cita15 = (Cita) consultas.get(14);
		Cita cita16 = (Cita) consultas.get(15);
		Cita cita17 = (Cita) consultas.get(16);
		Cita cita18 = (Cita) consultas.get(17);
		Cita cita19 = (Cita) consultas.get(18);
		Cita cita20 = (Cita) consultas.get(19);

		// Deserializar pacientes 
		pacientes = Deserializador.<Paciente> deserializar("pacientes");
		Paciente paciente1 = pacientes.get(0);
		Paciente paciente2 = pacientes.get(1);
		Paciente paciente3 = pacientes.get(2);
		pacientes = new ArrayList<Paciente>();

		// Deserializar medicos
		medicos = Deserializador.<Medico> deserializar("medicos");
		Medico medico1 = medicos.get(0);
		Medico medico2 = medicos.get(1);
		Medico medico3 = medicos.get(2);
		Medico medico4 = medicos.get(3);
		Medico medico5 = medicos.get(4);
		Medico medico6 = medicos.get(5);
		Medico medico7 = medicos.get(6);
		Medico medico8 = medicos.get(7);
		Medico medico9 = medicos.get(8);
		medicos = new ArrayList<Medico>();

		// Deserializar consultorios
		consultorios =  Deserializador.<Consultorio> deserializar("consultorios");
		Consultorio consultorio1 = consultorios.get(0);
		Consultorio consultorio2 = consultorios.get(1);
		Consultorio consultorio3 = consultorios.get(2);
		Consultorio consultorio4 = consultorios.get(3);
		Consultorio consultorio5 = consultorios.get(4);
		Consultorio consultorio6 = consultorios.get(5);
		Consultorio consultorio7 = consultorios.get(6);
		Consultorio consultorio8 = consultorios.get(7);
		consultorios = new ArrayList<Consultorio>();
		
		// Deserializar medicamentos
		medicamentos =  Deserializador.<Medicamentos> deserializar("medicamentos");
		Medicamentos medicamento1 = medicamentos.get(0);
		Medicamentos medicamento2 = medicamentos.get(1);
		Medicamentos medicamento3 = medicamentos.get(2);
		
		
		// Deserializar diagnosticos
		diagnosticos =  Deserializador.<Diagnostico> deserializar("diagnosticos");
		Diagnostico diagnostico = diagnosticos.get(0);
		Diagnostico diagnostico1 = diagnosticos.get(1);
		Diagnostico diagnostico2 = diagnosticos.get(2);
		
		// Deserializar lista sintomas
	 	listaSintomas = Deserializador.<String> deserializar("listaSintomas");
	 	Diagnostico.sintomas.add("gripa");
		Diagnostico.sintomas.add("fiebre");
		Diagnostico.sintomas.add("vomito");
		Diagnostico.sintomas.add("mareos");
		Diagnostico.sintomas.add("nauseas");
			
		// Deserializar historias clinicas
		historiasClinicas =  Deserializador.<HistoriaClinica> deserializar("historiasClinicas");
		HistoriaClinica historiaClinica1 = historiasClinicas.get(0);
		HistoriaClinica historiaClinica2 = historiasClinicas.get(1);
		HistoriaClinica historiaClinica3 = historiasClinicas.get(2);
		medico1.getConsultas().put(fecha1, cita1); medico1.getConsultas().put(fecha2,
				  null); medico1.getConsultas().put(fecha3, null);
				  medico1.getConsultas().put(fecha4, cita6); medico1.getConsultas().put(fecha5,
				  cita11); medico1.getConsultas().put(fecha6, cita16);
				  medico1.getConsultas().put(fecha7, null); medico1.getConsultas().put(fecha8,
				  null); medico1.getConsultas().put(fecha9, null);
				  medico1.getConsultas().put(fecha10, null);
				  medico1.getConsultas().put(fecha11, null);
				  medico1.getConsultas().put(fecha12, null);
				  medico1.getConsultas().put(fecha13, null);
				  medico1.getConsultas().put(fecha14, null);
				  
				  medico2.getConsultas().put(fecha1, cita2); medico2.getConsultas().put(fecha2,
				  cita3); medico2.getConsultas().put(fecha3, null);
				  medico2.getConsultas().put(fecha4, cita7); medico2.getConsultas().put(fecha5,
				  cita8); medico2.getConsultas().put(fecha6, null);
				  medico2.getConsultas().put(fecha7, null); medico2.getConsultas().put(fecha8,
				  null); medico2.getConsultas().put(fecha9, null);
				  medico2.getConsultas().put(fecha10, null);
				  medico2.getConsultas().put(fecha11, null);
				  medico2.getConsultas().put(fecha12, null);
				  medico2.getConsultas().put(fecha13, null);
				  medico2.getConsultas().put(fecha14, null);
				  
				  medico3.getConsultas().put(fecha1, null); medico3.getConsultas().put(fecha2,
				  null); medico3.getConsultas().put(fecha3, null);
				  medico3.getConsultas().put(fecha4, null); medico3.getConsultas().put(fecha5,
				  cita18); medico3.getConsultas().put(fecha6, null);
				  medico3.getConsultas().put(fecha7, null); medico3.getConsultas().put(fecha8,
				  cita12); medico3.getConsultas().put(fecha9, cita13);
				  medico3.getConsultas().put(fecha10, cita17);
				  medico3.getConsultas().put(fecha11, null);
				  medico3.getConsultas().put(fecha12, null);
				  medico3.getConsultas().put(fecha13, null);
				  medico3.getConsultas().put(fecha14, null);
				  
				  medico4.getConsultas().put(fecha1, null); medico4.getConsultas().put(fecha2,
				  cita4); medico4.getConsultas().put(fecha3, cita5);
				  medico4.getConsultas().put(fecha4, null); medico4.getConsultas().put(fecha5,
				  null); medico4.getConsultas().put(fecha6, cita9);
				  medico4.getConsultas().put(fecha7, cita10);
				  medico4.getConsultas().put(fecha8, null); medico4.getConsultas().put(fecha9,
				  null); medico4.getConsultas().put(fecha10, null);
				  medico4.getConsultas().put(fecha11, cita14);
				  medico4.getConsultas().put(fecha12, cita15);
				  medico4.getConsultas().put(fecha13, cita19);
				  medico4.getConsultas().put(fecha14, cita20);
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
		Administrador.dinero = 500000;
		Administrador.diagnosticos.add(diagnostico);
		diagnosticos.add(diagnostico);
		Administrador.diagnosticos.add(diagnostico1);
		diagnosticos.add(diagnostico1);
		Administrador.diagnosticos.add(diagnostico2);
		diagnosticos.add(diagnostico2);
		
		Administrador.medicamentos.add(medicamento1);
		Administrador.medicamentos.add(medicamento2);
		Administrador.medicamentos.add(medicamento3);
		medicamentos.add(medicamento1);
		medicamentos.add(medicamento2);
		medicamentos.add(medicamento3);		
		
		historiasClinicas.add(historiaClinica1);
		historiasClinicas.add(historiaClinica2);
		historiasClinicas.add(historiaClinica3);
		Administrador.historiasClinicas.add(historiaClinica1);
		Administrador.historiasClinicas.add(historiaClinica2);
		Administrador.historiasClinicas.add(historiaClinica3);
		
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
		
		Administrador.consultas.add(cita1);
		Administrador.consultas.add(cita2);
		Administrador.consultas.add(cita3);
		Administrador.consultas.add(cita4);
		Administrador.consultas.add(cita5);
		Administrador.consultas.add(cita6);
		Administrador.consultas.add(cita7);
		Administrador.consultas.add(cita8);
		Administrador.consultas.add(cita9);
		Administrador.consultas.add(cita10);
		Administrador.consultas.add(cita11);
		Administrador.consultas.add(cita12);
		Administrador.consultas.add(cita13);
		Administrador.consultas.add(cita14);
		Administrador.consultas.add(cita15);
		Administrador.consultas.add(cita16);
		Administrador.consultas.add(cita17);
		Administrador.consultas.add(cita18);
		Administrador.consultas.add(cita19);
		Administrador.consultas.add(cita20);
		
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
		Medico.medicos.add(medico1);
		Medico.medicos.add(medico2);
		Medico.medicos.add(medico3);
		Medico.medicos.add(medico4);
		Medico.medicos.add(medico5);
		Medico.medicos.add(medico6);
		Medico.medicos.add(medico7);
		Medico.medicos.add(medico8);
		Medico.medicos.add(medico9);
		
		consultorios.add(consultorio1);
		consultorios.add(consultorio2);
		consultorios.add(consultorio3);
		consultorios.add(consultorio4);	
		Consultorio.consultorios.add(consultorio1);
		Consultorio.consultorios.add(consultorio2);
		Consultorio.consultorios.add(consultorio3);
		Consultorio.consultorios.add(consultorio4);
		Consultorio.consultorios.add(consultorio5);
		Consultorio.consultorios.add(consultorio6);
		Consultorio.consultorios.add(consultorio7);
		Consultorio.consultorios.add(consultorio8);
		
		consultas.add(cita1);
		consultas.add(cita2);
		consultas.add(cita3);
		consultas.add(cita4);
		consultas.add(cita5);
		consultas.add(cita6);
		consultas.add(cita7);
		consultas.add(cita8);
		consultas.add(cita9);
		consultas.add(cita10);
		consultas.add(cita11);
		consultas.add(cita12);
		consultas.add(cita13);
		consultas.add(cita14);
		consultas.add(cita15);
		consultas.add(cita16);
		consultas.add(cita17);
		consultas.add(cita18);
		consultas.add(cita19);
		consultas.add(cita20);
		
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
		
		Cita.listaCitas.add(cita1);
		Cita.listaCitas.add(cita2);
		Cita.listaCitas.add(cita3);
		Cita.listaCitas.add(cita4);
		Cita.listaCitas.add(cita5);
		Cita.listaCitas.add(cita6);
		Cita.listaCitas.add(cita7);
		Cita.listaCitas.add(cita8);
		Cita.listaCitas.add(cita9);
		Cita.listaCitas.add(cita10);
		Cita.listaCitas.add(cita11);
		Cita.listaCitas.add(cita12);
		Cita.listaCitas.add(cita13);
		Cita.listaCitas.add(cita14);
		Cita.listaCitas.add(cita15);
		Cita.listaCitas.add(cita16);
		Cita.listaCitas.add(cita17);
		Cita.listaCitas.add(cita18);
		Cita.listaCitas.add(cita19);
		Cita.listaCitas.add(cita20);
		
		Entrega.lista.add(paciente1.getEntregas().get(fecha10));
		Entrega.lista.add(paciente1.getEntregas().get(fecha11));
		Entrega.lista.add(paciente2.getEntregas().get(fecha13));
		Entrega.lista.add(paciente3.getEntregas().get(fecha14));
		ArrayList<Diagnostico> diagnosticos1 = new ArrayList<Diagnostico>();
		ArrayList<Diagnostico> diagnosticos2 = new ArrayList<Diagnostico>();
		ArrayList<Diagnostico> diagnosticos3 = new ArrayList<Diagnostico>();
		historiaClinica1.setPaciente(paciente1);
		historiaClinica2.setPaciente(paciente2);
		historiaClinica3.setPaciente(paciente3);
		historiaClinica1.setDiagnosticos(diagnosticos1);
		historiaClinica2.setDiagnosticos(diagnosticos2);
		historiaClinica3.setDiagnosticos(diagnosticos3);
		diagnosticos1.add(diagnostico);
		diagnosticos2.add(diagnostico1);
		diagnosticos3.add(diagnostico2);
		diagnostico.setPersona(paciente1);
		paciente1.setHistoriaClinica(historiaClinica1);
		diagnostico1.setPersona(paciente2);
		paciente2.setHistoriaClinica(historiaClinica2);
		diagnostico2.setPersona(paciente3);
		paciente3.setHistoriaClinica(historiaClinica3);
		
		opcion = -1; 
		
		do {
			System.out.format("+-------------------------------------------------+%n");
            System.out.println("                  (0 0)           ");
            System.out.println("          ---oOO-- (_) ----oOO---        ");
            System.out.println("  ╔════════════════════════════════════════╗   ");
            System.out.println("  ║ Bienveniedo al Sistema Medico! ♥  ║   ");
            System.out.println("  ╚════════════════════════════════════════╝   ");
            System.out.println("           -------------------           ");
            System.out.println("                 |__|__|       ");
            System.out.println("                  || ||   ");
            System.out.println("                 ooO Ooo");
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
			opcion = sc.nextInt();
			
			 switch (opcion) {
			 	case 1: //Citas
			 		int opcion2 = -1;
			 		do {
			 			System.out.format("+-------------------------------------------------+%n");
						System.out.format("|		Escoja una opción  		  |%n");
						System.out.format("+-------------------------------------------------+%n");
						System.out.format("+-------------------------------------------------+%n");
						System.out.format("|		1. Solicitar cita		  |%n");
						System.out.format("|		2. Reagendar cita		  |%n");
						System.out.format("|		0. Atrás			  |%n");
						System.out.format("+-------------------------------------------------+%n");
						opcion2 = sc.nextInt();
						
						switch(opcion2) {
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
									tipoMed = tipoMedico.OPTOMETRA;
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
								break;
								
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
								break;
						}
			 		}while(opcion2 != 0);					
			 		break;
			 		
			 	case 2: //Exámenes
			 		int opcion3 = -1;
			 		int opcion4 = -1;
			 		int opcion5 = -1;
			 		do {
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
						System.out.format("|		0. Ir hacia atrás			|%n");
						System.out.format("+-------------------------------------------------------+%n");
						
						tipoExamen tipoEx = null;
						tipoMedico tipoMed = null;
						Examen examen;
						int solicitudExamen;
						do {
				            opcion4 = sc.nextInt();
				            switch(opcion4) {
							case 1:
								tipoEx = tipoExamen.SANGRE;
								tipoMed = tipoMedico.BACTERIOLOGO;
								System.out.println("A continuación se procederá a autorizar su examen");
								examen = new Examen((int)(Math.random()*10000+1), paciente, tipoEx, false);
								solicitudExamen = paciente.solicitarExamen(examen, tipoMed, medicos);
								// Autorizar el examen
								if (solicitudExamen == 1) {
									System.out.println("Examen autorizado con éxito");
									// Buscar fecha más cercana con disponibilidad
									LocalDateTime fechaExamen = Administrador.verificarDisponibilidadFechaExamen(fechas, tipoMed, medicos, consultorios);
									if(fechaExamen == null) {
										System.out.println("Lo sentimos, en este momento no tenemos disponibilidad");
										break;
									}
									else {
										System.out.println("La fecha más cercana es: " + fechaExamen + ". ¿Desea agendar la cita en esta fecha?");
										System.out.println("1. Sí");
										System.out.println("2. No");
										do {
											opcion5 = sc.nextInt();
								        } while (opcion5 != 1 & opcion5 != 2);
										switch(opcion5) {
										case 1:
											// Agendar examen
											System.out.println(Administrador.asignarExamen(examen, paciente, medicos, consultorios, fechaExamen, tipoMed, tipoEx));
											break;
											
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
											System.out.println(Administrador.asignarExamen(examen, paciente, medicos, consultorios, fechaExamen, tipoMed, tipoEx));
											break;
										}
										
									}			
									
								}
								else if (solicitudExamen == 2) {
									System.out.println("Lo sentimos ha ocurrido un problema y no se ha podido autorizar el examen");
									break;
									
								}
								else {
									System.out.println("Lo sentimos, en este momento no tenemos médicos que puedan atender su tipo de examen");
									break;
									
								}
								break;
							case 2:
								tipoEx = tipoExamen.LABORATORIO;
								tipoMed = tipoMedico.BACTERIOLOGO;
								System.out.println("A continuación se procederá a autorizar su examen");
								examen = new Examen((int)(Math.random()*10000+1), paciente, tipoEx, false);
								solicitudExamen = paciente.solicitarExamen(examen, tipoMed, medicos);
								// Autorizar el examen
								if (solicitudExamen == 1) {
									System.out.println("Examen autorizado con éxito");
									// Buscar fecha más cercana con disponibilidad
									LocalDateTime fechaExamen = Administrador.verificarDisponibilidadFechaExamen(fechas, tipoMed, medicos, consultorios);
									if(fechaExamen == null) {
										System.out.println("Lo sentimos, en este momento no tenemos disponibilidad");
										break;
									}
									else {
										System.out.println("La fecha más cercana es: " + fechaExamen + ". ¿Desea agendar la cita en esta fecha?");
										System.out.println("1. Sí");
										System.out.println("2. No");
										do {
											opcion5 = sc.nextInt();
								        } while (opcion5 != 1 & opcion5 != 2);
										switch(opcion5) {
										case 1:
											// Agendar examen
											System.out.println(Administrador.asignarExamen(examen, paciente, medicos, consultorios, fechaExamen, tipoMed, tipoEx));
											break;
											
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
											System.out.println(Administrador.asignarExamen(examen, paciente, medicos, consultorios, fechaExamen, tipoMed, tipoEx));
											break;
										}
										
									}			
									
								}
								else if (solicitudExamen == 2) {
									System.out.println("Lo sentimos ha ocurrido un problema y no se ha podido autorizar el examen");
									break;
									
								}
								else {
									System.out.println("Lo sentimos, en este momento no tenemos médicos que puedan atender su tipo de examen");
									break;
									
								}
								break;
							case 3:
								tipoEx = tipoExamen.RAYOSX;
								tipoMed = tipoMedico.GENERAL;
								
								System.out.println("A continuación se procederá a autorizar su examen");
								examen = new Examen((int)(Math.random()*10000+1), paciente, tipoEx, false);
								solicitudExamen = paciente.solicitarExamen(examen, tipoMed, medicos);
								// Autorizar el examen
								if (solicitudExamen == 1) {
									System.out.println("Examen autorizado con éxito");
									// Buscar fecha más cercana con disponibilidad
									LocalDateTime fechaExamen = Administrador.verificarDisponibilidadFechaExamen(fechas, tipoMed, medicos, consultorios);
									if(fechaExamen == null) {
										System.out.println("Lo sentimos, en este momento no tenemos disponibilidad");
										break;
									}
									else {
										System.out.println("La fecha más cercana es: " + fechaExamen + ". ¿Desea agendar la cita en esta fecha?");
										System.out.println("1. Sí");
										System.out.println("2. No");
										do {
											opcion5 = sc.nextInt();
								        } while (opcion5 != 1 & opcion5 != 2);
										switch(opcion5) {
										case 1:
											// Agendar examen
											System.out.println(Administrador.asignarExamen(examen, paciente, medicos, consultorios, fechaExamen, tipoMed, tipoEx));
											break;
											
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
											System.out.println(Administrador.asignarExamen(examen, paciente, medicos, consultorios, fechaExamen, tipoMed, tipoEx));
											break;
										}
										
									}			
									
								}
								else if (solicitudExamen == 2) {
									System.out.println("Lo sentimos ha ocurrido un problema y no se ha podido autorizar el examen");
									break;
									
								}
								else {
									System.out.println("Lo sentimos, en este momento no tenemos médicos que puedan atender su tipo de examen");
									break;
									
								}
								break;
							case 4: 
								tipoEx = tipoExamen.CITOQUIMICO;
								tipoMed = tipoMedico.BACTERIOLOGO;
								
								System.out.println("A continuación se procederá a autorizar su examen");
								examen = new Examen((int)(Math.random()*10000+1), paciente, tipoEx, false);
								solicitudExamen = paciente.solicitarExamen(examen, tipoMed, medicos);
								// Autorizar el examen
								if (solicitudExamen == 1) {
									System.out.println("Examen autorizado con éxito");
									// Buscar fecha más cercana con disponibilidad
									LocalDateTime fechaExamen = Administrador.verificarDisponibilidadFechaExamen(fechas, tipoMed, medicos, consultorios);
									if(fechaExamen == null) {
										System.out.println("Lo sentimos, en este momento no tenemos disponibilidad");
										break;
									}
									else {
										System.out.println("La fecha más cercana es: " + fechaExamen + ". ¿Desea agendar la cita en esta fecha?");
										System.out.println("1. Sí");
										System.out.println("2. No");
										do {
											opcion5 = sc.nextInt();
								        } while (opcion5 != 1 & opcion5 != 2);
										switch(opcion5) {
										case 1:
											// Agendar examen
											System.out.println(Administrador.asignarExamen(examen, paciente, medicos, consultorios, fechaExamen, tipoMed, tipoEx));
											break;
											
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
											System.out.println(Administrador.asignarExamen(examen, paciente, medicos, consultorios, fechaExamen, tipoMed, tipoEx));
											break;
										}
										
									}			
									
								}
								else if (solicitudExamen == 2) {
									System.out.println("Lo sentimos ha ocurrido un problema y no se ha podido autorizar el examen");
									break;
									
								}
								else {
									System.out.println("Lo sentimos, en este momento no tenemos médicos que puedan atender su tipo de examen");
									break;
									
								}
								break;
							}
				            
				            
				        } while (opcion4 != 1 && opcion4 != 2 && opcion4 != 3 && opcion4 != 4 && opcion4 != 0);
						break;
						
			 		}while(opcion3 != 0);
			 		break;
			 		
			 	case 3: //Finanzas
			 		int opcion6 = -1;
			 		int opcion7 = -1;
			 		do {
			 			System.out.format("+-------------------------------------------------+%n");
						System.out.format("|		Bienvenido a Finanzas  		  |%n");
						System.out.format("+-------------------------------------------------+%n");
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
			 			System.out.format("|		0. Ir hacia atrás			|%n");
			 			System.out.format("+-------------------------------------------------------+%n");
			 			opcion6 = sc.nextInt();
			 			
			 			do {			 				
			 				switch(opcion6) {
				 				case 1:
				 					ArrayList<Consulta>consultas_paciente= new ArrayList<>(paciente.getConsultas().values());
				 					//System.out.println("\n");
				 				while(true) {

				 					for (Consulta c: consultas_paciente) {
				 						if (c.getPago().isPagado() == false) {
				 							System.out.println("La consulta numero " + c.getId() + " esta sin pagar");
				 						}
				 					}
				 		
				 					System.out.println("Ingrese el ID de la consulta que desea pagar (Para ir hacia atras ingrese el numero 0): ");
				 					opcion7 = sc.nextInt();
				 					if (opcion7 == 0) {
				 						break;
				 					}
				 		
				 					else{
				 						for (Consulta c: consultas_paciente) {
				 							if (c.getId() == opcion7) {
				 								c.getPago().setPagado(true);
				 								Administrador.sumarDinero(c.getPago().getValor());
				 								System.out.println("La consulta numero " + c.getId() + " ha sido pagada exitosamente");
				 								}
				 							} 
				 						}
				 					}
				 				
				 					break;
				 					
				 				case 2:
				 					ArrayList<Entrega>entregas_paciente=new ArrayList<> (paciente.getEntregas().values());

				 					while(paciente.getEntregas().values().size() > 0) {
				 						for (Entrega e: entregas_paciente) {
				 							if (e.getPago().isPagado() == false) {
				 								System.out.println("La entrega numero " + e.getId() + " esta sin pagar");
				 							}
				 						}
				 			
				 						System.out.println("Ingrese el ID de la entrega que desea pagar (Para ir hacia atras ingrese el numero 0): ");
				 						opcion7 = sc.nextInt();
				 						if (opcion7 == 0) {
				 							break;
				 						}
				 			
				 						else {
				 							for (Entrega e: entregas_paciente) {
				 								if (e.getId() == opcion7) {
				 									e.getPago().setPagado(true);
				 									Administrador.sumarDinero(e.getPago().getValor());
				 									System.out.println("La entrega numero " + e.getId() + " ha sido pagada exitosamente");
				 										}
				 									}
				 								}	 
				 							}
				 					
				 					break;
				 					
				 				case 3: 
				 					System.out.println("\n" + "----------------------------------" + "\n"+
				 							"     Bienvenido Administrador	" + "\n"+
				 							"----------------------------------" + "\n"+
				 							"Actualmente el Dinero Disponible es: $" + Administrador.dinero );

				 							System.out.println("\n" + "Para ir hacia atras ingrese el numero 0 ");
				 							opcion7 = sc.nextInt();
				 							if (opcion7 == 0) {
				 								break;
				 							} 
				 							
				 					break;
				 				
				 				case 4:
				 					LocalDateTime fecha = LocalDateTime.of(2022, 10, 1, 00, 00);
				 					for (Medico m: Administrador.medicos) {
				 						if (m.getNomina().get(fecha).isPagado() == false) {
				 							System.out.println("El medico " + m.getNombre() + " con documento " + m.getNumeroDocumento() + " no ha recibido su pago desde la fecha " + fecha);
				 						}
				 					}

				 					System.out.println("Ingrese el numero del documento del medico al que le deseas pagar (Para ir hacia atras ingrese el numero 0): ");
				 					opcion7 = sc.nextInt();
				 					if (opcion7 == 0) {
				 						break;
				 					}

				 					for (Medico m: Administrador.medicos) {
				 						if(Administrador.dinero < m.getNomina().get(fecha).getValor()) {
				 							System.out.println("No hay suficiente dinero en el sistema para pagarle al medico " + m.getNombre() + " con documento " + m.getNumeroDocumento() );
				 						}
				 						else if (m.getNumeroDocumento() == opcion7) {
				 							m.getNomina().get(fecha).setPagado(true);
				 							Administrador.restarDinero(m.getNomina().get(fecha).getValor());
				 							System.out.println("El medico " + m.getNombre() + " con documento " + m.getNumeroDocumento() + " ha sido pagado exitosamente");
				 						}
				 					}
				 					
				 					break;
			 				}
			 				
			 			}while(opcion7 != 0);
			 			break;
			 			
			 		}while(opcion6 != 0);
			 		break;
			 		
			 	case 4: //Resultados y Medicamentos
			 		
			 		int opcion8 = -1;
			 		do {
			 			System.out.format("+-------------------------------------------------------+%n");
						System.out.format("|		Escoja una opción			|%n");
						System.out.format("+-------------------------------------------------------+%n");
						System.out.format("+-------------------------------------------------------+%n");
						System.out.format("|		1. Crear diagnostico		  	|%n");
						System.out.format("|		2. Mostrar diagnósticos			|%n");
						System.out.format("|		3. Solicitar entrega de medicamentos  	|%n");
						System.out.format("|		0. Ir hacia atrás			|%n");
						System.out.format("+-------------------------------------------------------+%n");
						opcion8 = sc.nextInt();
						
						switch(opcion8) {
							case 1:
								System.out.println("Por favor dijite la cedula del medico que creara el diagnostico: ");
								int cedulaMed = sc.nextInt();
								ArrayList<Medico> lista_medicos = medicos;
								int contador = 1;
								for (Medico medico : lista_medicos) {
									if(medico.getNumeroDocumento() == cedulaMed){
										System.out.println("Por favor dijite la cedula del paciente");
										int cedulaPa = sc.nextInt();
										Paciente pacienteX = null;
										ArrayList<Paciente> lista_pacientes = pacientes;
										for (Paciente paciente : lista_pacientes) {
											if (paciente.getNumeroDocumento() == cedulaPa){
												pacienteX=paciente;
											}
										}
										if(pacienteX == null){
											System.out.println("El documento del paciente no se encuentra en la base de datos");
											break;
										}
											System.out.println("Inserte los siguientes datos para la fecha de la consulta");
											LocalDateTime fechaCitaX = null;
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
											fechaCitaX = LocalDateTime.of(year, month, day, hour, min);
											Consulta consultaX = pacienteX.getConsultas().get(fechaCitaX);
										System.out.println("Por favor dijite el medicamento a recetar para el paciente"+ "\n" +
										"-----------------------------------------------------------------"+ "\n" +
										"1. Acetaminofen" + "\n" + 
										"2. Amoxicilina" + "\n" +
										"3. Ibuprofeno"+ "\n" +
										"4. Lagrimas Artificiales");
										tipoMedicamento tipoMedica = null;
										int  opcion9 = sc.nextInt();
										switch (opcion9){
											case 1:
												tipoMedica = tipoMedicamento.Acetaminofen;
												break;
											case 2:
												tipoMedica = tipoMedicamento.Amoxicilina;
												break;
											case 3:
												tipoMedica = tipoMedicamento.Ibuprofeno;
												break;
											case 4:
												tipoMedica = tipoMedicamento.LagrimasArtificiales;
												break;
										}
										System.out.println("Por favor dijite cuantas dosis recetara al paciente");
										int dosis = sc.nextInt();
										System.out.println("Por favor dijite el modo de uso que recomienda al paciente");
										int uso = sc.nextInt();
										System.out.println("Por favor dijite los sintomas del paciente");
										String sintomas = sc.next();
										listaSintomas.add(sintomas);
										System.out.println("Por favor dijite la observacion del paciente");
										String observacion = sc.next();
										Medicamentos medicamentoX = new Medicamentos(tipoMedica, pacienteX, dosis, uso);
										medico.crearDiagnostico(pacienteX,listaSintomas,observacion,medicamentoX,contador, consultaX);
										contador++;
										System.out.println("El diagnostico ha sido creado con exito");
										break;
									}
									
									
								}
								break;
								
							case 2:
								System.out.println("Por favor dijite la cedula del paciente: ");
								int cedulaPaX = sc.nextInt();
								Paciente pacienteX = null;
								
								for (Paciente paciente : pacientes) {
									if (paciente.getNumeroDocumento() == cedulaPaX){
										pacienteX = paciente;
										break;
									}
								}
								if(pacienteX == null){
									System.out.println("El documento del paciente no se encuentra en la base de datos");
									break;
								}
								ArrayList<Diagnostico> listaDiagnosticosX = pacienteX.getHistoriaClinica().getDiagnosticos();
								for (Diagnostico diagnosticoX : listaDiagnosticosX) {
									System.out.format("+-------------------------------------------------------+%n");
									System.out.println("El nombre y apellido del paciente es: " + diagnosticoX.getPersona().getNombre() + " " +diagnosticoX.getPersona().getApellido()+ "\n"+
									"Su observacion fue: "+ diagnosticoX.getObservacion() + "\n"+
									"Se reporto con los siguientes sintomas: ");
									for (int i = 0; i < diagnosticoX.getSintomas().size(); i++) {
										System.out.println(diagnosticoX.getSintomas().get(i) + " ");
									} 
									System.out.println("Su consulta fue en la fecha: "+ diagnosticoX.getConsulta().getFecha()+ "\n"+
									"Su medico fue: "+ diagnosticoX.getConsulta().getMedico().getNombre()+ " " + diagnosticoX.getConsulta().getMedico().getApellido() );
									System.out.format("+-------------------------------------------------------+%n");
								}
								break;
								
							case 3:
								System.out.println("Ingrese el documento del paciente: ");
								int cedulaX = sc.nextInt();
								ArrayList<Diagnostico> lista_diagnosticos = Medico.listado;
								int cont = 1;

								for (Diagnostico diagnosticoX : lista_diagnosticos) {
									if (diagnosticoX.getPersona().getNumeroDocumento() == (cedulaX)){
										System.out.println("Sus medicamentos son: " + diagnosticoX.medicamiento.getTipoMed());

										int option;
										while (true) {
											System.out.println("¿Deseas confirmar el envio de medicamentos?");
											System.out.println("1. Si");
											System.out.println("2. No");
											option = sc.nextInt();
											if (option == 1) {
												if (diagnosticoX.getConsulta().getPago().isPagado() == true){
													System.out.println("Por favor ingrese su direccion de domicilio: ");
													String domicilio1 = sc.next();
													Entrega.crearEntrega(cont,diagnosticoX.getPersona(), domicilio1, diagnosticoX.getMedicamiento(), estadoEntrega.EN_CAMINO);
													cont++;
													Medicamentos.asignarMed(diagnosticoX.medicamiento.getTipoMed(), 1);
													System.out.println("El proceso ha sido exitoso");
													//break;
												}
												else if (diagnosticoX.getConsulta().getPago().isPagado() == false){
													System.out.println("Debes pagar la consulta antes de pedir los medicamentos");
													break;
												}
												break;
											}
											else if (option == 2) {
												break;
											}
										}
										break;
									}
									else{
										System.out.println("El documento no se encuentara en la base de datos");
						                break;
										
									}
								}
								
								
								break;
						}
						
			 		}while(opcion8 != 0);
			 		
			 		break;
			 		
			 	case 5: //Administración
			 		int opcion10 = -1;
			 		int opcion11 = -1;
			 		int opcion12 = -1;
			 		System.out.println("Datos del sistema");
			        System.out.println("Se tiene un total de " + Administrador.medicos.size() + " medicos y " + Administrador.consultorios.size() + " consultorios");
			        System.out.println("Se han atendido a " + Administrador.pacientes.size() + " pacientes");
			        System.out.println("Y se ha facturado hasta ahora " + "$"+ Administrador.dinero);
			        System.out.println("--------------------------------------");
			        System.out.println("Desea visualizar las citas, examanes y entregas realizadas? [1]si  [0]no");
			        do {
			            System.out.print("Ingrese una opcion valida: ");
			            opcion10 = sc.nextInt();
			        } while (opcion10 != 1 & opcion10 != 0);
			        if (opcion10 == 1) {
			            System.out.println("Citas realizadas");
			            int cant = Cita.informeCitas(tipoCita.GENERAL);
			            int costoUnitario = (tipoCita.GENERAL.getValorCita());
			            System.out.println("General: " + cant + " citas recaudando $" + cant * costoUnitario );

			            cant = Cita.informeCitas(tipoCita.PRIORITARIA);
			            costoUnitario = (tipoCita.PRIORITARIA.getValorCita());
			            System.out.println("Prioritaria: " + cant + " citas recaudando $" + cant * costoUnitario );

			            cant = Cita.informeCitas(tipoCita.OPTOMETRIA);
			            costoUnitario = (tipoCita.OPTOMETRIA.getValorCita());
			            System.out.println("Optometría: " + cant + " citas recaudando $" + cant * costoUnitario );

			            cant = Cita.informeCitas(tipoCita.AUDIOMETRIA);
			            costoUnitario = (tipoCita.AUDIOMETRIA.getValorCita());
			            System.out.println("Audiometria: " + cant + " citas recaudando $" + cant * costoUnitario );

			            cant = Cita.informeCitas(tipoCita.LABORATORIO);
			            costoUnitario = (tipoCita.LABORATORIO.getValorCita());
			            System.out.println("laboratorio: " + cant + " citas recaudando $" + cant * costoUnitario );

			            cant = Cita.informeCitas(tipoCita.PEDIATRIA);
			            costoUnitario = (tipoCita.PEDIATRIA.getValorCita());
			            System.out.println("Pediatria: " + cant + " citas recaudando $" + cant * costoUnitario );
			            System.out.println("--------------------------------------");

			            System.out.println("Examenes realizados");
			            cant = Examen.informeExamenes(tipoExamen.SANGRE);
			            costoUnitario = (tipoExamen.SANGRE.getValorExamen());
			            System.out.println("Sangre: " + cant + " examenes recaudando $" + cant * costoUnitario );

			            cant = Examen.informeExamenes(tipoExamen.LABORATORIO);
			            costoUnitario = (tipoExamen.LABORATORIO.getValorExamen());
			            System.out.println("Laboratorio: " + cant + " examenes recaudando $" + cant * costoUnitario );

			            cant = Examen.informeExamenes(tipoExamen.RAYOSX);
			            costoUnitario = (tipoExamen.RAYOSX.getValorExamen());
			            System.out.println("Rayos X: " + cant + " examenes recaudando $" + cant * costoUnitario );

			            cant = Examen.informeExamenes(tipoExamen.CITOQUIMICO);
			            costoUnitario = (tipoExamen.CITOQUIMICO.getValorExamen());
			            System.out.println("Citoquimico: " + cant + " examenes recaudando $" + cant * costoUnitario );
			            System.out.println("--------------------------------------");

			            System.out.println("Estado de las entrega");
			            cant = Entrega.informeEntregas(estadoEntrega.PROCESADA);
			            System.out.println("Procesada: " + cant + " entregas");

			            cant = Entrega.informeEntregas(estadoEntrega.EN_CAMINO);
			            System.out.println("En camino: " + cant + " entregas");

			            cant = Entrega.informeEntregas(estadoEntrega.REALIZADA);
			            System.out.println("Realizada: " + cant + " entregas");
			        }

			        do {
			        	System.out.println("--------------------------------------");
				        System.out.println("Con el dinero obtenido hasta ahora " +  "$" + Administrador.dinero + " se puede:");
				        System.out.println("1. Contratar más medicos");
				        System.out.println("2. Adquirir más consultorios");
				        System.out.println("3. Comprar más medicamentos");
				        System.out.println("0. No utilizar el dinero");
				        System.out.println();
				        System.out.println("¿Que desea hacer?");
				        opcion11 = sc.nextInt();
				        
				        switch(opcion11) {
				        	case 1:
				        		System.out.println("Se tiene un total de " + Administrador.medicos.size() + " medicos");

				                System.out.println("Que especialista desea contratar");
				                System.out.println("1. General");
				                System.out.println("2. Optometra");
				                System.out.println("3. Fonoaudiologo");
				                System.out.println("4. Pediatra");
				                System.out.println("5. Bacteriologo");

				                do {
				                    System.out.print("Ingrese un numero valido: ");
				                    opcion12 = sc.nextInt();
				                } while (opcion12 != 1 & opcion12 != 2 & opcion12 != 3 & opcion12 != 4 & opcion12 != 5);
				                int nuevosMedicos;
				                int mn;
				                tipoMedico nuevo;
				                switch (opcion12) {
				                    case 1:
				                        nuevo = tipoMedico.GENERAL;
				                        break;
				                    case 2:
				                        nuevo = tipoMedico.OPTOMETRA;
				                        break;
				                    case 3:
				                        nuevo = tipoMedico.FONOAUDIOLOGO;
				                        break;
				                    case 4:
				                        nuevo = tipoMedico.PEDIATRA;
				                        break;
				                    default:
				                        nuevo = tipoMedico.BACTERIOLOGO;
				                        break;
				                }
				                System.out.println("¿Cuantos medicos de especialidad " + nuevo + " desea contratar?");
				                System.out.print("Ingrese un numero: ");
				                nuevosMedicos = sc.nextInt();
				                mn = 0;
				                for (int i = 0; i < nuevosMedicos; i++) {
				                    double x = Math.random();
				                    if (x > 0.3) {
				                        
				                        for (Medico contrato : Medico.medicos) {
				                            if (contrato.isContratado() == false) {// si no está contratado
				                                mn++;
				                                contrato.setContratado(true);
				                                Administrador.medicos.add(contrato);
				                                break;
				                            }
				                        }

				                    }
				                }
				                if (mn > 0) {
				                    System.out.println("Se han podido contratar " + mn + " especialistas ");
				                    System.out.println("Ahora hay " + Administrador.medicos.size() + " medicos");
				                } else {
				                    System.out.println("No se han podido adquirir nuevos especialistas. Lo sentimos");
				                }
				                
				        		break;
				        	case 2:
				        		int cConsultorio = 100000;
				                System.out.println("Se tiene un total de " + Administrador.consultorios.size() + " consultorios");
				                System.out.println("Actualmente el Dinero Disponible es: $" + Administrador.dinero);
				                System.out.println("Cada consultorio tiene un precio de $" + cConsultorio);
				                System.out.println("¿Cuantos consultorios desea adquirir?");
				                System.out.print("Ingrese un numero: ");
				                int nuevosConsultorios = sc.nextInt();

				                int cn = 0;
				                if (Administrador.dinero < (nuevosConsultorios * cConsultorio)) {
				                    System.out.println("No hay suficiente dinero para comprar " + nuevosConsultorios + " consultorios");
				                    break;
				                } else {
				                    for (int i = 0; i < nuevosConsultorios; i++) {
				                        double x = Math.random();
				                        if (x > 0.4) {
				                            for (Consultorio c : Consultorio.consultorios) {
				                                if (c.isDisponibilidad() == false) {// si no está adquirido
				                                    cn++;
				                                    c.setDisponibilidad(true);
				                                    Administrador.consultorios.add(c);
				                                    break;
				                                }
				                            }
				                        }
				                    }
				                }

				                if (cn > 0) {
				                    Administrador.restarDinero((cn * cConsultorio));
				                    System.out.println("Se han podido adquirir " + cn + " consultorios");
				                    System.out.println("Ahora hay " + Administrador.consultorios.size() + " consultorios");
				                    System.out.println("Actualmente el Dinero Disponible es: $" + Administrador.dinero);
				                } else {
				                    System.out.println("PROBLEMAS EN LA OBRA!!!");
				                    System.out.println("No se han podido adquirir consultorios");
				                }
				                
				        		break;
				        		
				        	case 3:
				        		System.out.println("INVENTARIO MEDICAMENTOS");
				                //ACETAMINOFEN
				                int a = Medicamentos.cantAcetaminofen;
				                tipoMedicamento b = tipoMedicamento.Acetaminofen;
				                int c = b.getValorMed();
				                System.out.println("hay en inventario " + a + " unidades de " + b + " a un precio unitario de: $" + c);
				                System.out.print("¿Cuantos unidades de " + b + " desea comprar? : ");
				                int comprar = sc.nextInt();
				                if (c == 0) {
				                } else if (Administrador.dinero < (comprar * c)) {
				                    System.out.println("ERROR FINANCIERO, dinero insuficiente");
				                } else {
				                    Administrador.restarDinero((comprar * c));
				                    Medicamentos.cantAcetaminofen += comprar;
				                    System.out.println("COMPRA EXITOSA");
				                }

				                //AMOXICILINA
				                a = Medicamentos.cantAmoxicilina;
				                b = tipoMedicamento.Amoxicilina;
				                c = b.getValorMed();
				                System.out.println("hay en inventario " + a + " unidades de " + b + " a un precio unitario de: $" + c);
				                System.out.print("¿Cuantos unidades de " + b + " desea comprar? : ");
				                comprar = sc.nextInt();
				                if (c == 0) {
				                } else if (Administrador.dinero < (comprar * c)) {
				                    System.out.println("ERROR FINANCIERO, dinero insuficiente");
				                } else {
				                    Administrador.restarDinero((comprar * c));
				                    Medicamentos.cantAmoxicilina += comprar;
				                    System.out.println("FELICIDADES POR TU COMPRA");
				                }

				                //IBUPROFENO
				                a = Medicamentos.cantIbuprofeno;
				                b = tipoMedicamento.Ibuprofeno;
				                c = b.getValorMed();
				                System.out.println("hay en inventario " + a + " unidades de " + b + " a un precio unitario de: $" + c);
				                System.out.print("¿Cuantos unidades de " + b + " desea comprar? : ");
				                comprar = sc.nextInt();
				                if (c == 0) {
				                } else if (Administrador.dinero < (comprar * c)) {
				                    System.out.println("ERROR FINANCIERO, dinero insuficiente");
				                } else {
				                    Administrador.restarDinero((comprar * c));
				                    Medicamentos.cantIbuprofeno += comprar;
				                    System.out.println("ENHORABUENA");
				                }

				                //LAGRIMAS ARTIFICIALES
				                a = Medicamentos.cantLagrimasArtificiales;
				                b = tipoMedicamento.LagrimasArtificiales;
				                c = b.getValorMed();
				                System.out.println("hay en inventario " + a + " unidades de " + b + " a un precio unitario de: $" + c);
				                System.out.print("¿Cuantos unidades de " + b + " desea comprar? : ");
				                comprar = sc.nextInt();
				                if (c == 0) {
				                } else if (Administrador.dinero < (comprar * c)) {
				                    System.out.println("ERROR FINANCIERO, dinero insuficiente");
				                } else {
				                    Administrador.restarDinero((comprar * c));
				                    Medicamentos.cantLagrimasArtificiales += comprar;
				                    System.out.println("COMPRA EXITOSA");
				                }

				                System.out.println("--- INVENTARIO ACTUALIZADO ---");
				                System.out.println("hay en inventario " + Medicamentos.cantAcetaminofen + " unidades de " + tipoMedicamento.Acetaminofen);
				                System.out.println("hay en inventario " + Medicamentos.cantAmoxicilina + " unidades de " + tipoMedicamento.Amoxicilina);
				                System.out.println("hay en inventario " + Medicamentos.cantIbuprofeno + " unidades de " + tipoMedicamento.Ibuprofeno);
				                System.out.println("hay en inventario " + Medicamentos.cantLagrimasArtificiales + " unidades de " + tipoMedicamento.LagrimasArtificiales);

				                System.out.println("Actualmente el Dinero Disponible es: $" + Administrador.dinero);

				                System.out.println("--------------------------------------");
				                
				        		break;
				        }
				        
			        }while(opcion11 != 0);
			        
			 		break;
			 		
			 		
			 	default:
                    break;
			 }
			 
			
		} while(opcion != 0);
		// Finalizar el programa
		System.out.println("Se ha terminado");
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
        
        //System.out.println(Medico.medicos);
        	// Serializar administrador
     		Serializador.serializar(administrador, "administrador");

     		// Serializar fechas
     		Serializador.serializar(Administrador.fechas, "fechas");

     		// Serializar consultas
     		Serializador.serializar(Administrador.consultas, "consultas");

     		// Serializar pacientes
     		Serializador.serializar(Administrador.pacientes, "pacientes");

     		// Serializar medicos
     		Serializador.serializar(Medico.medicos, "medicos");

     		// Serializar consultorios
     		Serializador.serializar(Consultorio.consultorios, "consultorios");
     		
     		// Serializar medicamentos
     		Serializador.serializar(Administrador.medicamentos, "medicamentos");
     		
     		// Serializar diagnosticos
     		Serializador.serializar(Administrador.diagnosticos, "diagnosticos");
     		
     		// Serializar historiasClinicas
     		Serializador.serializar(Administrador.historiasClinicas, "historiasClinicas");
        sc.close();
	}
	
	
	
}