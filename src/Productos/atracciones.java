package Productos;

public class atracciones {
	public String nombreAtraccion;
	protected String tipoAtraccion;
	protected String tipoPromocion;
	protected int cupo;

	protected int precio;
	protected int tiempo;

	public atracciones(String nombreAtraccion, String tipoAtraccion, int cupo, int tiempo, int precio) {
		this.nombreAtraccion = nombreAtraccion;
		this.tipoAtraccion = tipoAtraccion;
		this.cupo = cupo;
		this.tiempo = tiempo;

	}
	
	public void mostrarProducto() {
		System.out.println("Nombre de la atraccion: " + this.nombreAtraccion);
		System.out.println("Precio de la atraccion: " + this.precio);
		System.out.println("Cupo: " + this.cupo);
		System.out.println("Tiempo: " + this.tiempo + "hs");
	}

	public void setCupo(int cupo) {
		this.cupo = cupo;
	}

	public int getCupo() {
		return cupo;
	}

	public int getTiempo() {
		return tiempo;
	}

	public String getTipoAtraccion() {
		return tipoAtraccion;
	}

	public int getPrecio() {
		return precio;
	}
}
