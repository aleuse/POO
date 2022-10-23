package gestorAplicacion;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import baseDatos.*;
import gestorAplicacion.*;
import gestorAplicacion.personas.*;
import gestorAplicacion.registrosMedicos.*;

public class test {

	public static void testDisponibilidad() {
		LocalDateTime fecha1 = LocalDateTime.of(2022, 10, 15, 12, 30);
		LocalDateTime fecha2 = LocalDateTime.of(2022, 10, 15, 13, 00);
		LocalDateTime fecha3 = LocalDateTime.of(2022, 10, 16, 12, 30);
		LocalDateTime fecha4 = LocalDateTime.of(2022, 10, 16, 13, 00);

		Medico medico1 = new Medico("Susana", "Perez", tipoDocumento.CEDULA, 1000758374, 25, "Mujer", 1000758374, 
				"susper@gmail.com", "Cra 77 #45 04", tipoCita.General, true);
		Consultorio consultorio1 = new Consultorio(null, null, "Medicina general", true);
		Cita cita1 = new Cita(null, "Porque sí", null, null, fecha1, tipoCita.General);
		Cita cita2 = new Cita(null, "Dolor de estómago", null, null, fecha2, tipoCita.Prioritaria);
		
		medico1.getConsultas().put(fecha1, cita1);
		medico1.getConsultas().put(fecha2, null);
		medico1.getConsultas().put(fecha3, null);
		medico1.getConsultas().put(fecha4, null);
		
		System.out.println("El Médico " + medico1.getNombre() + " para el " + fecha1 + " está disponible: " +
				Administrador.verificarDisponibilidadMedico(fecha1, medico1));
		System.out.println("El Médico " + medico1.getNombre() + " para el " + fecha2 + " está disponible: " + 
				Administrador.verificarDisponibilidadMedico(fecha2, medico1));
		
		consultorio1.getConsultas().put(fecha1, cita1);
		consultorio1.getConsultas().put(fecha2, null);
		consultorio1.getConsultas().put(fecha3, null);
		consultorio1.getConsultas().put(fecha4, null);
		
		System.out.println("El Consultorio " + consultorio1.getId()+ " para el " + fecha1 + " está disponible: " +
				Administrador.verificarDisponibilidadConsultorio(fecha1, consultorio1));
		System.out.println("El Consultorio " + consultorio1.getId()+ " para el " + fecha2 + " está disponible: " +
				Administrador.verificarDisponibilidadConsultorio(fecha2, consultorio1));
		
		System.out.println("----------------------------------------------------------------------");
		
		medico1.getConsultas().put(fecha2, cita2);
		consultorio1.getConsultas().put(fecha2, cita2);
		
		System.out.println("El Médico " + medico1.getNombre() + " para el " + fecha1 + " está disponible: " +
				Administrador.verificarDisponibilidadMedico(fecha1, medico1));
		System.out.println("El Médico " + medico1.getNombre() + " para el " + fecha2 + " está disponible: " + 
				Administrador.verificarDisponibilidadMedico(fecha2, medico1));
		
		System.out.println("El Consultorio " + consultorio1.getId()+ " para el " + fecha1 + " está disponible: " +
				Administrador.verificarDisponibilidadConsultorio(fecha1, consultorio1));
		System.out.println("El Consultorio " + consultorio1.getId()+ " para el " + fecha2 + " está disponible: " +
				Administrador.verificarDisponibilidadConsultorio(fecha2, consultorio1));
	}
	
