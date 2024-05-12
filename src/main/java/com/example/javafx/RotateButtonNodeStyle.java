package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class RotateButtonNodeStyle extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        StackPane stackPane=new StackPane();
        stackPane.setRotate(-20);
        Button btn=new Button("ok");
        btn.setStyle("-fx-border-color: red;");
        Scene scene=new Scene(stackPane,500,500);
        stackPane.setStyle("-fx-border-color: #0055ff; -fx-background-color: lightgray;");
        stackPane.getChildren().add(btn);
        btn.setRotate(20);
        stage.setTitle("Rotate Button");
        stage.setScene(scene);
        stage.show();
    }
}
