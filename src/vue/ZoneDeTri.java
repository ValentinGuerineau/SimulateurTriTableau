package vue;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Case;
import model.LesCases;

public class ZoneDeTri extends JPanel{

	private  ArrayList<VueCase> lesCasesVue;
	private LesCases lesCases;
	private static  int tActu;
	
	public static int getTActu() {
		return tActu;
	}
	
	public ZoneDeTri(LesCases lesCases) {
		
		this.setLayout(null);
		tActu = 0;
		this.lesCases = lesCases;
		lesCasesVue =  new ArrayList<VueCase>();
		Case c;
		VueCase vc;
		
		
		vc = new VueCase(lesCases.getVariable());
		lesCasesVue.add(vc);
		this.add(vc);
		
		for(int i = 0 ; i < lesCases.getNbCases() ; i++){
			c = lesCases.getCase(i);
			vc = new VueCase(c);
			lesCasesVue.add(vc);
			this.add(vc);
		}
		
	}
	
	 /*public void paintComponent(Graphics g){
		 for(int i = 0 ; i < lesCasesVue.size() ; i++) {
			 lesCasesVue.get(i).go();
		 }
	}*/
	 
	
	public void go(){
		//System.out.println(lesCases.getMaxTemps());
		 for(tActu = 0 ; tActu <= lesCases.getMaxTemps() ; tActu++){
			// System.out.println(tActu);
			 for(int i = 0 ; i < lesCasesVue.size() ; i++) {
				 lesCasesVue.get(i).go();
			 }
			 this.repaint();
			 try {
				 Thread.sleep(5);
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			 }
		 }
	} 


	 
}
