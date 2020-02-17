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
import model.ReadFile;

/**
 *
 * @author Reza
 */
public class Right extends VBox{
    
    public ReadFile readFile;
    private String[][] R8_0_27_Tables = new String[27][8];
    
    
    public Right(){
        
        readFile = new ReadFile(this);
        
        this.setAlignment(Pos.TOP_LEFT);
        
        this.setPadding(new Insets(10, 10, 10, 100));  
        this.setSpacing(1);
        
        for (int x = 0 ; x < 27 ; x++){
            for (int y = 0 ; y < 8 ; y++){
                R8_0_27_Tables[x][y] = "";
            }
        }
        
        
        Label ll = new Label();
        ll.setText("Test!");
        
        this.getChildren().add(ll);
           
        ReadTables();
    }
    
    
    public void ReadTables(){
        
        R8_0_27_Tables = readFile.readFileFromTextFile();
                
    }
    
    public String[][] getSystemTables(){
        return R8_0_27_Tables;
    }
    
}
