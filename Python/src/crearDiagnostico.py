from tkinter import *
from tkinter import messagebox
from excepciones.excepcionTipoDatoInt import excepcionTipoDatoInt
from gestorAplicacion.fieldFrame import FieldFrame
from gestorAplicacion.personas.Administrador import Administrador
from excepciones.excepcionPersistenciaDatos import excepcionPersistenciaDatos
from excepciones.excepcionTipoDatoString import excepcionTipoDatoString
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
        from gestorAplicacion.personas.Medico import Medico
        import random as rd

        documentoMe = self.dialogos.getValue("Documento del medico")
        documentoMe = int(documentoMe)
        documentoPa = self.dialogos.getValue("Documento del paciente")
        documentoPa = int(documentoPa)
        fecha = self.dialogos.getValue("Fecha")
        medicamento = self.dialogos.getValue("Medicamento a recetar")
        dosis = self.dialogos.getValue("Dosis a recetar")
        uso = self.dialogos.getValue("Modo de uso recomienda")
        sintoma = self.dialogos.getValue("Sintoma del paciente")
        observacion = self.dialogos.getValue("Observacion del paciente")

        medico = None

        valores = [documentoMe, documentoMe, documentoPa,fecha,medicamento,dosis,uso,observacion]
        try:
            excepcionPersistenciaDatos.persistenciaDatos(self.criterios, valores)
        except excepcionPersistenciaDatos:
            return

        try:
            excepcionTipoDatoInt.tipoDatoInt(["Documento del medico"], 
                                     [documentoMe])
        except excepcionTipoDatoInt:
            return
        
        try:
            excepcionTipoDatoInt.tipoDatoInt(["Documento del paciente"], 
                                     [documentoPa])
        except excepcionTipoDatoInt:
            return

        try:
            excepcionTipoDatoInt.tipoDatoInt(["Dosis a recetar"], 
                                     [dosis])
        except excepcionTipoDatoInt:
            return

        try:
            excepcionTipoDatoInt.tipoDatoInt(["Modo de uso recomienda"], 
                                     [uso])
        except excepcionTipoDatoInt:
            return

        try:
            excepcionTipoDatoString.tipoDatoString(["Sintoma del paciente"], 
                                     [sintoma])
        except excepcionTipoDatoString:
            return

        try:
            excepcionTipoDatoString.tipoDatoString(["Observacion del paciente"], 
                                     [observacion])
        except excepcionTipoDatoString:
            return

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
                Medico.crearDiagnostico(paciente,observacion,medicamentoX,rd.random() * 5000 + 1,consultaX)
                messagebox.showinfo("Confirmación", "Diagnostico creado con exito")

            self.borrar()
            

        