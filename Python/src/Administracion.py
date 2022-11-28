from datetime import datetime
import tkinter as tk
from tkinter import *
from tkinter import messagebox
from gestorAplicacion.fieldFrame import FieldFrame
from tkinter import ttk

from gestorAplicacion.Cita import Cita
from gestorAplicacion.Examen import Examen
from gestorAplicacion.Entrega import Entrega
from gestorAplicacion.tipoCita import tipoCita
from gestorAplicacion.Consulta import Consulta
from gestorAplicacion.Medicamentos import Medicamentos
from gestorAplicacion.tipoMedicamento import tipoMedicamento
from gestorAplicacion.tipoExamen import tipoExamen
from gestorAplicacion.estadoEntrega import estadoEntrega
from gestorAplicacion.personas.Medico import Medico
from gestorAplicacion.personas.tipoMedico import tipoMedico
from gestorAplicacion.personas.Administrador import Administrador
from gestorAplicacion.Consultorio import Consultorio


class visualizarDatos(Frame):
    def __init__(self):
        super().__init__()
        tutorial=""" texto aqui
        """
        #cantidad citas,examenes y entregas realizados
        c1=Cita.informeCitas(tipoCita.GENERAL)
        c2=Cita.informeCitas(tipoCita.PRIORITARIA)
        c3=Cita.informeCitas(tipoCita.OPTOMETRIA)
        c4=Cita.informeCitas(tipoCita.LABORATORIO)
        c5=Cita.informeCitas(tipoCita.AUDIOMETRIA)
        c6=Cita.informeCitas(tipoCita.PEDIATRIA)
        e1=Examen.informeExamenes(tipoExamen.SANGRE)
        e2=Examen.informeExamenes(tipoExamen.LABORATORIO)
        e3=Examen.informeExamenes(tipoExamen.RAYOSX)
        e4=Examen.informeExamenes(tipoExamen.CITOQUIMICO)
        en1=Entrega.informeEntregas(estadoEntrega.EN_CAMINO)
        en2=Entrega.informeEntregas(estadoEntrega.PROCESADA)
        en3=Entrega.informeEntregas(estadoEntrega.REALIZADA)
        cantMedicos = 0
        for medico in Administrador.medicos:
            if medico.isContratado() == True:
                cantMedicos +=1 
        
        nombre = Label(master=self, text="Citas | Exámenes | Entregas", font="Helvetica 12 bold")
        info = f"""Datos del sistema.
        Se tiene un total de {cantMedicos} medicos.
        Se han atendido a {len(Administrador.pacientes)} pacientes.
        Se ha facturado hasta ahora ${Administrador.dinero}
            
        Citas realizadas:
        GENERAL: {c1} citas recaudando $ {c1*tipoCita.GENERAL.value[1]}
        PRIORITARIA: {c2} citas recaudando $ {c2*tipoCita.PRIORITARIA.value[1]}
        OPTOMETRIA: {c3} citas recaudando $ {c3*tipoCita.OPTOMETRIA.value[1]}
        LABORATORIO: {c4} citas recaudando $ {c4*tipoCita.LABORATORIO.value[1]}
        AUDIOMETRIA: {c5} citas recaudando $ {c5*tipoCita.AUDIOMETRIA.value[1]}
        PEDIATRIA: {c6} citas recaudando $ {c6*tipoCita.PEDIATRIA.value[1]}

        Examenes realizados: 
        SANGRE: {e1} examenes recaudando $ {e1*tipoExamen.SANGRE.value[1]}
        LABORATORIO: {e2} examenes recaudando $ {e2*tipoExamen.LABORATORIO.value[1]}
        RAYOS X: {e3} examenes recaudando $ {e3*tipoExamen.RAYOSX.value[1]}
        CITOQUIMICO: {e4} examenes recaudando $ {e4*tipoExamen.CITOQUIMICO.value[1]}

        Estado de las entregas:
        PROCESADA: {en1} entregas
        EN CAMINO: {en2} entregas  
        REALIZADA: {en3} entregas
        """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)

