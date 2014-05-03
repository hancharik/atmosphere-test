/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atmospheretest;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Mark
 */
public class GroundJPanel extends JPanel implements ActionListener, KeyListener{

    
    JPanel ground;// = new JPanel();
    Timer t;
    int delay = 1;
    int buildingNumber = 0;
    PlayerJButton player;// = new PlayerJButton(20);
    PlayerJButton newBuilding;
    PlayerJButton ship;
    int count;
    int speed;
    JLabel counter = new JLabel();
    int gravity = 40; //20 is highest gravity, 200 is lowest, 40 is good gameplay
    int thrusters = 5;//40 is good, 20 is good gameplay
    ArrayList<PlayerJButton> buildings = new ArrayList<PlayerJButton>();
    
    /*  PlayerJButton b2 = new PlayerJButton();
    PlayerJButton b3 = new PlayerJButton();
    PlayerJButton b4 = new PlayerJButton();
    PlayerJButton b5 = new PlayerJButton();
    PlayerJButton b6 = new PlayerJButton();
    */
    
   public GroundJPanel(){
       
       super();
       player = new PlayerJButton(20);
       //ship = new PlayerJButton(40);
       //ground = new JPanel();
       count = 0;
       speed = 10;
       setLayout(null);
       setBackground(Color.green);
       
       //counter.setText("hello");
       //counter.setLocation(200, 200);
       //ship.setBackground(Color.white);
       //ship.setText("S");
       //ship.setLocation(0,0);
       player.setLocation(300, 100);
      //add(ship);
       add(player);
       //add(ship);
       /*
       add(b2);
       add(b3);
       add(b4);
       add(b5);
       add(b6);
       
       
       newBuilding = new PlayerJButton(40);
                        buildings.add(newBuilding);
                        buildingNumber++;
                        newBuilding.xCord = player.xCord;
                        newBuilding.yCord = player.yCord;
			add(newBuilding);
       
       */
       
       //ground.setBackground(Color.blue);
       player.addActionListener(this);
       player.addKeyListener(this);
       player.requestFocusInWindow();
       t = new Timer(gravity, this);
       t.start();
       //t.setDelay(1);
       //this.add(ground);
       repaint();
       this.requestFocusInWindow();
       
   } 
    
   
   public void createBuilding(){
                        newBuilding = new PlayerJButton(40);
                        //buildings.get(buildingNumber).add(newBuilding);
                        buildingNumber++;
                        newBuilding.setBounds(player.getX() - 10, player.getY() - 10, 40, 40);
                        
			atmospheretest.GravityTest.game.landPanel.buildings.add(newBuilding);
                        atmospheretest.GravityTest.game.landPanel.add(newBuilding);
                        atmospheretest.GravityTest.game.landPanel.setVisible(true);
                        repaint();
   }
   
      public void createShip(){
                        ship = new PlayerJButton(40);
                        //buildings.get(buildingNumber).add(newBuilding);
                        buildingNumber++;
                        ship.setBounds(10, 10, 40, 40);
                        ship.setBackground(Color.white);
                        
			
                        atmospheretest.GravityTest.game.landPanel.add(ship);
                        atmospheretest.GravityTest.game.landPanel.setVisible(true);
                        repaint();
   }
   
   
   
   
    public void actionPerformed(ActionEvent event) 
    {

       	Object obj = event.getSource();
       	String choice = event.getActionCommand();
    
       	if (obj == player){
       		
       		
       	}
   

		if (obj == t)
		{
                    for(int i = 0; i < buildings.lastIndexOf(buildings); i++ ){
                        
                    }
		 /*	if(player.getY() < 240){
		 player.moveButton(speed);
			
		 player.setText("Speed = "+speed);
			 count++;
			 speed = (count/3) + 1;
			} else{
				count =  0;
				 speed = 0;//(count/3) + 1;
				player.setText("Fire Thrusters");
                               
				
		 }
		
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
			//b1.setLocation(player.getX(), player.getY() - thrusters);
		}
    }

    @Override
    public void keyPressed(KeyEvent e) {
               int k = e.getKeyCode();
		if(k == e.VK_UP){
                        if(player.getY() > 8){
			player.moveUp(speed);
                        }
		}
		if(k == e.VK_DOWN){
                        if(player.getY() < 240){
			player.moveDown(speed);
                        }
			
		}
		if(k == e.VK_LEFT){
                    /*
		atmospheretest.GravityTest.screen.landPanel.setVisible(false);
                atmospheretest.GravityTest.screen.landPanel.setVisible(false);// atmospheretest.GravityTest.screen.skyPanel.setVisible(true);
                atmospheretest.GravityTest.screen.add(atmospheretest.GravityTest.screen.skyPanel);
                atmospheretest.GravityTest.screen.repaint();
                atmospheretest.GravityTest.screen.skyPanel.player.requestFocusInWindow();
                * */
                    if(player.getX() > 8){
			player.moveLeft(speed);
                        }
                    
		}
		if(k == e.VK_RIGHT){
                        if(player.getX() < 480){
			player.moveRight(speed);
                        }
			
		}
                if(k == e.VK_B){
                    player.setBackground(Color.black);
                   this.createBuilding();
		}
                if(k == e.VK_S){
                    player.setBackground(Color.yellow);
                   this.createShip();
		}
                if(k == e.VK_E){
                        atmospheretest.GravityTest.game.inState = 2;
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
   
    
