from excepciones.errorAplicacion import errorAplicacion 

class excepcionPersistencia(errorAplicacion):
    def __init__(self, mensaje):
        self._mensaje = mensaje
        super().__init__("No se ha encontrado el elemento al que se hace referencia\n" + self._mensaje)
        