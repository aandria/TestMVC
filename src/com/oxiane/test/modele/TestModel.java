package com.oxiane.test.modele;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class TestModel extends Observable{
	
	private int variable = 0;
	
	public TestModel() {
		// TODO Auto-generated constructor stub
	}
	
	public void increment() {
		variable++;
	}
	
	public void setVariable(int variable) {
		this.variable = variable;
	}
	
	public int getVariable() {
		return variable;
	}
}
