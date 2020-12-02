package com.oxiane.test.engine;


import java.util.Timer;

import com.oxiane.test.controleur.TestControler;
import com.oxiane.test.modele.TestModel;
import com.oxiane.test.vue.TestView;

public class TestPattern {

	private TestModel testModel;
	private TestView testView ;
	private TestControler testControler ;
	
	
	public void threadSleep(long delay) {
		try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public void manageTime() {
		threadSleep(120000);
        testModel.cancel();
        testControler.cancel();
        threadSleep(30000);
	}
	
	public void launchProgram(TestPattern pattern) {
		System.out.println("avant init");
		init();
		addObservers();
		manageTime();
		try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	private void init() {
		testModel = new TestModel();
		testView = new TestView();
		testControler = new TestControler(testModel);
	}
	
	@SuppressWarnings("deprecation")
	private void addObservers() {
		testModel.addObserver(testView);
	}

	
	public static void main(String[] args) {
		TestPattern pattern = new TestPattern();
		pattern.launchProgram(pattern);
	}
}
