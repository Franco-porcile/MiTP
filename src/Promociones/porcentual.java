package Promociones;

import java.util.ArrayList;

import Productos.*;

public class porcentual implements promocion{
	private double porcentaje;

	public porcentual(){
		this.porcentaje = 0;
	}
	
	public double getPorcentaje() {
		return porcentaje;
	}
	
	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	@Override
	public int calcularPrecioPromocion(ArrayList<atracciones.miAtraccion> atraccion) {
		// TODO Auto-generated method stub
		double total = 0;
		
		for(atracciones.miAtraccion cadaAtraccion : atraccion) {
			total += cadaAtraccion.getPrecio();
		}
		 
		return (int)Math.round(total - total * porcentaje/100);
	}

	@Override
	public void msjPromocion() {
		// TODO Auto-generated method stub
		System.out.println("Aplicando una promocion con un descuento del " + this.porcentaje +"%");
	}

}
