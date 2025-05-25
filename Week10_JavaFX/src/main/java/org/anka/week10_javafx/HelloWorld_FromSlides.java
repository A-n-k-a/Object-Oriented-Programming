package org.anka.week10_javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloWorld_FromSlides extends Application {
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);

        Label label = new Label("Hello World!");

        Scene scene = new Scene(label);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}
