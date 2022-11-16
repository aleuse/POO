#La clase Diagnositco se crea para tener asociada el diagnostico que crea
#un medico a un respectivo paciente. Aqui se debe ingresar la persona a la
#cual se le esta creando el diagnostico, la observacion, el medicamento, el
#id del diagnosito y la consulta
#Esta clase no tiene metodos asociados

class Diagnostico:
    def __init__(self, persona, observacion, medicamento, id, consulta): 
        self._persona = persona
        self._observacion = observacion
        self.medicamento = medicamento
        self._id = id
        self.consulta = consulta

    
    #Getters y Setters
    def getPersona(self):
        return self._persona

    def setPersona(self, persona):
        self._persona = persona

    def getObservacion(self):
        return self._observacion

    def setObservacion(self, observacion):
        self._observacion = observacion

    def getId(self):
        return self._id

    def setId(self, id):
        self._id = id

