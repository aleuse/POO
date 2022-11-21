import tkinter as tk
from tkinter import *
from tkinter import messagebox
from solicitarExamen import solicitarExamen
from baseDatos.Serializador import serializar
from baseDatos.Deserializador import deserializar
from datetime import datetime
from PIL import Image, ImageTk

deserializar()
def inicializar():
    from gestorAplicacion.personas.Administrador import Administrador
    from gestorAplicacion.personas.Medico import Medico
    from gestorAplicacion.personas.Paciente import Paciente
    from gestorAplicacion.Consultorio import Consultorio
    from gestorAplicacion.personas.tipoDocumento import tipoDocumento
    from gestorAplicacion.personas.tipoMedico import tipoMedico
    from gestorAplicacion.tipoCita import tipoCita
    medico1 = Medico("Susana", "Perez", tipoDocumento.CEDULA, 1000758374, 25, "Femenino", 1000758374, 
                 "susper@gmail.com", "Cra 77 #45 04", tipoCita.GENERAL, tipoMedico.BACTERIOLOGO, True)
    consultorio1 = Consultorio(1, None, None, "Laboratorio", True)
    Paciente1 = Paciente("Sara", "Marin", tipoDocumento.CEDULA, 1, 20, "Femenino", 2038487, "sama@gmail.com", "calle 36 #89 53", "SURA", None, True)
    fecha1 = datetime(2022, 10, 15, 12, 30)
    fecha2 = datetime(2022, 10, 15, 13, 00)
    fecha3 = datetime(2022, 10, 15, 13, 30)
    fecha4 = datetime(2022, 10, 15, 14, 00)
    
    medico1.getConsultas().update({fecha1 : "Una consulta", fecha2 : "Otra consulta", fecha3 : None, fecha4 : "Consulta"})
    consultorio1.getConsultas().update({fecha1 : "Una consulta", fecha2 : "Otra consulta", fecha3 : None, fecha4 : None})
    
    Administrador.getFechas().append(fecha1)
    Administrador.getFechas().append(fecha2)
    Administrador.getFechas().append(fecha3)
    Administrador.getFechas().append(fecha4)
    Administrador.setDinero(500000)

#inicializar()
ventana = tk.Tk()
ventana.title('Sistema gestor médico')
ventana.geometry("+10+10")
ventana.grid_columnconfigure(0, weight=1)
ventana.grid_columnconfigure(1, weight=1)
ventanaExamenes = solicitarExamen()
ventanaExamenes.pack_forget()

posicionImagen=1
def cambiarImagen(e):
    global posicionImagen
    posicionImagen += 1
    if posicionImagen == 6:
        posicionImagen = 1
    FotoInicio=(Image.open("Imagenes/inicio/" + str(posicionImagen) + ".jpg")).resize((400,400), Image.ANTIALIAS)
    FotoInicio = ImageTk.PhotoImage(FotoInicio)
    LabelFotoInicio.configure(image=FotoInicio)
    LabelFotoInicio.image=FotoInicio

# Poner aquí las biografías

