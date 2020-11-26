package com.oxiane.test.engine;


import java.util.Timer;

import com.oxiane.test.controleur.TestControler;
import com.oxiane.test.modele.TestModel;

public class TestPattern {

	private TestModel testmodel = new TestModel();
	private TestControler testcontroler = new TestControler(testmodel);
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TestModel.MyTimerTaskModel timerTaskModel = testmodel.new MyTimerTaskModel();
		TestControler.MyTimerTaskControler timerTaskControler = testcontroler.new MyTimerTaskControler();
		
        //running timer task as daemon thread
        Timer timerModel = new Timer(true);
        Timer timerControler = new Timer(true);
        
        timerModel.scheduleAtFixedRate(timerTaskModel, 20, 10);
        System.out.println("TimerTaskModel started");
        
        timerControler.scheduleAtFixedRate(timerTaskControler, 0, 20);
        
        //cancel after sometime
        try {
            Thread.sleep(120000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        timerModel.cancel();
        System.out.println("TimerTaskModel cancelled");
        
        timerControler.cancel();
        System.out.println("TimerTaskControler cancelled");
        
        
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

}