class visualizarDinero(Frame):
    def __init__(self):
        super().__init__()
        tutorial=""" texto aqui
        """
        
        name = Administrador.getNombre()
        id = Administrador.getId()
        dinero = Administrador.getDinero()

        
        nombre = Label(master=self, text="Dinero Disponible", font="Helvetica 12 bold")
        info = f"""Bienvenido Administrador {name}. Identificacion: {id}.

        Actualmente, el Sistema Medico cuenta con ${dinero} dinero disponible.
        """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)

class contratarMedicos(Frame):
    def __init__(self):
        super().__init__()
        cantMedicos = 0
        for medico in Administrador.medicos:
            if medico.isContratado() == True:
                cantMedicos +=1 
        nombre = Label(master=self, text="Contratación Medicos", font="Helvetica 12 bold")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        info = f"""Se ha facturado hasta ahora $ {Administrador.dinero}
        Se tiene un total de {cantMedicos} medicos
        """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        descripcion.pack(fill=BOTH, padx=5, pady=5)

        labelTitulo1 = Label(master=self, text="Especialista", font="Helvetica 12 bold")
        labelTitulo1.pack(fill=BOTH, padx=5, pady=5)
        listado = ttk.Combobox(master=self,values=[tipoMedico.GENERAL.value,tipoMedico.OPTOMETRA.value,tipoMedico.FONOAUDIOLOGO.value,tipoMedico.PEDIATRA.value,tipoMedico.BACTERIOLOGO.value],state = "readonly")
        listado.current(0)
        listado.pack(fill=BOTH, padx=5, pady=5)

        labelTitulo2 = Label(master=self, text="Cantidad a contratar", font="Helvetica 12 bold")
        labelTitulo2.pack(fill=BOTH, padx=5, pady=5)
        valores = ttk.Combobox(master=self,values=[0,1,2,3,4,5],state = "readonly")
        valores.current(0)
        valores.pack(fill=BOTH, padx=5, pady=5)

        def contratar():
            cantMedicos = 0
            for medico in Administrador.medicos:
                if medico.isContratado() == True:
                    cantMedicos +=1 
            mc=0
            for i in range(0,int(valores.get())):
                for contrato in Administrador.medicos:
                    if((contrato.isContratado()==False) and (contrato.getEspecialista().value==listado.get())):
                        mc+=1
                        contrato.setContratado(True)
                        fecha1 = datetime(2022, 10, 15, 12, 30)
                        fecha2 = datetime(2022, 10, 15, 13, 00)
                        fecha3 = datetime(2022, 10, 15, 13, 30)
                        fecha4 = datetime(2022, 10, 15, 14, 00)
                        fecha5 = datetime(2022, 10, 15, 14, 30)
                        fecha6 = datetime(2022, 10, 15, 15, 00)
                        fecha7 = datetime(2022, 10, 15, 15, 30)
                        fecha8 = datetime(2022, 10, 16, 12, 30)
                        fecha9 = datetime(2022, 10, 16, 13, 00)
                        fecha10 = datetime(2022, 10, 16, 13, 30)
                        fecha11 = datetime(2022, 10, 16, 14, 00)
                        fecha12 = datetime(2022, 10, 16, 14, 30)
                        fecha13 = datetime(2022, 10, 16, 15, 00)
                        fecha14 = datetime(2022, 10, 16, 15, 30)
                        contrato.getConsultas().update({fecha1: None})
                        contrato.getConsultas().update({fecha2: None})
                        contrato.getConsultas().update({fecha3: None})
                        contrato.getConsultas().update({fecha4: None})
                        contrato.getConsultas().update({fecha5: None})
                        contrato.getConsultas().update({fecha6: None})
                        contrato.getConsultas().update({fecha7: None})
                        contrato.getConsultas().update({fecha8: None})
                        contrato.getConsultas().update({fecha9: None})
                        contrato.getConsultas().update({fecha10: None})
                        contrato.getConsultas().update({fecha11: None})
                        contrato.getConsultas().update({fecha12: None})
                        contrato.getConsultas().update({fecha13: None})
                        contrato.getConsultas().update({fecha14: None})
                        break
            if(mc>0):
                cantMedicos += mc
                messagebox.showinfo("Contratacion médicos",f"Has contratado a {mc} medicos\n Ahora se dispone de {cantMedicos} medicos")
            else:
                messagebox.showerror("Contratacion médicos","no se han podido contratar los medicos")
            
        boton_contratar = Button(master = self, text = "Contratar", font = "Helvetica 11 bold", bg = "grey", fg = "white", command=contratar)
        boton_contratar.pack( padx = 5, pady = 5)
        
