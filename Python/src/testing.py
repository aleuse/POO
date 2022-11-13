from datetime import datetime
from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.personas.Medico import Medico
from gestorAplicacion.personas.tipoDocumento import tipoDocumento
from gestorAplicacion.personas.tipoMedico import tipoMedico
from gestorAplicacion.tipoCita import tipoCita

medico1 = Medico("Susana", "Perez", tipoDocumento.CEDULA, 1000758374, 25, "Femenino", 1000758374, 
                 "susper@gmail.com", "Cra 77 #45 04", tipoCita.GENERAL, tipoMedico.BACTERIOLOGO)
fecha1 = datetime(2022, 10, 15, 12, 30)
fecha2 = datetime(2022, 10, 15, 13, 00)
fecha3 = datetime(2022, 10, 15, 13, 30)
fecha4 = datetime(2022, 10, 15, 14, 00)
medico1.getConsultas().update({fecha1 : "Una consulta", fecha2 : "Otra consulta", fecha3 : None, fecha4 : "Consulta"})

print(f"{fecha1} : {Administrador.verificarDisponibilidadMedico(fecha1, medico1)}") # False
print(f"{fecha3} : {Administrador.verificarDisponibilidadMedico(fecha3, medico1)}") # True