posicionVida=0
def cambiarVida(e):
    global posicionVida
    posicionVida += 1
    if posicionVida == 5:
        posicionVida = 0
    ListaFotos=["Andres", "Luzarait", "Natalia", "Roger", "Yeferson"]
    Foto1 =(Image.open("Imagenes/" + ListaFotos[posicionVida] + "/1.jpg")).resize((200,200), Image.ANTIALIAS)
    Foto1 = ImageTk.PhotoImage(Foto1)
    Foto2 =(Image.open("Imagenes/" + ListaFotos[posicionVida] + "/2.jpg")).resize((200,200), Image.ANTIALIAS)
    Foto2 = ImageTk.PhotoImage(Foto2)
    Foto3 =(Image.open("Imagenes/" + ListaFotos[posicionVida] + "/3.jpg")).resize((200,200), Image.ANTIALIAS)
    Foto3 = ImageTk.PhotoImage(Foto3)
    Foto4 =(Image.open("Imagenes/" + ListaFotos[posicionVida] + "/4.jpg")).resize((200,200), Image.ANTIALIAS)
    Foto4 = ImageTk.PhotoImage(Foto4)
    LabelFoto1.configure(image=Foto1)
    LabelFoto1.image=Foto1
    LabelFoto2.configure(image=Foto2)
    LabelFoto2.image=Foto2
    LabelFoto3.configure(image=Foto3)
    LabelFoto3.image=Foto3
    LabelFoto4.configure(image=Foto4)
    LabelFoto4.image=Foto4
    if posicionVida==0:
        CuerpoVida.config(text="VidaAndres")
    elif posicionVida==1:
        CuerpoVida.config(text="VidaLuzarait")
    elif posicionVida==2:
        CuerpoVida.config(text="VidaNatalia")
    elif posicionVida==3:
        CuerpoVida.config(text="VidaRoger")
    elif posicionVida==4:
        CuerpoVida.config(text="VidaYeferson")

def descripcion():
    descripcion = """En el sistema gestor médico los pacientes podrán solicitar citas o exámenes y reagendar sus citas; también podrán pagar sus consultas, solicitar la entrega de medicamentos y realizar el pago de estas.
Por otro lado, los médicos podrán crear diagnósticos que añadir a la historia clínica de un paciente.
Por último, el administrador podrá visualizar información referente a las consultas, exámenes y entregas realizadas; además, podrá contratar nuevos médicos, adquirir nuevos consultorios o comprar medicamentos."""
    messagebox.showinfo(title="Descripción de la aplicación",
                        message=descripcion)

def ocultarTodo():
    ventanaInicio.pack_forget()
    ventanaUsuario.pack_forget()
    ventanaExamenes.pack_forget()
    
def ingresar():
    ocultarTodo()
    ventanaUsuario.pack()
    ventana["menu"] = menuVentanaUsuario    
    
def evento():
    pass

def salir():
    finalizar = messagebox.askyesno(title="Salir",
                                message="¿Confirma que desea salir de la aplicación?",
                                detail="Clic en Sí para salir")
    if finalizar:
        ventana.destroy()
        serializar()
 
def salirUsuario():
    salir = messagebox.askyesno(title="Salir",
                                message="¿Confirma que desea regresar a la ventana de inicio?",
                                detail="Clic en Sí para regresar")
    if salir:
        ocultarTodo()
        ventanaInicio.pack()
        ventana["menu"] = menuVentanaInicio
        
def solicitarExamen():
    ocultarTodo()
    ventanaExamenes.pack()

# Solicitar examen



 
 
   
# Menú ventana de inicio
menuVentanaInicio = Menu(ventana, font="Helvetica 11 bold", fg="red")
menuInicio = Menu(menuVentanaInicio, font="Helvetica 11",)
menuVentanaInicio.add_cascade(menu=menuInicio, label="Inicio")
menuInicio.add_command(label="Descripción", command= descripcion)
menuInicio.add_command(label="Salir", command= salir)
ventana["menu"] = menuVentanaInicio

# Se crean cada uno de los frames especificados para la ventana de Inicio.
ventanaInicio = Frame()
P1 = Frame(master=ventanaInicio, highlightbackground="black", highlightthickness=2)
P2 = Frame(master=ventanaInicio, highlightbackground="black", highlightthickness=2)
P3 = Frame(master=P1, highlightbackground="black", highlightthickness=2)
P4 = Frame(master=P1, highlightbackground="black", highlightthickness=2)
P5 = Frame(master=P2, highlightbackground="black", highlightthickness=2)
P6 = Frame(master=P2, highlightbackground="black", highlightthickness=2)

# Se crea el Label de bienvenida a la aplicación.
Saludo = Label(master=P3, text="""Bienvenido al sistema gestor médico, que lo ayudará 
a administrar facilmente todo lo que tiene que ver con este.""", font="Helvetica 11")

