package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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

//        Group root = new Group();
//        Scene scene = new Scene(root, 800, 600, Color.SKYBLUE);
//        stage.getIcons().add(new Image("icon.png"));
        stage.setTitle("Penguin Pursuit");
//        stage.setResizable(false);
//        stage.setScene(scene);
//
//        Text text = new Text();
//        text.setText("Penguin Pursuit");
//        text.setX(175);
//        text.setY(140);
//        text.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
//        text.setFill(Color.NAVY);
//
//        Image image = new Image("icon.png");
//        ImageView imageView = new ImageView(image);
//        imageView.setX(290);
//        imageView.setY(220);

        BorderPane gameRoot = new BorderPane();
        Scene gameScene = new Scene(gameRoot);

        stage.setScene(gameScene);
        Canvas canvas = new Canvas(800, 600);
        GraphicsContext context = canvas.getGraphicsContext2D();

        gameRoot.setCenter(canvas);
        context.setFill(Color.SKYBLUE);
        context.fillRect(0,0,800,600);


        Player penguin = new Player(50, 50, Direction.RIGHT);
        Pane penguinPane = new Pane();
        penguinPane.getChildren().add(penguin.getPenguin());


        ArrayList<Fish> fishList = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            Fish fish = new Fish(25, 25);
            fishList.add(fish);

            Pane fishPane = new Pane();
            fishPane.getChildren().add(fish.getFish());
            gameRoot.getChildren().add(fishPane);
        }


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


        Button button = new Button("Start");
        button.setLayoutX(365);
        button.setLayoutY(500);
        button.setPrefWidth(80);
        button.setPrefHeight(40);
        button.setOnAction(event -> {
            stage.setScene(gameScene);
            stage.show();
        });



        gameRoot.getChildren().add(platformPane);
        gameRoot.getChildren().add(penguinPane);
        gameRoot.getChildren().add(icePlatformPane);

        root.getChildren().add(text);
        root.getChildren().add(imageView);
        root.getChildren().add(button);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}