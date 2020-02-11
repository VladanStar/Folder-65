/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxloancalculator;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author User
 */
public class JavaFXLoanCalculator extends Application {
    private TextField tfAnnualInterstRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private TextField tfMonthlyPayment = new TextField();
    private TextField tfTotalPayment = new TextField();
    private Button btCalculate = new Button("Calculate");
    
    
    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
       gridPane.setHgap(5);
       gridPane.setVgap(5);
       gridPane.add(new Label("Annual Interest Rate"), 0, 0);
       gridPane.add(tfAnnualInterstRate, 1, 0);
       gridPane.add(new Label("Number of Years"), 0, 1);
       gridPane.add(tfNumberOfYears, 1, 1);
       gridPane.add(new Label("Loan Amount:"), 0, 2);
       gridPane.add(tfLoanAmount, 1, 2);
       gridPane.add(new Label("Monthly Payment: "), 0, 3);
       gridPane.add(tfMonthlyPayment, 1, 3);
       gridPane.add(new Label("Total Payment:"), 0, 4);
       gridPane.add(tfTotalPayment, 1, 4);
       gridPane.add(btCalculate, 1, 5);
       gridPane.setStyle("-fx-background-color:yellow;");
       
       gridPane.setAlignment(Pos.CENTER);
       tfAnnualInterstRate.setAlignment(Pos.BOTTOM_RIGHT);
       tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
       tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
       tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
       tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
       tfMonthlyPayment.setEditable(false);
       tfTotalPayment.setEditable(false);
       GridPane.setHalignment(btCalculate, HPos.LEFT);
       btCalculate.setOnAction(e-> calculateLoanPayment());
       
       
       
        
        Scene scene = new Scene(gridPane, 300, 250);
        
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

    private void calculateLoanPayment() {
        double interest = Double.parseDouble(tfAnnualInterstRate.getText());
        int years = Integer.parseInt(tfNumberOfYears.getText());
        double loanAmount = Double.parseDouble(tfLoanAmount.getText());
        
        Loan loan = new Loan(interest, years, loanAmount);
        tfMonthlyPayment.setText(String.format("$%2f", loan.getMonthlyPayment()));
        tfTotalPayment.setText(String.format("$%2f", loan.getTotalPayment()));
    }
    
}
