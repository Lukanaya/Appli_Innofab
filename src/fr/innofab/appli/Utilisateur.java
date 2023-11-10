package fr.innofab.appli;

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
	
	public Utilisateur(String login, String motdepasse) {
		this.login = login;
		this.motDePasse = motdepasse;
		String[] infosUtilisateur = new String[4];
		try {
			infosUtilisateur = GestionFichiers.lireUtilisateur(login, motdepasse, "utilisateurs.csv");
			nom = infosUtilisateur[3];
			prenom = infosUtilisateur[2];
			
		}catch (IOException exc) {
			System.out.println("problème");
		}
		impressions = new ArrayList<Impression>();
		coutDimpression = 0;
		impressionsAFacturer = 0;
		InitialiserUtilisateur(nom, prenom);
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
