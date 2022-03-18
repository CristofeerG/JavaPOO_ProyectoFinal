package energiaEcuador;

public class Ciudad {
	private String nombre;
	
	private int[] consumoCiudad = new int[12];
	
	public Ciudad( String nombre) {
		this.nombre= nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return  "Ciudad: "+nombre +"\n"+"Consumo eléctrico: "  ;
	}
	
}
