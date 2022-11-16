"""
La clase Cita se utiliza para almacenar los atributos y métodos de los exámenes agendadas por los 
pacientes en el sistema.
"""
from gestorAplicacion.Consulta import Consulta
import random as rd
class Examen(Consulta):
    listaExamenes = []
    def __init__(self, id = int(rd.random() * 10000 + 1), paciente = None, tipoExamen = None, medico = None, 
                 consultorio = None, fecha = None, pago = None, autorizado = False):
        super().__init__(id, paciente, medico, consultorio, fecha, pago)
        self._tipoExamen = tipoExamen
        self._autorizado = autorizado
        Examen.listaExamenes.append(self)
    
    # Getters y Setters
    def getTipoExamen(self):
        return self._tipoExamen
    
    def setTipoExamen(self, tipoExamen):
        self._tipoExamen = tipoExamen
        
    def isAutorizado(self):
        return self._autorizado
    
    def setAutorizado(self, autorizado):
        self._autorizado = autorizado