package gestorAplicacion;

public class Pago {
	private int id;
	private int valor;
	private Consulta consulta;
	private boolean pagado;
	
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
}
