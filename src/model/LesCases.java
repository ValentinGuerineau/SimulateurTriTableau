package model;

import java.awt.Color;
import java.util.ArrayList;

import model.deplacement.Bas;
import model.deplacement.Deplacement;
import model.deplacement.Droite;
import model.deplacement.Gauche;
import model.deplacement.Haut;
import model.deplacement.Stable;

public class LesCases {
	
	
	/*** Par convention on mettre toujour la Variable plus a gauche que les cases ***/
	public final static int X_DEBUT = 200;
	public final static int Y_DEBUT = 100;
	
	public final static int ESPACE_ENTRE_CASE = 10;
	private final static int X_VARIABLE = 50;
	private final static int Y_VARIABLE = 300;
	
	private ArrayList<Case> lesCases;
	private Case variable;
	
	public LesCases() {
		lesCases = new ArrayList<Case>();
		variable = new Case(X_VARIABLE,Y_VARIABLE,0);
	}
	

	public void addCases(int valeur) {
		int xDebut = X_DEBUT;
		int yDebut = Y_DEBUT;
		
		if(lesCases.size() > 0) {
			xDebut = X_DEBUT + (lesCases.size()  ) * (Case.TAILLE_CASE + ESPACE_ENTRE_CASE);
		}
		
		lesCases.add(new Case(xDebut,yDebut,valeur));
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
	
	public Case getVariable() {
		return variable;
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
	
	
	public void ajouterDeplacementHaut(int indice,int duree,int valeur , Color couleur) {
		lesCases.get(indice).ajouterDeplacementHaut( duree, valeur ,  couleur);
	}
	
	public void ajouterDeplacementBas(int indice,int duree,int valeur , Color couleur) {
		lesCases.get(indice).ajouterDeplacementBas( duree, valeur ,  couleur);
	}
	
	
	public void ajouterDeplacementDroite(int indice,int duree,int valeur , Color couleur) {
		lesCases.get(indice).ajouterDeplacementDroite( duree, valeur ,  couleur);
	}
	
	public void ajouterDeplacementGauche(int indice,int duree,int valeur , Color couleur) {
		lesCases.get(indice).ajouterDeplacementGauche( duree, valeur ,  couleur);
	}
	
	
	public void ajouterDeplacementStable(int indice,int duree,int valeur , Color couleur) {
		lesCases.get(indice).ajouterDeplacementStable( duree, valeur ,  couleur);
	}
	
	public void miseAZero() {
		for(int i = 0 ; i < lesCases.size(); i++) {
			lesCases.get(i).miseAZero();
		}
	}

}
