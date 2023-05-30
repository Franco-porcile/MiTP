package Sistema;

import Productos.*;
import Usuarios.*;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;

public class sistema {
	ArrayList<paquetes> listaPaquetes = new ArrayList<>();
	ArrayList<atracciones> listaAtracciones = new ArrayList<>();
	public usuarios usuario;

	public sistema(String nombre, String tAtraccionPreferida, int tiempo, int dinero) {
		usuario = new usuarios(nombre, tAtraccionPreferida, tiempo, dinero);
	}

	public void crearPaquetes() {

	}

	public void agregarAtracciones() {

	}

	public void ordenarAtracciones() {
		Collections.sort(listaAtracciones, new comparadorPorPrecio());
	}

	static class comparadorPorPrecio implements Comparator<atracciones> {
		@Override
		public int compare(atracciones atraccion1, atracciones atraccion2) {
			return Integer.compare(atraccion2.getPrecio(), atraccion1.getPrecio());
		}
	}

	public void ordenarPaquetes() {
		Collections.sort(listaPaquetes, new comparadorPorPrecioPaquetes());
	}

	static class comparadorPorPrecioPaquetes implements Comparator<paquetes> {
		@Override
		public int compare(paquetes paquete1, paquetes paquete2) {
			return Integer.compare(paquete2.getPrecio(), paquete1.getPrecio());
		}
	}

	public void ofrecerProducto() { 
		// ofrece todos los productos 1° por paquetes afines a sus gustos 
		//2° atracciones  afines 
		//3° paquetes que no son afines a sus gustos  
		//4° atracciones no afines a sus gustos dejando al final solo los paquetes y atracciones aceptadas
		ordenarPaquetes();
		ordenarAtracciones();
		// Ofrece los paquetes con relacion a sus gustos y los elimina si dice que no
		Iterator<paquetes> iterator3 = listaPaquetes.iterator();
		while (iterator3.hasNext()) {
			paquetes paquete = iterator3.next();
			if (usuario.tiempo < paquete.tiempo || paquete.cupo == 0 || paquete.getPrecio() > usuario.dinero) {
				iterator3.remove();
			} else {
				if (paquete.tipoPaquete == usuario.tAtraccionPreferida) {
					if (usuario.dinero >= paquete.getPrecio() && usuario.tiempo >= paquete.tiempo
							&& paquete.cupo != 0) {
						paquete.mostrarProducto();
						if (preguntarXSiONo()) {
							usuario.dinero -= paquete.getPrecio();
							usuario.tiempo -= paquete.tiempo;
							compararPaquetesYAtracciones(paquete.getMisAtracciones());
						} else
							iterator3.remove();
					}
				}
			}
		}
		Iterator<atracciones> iterator = listaAtracciones.iterator();
		// Ofrece las atracciones de acuerdo con sus gustos y los elimina si dice que no
		while (iterator.hasNext()) {
			atracciones valor = iterator.next();
			if (usuario.tiempo < valor.getTiempo() || valor.getCupo() == 0 || valor.getPrecio() > usuario.dinero) {
				iterator.remove();
			} else {
				if (valor.getTipoAtraccion() == usuario.tAtraccionPreferida) {
					if (usuario.dinero >= valor.getPrecio() && usuario.tiempo >= valor.getTiempo()
							&& valor.getCupo() != 0) {
						valor.mostrarProducto();
						if (preguntarXSiONo()) {
							usuario.dinero -= valor.getPrecio();
							usuario.tiempo -= valor.getTiempo();
						} else
							iterator.remove();
					}

				}

			}
		}
		Iterator<paquetes> iterator4 = listaPaquetes.iterator();
		// Ofrece los paquetes que no tienen relacion a sus gustos y los elimina si dice
		// que no
		while (iterator4.hasNext()) {
			paquetes paquete = iterator4.next();
			if (usuario.tiempo < paquete.tiempo || paquete.cupo == 0 || paquete.getPrecio() > usuario.dinero) {
				iterator4.remove();
			} else {
				if (paquete.tipoPaquete != usuario.tAtraccionPreferida) {
					if (usuario.dinero >= paquete.getPrecio() && usuario.tiempo >= paquete.tiempo
							&& paquete.cupo != 0) {
						paquete.mostrarProducto();
						if (preguntarXSiONo()) {
							usuario.dinero -= paquete.getPrecio();
							usuario.tiempo -= paquete.tiempo;
							compararPaquetesYAtracciones(paquete.getMisAtracciones());
						} else
							iterator4.remove();
					}
				}
			}
		}
		// Ultima opcion, ofrece las atracciones que no son de sus gustos y si dice que
		// no las elimina
		Iterator<atracciones> iterator2 = listaAtracciones.iterator();
		while (iterator2.hasNext()) {
			atracciones valor = iterator2.next();
			if (usuario.tiempo < valor.getTiempo() || valor.getCupo() == 0 || valor.getPrecio() > usuario.dinero) {
				iterator2.remove();
			} else {
				if (valor.getTipoAtraccion() != usuario.tAtraccionPreferida) {
					if (usuario.dinero >= valor.getPrecio() && usuario.tiempo >= valor.getTiempo()
							&& valor.getCupo() != 0) {
						valor.mostrarProducto();
						if (preguntarXSiONo()) {
							usuario.dinero -= valor.getPrecio();
							usuario.tiempo -= valor.getTiempo();
						} else
							iterator2.remove();
					}

				}
			}
		}
	}

	public boolean preguntarXSiONo() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String respuesta = "";
		try {
			System.out.println("Desea aceptarlo ? s/n");
			respuesta = entrada.readLine();
			entrada.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			preguntarXSiONo();
		}
		return respuesta == "s";
	}

	public void compararPaquetesYAtracciones(ArrayList<atracciones> atracciones) {
		Iterator<atracciones> iterator = listaAtracciones.iterator();
		while (iterator.hasNext()) {
			atracciones elemento = iterator.next();
			for (atracciones atraccion : atracciones) {
				if (atraccion.nombreAtraccion.equals(elemento.nombreAtraccion)) {
					iterator.remove();
					break;
				}
			}
		}
	}
}
