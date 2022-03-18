package energiaEcuador;

public class Consumo {
	private int id;
	private PlantasEnergia planta;
	
	public Consumo() {
	}
	
	public Consumo(int id, PlantasEnergia planta) {
		this.id= id;
		this.planta = planta;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public PlantasEnergia getPlanta() {
		return planta;
	}


	public void setPlanta(PlantasEnergia plant) {
		this.planta = plant;
	}
}
