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
    @classmethod
    def sumarDinero(cls, cantidad):
        cls.dinero += cantidad
    
    @classmethod
    def restarDinero(cls, cantidad):
        cls.dinero -= cantidad
    
    