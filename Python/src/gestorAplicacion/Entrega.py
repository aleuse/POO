
import random as rd
class Entrega():
    lista=[]
    # constructor
    def __init__(self, id, paciente, domicilio, medicamentos, estado):
        self.id = ((rd.random() * 10000 + 1))
        self.paciente = paciente
        self.domicilio = domicilio
        self.medicamentos = medicamentos
        self.estado = estado
        self.lista.add(self)

    # getter & setter
    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id

    def getPaciente(self):
        return self.paciente

    def setPaciente(self, paciente):
        self.paciente = paciente

    def getDomicilio(self):
        return self.domicilio

    def setDomicilio(self, domicilio):
        self.domicilio = domicilio

    def getMedicamentos(self):
        return self.medicamentos

    def setMedicamentos(self, medicamentos):
        self.medicamentos = medicamentos

    def getEstado(self):
        return self.estado

    def setEstado(self, estado):
        self.estado = estado

    def getPago(self):
        return self.pago

    def setPago(self, pago):
        self.pago = pago

    # metodos
    @classmethod
    def crearEntrega(cls, id, paciente, domicilio, medicamentos, estado):
        Entrega(id, paciente, domicilio, medicamentos, estado)

    @classmethod
    def informeEntregas(cls, solicitado):
        #  se ingresa el tipo de entrega y se busca en la lista cuantas hay
        eeSolicitada = 0
        for ee in Entrega.lista :
            if ee.getEstado() == solicitado:
                eeSolicitada += 1
        return eeSolicitada