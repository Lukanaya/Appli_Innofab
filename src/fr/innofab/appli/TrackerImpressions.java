package fr.innofab.appli;

import java.util.Scanner;

/**
 * Application pour noter et gérer les impressions des adhérant·e·s du fablab.
 */
public class TrackerImpressions {
	
	private static Scanner entree = new Scanner(System.in);
	
	
	
	public static void main(String args[]) {
		Utilisateur utilisateur;
		String login, motDePasse;
		
		System.out.println("Bienvenue sur le tracker d'Innofab\n\nVeuillez vous connecter :");
		System.out.println("Login : ");
		login = entree.nextLine();
		System.out.println("Mot de passe : ");
		motDePasse = entree.nextLine();
		utilisateur = new Utilisateur(login, motDePasse);
		System.out.println("Vous êtes : " + utilisateur);
	}

}