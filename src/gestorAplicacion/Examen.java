/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorAplicacion;

/**
 *
 * @author Roger Vera
 */
public class Examen extends Consulta {

    private tipoExamen tipo;
    private boolean autorizado;
    
    // Getters y Setters
	public tipoExamen getTipo() {
		return tipo;
	}
	public void setTipo(tipoExamen tipo) {
		this.tipo = tipo;
	}
	public boolean isAutorizado() {
		return autorizado;
	}
	public void setAutorizado(boolean autorizado) {
		this.autorizado = autorizado;
	}
}
