"""

"""
import random as rd
class Pago():
    def __init__(self, id = int(rd.random() * 10000 + 1), valor = None, consulta = None, medico = None,
                pagado = False, entrega = None):
        self._id = id
        self._valor = valor
        self._consulta = consulta
        self._medico = medico
        self._pagado = pagado
        self._entrega = entrega
    
    # Getters y Setters
    def getId(self):
        return self._id
    
    def setId(self, id):
        self._id = id
        
    def getValor(self):
        return self._valor
    
    def setValor(self, valor):
        self._valor = valor
        
    def getConsulta(self):
        return self._consulta
    
    def setConsulta(self, consulta):
        self._consulta = consulta
        
    def getMedico(self):
        return self._medico
    
    def setMedico(self, medico):
        self._medico = medico
        
    def isPagado(self):
        return self._pagado
    
    def setPagado(self, pagado):
        self._pagado = pagado
        
    def getEntrega(self):
        return self._entrega
    
    def setEntrega(self, entrega): 
        self._entrega = entrega