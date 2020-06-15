package model;

import java.awt.Color;
import java.util.ArrayList;

public class LesCases {
	
	public final static int ESPACE_ENTRE_CASE = 10;
	
	private ArrayList<Case> lesCases;
	
	public LesCases() {
		lesCases = new ArrayList<Case>();
	}
	
	/*** a ameliore **/
	public void addCases(Case c) {
		lesCases.add(c);
	}
	
	public int getMaxTemps() {
		int tM = 0;
		int nbCases = lesCases.size();
		int maxActu;
		Case caseActu;
		for(int i = 0; i < nbCases ; i++) {
			caseActu = lesCases.get(i);
			maxActu = caseActu.getDureeDeplacement();
			if( tM < maxActu ) {
				tM = maxActu;
			}
		}
		
		return tM;
	}
	
	public int getNbCases() {
		return lesCases.size();
	}
	
	public Case getCase(int i) {
		return lesCases.get(i);
	}
	
	
	public String toString() {
		String aRenvoyer = "";
		int tempsMax = getMaxTemps();
		Case caseActu;
		
		for(int i = 0 ; i <= tempsMax ; i++) {
			aRenvoyer += "T :  "+i+"  ->  ";
			for(int j = 0 ; j < lesCases.size() ; j++) {
				caseActu = lesCases.get(j);
				aRenvoyer += "  n°"+j+"(Val : "+caseActu.getValeur(i) +" X : "+caseActu.getX(i) +" Y : "+caseActu.getY(i) +")";
			}
			aRenvoyer += "\n";
		}
		
		return aRenvoyer;
	}

	public void egalisationTempsMax() {
		// TODO Auto-generated method stub
		/** Pour egaliser les temps max on ajoute a chaque case un mouvement stable de duree (tempsMax - tempsMaxActu) **/
		int tempsMax = getMaxTemps();
		int tempsMaxActu;
		Case caseActu;

		
		for(int i = 0 ; i < lesCases.size() ; i++) {
			caseActu = lesCases.get(i);
			tempsMaxActu = caseActu.getDureeDeplacement();
			
			caseActu.ajouterDeplacementStable(tempsMax-tempsMaxActu,caseActu.getValeurFinal(),Color.black);
			
		}
	}

}
