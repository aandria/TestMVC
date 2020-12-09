package com.oxiane.test.key.model;

import java.util.Observable;

@SuppressWarnings("deprecation")
public class KeyModelTest extends Observable{
	
	private String key,event;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		setChanged();
		this.key = key;
		notifyChanges();
	}
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		setChanged();
		this.event = event;
		notifyChanges();
	}
	
	public void notifyChanges() {
		notifyObservers();
	}
}
