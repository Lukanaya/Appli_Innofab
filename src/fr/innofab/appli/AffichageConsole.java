package fr.innofab.appli;

public class AffichageConsole {
	
	private static final String TITRE = 
			  "   _____           _   _               _____ _   _ _   _  ____  ______      ____  \n"
			+ "  / ____|         | | (_)             |_   _| \\ | | \\ | |/ __ \\|  ____/\\   |  _ \\ \n"
			+ " | |  __  ___  ___| |_ _  ___  _ __     | | |  \\| |  \\| | |  | | |__ /  \\  | |_) |\n"
			+ " | | |_ |/ _ \\/ __| __| |/ _ \\| '_ \\    | | | . ` | . ` | |  | |  __/ /\\ \\ |  _ < \n"
			+ " | |__| |  __/\\__ \\ |_| | (_) | | | |  _| |_| |\\  | |\\  | |__| | | / ____ \\| |_) |\n"
			+ "  \\_____|\\___||___/\\__|_|\\___/|_| |_| |_____|_| \\_|_| \\_|\\____/|_|/_/    \\_\\____/ \n"
			+ "\n\n----------------------------------------------------------------------------------\n"
			+ "|                              MENU PRINCIPAL                                    |\n"
			+ "----------------------------------------------------------------------------------\n\n";
	
	private static final char[] OPTIONS = {'u','c','a','q'};
	
	private static final String[] LIBELLE = {"Connexion [U]tilisateur","[C]onnexion Admin","[A]ide","[Q]uitter"};

	/**
	 * Affichage du menu principal
	 */
	public static void menuPrincipal() {
		/* on split le string à chaque retour à la ligne */
		String[] words = TITRE.split("\n");
		/* on affiche chaque morceau avec un intervalle de 200 ms */
		for (int part = 0; part < words.length; part++) {
			System.out.println(words[part]);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// on affiche toutes les options et les libellés
        for (int i = 0; i < OPTIONS.length; i++) {
            System.out.print("   => " + OPTIONS[i] + " - " + LIBELLE[i] + "\n");
        }
	}
	
	/**
	 * Vérifie si l'option entrée par l'utilisateur est valide ou non
     * @param aTester l'option à vérifier
     * @return un boolean vrai si le character est valide, faux sinon.
     */
    public static boolean reponseValide(String aTester) {
        boolean valide;

        // la réponse ne contient pas un caractère unique ==> true
        valide = !(aTester == null || aTester.length() != 1);
        if (valide) {
            /* Pour la premiere itération de la boucle */
            valide = false;

            for (int index = 0; index < OPTIONS.length && !valide; index++) {
                valide = aTester.charAt(0) == OPTIONS[index]
                        || aTester.charAt(0) + 32 == OPTIONS[index];
            }
        }
        if(!valide) {
        	System.out.println("Réponse incorrect");
        }
        return valide;
    }

}