	public static void testExamen() {
		LocalDateTime fecha1 = LocalDateTime.of(2022, 10, 15, 12, 30);
		LocalDateTime fecha2 = LocalDateTime.of(2022, 10, 15, 13, 00);
		LocalDateTime fecha3 = LocalDateTime.of(2022, 10, 16, 12, 30);
		LocalDateTime fecha4 = LocalDateTime.of(2022, 10, 16, 13, 00);
		Cita cita1 = new Cita(null, "Porque sí", null, null, fecha1, tipoCita.General);
		Cita cita2 = new Cita(null, "Dolor de estómago", null, null, fecha2, tipoCita.Prioritaria);
		Cita cita3 = new Cita(null, "Diarrea", null, null, fecha1, tipoCita.Prioritaria);
		Paciente paciente1 = new Paciente();
		
		Medico medico1 = new Medico("Susana", "Perez", tipoDocumento.CEDULA, 1000758374, 25, "Mujer", 1000758374, 
				"susper@gmail.com", "Cra 77 #45 04", tipoCita.General, true);
		Medico medico2 = new Medico("Andres", "Lopez", tipoDocumento.CEDULA, 1254687950, 29, "Hombre", 1254687950, 
				"andlop@gmail.com", "Calle 113 #55 05", tipoCita.General, true);
		Medico medico3 = new Medico("Mariana", "Garcia", tipoDocumento.CEDULA, 656502354, 28, "Mujer", 656502354, 
				"margar@gmail.com", "Avenida 7 #8 07", tipoCita.General, true);
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
		
		Medico.medicos.add(medico1);
		Medico.medicos.add(medico2);
		Medico.medicos.add(medico3);
		
		Consultorio consultorio1 = new Consultorio(null, null, "Medicina general", true);
		Consultorio consultorio2 = new Consultorio(null, null, "Medicina general", true);
		Consultorio consultorio3 = new Consultorio(null, null, "Medicina general", true);
		
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
		
		Consultorio.consultorios.add(consultorio1);
		Consultorio.consultorios.add(consultorio2);
		Consultorio.consultorios.add(consultorio3);
		
		System.out.println(paciente1.solicitarExamen(tipoExamen.Sangre, fecha1));
		System.out.println(Administrador.verificarDisponibilidadConsultorio(fecha1, consultorio3));
		System.out.println(Administrador.verificarDisponibilidadMedico(fecha1, medico3));
		System.out.println("----------------------------------------------------------------------");
		System.out.println(paciente1.solicitarExamen(tipoExamen.Laboratorio, fecha3));
		System.out.println("Consultorio1, Medico1");
		System.out.println(Administrador.verificarDisponibilidadConsultorio(fecha3, consultorio1));
		System.out.println(Administrador.verificarDisponibilidadMedico(fecha3, medico1));
		System.out.println("Consultorio2, Medico2");
		System.out.println(Administrador.verificarDisponibilidadConsultorio(fecha3, consultorio2));
		System.out.println(Administrador.verificarDisponibilidadMedico(fecha3, medico2));
		System.out.println("Consultorio3, Medico3");
		System.out.println(Administrador.verificarDisponibilidadConsultorio(fecha3, consultorio3));
		System.out.println(Administrador.verificarDisponibilidadMedico(fecha3, medico3));
	}
	
	public static void testCitas() {
		LocalDateTime fecha = LocalDateTime.of(2022, Month.NOVEMBER, 25, 15,30);
		 Paciente paciente = new Paciente("Camilo", "Martinez", tipoDocumento.CEDULA, 1074074689, 25, "masculino", 300762957,"mcm@gmail.com", "cra87#12-34", "SURA", false);
			Paciente paciente1 = new Paciente("Maria", "Jaramillo", tipoDocumento.CEDULA, 9403862, 43, "femenino", 301762849,"mj@gmail.com", "calle 3", "SURA", false);
			Medico m1 = new Medico("Sara", "Perez", tipoDocumento.CEDULA, 12345678, 50, "femenino", 6048742, "sp@yahoo.com", "calle 43", 
					tipoCita.General, tipoMedico.General, true);
			Medico m2 = new Medico("Mauricio", "Fernandez", tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284 ,"mp@hotmail.com", "carrera 78", tipoCita.Audiometria, tipoMedico.Fonoaudiologo, true);
			Medico m3 = new Medico("Carlos", "Munera", tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284 ,"mp@hotmail.com", "carrera 78", tipoCita.General, tipoMedico.General, true);
			Consultorio c1 = new Consultorio(null, null, null, true, fecha, null);
			Consultorio c2 = new Consultorio(null, null, null, true, fecha, null);
		
		System.out.println(paciente1.pedirCita(LocalDateTime.of(2022, Month.NOVEMBER, 25, 15,30), tipoCita.General, null));
		System.out.println(paciente.pedirCita(LocalDateTime.of(2022, Month.NOVEMBER, 25, 16,30), tipoCita.General, null));
		System.out.println(paciente.pedirCita(LocalDateTime.of(2022, Month.NOVEMBER, 25, 16,30), tipoCita.Audiometria, null)); 
		System.out.println(paciente1.reagendarCita(LocalDateTime.of(2022, Month.NOVEMBER, 25, 16,30)));
		System.out.println(c1.consultas);
	}
	
