package Promociones;

import java.util.ArrayList;
import Productos.*;

public class absoluta implements promocion{
	private int precio;
	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public absoluta() {
		precio = 0;
	}

	@Override
	public int calcularPrecioPromocion(ArrayList<atracciones.miAtraccion> atraccion) {
		
		return this.precio;
	}

	@Override
	public void msjPromocion() {
		// TODO Auto-generated method stub
		System.out.println("Aplicando una promocion de tipo absoluto el paquete quedara con un precio de " );
	}
	
}
