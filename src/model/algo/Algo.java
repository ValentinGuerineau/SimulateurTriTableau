package model.algo;

import java.awt.Color;

import model.Case;
import model.LesCases;

public  class Algo {
private LesCases lesCases;
	
	public Algo(LesCases lesCases) {
		this.lesCases = lesCases;
	}
	
	/** un fonction qui normalement est lancer a la fin d'une boucle comme ca les cases voulu bouge et pas les autres **/
	public void egalisationDesTempsMax() {
		/** On fais en sorte que les autres case ne bouge pas **/
		lesCases.egalisationTempsMax();
	}

	public void affectationCaseVersCase(int i1,int i2) {
		
		
		Case c1 = lesCases.getCase(i1),c2= lesCases.getCase(i2);
		
		int valeurC1 = c1.getValeurFinal();
		int valeurC2 = c2.getValeurFinal();
		
		
		/** On fais dessendre la cases donneuse **/
		c1.ajouterDeplacementBas(Case.TAILLE_CASE*2, valeurC1,Color.black);
		
		int xC1 = c1.getXFinal();
		int xC2 = c2.getYFinal();
		int xDiff;
		
		/** On les fais ce rejoindre **/
		if(xC1 > xC2) {
			xDiff = xC1 - xC2;
			c1.ajouterDeplacementGauche(xDiff, valeurC1,Color.black);
			c2.ajouterDeplacementStable(xDiff, valeurC2,Color.black);
		}else {
			xDiff = xC2 - xC1;
			c1.ajouterDeplacementDroite(xDiff, valeurC1,Color.black);
			c2.ajouterDeplacementStable(xDiff, valeurC2,Color.black);
		}
		
		/** la case c1 remonte au contact de l'autre **/
		c1.ajouterDeplacementHaut(Case.TAILLE_CASE, valeurC1,Color.black);
		
		/** On les fait patienter **/
		c1.ajouterDeplacementStable(2, valeurC1,Color.black);
		c2.ajouterDeplacementStable(2, valeurC2,Color.black);
		
		/** On change la valeur**/
		valeurC2 = valeurC1;
		
		/** On les fait patienter **/
		c1.ajouterDeplacementStable(2, valeurC1,Color.black);
		c2.ajouterDeplacementStable(2, valeurC2,Color.black);
		
		/** la case c1 redescend **/
		c1.ajouterDeplacementBas(Case.TAILLE_CASE, valeurC1,Color.black);
		
		/** c1 revient a ca position d'origine **/
		if(xC1 > xC2) {
			c1.ajouterDeplacementDroite(xDiff, valeurC1,Color.black);
			c2.ajouterDeplacementStable(xDiff, valeurC2,Color.black);
		}else {
			c1.ajouterDeplacementGauche(xDiff/2, valeurC1,Color.black);
			c2.ajouterDeplacementStable(xDiff/2, valeurC2,Color.black);
		}
		
		/** On les fais remonter **/
		
		c1.ajouterDeplacementHaut(Case.TAILLE_CASE*2, valeurC1,Color.black);
		c2.ajouterDeplacementStable(Case.TAILLE_CASE*2, valeurC2,Color.black);
		
		//egalisationDesTempsMax();
	}
	
	public void comparaisonCaseCase(int i1,int i2) {
		
		
		Case c1 = lesCases.getCase(i1),c2= lesCases.getCase(i2);
		
		int valeurC1 = c1.getValeurFinal();
		int valeurC2 = c2.getValeurFinal();
		
		
		/** On fais dessendre les cases **/
		c1.ajouterDeplacementBas(Case.TAILLE_CASE*2, valeurC1,Color.black);
		c2.ajouterDeplacementBas(Case.TAILLE_CASE*2, valeurC2,Color.black);
		
		int xC1 = c1.getXFinal();
		int xC2 = c2.getYFinal();
		int xDiff;
		
		/** On les fais ce rejoindre **/
		if(xC1 > xC2) {
			xDiff = xC1 - xC2;
			c1.ajouterDeplacementGauche(xDiff/2, valeurC1,Color.black);
			c2.ajouterDeplacementDroite(xDiff/2, valeurC2,Color.black);
		}else {
			xDiff = xC2 - xC1;
			c2.ajouterDeplacementGauche(xDiff/2, valeurC2,Color.black);
			c1.ajouterDeplacementDroite(xDiff/2, valeurC1,Color.black);
		}
		
		/** On les fait patienter **/
		c1.ajouterDeplacementStable(2, valeurC1,Color.black);
		c2.ajouterDeplacementStable(2, valeurC2,Color.black);
				
		
		/** On les fais ce separe **/
		if(xC1 > xC2) {
			c1.ajouterDeplacementDroite(xDiff/2, valeurC1,Color.black);
			c2.ajouterDeplacementGauche(xDiff/2, valeurC2,Color.black);
		}else {
			c2.ajouterDeplacementDroite(xDiff/2, valeurC2,Color.black);
			c1.ajouterDeplacementGauche(xDiff/2, valeurC1,Color.black);
		}
		
		/** On les fais remonter **/
		
		c1.ajouterDeplacementHaut(Case.TAILLE_CASE*2, valeurC1,Color.black);
		c2.ajouterDeplacementHaut(Case.TAILLE_CASE*2, valeurC2,Color.black);
		
		//egalisationDesTempsMax();
	}
	
	public void affectationCaseVersVar(Case c) {
		
	}
	
	public void affectationVarVersCase(Case c) {
		
	}
	

	
	public void comparaisonCaseVar(Case c) {
		
	}
	
}
