/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Reza
 */
public class MGListener implements ActionListener{

    private Label[] MGArray ;
    private  int index = 0;
    private final String[] stringArray = new String[13];
    
    public MGListener(Label[] MGA){
        
        this.MGArray = MGA;
        
    }
    
    
    /*
    public void addMGLabelListener(){
	        
        for(int x = 0 ; x<MGArray.length ; x++){
	        //MGArray[x].addEventHandler(EventType.ROOT);
                MGArray[x].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                        public void handle(MouseEvent event) {
                            System.out.println("Klick!");
                            throw new UnsupportedOperationException("Exception throwed! Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            
                        }
                        
                }) ;
                
        }
	       
    }
    */
    
    public void addMGLabelListener(){
	        
       
        
        for(int x = 0 ; x<MGArray.length ; x++){
                
	        MGArray[x].setOnMouseClicked(event -> {
                    System.out.println(event.getSource());
                    //stringArray[x] = event.getSource().toString();
                    
            if (event.getClickCount() == 1) {
                
                    System.out.println("label click!: " + event.getSource() );
                
                
             /*
             if (labelFlag == false){
                 labelFlag = true;
                 MGArray[x].setGraphic(imageView2);
                 //System.out.println("Widt: " + ll.getWidth() + " Height: " + ll.getHeight());
             }
             else if (labelFlag == true){
                 labelFlag = false;
                 
                 MGArray[x].setGraphic(imageView1);
                 //System.out.println("Widt: " + ll.getWidth() + " Height: " + ll.getHeight());
             }
             */
            }
                }       
                );           }
    }       
    

    /*
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    
    
    
}
