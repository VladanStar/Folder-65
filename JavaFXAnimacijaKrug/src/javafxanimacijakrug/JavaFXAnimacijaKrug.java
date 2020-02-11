/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxanimacijakrug;

import java.awt.Color;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import static javafx.scene.paint.Color.RED;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class JavaFXAnimacijaKrug extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.setStyle("-fx-background-color:darkgrey;");
        
        Button btn1 = new Button("+");
        Button btn2 = new Button("-");
        
        hBox.getChildren().addAll(btn2,btn1);
        
        
        StackPane pane = new StackPane();
        pane.setStyle("-fx-background-color:lightblue;");
        Circle krug = new Circle(75);
        krug.setFill(RED);
        pane.getChildren().add(krug);
        
        BorderPane bp = new BorderPane();
        bp.setBottom(hBox);
        bp.setCenter(pane);
                
        btn1.setOnAction(e->{
        krug.setRadius(krug.getRadius()+10);
        });
        
        btn2.setOnAction(e->{
        krug.setRadius(krug.getRadius()-10);
        });
        
        Scene scene = new Scene(bp, 500, 450);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
