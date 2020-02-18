/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Grafik.Right;
import javafx.scene.control.Button;

/**
 *
 * @author Reza
 */
public class CountButtonListener {
    
    private Right right;
    private Button countButton;
    private ResultCounter resultCounter;
    private boolean flagOf5MGs;
    
    
    public CountButtonListener(Right right1, ResultCounter resultCounter1){
        
        this.right = right1;
        this.countButton = right.getCountButton();
        this.resultCounter = resultCounter1;
        
    }
    
    public void addCountButtonListener(){
        
        /*
        countButton.setOnMouseClicked(event -> {
            resultCounter.startResultCounter();         
        });
        */
        countButton.setOnAction(e -> {
            resultCounter.startResultCounter();
        });
            
    }
    
}
