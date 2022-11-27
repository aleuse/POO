"""
La clase Consultorio es utilizada para almacenar los atributos y aplciar cambios a los consultorios del sistema.
Se tienen atributos como Id, el tipo de consultorio y un diccionario de las consultas que el consultorio tiene asignadas
en determinadas fechas.
"""
from gestorAplicacion.personas.Administrador import Administrador
import random as rd
class Consultorio():
    consultorios=[]
    def __init__(self, id = int(rd.random() * 10000 + 1), medico = None, paciente = None, tipoConsultorio = None, 
                adquirido = False, disponibilidad = True, consultas = None, costo = 100000):
        if consultas is None:
            consultas = {}
        self._id = id
        self._medico = medico
        self._paciente = paciente
        self._tipoConsultorio = tipoConsultorio
        self._disponibilidad = disponibilidad
        self._consultas = consultas
        self._adquirido = adquirido
        self._costo = costo
        Administrador.consultorios.append(self)
    
    # Getters y Setters
    def getId(self):
        return self._id
    
    def setId(self, id):
        self._id = id
    
    def getMedico(self):
        return self._medico
    
    def setMedico(self, medico):
        self._medico = medico
    
    def getPaciente(self):
        return self._paciente
    
    def setPaciente(self, paciente):
        self._paciente = paciente
    
    def getTipoConsultorio(self):
        return self._tipoConsultorio
    
    def setTipoConsultorio(self, tipoConsultorio):
        self._tipoConsultorio = tipoConsultorio
    
    def isDisponibilidad(self):
        return self._disponibilidad
    
    def setDisponibilidad(self, disponibilidad):
        self._disponibilidad = disponibilidad
        
    def getConsultas(self):
        return self._consultas
    
    def setConsultas(self, consultas):
        self._consultas = consultas
        
    def isAdquirido(self):
        return self._adquirido
    
    def setAdquirido(self, adquirido):
        self._adquirido =adquirido
    
    def getCosto(self):
        return self._costo
    
    def setCosto(self, costo):
        self._costo = costo
    
        
            