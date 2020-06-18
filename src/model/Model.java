package model;

import java.util.Random;

import model.algo.Algo;

public class Model {
	
	private static Model Instance = null;
	public static Model getInstance() {
		if(Instance == null) {
			Instance = new Model();
		}
		
		return Instance;
	}
	
	public final static int NB_ALGO = 2;
	private Algo[] lesAlgo;
	private LesCases lesCases;
	
	private Model() {
		lesCases = new LesCases();
		creationAlgo();
		generateurCases(10);
		Algo a = new Algo(lesCases);
		a.comparaisonCaseVar(9,true);
		
	}
	
	private void creationAlgo() {
		lesAlgo = new Algo[NB_ALGO];
	}
	
	private void lancerAlgo(int i) {
		lesCases.miseAZero();
		//lesAlgo[i].lancerAlgo();
	}

	public LesCases getLesCases() {
		// TODO Auto-generated method stub
		return lesCases;
	}
	
	public void generateurCases(int nbCases) {
		
		int maximum = 99;
		
		Random rn = new Random();
		int alea;
		
		for(int i = 0 ; i < nbCases ; i++) {
			alea = rn.nextInt(maximum);
			lesCases.addCases(alea);
		}
	}

}
