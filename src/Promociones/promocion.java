package Promociones;

import java.util.ArrayList;

import Productos.atracciones;

public interface promocion {
	abstract int calcularPrecioPromocion(ArrayList <atracciones.miAtraccion>atraccion);
	abstract void msjPromocion();
}
