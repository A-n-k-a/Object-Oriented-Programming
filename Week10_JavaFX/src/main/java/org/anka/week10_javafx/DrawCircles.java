package org.anka.week10_javafx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import java.util.Random;
import javafx.scene.paint.Color;

public class DrawCircles extends Application {


    private Canvas canvas = new Canvas(400, 400);

    /**
     * Setting up the scene with a mouse event and the canvas
     * @param primaryStage
     */
    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();
        root.getChildren().add(canvas);

        Scene scene = new Scene(root);

        drawCircles();
        BorderPane borderPane = new BorderPane();
        //Scene inputScene = new Scene(borderPane, 400, 50);
        TextField inputShape = new TextField();
        Button addShape = new Button("Add Shape");
        addShape.setOnAction(event -> {
            String shape = inputShape.getText();
            if (shape.equalsIgnoreCase("circle")) {
                drawCircles();
            } else if (shape.equalsIgnoreCase("rectangle")) {
                drawRectangles();
            } else {
                System.out.println("Invalid shape");
            }
        });
        borderPane.setLeft(inputShape);
        borderPane.setBottom(addShape);
        //root.getChildren().add(borderPane);

        BorderPane borderPane2 = new BorderPane();
        RadioButton rbt1 = new RadioButton("Circles");
        //rbt1.setSelected(true);
        RadioButton rbt2 = new RadioButton("Rectangles");

        ToggleGroup radioGroup = new ToggleGroup();
        rbt1.setToggleGroup(radioGroup);
        rbt2.setToggleGroup(radioGroup);

        rbt1.setSelected(true);
        Button addShape2 = new Button("Add Shape");
        addShape2.setOnAction(event -> {
            if (rbt1.isSelected()) {
                drawCircles();
            } else if (rbt2.isSelected()) {
                drawRectangles();
            }
        });
        borderPane2.setLeft(rbt1);
        borderPane2.setRight(rbt2);
        borderPane2.setBottom(addShape2);
        root.getChildren().add(borderPane2);

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY) {
                    drawCircles();
                }
            }
        });
        primaryStage.setTitle("Draw Circles");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawCircles() {
        // radius of the circles
        final int RADIUS = 20;
        Random rand = new Random();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int i =0; i <10;i++) {
            int x = rand.nextInt(400);
            int y = rand.nextInt(400);
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            Color color = Color.rgb(r, g, b);
            gc.fillOval(x, y, RADIUS, RADIUS);
            gc.setFill(color);
        }
    }
    public void drawRectangles() {
        int height, width;
        Random rand = new Random();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (int i =0; i <10;i++) {
            height = rand.nextInt(100);
            width = rand.nextInt(100);
            int x = rand.nextInt(400);
            int y = rand.nextInt(400);
            int r = rand.nextInt(255);
            int g = rand.nextInt(255);
            int b = rand.nextInt(255);
            Color color = Color.rgb(r, g, b);
            gc.fillRect(x, y, height, width);
            gc.setFill(color);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
