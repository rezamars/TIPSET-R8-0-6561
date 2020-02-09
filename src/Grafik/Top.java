/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Grafik;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.javafx.jmx.MXNodeAlgorithm;
import com.sun.javafx.jmx.MXNodeAlgorithmContext;
import com.sun.javafx.sg.prism.NGNode;
import com.sun.javaws.Main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 *
 * @author Reza
 */
public class Top extends HBox{
    
    private Label tipsLabel = new Label();
    private Label systemLabel = new Label("R8-0-27-6561(10)");
    private Image image;
    private String imagePath = "tipset.jpg";
    
    //private FlowPane flowPane = new FlowPane(Orientation.VERTICAL, 10, 10);
    //private BorderPane borderTop = new BorderPane();
    
    public Top() {
        
        
        this.setAlignment(Pos.CENTER);
        this.setPadding(new Insets(10, 10, 10, 10));  
        this.setSpacing(30);
        
        try {
            
            image = new Image(imagePath);
        }
        catch(Exception e) {
            System.out.println("Gick ej att ladda tipset-bild!");
            //System.exit(0);
            return;
        }
        
        
        tipsLabel.setGraphic(new ImageView(image));
        
        Font font ;
        font = Font.font("Arial", FontWeight.BOLD, 40);
        systemLabel.setFont(font);
        systemLabel.setTextFill(Color.RED);

        this.getChildren().add(tipsLabel);
        this.getChildren().add(systemLabel);

        
    }
    
    
    
}
