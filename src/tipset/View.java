/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipset;

import Grafik.Left;
import Grafik.Top;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Reza
 */
public class View {
    
    private BorderPane borderPane = new BorderPane();
    
    private Top top;
    private Left left;
    
    public View(Stage primaryStage, Top top1, Left left1){
        
        this.top = top1;
        this.left= left1;
        
        borderPane.setTop(top);
        borderPane.setLeft(left);
        
        Scene scene = new Scene(borderPane, 300, 250);
        
        primaryStage.setTitle("Tipset");
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    
}
