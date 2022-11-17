from datetime import datetime
from gestorAplicacion.personas.Paciente import Paciente
from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.personas.Medico import Medico
from gestorAplicacion.Consultorio import Consultorio
from gestorAplicacion.personas.tipoDocumento import tipoDocumento
from gestorAplicacion.personas.tipoMedico import tipoMedico
from gestorAplicacion.tipoCita import tipoCita

medico1 = Medico("Susana", "Perez", tipoDocumento.CEDULA, 1000758374, 25, "Femenino", 1000758374, 
                 "susper@gmail.com", "Cra 77 #45 04", tipoCita.GENERAL, tipoMedico.BACTERIOLOGO)
consultorio1 = Consultorio(1, None, None, "Laboratorio")

fecha1 = datetime(2022, 10, 15, 12, 30)
fecha2 = datetime(2022, 10, 15, 13, 00)
fecha3 = datetime(2022, 10, 15, 13, 30)
fecha4 = datetime(2022, 10, 15, 14, 00)

Paciente1 = Paciente("Sara", "Marin", tipoDocumento.CEDULA, 1000000000, 20, "Femenino", 2038487, "sama@gmail.com", "calle 36 #89 53", "SURA", None, True)
medico1.getConsultas().update({fecha1 : "Una consulta", fecha2 : "Otra consulta", fecha3 : None, fecha4 : "Consulta"})
consultorio1.getConsultas().update({fecha1 : "Una consulta", fecha2 : "Otra consulta", fecha3 : "Consulta", fecha4 : None})

print(f"Medico1 en {fecha1} : {Administrador.verificarDisponibilidadMedico(fecha1, medico1)}") # False
print(f"Medico1 en {fecha3} : {Administrador.verificarDisponibilidadMedico(fecha3, medico1)}") # True
print(f"Consultorio1 en {fecha2} : {Administrador.verificarDisponibilidadConsultorio(fecha2, consultorio1)}") # False
print(f"Consultorio1 en {fecha4} : {Administrador.verificarDisponibilidadConsultorio(fecha4, consultorio1)}") # True
print(Paciente1.pedirCita(fecha1, tipoCita.GENERAL, "dolor de cabeza", tipoMedico.BACTERIOLOGO))

