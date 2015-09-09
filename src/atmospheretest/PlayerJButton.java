/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package atmospheretest;





import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


public class PlayerJButton extends JButton{
    
    Random randomNumber = new Random();
    int side = 20; //+ randomNumber.nextInt( 100 );
    boolean goingDown = true;
    boolean goingRight = true;
    int xCord = 240;//1 + randomNumber.nextInt( 470 );
    int yCord = 20; // + randomNumber.nextInt( 470 );
    int bounds = side;
    int speed;
    
   public PlayerJButton(int size){
       
       super();
       this.side = size;
       this.setText(null);
       setBounds(new Rectangle(xCord,yCord,side,side));
       
               int r1 = 1 + randomNumber.nextInt( 255 );
               int r2 = 1 + randomNumber.nextInt( 255 );
               int r3 = 1 + randomNumber.nextInt( 255 );
               setBackground(Color.getHSBColor((float)r1, (float)r2, (float)r3));
               
                int thisSpeed = 1 + randomNumber.nextInt( 10 );
                this.speed = thisSpeed;
               
               
               
               
       
   } 
    
   public void moveButton(int speed){
       
            int newX = this.getX();
            int newY = this.getY();
       /*
        * 
            if (this.getX()+ bounds > 640){
             goingDown = false;    
            }
            if (this.getY()+ bounds > 480){
             goingRight = false;    
            }
            if (this.getX() < 0){
             goingDown = true;    
            }
            if (this.getY()  < 0){
             goingRight = true;    
            }
            if(goingDown){
                newX = this.getX() + 5;
            }
              if(!goingDown){
               newX = this.getX() - 5;   
            }
              if(goingRight){
                newY = this.getY() + 5;
            }
              if(!goingRight){
               newY = this.getY() - 5;   
            }
            */if (this.getY() > 420){
                newY = 420;   
               }else{
            newY = this.getY() + speed;
               }
   setBounds(new Rectangle( newX, newY, side, side));
   
}
                    // 10 is a good max amount
      public void moveUp(int amount){
	   setBounds(new Rectangle( this.getX() , this.getY() - amount, side, side));
   }
   public void moveDown(int amount){
	   setBounds(new Rectangle( this.getX(), this.getY() + amount, side, side));
   }
   public void moveLeft(){
	   setBounds(new Rectangle( this.getX() - this.speed, this.getY(), side, side));
           if(this.getX()<0){
                       this.setLocation(500, this.getY());
                       this.repaint();
                   }
           //this.setLocation(this.getX() - amount, this.getY());
   }
   public void moveRight(int amount){
	   setBounds(new Rectangle( this.getX() + amount, this.getY(), side, side));
   }
   
   
   /*
        public void checkCollision(){
       
       for(int i = 0; i < mainpanel.app.main.screen.numberOfDestinations; i++){
       if (this.getBounds().intersects(mainpanel.app.main.screen.d1[i].getBounds())){
       this.setBackground(Color.red);
        }
      else if (!this.getBounds().intersects(mainpanel.app.main.screen.d1[i].getBounds())){
       this.setBackground(Color.yellow);
         }
       
       }
       
       if (this.getBounds().intersects(mainpanel.app.main.screen.b1.getBounds())){
       this.setBackground(Color.red);
       isHit = true;
       mainpanel.app.main.screen.score = mainpanel.app.main.screen.score - 50;
       mainpanel.app.main.screen.totalScore.setText("Score: "+mainpanel.app.main.screen.score);
        }
       if (!this.getBounds().intersects(mainpanel.app.main.screen.b1.getBounds())){
       this.setBackground(Color.yellow);
         }
               
   }
   
   * 
   * */
}                