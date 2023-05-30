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


	/*
	 * protected int calcularPrecioDeVenta() { return precio; miAtraccion atraccion
	 * = this.atraccion.get(0); promocion mipromocion = null; switch
	 * (atraccion.tipoPromocion) { case "Porcentual": mipromocion = new
	 * porcentual(); mipromocion.msjPromocion();
	 * atraccion.setPrecio(mipromocion.calcularPrecioPromocion(this.atraccion));
	 * this.atraccion.set(0, atraccion) ; break;
	 * 
	 * case "axb": mipromocion = new axb(); mipromocion.msjPromocion();
	 * atraccion.setPrecio(mipromocion.calcularPrecioPromocion(this.atraccion));
	 * this.atraccion.set(0, atraccion) ; break; case "Absoluta": mipromocion = new
	 * absoluta(); mipromocion.msjPromocion();
	 * atraccion.setPrecio(mipromocion.calcularPrecioPromocion(this.atraccion));
	 * this.atraccion.set(0, atraccion) ; break; } return atraccion.getPrecio();
	 * 
	 * }
	 * 
	 * 
	 * public static class miAtraccion { protected String nombreAtraccion; protected
	 * String tipoAtraccion; protected String tipoPromocion; protected int cupo;
	 * private int precio; protected int tiempo;
	 * 
	 * public miAtraccion(String nombreAtraccion, String tipoAtraccion, String
	 * tipoPromocion, int cupo, int tiempo, int precio) { this.nombreAtraccion =
	 * nombreAtraccion; this.tipoAtraccion = tipoAtraccion; this.tipoPromocion =
	 * tipoPromocion; this.cupo = cupo; this.tiempo = tiempo;
	 * this.setPrecio(precio); }
	 * 
	 * public int getPrecio() { return precio; }
	 * 
	 * public void setPrecio(int precio) { this.precio = precio; } }
	 */
}
