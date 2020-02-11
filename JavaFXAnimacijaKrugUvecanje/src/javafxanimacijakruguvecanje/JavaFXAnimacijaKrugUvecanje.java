/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxanimacijakruguvecanje;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class JavaFXAnimacijaKrugUvecanje extends Application {
    
    @Override
    public void start(Stage primaryStage) {
      Button btn = new Button("Click me");
      btn.setFont(Font.font("Arial", 20));
      btn.setStyle("-fx-background-color:red;");
      Circle circle = new Circle(75);
        StackPane root = new StackPane();
        root.getChildren().addAll(circle, btn);
        btn.setOnAction(e->{
            circle.setFill(Color.color(Math.random(), Math.random(), Math.random()));
        circle.setRadius(circle.getRadius()+10);
        });
        
        Scene scene = new Scene(root, 700, 650);
        
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
