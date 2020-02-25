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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tipset.Controller;

/**
 *
 * @author Reza
 */
public class MGListener    {

    private Label[] MGArray ;
    private  int index = 0;
    private Left left;
    private Center center;
    private Right right;
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
    private int[] chosenMGIndexes;
    
    private boolean flagOf5MGs;
    private boolean result13Flag;
    
    
    public MGListener(Label[] MGA, Left left1, Center center1, Right right1, boolean flag13){
        
        for (int a = 0 ; a < mgFlagArray.length ; a++){
            mgFlagArray[a] = false;
        }
        
        this.MGArray = MGA;
        this.left = left1;
        this.center = center1;
        this.right = right1;
        this.imageViewArray = left1.getImageViewArray();
        this.imageView1 = left1.getImageView1();
        this.imageView2 = left1.getImageView2();
        this.imageViewArray = left1.getImageViewArray();
        this.flagOf5MGs = left1.get5MGsFlag();
        this.chosenMGIndexes = left1.getChosenMGIndexes();
        this.result13Flag = flag13;
        
        
        loadLabelImage();
        
    }
    
    
    
    public void addMGLabelListener(){
	        
        for(int x = 0 ; x<MGArray.length ; x++){
                
	        MGArray[x].setOnMouseClicked(event -> {
                    
                    for (int index = 0 ; index < MGArray.length ; index++){
                        if(event.getSource()== MGArray[index]){
                        MGIndex = index;
                        }
                        else{
                            //System.exit(0);
                        }
                   }
                    
                    MGLabelFlagSetter();
                    updateLabelImage();
                    updateEnableCountCButton(this.result13Flag);
                    
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
                //System.out.println("MGArray!: " + MGIndex + ", now true!");
            }
        else if(mgFlagArray[MGIndex] == true){
            mgFlagArray[MGIndex] = false;
            //System.out.println("MGArray!: " + MGIndex + ", now false");
        }
        
    }
    
    public void updateLabelImage(){
        
        if(MGIndex != -1){
            
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
                
            if (numberOfMGs > 0){
                numberOfMGs--;
            }
                
            
            }
            else if (mgFlagArray[MGIndex] == true){

                imageViewArray[MGIndex].setImage(MGimage2);
                MGArray[MGIndex].setGraphic(imageViewArray[MGIndex]);
                numberOfMGs++;
            }
            
        }
        
        
            
            
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
            flagOf5MGs = true;
            //System.out.println("flag of 5MGs: " + numberOfMGs);
            /*
            for(int x = 0 ; x < chosenMGIndexes.length ; x++){
                System.out.println("chosen index = " + chosenMGIndexes[x]);
            }
            */
            //updateEnableCountCButton();
        }
        else{
            flagOf5MGs = false;
            //System.out.println("number of MGs: " + numberOfMGs);
        }
        
    }

    public void updateEnableCountCButton(boolean flag13){
        
        this.result13Flag = flag13;
        System.out.println("in update enable, result13flag= " + this.result13Flag);
        if ((flagOf5MGs == true) && (this.result13Flag == true)){
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            right.getCountButton().setDisable(false);
        }
        else{
            right.getCountButton().setDisable(true);
        }
        
    }
    
    public boolean[] getMgFlagArray(){
        return this.mgFlagArray;
    }
 
    public void resetMGs(){
        
        for(int p = 0 ; p < mgFlagArray.length ; p++){
            mgFlagArray[p] = false;
        }
        
        for(int w = 0 ; w < MGArray.length ; w++){
            imageViewArray[w].setImage(MGimage1);
            MGArray[w].setGraphic(imageViewArray[w]);
            MGArray[w].setDisable(false);
        }
        
        for(int q = 0 ; q < chosenMGIndexes.length ; q++){
            chosenMGIndexes[q] = -1;
        }
        
        numberOfMGs = 0;
    }
    
}
