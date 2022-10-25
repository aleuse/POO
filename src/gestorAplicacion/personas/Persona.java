package gestorAplicacion.personas;

import java.io.Serializable;
import java.util.ArrayList;

public class Persona implements Serializable, VisualizacionDatos{
	private static final long serialVersionUID = 1L;
	protected String nombre;
	protected String apellido;
	protected tipoDocumento documento;
	protected long numeroDocumento;
	protected int edad;
	protected String genero;
	protected long telefono;
	protected String correoElectronico;
	protected String direccion;
	
	
	public Persona(String nombre, String apellido, tipoDocumento documento, long numeroDocumento, int edad, String genero, long telefono, String correoElectronico, String direccion) {
		setNombre(nombre);
		setApellido(apellido);
		setDocumento(documento);
		setNumeroDocumento(numeroDocumento);
		setEdad(edad);
		setGenero(genero);
		setTelefono(telefono);
		setCorreoElectronico(correoElectronico);
		setDireccion(direccion);
	}
	public Persona() {
		this(null,null, null, 0, 0, null, 0, null, null);
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public tipoDocumento getDocumento() {
		return documento;
	}
	public void setDocumento(tipoDocumento documento) {
		this.documento = documento;
	}
	
	public long getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	
	public String getCorreoElectronico() {
		return correoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	//Implemenatacion metodo abstracto
	
	public String visualizarDatos() {
		return getNombre() +" "+ getApellido() + 
				"\nTipo de documento: " +getDocumento() +
				"\nNúmero de documento: " +getNumeroDocumento() + 
				"\nEdad: " +getEdad() +
				"\nGenero " + getGenero()+
				"\nTeléfono número: "+getTelefono()
				+"\nCorreoElectrónico: " +getCorreoElectronico()
				+"\nDirección: " +getDireccion();
	}
}
