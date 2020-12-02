package com.oxiane.test.modele;

import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

import com.oxiane.test.vue.Utils;

@SuppressWarnings("deprecation")
public class TestModel extends Observable implements ITestModel4TestView{
	
	private int variable = 0;
	private MyTimerTaskModel myTimerTaskModel;
	private Timer timerModel;
	
	
	public TestModel() {
		myTimerTaskModel = new MyTimerTaskModel();
		timerModel = Utils.CreateTimer();
		timerModel.scheduleAtFixedRate(myTimerTaskModel, 20, 10);
		System.out.println("TimerTaskModel started");
	}
	
	
	public void incVariable() {
		setChanged();
		variable++;
	}
	
	public void setVariable(int variable) {
		this.variable = variable;
	}
	
	public int getVariable() {
		return variable;
	}
	
	public void notifyChanges() {
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
	public void cancel() {
    	timerModel.cancel();
    }
}
