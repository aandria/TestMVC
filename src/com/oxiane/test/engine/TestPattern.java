package com.oxiane.test.engine;


import java.util.Timer;

import com.oxiane.test.controleur.TestControler;
import com.oxiane.test.controleur.TestControler.MyTimerTaskControler;
import com.oxiane.test.modele.TestModel;
import com.oxiane.test.vue.TestView;

public class TestPattern {

	private TestModel testModel = new TestModel();
	private TestView testView = new TestView();
	private TestControler testControler = new TestControler(testModel);
	
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
	
	public void cancelTimerTask(TestPattern pattern, Timer timer1, Timer timer2) {

		pattern.threadSleep(120000);
		
        pattern.timerCancel(timer1);
        pattern.timerCancel(timer2);
        
        pattern.threadSleep(30000);
	}
	
	@SuppressWarnings("deprecation")
	public void launchProgram(TestPattern pattern) {
		testModel.addObserver(testView);
		
		TestControler.MyTimerTaskControler timerTaskControler = testControler.new MyTimerTaskControler();		
		Timer timerControler = pattern.CreateTimer();
		pattern.createSchedulControler(timerControler, timerTaskControler);
		
		// pattern.CancelTimerTask(pattern, timerModel, timerControler);
		while (true) {
			
		}
	}

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPattern pattern = new TestPattern();
		pattern.launchProgram(pattern);
	}
}
