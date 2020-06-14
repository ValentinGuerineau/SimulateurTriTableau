package model.deplacement;

import java.awt.Color;

public class Stable extends Deplacement{

	public Stable(int xDebut, int yDebut, int tDebut, int duree, int valeur, Color couleur) {
		super(xDebut, yDebut, tDebut, duree, valeur, couleur);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getX(int t) {
		// TODO Auto-generated method stub
		return xDebutMouv;
	}

	@Override
	public int getY(int t) {
		// TODO Auto-generated method stub
		return yDebutMouv;
	}

}
