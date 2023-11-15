package fr.innofab.appli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Gère la sauvegarde dans des fichiers.
 */
public class GestionFichiers {
	
	/**
	 * Vérifie l'existence d'un fichier et si celui ci existe, renvoie un BufferedWriter afin de pouvoir écrire dedans.
	 * @param chemin
	 * @return
	 */
	public static BufferedWriter ecrireFichier(String chemin) {
		File fichier = new File(chemin);

		BufferedWriter ecrivain = null;

		// Si le fichier n'existe pas, on le crée
		if (!fichier.exists()) {
			try {
				ecrivain = new BufferedWriter(new FileWriter(fichier, true));
			} catch (IOException e) {
				System.out.println("Impossible d'accéder au fichier : " + chemin);
			}
		}

		return ecrivain;

	}

	/**
	 * Vérifie l'existence d'un fichier et si celui ci existe, renvoie un BufferedReader afin de pouvoir le lire.
	 * @param chemin
	 * @return
	 */
	public static BufferedReader lireFichier(String chemin) {
		BufferedReader lecteur = null;

		File fichier = new File(chemin);
		if (fichier.exists()) {
			try {
				lecteur = new BufferedReader(new FileReader(fichier));
			} catch (IOException e) {
				System.out.println("Impossible d'écrire le fichier : " + chemin);
			}
		} else {
			System.out.println("Le fichier \"" + chemin + "\" n'existe pas !");
			lecteur = null;
		}

		return lecteur;
	}

}
