package baseDatos;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import gestorAplicacion.*;
import gestorAplicacion.personas.*;
import gestorAplicacion.registrosMedicos.*;

public class Serializador {

    public static void main(String[] args) { 
        /*-------------------------- Registros iniciales ---------------------------------------*/
        
    	ArrayList<Administrador> administrador = new ArrayList<Administrador>();
        Administrador admin = new Administrador(123, "Samuel García");
        administrador.add(admin);
        serializar(administrador, "administrador");
        
        ArrayList<LocalDateTime> fechas = new ArrayList<LocalDateTime>();
        LocalDateTime fecha1 = LocalDateTime.of(2022, 10, 15, 12, 30);
        fechas.add(fecha1);
		LocalDateTime fecha2 = LocalDateTime.of(2022, 10, 15, 13, 00);
		fechas.add(fecha2);
		LocalDateTime fecha3 = LocalDateTime.of(2022, 10, 16, 12, 30);
		fechas.add(fecha3);
		LocalDateTime fecha4 = LocalDateTime.of(2022, 10, 16, 13, 00);
		fechas.add(fecha4);
		serializar(fechas, "fechas");
		
		ArrayList<Consulta> consultas = new ArrayList<Consulta>();
		Cita cita1 = new Cita(null, "Porque sí", null, null, fecha1, tipoCita.General);
		consultas.add(cita1);
		Cita cita2 = new Cita(null, "Dolor de estómago", null, null, fecha2, tipoCita.Prioritaria);
		consultas.add(cita2);
		Cita cita3 = new Cita(null, "Diarrea", null, null, fecha1, tipoCita.Prioritaria);
		consultas.add(cita3);
		serializar(consultas, "consultas");
		
		ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
		Paciente paciente1 = new Paciente();
		pacientes.add(paciente1);
		serializar(pacientes, "pacientes");
		
		ArrayList<Medico> medicos = new ArrayList<Medico>();
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
		
		medicos.add(medico1);
		medicos.add(medico2);
		medicos.add(medico3);
		serializar(medicos, "medicos");
		
		ArrayList<Consultorio> consultorios = new ArrayList<Consultorio>();
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
		
		consultorios.add(consultorio1);
		consultorios.add(consultorio2);
		consultorios.add(consultorio3);
		
		
        serializar(consultorios, "consultorios");
        
        Medico.medicos = new ArrayList<Medico>();
		Consultorio.consultorios = new ArrayList<Consultorio>();
    }

    public static <E> void serializar(List<E> objetos, String nomClase){
        String path = System.getProperty("user.dir") + "\\src\\baseDatos\\temp\\" + nomClase + ".txt";

        try {
            // Borrar el contenido del archivo
            PrintWriter pw = new PrintWriter(path);
        } catch (FileNotFoundException excepcion) {
        	excepcion.printStackTrace();
        }

        try {

            File archivo = new File(path);
            // Crear un nuevo archivo si no hay uno 
			archivo.createNewFile(); 

            // Se utiliza un FileInputStream para saber dónde serializar los archivos
            FileOutputStream fileOut = new FileOutputStream(path);

            // Se crea un objeto OutputStream para escribir en el archivo
			ObjectOutputStream out = new ObjectOutputStream(fileOut);

            // Se guarda la lista de objetos
			out.writeObject(objetos);
			out.close();
			fileOut.close();

        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
