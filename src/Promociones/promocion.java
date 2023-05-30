package Promociones;

import java.util.ArrayList;

import Productos.atracciones;

public interface promocion {
	abstract int calcularPrecioPromocion(ArrayList <atracciones>atraccion);
	abstract void msjPromocion();
}
