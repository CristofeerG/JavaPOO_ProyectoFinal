package energiaEcuador;

import java.util.*;

public class PlantasEnergia {
	private String nombre;
	private double tarifa;
	private Ciudad ciudad;
	
	public PlantasEnergia( String nombre, Ciudad ciudad) {
		this.nombre=  nombre;
		this.ciudad= ciudad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Planta Electrica: " +nombre+"\t"+ ciudad;
	}
	
}
	

