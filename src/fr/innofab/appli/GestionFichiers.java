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
	
	public File LireFichierCSV(String nom) {
		
		return null;
	}
	
	public static int lireOuGenererIdentifiant(String chemin) {
        File fichierCSV = new File(chemin);

        // Si le fichier n'existe pas, créer un nouvel identifiant
        if (!fichierCSV.exists()) {
            int nouvelIdentifiant = 1;
            enregistrerIdentifiantDansFichierCSV(nouvelIdentifiant, chemin);
            return nouvelIdentifiant;
        }

        // Lire l'identifiant à partir du fichier CSV
        try (BufferedReader lecteur = new BufferedReader(new FileReader(fichierCSV))) {
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

            return nouvelIdentifiant;
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return -1; // En cas d'erreur
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
