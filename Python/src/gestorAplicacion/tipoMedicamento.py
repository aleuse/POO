from enum import Enum

""" 
La clase TipoMedicamento de tipo Enum es utilizada para indicar el tipo de un medicamento y su costo asociado. Hay 4
posibles objetos que podrían ser creados que son ACETAMINOFEN, AMOXICILINA, IBUPROFENO y LAGRIMAS_ARTIFICIALES con
su atributo de tipoMedicamento que indica su tipo y su atributo costo que indica el costo de dicho medicamento por
unidad (en el caso de Lágrimas artificiales es por frasco).

"""
class tipoMedicamento(Enum):
    ACETAMINOFEN = ("ACETAMINOFEN", 140)
    AMOXICILINA = ("AMOXICILINA", 250)
    IBUPROFENO = ("IBUPROFENO", 190)
    LAGRIMAS_ARTIFICIALES = ("LAGRIMAS_ARTIFICIALES", 8000)
    
    def __init__(self, tipoMedicamento, costo):
        self._tipoMedicamento = tipoMedicamento
        self._costo = costo
    
    # Getters y Setters
    def getTipoMedicamento(self):
        return self._tipoMedicamento
    
    def setTipoMedicamento(self, tipoMedicamento):
        self._tipoMedicamento = tipoMedicamento
        
    def getCosto(self):
        return self._costo
    
    def setCosto(self, costo):
        self._costo = costo