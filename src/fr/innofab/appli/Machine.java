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
	
	public static ArrayList<Machine> lireFichierMachines(String chemin) {
		BufferedReader lecteur = GestionFichiers.lireFichier(chemin);
		String ligne;
		ArrayList<Machine> machines = new ArrayList<Machine>();
		if (!(lecteur == null)) {
			try {
				while ((ligne = lecteur.readLine()) != null) {
					ArrayList<Matiere> matiere = new ArrayList<Matiere>();
					Machine machine = new Machine();
					String[] colonnes = ligne.split(",");
					if (colonnes.length > 0) {
						machine.setNom(colonnes[0]);
						machine.setType(colonnes[1]);
						machine.setCoutUtilisation(Double.parseDouble(colonnes[2]));
						for (int i = 3; i < colonnes.length; i += 2) {
							matiere.add(new Matiere(colonnes[i], Double.parseDouble(colonnes[i + 1])));
						}
						machine.setMatiere(matiere);
						machines.add(machine);
					}
				}
				lecteur.close();
			} catch (IOException e) {
				System.out.println("Erreur lors de la lecture du fichier : " + chemin);
			}
		} else {
			GestionFichiers.ecrireFichier(chemin); // on crée le fichier
		}
		return machines;
	}

	public String toString() {
		StringBuilder chaine = new StringBuilder();
		chaine.append("La machine " + nom + " de type " + type + " coute " + coutUtilisation + "€/h ou par m et utilise ces matières :\n");
		chaine.append(matiere.toString());
		return chaine.toString();
	}
}