/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atmospheretest;





import java.awt.*;
import javax.swing.*;
import java.awt.event.*;




public class AtmosphereJPanel extends JPanel implements ActionListener, KeyListener{
    
    Timer t;
    int delay = 1;
    PlayerJButton playerShip = new PlayerJButton(20);
    int count;
    int speed;
    JLabel counter = new JLabel();
    int gravity = 80; //20 is highest gravity, 200 is lowest, 40 is good gameplay
    int thrusters = 20;//40 is good, 20 is good gameplay
    
    
    /*  PlayerJButton b2 = new PlayerJButton();
    PlayerJButton b3 = new PlayerJButton();
    PlayerJButton b4 = new PlayerJButton();
    PlayerJButton b5 = new PlayerJButton();
    PlayerJButton b6 = new PlayerJButton();
    */
    
   public AtmosphereJPanel(){
       
       super();
       count = 0;
       speed = 1;
       setLayout(null);
       setBackground(Color.white);
       
       counter.setText("hello");
       counter.setLocation(200, 200);
       
       add(playerShip);
       add(counter);
       /*
       add(b2);
       add(b3);
       add(b4);
       add(b5);
       add(b6);
       */
       playerShip.addActionListener(this);
       playerShip.addKeyListener(this);
       t = new Timer(gravity, this);
       t.start();
       //t.setDelay(1);
       //repaint();
       
   } 
    
    public void actionPerformed(ActionEvent event) 
    {

       	Object obj = event.getSource();
       	String choice = event.getActionCommand();
    
       	if (obj == playerShip){
       		count = count - 10;
                if(speed==0){
                playerShip.setLocation(playerShip.getX(), playerShip.getY() - thrusters);
                }
       		
       	}
   

		if (obj == t)
		{
                    
                    if(playerShip.getY() < 0){
                    atmospheretest.GravityTest.game.inState = 3;
			atmospheretest.GravityTest.game.createScreen();
                        atmospheretest.GravityTest.game.repaint();
                    }
                    
                    
			if(playerShip.getY() < 240){
		 playerShip.moveButton(speed);
			
		 playerShip.setText("Speed = "+speed);
			 count++;
			 speed = (count/3) + 1;
			} else{
				count =  0;
				 speed = 0;//(count/3) + 1;
				playerShip.setText("Fire Thrusters");
                               
				
		 }
		 /*
                 b2.moveButton();
                 b3.moveButton();
                 b4.moveButton();
                 b5.moveButton();
                 b6.moveButton();
                 */
		}
    
    }

    @Override
    public void keyTyped(KeyEvent e) {
        int k = e.getKeyCode();
		if(k == e.VK_UP){
			//count = count - 10;
		}
                if(k == e.VK_DOWN){
			//b1.setLocation(playerShip.getX(), playerShip.getY() - thrusters);
		}
                if(k == e.VK_LEFT){
		//b1.moveLeft(10);
                   //atmospheretest.GravityTest.screen.changeScreens();
		}
		if(k == e.VK_RIGHT){
		playerShip.moveRight(10);	//atmospheretest.GravityTest.screen.changeScreens();
		}
    }

    @Override
    public void keyPressed(KeyEvent e) {
                int k = e.getKeyCode();
		if(k == e.VK_UP){
                    if (count > (0 - thrusters)){
			count = count - 10;
                    }
		}
                if(k == e.VK_DOWN){
			playerShip.setLocation(playerShip.getX(), playerShip.getY() - (thrusters * 2));
		}
                if(k == e.VK_LEFT){
		//atmospheretest.GravityTest.screen.skyPanel.setVisible(false);
                //atmospheretest.GravityTest.screen.landPanel.setVisible(true);//
                  //atmospheretest.GravityTest.screen.add(atmospheretest.GravityTest.screen.landPanel);
                //atmospheretest.GravityTest.screen.changeScreens();//
                //atmospheretest.GravityTest.screen.repaint();
                   playerShip.moveLeft(10);
		}
		if(k == e.VK_RIGHT){
			playerShip.moveRight(10);
		}
                if(k == e.VK_E){
                        atmospheretest.GravityTest.game.inState = 1;
                        atmospheretest.GravityTest.game.fromSpace = false;
			atmospheretest.GravityTest.game.createScreen();
                        atmospheretest.GravityTest.game.repaint();
                        
		}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
   
    

