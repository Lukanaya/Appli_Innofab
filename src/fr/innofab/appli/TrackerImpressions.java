package fr.innofab.appli;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Application pour noter et gérer les impressions des adhérant·e·s du fablab.
 */
public class TrackerImpressions {

	public static void main(String args[]) {
		ArrayList<Machine> listeMachines = lireFichierMachines("machines.csv");
		for (int i = 0; i < listeMachines.size(); i++) {
			System.out.println(listeMachines.get(i).toString());
		}
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
}