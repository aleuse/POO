#La clase HistoriaClinica es en donde se puede ver la historia del paciente.
#Esta clase no tiene metodos asociados
from gestorAplicacion.personas.Administrador import Administrador
class HistoriaClinica:
    def __init__(self, paciente, diagnosticos): 
        self._paciente = paciente
        self._diagnosticos = diagnosticos
        Administrador.historiasClinicas.append(self)
    
    #Getters y Setters
    def getPaciente(self):
        return self._paciente

    def setPaciente(self, paciente):
        self._paciente = paciente

    def getDiagnosticos(self):
        return self._diagnosticos

    def setDiagnosticos(self, diagnosticos):
        self._diagnosticos = diagnosticos        