# Se crea el botón "Ingresar", que al ser presionado permitirá al usuario acceder a las funcionalidades.
Ingreso = Button(master=P4, text="Ingresar", font="Helvetica 11 bold", 
                bg="grey", fg="white", borderwidth=5, relief="groove",
                command=ingresar)

# Se crea el título para las hojas de vida de los autores.
TituloVida = Label(master=P5, text="Breve biografía de los autores", 
                font="Helvetica 11 bold")

# Se crea el Label para el texto de las hojas de vida de los autores.
CuerpoVida = Label(master=P5, text="Aquí va la hoja de vida", font="Helvetica 10", 
                anchor=W)

# Se crea el Label que contendrá las instrucciones para cambiar entre hojas de vida de los autores.
PieVida = Label(master=P5, text="Clic sobre la biografía para cambiar de autor",
                font="Helvetica 8 italic", fg="blue")

# Se localizan las imágenes iniciales para las relacionadas con la aplicación y para las de hojas de vida de los autores.
FotoInicio=(Image.open("Imagenes/inicio/1.jpg")).resize((400,400), Image.ANTIALIAS)
FotoInicio = ImageTk.PhotoImage(FotoInicio)
Foto1 =(Image.open("Imagenes/Andres/1.jpg")).resize((200,200), Image.ANTIALIAS)
Foto1 = ImageTk.PhotoImage(Foto1)
Foto2 =(Image.open("Imagenes/Andres/2.jpg")).resize((200,200), Image.ANTIALIAS)
Foto2 = ImageTk.PhotoImage(Foto2)
Foto3 =(Image.open("Imagenes/Andres/3.jpg")).resize((200,200), Image.ANTIALIAS)
Foto3 = ImageTk.PhotoImage(Foto3)
Foto4 =(Image.open("Imagenes/Andres/4.jpg")).resize((200,200), Image.ANTIALIAS)
Foto4 = ImageTk.PhotoImage(Foto4)

# Se crean los Label para las imágenes relacionadas con la aplicación y para las de hojas de vida de los autores.
LabelFotoInicio = Label(master=P4, image=FotoInicio, borderwidth=5, relief="ridge")
LabelFoto1 = Label(master=P6, image=Foto1, borderwidth=5, relief="ridge")
LabelFoto1.grid(column=0, row=0, padx=3, pady=3)
LabelFoto2 = Label(master=P6, image=Foto2, borderwidth=5, relief="ridge")
LabelFoto2.grid(column=1, row=0, padx=3, pady=3)
LabelFoto3 = Label(master=P6, image=Foto3, borderwidth=5, relief="ridge")
LabelFoto3.grid(column=0, row=1, padx=3, pady=3)
LabelFoto4 = Label(master=P6, image=Foto4, borderwidth=5, relief="ridge")
LabelFoto4.grid(column=1, row=1, padx=3, pady=3)

# Se visualizan todos los elementos anteriormente creados.
ventanaInicio.pack()
P1.pack(side=LEFT, fill=BOTH, padx=5, pady=5)
P2.pack(side=RIGHT, fill=BOTH, padx=5, pady=5)
P3.pack(side=TOP, fill=BOTH, padx=5, pady=5)
P4.pack(side=BOTTOM, fill=BOTH, padx=5, pady=5)
P5.pack(side=TOP, fill=BOTH, padx=5, pady=5)
P6.pack(side=BOTTOM, fill=BOTH, padx=5, pady=5)
Saludo.pack(padx=5, pady=5)
Ingreso.pack(side=BOTTOM, padx=5, pady=5)
LabelFotoInicio.pack(side=TOP, padx=10, pady=10)
TituloVida.pack(padx=5, pady=5)
CuerpoVida.pack(padx=5, pady=5)
PieVida.pack(padx=5, pady=5)

