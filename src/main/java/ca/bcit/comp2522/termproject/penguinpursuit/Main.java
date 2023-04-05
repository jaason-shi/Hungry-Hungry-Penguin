package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Parent root =  FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Penguin Pursuit");
        stage.getIcons().add(new Image("penguin.png"));
        stage.setResizable(false);

        Group titleRoot = new Group();
        Scene titleScene = new Scene(titleRoot, 800, 600, Color.SKYBLUE);

        BorderPane gameRoot = new BorderPane();
        Scene gameScene = new Scene(gameRoot);

        stage.setScene(titleScene);

        Text text = new Text();
        text.setText("Penguin Pursuit");
        text.setX(175);
        text.setY(140);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        text.setFill(Color.NAVY);

        Button button = new Button("Start");
        button.setLayoutX(365);
        button.setLayoutY(500);
        button.setPrefWidth(80);
        button.setPrefHeight(40);
        button.setOnAction(event -> {
            stage.setScene(gameScene);
            stage.show();
        });
//
//        Image image = new Image("icon.png");
//        ImageView imageView = new ImageView(image);
//        imageView.setX(290);
//        imageView.setY(220);

        titleRoot.getChildren().add(text);
        titleRoot.getChildren().add(button);

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext context = canvas.getGraphicsContext2D();

        gameRoot.setCenter(canvas);
        context.setFill(Color.SKYBLUE);
        context.fillRect(0,0,800,600);

        ArrayList<String> inputList = new ArrayList<>();

        gameScene.setOnKeyPressed(
                (KeyEvent event) -> {
                    String keyName = event.getCode().toString();
                    if (!inputList.contains(keyName)) {
                        inputList.add(keyName);
                    }
                }
        );

        gameScene.setOnKeyReleased(
                (KeyEvent event) -> {
                    String keyName = event.getCode().toString();
                    inputList.remove(keyName);
                }
        );

        Sprite penguin = new Sprite();
        penguin.position.set(100, 100);
        penguin.setImage("penguin.png");

        ArrayList<Sprite> fishList = new ArrayList<>();
        int fishCount = 30;
        for (int i = 0; i < fishCount; i++) {
            Sprite fish = new Sprite();
            double x = Math.random() * 600 + 100;
            double y = Math.random() * 400 + 100;
            fish.position.set(x, y);
            fish.setImage("fish.png");
            fishList.add(fish);
        }

        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                penguin.render(context);

                penguin.speed.set(0, 0);

                if(inputList.contains("LEFT")) {
                    penguin.speed.add(-50, 0);
                }
                if(inputList.contains("RIGHT")) {
                    penguin.speed.add(50, 0);
                }
                if(inputList.contains("UP")) {
                    penguin.speed.add(0, -50);
                }
                if(inputList.contains("DOWN")) {
                    penguin.speed.add(0, 50);
                }

                penguin.speed.multiply(1/60.0);
                penguin.position.add(penguin.speed);

                for (int i = 0; i < fishList.size(); i++) {
                    Sprite fish = fishList.get(i);
                    if (penguin.intersects(fish)) {
                        fishList.remove(i);
                    }
                }
                context.setFill(Color.SKYBLUE);
                context.fillRect(0,0,800,600);

                for(Sprite fish: fishList) {
                    fish.render(context);
                }
                penguin.render(context);

                int fishLeft = fishList.size();
                context.setFont(new Font("Verdana", 36));
                context.setLineWidth(2);
                context.setFill(Color.BLACK);
                context.setStroke(Color.BLACK);
                if(fishLeft > 0) {
                    context.fillText("Fish Left: " + fishLeft, 25, 40);
                    context.strokeText("Fish Left: " + fishLeft, 25, 40);
                } else {
                    context.fillText("Penguin finished its meal!", 25, 40);
                    context.strokeText("Penguin finished its meal!", 25, 40);
                }
            }
        };
        gameLoop.start();
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}