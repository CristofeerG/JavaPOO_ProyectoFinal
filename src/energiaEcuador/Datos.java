package energiaEcuador;

import java.util.*;

public class Datos {
	private int[] consumoCiudad;
	private double tarifa;
	private Hashtable<String, Datos> plantaE = new Hashtable<String, Datos>();
	private Hashtable<String, Datos> plantaE2 = new Hashtable<String, Datos>();
	
	
	
	public Datos(int[] dto) {
		this.consumoCiudad= dto;
	}
	
	public Datos(Hashtable<String, Datos> plantaE) {
		this.plantaE= plantaE;
	}
	
	public void verdto() {
		for( int i=0; i< consumoCiudad.length ; i++) {
			System.out.println(consumoCiudad[i]);
		}
	}
	
	public int calculo_megavatios() {
		int suma = 0;
		for(int i=0; i< consumoCiudad.length;i++) {
		
			suma= consumoCiudad[i]+suma;	
		}
		return suma;
	}

	public Hashtable<String, Datos> getPlantaE() {
		return plantaE;
	}
	
	public int[] getConsumoCiudad() {
		return consumoCiudad;
	}
	
	public double getTarifa() {
		return tarifa;
	}
}
