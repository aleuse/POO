"""
La clase Consulta tiene el fin de ser la clase padre de Cita y Examen agrupando así los atributos y métodos comunes para
estas dos subclases.
"""
import random as rd
class Consulta():
    def __init__(self, id = int(rd.random() * 10000 + 1), paciente = None, medico = None, consultorio = None, 
                 fecha = None, pago = None):
        self._id = id
        self._paciente = paciente
        self._medico = medico
        self._consultorio = consultorio
        self._fecha = fecha
        self._pago = pago
    
    # Getters y Setters
    def getId(self):
        return self._id
    
    def setId(self, id):
        self._id = id
        
    def getPaciente(self):
        return self._paciente
    
    def setPaciente(self, paciente):
        self._paciente = paciente
    
    def getMedico(self):
        return self._medico
    
    def setMedico(self, medico):
        self._medico = medico
        
    def getConsultorio(self):
        return self._consultorio
    
    def setConsultorio(self, consultorio):
        self._consultorio = consultorio
        
    def getFecha(self):
        return self._fecha
    
    def setFecha(self, fecha):
        self._fecha = fecha
    
    def getPago(self):
        return self._pago
    
    def setPago(self, pago):
        self._pago = pago