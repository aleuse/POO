from tkinter import *
from tkinter import messagebox
from gestorAplicacion.fieldFrame import FieldFrame
from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.personas.tipoMedico import tipoMedico
from gestorAplicacion.tipoCita import tipoCita
class reagendarCita(Frame):
    def __init__(self):
        super().__init__()
    
        nombre = Label(master=self, text="Reagendar cita", font="Helvetica 11 bold")
        info = """XXXXXXXXXXXXXXX.
            """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)
        
        # Se especifican los nombres de los criterios que tendrá el FieldFrame de esta funcionalidad.
        self.criterios = ["Nombre", "Apellido", "Id de la cita", "Nueva fecha"]

        # Se especifican los valores que tendrá el FieldFrame de esta funcionalidad para los criterios anteriormente especificados.
        self.valores = ["", "", "", False]
        # Igualmente, se especifican los valores que estarán habilitados para ser editados por el usuario.
        self.habilitados = [True, True, True,True]
        #Se especifican las listas de selección que una la GUI para que el usuario elija entre los valores de la lista
        self.combobox = [False, False,False, Administrador.getFechas()]
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
        self.dialogos.getComponente("Id de la cita").delete(0,"end")
        self.dialogos.getComponente("Nueva fecha").set("")

    def aceptar(self):
        nombre = self.dialogos.getValue("Nombre")
        apellido = self.dialogos.getValue("Apellido")
        fecha = self.dialogos.getValue("Nueva fecha")
        id_cita = self.dialogos.getValue("Id de la cita")
        
        paciente = None
        
        for i in Administrador.getPacientes():
            if i.getNombre() == nombre and i.getApellido() == apellido:
                paciente = i
                break
        
        
        messagebox.showinfo("Resultado", paciente.reagendarCita(id_cita,fecha))
        self.borrar()