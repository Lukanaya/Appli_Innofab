package fr.innofab.appli;

import java.util.ArrayList;

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
	
	/** Mot de passe (hashé et salé) de l'utilisateur·rice */
	private String motDePasse;
	
	/** Le coût d'impression à facturer pour cet·te utilisateur·rice */
	private double coutDimpression;
	
	/** La liste d'impressions effectuées par cet·te utilisateur·rice */
	private ArrayList<Impression> impressions;
	
	/** Le nombre d'impressions restantes à facturer */
	private int impressionsAFacturer;
	
	public Utilisateur(String nom, String prenom) {
		impressions = new ArrayList<Impression>();
		this.nom = nom;
		this.prenom = prenom;
		coutDimpression = 0;
		impressionsAFacturer = 0;
		InitialiserUtilisateur(nom, prenom);
	}
	
	public void AjouterImpression() {
		
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

}
