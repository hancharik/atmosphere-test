/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atmospheretest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import java.util.ArrayList;


public class SolarSystemJPanel extends JPanel implements ActionListener, KeyListener{
    
    Timer t;
    int delay = 500;
    int size = 7;
    ArrayList<PlanetJButton> buttonList = new ArrayList<PlanetJButton>();
    PlanetJButton playerShip;
    
    
    /*
    
    PlanetJButton b1 = new PlanetJButton(1);
    PlanetJButton b2 = new PlanetJButton(2);
    PlanetJButton b3 = new PlanetJButton(3);
    PlanetJButton b4 = new PlanetJButton(4);
    PlanetJButton b5 = new PlanetJButton(5);
    PlanetJButton b6 = new PlanetJButton(6);
    */
    
   public SolarSystemJPanel(int planetNumber){
       
       super();
       this.size = planetNumber;
       setLayout(null);
       setBackground(Color.black);
      /* add(b1);
       add(b2);
       add(b3);
       add(b4);
       add(b5);
       add(b6);
       */
       playerShip = new PlanetJButton(11);
       playerShip.addActionListener(this);
       playerShip.addKeyListener(this);
       this.add(playerShip);
       
       
       for(int i = 0; i < size; i++){
        buttonList.add(new PlanetJButton(i)) ;   
       }
       
       
       for(int i = buttonList.size() - 1; i >= 0; i--){
    	   
    	   this.add(buttonList.get(i));
       }
       setFocusable(true);
		//addKeyListener((KeyListener) this);
       //b1.addActionListener(this);
       t = new Timer(delay, this);
       t.start();
       //t.setDelay(1);
       //repaint();
       this.requestFocusInWindow();
       playerShip.requestFocusInWindow();
   } 
    
    public void actionPerformed(ActionEvent event) 
    {

       	Object obj = event.getSource();
       	String choice = event.getActionCommand();
    
    
   

		if (obj == t)
		{
                    
                    for(int i = 0; i < size; i++){
                        
                        buttonList.get(i).moveButton();
                    }
		    /*     b1.moveButton();
                 b2.moveButton();
                 b3.moveButton();
                 b4.moveButton();
                 b5.moveButton();
                // b6.moveButton();
                 * */
                 
		}
    
    }
public void keyPressed(KeyEvent e){
		
		int k = e.getKeyCode();
		if(k == e.VK_UP){
			playerShip.moveUp();
                        playerShip.checkCollision();
		}
		if(k == e.VK_DOWN){
			playerShip.moveDown();
                        playerShip.checkCollision();
		}
		if(k == e.VK_LEFT){
		
                    playerShip.moveLeft();
                    playerShip.checkCollision();
		}
		if(k == e.VK_RIGHT){
			playerShip.moveRight();
                        playerShip.checkCollision();
		}
                if(k == e.VK_E){
			atmospheretest.GravityTest.game.inState = 2;
                        atmospheretest.GravityTest.game.fromSpace = true;
			atmospheretest.GravityTest.game.createScreen();
                        atmospheretest.GravityTest.game.repaint();
		}
		
	}
   public void createButtons(){
	   for(int i = 1; i < 7; i++){
	    	//buttonList[i]  =  new PlanetJButton(i);
	    }
	   
   }

    @Override
    public void keyTyped(KeyEvent e) {
      //  throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void keyReleased(KeyEvent e) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }
   
   
   
}
