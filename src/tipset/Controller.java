/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipset;

import Grafik.Left;
import Grafik.Top;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author Reza
 */
public class Controller extends Application {
    
    
    private Top top = new Top();
    private Left left = new Left();
    
    
    @Override
    public void start(Stage primaryStage) {
        
        //left.addMGLabelListener(new Listener());
        
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        
        //set Stage boundaries to visible bounds of the main screen
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.setWidth((primaryScreenBounds.getWidth())/1.5);
        primaryStage.setHeight((primaryScreenBounds.getHeight())/1.5);
        
        
        View v = new View(primaryStage, top, left);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
