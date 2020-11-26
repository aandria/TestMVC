package com.oxiane.test.modele;

import java.util.Observable;
import java.util.TimerTask;

@SuppressWarnings("deprecation")
public class TestModel extends Observable{
	
	private int variable = 0;
	
	
	public void increment() {
		variable++;
	}
	
	public void setVariable(int variable) {
		this.variable = variable;
	}
	
	public int getVariable() {
		return variable;
	}
	
	public void notifyChanges() {
		setChanged();
		notifyObservers();
	}
	
	public class MyTimerTaskModel extends TimerTask {

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
