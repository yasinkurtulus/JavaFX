package com.example.javafx;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class LoanCalculator extends Application {
    private TextField tfAnnualInterestRate = new TextField();
    private TextField tfNumberOfYears = new TextField();
    private TextField tfLoanAmount = new TextField();
    private TextField tfMonthlyPayment = new TextField();
    private TextField tfTotalPayment = new TextField();
    private Button btCalculate = new Button("Calculate");
    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane=new GridPane();
        pane.setHgap(20);
        pane.setVgap(20);
        pane.add(new Label("Annual Interest Rate:"), 0, 0);
        pane.add(tfAnnualInterestRate, 1, 0);
        pane.add(new Label("Number Of Years:"), 0, 1);
        pane.add(tfNumberOfYears, 1, 1);
        pane.add(new Label("Loan Amount:"), 0, 2);
        pane.add(tfLoanAmount, 1, 2);
        pane.add(new Label("Monthly Payment:"), 0, 3);
        pane.add(tfMonthlyPayment, 1, 3);
        pane.add(new Label("Total Payment:"), 0, 4);
        pane.add(tfTotalPayment, 1, 4);
        pane.add(btCalculate,1,5);

        pane.setAlignment(Pos.CENTER);
        tfAnnualInterestRate.setAlignment(Pos.BOTTOM_RIGHT);
        tfNumberOfYears.setAlignment(Pos.BOTTOM_RIGHT);
        tfLoanAmount.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfTotalPayment.setAlignment(Pos.BOTTOM_RIGHT);
        tfMonthlyPayment.setEditable(false);
        tfTotalPayment.setEditable(false);
        btCalculate.setOnAction(e->calculateLoan());
        GridPane.setHalignment(btCalculate, HPos.RIGHT);
        Scene scene=new Scene(pane,250,300);
        stage.setTitle("Loan Calculator");
        stage.setScene(scene);
        stage.show();

    }

    private void calculateLoan() {
        double interest= Double.parseDouble(tfAnnualInterestRate.getText());
        double year= Double.parseDouble(tfNumberOfYears.getText());
        double amount= Double.parseDouble(tfLoanAmount.getText());
        Loan loan=new Loan(interest,year,amount);
        tfMonthlyPayment.setText(String.format("$%.2f",
                loan.getMonthlyPayment()));
        tfTotalPayment.setText(String.format("$%.2f",
                loan.totalPayment()));
    }
}
class Loan{
  private   double annualInterestRate;
  private   double numberOfYears;
   private double loanAmount;

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Loan(double annualInterestRate, double numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getNumberOfYears() {
        return numberOfYears;
    }

    public void setNumberOfYears(double numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }
    public double getMonthlyPayment(){
        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate / (1 -
                (1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
        return monthlyPayment;
    }
    public double totalPayment(){
        double totalPayment = getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }
}
