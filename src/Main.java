import java.awt.Color;

import model.Case;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Case c1 = new Case(10, 10, 5);
		c1.ajouterDeplacementBas(3, 5, Color.black);
		c1.ajouterDeplacementDroite(10, 5, Color.black);
		
		
		System.out.print(c1);
	}

}
