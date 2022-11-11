""" 
La clase Administrador tiene el fin de llevar la economía del sistema médico asociada al dinero disponible y la 
administración de este. También se encarga de procesos administrativos y logísticos como verificar la disponibilidad
de médicos y/o consultorios; asignar citas a los pacientes cuando soliciten una; autorizar y asignar los exámenes
solicitados por los pacientes; entre otras.
"""
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
    
    