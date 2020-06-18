package model.algo;

import java.awt.Color;

import model.Case;
import model.LesCases;

public class Algo {
private LesCases lesCases;
	
	public Algo(LesCases lesCases) {
		this.lesCases = lesCases;
	}
	
	/** un fonction qui normalement est lancer a la fin d'une boucle comme ca les cases voulu bouge et pas les autres **/
	public void egalisationDesTempsMax() {
		/** On fais en sorte que les autres case ne bouge pas **/
		lesCases.egalisationTempsMax();
	}
	
	/*** Cette fonction fais que la case c1 vas vers la case c2 ***/
	
	
	
	public void comparaisonCaseCase(int i1,int i2,boolean valide) {
		
		Case c1 = lesCases.getCase(i1),c2 = lesCases.getCase(2);
		
		int xC1 = c1.getXIni(),xC2 = c2.getXIni();
		int xDiff = xC1 - xC2;
		int valeurC1 = c1.getValeurFinal(),valeurC2 = c2.getValeurFinal();
		
		Color couleurComparaison;
		
		if(valide) {
			couleurComparaison = Color.green;
		}else {
			couleurComparaison = Color.red;
		}
		
		/** On les fais dessendre **/
		c1.ajouterDeplacementBas(Case.TAILLE_CASE*2, valeurC1, Color.blue);
		c2.ajouterDeplacementBas(Case.TAILLE_CASE*2, valeurC2, Color.blue);
		
		/** On les rapproche **/
		if(xDiff > 0) {
			xDiff -= Case.TAILLE_CASE;
			c1.ajouterDeplacementGauche(xDiff/2, valeurC1, Color.blue);
			c2.ajouterDeplacementDroite(xDiff/2, valeurC2, Color.blue);
		}else {
			xDiff += Case.TAILLE_CASE;
			c2.ajouterDeplacementGauche(-xDiff/2, valeurC2, Color.blue);
			c1.ajouterDeplacementDroite(-xDiff/2, valeurC1, Color.blue);
		}
		
		/** On les fait attendre **/
		c1.ajouterDeplacementStable(2, valeurC1, couleurComparaison);
		c2.ajouterDeplacementStable(2, valeurC2, couleurComparaison);
		
		/** On les eloigne **/
		if(xDiff > 0) {
			c2.ajouterDeplacementGauche(xDiff/2, valeurC2, Color.blue);
			c1.ajouterDeplacementDroite(xDiff/2, valeurC1, Color.blue);
		}else {
			c1.ajouterDeplacementGauche(-xDiff/2, valeurC1, Color.blue);
			c2.ajouterDeplacementDroite(-xDiff/2, valeurC2, Color.blue);
		}
		
		/** On les fais remonter **/
		c1.ajouterDeplacementHaut(Case.TAILLE_CASE*2, valeurC1, Color.blue);
		c2.ajouterDeplacementHaut(Case.TAILLE_CASE*2, valeurC2, Color.blue);
	}
	
	public void comparaisonCaseVar(int i,boolean valide) {
		
		Case c = lesCases.getCase(i),var = lesCases.getVariable();
		int xC = c.getXIni(),xVar = var.getXIni(),xDiff = xC - xVar,yC = c.getYIni(),yVar = var.getYIni(),yDiff = yVar - yC;
		int valeurC = c.getValeurIni(),valeurVar = var.getValeurIni();
		
		Color couleurComparaison;
		
		if(valide) {
			couleurComparaison = Color.green;
		}else {
			couleurComparaison = Color.red;
		}

		if(xDiff > yDiff) {
			c.ajouterDeplacementBas(yDiff, valeurC, Color.blue);
			c.ajouterDeplacementGauche((xDiff - yDiff- Case.TAILLE_CASE)/2, valeurC, Color.blue);
			var.ajouterDeplacementDroite(yDiff+(xDiff - yDiff- Case.TAILLE_CASE)/2, valeurVar, Color.blue);
		}else {
			var.ajouterDeplacementDroite(xDiff , valeurVar, Color.blue);
			var.ajouterDeplacementHaut(( yDiff - xDiff - Case.TAILLE_CASE)/2, valeurVar, Color.blue);
			c.ajouterDeplacementBas(xDiff+(yDiff - xDiff - Case.TAILLE_CASE)/2, valeurC, Color.blue);
		}
		
		/** On les fait attendre **/
		c.ajouterDeplacementStable(2, valeurC, couleurComparaison);
		var.ajouterDeplacementStable(2, valeurVar, couleurComparaison);
		
		
		if(xDiff > yDiff) {
			c.ajouterDeplacementDroite((xDiff - yDiff- Case.TAILLE_CASE)/2, valeurC, Color.blue);
			c.ajouterDeplacementHaut(yDiff, valeurC, Color.blue);
			var.ajouterDeplacementGauche(yDiff+(xDiff - yDiff- Case.TAILLE_CASE)/2, valeurVar, Color.blue);
		}else {
			var.ajouterDeplacementBas(( yDiff - xDiff - Case.TAILLE_CASE)/2, valeurVar, Color.blue);
			var.ajouterDeplacementGauche(xDiff , valeurVar, Color.blue);
			c.ajouterDeplacementHaut(xDiff+(yDiff - xDiff- Case.TAILLE_CASE)/2, valeurC, Color.blue);
		}
	}
	

	public void affectationCaseVersCase(int i1,int i2) {
		
		
	}
	
	
	public void affectationCaseVersVar(int i) {
		
	}
	
	public void affectationVarVersCase(int i) {
		
	}
	

	
	//public abstract void lancerAlgo();
}
