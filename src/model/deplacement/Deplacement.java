package model.deplacement;

import java.awt.Color;

public abstract class Deplacement {

	protected int valeur;
	/** Les coordonner son en veriter les coordoner de fin du Deplacement precedent **/
	protected int xDebutMouv;
	protected int yDebutMouv;
	
	protected int tDebut;//Ne peut etre egal a 0
	protected int tFin;
	
	protected Color couleur;
	
	
	
	public Deplacement(int xDebut,int yDebut,int tDebut,int duree ,int valeur,Color couleur) {
		this.xDebutMouv = xDebut;
		this.yDebutMouv = yDebut;
		this.tDebut = tDebut;
		this.tFin = tDebut+duree-1;
		this.valeur = valeur;
		this.couleur =  couleur;
		
	
	}
	
	public Color getCouleur() {
		return couleur;
	}
	
	public int getValeur() {
		return valeur;
	}
	
	public int getXFinal() {
		return  getX(tFin);
	}
	
	public int getYFinal() {
		return  getY(tFin);
	}
	
	public int getTDebut() {
		return tDebut;
	}
	
	public int getTFin() {
		return tFin;
	}
	
	public boolean estStable() {
		return false;
	}
	
	public abstract int getX(int t);
	public abstract int getY(int t);
	
}
