/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlogin;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import static javafx.scene.paint.Color.BLUE;
import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class Main extends Application {

    Font fn = Font.font("Arial", FontWeight.LIGHT, FontPosture.REGULAR, 26);
    Font fb = Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 26);
    Font fi = Font.font("Arial", FontWeight.LIGHT, FontPosture.ITALIC, 26);
    Font fbi = Font.font("Arial", FontWeight.BOLD, FontPosture.ITALIC, 26);

    CheckBox cb1 = new CheckBox("Bold");
    CheckBox cb2 = new CheckBox("Italic");
    Text tx = new Text(150, 150, "UNIVERZITET");

    @Override
    public void start(Stage primaryStage) {
        HBox hb1 = new HBox(20);
        hb1.setStyle("-fx-background-color:lightblue;");
        hb1.setAlignment(Pos.CENTER);
        Button btn1 = new Button("Levo");
        Button btn2 = new Button("Desno");
        Button btn3 = new Button("Gore");
        Button btn4 = new Button("Dole");
        Button logout = new Button("Odjavi se");
        Button kraj = new Button("Kraj programa");
        hb1.getChildren().addAll(btn1, btn2, btn3, btn4, logout, kraj);

        HBox hb2 = new HBox(20);
        hb2.setStyle("-fx-background-color:yellow;");
        hb2.setAlignment(Pos.CENTER);
        Label lb1 = new Label("Unesite tekst:");
        TextField tf = new TextField();
        tf.setAlignment(Pos.BASELINE_RIGHT);
        tf.setPromptText("Unesite tekst");
        Button btn5 = new Button("Promeni tekst");
        hb2.getChildren().addAll(lb1, tf, btn5);

        VBox vb1 = new VBox(20);
        vb1.setStyle("-fx-background-color:lightblue;");
        vb1.setAlignment(Pos.CENTER_LEFT);
        vb1.getChildren().addAll(cb1, cb2);

        VBox vb2 = new VBox(20);
        vb2.setStyle("-fx-background-color:yellow;");
        vb2.setAlignment(Pos.CENTER_LEFT);
        
        RadioButton rb1 = new RadioButton("Crvena");
        RadioButton rb2 = new RadioButton("Zelena");
        RadioButton rb3 = new RadioButton("Plava");
        ToggleGroup tg = new ToggleGroup();
        
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);
        rb3.setToggleGroup(tg);
        vb2.getChildren().addAll(rb1, rb2, rb3);

        Pane pane = new Pane();

        tx.setFont(fn);
        pane.getChildren().add(tx);

        BorderPane root = new BorderPane();
        root.setBottom(hb1);
        root.setTop(hb2);
        root.setRight(vb1);
        root.setLeft(vb2);
        root.setCenter(pane);

        btn1.setOnAction(e -> {
            tx.setX(tx.getX() - 10);
        });
        btn2.setOnAction(e -> {

            tx.setX(tx.getX() + 10);
        });

        btn3.setOnAction(e -> {
            tx.setY(tx.getY() - 10);
        });

        btn4.setOnAction(e -> {
            tx.setY(tx.getY() + 10);
        });
        

        tf.setOnAction(e -> {
            tx.setText(tf.getText());
        });
        
        btn5.setOnAction(e->{
        tx.setText(tf.getText());
        });
        

        rb1.setOnAction(e -> {
            tx.setFill(RED);
        });

        rb2.setOnAction(e -> {
            tx.setFill(GREEN);
        });

        rb3.setOnAction(e -> {
            tx.setFill(BLUE);
        });

        logout.setOnAction(e -> {
            primaryStage.close();
            new JavaFXLogin().start(primaryStage);
        });

        kraj.setOnAction(e -> {
            Platform.exit();
        });

        TipFonta tipFonta = new TipFonta();
        cb1.setOnAction(tipFonta);
        cb2.setOnAction(tipFonta);

        Scene scene = new Scene(root, 600, 450);

        primaryStage.setTitle("UNIVERZITET!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    class TipFonta implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            if (cb1.isSelected() && cb2.isSelected()) {
                tx.setFont(fbi);
            } else if (cb1.isSelected()) {

                tx.setFont(fb);
            } else if (cb2.isSelected()) {
                tx.setFont(fi);
            } else {
                tx.setFont(fn);
            }

        }
    }

}
