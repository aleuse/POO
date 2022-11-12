"""
La clase Persona tiene el fin de ser la clase padre de Medico y Paciente agrupando atributos compartidos entre ambas 
subclases como nombre, apellido, entre otros.
"""
class Persona():
    def __init__(self, nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion):
        self._nombre = nombre
        self._apellido = apellido
        self._documento = documento
        self._numeroDocumento = numeroDocumento
        self._edad = edad
        self._genero = genero
        self._telefono = telefono
        self._correoElectronico = correoElectronico
        self._direccion = direccion
    
    # Getters y Setters  
    def getNombre(self):
        return self._nombre

    def setNombre(self, nombre):
        self._nombre = nombre

    def getApellido(self):
        return self._apellido

    def setApellido(self, apellido):
        self._apellido = apellido

    def getDocumento(self):
        return self._documento

    def setDocumento(self, documento):
        self._documento = documento

    def getNumeroDocumento(self):
        return self._numeroDocumento

    def setNumeroDocumento(self, numeroDocumento):
        self._numeroDocumento = numeroDocumento

    def getEdad(self):
        return self._edad

    def setEdad(self, edad):
        self._edad = edad

    def getGenero(self):
        return self._genero

    def setGenero(self, genero):
        self._genero = genero

    def getTelefono(self):
        return self._telefono

    def setTelefono(self, telefono):
        self._telefono = telefono

    def getCorreoElectronico(self):
        return self._correoElectronico

    def setCorreoElectronico(self, correoElectronico):
        self._correoElectronico = correoElectronico

    def getDireccion(self):
        return self._direccion

    def setDireccion(self, direccion):
        self._direccion = direccion