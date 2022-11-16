
#Clase Paciente, para poder almacenar los atributos y aplicar los metodos respecto a los pacientes del sistema se usan arraylist para almacenar todos los pacientes creados y para tener las lista de los síntomas que tenga el paciente.
#Al igual se usan tree maps, donde se guardan las consultas con su respectiva fecha y le consulta asignada y las entregas, donde se guardan las fechas y las netregas correspondientes.

from Python.src.gestorAplicacion.personas.Persona import Persona


class Paciente(Persona):

#constructores	
    def __init__(self, nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, 
        direccion, eps, sintomas, historicaClinica, consultas, entregas, pagado):
        super(nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion)




	public Paciente(String eps, ArrayList<String> sintomas, HistoriaClinica historiaClinica,
			Map<LocalDateTime, Consulta> consultas, Map<LocalDateTime, Entrega> entregas, boolean pagado) {
		this.eps = eps;
		this.sintomas = sintomas;
		this.historiaClinica = historiaClinica;
		this.consultas = consultas;
		this.entregas = entregas;
		this.pagado = pagado;
	}
	public Paciente(String nombre, String apellido, tipoDocumento documento, long numeroDocumento, int edad,
			String genero, long telefono, String correoElectronico, String direccion, String eps,boolean pagado) {
		this(nombre, apellido, documento,numeroDocumento, edad,genero, telefono, correoElectronico, direccion, eps,
			new ArrayList<String>(), null, new TreeMap<LocalDateTime, Consulta>(),new TreeMap<LocalDateTime, Entrega>(), pagado);
	}


	//Getters y setters
	public String getEps() {
		return eps;
	}
	public void setEps(String eps) {
		this.eps = eps;
	}
	
	public ArrayList<String> getSintomas() {
		return sintomas;
	}
	public void setSintomas(ArrayList<String> sintomas) {
		this.sintomas = sintomas;
	}
	
	public HistoriaClinica getHistoriaClinica() {
		return historiaClinica;
	}
	public void setHistoriaClinica(HistoriaClinica historiaClinica) {
		this.historiaClinica = historiaClinica;
	}
	public Map<LocalDateTime, Consulta> getConsultas() {
		return consultas;
	}

	public void setConsultas(Map<LocalDateTime, Consulta> consultas) {
		this.consultas = consultas;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}
		
	public Map<LocalDateTime, Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(Map<LocalDateTime, Entrega> entregas) {
		this.entregas = entregas;
	}

	//Metodos
	
	/*Metodo para poder ejecutar la funcionalidad de pedir cita, el cual recibe la fecha en que se desea pedir la cita, el tipo de la cita, el motivo y el típo de médico 
	requerido, este retorna un String que indica si el proceso fue exitoso o fallido, en el primer caso, a su vez se devuelve la fecha en que fue asignada la cita, junto con
	el consultorio en el que será la cita.*/
	
	public String pedirCita(LocalDateTime fecha, tipoCita tipoCita, String motivo, tipoMedico tipoMed) {
		ArrayList<Medico> medicos = Administrador.medicos;
		Medico medico = null;
		for (int i = 0; i<medicos.size(); i++){
			//Se recorre la lista de los medicos creados y se va verificando si la especialidad del medico i concuerda con el tipo de cita que
			//se requiere y tambien se verifica si ese medico esta disponible.
			if ( medicos.get(i).especialista == tipoMed && Administrador.verificarDisponibilidadMedico(fecha, medicos.get(i)) == true) {
				medico = medicos.get(i);
				break;
			}
		}
		ArrayList<Consultorio> consultorios = Administrador.consultorios;
		Consultorio consultorio = null;
		for (int i = 0; i< consultorios.size(); i++) {
			//Se recorre la lista de los consultorios creados y se verifica si el consultorio esta disponible en la fecha que se requiere la cita
			if(Administrador.verificarDisponibilidadConsultorio(fecha, consultorios.get(i)) == true){
				consultorio = consultorios.get(i);
				break;
			}
		}
		if (medico != null && consultorio != null) {
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");  
			Administrador.asignarCita(this, medico, consultorio, fecha, motivo, tipoCita);
			return "Su cita ha sido agendada exitosamente el: " + fecha.format(formato) + " con el médico: "+ medico.getNombre()+" "+ medico.getApellido()+ " en el consultorio "+ consultorio.getId()+"\n";
		}
		else {
			return "Hubo un error agendando su cita, vuelvalo a intentar. \n";
		}
	}
	
	/*Método para reagendar una cita, el cual recibe el identificador de la cita que se desea modificar y la nueva fecha a la que se desea hacer el cambio, el retornno de esta
	 * funcion es un String que muestra si el reagendamiento fue exitoso o no, el caso de exito hay 3 diferentes posibilidades, la primera es en caso que tanto el medico como el
	 *  consultorio esten disponibles en la nueva fecha, el otro caso es que el consultorio esté disponible, pero no el medico, en este caso se retorna si se pudo reagendar, 
	 *  pero hbuo cambio de medico y se muestra el nombre y apellido del nuevo medico y el caso final es que ni el consultorio ni el medico original se deben de cambiar,
	 *   en este caso se retorna que el cambio de cita fue exitos, sin embargo que se cambio tanto el consultorio como el medico, mostrando los respectivos cambios*/
	public String reagendarCita(int id, LocalDateTime fechaNueva) {
		Cita cita = null;
		ArrayList<Consulta> citas = Administrador.consultas;
		//Se busca la cita que se quiere reagendar
		for (int i = 0; i<citas.size(); i++) {
			if (citas.get(i).getPaciente() == this && citas.get(i).getId() == id) {
				cita = (Cita) citas.get(i);
				break;
			}
		}
		if(cita == null) {
			return "Hubo un problema reagendando su cita, vuelvalo a intentar mas tarde";
		}
		//Se verifica que tanto el medico como el consultorio esten disponible en la nueva fecha
		if(Administrador.verificarDisponibilidadMedico(fechaNueva,cita.getMedico()) == true && Administrador.verificarDisponibilidadConsultorio(fechaNueva, cita.getConsultorio())==true){
			cita.setFecha(fechaNueva);
			return "Su cita ha sido reagendada exitosamente y será en el mismo consultorio, con el mismo médico";
		}
		else if(Administrador.verificarDisponibilidadMedico(fechaNueva,cita.getMedico()) == false) {
			//Se busca un medico con disponibilidad
			ArrayList<Medico> medicos = Administrador.medicos;
			Medico medico = null;
			for (int i = 0; i<medicos.size(); i++){
				if ( medicos.get(i).especialidad == cita.getTiposCitas() && Administrador.verificarDisponibilidadMedico(fechaNueva, medicos.get(i)) == true) {
					medico = medicos.get(i);
					cita.setMedico(medico);
					cita.setFecha(fechaNueva);
					if (Administrador.verificarDisponibilidadConsultorio(fechaNueva, cita.getConsultorio())==true && medico != null) {
						return "Su cita ha sido reagendada exitosamente, su nuevo medico será : "+ medico.getNombre()+" "+medico.getApellido()+ " en el mismo consultorio \n";
					}
					//Si el consultorio no esta disponible, se busca un nuevo consultorio
					else {
						ArrayList<Consultorio> consultorios = Administrador.consultorios;
						Consultorio consultorio = null;
						for (int j = 0; j< consultorios.size(); j++) {
							//Se recorre la lista de los consultorios creados y se verifica si el consultorio esta disponible en la fecha que se requiere la cita
							if(Administrador.verificarDisponibilidadConsultorio(fechaNueva, consultorios.get(j)) == true){
								consultorio = consultorios.get(j);
								cita.setConsultorio(consultorio);
								break;
							}
						}
						return "Su cita ha sido reagendada exitosamente, su nuevo medico será : "+ medico.getNombre()+" "+medico.getApellido()+ " y esta será en el consultorio: "+consultorio.getId()+ "\n";
					}
					
				}
				else if(Administrador.verificarDisponibilidadMedico(fechaNueva, medicos.get(i)) == false && i== medicos.size()){
					return "No fue posible reagendar su cita, debido a que no hay disponibilidad de citas, vuelvalo a intentar mas tarde";
				}
			}
			}		
				
				

		return "Hubo un problema reagendando su cita, vuelvalo a intentar mas tarde";					
	}
	
	//En caso de que el medico no este disponible
	public String reagendarCitaMedico(int id, LocalDateTime fecha) {
		Cita cita = null;
		ArrayList<Cita> citas = Cita.listaCitas;
		//Se busca la cita que se quiere reagendar
		for (int i = 0; i<citas.size(); i++) {
			if (citas.get(i).getPaciente() == this && citas.get(i).getId() == id) {
				cita = citas.get(i);
				break;
			}
		}
		//Se busca un medico con disponibilidad
		ArrayList<Medico> medicos = Administrador.medicos;
		Medico medico = null;
		for(int i = 0; i<medicos.size(); i++) {
			if(medicos.get(i).especialidad ==  cita.getTiposCitas() && Administrador.verificarDisponibilidadMedico(fecha, medicos.get(i)) == true){
				medico = medicos.get(i);
				cita.setMedico(medico);
				cita.setFecha(fecha);
				break;
			}
			else if(Administrador.verificarDisponibilidadMedico(fecha, medicos.get(i)) == false && i== medicos.size()){
				return "No fue posible reagendar su cita, debido a que no hay disponibilidad de citas, vuelvalo a intentar mas tarde";
			}
		}
		//Se verifica si el consultorio esta disponible para la nueva fecha
		if (Administrador.verificarDisponibilidadConsultorio(fecha, cita.getConsultorio())==true && medico != null) {
			return "Su cita ha sido reagendada exitosamente, su nuevo medico será : "+ medico.getNombre()+" "+medico.getApellido()+ " en el mismo consultorio \n";
		}
		//Si el consultorio no esta disponible, se busca un nuevo consultorio
		else {
			ArrayList<Consultorio> consultorios = Administrador.consultorios;
			Consultorio consultorio = null;
			for (int i = 0; i< consultorios.size(); i++) {
				//Se recorre la lista de los consultorios creados y se verifica si el consultorio esta disponible en la fecha que se requiere la cita
				if(Administrador.verificarDisponibilidadConsultorio(fecha, consultorios.get(i)) == true){
					consultorio = consultorios.get(i);
					cita.setConsultorio(consultorio);
					break;
				}
			}
			return "Su cita ha sido reagendada exitosamente, su nuevo medico será : "+ medico.getNombre()+" "+medico.getApellido()+ " y esta será en el consultorio: "+consultorio.getId()+ "\n";
		}
	}

	
	public int solicitarExamen(Examen examen, tipoMedico tipoMed, ArrayList<Medico> medicos) {
		if(Administrador.autorizarExamen(examen, tipoMed, medicos) == 1) {
			return 1;
		}
		else if (Administrador.autorizarExamen(examen, tipoMed, medicos) == 2) {
			return 2;
		}
		else {
			return 0;
		}
	}
	
	
	
	public HistoriaClinica consultarHistorioaClinica() {
		return getHistoriaClinica();
	}

/*Implementación del metodo abstracto de la interfaz visualiazcion Datos, que implementa la clase padre persona, el cual tiene el mismo objetivo de mostrar un listado de
 * todos los datos. 	
 */
	@Override
	public String visualizarDatos() {
		return getNombre() +" "+ getApellido() + 
				"\nTipo de documento: " +getDocumento() +
				"\nNúmero de documento: " +getNumeroDocumento() + 
				"\nEdad: " +getEdad() +
				"\nGénero: " + getGenero()+
				"\nTeléfono número: "+getTelefono()
				+"\nCorreo Electrónico: " +getCorreoElectronico()
				+"\nDirección: " +getDireccion()+
				"\nEPS a la que está afiliado: " +getEps();
	}
}
