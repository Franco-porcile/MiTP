package Promociones;

import java.util.ArrayList;

import Productos.*;

public class axb implements promocion{

	@Override
	public int calcularPrecioPromocion(ArrayList<atracciones.miAtraccion> atraccion) {
		// TODO Auto-generated method stub
		int menor = 0;
		int total = 0;
		boolean bandera = true;
		for(atracciones.miAtraccion cadaAtraccion : atraccion) {
			if (bandera) {
				menor = cadaAtraccion.getPrecio();
				bandera = false;
			}
			if(menor > cadaAtraccion.getPrecio()) {
				menor = cadaAtraccion.getPrecio();
			}
			total += cadaAtraccion.getPrecio();
		}
		total -= menor;
		return total;
	}

	@Override
	public void msjPromocion() {
		// TODO Auto-generated method stub
		System.out.println("Con el descuento te saldra: " );
		
	}
	
}
