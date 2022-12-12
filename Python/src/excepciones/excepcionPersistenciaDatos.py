from excepciones.excepcionPersistencia import excepcionPersistencia
from tkinter import messagebox

class excepcionPersistenciaDatos(excepcionPersistencia):
    def __init__(self, faltantes):
        self._faltantes = faltantes
        super().__init__("Tipo de elemento: Dato\nDatos faltantes: " + self._faltantes)
        
    @classmethod
    def persistenciaDatos(cls, criterios, valores):
        mensaje = ""
        advertencia = "Por favor llene todos los campos.\nLos siguientes campos faltan por llenar:\n\n"
        faltantes = 0 
        for i in range(len(valores)):
            if valores[i] == "": 
                if i == len(valores)-1:
                    mensaje += criterios[i] + "\n\n"
                else:                                
                    mensaje += criterios[i] + ", "
                advertencia += criterios[i] + "\n" 
                faltantes += 1
        if faltantes > 0:
            messagebox.showwarning(title="Advertencia",
                                   message=advertencia)
            raise excepcionPersistenciaDatos(mensaje)