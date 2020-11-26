package com.oxiane.test.controleur;

import java.util.TimerTask;

import com.oxiane.test.modele.TestModel;

public class TestControler {
	private TestModel testmodele;
	
	public TestControler(TestModel testmodele) {
		this.testmodele=testmodele;
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
	            testmodele.increment();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
