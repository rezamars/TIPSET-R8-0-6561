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
    
    
    public ResultRowListener(Label[] resultArray, Center center1){
        
        this.result1X2Array = resultArray;
        this.center = center1;
        this.imageViewArray = center.getImageViewArray();
        this.result13Flag = center.getResult13FClag();
        this.result13Array = center1.getResult13Array();
        
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
            }
        else if(resultFlagArray[resultLabellIndex] == true){
            resultFlagArray[resultLabellIndex] = false;
            //System.out.println("ResultArray!: " + resultLabellIndex + ", now false");
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
            
            if(checkedResults >= 13){
                System.out.println("Number of checked: " + checkedResults);
                result13Flag = true;
                countRowNumber();
            }
            else{
                result13Flag = false;
            }
           
        }
            
        
    }
      
      public void countRowNumber(){
          
          int rowCounter = -1;
          
          /*
          for ( int i = 0 ; i < 39 ; i+=3){
              rowCounter ++;
              if (strArray[i].equals("1") ){
                  result13Array[rowCounter] = "1"; 
              }
              else if (strArray[i+1].equalsIgnoreCase("X") ){
                  result13Array[rowCounter] = "X"; 
              }
              else if (strArray[i+2].equals("2")){
                  result13Array[rowCounter] = "2"; 
              }
              else if (strArray[i].equals("")){
                  result13Array[rowCounter] = "tomt"; 
              }
              else{
                  result13Array[rowCounter] = "Ö";
              }
          }
          */
          
          rowCounter = -1;
          
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
          
          System.out.println("Result:");
          
          for(int y = 0 ; y < result13Array.length ; y++){
              System.out.println("Row: " + y + ", sign: " + result13Array[y] );
          }
          
          /*
          for(int y = 0 ; y < resultFlagArray.length ; y++){
              if (resultFlagArray[y] == true){
                  System.out.println("FlagTrue-index: " + y  );
              }
          }
          */
          
      }
    
}
