""" 
La clase Administrador tiene el fin de llevar la economía del sistema médico asociada al dinero disponible y la 
administración de este. También se encarga de procesos administrativos y logísticos como verificar la disponibilidad
de médicos y/o consultorios; asignar citas a los pacientes cuando soliciten una; autorizar y asignar los exámenes
solicitados por los pacientes; entre otras.
"""
class Administrador:
    # Dinero es un atributo de clase público
    dinero = 0
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
    
    