
#Clase Paciente, para poder almacenar los atributos y aplicar los metodos respecto a los pacientes del sistema se usan arraylist para almacenar todos los pacientes creados y para tener las lista de los síntomas que tenga el paciente.
#Al igual se usan tree maps, donde se guardan las consultas con su respectiva fecha y le consulta asignada y las entregas, donde se guardan las fechas y las netregas correspondientes.

from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.personas.Persona import Persona
<<<<<<< Updated upstream
from gestorAplicacion.personas.Administrador import Administrador
=======
>>>>>>> Stashed changes
import datetime as dt


class Paciente(Persona):

#constructores	
    def __init__(self, nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, 
        direccion, eps, historicaClinica, pagado,sintomas = None, consultas = None, entregas = None):
        super().__init__(nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion)
        if sintomas is None:
            sintomas = []
        if consultas is None:
            consultas = {}
        if entregas is None:
            entregas = {}
        self.eps = eps
        self.sintomas = sintomas
        self.historiaClinica = historicaClinica
        self.consultas = consultas 
        self.entregas = entregas
        self.pagado = pagado

	#Metodos
    #Getters y setters

    def getEps(self):
        return self.eps
    def setEps(self, eps):
        self.eps = eps

    def getSintomas(self):
        return self.sintomas

    def setSintomas(self, sintomas):
        self.sintomas = sintomas

    def getHistoriaClinica(self):
        return self.historiaClinica
    
    def setHistoriaClinica(self, historiaClinica):
        self.historiaClinica = historiaClinica

    def getConsultas(self):
        return self.consultas

    def setConsultas(self, consultas):
        self.consultas = consultas

    def isPagado(self):
        return self.pagado

    def setPagado(self, pagado):
        self.pagado = pagado
        
    def getEntregas(self):
        return self.entregas
	
    def setEntregas(self, entregas):
        self.entregas = entregas
        
    #Metodos
    '''
 	/*Metodo para poder ejecutar la funcionalidad de pedir cita, el cual recibe la fecha en que se desea pedir la cita, el tipo de la cita, el motivo y el típo de médico 
 	requerido, este retorna un String que indica si el proceso fue exitoso o fallido, en el primer caso, a su vez se devuelve la fecha en que fue asignada la cita, junto con
 	el consultorio en el que será la cita.*/
	'''
    def pedirCita(self, fecha, tipoCita, motivo, tipoMedico):
        medicos = Administrador.getMedicos()
        medico = None

        for i in medicos:
            #Se recorre la lista de los medicos creados y se va verificando si la especialidad del medico i concuerda con el tipo de cita que
 			#se requiere y tambien se verifica si ese medico esta disponible.
            if i.especialista == tipoMedico and Administrador.verificarDisponibilidadMedico(fecha, i) == True:
                medico = i
                break
        
        consultorios = Administrador.consultorios
        consultorio = None
        for i in consultorios:
            #Se recorre la lista de los consultorios creados y se verifica si el consultorio esta disponible en la fecha que se requiere la cita
            if Administrador.verificarDisponibilidadConsultorio(fecha, i) == True:
                consultorio = i
                break

        if medico != None and consultorio != None:
            Administrador.asignarCita(self, medico, consultorio, fecha, motivo, tipoCita)
            return f"Su cita ha sido agendada exitosamente el: {fecha} con el médico: {medico.nombre} {medico.apellido} en el consultorio {consultorio.id} \n" 
        else:
            return "Hubo un error agendando su cita, vuelvalo a intentar. \n"

        '''
        Método para reagendar una cita, el cual recibe el identificador de la cita que se desea modificar y la nueva fecha a la que se desea hacer el cambio, el retornno de esta
        funcion es un String que muestra si el reagendamiento fue exitoso o no, el caso de exito hay 3 diferentes posibilidades, la primera es en caso que tanto el medico como el
        consultorio esten disponibles en la nueva fecha, el otro caso es que el consultorio esté disponible, pero no el medico, en este caso se retorna si se pudo reagendar, 
        pero hbuo cambio de medico y se muestra el nombre y apellido del nuevo medico y el caso final es que ni el consultorio ni el medico original se deben de cambiar,
        en este caso se retorna que el cambio de cita fue exitos, sin embargo que se cambio tanto el consultorio como el medico, mostrando los respectivos cambios*/
        '''
    
