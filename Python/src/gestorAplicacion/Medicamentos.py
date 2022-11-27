from gestorAplicacion.tipoMedicamento import tipoMedicamento
class Medicamentos:
    cantAcetaminofen =100
    cantAmoxicilina =100
    cantIbuprofeno =100
    cantLagrimasArtificiales =20
    _medicamiento = []

    #constructor
    def __init__(self, tipoMed, paciente, dosis, modoUso):
        self._tipoMed = tipoMed
        self._paciente = paciente
        self._dosis = dosis #cantidad a consumir
        self._modoUso = modoUso #consumir cada x horas
        self._medicamiento.append(self)
    
    #getter & setter
    def getTipoMed(self):
        return self._tipoMed
    def setTipoMed(self, tipoMed):
        self._tipoMed = tipoMed

    def getPaciente(self):
        return self._paciente
    def setPaciente(self, paciente):
        self._paciente = paciente

    def getDosis(self):
        return self._dosis
    def setDosis(self, dosis):
        self._dosis = dosis

    def getModoUso(self):
        return self._modoUso
    def setModoUso(self, modoUso):
        self._modoUso = modoUso

    def getMedicamiento(self):
        return self._medicamiento

    def setMedicamiento(self, medicamiento):
        self._medicamiento = medicamiento

    #metodos
    #resta la cantidad de medicamento asignado del inventario de medicamentos
    @staticmethod
    def asignarMed(eleccion, cantidad):
        if eleccion == tipoMedicamento.tipoMedicamento.ACETAMINOFEN.value[0]: #"ACETAMINOFEN"
            Medicamentos.cantAcetaminofen=Medicamentos.cantAcetaminofen-cantidad
        elif eleccion == tipoMedicamento.tipoMedicamento.AMOXICILINA.value[0]:
            Medicamentos.cantAmoxicilina=Medicamentos.cantAmoxicilina-cantidad
        elif eleccion == tipoMedicamento.tipoMedicamento.IBUPROFENO.value[0]:
            Medicamentos.cantIbuprofeno=Medicamentos.cantIbuprofeno-cantidad
        else:
            Medicamentos.cantLagrimasArtificiales=Medicamentos.cantLagrimasArtificiales-cantidad
    
    

