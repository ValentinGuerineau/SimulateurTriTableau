package vue;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

import model.Model;

public class FenetrePrincipal extends JFrame{
	
	private ZoneDeTri zoneDeTri;
	private ZoneAction zoneAction; 

	private Model model;
	
	
	public FenetrePrincipal() {
		
		this.setTitle("Simulateur de tri de tableau");
		this.setSize(1280, 720);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		this.setVisible(true);
		
		model = Model.getInstance();
		this.setLayout(new BorderLayout());
		zoneDeTri =  new ZoneDeTri(model.getLesCases());
		zoneAction = new ZoneAction();
		
		this.getContentPane().add(zoneAction,BorderLayout.NORTH);
		this.getContentPane().add(zoneDeTri,BorderLayout.CENTER);
		
		zoneDeTri.go();

	}
}
