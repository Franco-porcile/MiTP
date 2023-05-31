package Productos;
import Promociones.*;
import java.util.ArrayList;


public class paquetes {
	protected ArrayList<atracciones> misAtracciones = new ArrayList<>();
	public String nombrePaquete;
	public String tipoPaquete;
	protected String tipoPromocion;
	protected int precio;
	public int tiempo;
	public int cupo;
	public ArrayList<atracciones> getMisAtracciones() {
		return misAtracciones;
	}
	public int getPrecio() {
		return precio;
	}
	public paquetes (String nombrePaquete, String tipo,String tipoPromocion) {
		this.nombrePaquete = nombrePaquete;
		this.tipoPaquete = tipo;
		this.tipoPromocion = tipoPromocion;
		this.precio = 0;
		this.tiempo = 0;
		this.cupo = 0;
	}
	public void agregarAtraccion(atracciones nueva) {
		misAtracciones.add(nueva);
	}
	public void mostrarProducto() {
		boolean band = true;
		
		System.out.println("Nombre del Paquete: " + nombrePaquete);
		System.out.println("Paquete del Tipo: " +tipoPaquete);
		System.out.print("Contiene: ");
		for(atracciones atraccion : misAtracciones) {
			if(band) {
				cupo = atraccion.cupo;
				band = false;
			}
			this.precio +=atraccion.precio; 
			tiempo += atraccion.tiempo;
			if(atraccion.cupo < cupo) {
				cupo = atraccion.cupo;
			}
			System.out.print(atraccion.nombreAtraccion+" ");
		}
		System.out.println();
		System.out.println("Precio total sin descuento: " + this.precio);
		System.out.println(this.calcularPrecioDeVenta());
		System.out.println("Cupo disponible: " + cupo);
		System.out.println("Duracion del paquete: " + tiempo);
	}
	protected int calcularPrecioDeVenta() {
		int precio = 0;
		promocion mipromocion = null;
		switch (this.tipoPromocion) {
		case "Porcentual": 
			mipromocion = new porcentual();
			mipromocion.msjPromocion();
			precio = mipromocion.calcularPrecioPromocion(misAtracciones);
			break;
		case "Absoluta":
			mipromocion = new absoluta();
			mipromocion.msjPromocion();
			precio = mipromocion.calcularPrecioPromocion(misAtracciones);

			break;
		case "axb":
			mipromocion = new axb();
			mipromocion.msjPromocion();
			precio = mipromocion.calcularPrecioPromocion(misAtracciones);
			break;
		}
		return precio;
	}
}
