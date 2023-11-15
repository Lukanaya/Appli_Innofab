package fr.innofab.appli;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Contient les informations sur une impression (utilisation d'une machine par un·e utilisateur·rice)
 */
public class Impression {
	
	/** L'utilisateur·rice réalisant l'impression. */
	private Utilisateur utilisateur;
	
	/** Date de réalisation de l'impression. */
	private Date date;
	
	/** Machine avec laquelle est réalisée l'impression. */
	private Machine machine;
	
	/** Poids de l'impression */
	private double poids;
	
	/** Durée d'impression */
	private int duree;
	
	/** Couleur d'impression (rouge, vert, blanc, etc) */
	private String couleur;
	
	/** Matière utilisée pour l'impression (ABS, PLA, etc) */
	private Matiere matiere;
	
	/** Indique si l'utilisateur·rice a été facturé·e pour cette impression. */
	private boolean facturee;
	
	/** Identifiant unique d'impression */
	private int identifiant;
	
	public Impression(Utilisateur utilisateur, Date date, Machine machine, double poids, int duree, String couleur, Matiere matiere) {
		this.utilisateur = utilisateur;
		this.date = date;
		this.machine = machine;
		this.poids = poids;
		this.duree = duree;
		this.couleur = couleur;
		this.matiere = matiere;
		facturee = false;
		try {
			identifiant = lireOuGenererIdentifiant("ListeImpressions.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("null")
	public static int lireOuGenererIdentifiant(String chemin) throws IOException {

		BufferedReader lecteur = GestionFichiers.lireFichier(chemin);

		// Si le fichier n'existe pas, créer un nouvel identifiant
		if (!(lecteur == null)) {
			int nouvelIdentifiant = 1;
			enregistrerIdentifiantDansFichierCSV(nouvelIdentifiant, chemin);
			return nouvelIdentifiant;
		}

		// Lire l'identifiant à partir du fichier CSV
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

		BufferedWriter ecrivain = GestionFichiers.ecrireFichier(chemin);
		// Écrire l'identifiant dans le fichier CSV
		try {
			ecrivain.write(String.valueOf(identifiant));
			ecrivain.newLine();
			ecrivain.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enregistrerImpression() {
		
	}

}
