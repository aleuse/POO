from enum import Enum

""" 
La clase tipoDocumento de tipo Enum sirve para definir el tipo de documento que pueden tener los objetos de la 
clase Persona y sus subclases. Hay 3 posibles objetos que podrán ser creados que son CEDULA, TARJETA_DE_IDENTIDAD
y CEDULA_DE_EXTRANJERIA que tienen el atributo tipoDoc
"""
class tipoDocumento(Enum):
    CEDULA = "Cédula"
    TARJETA_DE_IDENTIDAD = "Tarjeta de identidad"
    CEDULA_DE_EXTRANJERIA = "Cédula de extranjería"
    
    def __init__(self, tipoDoc):
        self._tipoDoc = tipoDoc
        
    # Getters y Setters
    def getTipoDoc(self):
        return self._tipoDoc
    
    def setTipoDoc(self, tipoDoc):
        self._tipoDoc = tipoDoc