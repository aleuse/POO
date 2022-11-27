""" 
La clase Administrador tiene el fin de llevar la economía del sistema médico asociada al dinero disponible y la 
administración de este. También se encarga de procesos administrativos y logísticos como verificar la disponibilidad
de médicos y/o consultorios; asignar citas a los pacientes cuando soliciten una; autorizar y asignar los exámenes
solicitados por los pacientes; entre otras.
"""
import random as rd
class Administrador:
    # Dinero es un atributo de clase público
    dinero = 0
    """
    Los siguientes atributos de clase serán utilizados para guardar la información referente a otras clases, por ejemplo
    los médicos que hay en planta, los consultorios, etc.
    """
    consultas = []
    consultorios = []
    diagnosticos = []
    fechas = []
    historiasClinicas = []
    listaSintomas = []
    medicamentos = []
    medicos = []
    pacientes = []
    
    def __init__(self, id, nombre):
        # Id y Nombre son atributos de instancia privados
        self._id = id
        self._nombre = nombre
    
    # Getters y Setters
    @classmethod
    def getDinero(cls):
        return cls.dinero
    @classmethod
    def setDinero(cls, dinero):
        cls.dinero = dinero
        
    @classmethod
    def getConsultas(cls):
        return cls.consultas
    @classmethod
    def setConsultas(cls, consultas):
        cls.consultas = consultas
        
    @classmethod
    def getConsultorios(cls):
        return cls.consultorios
    @classmethod
    def setConsultorios(cls, consultorios):
        cls.consultorios = consultorios
        
    @classmethod
    def getDiagnosticos(cls):
        return cls.diagnosticos
    @classmethod
    def setDiagnosticos(cls, diagnosticos):
        cls.diagnosticos = diagnosticos
    
    @classmethod
    def getFechas(cls):
        return cls.fechas
    @classmethod
    def setFechas(cls, fechas):
        cls.fechas = fechas
    
    @classmethod
    def getHistoriasClinicas(cls):
        return cls.historiasClinicas
    @classmethod
    def setHistoriasClinicas(cls, historiasClinicas):
        cls.historiasClinicas = historiasClinicas
        
    @classmethod
    def getListaSintomas(cls):
        return cls.listaSintomas
    @classmethod
    def setListaSintomas(cls, listaSintomas):
        cls.listaSintomas = listaSintomas
    
    @classmethod
    def getMedicamentos(cls):
        return cls.medicamentos
    @classmethod
    def setMedicamentos(cls, medicamentos):
        cls.medicamentos = medicamentos
        
    @classmethod
    def getMedicos(cls):
        return cls.medicos
    @classmethod
    def setMedicos(cls, medicos):
        cls.medicos = medicos
        
    @classmethod
    def getPacientes(cls):
        return cls.pacientes
    @classmethod
    def setPacientes(cls, pacientes):
        cls.pacientes = pacientes
    
    def getId(self):
        return self._id
    
    def setId(self, id):
        self._id = id
    
    def getNombre(self):
        return self._nombre
    
    def setNombre(self, nombre):
        self._nombre = nombre
        
    # Métodos
    """
    Los métodos de sumar y restar dinero como indican sus nombres se encargan de agregar o quitar la cantidad
    de dinero especificada al dinero que hay disponible
    """
    @classmethod
    def sumarDinero(cls, cantidad):
        cls.dinero += cantidad
    
    @classmethod
    def restarDinero(cls, cantidad):
        cls.dinero -= cantidad
    
    """
    El método verificarTipoMedico se encarga de verificar si el atributo "especialista" de un objeto de la clase Medico 
    proporcionado es igual a un valor del enum tipoMedico; si es el caso entonces retorna True, de lo contrario False. 
    El método recibo como parámetros a tipo, que hace referencia al valor del enum tipoMedico; también recibe medico, que
    es un objeto de la clase Medico al cual se le verificará su especialidad.
    """
    @staticmethod
    def verificarTipoMedico(tipo, medico):
        from gestorAplicacion.personas.Medico import Medico
        if medico.getEspecialista() == tipo:
            return True
        else:
            return False
            
    """
    El método verificarDisponibilidadMedico se encarga de verificar si un médico está disponible para atender una
    consulta en determinada fecha. Se recibe una fecha y un objeto de tipo Medico como parámetros y se verifica para 
    el objeto tipo Medico en su diccionario de consultas si el valor (value) para la fecha especificada (key) es igual
    a None; si es el caso entonces retorna True, de lo contrario False.
    """
    @staticmethod
    def verificarDisponibilidadMedico(fecha, medico):
        from gestorAplicacion.personas.Medico import Medico
        if medico.getConsultas().get(fecha) == None:
            return True
        else:
            return False
        
    """
    El método verificarDisponibilidadConsultorio se encarga de verificar si un consultorio está disponible para atender 
    una consulta en determinada fecha. Se recibe una fecha y un objeto de tipo Consultorio como parámetros y se 
    verifica para el objeto tipo Consultorio en su diccionario de consultas si el valor (value) para la fecha 
    especificada (key) es igual a None; si es el caso entonces retorna True, de lo contrario False.
    """
    @staticmethod
    def verificarDisponibilidadConsultorio(fecha, consultorio):
        from gestorAplicacion.Consultorio import Consultorio
        if consultorio.getConsultas().get(fecha) == None:
            return True
        else:
            return False
    
    """
    
    """
    @staticmethod
    def verificarDisponibilidadFechaExamen(fechas, tipoMedico, medicos, consultorios):
        from gestorAplicacion.personas.Medico import Medico
        from gestorAplicacion.Consultorio import Consultorio
        # Devuelve la fecha más cercana que cumple con tener un consultorio disponible, un médico disponible y que 
        # sea especialista del tipo necesario
        for fecha in fechas:
            # Buscar un médico disponible
            for medico in medicos:
                # Verifica que el médico esté contratado
                if medico.isContratado():
                    # Verificar que el médico es un especialista adecuado para dicho examen
                    if Administrador.verificarTipoMedico(tipoMedico, medico):
                        # Verificar que el médico tenga disponibilidad
                        if Administrador.verificarDisponibilidadMedico(fecha, medico):
                            # Busca un consultorio disponible
                            for consultorio in consultorios:
                                # Verifica que el consultorio esté adquirido
                                if consultorio.isAdquirido():
                                    # Verificar que el consultorio tenga disponibilidad
                                    if Administrador.verificarDisponibilidadConsultorio(fecha, consultorio):
                                        return fecha
                                
                        
    
    """
    
    """
    @staticmethod
    def asignarCita(paciente, medico, consultorio, fecha, motivo, tipo): 
        from gestorAplicacion.personas.Medico import Medico
        from gestorAplicacion.Consultorio import Consultorio
        from gestorAplicacion.Cita import Cita
        from gestorAplicacion.Pago import Pago
        cita = Cita(paciente, medico, consultorio, fecha,motivo, tipo)
        pago = Pago(14700, False)
        cita.setPago(pago)
        pago.setConsulta(cita)
        medico.getConsultas().update({fecha : cita})
        consultorio.getConsultas().update({fecha : cita})
        print(cita.getId())
    
    """
    
    """
    @staticmethod
    def autorizarExamen(examen, tipoMed, medicos):
        from gestorAplicacion.personas.Medico import Medico
        from gestorAplicacion.Examen import Examen
        for medico in medicos:
            # Verifica que el médico esté contratado
            if medico.isContratado():
                # Si hay al menos un médico con la especialidad necesaria para el examen
                if medico.getEspecialista() == tipoMed:
                    # Se genera un número aleatorio para simular posibles fallos a la hora de autorizar el examen
                    x = rd.random()
                    # Si el número aleatorio es mayor a 0.2 entonces se asigna el examen
                    if x > 0.2:
                        examen.setAutorizado(True)
                        Examen.listaExamenes.append(examen)
                        # Autorizado con éxito
                        return 1
                    else:
                        # Lo sentimos ha ocurrido un problema y no se ha podido autorizar el examen
                        return 2
            # Lo sentimos, en este momento no tenemos médicos que puedan atender su tipo de examen
            return 0
    
    """
    
    """
    @staticmethod
    def asignarExamen(examen, paciente, medicos, consultorios, fecha, tipoMedico, tipoExam):
        from gestorAplicacion.personas.Medico import Medico
        from gestorAplicacion.Consultorio import Consultorio
        from gestorAplicacion.personas.Paciente import Paciente
        from gestorAplicacion.Examen import Examen
        from gestorAplicacion.tipoExamen import tipoExamen
        from gestorAplicacion.Pago import Pago
        # Si el examen está autorizado
        if examen.isAutorizado():
            for medico in medicos:
            # Verifica que el médico esté contratado
                if medico.isContratado():
                    # Si hay al menos un médico con la especialidad necesaria para el examen
                    if medico.getEspecialista() == tipoMedico:
                        # Si hay un médico disponible en la fecha
                        if Administrador.verificarDisponibilidadMedico(fecha, medico):
                            examen.setMedico(medico)
                            for consultorio in consultorios:
                                # Verifica que el consultorio esté adquirido
                                if consultorio.isAdquirido():
                                    # Si hay un consultorio disponible en la fehca
                                    if Administrador.verificarDisponibilidadConsultorio(fecha, consultorio):
                                        examen.setConsultorio(consultorio)
                                        examen.setFecha(fecha)
                                        examen.setPago(Pago(None, tipoExam.getValor(), examen))
                                        paciente.getConsultas().update({fecha : examen})
                                        consultorio.getConsultas().update({fecha : examen})
                                        medico.getConsultas().update({fecha : examen})
                                        return f"Examen agendado exitosamente el {fecha} con el médico {examen.getMedico().getNombre()} {examen.getMedico().getApellido()} en el consultorio {examen.getConsultorio().getId()}"
                                    
                                    #return "No se pudo agendar el examen"
                        #return "No se pudo agendar el examen"
        return "No se pudo agendar el examen"