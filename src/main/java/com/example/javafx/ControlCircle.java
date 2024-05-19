package com.example.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class ControlCircle extends Application {
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Circle circle = new Circle(10,10,50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);

        HBox hBox = new HBox();
        hBox.setSpacing(10);
        hBox.setAlignment(Pos.CENTER);
        Button btEnlarge = new Button("Enlarge");
        Button btShrink = new Button("Shrink");
        hBox.getChildren().add(btEnlarge);
        hBox.getChildren().add(btShrink);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setTop(hBox);
        BorderPane.setAlignment(hBox, Pos.CENTER);

        EnLarge enLarge=new EnLarge(circle);
        Shrink shrink=new Shrink(circle);

        btEnlarge.setOnAction(enLarge);
        btShrink.setOnAction(shrink);

        // Create a scene and place it in the stage
        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("ControlCircle"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
class EnLarge implements EventHandler<ActionEvent> {
    Circle circle;
    public EnLarge(Circle circle){
        this.circle=circle;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        double radius=circle.getRadius();
        circle.setRadius(++radius);
    }
}
class Shrink implements EventHandler<ActionEvent> {
    Circle circle;
    public Shrink(Circle circle){
        this.circle=circle;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        double radius=circle.getRadius();
        circle.setRadius(--radius);
    }
}