# 	public String reagendarCita(int id, LocalDateTime fechaNueva) {
# 		Cita cita = null;
# 		ArrayList<Consulta> citas = Administrador.consultas;
# 		//Se busca la cita que se quiere reagendar
# 		for (int i = 0; i<citas.size(); i++) {
# 			if (citas.get(i).getPaciente() == this && citas.get(i).getId() == id) {
# 				cita = (Cita) citas.get(i);
# 				break;
# 			}
# 		}
# 		if(cita == null) {
# 			return "Hubo un problema reagendando su cita, vuelvalo a intentar mas tarde";
# 		}
# 		//Se verifica que tanto el medico como el consultorio esten disponible en la nueva fecha
# 		if(Administrador.verificarDisponibilidadMedico(fechaNueva,cita.getMedico()) == true && Administrador.verificarDisponibilidadConsultorio(fechaNueva, cita.getConsultorio())==true){
# 			cita.setFecha(fechaNueva);
# 			return "Su cita ha sido reagendada exitosamente y será en el mismo consultorio, con el mismo médico";
# 		}
# 		else if(Administrador.verificarDisponibilidadMedico(fechaNueva,cita.getMedico()) == false) {
# 			//Se busca un medico con disponibilidad
# 			ArrayList<Medico> medicos = Administrador.medicos;
# 			Medico medico = null;
# 			for (int i = 0; i<medicos.size(); i++){
# 				if ( medicos.get(i).especialidad == cita.getTiposCitas() && Administrador.verificarDisponibilidadMedico(fechaNueva, medicos.get(i)) == true) {
# 					medico = medicos.get(i);
# 					cita.setMedico(medico);
# 					cita.setFecha(fechaNueva);
# 					if (Administrador.verificarDisponibilidadConsultorio(fechaNueva, cita.getConsultorio())==true && medico != null) {
# 						return "Su cita ha sido reagendada exitosamente, su nuevo medico será : "+ medico.getNombre()+" "+medico.getApellido()+ " en el mismo consultorio \n";
# 					}
# 					//Si el consultorio no esta disponible, se busca un nuevo consultorio
# 					else {
# 						ArrayList<Consultorio> consultorios = Administrador.consultorios;
# 						Consultorio consultorio = null;
# 						for (int j = 0; j< consultorios.size(); j++) {
# 							//Se recorre la lista de los consultorios creados y se verifica si el consultorio esta disponible en la fecha que se requiere la cita
# 							if(Administrador.verificarDisponibilidadConsultorio(fechaNueva, consultorios.get(j)) == true){
# 								consultorio = consultorios.get(j);
# 								cita.setConsultorio(consultorio);
# 								break;
# 							}
# 						}
# 						return "Su cita ha sido reagendada exitosamente, su nuevo medico será : "+ medico.getNombre()+" "+medico.getApellido()+ " y esta será en el consultorio: "+consultorio.getId()+ "\n";
# 					}
					
# 				}
# 				else if(Administrador.verificarDisponibilidadMedico(fechaNueva, medicos.get(i)) == false && i== medicos.size()){
# 					return "No fue posible reagendar su cita, debido a que no hay disponibilidad de citas, vuelvalo a intentar mas tarde";
# 				}
# 			}
# 			}		
				
				

# 		return "Hubo un problema reagendando su cita, vuelvalo a intentar mas tarde";					
# 	}
	
