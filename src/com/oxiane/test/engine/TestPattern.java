package com.oxiane.test.engine;


import java.util.Timer;

import com.oxiane.test.controleur.TestControler;
import com.oxiane.test.modele.TestModel;
import com.oxiane.test.vue.TestView;

public class TestPattern {

	private static TestModel testmodel = new TestModel();
	private static TestView testview = new TestView();
	private static TestControler testcontroler = new TestControler(testmodel);
	
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testmodel.addObserver(testview);
		
		TestModel.MyTimerTaskModel timerTaskModel = testmodel.new MyTimerTaskModel();
		TestControler.MyTimerTaskControler timerTaskControler = testcontroler.new MyTimerTaskControler();
		
        //running timer task as daemon thread
        Timer timerModel = new Timer(true);
        Timer timerControler = new Timer(true);
        
        timerModel.scheduleAtFixedRate(timerTaskModel, 20, 10);
        System.out.println("TimerTaskModel started");
        
        timerControler.scheduleAtFixedRate(timerTaskControler, 0, 20);
        System.out.println("TimerTaskControler started");
        
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
