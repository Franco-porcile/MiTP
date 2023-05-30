package Sistema;
import Productos.*;
import Promociones.*;
import Usuarios.*;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.util.Iterator;

public class sistema {
	HashMap<paquetes,Boolean> listaPaquetes = new HashMap<>();
	ArrayList<atracciones> listaAtracciones = new ArrayList<>();
	public usuarios usuario;
	public sistema(String nombre,String tAtraccionPreferida,int tiempo,int dinero) {
		usuario = new usuarios(nombre,tAtraccionPreferida,tiempo,dinero);
	}
	//cada paquete creado se almacena en el hash map y el boolean por default es false
	public void crearPaquetes() {
		
	}
	public void agregarAtracciones() {
		
	}
	public void ofrecerProducto() { 
		Iterator<atracciones>iterator = listaAtracciones.iterator();		
		for(Entry<paquetes,Boolean> entry : listaPaquetes.entrySet()) {
			paquetes paquete = entry.getKey();
			if(paquete.tipoPaquete == usuario.tAtraccionPreferida) {
				if(usuario.dinero >= paquete.getPrecio() && usuario.tiempo >= paquete.tiempo && paquete.cupo != 0) {
					paquete.mostrarProducto();
					if(preguntarXSiONo()) {
						usuario.dinero -= paquete.getPrecio();
						usuario.tiempo -= paquete.tiempo;
						entry.setValue(true);
						compararPaquetesYAtracciones(paquete.getMisAtracciones());
					}
				}
			}
		}
		while(iterator.hasNext()) {
			atracciones valor = iterator.next();
			if(valor.getTipoAtraccion() == usuario.tAtraccionPreferida && usuario.tiempo >= valor.getTiempo() && valor.getCupo() != 0) {
				if(usuario.dinero >= valor.getPrecio()) {					
					valor.mostrarProducto();
					if(preguntarXSiONo()) {
						usuario.dinero -= valor.getPrecio();
						usuario.tiempo -= valor.getTiempo();
					}
					else
						iterator.remove();			
				}
				
			}
		}
		Iterator<atracciones>iterator2 = listaAtracciones.iterator();
		while(iterator2.hasNext()) {
			atracciones valor = iterator2.next();
			if(valor.getTipoAtraccion() != usuario.tAtraccionPreferida) {
				if(usuario.dinero >= valor.getPrecio() && usuario.tiempo >= valor.getTiempo() && valor.getCupo() != 0) {					
					valor.mostrarProducto();
					if(preguntarXSiONo()) {
						usuario.dinero -= valor.getPrecio();
						usuario.tiempo -= valor.getTiempo();					}
					else
						iterator.remove();			
				}
				
			}
		}		
	}
	public boolean preguntarXSiONo() {
		BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
		String respuesta="";
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
	public void compararPaquetesYAtracciones(ArrayList<atracciones>atracciones) {
		Iterator<atracciones>iterator = listaAtracciones.iterator();
		while(iterator.hasNext()) {
			atracciones elemento = iterator.next();
			for(atracciones atraccion : atracciones) {
				if(atraccion.nombreAtraccion.equals(elemento.nombreAtraccion)) {
					iterator.remove();
					break;
				}
			}
		}
	}
}
