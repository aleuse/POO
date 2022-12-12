from enum import Enum

""" 
La clase tipoExamen de tipo Enum se usa para indicar el tipo de un examen y su correspondiente valor. Hay 4 posibles
objetos que podrían ser creados que son SANGRE, LABORATORIO, RAYOSX y CITOQUIMICO y tienen dos atributos que 
corresponden al tipo de examen (tipoExamen) y su valor asociado.
"""
class tipoExamen(Enum):
    SANGRE = ("SANGRE", 12000)
    LABORATORIO = ("LABORATORIO", 14000)
    RAYOSX = ("RAYOSX", 40000)
    CITOQUIMICO = ("CITOQUIMICO", 12000)
    
    def __init__(self, tipoExamen, valor):
        self._tipoExamen = tipoExamen
        self._valor = valor
        
    # Getters y Setters
    def getTipoExamen(self):
        return self._tipoExamen
    
    def setTipoExamen(self, tipoExamen):
        self._tipoExamen = tipoExamen
        
    def getValor(self):
        return self._valor
    
    def setValor(self, valor):
        self._valor = valor