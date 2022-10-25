package baseDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
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
	static ArrayList<Paciente> pacientes = Administrador.pacientes;
	 static ArrayList<Medico> medicos = Administrador.medicos;
	 static ArrayList<Consultorio> consultorios = Administrador.consultorios;
	 static ArrayList<LocalDateTime> fechas = Administrador.fechas;
	 static ArrayList<Consulta> consultas = Administrador.consultas;
	 static ArrayList<String> listaSintomas = Administrador.listaSintomas;
	 static ArrayList<Medicamentos> medicamentos = Administrador.medicamentos;
	 static ArrayList<Diagnostico> diagnosticos = Administrador.diagnosticos;
	 static ArrayList<HistoriaClinica> historiasClinicas = Administrador.historiasClinicas;
	 
    public static void main(String[] args) { 
        /*-------------------------- Registros iniciales ---------------------------------------*/
		
		  Administrador.medicos = new ArrayList<Medico>(); Administrador.consultorios =
		  new ArrayList<Consultorio>(); Administrador.pacientes = new
		  ArrayList<Paciente>(); Administrador.fechas = new ArrayList<LocalDateTime>();
		  Administrador.consultas = new ArrayList<Consulta>();
		  Administrador.medicamentos = new ArrayList<Medicamentos>();
		  Administrador.diagnosticos = new ArrayList<Diagnostico>();
		  Administrador.historiasClinicas = new ArrayList<HistoriaClinica>();
		  Administrador.listaSintomas = new ArrayList<String>();
		  
		  diagnosticos = new ArrayList<Diagnostico>(); historiasClinicas = new
		  ArrayList<HistoriaClinica>(); listaSintomas = new ArrayList<String>();
		  medicamentos = new ArrayList<Medicamentos>(); medicos = new
		  ArrayList<Medico>(); consultorios = new ArrayList<Consultorio>(); pacientes =
		  new ArrayList<Paciente>(); fechas = new ArrayList<LocalDateTime>(); consultas
		  = new ArrayList<Consulta>();
		  
		  ArrayList<Administrador> administrador = new ArrayList<Administrador>();
		  Administrador admin = new Administrador(123, "Jaime"); Administrador.dinero =
		  500000; administrador.add(admin);
		  
		  LocalDateTime fecha1 = LocalDateTime.of(2022, 10, 15, 12, 30); LocalDateTime
		  fecha2 = LocalDateTime.of(2022, 10, 15, 13, 00); LocalDateTime fecha3 =
		  LocalDateTime.of(2022, 10, 15, 13, 30); LocalDateTime fecha4 =
		  LocalDateTime.of(2022, 10, 15, 14, 00); LocalDateTime fecha5 =
		  LocalDateTime.of(2022, 10, 15, 14, 30); LocalDateTime fecha6 =
		  LocalDateTime.of(2022, 10, 15, 15, 00); LocalDateTime fecha7 =
		  LocalDateTime.of(2022, 10, 15, 15, 30);
		  
		  LocalDateTime fecha8 = LocalDateTime.of(2022, 10, 16, 12, 30); LocalDateTime
		  fecha9 = LocalDateTime.of(2022, 10, 16, 13, 00); LocalDateTime fecha10 =
		  LocalDateTime.of(2022, 10, 16, 13, 30); LocalDateTime fecha11 =
		  LocalDateTime.of(2022, 10, 16, 14, 00); LocalDateTime fecha12 =
		  LocalDateTime.of(2022, 10, 16, 14, 30); LocalDateTime fecha13 =
		  LocalDateTime.of(2022, 10, 16, 15, 00); LocalDateTime fecha14 =
		  LocalDateTime.of(2022, 10, 16, 15, 30);
		  
		  LocalDateTime nomina9 = LocalDateTime.of(2022, 9, 1, 00, 00); LocalDateTime
		  nomina10 = LocalDateTime.of(2022, 10, 1, 00, 00);
		  
		  
		  Paciente paciente1 = new Paciente("Maria", "Jaramillo", tipoDocumento.CEDULA,
		  9403862, 43, "Femenino", 301762849,"mj@gmail.com", "calle 36 #89 53", "SURA",
		  false); Paciente paciente2 = new Paciente( "Juan", "Pérez",
		  tipoDocumento.CEDULA, 1000, 23, "Masculino", 245687523, "juanper@gmail.com",
		  "Carrera 68 # 54 12", "SURA" , false); Paciente paciente3 = new
		  Paciente("Camilo", "Martinez", tipoDocumento.CEDULA, 1074074689, 25,
		  "Masculino", 300762957,"mcm@gmail.com", "cra87#12-34", "SURA", false);
		  
		  
		  Medico medico1 = new Medico("Susana", "Perez", tipoDocumento.CEDULA,
		  1000758374, 25, "Femenno", 1000758374, "susper@gmail.com", "Cra 77 #45 04",
		  tipoCita.GENERAL, tipoMedico.BACTERIOLOGO ,true); Medico medico2 = new
		  Medico("Andres", "Lopez", tipoDocumento.CEDULA, 1254687950, 29, "Masculino",
		  1254687950, "andlop@gmail.com", "Calle 113 #55 05", tipoCita.GENERAL,
		  tipoMedico.OPTOMETRA, true); Medico medico3 = new Medico("Mariana", "Garcia",
		  tipoDocumento.CEDULA, 656502354, 28, "Femenino", 656502354,
		  "margar@gmail.com", "Avenida 7 #8 07", tipoCita.GENERAL,
		  tipoMedico.OPTOMETRA, true); Medico medico4 = new Medico("Mauricio",
		  "Fernandez", tipoDocumento.CEDULA, 98765432, 60, "Masculino", 388030284,
		  "mp@hotmail.com", "carrera 78", tipoCita.AUDIOMETRIA,
		  tipoMedico.FONOAUDIOLOGO, true); medico1.setContratado(true);
		  medico2.setContratado(true); medico3.setContratado(true);
		  medico4.setContratado(true); Medico medico5 = new Medico("María", "Mercedes",
		  tipoDocumento.CEDULA, 154687, 29, "Masculino", 65426548, "marmer@gmail.com",
		  "Clle 77 #49 04", tipoCita.GENERAL, tipoMedico.GENERAL ,true); Medico medico6
		  = new Medico("Alejandro", "Valencia", tipoDocumento.CEDULA, 9875642, 38,
		  "Masculino", 236547898, "alval@gmail.com", "Carrera 111 #25 05",
		  tipoCita.GENERAL, tipoMedico.PEDIATRA, true); Medico medico7 = new
		  Medico("Valentina", "Gomez", tipoDocumento.CEDULA, 2154687, 26, "Femenino",
		  655984236, "valgom,@gmail.com", "Avenida 70 #22 07", tipoCita.GENERAL,
		  tipoMedico.BACTERIOLOGO, true); Medico medico8 = new Medico("David",
		  "Herrera", tipoDocumento.CEDULA, 65498752, 50, "Masculino", 87630549,
		  "dherrera@hotmail.com", "Transversal 78 # 69 02", tipoCita.AUDIOMETRIA,
		  tipoMedico.FONOAUDIOLOGO, true); Medico medico9 = new Medico("Juan", "Calvo",
		  tipoDocumento.CEDULA, 12354889, 65, "Masculino", 65698421,
		  "jcalvo@hotmail.com", "carrera 80 # 95 6", tipoCita.AUDIOMETRIA,
		  tipoMedico.OPTOMETRA, true);
		  
		  medico5.setSueldo(70000); medico6.setSueldo(60000); medico7.setSueldo(60000);
		  medico8.setSueldo(80000); medico9.setSueldo(80000);
		  
		  TreeMap<LocalDateTime, Pago> nominaMedico5 = new TreeMap<LocalDateTime,
		  Pago>(); nominaMedico5.put(nomina9, new Pago(7, (int) medico5.getSueldo(),
		  medico5, true)); nominaMedico5.put(nomina10, new Pago(8, (int)
		  medico5.getSueldo(), medico5, false)); TreeMap<LocalDateTime, Pago>
		  nominaMedico6 = new TreeMap<LocalDateTime, Pago>();
		  nominaMedico6.put(nomina9, new Pago(7, (int) medico6.getSueldo(), medico6,
		  true)); nominaMedico6.put(nomina10, new Pago(8, (int) medico6.getSueldo(),
		  medico6, false)); TreeMap<LocalDateTime, Pago> nominaMedico7 = new
		  TreeMap<LocalDateTime, Pago>(); nominaMedico7.put(nomina9, new Pago(7, (int)
		  medico7.getSueldo(), medico7, true)); nominaMedico7.put(nomina10, new Pago(8,
		  (int) medico7.getSueldo(), medico7, false)); TreeMap<LocalDateTime, Pago>
		  nominaMedico8 = new TreeMap<LocalDateTime, Pago>();
		  nominaMedico8.put(nomina9, new Pago(7, (int) medico8.getSueldo(), medico8,
		  true)); nominaMedico8.put(nomina10, new Pago(8, (int) medico8.getSueldo(),
		  medico8, false)); TreeMap<LocalDateTime, Pago> nominaMedico9 = new
		  TreeMap<LocalDateTime, Pago>(); nominaMedico9.put(nomina9, new Pago(7, (int)
		  medico9.getSueldo(), medico9, true)); nominaMedico9.put(nomina10, new Pago(8,
		  (int) medico9.getSueldo(), medico9, false));
		  
		  medico5.setNomina(nominaMedico5); medico6.setNomina(nominaMedico6);
		  medico7.setNomina(nominaMedico7); medico8.setNomina(nominaMedico8);
		  medico9.setNomina(nominaMedico9);
		  
		  
		  Consultorio consultorio1 = new Consultorio(1, null, null, "Laboratorio",
		  true); Consultorio consultorio2 = new Consultorio(2, null, null,
		  "Consultorio Optometría", true); Consultorio consultorio3 = new
		  Consultorio(3, null, null, "Consultorio Optometría", true); Consultorio
		  consultorio4 = new Consultorio(4, null, null, "Consultorio Audiometría",
		  true);
		  
		  Consultorio consultorio5 = new Consultorio(1, null, null, "Laboratorio",
		  false); Consultorio consultorio6 = new Consultorio(2, null, null,
		  "Consultorio Fonoaudología", false); Consultorio consultorio7 = new
		  Consultorio(3, null, null, "Consultorio Pediatria", false); Consultorio
		  consultorio8 = new Consultorio(4, null, null, "Consultorio General", false);
		  
		  
		  Cita cita1 = new Cita(paciente1, "Un laboratorio", medico1, consultorio1,
		  fecha1, tipoCita.LABORATORIO); Cita cita6 = new Cita(paciente3,
		  "Un laboratorio", medico1, consultorio1, fecha4, tipoCita.LABORATORIO); Cita
		  cita11 = new Cita(paciente2, "Un laboratorio", medico1, consultorio1, fecha5,
		  tipoCita.LABORATORIO); Cita cita16 = new Cita(null, "Un laboratorio",
		  medico1, consultorio1, fecha6, tipoCita.LABORATORIO); cita1.setPago(new
		  Pago(15000, true)); cita6.setPago(new Pago(15000, false)); cita11.setPago(new
		  Pago(15000, false));
		  
		  Cita cita2 = new Cita(null, "Revisión visual", medico2, consultorio2, fecha1,
		  tipoCita.OPTOMETRIA); Cita cita3 = new Cita(null, "Problemas visuales",
		  medico2, consultorio2, fecha2, tipoCita.OPTOMETRIA); Cita cita7 = new
		  Cita(null, "Revisión visual", medico2, consultorio2, fecha4,
		  tipoCita.OPTOMETRIA); Cita cita8 = new Cita(paciente1, "Problemas visuales",
		  medico2, consultorio2, fecha5, tipoCita.OPTOMETRIA); cita8.setPago(new
		  Pago(15000, false));
		  
		  
		  Cita cita12 = new Cita(paciente2, "Revisión visual", medico3, consultorio3,
		  fecha8, tipoCita.OPTOMETRIA); Cita cita13 = new Cita(null,
		  "Problemas visuales", medico3, consultorio3, fecha9, tipoCita.OPTOMETRIA);
		  Cita cita17 = new Cita(paciente3, "Revisión visual", medico3, consultorio3,
		  fecha10, tipoCita.OPTOMETRIA); Cita cita18 = new Cita(null,
		  "Problemas visuales", medico3, consultorio3, fecha5, tipoCita.OPTOMETRIA);
		  cita12.setPago(new Pago(15000, false)); cita17.setPago(new Pago(15000,
		  false));
		  
		  
		  Cita cita4 = new Cita(null, "Problemas en los oídos", medico4, consultorio4,
		  fecha2, tipoCita.AUDIOMETRIA); Cita cita5 = new Cita(null, "No escucha",
		  medico4, consultorio4, fecha3, tipoCita.AUDIOMETRIA); Cita cita9 = new
		  Cita(null, "Problemas en los oídos", medico4, null, fecha6,
		  tipoCita.AUDIOMETRIA); Cita cita10 = new Cita(null, "No escucha", medico4,
		  consultorio4, fecha7, tipoCita.AUDIOMETRIA); Cita cita14 = new Cita(null,
		  "Problemas en los oídos", medico4, null, fecha11, tipoCita.AUDIOMETRIA); Cita
		  cita15 = new Cita(paciente1, "No escucha", medico4, consultorio4, fecha12,
		  tipoCita.AUDIOMETRIA); Cita cita19 = new Cita(null, "Problemas en los oídos",
		  medico4, null, fecha13, tipoCita.AUDIOMETRIA); Cita cita20 = new
		  Cita(paciente3, "No escucha", medico4, consultorio4, fecha14,
		  tipoCita.AUDIOMETRIA); cita15.setPago(new Pago(15000, false));
		  cita20.setPago(new Pago(15000, false));
		  
		  cita1.setId(1); cita2.setId(2); cita3.setId(3); cita4.setId(4);
		  cita5.setId(5); cita6.setId(6); cita7.setId(7); cita8.setId(8);
		  cita9.setId(9); cita10.setId(10); cita11.setId(11); cita12.setId(12);
		  cita13.setId(13); cita14.setId(14); cita15.setId(15); cita16.setId(16);
		  cita17.setId(17); cita18.setId(18); cita19.setId(19); cita20.setId(20);
		  
		  
		  Entrega entrega1 = new Entrega(paciente1, "calle 36 #89 53", null,
		  estadoEntrega.EN_CAMINO); Entrega entrega2 = new Entrega(paciente1,
		  "calle 36 #89 53", null, estadoEntrega.EN_CAMINO); Entrega entrega3 = new
		  Entrega(paciente2, "Carrera 68 # 54 12", null, estadoEntrega.EN_CAMINO);
		  Entrega entrega4 = new Entrega(paciente3, "cra87#12-34", null,
		  estadoEntrega.EN_CAMINO);
		  
		  entrega1.setPago(new Pago(10000, false)); entrega2.setPago(new Pago(10000,
		  false)); entrega3.setPago(new Pago(10000, false)); entrega4.setPago(new
		  Pago(10000, false));
		  
		  paciente1.getEntregas().put(fecha10, entrega1);
		  paciente1.getEntregas().put(fecha11, entrega2);
		  paciente2.getEntregas().put(fecha13, entrega3);
		  paciente3.getEntregas().put(fecha14, entrega4);
		  
		  
		  Medicamentos medicamento1 = new Medicamentos(tipoMedicamento.Acetaminofen,
		  paciente1, 2, 3); Medicamentos medicamento2 = new
		  Medicamentos(tipoMedicamento.Ibuprofeno, paciente1, 4, 6); Medicamentos
		  medicamento3 = new Medicamentos(tipoMedicamento.Amoxicilina, paciente1, 1,
		  8);
		  
		  Diagnostico.sintomas.add("gripa"); Diagnostico.sintomas.add("fiebre");
		  Diagnostico.sintomas.add("vomito"); Diagnostico.sintomas.add("mareos");
		  Diagnostico.sintomas.add("nauseas"); Diagnostico diagnostico = new
		  Diagnostico(paciente1, Diagnostico.sintomas, "Dolor de cabeza", medicamento1,
		  1, cita1); Medico.listado.add(diagnostico);
		  Administrador.diagnosticos.add(diagnostico); diagnosticos.add(diagnostico);
		  Diagnostico diagnostico1 = new Diagnostico(paciente2, Diagnostico.sintomas,
		  "Dolor de cabeza", medicamento2, 2, cita11);
		  Medico.listado.add(diagnostico1);
		  Administrador.diagnosticos.add(diagnostico1); diagnosticos.add(diagnostico1);
		  Diagnostico diagnostico2 = new Diagnostico(paciente3, Diagnostico.sintomas,
		  "Rodilla Rota", medicamento3, 3, cita6); Medico.listado.add(diagnostico2);
		  Administrador.diagnosticos.add(diagnostico2); diagnosticos.add(diagnostico2);
		  ArrayList<Diagnostico> diagnosticos1 = new ArrayList<Diagnostico>();
		  ArrayList<Diagnostico> diagnosticos2 = new ArrayList<Diagnostico>();
		  ArrayList<Diagnostico> diagnosticos3 = new ArrayList<Diagnostico>();
		  diagnosticos1.add(diagnostico); diagnosticos2.add(diagnostico1);
		  diagnosticos3.add(diagnostico2); HistoriaClinica historiaClinica1 = new
		  HistoriaClinica(paciente1, diagnosticos1); HistoriaClinica historiaClinica2 =
		  new HistoriaClinica(paciente2, diagnosticos2); HistoriaClinica
		  historiaClinica3 = new HistoriaClinica(paciente3, diagnosticos3);
		  diagnostico.setPersona(paciente1);
		  paciente1.setHistoriaClinica(historiaClinica1);
		  diagnostico1.setPersona(paciente2);
		  paciente2.setHistoriaClinica(historiaClinica2);
		  diagnostico2.setPersona(paciente3);
		  paciente3.setHistoriaClinica(historiaClinica3);
		  
		  
		  
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
		  
		  medico1.setSueldo(70000); medico2.setSueldo(60000); medico3.setSueldo(60000);
		  medico4.setSueldo(80000);
		  
		  TreeMap<LocalDateTime, Pago> nominaMedico1 = new TreeMap<LocalDateTime,
		  Pago>(); nominaMedico1.put(nomina9, new Pago(1, (int) medico1.getSueldo(),
		  medico1, true)); nominaMedico1.put(nomina10, new Pago(2, (int)
		  medico1.getSueldo(), medico1, true));
		  
		  TreeMap<LocalDateTime, Pago> nominaMedico2 = new TreeMap<LocalDateTime,
		  Pago>(); nominaMedico2.put(nomina9, new Pago(3, (int) medico2.getSueldo(),
		  medico2, true)); nominaMedico2.put(nomina10, new Pago(4, (int)
		  medico2.getSueldo(), medico2, false));
		  
		  TreeMap<LocalDateTime, Pago> nominaMedico3 = new TreeMap<LocalDateTime,
		  Pago>(); nominaMedico3.put(nomina9, new Pago(5, (int) medico3.getSueldo(),
		  medico3, true)); nominaMedico3.put(nomina10, new Pago(6, (int)
		  medico3.getSueldo(), medico3, true));
		  
		  TreeMap<LocalDateTime, Pago> nominaMedico4 = new TreeMap<LocalDateTime,
		  Pago>(); nominaMedico4.put(nomina9, new Pago(7, (int) medico4.getSueldo(),
		  medico4, true)); nominaMedico4.put(nomina10, new Pago(8, (int)
		  medico4.getSueldo(), medico4, false));
		  
		  medico1.setNomina(nominaMedico1); medico2.setNomina(nominaMedico2);
		  medico3.setNomina(nominaMedico3); medico4.setNomina(nominaMedico4);
		  
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
		  
		  
		  Administrador.listaSintomas.add("gripa"); listaSintomas.add("gripa");
		  Administrador.listaSintomas.add("vomito"); listaSintomas.add("vomito");
		  Administrador.listaSintomas.add("fiebre"); listaSintomas.add("fiebre");
		  Administrador.listaSintomas.add("mareos"); listaSintomas.add("mareos");
		  Administrador.listaSintomas.add("nauseas"); listaSintomas.add("nauseas");
		  
		  
		  Administrador.diagnosticos.add(diagnostico); diagnosticos.add(diagnostico);
		  Administrador.diagnosticos.add(diagnostico1); diagnosticos.add(diagnostico1);
		  Administrador.diagnosticos.add(diagnostico2); diagnosticos.add(diagnostico2);
		  
		  Administrador.medicamentos.add(medicamento1);
		  Administrador.medicamentos.add(medicamento2);
		  Administrador.medicamentos.add(medicamento3); medicamentos.add(medicamento1);
		  medicamentos.add(medicamento2); medicamentos.add(medicamento3);
		  
		  
		  historiasClinicas.add(historiaClinica1);
		  historiasClinicas.add(historiaClinica2);
		  historiasClinicas.add(historiaClinica3);
		  Administrador.historiasClinicas.add(historiaClinica1);
		  Administrador.historiasClinicas.add(historiaClinica2);
		  Administrador.historiasClinicas.add(historiaClinica3);
		  
		  
		  Administrador.consultas.add(cita1); Administrador.consultas.add(cita2);
		  Administrador.consultas.add(cita3); Administrador.consultas.add(cita4);
		  Administrador.consultas.add(cita5); Administrador.consultas.add(cita6);
		  Administrador.consultas.add(cita7); Administrador.consultas.add(cita8);
		  Administrador.consultas.add(cita9); Administrador.consultas.add(cita10);
		  Administrador.consultas.add(cita11); Administrador.consultas.add(cita12);
		  Administrador.consultas.add(cita13); Administrador.consultas.add(cita14);
		  Administrador.consultas.add(cita15); Administrador.consultas.add(cita16);
		  Administrador.consultas.add(cita17); Administrador.consultas.add(cita18);
		  Administrador.consultas.add(cita19); Administrador.consultas.add(cita20);
		  
		  Administrador.fechas.add(fecha1); Administrador.fechas.add(fecha2);
		  Administrador.fechas.add(fecha3); Administrador.fechas.add(fecha4);
		  Administrador.fechas.add(fecha5); Administrador.fechas.add(fecha6);
		  Administrador.fechas.add(fecha7); Administrador.fechas.add(fecha8);
		  Administrador.fechas.add(fecha9); Administrador.fechas.add(fecha10);
		  Administrador.fechas.add(fecha11); Administrador.fechas.add(fecha12);
		  Administrador.fechas.add(fecha13); Administrador.fechas.add(fecha14);
		  Administrador.fechas.add(nomina9); Administrador.fechas.add(nomina10);
		  
		  
		  pacientes.add(paciente1); pacientes.add(paciente2); pacientes.add(paciente3);
		  
		  
		  medicos.add(medico1); medicos.add(medico2); medicos.add(medico3);
		  medicos.add(medico4); medicos.add(medico5); medicos.add(medico6);
		  medicos.add(medico7); medicos.add(medico8); medicos.add(medico9);
		  Medico.medicos.add(medico1);
			Medico.medicos.add(medico2);
			Medico.medicos.add(medico3);
			Medico.medicos.add(medico4);
			Medico.medicos.add(medico5);
			Medico.medicos.add(medico6);
			Medico.medicos.add(medico7);
			Medico.medicos.add(medico8);
			Medico.medicos.add(medico9);
		  
		  consultorios.add(consultorio1); consultorios.add(consultorio2);
		  consultorios.add(consultorio3); consultorios.add(consultorio4);
		  consultorios.add(consultorio5); consultorios.add(consultorio6);
		  consultorios.add(consultorio7); consultorios.add(consultorio8);
		  consultorios.add(consultorio1);
			Consultorio.consultorios.add(consultorio1);
			Consultorio.consultorios.add(consultorio2);
			Consultorio.consultorios.add(consultorio3);
			Consultorio.consultorios.add(consultorio4);
			Consultorio.consultorios.add(consultorio5);
			Consultorio.consultorios.add(consultorio6);
			Consultorio.consultorios.add(consultorio7);
			Consultorio.consultorios.add(consultorio8);
		  
		  consultas.add(cita1); consultas.add(cita2); consultas.add(cita3);
		  consultas.add(cita4); consultas.add(cita5); consultas.add(cita6);
		  consultas.add(cita7); consultas.add(cita8); consultas.add(cita9);
		  consultas.add(cita10); consultas.add(cita11); consultas.add(cita12);
		  consultas.add(cita13); consultas.add(cita14); consultas.add(cita15);
		  consultas.add(cita16); consultas.add(cita17); consultas.add(cita18);
		  consultas.add(cita19); consultas.add(cita20);
		  
		  fechas.add(fecha1); fechas.add(fecha2); fechas.add(fecha3);
		  fechas.add(fecha4); fechas.add(fecha5); fechas.add(fecha6);
		  fechas.add(fecha7); fechas.add(fecha8); fechas.add(fecha9);
		  fechas.add(fecha10); fechas.add(fecha11); fechas.add(fecha12);
		  fechas.add(fecha13); fechas.add(fecha14); fechas.add(nomina9);
		  fechas.add(nomina10);
		  
		  Cita.listaCitas.add(cita1); Cita.listaCitas.add(cita2);
		  Cita.listaCitas.add(cita3); Cita.listaCitas.add(cita4);
		  Cita.listaCitas.add(cita5); Cita.listaCitas.add(cita6);
		  Cita.listaCitas.add(cita7); Cita.listaCitas.add(cita8);
		  Cita.listaCitas.add(cita9); Cita.listaCitas.add(cita10);
		  Cita.listaCitas.add(cita11); Cita.listaCitas.add(cita12);
		  Cita.listaCitas.add(cita13); Cita.listaCitas.add(cita14);
		  Cita.listaCitas.add(cita15); Cita.listaCitas.add(cita16);
		  Cita.listaCitas.add(cita17); Cita.listaCitas.add(cita18);
		  Cita.listaCitas.add(cita19); Cita.listaCitas.add(cita20);
		  
		  serializar(administrador, "administrador");
		  
		  serializar(fechas, "fechas");
		  
		  serializar(consultas, "consultas");
		  
		  serializar(pacientes, "pacientes");
		  
		  serializar(medicos, "medicos");
		  
		  serializar(consultorios, "consultorios");
		  
		  serializar(medicamentos, "medicamentos");
		  
		  serializar(listaSintomas, "listaSintomas"); 
		  
		  serializar(diagnosticos, "diagnosticos");
		  
		  serializar(historiasClinicas, "historiasClinicas");
		 
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
