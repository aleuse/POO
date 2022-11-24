from tkinter import *
from tkinter import messagebox
from gestorAplicacion.fieldFrame import FieldFrame
from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.personas.tipoMedico import tipoMedico
from gestorAplicacion.tipoCita import tipoCita
class solicitarCita(Frame):
    def __init__(self):
        super().__init__()
    
        nombre = Label(master=self, text="Solicitar cita", font="Helvetica 11 bold")
        info = """XXXXXXXXXXXXXXX.
            """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)
        
        # Se especifican los nombres de los criterios que tendrá el FieldFrame de esta funcionalidad.
        self.criterios = ["Nombre", "Apellido", "Fecha", "Tipo de Cita", "Motivo"]

        # Se especifican los valores que tendrá el FieldFrame de esta funcionalidad para los criterios anteriormente especificados.
        self.valores = ["", "", False, False, ""]
        # Igualmente, se especifican los valores que estarán habilitados para ser editados por el usuario.
        self.habilitados = [True, True, True,True,True]
        #Se especifican las listas de selección que una la GUI para que el usuario elija entre los valores de la lista
        self.combobox = [False, False, Administrador.getFechas(), ["General", "Prioritaria", "Optometria", "Audiometria", "Pediatría", "Laboratorio"], False]
        # Se crea el FieldFrame para esta funcionalidad con los parámetros anteriormente especificados.
        self.dialogos = FieldFrame(self, "Criterios", self.criterios, "Valores", self.valores, self.habilitados, self.combobox)
        self.dialogos.pack(padx=5, pady=5)
        #Se crean los botones de aceptar y borrar
        botones = Frame(master=self)
        aceptar = Button(master = botones, text = "Aceptar", font = "Helvetica 11 bold",
                         bg = "grey", fg = "white", borderwidth=3, relief = "raised", command=self.aceptar)
        aceptar.pack(side = LEFT, padx = 5, pady = 5)
        borrar = Button(master=botones, text="Borrar", font="Helvetica 11 bold", 
                         bg="grey", fg="white", borderwidth=3, relief="raised", command= self.borrar)
        borrar.pack(side=RIGHT, padx=5, pady=5)
        botones.pack()
    
    def borrar(self):
        self.dialogos.getComponente("Nombre").delete(0,"end")
        self.dialogos.getComponente("Apellido").delete(0,"end")
        self.dialogos.getComponente("Fecha").set("")
        self.dialogos.getComponente("Tipo de Cita").set("")
        self.dialogos.getComponente("Motivo").delete(0,"end")

    def aceptar(self):
        nombre = self.dialogos.getValue("Nombre")
        apellido = self.dialogos.getValue("Apellido")
        fecha = self.dialogos.getValue("Fecha")
        tCita = self.dialogos.getValue("Tipo de Cita")
        motivo = self.dialogos.getValue("Motivo")

        paciente = None
        tMedico = None
        t_Cita = None
        for i in Administrador.getPacientes():
            if i.getNombre() == nombre and i.getApellido() == apellido:
                paciente = i
                break
        if tCita == "General":
            t_Cita = tipoCita.GENERAL
            tMedico = tipoMedico.GENERAL
        elif tCita == "Prioritaria":
            tCita = tipoCita.PRIORITARIA
            tMedico = tipoMedico.GENERAL
        elif tCita == "Optometria":
            tCita = tipoCita.OPTOMETRIA
            tMedico = tipoMedico.OPTOMETRA
        elif tCita == "Audiometria":
            tCita = tipoCita.AUDIOMETRIA
            tMedico = tipoMedico.FONOAUDIOLOGO
        elif tCita == "Pediatria":
            tCita = tipoCita.PEDIATRIA
            tMedico = tipoMedico.PEDIATRA
        elif tCita == "Laboratorio":
            tCita = tipoCita.LABORATORIO
            tMedico = tipoMedico.BACTERIOLOGO

        
        messagebox.showinfo("Resultado", paciente.pedirCita(fecha, tCita, motivo,tMedico))
        self.borrar()