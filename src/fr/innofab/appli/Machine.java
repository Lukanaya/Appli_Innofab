package fr.innofab.appli;

import java.util.ArrayList;

/**
 * Une machine du fablab, contient plusieures informations comme le type de machine,
 * le coût du matériau, le type de matériau, le coût d'utilisation, etc.
 */
public class Machine {
	
	private String type;
	
	private ArrayList<Matiere> matiere;
	
	private double coutUtilisation;

}