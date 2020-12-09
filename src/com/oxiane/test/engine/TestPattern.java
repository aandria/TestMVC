package com.oxiane.test.engine;


import com.oxiane.test.controleur.TestControler;
import com.oxiane.test.modele.TestModel;
import com.oxiane.test.vue.TestView;

public class TestPattern {

	private TestModel testModel;
	private TestView testView ;
	private TestControler testControler ;
	
	public void manageTime() throws InterruptedException {
		//2 mins d'action entre le controleur le modèle et la vue
		//threadSleep(120000);
        Thread.sleep(120000);
		
		//arrêt du timer du modèle et du contrôleur
		testModel.cancel();
        testControler.cancel();
        
        //on patiente 30 sec
        //threadSleep(30000);
        Thread.sleep(30000);
	}
	
	public void launchProgram() throws InterruptedException {
		//Initialisation des variables pour les liaisons MVC
		init();
		addObservers();
		manageTime();
		try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	private void init() {
		testModel = new TestModel();
		testView = new TestView();
		testControler = new TestControler(testModel);
	}
	
	@SuppressWarnings("deprecation")
	private void addObservers() {
		testModel.addObserver(testView);
	}

	
	public static void main(String[] args) throws InterruptedException {
		TestPattern pattern = new TestPattern();
		pattern.launchProgram();
	}
}
