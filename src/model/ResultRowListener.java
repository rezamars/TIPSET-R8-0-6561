/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import Grafik.Center;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import tipset.Controller;

/**
 *
 * @author Reza
 */
public class ResultRowListener {
    
    
    private Center center;
    private Label[] result1X2Array;
    
    private Image image1;
    private String image1Path = "1.jpg";
    private Image imageX;
    private String imageXPath = "x.jpg";
    private Image image2;
    private String image2Path = "2.jpg";
    private Image imageBlank;
    private String imageBlankPath = "blank.jpg";
    private ImageView[] imageViewArray;
    
    private int resultLabellIndex = -1;
    private boolean[] resultFlagArray = new boolean[39];
    
    private int selectedRowNumber = -1;
    private String strArrayTypeOfImage = "";
    private String[] strArray = new String[39];
    private int[] disableIndexes = new int[2];
    
    private boolean result13Flag;
    private int checkedResults = 0;
    
    private String[] result13Array;
    private int rowIndex = -1;
    private int numberOfResChecked = 0;
    
    private MGListener MGListener;
    
    
    public ResultRowListener(Label[] resultArray, Center center1, MGListener MGListener1, boolean flag13){
        
        this.result1X2Array = resultArray;
        this.center = center1;
        this.imageViewArray = center1.getImageViewArray();
        //this.result13Flag = center1.getResult13Flag();
        this.result13Array = center1.getResult13Array();
        this.MGListener = MGListener1;
        this.result13Flag = flag13;
        
        for (int a = 0 ; a < resultFlagArray.length ; a++){
            resultFlagArray[a] = false;
        }
        
        loadLabelImages();
        
        disableIndexes[0] = -1;
        disableIndexes[1] = -1;
        
        for ( int s = 0 ; s < strArray.length ; s++){
            strArray[s] = "";
        }
        
    }
    
    
    public void addResultLabelListener(){
	        
        for(int x = 0 ; x<result1X2Array.length ; x++){
                
	        result1X2Array[x].setOnMouseClicked(event -> {
                    
                    for(int loopIndex = 0 ; loopIndex <result1X2Array.length ; loopIndex+=3){
                        
                        if(event.getSource() == result1X2Array[loopIndex]){
                            resultLabellIndex = loopIndex;
                            strArrayTypeOfImage = "1";
                            strArray[resultLabellIndex] = strArrayTypeOfImage;
                            strArray[resultLabellIndex + 1] = "";
                            strArray[resultLabellIndex + 2] = "";
                        }
                        else if(event.getSource() == result1X2Array[loopIndex+1]){
                            resultLabellIndex = loopIndex + 1 ;
                            strArrayTypeOfImage = "X";
                            strArray[resultLabellIndex] = strArrayTypeOfImage;
                            strArray[resultLabellIndex - 1] = "";
                            strArray[resultLabellIndex + 1] = "";
                        }
                        else if(event.getSource() == result1X2Array[loopIndex+2]){
                            resultLabellIndex = loopIndex + 2 ;
                            strArrayTypeOfImage = "2";
                            strArray[resultLabellIndex] = strArrayTypeOfImage;
                            strArray[resultLabellIndex - 1] = "";
                            strArray[resultLabellIndex - 2] = "";
                        }
                    }
                    
                   
                    
                    //System.out.println("Click på nr: " + resultLabellIndex);
                    ResultLabelFlagSetter();
                    updateLabelImage();
                    
                });
        }
    }      
    
    
    public void loadLabelImages(){
        
        try {
            
            image1 = new Image(image1Path);
            imageX = new Image(imageXPath);
            image2 = new Image(image2Path);
            imageBlank = new Image(imageBlankPath);
        }
        catch(Exception e) {
            System.out.println("Gick ej att ladda bild!");
            //System.exit(0);
            return;
        }
        
    }
    
    public void ResultLabelFlagSetter(){
        
        if (resultFlagArray[resultLabellIndex] == false){
            resultFlagArray[resultLabellIndex] = true;
                //System.out.println("ResultArray!: " + resultLabellIndex + ", now true!");
                numberOfResChecked++;
            }
        else if(resultFlagArray[resultLabellIndex] == true){
            resultFlagArray[resultLabellIndex] = false;
            //System.out.println("ResultArray!: " + resultLabellIndex + ", now false");
            numberOfResChecked--;
        }
        
    }
    
