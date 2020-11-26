package com.oxiane.test.vue;

import java.util.Observable;
import java.util.Observer;

import com.oxiane.test.modele.ITestModel4TestView;

@SuppressWarnings("deprecation")
public class TestView implements Observer {

	private ITestModel4TestView testModele;
	
	@Override
	public void update(Observable testModele, Object arg1) {
		this.testModele = (ITestModel4TestView) testModele;
		actionsDeTestView();
	}
	
	private void actionsDeTestView() {
		System.out.println("Variable mise à jour : "+ testModele.getVariable());
	}
}
