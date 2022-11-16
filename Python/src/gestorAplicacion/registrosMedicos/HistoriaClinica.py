#La clase HistoriaClinica es en donde se puede ver la historia del paciente.
#Esta clase no tiene metodos asociados

class HistoriaClinica:
    def __init__(self, paciente): 
        self._paciente = paciente

    
    #Getters y Setters
    def getPaciente(self):
        return self._paciente

    def setPaciente(self, paciente):
        self._paciente = paciente

        