      public void updateLabelImage(){
        
        if (resultFlagArray[resultLabellIndex] == false){
              
            if(strArrayTypeOfImage == "1"){
                disableIndexes[0] = resultLabellIndex + 1;
                disableIndexes[1] = resultLabellIndex + 2;
            }
            else if(strArrayTypeOfImage == "X"){
                disableIndexes[0] = resultLabellIndex - 1;
                disableIndexes[1] = resultLabellIndex + 1;
            }
            else if(strArrayTypeOfImage == "2"){
                disableIndexes[0] = resultLabellIndex - 1;
                disableIndexes[1] = resultLabellIndex - 2;
            }
            else{
                
            }
            
            imageViewArray[resultLabellIndex].setImage(imageBlank);
            result1X2Array[resultLabellIndex].setGraphic(imageViewArray[resultLabellIndex]);    
            
            result1X2Array[disableIndexes[0]].setDisable(false);
            result1X2Array[disableIndexes[1]].setDisable(false);
            
            checkedResults--;
            this.result13Flag  = false;
        }
        else if (resultFlagArray[resultLabellIndex] == true){
            
            if(strArrayTypeOfImage == "1"){
                imageViewArray[resultLabellIndex].setImage(image1);
                result1X2Array[resultLabellIndex].setGraphic(imageViewArray[resultLabellIndex]);
                disableIndexes[0] = resultLabellIndex + 1;
                disableIndexes[1] = resultLabellIndex + 2;
                
            }
            else if(strArrayTypeOfImage == "X"){
                imageViewArray[resultLabellIndex].setImage(imageX);
                result1X2Array[resultLabellIndex].setGraphic(imageViewArray[resultLabellIndex]);
                disableIndexes[0] = resultLabellIndex - 1;
                disableIndexes[1] = resultLabellIndex + 1;
            }
            else if(strArrayTypeOfImage == "2"){
                imageViewArray[resultLabellIndex].setImage(image2);
                result1X2Array[resultLabellIndex].setGraphic(imageViewArray[resultLabellIndex]);
                disableIndexes[0] = resultLabellIndex - 1;
                disableIndexes[1] = resultLabellIndex - 2;
            }
            else{
                
            }
            
            result1X2Array[disableIndexes[0]].setDisable(true);
            result1X2Array[disableIndexes[1]].setDisable(true);
            checkedResults++;   
            
            //System.out.println("Row: " + rowIndex + ", Type: " + strArrayTypeOfImage );
            
            if(checkedResults == 13){
                System.out.println("Number of checked: " + checkedResults);
                result13Flag = true;
                System.out.println("In rrli,result13flag= " + result13Flag);
                countRowNumber();
                //this.result13Flag = true;
            }
            else{
                //result13Flag = false;
                //this.result13Flag  = false;
            }
            //this.MGListener.updateEnableCountCButton();
            System.out.println("NUmber of checked: " + checkedResults);
        }
            
        this.MGListener.updateEnableCountCButton(result13Flag);
    }
      
      public void countRowNumber(){
          
          int rowCounter = -1;
          
          
          for ( int i = 0 ; i < resultFlagArray.length ; i+=3){
              rowCounter ++;
              if (resultFlagArray[i] == true ){
                  result13Array[rowCounter] = "1"; 
              }
              else if (resultFlagArray[i+1] == true ) {
                  result13Array[rowCounter] = "X"; 
              }
              else if (resultFlagArray[i+2] = true){
                  result13Array[rowCounter] = "2"; 
              }
              else{
                  result13Array[rowCounter] = "Ö";
              }
          }
          
          //System.out.println("Result:");
          
          for(int y = 0 ; y < result13Array.length ; y++){
              //System.out.println("Row: " + y + ", sign: " + result13Array[y] );
          }
          
         
      }
    
      public boolean[] getResultFlags(){
          
          return this.resultFlagArray;
          
      }
      
      public void resetChosenResults(){
        
        for(int p = 0 ; p < resultFlagArray.length ; p++){
            resultFlagArray[p] = false;
        }
        
        for(int w = 0 ; w < strArray.length ; w++){
            imageViewArray[w].setImage(imageBlank);
            result1X2Array[w].setGraphic(imageViewArray[w]);
            result1X2Array[w].setDisable(false);
        }
        
        for(int q = 0 ; q < result13Array.length ; q++){
            result13Array[q] = "";
        }
        
        checkedResults = 0;
        result13Flag = false;
        this.MGListener.updateEnableCountCButton(result13Flag);
    }
      
}