	public static void main(String[] args) {
		System.out.println(Medico.medicos);
		System.out.println(Consultorio.consultorios);
		Serializador.main(args);
		System.out.println(Medico.medicos);
		System.out.println(Consultorio.consultorios);
		
		
		// Deserializar administrador
		ArrayList<Administrador> administrador = Deserializador.<Administrador> deserializar("administrador");
		Administrador admin = administrador.get(0);

		// Deserializar fechas
		ArrayList<LocalDateTime> fechas = (Deserializador.<LocalDateTime> deserializar("fechas"));
		LocalDateTime fecha1 = fechas.get(0);
		LocalDateTime fecha2 = fechas.get(1);
		LocalDateTime fecha3 = fechas.get(2);
		LocalDateTime fecha4 = fechas.get(3);

		// Deserializar consultas
		ArrayList<Consulta> consultas = Deserializador.<Consulta> deserializar("consultas");
		Cita cita1 = (Cita) consultas.get(0);
		Cita cita2 = (Cita) consultas.get(1);
		Cita cita3 = (Cita) consultas.get(2);
		        
		// Deserializar pacientes 
		ArrayList<Paciente> pacientes = Deserializador.<Paciente> deserializar("pacientes");
		Paciente paciente1 = pacientes.get(0);
		        
		// Deserializar medicos
		ArrayList<Medico> medicos = Deserializador.<Medico> deserializar("medicos");
		Medico medico1 = medicos.get(0);
		Medico medico2 = medicos.get(1);
		Medico medico3 = medicos.get(2);
		        
		// Deserializar consultorios
		ArrayList<Consultorio> consultorios =  Deserializador.<Consultorio> deserializar("consultorios");
		Consultorio consultorio1 = consultorios.get(0);
		Consultorio consultorio2 = consultorios.get(1);
		Consultorio consultorio3 = consultorios.get(2);
		        
		//System.out.println(administrador);
		//System.out.println(fechas);
		//System.out.println(consultas);
		//System.out.println(pacientes);
		//System.out.println(medicos);
		//System.out.println(consultorios);
		
		
		Medico.medicos.add(medico1);
		Medico.medicos.add(medico2);
		Medico.medicos.add(medico3);
		Consultorio.consultorios.add(consultorio1);
		Consultorio.consultorios.add(consultorio2);
		Consultorio.consultorios.add(consultorio3);
		
		System.out.println(Medico.medicos);
		System.out.println(Consultorio.consultorios);
		        
		System.out.println(paciente1.solicitarExamen(tipoExamen.Sangre, fecha1));
		System.out.println(Administrador.verificarDisponibilidadConsultorio(fecha1, consultorio3));
		System.out.println(Administrador.verificarDisponibilidadMedico(fecha1, medico3));
		System.out.println("----------------------------------------------------------------------");
		System.out.println(paciente1.solicitarExamen(tipoExamen.Laboratorio, fecha3));
		System.out.println("Consultorio1, Medico1");
		System.out.println(Administrador.verificarDisponibilidadConsultorio(fecha3, consultorio1));
		System.out.println(Administrador.verificarDisponibilidadMedico(fecha3, medico1));
		System.out.println("Consultorio2, Medico2");
		System.out.println(Administrador.verificarDisponibilidadConsultorio(fecha3, consultorio2));
		System.out.println(Administrador.verificarDisponibilidadMedico(fecha3, medico2));
		System.out.println("Consultorio3, Medico3");
		System.out.println(Administrador.verificarDisponibilidadConsultorio(fecha3, consultorio3));
		System.out.println(Administrador.verificarDisponibilidadMedico(fecha3, medico3));
		        
		        
		// Serializar administrador
		Serializador.serializar(administrador, "administrador");
		
		// Serializar fechas
		Serializador.serializar(fechas, "fechas");
		        
		// Serializar consultas
		Serializador.serializar(consultas, "consultas");
		        
		// Serializar pacientes
		Serializador.serializar(pacientes, "pacientes");
		        
		// Serializar medicos
		Serializador.serializar(medicos, "medicos");
		        
		// Serializar consultorios
		Serializador.serializar(consultorios, "consultorios");

	}

}
