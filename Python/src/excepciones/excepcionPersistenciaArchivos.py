from excepciones.excepcionPersistencia import excepcionPersistencia
from tkinter import messagebox

class excepcionPersistenciaArchivos(excepcionPersistencia):
    def __init__(self, faltantes):                    
        self._faltantes = faltantes
        super().__init__("Tipo de elemento: Archivo\n Archivos faltantes: " + self._faltantes)

    @classmethod
    def persistenciaArchivos(cls, direcciones):
        mensaje = ""
        advertencia= "Por favor verifique que los siguientes archivos existen en sus respectivos directorios :\n\n"
        faltantes= 0 
        for i in range(len(direcciones)):
            try:
                f= open(direcciones[i], "r") 
            except FileNotFoundError:
                if i == len(direcciones) - 1:
                    mensaje += direcciones[i] +"\n\n" 
                else:                                 
                    mensaje += direcciones[i] + ","
                
                advertencia +=  direcciones[i].split("/")[-1] + "\n" 
                faltantes += 1
                   
        if faltantes > 0 :
            messagebox.showwarning(title= "Advertencia", message= advertencia) 
            raise excepcionPersistenciaArchivos(mensaje)


