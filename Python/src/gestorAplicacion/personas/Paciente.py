"""
Clase Paciente, para poder almacenar los atributos y aplicar los metodos respecto a los pacientes del sistema.
Se usan listas para guardar los síntomas que tenga el paciente; se usan diccionarios donde se guardan las consultas 
con su respectiva fecha y consulta asignada; las entregas también se guardan en diccionarios con las fechas
y las entregas correspondientes.
"""
from gestorAplicacion.personas.Persona import Persona
class Paciente(Persona):
    def __init__(self, nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion,
                 eps, sintomas = None, historiaClinica = None, consultas = None, entregas = None):
        super().__init__(nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion)
        self._eps = eps
        self._sintomas = sintomas
        self._historiaClinica = historiaClinica
        self._consultas = consultas
        self._entregas = entregas
    
    # Getters y Setters
    def getEps(self):
        return self._eps
    
    def setEps(self, eps):
        self._eps = eps
        
    def getSintomas(self):
        return self._eps
    
    def setSintomas(self, sintomas):
        self._sintomas = sintomas
    
    def getHistoriaClinica(self):
        return self._eps
    
    def setHistoriaClinica(self, historiaClinica):
        self._historiaClinica = historiaClinica
    
    def getConsultas(self):
        return self._consultas
    
    def setConsultas(self, consultas):
        self._consultas = consultas
        
    def getEntregas(self):
        return self._entregas
    
    def setEntregas(self, entregas):
        self._entregas = entregas