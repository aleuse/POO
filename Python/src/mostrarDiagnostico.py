#mostrarDiagnostico
from tkinter import *
from tkinter import messagebox
from excepciones.excepcionTipoDatoInt import excepcionTipoDatoInt
from excepciones.excepcionPersistenciaDatos import excepcionPersistenciaDatos
from gestorAplicacion.Consultorio import Consultorio
from gestorAplicacion.fieldFrame import FieldFrame
from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.personas.Medico import Medico
from gestorAplicacion.personas.tipoDocumento import tipoDocumento
from gestorAplicacion.personas.Paciente import Paciente
from gestorAplicacion.tipoCita import tipoCita
class mostrarDiagnostico(Frame):
    def __init__(self):
        super().__init__()
    
        nombre = Label(master=self, text="Mostrar Diagnostico", font="Helvetica 11 bold")
        info = """Aqui podras: Ver tu diagnostico
            """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)
        
        # Se especifican los nombres de los criterios que tendrá el FieldFrame de esta funcionalidad.
        self.criterios = ["Documento del paciente"]
        
        # Se especifican los valores que tendrá el FieldFrame de esta funcionalidad para los criterios anteriormente especificados.
        self.valores = [""]
        # Igualmente, se especifican los valores que estarán habilitados para ser editados por el usuario.
        self.habilitados = [True]
        # Ahora, se especifican las listas de selección que usa la GUI para que el usuario elija entre los valores de la lista.
        self.combobox = [False]
        # Se crea el FieldFrame para esta funcionalidad con los parámetros anteriormente especificados.
        self.dialogos = FieldFrame(self, "Criterios", self.criterios, "Valores", self.valores, self.habilitados, self.combobox)
        self.dialogos.pack(padx=5, pady=5)
        # Se crean además, y debajo del FieldFrame, los botones de Aceptar y Borrar.
        botones = Frame(master=self)
        aceptar = Button(master=botones, text="Aceptar", font="Helvetica 11 bold", 
                         bg="grey", fg="white", borderwidth=3, relief="raised",
                         command=self.aceptar)
        aceptar.pack(side=LEFT, padx=5, pady=5)
        borrar = Button(master=botones, text="Borrar", font="Helvetica 11 bold", 
                         bg="grey", fg="white", borderwidth=3, relief="raised",
                         command=self.borrar)
        borrar.pack(side=RIGHT, padx=5, pady=5)
        botones.pack(padx=5, pady=5)
        
        
    # Por medio del método borrar() se limpian todos los campos del FieldFrame, tanto combobox como entry.
    def borrar(self):
        self.dialogos.getComponente("Documento del paciente").delete(0,"end")
    
    def aceptar(self):
        from gestorAplicacion.personas.Paciente import Paciente
        from gestorAplicacion.Examen import Examen
        from gestorAplicacion.tipoExamen import tipoExamen
        from gestorAplicacion.personas.tipoMedico import tipoMedico

        
        numDocumento = self.dialogos.getValue("Documento del paciente")
        
        paciente = None

        valores = [numDocumento]
        try:
            excepcionPersistenciaDatos.persistenciaDatos(self.criterios, valores)
        except excepcionPersistenciaDatos:
            return

        try:
            excepcionTipoDatoInt.tipoDatoInt(["Documento del paciente"], 
                                     [numDocumento])
        except excepcionTipoDatoInt:
            return
            
        numDocumento = int(numDocumento)
        for e in Administrador.getPacientes():
            if e.getNumeroDocumento() == numDocumento:
                paciente = e
                break
        if paciente == None:
            messagebox.showerror("Error", "Paciente no encontrado")
        else:
            listaDiagnosticos = paciente.getHistoriaClinica().getDiagnosticos()
            for i in listaDiagnosticos:
                messagebox.showinfo("Confirmación", f"El nombre y apellido del paciente es: {i.getPersona().getNombre()} {i.getPersona().getApellido()} \nSu observacion fue: {i.getObservacion()}")
                messagebox.showinfo("Confirmación", f"Su consulta fue en la fecha: {i.getConsulta().getFecha()}\nSu medico fue: {i.getConsulta().getMedico().getNombre()} {i.getConsulta().getMedico().getApellido()}")

            self.borrar()
            