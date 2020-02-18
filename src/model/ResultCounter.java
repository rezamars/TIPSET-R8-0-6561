/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Grafik.Center;
import Grafik.Left;
import Grafik.Right;
import javafx.scene.control.Label;

/**
 *
 * @author Reza
 */
public class ResultCounter {
    
    private int[] chosenMGIndexes;
    private String[] result13Array;
    private String[][] R8_0_27_Tables;
    private boolean flagOf5MGs;
    
    
    public ResultCounter(Left left1, Center center1, Right right1){
        
        this.chosenMGIndexes = left1.getChosenMGIndexes();
        this.result13Array = center1.getResult13Array();
        this.R8_0_27_Tables = right1.getSystemTables();
        this.flagOf5MGs = left1.get5MGsFlag();
    }
    
    public void startResultCounter(){
        
        
        
        for(int x = 0 ; x < 5; x++){
            System.out.println("chosen index = " + chosenMGIndexes[x]);
        }
        
    }
    
}
