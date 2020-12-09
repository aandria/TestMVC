package com.oxiane.test.key.view;

import java.util.Observable;
import java.util.Observer;

import com.oxiane.test.key.model.KeyModelTest;

@SuppressWarnings("deprecation")
public class KeyViewTest implements Observer{
	
	private KeyModelTest model;
	
	public void printEvent(String key, String event) {
    	switch (key) {
		case "up":
			System.out.println(key + " key " + event);
			break;
		case "down":
			System.out.println(key + " key " + event);
			break;
		case "left":
			System.out.println(key + " key " + event);
			break;
		case "right":
			System.out.println(key + " key " + event);
			break;
		default:
			break;
		}
    }

	@Override
	public void update(Observable model, Object arg) {
		this.model= (KeyModelTest) model;
		printEvent(this.model.getKey(), this.model.getEvent());
	}
}
