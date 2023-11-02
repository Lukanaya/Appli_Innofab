package fr.innofab.appli;

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

}
