import java.awt.Color;

import model.Case;
import model.LesCases;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LesCases lesCases = new LesCases();
		
		Case c1 = new Case(10, 10, 5);
		c1.ajouterDeplacementBas(3, 5, Color.black);
		c1.ajouterDeplacementDroite(10, 5, Color.black);
		c1.ajouterDeplacementStable(10, 5, Color.black);
		
		Case c2 = new Case(10, 10, 5);
		c1.ajouterDeplacementBas(3, 5, Color.black);
		c1.ajouterDeplacementDroite(10, 5, Color.black);
		
		
		lesCases.addCases(c1);
		lesCases.addCases(c2);
		
		System.out.print(lesCases);
	}

}