# 	//En caso de que el medico no este disponible
# 	public String reagendarCitaMedico(int id, LocalDateTime fecha) {
# 		Cita cita = null;
# 		ArrayList<Cita> citas = Cita.listaCitas;
# 		//Se busca la cita que se quiere reagendar
# 		for (int i = 0; i<citas.size(); i++) {
# 			if (citas.get(i).getPaciente() == this && citas.get(i).getId() == id) {
# 				cita = citas.get(i);
# 				break;
# 			}
# 		}
# 		//Se busca un medico con disponibilidad
# 		ArrayList<Medico> medicos = Administrador.medicos;
# 		Medico medico = null;
# 		for(int i = 0; i<medicos.size(); i++) {
# 			if(medicos.get(i).especialidad ==  cita.getTiposCitas() && Administrador.verificarDisponibilidadMedico(fecha, medicos.get(i)) == true){
# 				medico = medicos.get(i);
# 				cita.setMedico(medico);
# 				cita.setFecha(fecha);
# 				break;
# 			}
# 			else if(Administrador.verificarDisponibilidadMedico(fecha, medicos.get(i)) == false && i== medicos.size()){
# 				return "No fue posible reagendar su cita, debido a que no hay disponibilidad de citas, vuelvalo a intentar mas tarde";
# 			}
# 		}
# 		//Se verifica si el consultorio esta disponible para la nueva fecha
# 		if (Administrador.verificarDisponibilidadConsultorio(fecha, cita.getConsultorio())==true && medico != null) {
# 			return "Su cita ha sido reagendada exitosamente, su nuevo medico será : "+ medico.getNombre()+" "+medico.getApellido()+ " en el mismo consultorio \n";
# 		}
# 		//Si el consultorio no esta disponible, se busca un nuevo consultorio
# 		else {
# 			ArrayList<Consultorio> consultorios = Administrador.consultorios;
# 			Consultorio consultorio = null;
# 			for (int i = 0; i< consultorios.size(); i++) {
# 				//Se recorre la lista de los consultorios creados y se verifica si el consultorio esta disponible en la fecha que se requiere la cita
# 				if(Administrador.verificarDisponibilidadConsultorio(fecha, consultorios.get(i)) == true){
# 					consultorio = consultorios.get(i);
# 					cita.setConsultorio(consultorio);
# 					break;
# 				}
# 			}
# 			return "Su cita ha sido reagendada exitosamente, su nuevo medico será : "+ medico.getNombre()+" "+medico.getApellido()+ " y esta será en el consultorio: "+consultorio.getId()+ "\n";
# 		}
# 	}

	
# 	public int solicitarExamen(Examen examen, tipoMedico tipoMed, ArrayList<Medico> medicos) {
# 		if(Administrador.autorizarExamen(examen, tipoMed, medicos) == 1) {
# 			return 1;
# 		}
# 		else if (Administrador.autorizarExamen(examen, tipoMed, medicos) == 2) {
# 			return 2;
# 		}
# 		else {
# 			return 0;
# 		}
# 	}
	
	
	
# 	public HistoriaClinica consultarHistorioaClinica() {
# 		return getHistoriaClinica();
# 	}

# /*Implementación del metodo abstracto de la interfaz visualiazcion Datos, que implementa la clase padre persona, el cual tiene el mismo objetivo de mostrar un listado de
#  * todos los datos. 	
#  */
# 	@Override
# 	public String visualizarDatos() {
# 		return getNombre() +" "+ getApellido() + 
# 				"\nTipo de documento: " +getDocumento() +
# 				"\nNúmero de documento: " +getNumeroDocumento() + 
# 				"\nEdad: " +getEdad() +
# 				"\nGénero: " + getGenero()+
# 				"\nTeléfono número: "+getTelefono()
# 				+"\nCorreo Electrónico: " +getCorreoElectronico()
# 				+"\nDirección: " +getDireccion()+
# 				"\nEPS a la que está afiliado: " +getEps();
# 	}
# }
