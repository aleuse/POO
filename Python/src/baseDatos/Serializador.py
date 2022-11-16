"""
Serializador fue creada para realizar, como su nombre indica, la serialización de los objetos creados y que
estos puedan ser almacenamos para su posterior deserialización y de esta forma ser utilizados en la aplicación.
"""
import os
import pathlib
import pickle

from gestorAplicacion.personas.Administrador import Administrador


# Se llaman a todas las funciones de serilización
def serializar():
    serializarAdministrador()
    serializarConsultas()
    serializarConsultorios()
    serializarDiagnosticos()
    serializarFechas()
    serializarHistoriasClinicas()
    serializarListaSintomas()
    serializarMedicamentos()
    serializarMedicos()
    serializarPacientes()

def serializarAdministrador():
    # Creación y apertura del archivo donde serán guardados los objetos
    archivoAdministrador = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\administrador"), "wb")
    # Se indica el objeto que será serializado. En este, caso el dinero que tiene el administrador
    pickle.dump(Administrador.getDinero(), archivoAdministrador)
    # Se cierra el archivo creado
    archivoAdministrador.close()

def serializarConsultas():
    # Creación y apertura del archivo donde serán guardados los objetos
    archivoConsultas = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\consultas"), "wb")
    # Se indica el objeto que será serializado. En este, caso la lista de consultas
    pickle.dump(Administrador.getConsultas(), archivoConsultas)
    # Se cierra el archivo creado
    archivoConsultas.close()
    
def serializarConsultorios():
    # Creación y apertura del archivo donde serán guardados los objetos
    archivoConsultorios = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\consultorios"), "wb")
    # Se indica el objeto que será serializado. En este, caso la lista de consultorios
    pickle.dump(Administrador.getConsultorios(), archivoConsultorios)
    # Se cierra el archivo creado
    archivoConsultorios.close()
    
def serializarDiagnosticos():
    # Creación y apertura del archivo donde serán guardados los objetos
    archivoDiagnosticos = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\diagnosticos"), "wb")
    # Se indica el objeto que será serializado. En este caso, la lista de diagnósticos
    pickle.dump(Administrador.getDiagnosticos(), archivoDiagnosticos)
    # Se cierra el archivo creado
    archivoDiagnosticos.close()

def serializarFechas():
    # Creación y apertura del archivo donde serán guardados los objetos
    archivoFechas = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\fechas"), "wb")
    # Se indica el objeto que será serializado. En este caso, la lista de fechas para las consultas
    pickle.dump(Administrador.getFechas(), archivoFechas)
    # Se cierra el archivo creado
    archivoFechas.close()

def serializarHistoriasClinicas():
    # Creación y apertura del archivo donde serán guardados los objetos
    archivoHistoriasClinicas = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\historiasClinicas"), "wb")
    # Se indica el objeto que será serializado. En este caso, la lista de historias clínicas
    pickle.dump(Administrador.getHistoriasClinicas(), archivoHistoriasClinicas)
    # Se cierra el archivo creado
    archivoHistoriasClinicas.close()

def serializarListaSintomas():
    # Creación y apertura del archivo donde serán guardados los objetos
    archivoListaSintomas = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\listaSintomas"), "wb")
    # Se indica el objeto que será serializado. En este caso, la lista de síntomas
    pickle.dump(Administrador.getListaSintomas(), archivoListaSintomas)
    # Se cierra el archivo creado
    archivoListaSintomas.close()

def serializarMedicamentos():
    # Creación y apertura del archivo donde serán guardados los objetos
    archivoMedicamentos = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\medicamentos"), "wb")
    # Se indica el objeto que será serializado. En este caso, la lista de medicamentos
    pickle.dump(Administrador.getMedicamentos(), archivoMedicamentos)
    # Se cierra el archivo creado
    archivoMedicamentos.close()
    
def serializarMedicos():
    # Creación y apertura del archivo donde serán guardados los objetos
    archivoMedicos = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\medicos"), "wb")
    # Se indica el objeto que será serializado. En este caso, la lista de médicos
    pickle.dump(Administrador.getMedicos(), archivoMedicos)
    # Se cierra el archivo creado
    archivoMedicos.close()
    
def serializarPacientes():
    # Creación y apertura del archivo donde serán guardados los objetos
    archivoPacientes = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\pacientes"), "wb")
    # Se indica el objeto que será serializado. En este caso, la lista de pacientes
    pickle.dump(Administrador.getPacientes(), archivoPacientes)
    # Se cierra el archivo creado
    archivoPacientes.close()