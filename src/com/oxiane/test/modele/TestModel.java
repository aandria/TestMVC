package com.oxiane.test.modele;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import com.oxiane.test.vue.utils.Utils;

@SuppressWarnings("deprecation")
public class TestModel extends Observable{
	
	private int variable = 0;
	private MyTimerTaskModel myTimerTaskModel;
	private Timer timerModel;
	
	public TestModel() {
		myTimerTaskModel = new MyTimerTaskModel();
		timerModel = Utils.CreateTimer();
		timerModel.scheduleAtFixedRate(myTimerTaskModel, 20, 10);
	}
	
	// appelée par le controleur 
	public void incVariable() {
		setChanged();
		variable++;
	}
		
	// appelée par la vue
	public int getVariable() {
		return variable;
	}
	
	private void notifyChanges() {
		notifyObservers();
	}
	
	/**
	 * TimerTask spécifique à TestModel
	 * @author ext-flanic
	 *
	 */
	private class MyTimerTaskModel extends TimerTask {
	    @Override
	    public void run() {
	        completeTask();
	    }

	    private void completeTask() {
	        try {
	            //assuming it takes 5 secs to complete the task
	            Thread.sleep(5000);
	            notifyChanges();
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
