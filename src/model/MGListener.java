/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Grafik.Left;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import tipset.Controller;

/**
 *
 * @author Reza
 */
public class MGListener implements ActionListener   {

    private Label[] MGArray ;
    private  int index = 0;
    private final String[] stringArray = new String[13];
    private Left left;
    private ImageView[] imageViewArray;
    private int MGIndex = -1;
    private boolean[] mgFlagArray = new boolean[13];
    
    private Image MGimage1;
    private String MGimage1Path = "MG-ej-klickad.jpg";
    private Image MGimage2;
    private String MGimage2Path = "MG-klickad.jpg";
    private ImageView imageView1;
    private ImageView imageView2;
    
    private int numberOfMGs = 0;
    private int[] chosenMGIndexes = new int[5];
    
    
    public MGListener(Label[] MGA, Left left){
        
        for (int a = 0 ; a < mgFlagArray.length ; a++){
            mgFlagArray[a] = false;
        }
        
        this.MGArray = MGA;
        this.left = left;
        this.imageViewArray = left.getImageViewArray();
        this.imageView1 = left.getImageView1();
        this.imageView2 = left.getImageView2();
        this.imageViewArray = left.getImageViewArray();
        
        /*
        for (int i = 0 ; i < MGchosenIndexes.length ; i++){
            MGchosenIndexes[i] = -1;
        }
        */
        
        loadLabelImage();
        
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
                    //System.out.println(event.getSource());
                    //stringArray[x] = event.getSource().toString();
                    
                    if(event.getSource()== MGArray[0]){
                        MGIndex = 0;
                    }
                    else if(event.getSource()== MGArray[1]){
                        MGIndex = 1;
                    }
                    else if(event.getSource()== MGArray[2]){
                        MGIndex = 2;
                    }
                    else if(event.getSource()== MGArray[3]){
                        MGIndex = 3;
                    }
                    else if(event.getSource()== MGArray[4]){
                        MGIndex = 4;
                    }
                    else if(event.getSource()== MGArray[5]){
                        MGIndex = 5;
                    }
                    else if(event.getSource()== MGArray[6]){
                        MGIndex = 6;
                    }
                    else if(event.getSource()== MGArray[7]){
                        MGIndex = 7;
                    }
                    else if(event.getSource()== MGArray[8]){
                        MGIndex = 8;
                    }
                    else if(event.getSource()== MGArray[9]){
                        MGIndex = 9;
                    }
                    else if(event.getSource()== MGArray[10]){
                        MGIndex = 10;
                    }
                    else if(event.getSource()== MGArray[11]){
                        MGIndex = 11;
                    }
                    else if(event.getSource()== MGArray[12]){
                        MGIndex = 12;
                    }
                    else{
                        System.exit(0);
                    }
                    
                    MGLabelFlagSetter();
                    updateLabelImage();
                    //System.out.println("MGArray!: " + MGIndex );
                    
                });
        }
    }       
    
    public void loadLabelImage(){
        
        try {
            
            MGimage1 = new Image(MGimage1Path);
            MGimage2 = new Image(MGimage2Path);
        }
        catch(Exception e) {
            System.out.println("Gick ej att ladda MG-bild!");
            //System.exit(0);
            return;
        }
        
    }

    public void MGLabelFlagSetter(){
        
        if (mgFlagArray[MGIndex] == false){
            mgFlagArray[MGIndex] = true;
                System.out.println("MGArray!: " + MGIndex + ", now true!");
            }
        else if(mgFlagArray[MGIndex] == true){
            mgFlagArray[MGIndex] = false;
            System.out.println("MGArray!: " + MGIndex + ", now false");
        }
        
    }
    
    public void updateLabelImage(){
        
       
        
        
        
        if (mgFlagArray[MGIndex] == false){
                
            if (numberOfMGs == 5){
                for (int y = 0; y < MGArray.length ; y++){
                    if (mgFlagArray[y] != true){
                        MGArray[y].setDisable(false);
                    }
                    else {
                        MGArray[y].setDisable(false);
                    }
                }
            }
                
            imageViewArray[MGIndex].setImage(MGimage1);
            MGArray[MGIndex].setGraphic(imageViewArray[MGIndex]);
                /*
                for (int x = 0 ; x < MGchosenIndexes.length ; x++){
                    if (MGchosenIndexes[x] == MGIndex){
                        MGchosenIndexes[x] = -1;
                    }
                }
                */
            if (numberOfMGs > 0){
                numberOfMGs--;
            }
                
            
        }
        else if (mgFlagArray[MGIndex] == true){
                
            imageViewArray[MGIndex].setImage(MGimage2);
            MGArray[MGIndex].setGraphic(imageViewArray[MGIndex]);
            //MGchosenIndexes[numberOfMGs] = MGIndex;
            numberOfMGs++;
        }
            
        
        
        /*for (int x = 0 ; x < MGchosenIndexes.length ; x++){
            for (int q = 0 ; q < mgFlagArray.length ; q++){
                if (mgFlagArray[q] == true){
                    MGchosenIndexes[x] = q;
                }
                else {
                    
                }
            }
        }*/
              
        if (numberOfMGs > 4){
            System.out.println("5+++++ " );
            for (int y = 0; y < MGArray.length ; y++){
                if (mgFlagArray[y] != true){
                    MGArray[y].setDisable(true);
                }
                else {
                    MGArray[y].setDisable(false);
                }
            }
        }
        
         
        int iter = 0;
        
        if (numberOfMGs == 5){
            for (int y = 0; y < mgFlagArray.length ; y++){
            if (mgFlagArray[y] == true){
                chosenMGIndexes[iter] = y;
                iter++;
            }
        }
        }
        
        
        
        
        System.out.println("number of MGs: " + numberOfMGs);
        
        System.out.println("Selected Indexes: " + chosenMGIndexes[0] + "," + chosenMGIndexes[1] + "," + chosenMGIndexes[2] + 
                "," + chosenMGIndexes[3] + "," + chosenMGIndexes[4]);
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("ae");
        
    }
    
    
}
