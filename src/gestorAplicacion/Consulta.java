/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

import gestorAplicacion.personas.*;
import java.time.*;

/**
 *
 * @author Roger Vera
 */
public abstract class Consulta {
	protected int id;
    protected Paciente paciente;
    protected Medico medico;
    protected Consultorio consultorio;
    protected LocalDateTime fecha;
    protected Pago pago;
            
    
}
