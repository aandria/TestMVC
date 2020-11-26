package com.oxiane.test.vue;

import java.util.Observable;
import java.util.Observer;

import com.oxiane.test.modele.TestModel;

@SuppressWarnings("deprecation")
public class TestView implements Observer {

	private TestModel testmodele;
	
	@Override
	public void update(Observable testmodele, Object arg1) {
		this.testmodele= (TestModel) testmodele;
	}
}
