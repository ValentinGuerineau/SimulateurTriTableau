package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Case;

public class VueCase extends JPanel{

	private Case c;
	private JLabel valeur;

	public VueCase(Case c) {
		this.c = c;
		valeur =  new JLabel();
		
		this.setLayout(new BorderLayout());
		this.add(valeur,BorderLayout.CENTER);
		
		valeur.setText(""+c.getValeur(ZoneDeTri.getTActu()));
		valeur.setHorizontalAlignment(SwingConstants.CENTER);
		valeur.setVerticalAlignment(SwingConstants.CENTER);
		
		
		setBounds(c.getX(ZoneDeTri.getTActu()),c.getY(ZoneDeTri.getTActu()),Case.TAILLE_CASE,Case.TAILLE_CASE);
		
	}
	
	public void paintComponent(Graphics g) {
		g.setColor(Color.black);
		g.drawRect(0,0 , this.getWidth()-1, this.getHeight()-1);
	}
	
	public void go() {
		valeur.setText(""+c.getValeur(ZoneDeTri.getTActu()));
		setBounds(c.getX(ZoneDeTri.getTActu()),c.getY(ZoneDeTri.getTActu()),Case.TAILLE_CASE,Case.TAILLE_CASE);
	}
}
