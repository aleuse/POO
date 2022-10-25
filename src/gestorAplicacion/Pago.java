package gestorAplicacion;

import java.io.Serializable;

import gestorAplicacion.personas.Medico;

public class Pago implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;
	private int valor;
	private Consulta consulta;
	private Medico medico;
	private boolean pagado;
	private Entrega entrega;
	
	// Constructor
	public Pago(int valor, boolean pagado) {
		this.setId((int)(Math.random()*10000+1));
		this.setValor(valor);
		this.setPagado(pagado);
		this.setConsulta(null);
	}
	
	public Pago(int valor, Consulta consulta, boolean pagado) {
		this.setId((int)(Math.random()*10000+1));
		this.setValor(valor);
		this.setPagado(pagado);
		this.setConsulta(consulta);
	}
	public Pago(int id, int valor, Medico medico, boolean pagado) {
		this.setId(id);
		this.setValor( valor);
		this.setPagado(pagado);
		this.setMedico(medico);
	}

	// Getters y Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public boolean isPagado() {
		return pagado;
	}

	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}
}
