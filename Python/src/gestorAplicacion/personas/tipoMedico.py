from enum import Enum

""" 
La clase tipoMedico de tipo Enum sirve para indicar la especialidad o tipo de médico de un objeto de la clase 
Medico. Hay 5 posibles objetos que podrían ser creados que son GENERAL, OPTOMETRA, FONOAUDIOLOGO, PEDIATRA y 
BACTERIOLOGO y tienen el atributo tipoMedico.
"""
class tipoMedico(Enum):
    GENERAL = "GENERAL"
    OPTOMETRA = "OPTOMETRA"
    FONOAUDIOLOGO = "FONOAUDIOLOGO"
    PEDIATRA = "PEDIATRA"
    BACTERIOLOGO = "BACTERIOLOGO"
    
    def __init__(self, tipoMedico):
        self._tipoMedico = tipoMedico
    
    # Getters y Setters
    def getTipoMedico(self):
        return self._tipoMedico
    
    def setTipoMedico(self, tipoMedico):
        self._tipoMedico = tipoMedico