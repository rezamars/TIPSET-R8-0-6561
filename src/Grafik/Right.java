/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import javafx.stage.Screen;
import model.ReadFile;

/**
 *
 * @author Reza
 */
public class Right extends VBox{
    
    public ReadFile readFile;
    private String[][] R8_0_27_Tables = new String[27][8];
    private Button countButton = new Button("Räkna antal rätt");
    
    private HBox spaceHbox1 = new HBox();
    private HBox spaceHbox2 = new HBox();
    private Label numberOfRightsLabel = new Label();
    
    public Right(){
        
        readFile = new ReadFile(this);
        
        this.setAlignment(Pos.TOP_CENTER);
        
        this.setPadding(new Insets(10, 10, 50, 100));  
        this.setSpacing(1);
        
        for (int x = 0 ; x < 27 ; x++){
            for (int y = 0 ; y < 8 ; y++){
                R8_0_27_Tables[x][y] = "";
            }
        }
        
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double width = primaryScreenBounds.getWidth();
        //System.out.println("Width= " + width);
        
        spaceHbox1.setPadding(new Insets(10, 10, 100, (width/8)));
        this.getChildren().add(spaceHbox1);
        
        spaceHbox2.setPadding(new Insets(10, 10, 10, (width/8)));
        
        Font labelFont ;
        labelFont = Font.font("Arial", FontWeight.BOLD, 20);
        
        numberOfRightsLabel.setFont(labelFont);
        numberOfRightsLabel.setText("");
        numberOfRightsLabel.setTextAlignment(TextAlignment.CENTER);
        numberOfRightsLabel.setWrapText(true);
        
        BackgroundFill background_fill = new BackgroundFill(Color.YELLOW,  CornerRadii.EMPTY, Insets.EMPTY); 
        Background background = new Background(background_fill);
        numberOfRightsLabel.setBackground(background);
        
        numberOfRightsLabel.setStyle("-fx-text-fill: red;");
        numberOfRightsLabel.setStyle("-fx-border-color: black;");
        
        countButton.setDisable(true);
        
        this.getChildren().add(countButton);
        this.getChildren().add(spaceHbox2);
        this.getChildren().add(numberOfRightsLabel);
           
        ReadTables();
    }
    
    
    public void ReadTables(){
        
        R8_0_27_Tables = readFile.readFileFromTextFile();
                
    }
    
    public String[][] getSystemTables(){
        return R8_0_27_Tables;
    }
   
    public Button getCountButton(){
        return this.countButton;
    }
    
}
