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
    
    public MGListener(Label[] MGA, Left left){
        
        for (int a = 0 ; a < mgFlagArray.length ; a++){
            mgFlagArray[a] = false;
        }
        
        this.MGArray = MGA;
        this.left = left;
        this.imageViewArray = left.getImageViewArray();
        this.imageView1 = left.getImageView1();
        this.imageView2 = left.getImageView2();
                
        
        /*
        imageView1.setFitHeight(30);
        imageView1.setFitWidth(30);
        
        imageView2.setFitHeight(30);
        imageView2.setFitWidth(30);
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
                        if (mgFlagArray[MGIndex] == false){
                            mgFlagArray[MGIndex] = true;
                            System.out.println("MGArray!: " + MGIndex + ", now true!");
                        }
                        else if(mgFlagArray[MGIndex] == true){
                            mgFlagArray[MGIndex] = false;
                            System.out.println("MGArray!: " + MGIndex + ", now false");
                        }
                        updateLabelImage(MGIndex);
                    }
                    if(event.getSource()== MGArray[1]){
                        MGIndex = 1;
                        System.out.println("MGArray!: " + MGIndex );
                    }
                    
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

    public void updateLabelImage(int labelIndex){
        
        if (mgFlagArray[labelIndex] == false){
            MGArray[labelIndex].setGraphic(imageView1);
        }
        else if (mgFlagArray[labelIndex] == true){
            MGArray[labelIndex].setGraphic(imageView2);
        }
                        
        
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("ae");
        
    }

}
