#solicitarEntregaMedicamentos
from tkinter import *
from tkinter import messagebox
from gestorAplicacion.Entrega import Entrega
from gestorAplicacion.estadoEntrega import estadoEntrega
from gestorAplicacion.fieldFrame import FieldFrame
from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.personas.Medico import Medico
class solicitarEntregaMedicamentos(Frame):
    def __init__(self):
        super().__init__()
    
        nombre = Label(master=self, text="Solicitar medicamentos", font="Helvetica 11 bold")
        info = """Aqui podras: Solicitar la entrega de sus medicamentos
            """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)
        
        # Se especifican los nombres de los criterios que tendrá el FieldFrame de esta funcionalidad.
        self.criterios = ["Documento del paciente", "¿Deseas confirmar?","Ingrese su direccion de domicilio"]
        
        # Se especifican los valores que tendrá el FieldFrame de esta funcionalidad para los criterios anteriormente especificados.
        self.valores = [False, False,""]
        # Igualmente, se especifican los valores que estarán habilitados para ser editados por el usuario.
        self.habilitados = [True, True,True]
        # Ahora, se especifican las listas de selección que usa la GUI para que el usuario elija entre los valores de la lista.
        self.combobox = [False, ["Si", "No"],False]
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
        self.dialogos.getComponente("¿Deseas confirmar?").set("")
        self.dialogos.getComponente("Ingrese su direccion de domicilio").delete(0,"end")
    
    def aceptar(self):
        from gestorAplicacion.personas.Paciente import Paciente
        from gestorAplicacion.Examen import Examen
        from gestorAplicacion.Medicamentos import Medicamentos
        
        numDocumento = self.dialogos.getValue("Documento del paciente")
        re = self.dialogos.getValue("¿Deseas confirmar?")
        direccion = self.dialogos.getValue("Ingrese su direccion de domicilio")
        
        numDocumento = self.dialogos.getValue("Documento del paciente")
        
        numDocumento = int(numDocumento)
        paciente = None
        cont = 0
        for e in Administrador.getPacientes():
            if e.getNumeroDocumento() == numDocumento:
                paciente = e
                break
        if paciente == None:
            messagebox.showerror("Error", "Paciente no encontrado")
        else:
            per = None
            for i in Medico.listado:
                if i.getPersona().getNumeroDocumento() == numDocumento:
                    per = i
                    messagebox.showerror("Sus medicamentos son: ", i.medicamento.getTipoMed())

            if re == "No":
                messagebox.showerror("Error", "Envio no confirmado")
            elif re=="Si":
                if per.getConsulta().getPago().isPagado() == True:
                    Entrega.crearEntrega(cont,per.getPersona(), direccion, per.getMedicamiento(), estadoEntrega.EN_CAMINO)
                    cont=cont+1
                    Medicamentos.asignarMed(per.medicamiento.getTipoMed(), 1)
                    messagebox.showerror("El proceso ha sido exitoso")
                else:
                    messagebox.showerror("Debes pagar la consulta antes de pedir los medicamentos")
                                
        self.borrar()   
                
        