/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atmospheretest;




import java.awt.*;
import javax.swing.*;


/**
 *
 * @author mah537
 */
public class GameJPanel extends JFrame{
    
    
    SolarSystemJPanel spacePanel = new SolarSystemJPanel(9);
    AtmosphereJPanel skyPanel = new AtmosphereJPanel();
    GroundJPanel landPanel = new GroundJPanel();
    int inState = 2;
    boolean fromSpace = false;
    
    
    public GameJPanel(){
		super ("Gravity Test");
                getContentPane().setLayout(new BorderLayout());
                //getContentPane().add(landPanel,"Center");
                 createScreen();                                                                   //landPanel.setVisible(false);
		//getContentPane().add(skyPanel,"Center");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (520, 300);
		setVisible(true);
        }
    
    public void createScreen(){
      //this.setContentPane(null); 
        if(inState==1){
            getContentPane().remove(skyPanel);
            getContentPane().add(landPanel,"Center");
            setVisible(true);
            landPanel.player.requestFocusInWindow();
        } else if(inState==2){
            //if(getContentPane().equals(spacePanel)){
                
           // }
            getContentPane().remove(landPanel);
            getContentPane().remove(spacePanel);
            getContentPane().add(skyPanel,"Center");
            repaint();
            setVisible(true);
            
            if(fromSpace){
                skyPanel.playerShip.setBounds(240, 20, 20, 20);
            }
            skyPanel.playerShip.requestFocusInWindow();
        } else if(inState==3){
           getContentPane().remove(skyPanel);
           getContentPane().add(spacePanel,"Center"); 
           setVisible(true);
           spacePanel.playerShip.requestFocusInWindow();
                }
    
        }
}