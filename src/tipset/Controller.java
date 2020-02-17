/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipset;

import Grafik.Center;
import Grafik.Left;
import Grafik.Right;
import Grafik.Top;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.stage.Screen;
import javafx.stage.Stage;
import model.MGListener;
import model.ReadFile;
import model.ResultRowListener;

/**
 *
 * @author Reza
 */
public class Controller extends Application {
    
    
    private Top top = new Top();
    private Left left = new Left();
    private Center center = new Center();
    private Right right = new Right();
    private Label[] MGArray ;
    private MGListener MGlistener;
    private Label[] result1X2Array;
    private ResultRowListener resultListener;
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        
        //set Stage boundaries to visible bounds of the main screen
        primaryStage.setX(primaryScreenBounds.getMinX());
        primaryStage.setY(primaryScreenBounds.getMinY());
        primaryStage.setWidth((primaryScreenBounds.getWidth())/1.5);
        primaryStage.setHeight((primaryScreenBounds.getHeight())/1.5);
        
        this.MGArray = left.getMGArray();
        this.result1X2Array = center.getResultArray();
        
        MGlistener = new MGListener(MGArray, left);
        MGlistener.addMGLabelListener();
        
        resultListener = new ResultRowListener(result1X2Array, center);
        resultListener.addResultLabelListener();
        
        View v = new View(primaryStage, top, left, center, right);
        
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
