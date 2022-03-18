package energiaEcuador;

import java.util.*;

public class Region {
	private String nombre_reg;
	private ArrayList<Ciudad> ciudades = new ArrayList<Ciudad>(); 
	
	public Region(String nombre_reg,String city) {
		this.nombre_reg= nombre_reg;
	}

	public String getNombre_reg() {
		return nombre_reg;
	}

	public void setNombre_reg(String nombre_reg) {
		this.nombre_reg = nombre_reg;
	}
	
}
