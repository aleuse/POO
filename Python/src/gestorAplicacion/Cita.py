"""
La clase Cita se utiliza para almacenar los atributos y métodos de las citas agendadas por los pacientes en el sistema.
"""
import random as rd
from gestorAplicacion.Consulta import Consulta
class Cita(Consulta):
    numeroCitas = 0
    listaCitas = []
    def __init__(self, id = int(rd.random() * 10000 + 1), paciente = None, motivo = None, medico = None, 
                 consultorio = None, fecha = None, pago = None, tipoCita = None):
        super().__init__(id, paciente, medico, consultorio, fecha, pago)
        self._motivo = motivo
        self._tipoCita = tipoCita
        Cita.listaCitas.append(self)
    
    # Getters y Setters
    @classmethod
    def getCitas(self):
        return self.listaCitas
    def getMotivo(self):
        return self._motivo
    
    def setMotivo(self, motivo):
        self._motivo = motivo
        
    def getTipoCita(self):
        return self._tipoCita
    
    def setTipoCita(self, tipoCita):
        self._tipoCita = tipoCita

    #metodos
    @classmethod
    def totalCitasAgendadas():
        return len(Cita.listaCitas)
    @classmethod
    def numeroCitasAgendadas():
        return Cita.numeroCitas
    @classmethod
    def datosCita(cls):
        a="Paciente: "+ Consulta.getPaciente()+ "\nMotivo: " + cls.getMotivo + "\nMedico: " + Consulta.getMedico() + "\nConsultorio: " + Consulta.getConsultorio() +"\nFecha: " + Consulta.getFecha()
        return a
    @classmethod
    def informeCitas(cls, solicitado):
        tcSolicitada=0
        for tc in Cita.listaCitas:
            if(tc.getTipoCita == solicitado):
                tcSolicitada +=1
        return tcSolicitada



