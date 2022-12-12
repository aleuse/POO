from excepciones.errorAplicacion import errorAplicacion

class excepcionTipoDato(errorAplicacion): 
    def __init__(self, mensaje):
        super().__init__("El tipo de dato no corresponde al dato solicitado\n" + mensaje)
        self._mensaje = mensaje
        