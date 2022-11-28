from datetime import datetime
import tkinter as tk
from tkinter import *
from tkinter import messagebox
from gestorAplicacion.fieldFrame import FieldFrame
from tkinter import ttk


from gestorAplicacion.personas.Medico import Medico
from gestorAplicacion.personas.Administrador import Administrador

class pagoNomina(Frame):
    def __init__(self):
        super().__init__()
        cantMedicos = 0
        for medico in Administrador.medicos:
            if medico.isContratado() == True:
                print(medico)
                cantMedicos +=1 
        nombre = Label(master=self, text="Realizar Pago de Nomina", font="Helvetica 12 bold")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        info = f"""Se ha facturado hasta ahora $ {Administrador.dinero}
        Se tiene un total de {cantMedicos} medicos
        """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        descripcion.pack(fill=BOTH, padx=5, pady=5)

        # Se crea el botón de Consultar para obtener por medio de este la tabla de los medicos.
        botones = Frame(master=self)
        consultar = Button(master=botones, text="Consultar", font="Helvetica 11 bold", 
                         bg="grey", fg="white", borderwidth=3, relief="raised",
                         command=self.consultar)
        consultar.pack(padx=5, pady=5)

        pagar = Button(master=botones, text="Pagar", font="Helvetica 11 bold", 
                         bg="grey", fg="white", borderwidth=3, relief="raised",
                         command=self.pagar)
        pagar.pack(side=RIGHT, padx=5, pady=5)

        # Se crea el label que contendrá el mensaje con la cantidad de medicos con los que se cuenta.
        self.labelCantidad = Label(master=botones, font="Helvetica 10 bold", anchor=CENTER)
        botones.pack(padx=5, pady=5)

        # Se crea la tabla de los medicos.
        self.frameTabla = Frame(master=self)
        self.tabla = ttk.Treeview(master=self.frameTabla, columns=(1, 2, 3, 4, 5), show='headings')
        self.tabla.pack(side=LEFT)
        # Se especifican los escabezados de la tabla.
        encabezados = ("Nombre", "Apellido", "Documento", "Pagado", " ")
        
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
        cantMedicos = 0
        for medico in Administrador.medicos:
            if medico.isContratado() == True:
                #print(medico)
                cantMedicos +=1 
        # Se establece el mensaje con la cantidad de medicos con los que se cuenta.
        mensaje="Actualmente el Sistema Medico cuenta con "+str(cantMedicos)+" medicos. Los siguientes son los datos de los medicos."
        self.labelCantidad.configure(text=mensaje)
        # Primero se eliminan los anteriores datos con los que cuenta la última tabla que se armó, 
        # esto debido a que puede ser el caso en que haya nuevos datos disponibles para consultar.
        for i in self.tabla.get_children():
            self.tabla.delete(i)
        # Ahora, se obtienen cada uno de los datos de los medicos existentes para ser ingresados en la tabla por filas.
        for med in Administrador.getMedicos():
            if med.isContratado() == True:
                datos = (med.getNombre(), med.getApellido(), 
                        str(med.getNumeroDocumento()), med.getNomina().get(datetime(2022, 10, 1, 00, 00)).isPagado(), "Pagar")
                self.tabla.insert(parent="", index="end", values=datos)
        # Por último se habilita para ser visualizada la tabla y el mensaje de la cantidad de medicos con los que se cuenta.
        self.labelCantidad.pack(padx=5, pady=5)
        self.frameTabla.pack(padx=5, pady=5)

    def pagar():
        for medico in Administrador.medicos:
            if medico.isContratado() == True:
                if medico.getNomina().get(datetime(2022, 10, 1, 00, 00)).isPagago() == False:
                    medico.getNomina().get(datetime(2022, 10, 1, 00, 00)).isPagago() == True
                    messagebox.showinfo("Aviso", "Se ha realizado el pago de nomina exitosamente")
                else:
                    messagebox.showinfo("Aviso", "Ya se le ha realizado el pago de nomina a este medico")                    

    # Por medio del método ocultarTabla() se deshabilita la visualización de las tablas cuando se cambia de menú.
    def ocultarTabla(self):
        self.labelCantidad.pack_forget()
        self.frameTabla.pack_forget()