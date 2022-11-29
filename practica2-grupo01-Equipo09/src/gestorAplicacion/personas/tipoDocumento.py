from enum import Enum

""" 
La clase tipoDocumento de tipo Enum sirve para definir el tipo de documento que pueden tener los objetos de la 
clase Persona y sus subclases. Hay 3 posibles objetos que podrán ser creados que son CEDULA, TARJETA_DE_IDENTIDAD
y CEDULA_DE_EXTRANJERIA que tienen el atributo tipoDocumento.
"""
class tipoDocumento(Enum):
    CEDULA = "CEDULA"
    TARJETA_DE_IDENTIDAD = "TARJETA_DE_IDENTIDAD"
    CEDULA_DE_EXTRANJERIA = "CEDULA_DE_EXTRANJERIA"
    
    def __init__(self, tipoDocumento):
        self._tipoDocumento = tipoDocumento
        
    # Getters y Setters
    def getTipoDocumento(self):
        return self._tipoDocumento
    
    def setTipoDocumento(self, tipoDocumento):
        self._tipoDocumento = tipoDocumento