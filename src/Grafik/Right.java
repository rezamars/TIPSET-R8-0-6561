/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/**
 *
 * @author Reza
 */
public class Right extends VBox{
    
    
    
    public Right(){
        
       
        this.setAlignment(Pos.TOP_LEFT);
        
        this.setPadding(new Insets(10, 10, 10, 100));  
        this.setSpacing(1);
        
        
        Label ll = new Label();
        ll.setText("Test!");
        
        this.getChildren().add(ll);
            
    }
    
}
