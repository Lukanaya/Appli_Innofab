package fr.innofab.appli;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * Un·e utilisateur·ice du fablab, iel peut ajouter des impressions à son nom ainsi que les modifier.
 */
public class Utilisateur {
	
	/** Nom de l'utilisateur·rice */
	private String nom;
	
	/** Prénom de l'utilisateur·rice */
	private String prenom;
	
	/** Login de l'utilisateur·rice */
	private String login;
	
	/** Mot de passe de l'utilisateur·rice */
	private String motDePasse;
	
	/** Le coût d'impression à facturer pour cet·te utilisateur·rice */
	private double coutDimpression;
	
	/** La liste d'impressions effectuées par cet·te utilisateur·rice */
	private ArrayList<Impression> impressions;
	
	/** Le nombre d'impressions restantes à facturer */
	private int impressionsAFacturer;
	
	/**
	 * Connexion d'un utilisateur au logiciel, on charge sa liste d'impressions en mémoire.
	 * @param login le login de l'utilisateur
	 * @param motdepasse le mot de passe de l'utilisateur
	 */
	public Utilisateur(String login, String motdepasse) {
		this.login = login;
		this.motDePasse = motdepasse;
		String[] infosUtilisateur = new String[4];
		infosUtilisateur = lireUtilisateur(login, motdepasse, "utilisateurs.csv");
		prenom = infosUtilisateur[2];
		nom = infosUtilisateur[3];
		impressions = new ArrayList<Impression>();
		coutDimpression = 0;
		impressionsAFacturer = 0;
		InitialiserUtilisateur(nom, prenom);
	}

	public static String[] lireUtilisateur(String login, String mdp, String chemin) {

		String[] utilisateur = new String[4];

		if (!(GestionFichiers.ecrireFichier(chemin) == null)) { // on vérifie l'existence du fichier
			try {
				// Lire l'utilisateur à partir du fichier CSV
				BufferedReader lecteur = GestionFichiers.lireFichier(chemin);
				String ligne;

				// Trouver l'utilisateur correspondant dans le fichier
				while ((ligne = lecteur.readLine()) != null) {
					String[] colonnes = ligne.split(",");
					if (colonnes.length > 0) {
						if (colonnes[0].equals(login) && colonnes[1].equals(mdp)) {
							System.arraycopy(colonnes, 0, utilisateur, 0, colonnes.length);
						}
					}
				}
				lecteur.close();
			} catch (IOException e) {
				System.out.println("Il y a eu un problème avec le fichier.");
			}
		}

		return utilisateur;

	}
	
	public void AjouterImpression(Machine machine, double poids, int duree, String couleur, Matiere matiere) {
		Date date = new Date();
		impressions.add(new Impression(this, date, machine, poids, duree, couleur, matiere));
		
	}
	
	public void ModifierImpression() {
		
	}
	
	private void InitialiserUtilisateur(String nom, String prenom) {
		
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public double getCoutDimpression() {
		return coutDimpression;
	}

	public ArrayList<Impression> getImpressions() {
		return impressions;
	}

	public int getImpressionsAFacturer() {
		return impressionsAFacturer;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setCoutDimpression(double coutDimpression) {
		this.coutDimpression = coutDimpression;
	}

	public void setImpressions(ArrayList<Impression> impressions) {
		this.impressions = impressions;
	}

	public void setImpressionsAFacturer(int impressionsAFacturer) {
		this.impressionsAFacturer = impressionsAFacturer;
	}
	
	@Override
	public String toString() {
		return nom + " " + prenom;
	}

}
