
#Clase Paciente, para poder almacenar los atributos y aplicar los metodos respecto a los pacientes del sistema se usan arraylist para almacenar todos los pacientes creados y para tener las lista de los síntomas que tenga el paciente.
#Al igual se usan tree maps, donde se guardan las consultas con su respectiva fecha y le consulta asignada y las entregas, donde se guardan las fechas y las netregas correspondientes.

from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.personas.Persona import Persona
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
            if i.getEspecialista()== tipoMedico and Administrador.verificarDisponibilidadMedico(fecha, i) == True:
                medico = i
                break
        
        consultorios = Administrador.getConsultorios()
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

    def reagendarCita(self, id, fecha):
        cita = None
        citas = Administrador.getCitas()
        #Se busca la cita que se quiere reagendar
        for i in citas:
            if i.getPaciente() == self and i.getId() == id:
                cita = i
                break
        if cita is None:
            return "Hubo un problema reagendando su cita, vuelvalo a intentar más tarde"

        #Se verifica que tanto el medico como el consultorio esten disponible en la nueva fecha
        if Administrador.verificarDisponibilidadMedico(fecha, cita.getMedico()) == True and Administrador.verificarDisponibilidadConsultorio(fecha, cita.getConsultorio()) == True:
            cita.setFecha(fecha)
            return "Su cita ha sido reagendada exitosamente y será en el mismo consultorio, con el mismo médico"
            
        elif Administrador.verificarDisponibilidadMedico(fecha, cita.getMedico()) == False:
            #Se busca un medico con disponibilidad
            medicos = Administrador.getMedicos()
            medico = None
            for i in range(len(medicos)):
                if medicos[i].getEspecialidad() == cita.getTiposCitas() and Administrador.verificarDisponibilidadMedico(fecha, medicos[i]) == True:
                    medico = medicos[i]
                    cita.setMedico(medico)
                    cita.setFecha(fecha)
                    if Administrador.verificarDisponibilidadConsultorio(fecha, cita.getConsultorio) == True and medico != None:
                        return f"Su cita ha sido reagendada exitosamente, su nuevo medico será {medico.getNombre()} {medico.getApellido()} en el mismo consultorio \n"        
                    #Si el conusltorio no esta disponible, se busca un nuevo consultorio
                    else:
                        consultorios = Administrador.getConsultorios()
                        consultorio = None
                        for i in consultorios:
                            #Se recorre la lista de los consultorios creados y se verifica si el consultorio esta disponible en la fecha que se requiere la cita
                            if Administrador.verificarDisponibilidadConsultorio(fecha, i) == True:
                                consultorio = i
                                cita.setConsultorio(consultorio)
                                break
                        return f"Su cita ha sido reagendada exitosamente, su nuevo medico {medico.getNombre()} {medico.getApellido()} y esta será en el consultorio: {consultorio.getId()} \n"

                elif Administrador.verificarDisponibilidad(fecha, medicos[i]) == False and i == len(medicos)-1:
                    return "No fue posible reagendar su cita, debido a que no hay disponibilidad de citas, vuelvalo a intentar mas tarde"

        return "Hubo un problema reagendando su cita, vuelvalo a intentar mas tarde"            
    
    def solicitarExamen(examen, tipoMedico, medicos):
        if Administrador.autorizarExamen(examen, tipoMedico, medicos) == 1:
            return 1
        elif Administrador.autorizarExamen(examen, tipoMedico, medicos) == 2:
            return 2
        else:
            return 0
    
    