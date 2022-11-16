"""
Deserializador fue creado para, como su nombre indica, poder deserializar los objetos que se hayan creado y poder
utilizarlos en la aplicación.
"""
import os
import pathlib
import pickle

from gestorAplicacion.personas.Administrador import Administrador


# Se llaman a todas las funciones de deserialización
def deserializar():
    deserializarAdministrador()
    deserializarConsultas()
    deserializarConsultorios()
    deserializarDiagnosticos()
    deserializarFechas()
    deserializarHistoriasClinicas()
    deserializarListaSintomas()
    deserializarMedicamentos()
    deserializarMedicos()
    deserializarPacientes()

def deserializarAdministrador():
    # Apertura del archivo de donde se leerán los objetos
    archivoAdministrador = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\administrador"), "rb")
    # Se indica la variable que será deserializada. En este, caso el dinero que tiene el administrador
    Administrador.setDinero(pickle.load(archivoAdministrador))
    # Se cierra el archivo creado
    archivoAdministrador.close()

def deserializarConsultas():
    # Apertura del archivo de donde se leerán los objetos
    archivoConsultas = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\consultas"), "rb")
    # Se indica la variable que será deserializada. En este, caso la lista de consultas
    Administrador.setConsultas(pickle.load(archivoConsultas))
    # Se cierra el archivo creado
    archivoConsultas.close()
    
def deserializarConsultorios():
    # Apertura del archivo de donde se leerán los objetos
    archivoConsultorios = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\consultorios"), "rb")
    # Se indica la variable que será deserializada. En este, caso la lista de consultorios
    Administrador.setConsultorios(pickle.load(archivoConsultorios))
    # Se cierra el archivo creado
    archivoConsultorios.close()
    
def deserializarDiagnosticos():
    # Apertura del archivo de donde se leerán los objetos
    archivoDiagnosticos = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\diagnosticos"), "rb")
    # Se indica la variable que será deserializada. En este, caso la lista de diagnósticos
    Administrador.setDiagnosticos(pickle.load(archivoDiagnosticos))
    # Se cierra el archivo creado
    archivoDiagnosticos.close()

def deserializarFechas():
    # Apertura del archivo de donde se leerán los objetos
    archivoFechas = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\fechas"), "rb")
    # Se indica la variable que será deserializada. En este, caso la lista de fechas para las consultas
    Administrador.setFechas(pickle.load(archivoFechas))
    # Se cierra el archivo creado
    archivoFechas.close()

def deserializarHistoriasClinicas():
    # Apertura del archivo de donde se leerán los objetos
    archivoHistoriasClinicas = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\historiasClinicas"), "rb")
    # Se indica la variable que será deserializada. En este, caso la lista de historias clínicas
    Administrador.setHistoriasClinicas(pickle.load(archivoHistoriasClinicas))
    # Se cierra el archivo creado
    archivoHistoriasClinicas.close()

def deserializarListaSintomas():
    # Apertura del archivo de donde se leerán los objetos
    archivoListaSintomas = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\listaSintomas"), "rb")
    # Se indica la variable que será deserializada. En este, caso la lista de síntomas
    Administrador.setListaSintomas(pickle.load(archivoListaSintomas))
    # Se cierra el archivo creado
    archivoListaSintomas.close()

def deserializarMedicamentos():
    # Apertura del archivo de donde se leerán los objetos
    archivoMedicamentos = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\medicamentos"), "rb")
    # Se indica la variable que será deserializada. En este, caso la lista de medicamentos
    Administrador.setMedicamentos(pickle.load(archivoMedicamentos))
    # Se cierra el archivo creado
    archivoMedicamentos.close()
    
def deserializarMedicos():
    # Apertura del archivo de donde se leerán los objetos
    archivoMedicos = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\medicos"), "rb")
    # Se indica la variable que será deserializada. En este, caso la lista de medicos
    Administrador.setMedicos(pickle.load(archivoMedicos))
    # Se cierra el archivo creado
    archivoMedicos.close()
    
def deserializarPacientes():
    # Apertura del archivo de donde se leerán los objetos
    archivoPacientes = open(os.path.join(pathlib.Path(__file__).parent.absolute(), "temp\\pacientes"), "rb")
    # Se indica la variable que será deserializada. En este, caso la lista de pacientes
    Administrador.setPacientes(pickle.load(archivoPacientes))
    # Se cierra el archivo creado
    archivoPacientes.close()