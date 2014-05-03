/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atmospheretest;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Mark
 */
public class GameJFrame extends JFrame{
    
    public GameJPanel gamePanel;// = new GameJPanel();
    
    
    public GameJFrame(){
        super ("Gravity Test");
                getContentPane().setLayout(new BorderLayout());
                gamePanel = new GameJPanel();
                //getContentPane().add(gamePanel,"Center");
                 gamePanel.createScreen();                                                                   //landPanel.setVisible(false);
		//getContentPane().add(skyPanel,"Center");
                setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize (520, 300);
		setVisible(true);
    }
    
}