class adquirirConsultorios(Frame):
    def __init__(self):
        super().__init__()
        cConsultorio = 100000
        cantConsultorios = 0
        for consultorio in Administrador.consultorios:
            if consultorio.isAdquirido() == True:
                cantConsultorios += 1
        nombre = Label(master=self, text="adquirir Consultorios", font="Helvetica 12 bold")
        info = f"""Se tiene un total de {cantConsultorios} consultorios
        Actualmente el Dinero Disponible es: $ {Administrador.dinero}
		Cada consultorio tiene un precio de $ {cConsultorio}

        """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)

        cantidad= StringVar()
        def adquirirConsultorios():
            cantConsultorios = 0
            for consultorio in Administrador.consultorios:
                if consultorio.isAdquirido() == True:
                    cantConsultorios += 1
            cn=0
            try:
                costo=int(cantidad.get())*cConsultorio
            except ValueError:
                messagebox.showerror("Excepcion tipo ValueError","Solo ingresar numeros")
                entradaTexto.delete(0, tk.END)
                raise ValueError("Solo ingresar numeros ")
                
                
            if costo<0:
                messagebox.showerror("Excepcion tipo ValueError","Solo ingresar numeros positivos")
                entradaTexto.delete(0, tk.END)
                raise ValueError("Solo ingresar numeros positivos ")
                
            elif (Administrador.dinero < costo):
                messagebox.showerror("Problemas financieros","Dinero insuficiente para comprar los consultorios")
                entradaTexto.delete(0, tk.END)
            else:
                for c in Administrador.consultorios:##duda aparece en la clase Consultorio: Administrador.consultorios
                    if (c.isAdquirido() == False):
                        cn+=1
                        c.setAdquirido(True)
                        break
                if(cn>0):
                    Administrador.restarDinero(cn* cConsultorio)
                    cantConsultorios += 1
                    messagebox.showinfo("Adquisicion de consultorios",f"se han adquirido {int(cantidad.get())} consultorios\n Ahora se dispone de {cantConsultorios} consultorios\nDinero Disponible: $ {Administrador.dinero}")
                    
                else:
                    messagebox.showerror("Adquisicion de consultorios","no se han podido adquirir los consultorios")
                entradaTexto.delete(0, tk.END)




        labelTitulo1 = Label(master=self, text="¿Cuantos Consultorios deseas adquirir?", font="Helvetica 10 bold")
        labelTitulo1.pack(fill=BOTH, padx=5, pady=5)
        entradaTexto = Entry(master=self,textvariable=cantidad)
        entradaTexto.insert(0,0)
        entradaTexto.pack(fill=BOTH, padx=5, pady=5)

        boton=Button(master=self,text="ADQUIRIR",command=adquirirConsultorios)
        boton.pack(fill=BOTH, padx=5, pady=5)

