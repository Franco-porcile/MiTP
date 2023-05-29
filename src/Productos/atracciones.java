package Productos;

import java.util.ArrayList;

import Promociones.*;

public class atracciones {
	public ArrayList<miAtraccion>atraccion;

	public atracciones(String nombreAtraccion, String tipoAtraccion, String tipoPromocion, int cupo, int tiempo,
			int precio) {
		atraccion = new ArrayList<>();
		atraccion.add(new miAtraccion( nombreAtraccion,  tipoAtraccion,  tipoPromocion,  cupo, tiempo,
				precio));
	}

	protected void mostrarProducto() {
		miAtraccion atraccion = this.atraccion.get(0);
		System.out.println("Nombre de la atraccion: " + atraccion.nombreAtraccion);
		System.out.println("Precio de la atraccion: " + atraccion.getPrecio());
		System.out.println("Cupo: " + atraccion.cupo);
		System.out.println("Tiempo: " + atraccion.tiempo + "hs");
	}

	protected int calcularPrecioDeVenta() {
		miAtraccion atraccion = this.atraccion.get(0);
		promocion mipromocion = null; 
		switch (atraccion.tipoPromocion) {
		case "Porcentual": 
			mipromocion = new porcentual();	
			mipromocion.msjPromocion();
			atraccion.setPrecio(mipromocion.calcularPrecioPromocion(this.atraccion));
			this.atraccion.set(0, atraccion) ;
			break;
		
		case "axb":
			mipromocion = new axb();
			mipromocion.msjPromocion();
			atraccion.setPrecio(mipromocion.calcularPrecioPromocion(this.atraccion));
			this.atraccion.set(0, atraccion) ;			
			break;
		case "Absoluta":
			mipromocion = new absoluta();
			mipromocion.msjPromocion();
			atraccion.setPrecio(mipromocion.calcularPrecioPromocion(this.atraccion));
			this.atraccion.set(0, atraccion) ;
			break;
		}
		return atraccion.getPrecio();
	}

	public static class miAtraccion {
		protected String nombreAtraccion;
		protected String tipoAtraccion;
		protected String tipoPromocion;
		protected int cupo;
		private int precio;
		protected int tiempo;

		public miAtraccion(String nombreAtraccion, String tipoAtraccion, String tipoPromocion, int cupo, int tiempo,
				int precio) {
			this.nombreAtraccion = nombreAtraccion;
			this.tipoAtraccion = tipoAtraccion;
			this.tipoPromocion = tipoPromocion;
			this.cupo = cupo;
			this.tiempo = tiempo;
			this.setPrecio(precio);
		}

		public int getPrecio() {
			return precio;
		}

		public void setPrecio(int precio) {
			this.precio = precio;
		}
	}
}
