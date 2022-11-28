from tkinter import *
from tkinter import messagebox
from gestorAplicacion.Entrega import Entrega
from gestorAplicacion.fieldFrame import FieldFrame
from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.personas.Paciente import Paciente
#from gestorAplicacion.Consulta import Consulta



class pagarEntrega(Frame):
    def __init__(self):
        super().__init__()
    
        nombre = Label(master=self, text="Pagar Entrega", font="Helvetica 11 bold")
        info = """Ingrese los datos necesarios para realizar el pago de entrega.
            """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)
        
        # Se especifican los nombres de los criterios que tendrá el FieldFrame de esta funcionalidad.
        self.criterios = ["Nombre", "Documento", "ID Entrega"]

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
        pagar = Button(master = botones, text = "Pagar mi Entrega", font = "Helvetica 11 bold",
                         bg = "grey", fg = "white", borderwidth=3, relief = "raised", command=self.pagar)
        pagar.pack(side = LEFT, padx = 5, pady = 5)
        borrar = Button(master=botones, text="Borrar", font="Helvetica 11 bold", 
                         bg="grey", fg="white", borderwidth=3, relief="raised", command= self.borrar)
        borrar.pack(side=RIGHT, padx=5, pady=5)
        botones.pack()
    
    def borrar(self):
        self.dialogos.getComponente("Nombre").delete(0,"end")
        self.dialogos.getComponente("Documento").delete(0,"end")
        self.dialogos.getComponente("ID Entrega").delete(0,"end")

    def pagar(self):

        nombre = self.dialogos.getValue("Nombre")
        documento = self.dialogos.getValue("Documento")
        documento = int(documento)
        id_entrega = self.dialogos.getValue("ID Entrega")
        id_entrega = int(id_entrega)

        paciente = None

        for i in Administrador.getPacientes():
            if i.getNumeroDocumento() == documento:
                paciente = i
                break
        if paciente == None:
            messagebox.showerror("Error", "Paciente no encontrado")

        for e in Entrega.lista:
            print(e.getId())
            if e.getId() == id_entrega and e.getPago().isPagado() == True:
                messagebox.showinfo("Aviso", "La entrega ya ha sido pagada")
                break
            elif e.getId() == id_entrega and e.getPago().isPagado() == False:
                e.getPago().setPagado(True) 
                Administrador.sumarDinero(e.getPago().getValor())
                messagebox.showinfo("Aviso", "El pago de la entrega ha sido exitoso")
                break
            messagebox.showinfo("Avisa", "No se encontraron datos")
            break    
            
        self.borrar()