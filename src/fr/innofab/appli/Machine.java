package fr.innofab.appli;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Une machine du fablab, contient plusieures informations comme le type de
 * machine, le coût du matériau, le type de matériau, le coût d'utilisation,
 * etc.
 */
public class Machine {

	private String nom;

	private String type;

	private double coutUtilisation;

	private ArrayList<Matiere> matiere;

	public Machine(String nom, String type) {

	}

	public Machine() {

	}

	public String getNom() {
		return nom;
	}

	public String getType() {
		return type;
	}

	public double getCoutUtilisation() {
		return coutUtilisation;
	}

	public ArrayList<Matiere> getMatiere() {
		return matiere;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setCoutUtilisation(double coutUtilisation) {
		this.coutUtilisation = coutUtilisation;
	}

	public void setMatiere(ArrayList<Matiere> matiere) {
		this.matiere = matiere;
	}

	public String toString() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("La machine " + nom + " de type " + type + " coute " + coutUtilisation + "€/h ou par m et utilise ces matières :\n");
		chaine.append(matiere.toString());
		return chaine.toString();
	}
}