# Se asignan los comandos para cambiar de hoja de vida y de imagen relacionada a la aplicación.
CuerpoVida.bind("<Button-1>", cambiarVida)
LabelFotoInicio.bind("<Enter>", cambiarImagen)  

# Menú de la ventana de usuario
menuVentanaUsuario = Menu(ventana, font="Helvetica 11 bold")

menuArchivo = Menu(menuVentanaUsuario, font="Helvetica 11")
menuVentanaUsuario.add_cascade(menu=menuArchivo, label="Archivo")
menuArchivo.add_command(label="Aplicación", command=evento)
menuArchivo.add_command(label="Salir", command=salirUsuario)


menuProcesos = Menu(menuVentanaUsuario, font="Helvetica 11")
menuVentanaUsuario.add_cascade(label="Procesos y consultas", menu=menuProcesos)

menuCitas = Menu(menuProcesos, font="Helvetica 11")
menuProcesos.add_cascade(label="Citas", menu= menuCitas)
menuCitas.add_command(label="Solicitar cita", command=evento)
menuCitas.add_command(label="Reagendar cita", command=evento)

menuProcesos.add_command(label="Exámenes", command=solicitarExamen)

menuFinanzas = Menu(menuProcesos, font="Helvetica 11")
menuProcesos.add_cascade(label="Finanzas", menu= menuFinanzas)
menuFinanzas.add_command(label="Pagar consultas", command=evento)
menuFinanzas.add_command(label="Pagar entregas", command=evento)
menuFinanzas.add_command(label="Consultar dinero disponible", command=evento)
menuFinanzas.add_command(label="Pago de nómina", command=evento)

menuResultadosMedicamentos = Menu(menuProcesos, font="Helvetica 11")
menuProcesos.add_cascade(label="Resultados y Medicamentos", menu= menuResultadosMedicamentos)
menuResultadosMedicamentos.add_command(label="Crear diagnóstico", command=evento)
menuResultadosMedicamentos.add_command(label="Mostrar diagnósticos", command=evento)
menuResultadosMedicamentos.add_command(label="Solicitar entrega medicamentos", command=evento)

menuAdministracion = Menu(menuProcesos, font="Helvetica 11")
menuProcesos.add_cascade(label="Administración", menu= menuAdministracion)
menuAdministracion.add_command(label="Visualizar citas, exámenes y entregas", command=evento)
menuAdministracion.add_command(label="Contratar médicos", command=evento)
menuAdministracion.add_command(label="Adquirir consultorios", command=evento)
menuAdministracion.add_command(label="Comprar medicamentos", command=evento)


menuAyuda = Menu(menuVentanaUsuario, font="Helvetica 11")
menuVentanaUsuario.add_cascade(menu=menuAyuda, label="Ayuda")
menuAyuda.add_command(label="Acerca de", command=evento)

# Se define el mensaje que aparecerá cuando se accede a la ventana de Usuario desde la ventana de Inicio.
tutorial = """           (0 0)           
          ---oOO-- (_) ----oOO---        
    ╔════════════════════════════════════════╗  
    ║ Bienveniedo al Sistema Medico! ♥       ║  
    ╚════════════════════════════════════════╝  
        --------------       
       |__|__|     
     || ||   
    ooO Ooo"
    explicacion del programa sobre el sistema medico
    ...
    ...
    ...
    
"""    

# Se crea la ventana de usuario, así como la sección de qué se puede hacer con la aplicación.
ventanaUsuario = Frame()
tituloInfo = Label(master=ventanaUsuario, text="¿Cómo usar esta aplicación y qué puede hacer con ella?", font="Helvetica 11 bold")
info = Label(master=ventanaUsuario, text=tutorial, font="Helvetica 10")
tituloInfo.pack(fill=BOTH, padx=5, pady=5)
info.pack(fill=BOTH, padx=5, pady=5)



ventana.mainloop()