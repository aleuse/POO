from tkinter import *
from tkinter import messagebox
from gestorAplicacion.fieldFrame import FieldFrame
from gestorAplicacion.personas.Administrador import Administrador
class crearDiagnostico(Frame):
    def __init__(self):
        super().__init__()
    
        nombre = Label(master=self, text="Crear diagnostico", font="Helvetica 11 bold")
        info = """Aqui podras:Crear un diagnostico
            """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)
        
        # Se especifican los nombres de los criterios que tendrá el FieldFrame de esta funcionalidad.
        self.criterios = ["Documento del medico", "Documento del paciente","Fecha", "Medicamento a recetar","Dosis a recetar", "Modo de uso recomienda","Sintoma del paciente","Observacion del paciente"]

        # Se especifican los valores que tendrá el FieldFrame de esta funcionalidad para los criterios anteriormente especificados.
        self.valores = ["", "", False, False, "","","",""]
        # Igualmente, se especifican los valores que estarán habilitados para ser editados por el usuario.
        self.habilitados = [True, True, True,True,True,True,True,True]
        #Se especifican las listas de selección que una la GUI para que el usuario elija entre los valores de la lista
        self.combobox = [False, False, Administrador.getFechas(), ["Acetaminofen", "Amoxicilina", "Ibuprofeno","Lagrimas Artificiales"], False,False,False,False]
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
        self.dialogos.getComponente("Documento del medico").delete(0,"end")
        self.dialogos.getComponente("Documento del paciente").delete(0,"end")
        self.dialogos.getComponente("Fecha").set("")
        self.dialogos.getComponente("Medicamento a recetar").set("")
        self.dialogos.getComponente("Dosis a recetar").delete(0,"end")
        self.dialogos.getComponente("Modo de uso recomienda").delete(0,"end")
        self.dialogos.getComponente("Sintoma del paciente").delete(0,"end")
        self.dialogos.getComponente("Observacion del paciente").delete(0,"end")


    def aceptar(self):
        from gestorAplicacion.Medicamentos import Medicamentos
        from gestorAplicacion.tipoMedicamento import tipoMedicamento

        documentoMe = self.dialogos.getValue("Documento del medico")
        documentoPa = self.dialogos.getValue("Documento del paciente")
        fecha = self.dialogos.getValue("Fecha")
        medicamento = self.dialogos.getValue("Medicamento a recetar")
        dosis = self.dialogos.getValue("Dosis a recetar")
        uso = self.dialogos.getValue("Modo de uso recomienda")
        sintoma = self.dialogos.getValue("Sintoma del paciente")
        observacion = self.dialogos.getValue("Observacion del paciente")

        medico = None
        for i in Administrador.getMedicos():
            if i.getNumeroDocumento() == documentoMe:
                medico = i
                break

        if medico == None:
            messagebox.showerror("Error", "Medico no encontrado")

        
        else:
            paciente = None
            for e in Administrador.getPacientes():
                if e.getNumeroDocumento() == documentoPa:
                    paciente = e
                    break
            if paciente == None:
                messagebox.showerror("Error", "Paciente no encontrado")
            else:
                medicamento1=None
                if medicamento == "Acetaminofen":
                    medicamento1 = tipoMedicamento.ACETAMINOFEN
                elif medicamento == "Amoxicilina":
                    medicamento1 = tipoMedicamento.AMOXICILINA
                elif medicamento == "Ibuprofeno":
                    medicamento1 = tipoMedicamento.IBUPROFENO
                elif medicamento ==  "Lagrimas Artificiales":
                    medicamento1 = tipoMedicamento.LAGRIMAS_ARTIFICIALES
                consultaX = e.getConsultas().get(fecha)
                medicamentoX = Medicamentos (medicamento1, paciente, dosis, uso)
                medico.crearDiagnostico(paciente,sintoma,observacion,medicamentoX,consultaX)
                messagebox.showinfo("Diagnostico creado con exito")

            self.borrar()
            

        