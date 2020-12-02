package com.oxiane.test.controleur;

import java.util.Timer;
import java.util.TimerTask;

import com.oxiane.test.modele.TestModel;
import com.oxiane.test.vue.Utils;

public class TestControler {
	private TestModel testmodele;
	private Timer timerControler;
	private MyTimerTaskControler myTimerTaskControler;
	
	public TestControler(TestModel testmodele) {
		this.testmodele=testmodele;
		myTimerTaskControler = new MyTimerTaskControler();
		timerControler = Utils.CreateTimer();
		timerControler.scheduleAtFixedRate(myTimerTaskControler, 0, 20);
		System.out.println("TimerTaskControler started");
	}
	
	public class MyTimerTaskControler extends TimerTask {

	    @Override
	    public void run() {
	        completeTask();
	    }

	    private void completeTask() {
	        try {
	            //assuming it takes 5 secs to complete the task
	            Thread.sleep(5000);
	            testmodele.incVariable();
	            System.out.println("variable incrémentée");
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
	
	public void cancel() {
		timerControler.cancel();
	}
}
