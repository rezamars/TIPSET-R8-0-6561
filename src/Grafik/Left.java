/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckBoxTreeItem;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import static javafx.scene.paint.Color.color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Reza
 */
public class Left extends VBox{
    
    private Label headingLabel = new Label("Mitt system, (5 MG)");
    private Label[] rowNumberlabelArray = new Label[13];
    private Label[] MGArray = new Label[13];
    private ImageView[] imageViewArray = new ImageView[13];
    private Label[] label1X2Array = new Label[39];
    
    private Image MGimage1;
    private String MGimage1Path = "MG-ej-klickad.jpg";
    private Image MGimage2;
    private String MGimage2Path = "MG-klickad.jpg";
    
    
    private HBox spaceHbox = new HBox();
    private HBox[] hboxNumMGArray = new HBox[13];
    private HBox[] hbox1X2Array = new HBox[13];
    private HBox[] hboxLabelArray = new HBox[13];
    private boolean labelFlag = false;
    
    
    public Left(){
        
        //this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10, 10, 10, 100));  
        this.setSpacing(1);
        
        Font headingFont ;
        headingFont = Font.font("Arial", FontWeight.BOLD, 20);
        
        headingLabel.setFont(headingFont);
        headingLabel.setTextFill(Color.BLUE);
        
        this.getChildren().add(headingLabel);
        spaceHbox = new HBox();
        spaceHbox.setPadding(new Insets(10, 10, 10, 100));
        this.getChildren().add(spaceHbox);
        
        for(int z = 0 ; z < hboxLabelArray.length ; z++){
            hboxLabelArray[z] = new HBox();
            hboxLabelArray[z].setSpacing(25);
            hboxLabelArray[z].setFillHeight(true); 
            //hboxLabelArray[z].setPrefSize(200, 200);
            hboxLabelArray[z].autosize();
            hboxLabelArray[z].setAlignment(Pos.CENTER);

        }
       
        for(int z = 0 ; z < hboxNumMGArray.length ; z++){
            hboxNumMGArray[z] = new HBox();
            hboxNumMGArray[z].setSpacing(25);
            hboxNumMGArray[z].setFillHeight(true); 
            hboxNumMGArray[z].setPrefSize(50, 50);
            hboxNumMGArray[z].autosize();
            hboxNumMGArray[z].setAlignment(Pos.CENTER);

            hbox1X2Array[z] = new HBox();
            hbox1X2Array[z].setSpacing(3);
            hbox1X2Array[z].setFillHeight(true);          
            hbox1X2Array[z].setAlignment(Pos.CENTER);
        }
        
        Font labelFont ;
        labelFont = Font.font("Arial", FontWeight.BOLD, 20);
        
        for(int x = 0 ; x < rowNumberlabelArray.length ; x++){
            rowNumberlabelArray[x] = new Label();
            BackgroundFill background_fill = new BackgroundFill(Color.LIGHTYELLOW,  CornerRadii.EMPTY, Insets.EMPTY); 
            Background background = new Background(background_fill);
            rowNumberlabelArray[x].setBackground(background);
            
            if (x<9){
                rowNumberlabelArray[x].setText("   " + Integer.toString((x+1)) + " ");
            }
            else{
                rowNumberlabelArray[x].setText(" " + Integer.toString((x+1)) + " ");
            }
            
            rowNumberlabelArray[x].setFont(labelFont);
            rowNumberlabelArray[x].setAlignment(Pos.CENTER);
        }
        
        
        try {
            
            MGimage1 = new Image(MGimage1Path);
            MGimage2 = new Image(MGimage2Path);
        }
        catch(Exception e) {
            System.out.println("Gick ej att ladda MG-bild!");
            //System.exit(0);
            return;
        }
        
        
        ImageView imageView1 = new ImageView(MGimage1);
        imageView1.setFitHeight(30);
        imageView1.setFitWidth(30);
        ImageView imageView2 = new ImageView(MGimage2);
        imageView2.setFitHeight(30);
        imageView2.setFitWidth(30);
        
        for(int w = 0 ; w < MGArray.length ; w++){
            imageViewArray[w] = new ImageView(MGimage1);
            imageViewArray[w].setFitHeight(30);
            imageViewArray[w].setFitWidth(30);
            
            MGArray[w] = new Label();
            MGArray[w].setGraphic(imageViewArray[w]);
            
        }
        
        
        /*ll.setGraphic(imageView1);
        //ll.onMouseClickedProperty().addListener(listener);
        ll.setOnMouseClicked(event -> {
        if (event.getClickCount() == 1) {
             System.out.println("label click!");
             if (labelFlag == false){
                 labelFlag = true;
                 ll.setGraphic(imageView2);
                 //System.out.println("Widt: " + ll.getWidth() + " Height: " + ll.getHeight());
             }
             else if (labelFlag == true){
                 labelFlag = false;
                 
                 ll.setGraphic(imageView1);
                 //System.out.println("Widt: " + ll.getWidth() + " Height: " + ll.getHeight());
             }
        }
    });
        
        */
        
        int numberControl = 0;
        
        for(int q = 0 ; q < label1X2Array.length ; q++){
            label1X2Array[q] = new Label();
            BackgroundFill background_fill = new BackgroundFill(Color.LIGHTGREEN,  CornerRadii.EMPTY, Insets.EMPTY); 
            Background background = new Background(background_fill);
            label1X2Array[q].setBackground(background);
            if ( numberControl == 0){
                label1X2Array[q].setText("  1  ");
                numberControl++;
            }
            else if (numberControl == 1){
                label1X2Array[q].setText("  X  ");
                numberControl++;
            }
            else if (numberControl == 2){
                label1X2Array[q].setText("  2  ");
                numberControl = 0;
            }
            
        }
        
        /*
        for(int index = 0 ; index < hboxLabelArray.length  ; index++){
            hboxLabelArray[index].getChildren().add(rowNumberlabelArray[index]);
            hboxLabelArray[index].getChildren().add(MGArray[index]);
            //this.getChildren().add(hboxNumMGArray[index]);
        }
        */
        
        //hboxLabelArray[0].setStyle("-fx-background-color: Blue;");
        //hbox1X2Array[0].setStyle("-fx-background-color: yellow;");
        
        //MGArray[0].setGraphic(imageView1);
        //MGArray[1].setGraphic(imageView2);
        /*
        hboxLabelArray[0].getChildren().add(rowNumberlabelArray[0]);
        hboxLabelArray[0].getChildren().add(MGArray[0]);
        hboxLabelArray[0].getChildren().add(label1X2Array[0]);
        hboxLabelArray[0].getChildren().add(label1X2Array[1]);
        hboxLabelArray[0].getChildren().add(label1X2Array[2]);
        
        hboxLabelArray[1].getChildren().add(rowNumberlabelArray[1]);
        hboxLabelArray[1].getChildren().add(MGArray[1]);
        hboxLabelArray[1].getChildren().add(label1X2Array[3]);
        hboxLabelArray[1].getChildren().add(label1X2Array[4]);
        hboxLabelArray[1].getChildren().add(label1X2Array[5]);
        */
        //hboxNumMGArray[3].setFillHeight(true);
        //this.getChildren().add(hboxNumMGArray[0]);
        //this.getChildren().add(hbox1X2Array[0]);
        //this.getChildren().addAll(hboxLabelArray[0]);
        //this.getChildren().addAll(hboxLabelArray[1]);
        //this.getChildren().add(hboxNumMGArray[1]);
        //this.getChildren().add(hbox1X2Array[1]);
        
        
        //this.getChildren().add(hboxNumMGArray[1]);
        //this.getChildren().add(MGArray[1]);
        
        Double sm0 = hboxNumMGArray[0].getHeight();
        System.out.println("height0: " + sm0);
        Double sm1= hboxNumMGArray[1].getHeight();
        System.out.println("height0: " + sm1);
        
        //hboxNumMGArray[4].getChildren().add(rowNumberlabelArray[4]);
        //hboxNumMGArray[4].getChildren().add(MGArray[4]);
        //this.getChildren().add(hboxNumMGArray[4]);
        
        
        int totalLabels = (rowNumberlabelArray.length + MGArray.length + label1X2Array.length);
        int squareNumber = 0; 
        int hboxIndex = 0;
        int array1X2Number = 0;
        
        for (int addIndex = 0 ; addIndex < totalLabels ; addIndex++ ){
            if ( squareNumber == 0){
                hboxLabelArray[hboxIndex].getChildren().add(rowNumberlabelArray[hboxIndex]);
                squareNumber++;
            }
            else if (squareNumber == 1){
                hboxLabelArray[hboxIndex].getChildren().add(MGArray[hboxIndex]);
                squareNumber++;
            }
            else if (squareNumber == 2){
                hboxLabelArray[hboxIndex].getChildren().add(label1X2Array[array1X2Number]);
                array1X2Number++;
                squareNumber++;
            }
            else if (squareNumber == 3){
                hboxLabelArray[hboxIndex].getChildren().add(label1X2Array[array1X2Number]);
                array1X2Number++;
                squareNumber++;
            }
            else if (squareNumber == 4){
                hboxLabelArray[hboxIndex].getChildren().add(label1X2Array[array1X2Number]);
                array1X2Number++;
                hboxIndex++;
                squareNumber = 0;
            }
            
        }
        
        /*
        for (int i = 0 ; i < hboxLabelArray.length ; i++){
            this.getChildren().add(hboxLabelArray[i]);
        }
        */
        
        this.getChildren().addAll(hboxLabelArray);
        
        //hboxNumMGArray[3].getChildren().add(MGArray[7]);
        /*
        hboxNumMGArray[0].getChildren().add(labelArray[0]);
        hboxNumMGArray[0].getChildren().add(ll);
        hbox1X2Array[0].getChildren().add(labelArray[2]);
        hbox1X2Array[0].getChildren().add(labelArray[3]);
        hbox1X2Array[0].getChildren().add(labelArray[4]);
        */
        //hbox.getChildren().add(bu);
        //hbox.getChildren().add(MGcheckArray[0]);
        
        
        
        //this.getChildren().addAll(MGArray);
        
        
    }
    
    /*
    public void addMGLabelListener(ActionEvent  listenForLabelClick){
	        
        for(int x = 0 ; x<MGArray.length ; x++){
	        //MGArray[x].addEventHandler(EventType.ROOT);
                MGArray[x].setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                        public void handle(MouseEvent event) {
                            throw new UnsupportedOperationException("Exception throwed! Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            
                        }
                        
                }) ;
                
        }
	       
    }
    */
    
}
