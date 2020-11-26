package com.oxiane.test.engine;


import java.util.Timer;

import com.oxiane.test.controleur.TestControler;
import com.oxiane.test.controleur.TestControler.MyTimerTaskControler;
import com.oxiane.test.modele.TestModel;
import com.oxiane.test.vue.TestView;

public class TestPattern {

	private TestModel testModel;
	private TestView testView;
	private TestControler testControler;
	
	// méthode à supprimer ici
	public Timer CreateTimer() {
		Timer timer= new Timer(true);
		return timer;
	}
	
	// méthode à supprimer ici
	public void createSchedulControler(Timer timer, MyTimerTaskControler timerTaskControler) {
		timer.scheduleAtFixedRate(timerTaskControler, 0, 20);
		System.out.println("TimerTaskControler started");
	}
	
	public void timerCancel(Timer timer) {
		timer.cancel();
		System.out.println(timer + " cancelled ");
	}
	
	// méthode à supprimer ici
	public void threadSleep(long delay) {
		try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }        
	}	
	
	private void manageTime(Timer timer2) {
		// 2 minutes d'actions entre le ctrl - model - view
		threadSleep(120000);		
		
		// arrêt des timers du modèle et de la vue
        testModel.cancel();        
        timerCancel(timer2);
        
        // on dort 30 secondes
        threadSleep(30000);
	}
	
	@SuppressWarnings("deprecation")
	public void launchProgram(TestPattern pattern) {
		init();		
		addObservers();
		
		TestControler.MyTimerTaskControler timerTaskControler = testControler.new MyTimerTaskControler();		
		Timer timerControler = pattern.CreateTimer();
		pattern.createSchedulControler(timerControler, timerTaskControler);
		
		pattern.manageTime(timerControler);
		while (true) {
			
		}
	}

	private void init() {
		// Mise en place du MVC 
		testModel = new TestModel();
		testView = new TestView();
		testControler = new TestControler(testModel);
	}
	
	private void addObservers() {
		testModel.addObserver(testView);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPattern pattern = new TestPattern();
		pattern.launchProgram(pattern);
	}
}
