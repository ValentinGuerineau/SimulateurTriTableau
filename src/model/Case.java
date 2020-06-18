package model;

import java.awt.Color;
import java.util.ArrayList;

import model.deplacement.*;

public class Case {
	
	public final static int TAILLE_CASE = 100;
	
	private int xIni;
	private int yIni;
	private int valeurIni;
	
	
	private ArrayList<Deplacement> lesDeplacements;
	private int dureeDeplacement;
	
	private int deplacementActu;
	
	
	public Case(int x , int y ,int valeur) {
		xIni = x;
		yIni = y;
		valeurIni = valeur;
		
		lesDeplacements = new ArrayList<Deplacement>();
		dureeDeplacement = 0;
		deplacementActu = -1;
	}
	
	public void miseAZero() {
		dureeDeplacement = 0;
		deplacementActu = -1;
		lesDeplacements.removeAll(lesDeplacements);
	}
	public void ajouterDeplacementHaut(int duree,int valeur , Color couleur) {
		if(duree > 0) {
			int nbDeplacement = lesDeplacements.size();
			int xDebut = xIni;
			int yDebut = yIni;
			int tDebut = dureeDeplacement+1;
	
			if(nbDeplacement > 0) {
				Deplacement dernier = lesDeplacements.get(nbDeplacement-1);
				xDebut = dernier.getXFinal();
				yDebut =  dernier.getYFinal();
			}
			
			lesDeplacements.add( new Haut(xDebut,yDebut,tDebut,duree,valeur ,couleur));
			dureeDeplacement += duree;
		}
	}
	
	public void ajouterDeplacementBas(int duree,int valeur , Color couleur) {
		if(duree > 0) {
			int nbDeplacement = lesDeplacements.size();
			int xDebut = xIni;
			int yDebut = yIni;
			int tDebut = dureeDeplacement+1;
	
			if(nbDeplacement > 0) {
				Deplacement dernier = lesDeplacements.get(nbDeplacement-1);
				xDebut = dernier.getXFinal();
				yDebut =  dernier.getYFinal();
			}
			
			lesDeplacements.add( new Bas(xDebut,yDebut,tDebut,duree,valeur ,couleur));
			dureeDeplacement += duree;
		}
	}
	
	
	public void ajouterDeplacementDroite(int duree,int valeur , Color couleur) {
		if(duree > 0) {
			int nbDeplacement = lesDeplacements.size();
			int xDebut = xIni;
			int yDebut = yIni;
			int tDebut = dureeDeplacement+1;
	
			if(nbDeplacement > 0) {
				Deplacement dernier = lesDeplacements.get(nbDeplacement-1);
				xDebut = dernier.getXFinal();
				yDebut =  dernier.getYFinal();
			}
			
			lesDeplacements.add( new Droite(xDebut,yDebut,tDebut,duree,valeur ,couleur));
			dureeDeplacement += duree;
		}
	}
	
	public void ajouterDeplacementGauche(int duree,int valeur , Color couleur) {
		if(duree > 0) {
			int nbDeplacement = lesDeplacements.size();
			int xDebut = xIni;
			int yDebut = yIni;
			int tDebut = dureeDeplacement+1;
	
			if(nbDeplacement > 0) {
				Deplacement dernier = lesDeplacements.get(nbDeplacement-1);
				xDebut = dernier.getXFinal();
				yDebut =  dernier.getYFinal();
			}
			
			lesDeplacements.add( new Gauche(xDebut,yDebut,tDebut,duree,valeur ,couleur));
			dureeDeplacement += duree;
		}
	}
	
	
	public void ajouterDeplacementStable(int duree,int valeur , Color couleur) {
		if(duree > 0) {
			int nbDeplacement = lesDeplacements.size();
			int xDebut = xIni;
			int yDebut = yIni;
			int tDebut = dureeDeplacement+1;
	
			if(nbDeplacement > 0) {
				Deplacement dernier = lesDeplacements.get(nbDeplacement-1);
				xDebut = dernier.getXFinal();
				yDebut =  dernier.getYFinal();
			}
			
			lesDeplacements.add( new Stable(xDebut,yDebut,tDebut,duree,valeur ,couleur));
			dureeDeplacement += duree;
		}
	}
		
	public int getXIni() {
		return xIni;
	}

	public int getYIni() {
		return yIni;
	}

	public int getValeurIni() {
		return valeurIni;
	}

	public void setValeurIni(int valeurIni) {
		this.valeurIni = valeurIni;
	}

	public void trouverDeplacementActu(int t) {
		int nbDeplacement = lesDeplacements.size() ;
		if(nbDeplacement > 0) {
			if(deplacementActu < 0) {
				deplacementActu = 0;
			}
			
			while(deplacementActu + 1 < nbDeplacement & t > lesDeplacements.get(deplacementActu).getTFin()) {
				deplacementActu++;
			}
			while(deplacementActu - 1 >= 0 & t < lesDeplacements.get(deplacementActu).getTDebut()) {
				deplacementActu--;
			}
		}else {
			deplacementActu = -1;
		}
	}
	
	public boolean estTempsMouvementStable(int t) {
		trouverDeplacementActu(t);
		return lesDeplacements.get(deplacementActu).estStable();
	}
	
	public int getX(int t) {
		trouverDeplacementActu(t);
		
		if(t <= 0 || deplacementActu < 0 ) {
			return xIni;
		}
		
		return lesDeplacements.get(deplacementActu).getX(t);
	}
	
	public int getY(int t) {
		trouverDeplacementActu(t);
		
		if(t <= 0 || deplacementActu < 0) {
			return yIni;
		}
		
		return lesDeplacements.get(deplacementActu).getY(t);
	}
	
	public int getValeur(int t) {
		trouverDeplacementActu(t);
		
		if(t <= 0 || deplacementActu < 0) {
			return valeurIni;
		}
		
		return lesDeplacements.get(deplacementActu).getValeur();
	}
	
	
	public int getXFinal() {
		return getX(dureeDeplacement);
	}
	public int getYFinal() {
		return getY(dureeDeplacement);
	}
	public int getValeurFinal() {
		return getValeur(dureeDeplacement);
	}
	
	
	public int getDureeDeplacement() {
		return dureeDeplacement;
	}
	
	public String toString() {
		String aRenvoyer ="";
		
		for(int t = 0; t <= dureeDeplacement+1 ; t++ ) {
			aRenvoyer += "t : "+t+" ->Val : "+getValeur(t)+" X : "+getX(t)+" Y : "+getY(t)+"\n";
		}
		return aRenvoyer;
	}

}
