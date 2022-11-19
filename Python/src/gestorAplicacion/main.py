import tkinter as tk
from tkinter import *
from tkinter import messagebox

ventana = tk.Tk()
ventana.title('Barra de menu')
ventana.geometry('550x550')

       
    
    
def evento():
    pass

def main():
    menuBar = tk.Menu(ventana)
    ventana.config(menu=menuBar)
    
    menu1 = tk.Menu(menuBar)
    menu1.add_command(label="SOLICITAR CITA",command=evento)
    menu1.add_command(label="REAGENDAR CITA",command=evento)
    menuBar.add_cascade(label="CITAS", menu=menu1)

    menu2 = tk.Menu(menuBar)
    menu2.add_command(label="DOCUMENTO",command=evento)
    menu2.add_command(label="TIPOS DE EXAMENES",command=evento)
    menuBar.add_cascade(label="EXAMENES", menu=menu2)

    menu3 = tk.Menu(menuBar)
    menu3.add_command(label="DOCUMENTO",command=evento)
    menu3.add_command(label="PAGAR CONSULTA",command=evento)
    menu3.add_command(label="PAGAR EXAMEN",command=evento)
    menu3.add_command(label="PAGO NOMINA",command=evento)
    menuBar.add_cascade(label="FINANZAS", menu=menu3)

    menu4 = tk.Menu(menuBar)
    menu4.add_command(label="CREAR DIAGNOSTICO",command=evento)
    menu4.add_command(label="MOSTRAR DIAGNOSTICO",command=evento)
    menu4.add_command(label="SOLICITAR ENTREGA MEDICAMENTOS",command=evento)
    menuBar.add_cascade(label="RESULTADOS", menu=menu4)

    menu5 = tk.Menu(menuBar)
    menu5.add_command(label="INFORMACION DEL SISTEMA",command=evento)
    menu5.add_command(label="CONTRATAR MEDICOS",command=evento)
    menu5.add_command(label="ADQUIRIR CONSULTORIOS",command=evento)
    menu5.add_command(label="COMPRAR MEDICAMENTOS",command=evento)
    menuBar.add_cascade(label="RESULTADOS", menu=menu5)

    menu6 = tk.Menu(menuBar)
    menu6.add_command(label="SOBRE NOSOTROS",command=evento)
    menu6.add_command(label="CONTACTANOS",command=evento)
    menu6.add_command(label="SALIR",command=salir)
    menuBar.add_cascade(label="AYUDA", menu=menu6)

    intro="""           (0 0)           
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
    # Se crea la ventana de usuario y la sección del uso del programa.
    ventanaUsuario = Frame()
    tituloInf = Label(master=ventana, text="explicacion sistema medico", font="Arial 11 bold")
    info = Label(master=ventana, text=intro, font="Arial 10")
    tituloInf.pack(fill=BOTH, padx=5, pady=5)
    info.pack(fill=BOTH, padx=5, pady=5)       
   
    ventana.mainloop()

def salir():
    finalizar = messagebox.askyesno(title="Salir",
                                message="¿Confirma que desea salir de la aplicación?",
                                detail="Clic en Sí para salir")
    if finalizar:
        ventana.destroy()
 

if __name__ == "__main__":
    main()