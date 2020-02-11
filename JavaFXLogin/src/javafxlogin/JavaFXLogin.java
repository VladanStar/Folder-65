/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxlogin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class JavaFXLogin extends Application {

    Label lab1 = new Label("Unesite korisnicko ime:");
    TextField tf1 = new TextField();
    Label lab2 = new Label("Unesite lozinku");
    PasswordField tf2 = new PasswordField();
    Button btn = new Button("Login");
    Button btn2 = new Button("Novi korisnik");
    File file = new File("login.txt");

    @Override
    public void start(Stage primaryStage) {
        tf1.setAlignment(Pos.BOTTOM_RIGHT);
        tf2.setAlignment(Pos.BOTTOM_RIGHT);

        btn.setOnAction(e -> {

            try {
                Scanner sc = new Scanner(file);
                String s1;
                String s2;
                boolean nadjen = false;

                while (sc.hasNext()) {
                    s1 = sc.next();
                    s2 = sc.next();
                    if (tf1.getText().equals(s1)
                            && tf2.getText().equals(s2)) {
                        primaryStage.close();
                        new Main().start(primaryStage);
                        nadjen = true;

                    }
                }
                if (!nadjen) {
                    JOptionPane.showMessageDialog(null,
                            "Pogresni podaci: korisnicko ime ne postoji");
                }

            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null,
                        "Ne postoji takva datoteka");

            }
        });
        btn2.setOnAction(e -> {
            try (PrintWriter pw = new PrintWriter(new FileOutputStream(file, true))) {
                pw.println(tf1.getText());
                pw.println(tf2.getText());
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Ne postoji takva datoteka");
            }

        });
        GridPane root = new GridPane();
        root.setHgap(5);
        root.setVgap(5);
        root.setAlignment(Pos.CENTER);
        root.add(lab1, 0, 0);
        root.add(tf1, 1, 0);
        root.add(lab2, 0,1);
        root.add(tf2, 1, 1);
        root.add(btn, 0, 2);
        root.add(btn2, 1, 2);
        GridPane.setHalignment(btn, HPos.LEFT);
        GridPane.setHalignment(btn2, HPos.LEFT);
        GridPane.setHalignment(lab1, HPos.LEFT);
        GridPane.setHalignment(lab2, HPos.LEFT);
        
        tf1.setAlignment(Pos.BOTTOM_RIGHT);
        tf2.setAlignment(Pos.BOTTOM_RIGHT);

        Scene scene = new Scene(root, 400, 150);

        primaryStage.setTitle("Login Stranica");
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