class comprarMedicamentos(Frame):
    def __init__(self):
        super().__init__()
        nombre = Label(master=self, text="Comprar Medicamentos", font="Helvetica 12 bold")
        info = f"""\nINVENTARIO MEDICAMENTOS\n
        {tipoMedicamento.ACETAMINOFEN.value[0]} : {Medicamentos.cantAcetaminofen} unidades  |   Costo Unidad: ${tipoMedicamento.ACETAMINOFEN.value[1]}           
        {tipoMedicamento.AMOXICILINA.value[0]} : {Medicamentos.cantAmoxicilina} unidades    |   Costo Unidad: ${tipoMedicamento.AMOXICILINA.value[1]}           
        {tipoMedicamento.IBUPROFENO.value[0]} : {Medicamentos.cantIbuprofeno} unidades  |   Costo Unidad: ${tipoMedicamento.IBUPROFENO.value[1]} 
        {tipoMedicamento.LAGRIMAS_ARTIFICIALES.value[0]} : {Medicamentos.cantLagrimasArtificiales} unidades |   Costo Unidad: ${tipoMedicamento.LAGRIMAS_ARTIFICIALES.value[1]} 
        
        Dinero Disponible es: $ {Administrador.dinero}
        """
        descripcion = Label(master=self, text=info, font="Helvetica 10")
        nombre.pack(fill=BOTH, padx=5, pady=5)
        descripcion.pack(fill=BOTH, padx=5, pady=5)

        def comprarM():
            validar=messagebox.askokcancel("Confirmacion compra","¿Confrimar compra?")
            if validar:
                canAcet=int(acet.get())*tipoMedicamento.ACETAMINOFEN.value[1]
                canAmox=int(amox.get())*tipoMedicamento.AMOXICILINA.value[1]
                canIbup=int(ibup.get())*tipoMedicamento.IBUPROFENO.value[1]
                canLagA=int(lagA.get())*tipoMedicamento.LAGRIMAS_ARTIFICIALES.value[1]
                total=canAcet+canAmox+canIbup+canLagA
                if(total<Administrador.dinero):
                    Administrador.dinero-=total
                    Medicamentos.cantAcetaminofen += int(acet.get())
                    Medicamentos.cantAmoxicilina += int(amox.get())
                    Medicamentos.cantIbuprofeno += int(ibup.get())
                    Medicamentos.cantLagrimasArtificiales += int(lagA.get())
                    messagebox.showinfo("Informacion compra",f"Compra realizada con exiton\nDinero Disponible: $ {Administrador.dinero}\nFELICIDADES POR TU COMPRA")
                else:
                    messagebox.showerror("Informacion compra",f"Dinero insuficiente")
            else:
                    messagebox.showerror("Confirmacion compra",f"Compra cancelada")


        frame1 = Frame(master=self,width=300,height=400,highlightbackground="black", highlightthickness=2)
        labelTituloCriterios = Label(master=frame1, text="MEDICAMENTOS", font="Helvetica 10 bold")
        labelTituloCriterios.grid(column=0, row=0, padx=20, pady=10)
        labelTituloValores = Label(master=frame1, text="UNIDADES A COMPRAR", font="Helvetica 10 bold")
        labelTituloValores.grid(column=1, row=0, padx=20, pady=10)

        label1 = Label(master=frame1, text=tipoMedicamento.ACETAMINOFEN.value[0], font="Helvetica 10 bold")
        label1.grid(column=0, row=1, padx=20, pady=10)
        acet=ttk.Combobox(master=frame1,values=[0,10,20,30,40,50,],state = "readonly")
        acet.current(0)
        acet.grid(column=1, row=1, padx=20, pady=10)

        label2 = Label(master=frame1, text=tipoMedicamento.AMOXICILINA.value[0], font="Helvetica 10 bold")
        label2.grid(column=0, row=2, padx=20, pady=10)
        amox=ttk.Combobox(master=frame1,values=[0,10,20,30,40,50,],state = "readonly")
        amox.current(0)
        amox.grid(column=1, row=2, padx=20, pady=10)

        label3 = Label(master=frame1, text=tipoMedicamento.IBUPROFENO.value[0], font="Helvetica 10 bold")
        label3.grid(column=0, row=3, padx=20, pady=10)
        ibup=ttk.Combobox(master=frame1,values=[0,10,20,30,40,50,],state = "readonly")
        ibup.current(0)
        ibup.grid(column=1, row=3, padx=20, pady=10)

        label4 = Label(master=frame1, text=tipoMedicamento.LAGRIMAS_ARTIFICIALES.value[0], font="Helvetica 10 bold")
        label4.grid(column=0, row=4, padx=20, pady=10)
        lagA=ttk.Combobox(master=frame1,values=[0,10,20,30,40,50,],state = "readonly")
        lagA.current(0)
        lagA.grid(column=1, row=4, padx=20, pady=10)
        
        boton_comprar = Button(master = frame1, text = "COMPRAR", font = "Helvetica 11 bold", bg = "grey", fg = "white", command=comprarM)
        boton_comprar.grid(column=1, row=5, padx=20, pady=10)
        frame1.pack()
        
    
        
        

