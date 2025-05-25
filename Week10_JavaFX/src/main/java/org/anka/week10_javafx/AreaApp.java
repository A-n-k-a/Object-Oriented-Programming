package org.anka.week10_javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AreaApp extends Application {

    public Double CalculateRectangleArea(Double width, Double height) {
        return width * height;
    }

    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("getArea'");

        TextField widthField = new TextField();
        widthField.setPromptText("Enter width");
        TextField heightField = new TextField();
        heightField.setPromptText("Enter height");
        Label areaLabel = new Label("Area");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        });
        btn.setOnAction((ActionEvent event) -> {
            areaLabel.setText("Area: " + CalculateRectangleArea(Double.parseDouble(widthField.getText()), Double.parseDouble(heightField.getText())));
            VBox vBox = new VBox(5);
            Scene scene = new Scene(vBox);
            Label label = new Label("Area: " + CalculateRectangleArea(Double.parseDouble(widthField.getText()), Double.parseDouble(heightField.getText())));
            vBox.getChildren().add(label);
            Stage newStage = new Stage();
            newStage.setTitle("Area");
            newStage.setWidth(400);
            newStage.setHeight(300);
            newStage.setScene(scene);
            //newStage.show();
        });

        VBox root = new VBox(5.0);
        Scene scene = new Scene(root);
        root.getChildren().add(widthField);
        root.getChildren().add(heightField);
        root.getChildren().add(areaLabel);
        root.getChildren().add(btn);

        primaryStage.setTitle("Areas");
        primaryStage.setWidth(400);
        primaryStage.setHeight(300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
