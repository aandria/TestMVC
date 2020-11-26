package com.oxiane.test.engine;


import java.util.Timer;

import com.oxiane.test.controleur.TestControler;
import com.oxiane.test.controleur.TestControler.MyTimerTaskControler;
import com.oxiane.test.modele.TestModel;
import com.oxiane.test.modele.TestModel.MyTimerTaskModel;
import com.oxiane.test.vue.TestView;

public class TestPattern {

	private TestModel testmodel = new TestModel();
	private TestView testview = new TestView();
	private TestControler testcontroler = new TestControler(testmodel);
	
	public Timer CreateTimer() {
		Timer timer= new Timer(true);
		return timer;
	}
	
	public void CreateSchedulModel(Timer timer, MyTimerTaskModel timerTaskModel) {
		timer.scheduleAtFixedRate(timerTaskModel, 20, 10);
		System.out.println("TimerTaskModel started");
	}
	
	public void CreateSchedulControler(Timer timer, MyTimerTaskControler timerTaskControler) {
		timer.scheduleAtFixedRate(timerTaskControler, 0, 20);
		System.out.println("TimerTaskControler started");
	}
	
	public void TimerCancel(Timer timer) {
		timer.cancel();
		System.out.println(timer + " cancelled ");
	}
	
	public void ThreadSleep(long delay) {
		try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
	}
	
	public void CancelTimerTask(TestPattern pattern, Timer timer1, Timer timer2) {

		pattern.ThreadSleep(120000);
		
        pattern.TimerCancel(timer1);
        pattern.TimerCancel(timer2);
        
        pattern.ThreadSleep(30000);
	}
	
	@SuppressWarnings("deprecation")
	public void launchProgram(TestPattern pattern) {
		testmodel.addObserver(testview);
		
		TestModel.MyTimerTaskModel timerTaskModel = testmodel.new MyTimerTaskModel();
		TestControler.MyTimerTaskControler timerTaskControler = testcontroler.new MyTimerTaskControler();
		
		Timer timerModel = pattern.CreateTimer();
		Timer timerControler = pattern.CreateTimer();
		
		pattern.CreateSchedulControler(timerControler, timerTaskControler);
		pattern.CreateSchedulModel(timerModel, timerTaskModel);
		
		pattern.CancelTimerTask(pattern, timerModel, timerControler);
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestPattern pattern = new TestPattern();
		pattern.launchProgram(pattern);
	}
}
