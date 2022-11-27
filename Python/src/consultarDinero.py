from tkinter import *
from tkinter import messagebox
from tkinter import ttk
from gestorAplicacion.fieldFrame import FieldFrame
from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.personas.tipoMedico import tipoMedico
from gestorAplicacion.tipoCita import tipoCita

class consultarDinero(Frame):
    def __init__(self):
        super().__init__()
    
        nombre = Label(master=self, text="Consultar Dinero Disponible", font="Helvetica 11 bold")
        info = """XXXXXXXXXXXXXXX.
            """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)

        # Se crea el botón de Consultar para obtener por medio de este la tabla de informacion financiera.
        botones = Frame(master=self)
        consultar = Button(master=botones, text="Consultar", font="Helvetica 11 bold", 
                         bg="grey", fg="white", borderwidth=3, relief="raised",
                         command=self.consultar)
        consultar.pack(padx=5, pady=5)
        # Se crea el label que contendrá el mensaje con la cantidad de dinero con el que se cuenta.
        self.labelCantidad = Label(master=botones, font="Helvetica 10 bold", anchor=CENTER)
        botones.pack(padx=5, pady=5)
        
        # Se crea la tabla de consulta.
        self.frameTabla = Frame(master=self)
        self.tabla = ttk.Treeview(master=self.frameTabla, columns=(1, 2, 3, 4), show='headings')
        self.tabla.pack(side=LEFT)
        # Se especifican los escabezados de la tabla.
        encabezados = ("Usuario", "Documento", "Fecha", "Cantidad de Dinero")
        # De acuerdo a los encabezados especificados, estos son ingresados como encabezados de la tabla.
        for i in range(len(encabezados)):
            self.tabla.column(i+1, anchor=CENTER)
            self.tabla.heading(i+1, text=encabezados[i])
        # Se añade una scroll bar a la tabla para ser usado en caso que los datos consultados superen la altura estándar de la tabla.
        bardesp = Scrollbar(self.frameTabla, orient=VERTICAL)
        bardesp.pack(side=RIGHT, fill=Y)
        # Se configura la tabla con el scroll bar y viceversa.
        self.tabla.config(yscrollcommand=bardesp.set)
        bardesp.config(command=self.tabla.yview)


        # Por medio del método consultar() se arma la tabla con los datos consultados.
        def consultar(self):
            # Se establece el mensaje con la cantidad de dinero disponible.
            mensaje="Actualmente el Sistema Medico cuenta con $"+str(Administrador.getDinero())+" dinero disponible."
            self.labelCantidad.configure(text=mensaje)
            
            
            # Primero se eliminan los anteriores datos con los que cuenta la última tabla que se armó, 
            # esto debido a que puede ser el caso en que haya nuevos datos disponibles para consultar.
            for i in self.tabla.get_children():
                self.tabla.delete(i)
            # Ahora, se obtienen cada uno de los datos.
            for a in Administrador():
                datos = (str(Administrador.getNombre), str(Administrador.getId), str(Administrador.getFechas), str(Administrador.getDinero))
                self.tabla.insert(parent="", index="end", values=datos)
            # Por último se habilita para ser visualizada la tabla.
            self.labelCantidad.pack(padx=5, pady=5)
            self.frameTabla.pack(padx=5, pady=5)
        
        # Por medio del método ocultarTabla() se deshabilita la visualización de las tablas cuando se cambia de menú.
        def ocultarTabla(self):
            self.labelCantidad.pack_forget()
            self.frameTabla.pack_forget()

