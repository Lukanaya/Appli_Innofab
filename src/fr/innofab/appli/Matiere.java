package fr.innofab.appli;

public class Matiere {
	
	private String type;
	
	private double prix;
	
	public Matiere(String type, double prix) {
		this.type = type;
		this.prix = prix;
	}
	
	public String toString() {
		return "type : " + type + " et coût : " + prix +"€/kg";
	}
}
