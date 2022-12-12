from enum import Enum

""" 
La clase tipoCita de tipo Enum sirve para saber el tipo de una cita y el costo asociado a esta. Hay 6 posibles objetos
que podrían ser creados que son GENERAL, PRIORITARIA, OPTOMETRIA, AUDIOMETRIA, PEDIATRIA y LABORATORIO y tienen dos 
atributos que son el tipo de la cita (tipoCita) y su correspondiente valor.
"""
class tipoCita(Enum):
    GENERAL = ("GENERAL", 14700)
    PRIORITARIA = ("PRIORITARIA", 14700)
    OPTOMETRIA = ("OPTOMETRIA", 25000)
    AUDIOMETRIA = ("AUDIOMETRIA", 25000)
    PEDIATRIA = ("PEDIATRIA", 25000)
    LABORATORIO = ("LABORATORIO", 25000)
    
    def __init__(self, tipoCita, valor):
        self._tipoCita = tipoCita
        self._valor = valor
    
    # Getters y Setters
    def getTipoCita(self):
        return self._tipoCita
    
    def setTipoCita(self, tipoCita):
        self._tipoCita = tipoCita
    
    def getValor(self):
        return self._valor
    
    def setValor(self, valor):
        self._valor = valor