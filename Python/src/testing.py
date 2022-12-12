from datetime import datetime
from gestorAplicacion.Examen import Examen
from gestorAplicacion.personas.Paciente import Paciente
from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.personas.Medico import Medico
from gestorAplicacion.Consultorio import Consultorio
from gestorAplicacion.personas.tipoDocumento import tipoDocumento
from gestorAplicacion.personas.tipoMedico import tipoMedico
from gestorAplicacion.tipoCita import tipoCita
from gestorAplicacion.tipoExamen import tipoExamen

medico1 = Medico("Susana", "Perez", tipoDocumento.CEDULA, 1000758374, 25, "Femenino", 1000758374, 
                 "susper@gmail.com", "Cra 77 #45 04", tipoCita.GENERAL, tipoMedico.BACTERIOLOGO, True)
consultorio1 = Consultorio(1, None, None, "Laboratorio", True)

fecha1 = datetime(2022, 10, 15, 12, 30)
fecha2 = datetime(2022, 10, 15, 13, 00)
fecha3 = datetime(2022, 10, 15, 13, 30)
fecha4 = datetime(2022, 10, 15, 14, 00)
fecha5 = datetime(2023,1,3,10,00)
fecha6 = datetime(2023, 2,1,23,00)


Paciente1 = Paciente("Sara", "Marin", tipoDocumento.CEDULA, 1000000000, 20, "Femenino", 2038487, "sama@gmail.com", "calle 36 #89 53", "SURA", None, True)
medico1.getConsultas().update({fecha1 : "Una consulta", fecha2 : "Otra consulta", fecha3 : None, fecha4 : "Consulta"})
consultorio1.getConsultas().update({fecha1 : "Una consulta", fecha2 : "Otra consulta", fecha3 : None, fecha4 : None})
tipoExamen = tipoExamen.SANGRE
tipoMedico = tipoMedico.BACTERIOLOGO
    
def testExamenes():
    examen = Examen(None, Paciente1, tipoExamen)
    solicitudExamen = Paciente1.solicitarExamen(examen, tipoMedico, Administrador.medicos)
        
    if solicitudExamen == 1:
        print("Examen autorizado con éxito")
        fechaExamen = Administrador.verificarDisponibilidadFechaExamen([fecha1, fecha2, fecha3, fecha4], tipoMedico, Administrador.medicos, Administrador.consultorios)
        if fechaExamen == None:
            print("Lo sentimos, en este momento no tenemos disponibilidad")
            
        print(Administrador.asignarExamen(examen, Paciente1, Administrador.medicos, Administrador.consultorios, fechaExamen, tipoMedico, tipoExamen))
    elif solicitudExamen == 2:
        print("Lo sentimos ha ocurrido un problema y no se ha podido autorizar el examen")
    else:
        print("Lo sentimos, en este momento no tenemos médicos que puedan atender su tipo de examen")

print(f"Medico1 en {fecha1} : {Administrador.verificarDisponibilidadMedico(fecha1, medico1)}") # False
print(f"Medico1 en {fecha3} : {Administrador.verificarDisponibilidadMedico(fecha3, medico1)}") # True
print(f"Consultorio1 en {fecha2} : {Administrador.verificarDisponibilidadConsultorio(fecha2, consultorio1)}") # False
print(f"Consultorio1 en {fecha4} : {Administrador.verificarDisponibilidadConsultorio(fecha4, consultorio1)}") # True
print(f"Médicos: {Administrador.medicos} \nConsultorios: {Administrador.consultorios}")
testExamenes()
Cita1 = Paciente1.pedirCita(fecha5, tipoCita.GENERAL, "dolor de cabeza", tipoMedico.BACTERIOLOGO)
cita1 = medico1.getConsultas()[fecha5]
#print(Cita1)
idcita = cita1.getId()
print(idcita)
print(Paciente1.reagendarCita(idcita,fecha6))


