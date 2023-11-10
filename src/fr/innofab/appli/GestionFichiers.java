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

	public static String[] lireUtilisateur(String login, String mdp, String chemin) throws IOException {
		File fichierCSV = new File(chemin);

		if (!fichierCSV.exists()) {
			try (BufferedWriter ecrivain = new BufferedWriter(new FileWriter(fichierCSV, true))) {
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Lire l'identifiant à partir du fichier CSV
		BufferedReader lecteur = new BufferedReader(new FileReader(fichierCSV));
		String ligne;
		String[] utilisateur = new String[4];

		// Trouver le dernier identifiant dans le fichier CSV
		while ((ligne = lecteur.readLine()) != null) {
			String[] colonnes = ligne.split(",");
			if (colonnes.length > 0) {
				if(colonnes[0].equals(login) && colonnes[1].equals(mdp)) {
					System.arraycopy(colonnes, 0, utilisateur, 0, colonnes.length);
				}
			}
		}
		
		return utilisateur;

	}

	public static int lireOuGenererIdentifiant(String chemin) throws IOException {
		File fichierCSV = new File(chemin);

		// Si le fichier n'existe pas, créer un nouvel identifiant
		if (!fichierCSV.exists()) {
			int nouvelIdentifiant = 1;
			enregistrerIdentifiantDansFichierCSV(nouvelIdentifiant, chemin);
			return nouvelIdentifiant;
		}

		// Lire l'identifiant à partir du fichier CSV
		BufferedReader lecteur = new BufferedReader(new FileReader(fichierCSV));
		String ligne;
		int dernierIdentifiant = 0;

		// Trouver le dernier identifiant dans le fichier CSV
		while ((ligne = lecteur.readLine()) != null) {
			String[] colonnes = ligne.split(",");
			if (colonnes.length > 0) {
				dernierIdentifiant = Integer.parseInt(colonnes[0]);
			}
		}

		// Calculer le nouvel identifiant incrémental
		int nouvelIdentifiant = dernierIdentifiant + 1;

		// Enregistrer le nouvel identifiant dans le fichier CSV
		enregistrerIdentifiantDansFichierCSV(nouvelIdentifiant, chemin);
		lecteur.close();

		return nouvelIdentifiant;
	}

	private static void enregistrerIdentifiantDansFichierCSV(int identifiant, String chemin) {
		File fichierCSV = new File(chemin);

		// Écrire l'identifiant dans le fichier CSV
		try (BufferedWriter ecrivain = new BufferedWriter(new FileWriter(fichierCSV, true))) {
			ecrivain.write(String.valueOf(identifiant));
			ecrivain.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
