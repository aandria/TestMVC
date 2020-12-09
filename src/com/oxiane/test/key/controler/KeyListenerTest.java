package com.oxiane.test.key.controler;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.oxiane.test.key.model.*;

public class KeyListenerTest extends JFrame implements KeyListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JLabel label;
    private KeyModelTest keyModel;
    
    public KeyListenerTest(KeyModelTest model) {
    	super();
    	this.keyModel=model;
        JPanel panel = new JPanel();
        label = new JLabel("Key Listener!");
        panel.add(label);
        add(panel);
        addKeyListener(this);
        setSize(200, 100);
        setVisible(true);
	}
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	keyModel.setKey("right");
            keyModel.setEvent("typed");       
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	keyModel.setKey("left");
            keyModel.setEvent("typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
        	keyModel.setKey("up");
            keyModel.setEvent("typed");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        	keyModel.setKey("down");
            keyModel.setEvent("typed");
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	keyModel.setKey("right");
            keyModel.setEvent("pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	keyModel.setKey("left");
            keyModel.setEvent("pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
        	keyModel.setKey("up");
            keyModel.setEvent("pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        	keyModel.setKey("down");
            keyModel.setEvent("pressed");
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
        	keyModel.setKey("right");
            keyModel.setEvent("released");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
        	keyModel.setKey("left");
            keyModel.setEvent("released");
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
        	keyModel.setKey("up");
            keyModel.setEvent("released");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
        	keyModel.setKey("down");
            keyModel.setEvent("released");
        }
    }
}