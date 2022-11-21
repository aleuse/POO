class Persona():
	
	#Constructor
    def __init__(self, nombre, apellido, documento, numeroDocumento, edad, genero, telefono, correoElectronico, direccion):
        self.nombre = nombre
        self.apellido = apellido
        self.documento = documento
        self.numeroDocumento = numeroDocumento
        self.edad = edad
        self.genero = genero
        self.telefono = telefono
        self.correoElectronico = correoElectronico
        self.direccion = direccion

    #METODOS
    #Getters y setters, usados para poder modificar y obtener los atributos de la clase
    def getNombre(self):
        return self.nombre

    def setNombre(self, nombre):
        self.nombre= nombre    

    def getApellido(self):
        return self.apellido

    def setApeliido(self, apellido):
        self.apellido = apellido

    def getDocumento(self):
        return self.documento

    def setDocumento(self, documento):
        self.documento = documento

    def getNumeroDocumento(self):
        return self.numeroDocumento
    
    def setNumeroDocumento(self, numeroDocumento):
        self.numeroDocumento = numeroDocumento

    def getEdad(self):
        return self.edad

    def setEdad(self, edad):
        self.edad = edad

    def getGenero(self):
        return self.genero
    
    def setGenero(self, genero):
        self.genero = genero

    def getTelefono(self):
        return self.telefono
        
    def setTelefono(self, telefono):
        self.telefono = telefono 
        
    def getCorreoElectronico(self)	:
        return self.correoElectronico
        
    def setCorreoElectronico(self, correoElectronico):
        self.correoElectronico = correoElectronico
        
        
    def getDireccion(self):
        return self.direccion

    def setDirección(self, direccion):
        self.direccion = direccion

