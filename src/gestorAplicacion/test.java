package gestorAplicacion;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import gestorAplicacion.personas.Paciente;
import gestorAplicacion.personas.tipoDocumento;
import gestorAplicacion.personas.Administrador;
import gestorAplicacion.personas.Medico;

public class test {

	public static void main(String[] args) {
		Paciente paciente = new Paciente("Camilo", "Martinez", tipoDocumento.CEDULA, 1074074689, 25, "masculino", 300762957,"mcm@gmail.com", "cra87#12-34", "SURA", null, null);
		Paciente paciente1 = new Paciente("Maria", "Jaramillo", tipoDocumento.CEDULA, 9403862, 43, "femenino", 301762849,"mj@gmail.com", "calle 3", "SURA", null, null);
		LocalDateTime fecha = LocalDateTime.of(2022, Month.NOVEMBER, 25, 15,30);
		Medico m1 = new Medico("Sara", "Perez", tipoDocumento.CEDULA, 12345678, 50, "femenino", 6048742, "sp@yahoo.com", "calle 43", tipoCita.General, true);
		Medico m2 = new Medico("Mauricio", "Fernandez", tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284 ,"mp@hotmail.com", "carrera 78", tipoCita.Audiometria, true);
		Medico m3 = new Medico("Carlos", "Munera", tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284 ,"mp@hotmail.com", "carrera 78", tipoCita.General, true);
		Consultorio c1 = new Consultorio(null, null, null, true, fecha, null);
		Consultorio c2 = new Consultorio(null, null, null, true, fecha, null);
		
		System.out.println(paciente1.pedirCita(LocalDateTime.of(2022, Month.NOVEMBER, 25, 15,30), tipoCita.General, null));
		System.out.println(paciente.pedirCita(LocalDateTime.of(2022, Month.NOVEMBER, 25, 16,30), tipoCita.General, null));
		System.out.println(paciente.pedirCita(LocalDateTime.of(2022, Month.NOVEMBER, 25, 16,30), tipoCita.Audiometria, null)); 
		System.out.println(paciente1.reagendarCita(LocalDateTime.of(2022, Month.NOVEMBER, 25, 16,30)));
		System.out.println(c1.consultas);

		
		

	}

}
