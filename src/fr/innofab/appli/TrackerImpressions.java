package fr.innofab.appli;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Application pour noter et gérer les impressions des adhérant·e·s du fablab.
 */
public class TrackerImpressions {

	public static void main(String args[]) {
		ArrayList<Machine> listeMachines = Machine.lireFichierMachines("machines.csv");
		for (int i = 0; i < listeMachines.size(); i++) {
			System.out.println(listeMachines.get(i).toString());
		}
	}

}