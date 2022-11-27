from tkinter import *
from tkinter import messagebox
from gestorAplicacion.fieldFrame import FieldFrame
from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.Consulta import Consulta



class pagarConsulta(Frame):
    def __init__(self):
        super().__init__()
    
        nombre = Label(master=self, text="Pagar Consulta", font="Helvetica 11 bold")
        info = """XXXXXXXXXXXXXXX.
            """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)
        
        # Se especifican los nombres de los criterios que tendrá el FieldFrame de esta funcionalidad.
        self.criterios = ["Nombre", "Documento", "ID Consulta"]

        # Se especifican los valores que tendrá el FieldFrame de esta funcionalidad para los criterios anteriormente especificados.
        self.valores = ["", False, False]
        # Igualmente, se especifican los valores que estarán habilitados para ser editados por el usuario.
        self.habilitados = [True, True, True]
        #Se especifican las listas de selección que una la GUI para que el usuario elija entre los valores de la lista
        self.combobox = [False, False, False]
        # Se crea el FieldFrame para esta funcionalidad con los parámetros anteriormente especificados.
        self.dialogos = FieldFrame(self, "Criterios", self.criterios, "Valores", self.valores, self.habilitados, self.combobox)
        self.dialogos.pack(padx=5, pady=5)
        #Se crean los botones de aceptar y borrar
        botones = Frame(master=self)
        pagar = Button(master = botones, text = "Pagar mi Consulta", font = "Helvetica 11 bold",
                         bg = "grey", fg = "white", borderwidth=3, relief = "raised", command=self.pagar)
        pagar.pack(side = LEFT, padx = 5, pady = 5)
        borrar = Button(master=botones, text="Borrar", font="Helvetica 11 bold", 
                         bg="grey", fg="white", borderwidth=3, relief="raised", command= self.borrar)
        borrar.pack(side=RIGHT, padx=5, pady=5)
        botones.pack()
    
    def borrar(self):
        self.dialogos.getComponente("Nombre").delete(0,"end")
        self.dialogos.getComponente("Documento").delete(0,"end")
        self.dialogos.getComponente("ID Consulta").delete(0,"end")

    def pagar(self):

        nombre = self.dialogos.getValue("Nombre")
        documento = self.dialogos.getValue("Documento")
        id_consulta = self.dialogos.getValue("ID Consulta")

        paciente = None

        for i in Administrador.getPacientes():
            if i.getNombre() == nombre and i.getNumeroDocumento() == documento:
                paciente = i
                break
            if paciente == None:
                messagebox.showerror("Error", "Paciente no encontrado")

        for c in Consulta:    
            if c.getId == id_consulta and c.getPago() == True:
                messagebox.showinfo("Resultado", "La consulta ya ha sido pagada")
            elif c.getId == id_consulta and c.getPago() == False:
                c.setPago().setPagado() == True
                Administrador.sumarDinero(c.getPago().getValor())
                messagebox.showinfo("Resultado", "El pago de la consulta ha sido exitoso")
            else:
                break
                    
        self.borrar()