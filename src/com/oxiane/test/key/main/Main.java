package com.oxiane.test.key.main;

import com.oxiane.test.key.controler.KeyListenerTest;
import com.oxiane.test.key.model.KeyModelTest;
import com.oxiane.test.key.view.KeyViewTest;

public class Main {
	
	private KeyModelTest keyModel;
	private KeyViewTest keyView ;
	@SuppressWarnings("unused")
	private KeyListenerTest keyControler ;
	
	private void init() {
		keyModel = new KeyModelTest();
		keyView = new KeyViewTest();
		keyControler = new KeyListenerTest(keyModel);
	}
	
	@SuppressWarnings("deprecation")
	private void addObservers() {
		keyModel.addObserver(keyView);
	}
	
	private void launchProgram() {
		init();
		addObservers();
	}

	public static void main(String[] args) {
		Main main = new Main();
		main.launchProgram();
        
    }
}
