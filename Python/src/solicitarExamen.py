from tkinter import *
from tkinter import messagebox
from gestorAplicacion.fieldFrame import FieldFrame
from gestorAplicacion.personas.Administrador import Administrador
from excepciones.excepcionPresenciaDatos import ExcepcionPresenciaDatos
from excepciones.excepcionTipoString import ExcepcionTipoString

class solicitarExamen(Frame):
    def __init__(self):
        super().__init__()
    
        nombre = Label(master=self, text="Solicitar examen", font="Helvetica 11 bold")
        info = """Solicite la autorización y asignación de sus exámenes médicos.
            """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)
        
        # Se especifican los nombres de los criterios que tendrá el FieldFrame de esta funcionalidad.
        self.criterios = ["Documento", "Nombre del paciente", "Apellido", "Tipo de examen"]
        
        # Se especifican los valores que tendrá el FieldFrame de esta funcionalidad para los criterios anteriormente especificados.
        self.valores = [False, False ,False ,False]
        # Igualmente, se especifican los valores que estarán habilitados para ser editados por el usuario.
        self.habilitados = [False, True, True,True]
        # Ahora, se especifican las listas de selección que usa la GUI para que el usuario elija entre los valores de la lista.
        self.combobox = [False, False, False, ["Sangre", "Laboratorio", "Rayos X", "Citoquimico"]]
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
        self.dialogos.getComponente("Documento").delete(0,"end")
        self.dialogos.getComponente("Nombre del paciente").delete(0,"end")
        self.dialogos.getComponente("Apellido").delete(0,"end")
        self.dialogos.getComponente("Tipo de examen").set("")
    
    def aceptar(self):
        from gestorAplicacion.personas.Paciente import Paciente
        from gestorAplicacion.Examen import Examen
        from gestorAplicacion.tipoExamen import tipoExamen
        from gestorAplicacion.personas.tipoMedico import tipoMedico
        
        nombrePaciente = self.dialogos.getValue("Nombre del paciente")
        apellido = self.dialogos.getValue("Apellido")
        tipoEx = self.dialogos.getValue("Tipo de examen")
        
        
        #print(numDocumento)
        paciente = None
        tipoExam = None
        tipoMed = None
        
        valores = [nombrePaciente, apellido, tipoEx]
        try:
            ExcepcionPresenciaDatos.presenciaDatos(self.criterios, valores)
        except ExcepcionPresenciaDatos:
            return
        
        try:
            ExcepcionTipoString.tipoString(["Nombre del paciente"], 
                                     [nombrePaciente])
        except ExcepcionTipoString:
            return
        
        try:
            ExcepcionTipoString.tipoString(["Apellido"], 
                                     [apellido])
        except ExcepcionTipoString:
            return
    
        
        for pac in Administrador.getPacientes():
            #print(pac.getNumeroDocumento())
            if pac.getNombre() == nombrePaciente and pac.getApellido() == apellido:
                paciente = pac
                break
            
        if paciente == None:
            messagebox.showerror("Error", "Paciente no encontrado")
        else:
            if tipoEx == "Sangre":
                tipoExam = tipoExamen.SANGRE
                tipoMed = tipoMedico.BACTERIOLOGO
            elif tipoEx == "Laboratorio":
                tipoExam = tipoExamen.LABORATORIO
                tipoMed = tipoMedico.BACTERIOLOGO
            elif tipoEx == "Rayos X":
                tipoExam = tipoExamen.RAYOSX
                tipoMed = tipoMedico.GENERAL
            elif tipoEx ==  "Citoquimico":
                tipoExam = tipoExamen.CITOQUIMICO
                tipoMed = tipoMedico.BACTERIOLOGO
            
            
            examen = Examen(None, paciente, tipoExam)
            solicitudExamen = paciente.solicitarExamen(examen, tipoMed, Administrador.getMedicos())
            
            if solicitudExamen == 1:
                messagebox.showinfo("Confirmación", "Examen autorizado con éxito, ahora se asignará su examen")
                fechaExamen = Administrador.verificarDisponibilidadFechaExamen(Administrador.getFechas(), tipoMed, Administrador.getMedicos(), Administrador.getConsultorios())
                if fechaExamen == None:
                    messagebox.showerror("Error", "Lo sentimos, en este momento no tenemos disponibilidad")
                
                messagebox.showinfo("Confirmación", Administrador.asignarExamen(examen, paciente, Administrador.getMedicos(), Administrador.getConsultorios(), fechaExamen, tipoMed, tipoExam))
            elif solicitudExamen == 2:
                messagebox.showerror("Error", "Lo sentimos ha ocurrido un problema y no se ha podido autorizar el examen")
            else:
                messagebox.showerror("Error", "Lo sentimos, en este momento no tenemos médicos que puedan atender su tipo de examen")
            
            
            self.borrar()
        
        
        