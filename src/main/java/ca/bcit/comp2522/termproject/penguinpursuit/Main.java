package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.RecursiveAction;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
//        Parent root =  FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.SKYBLUE);
        stage.getIcons().add(new Image("icon.png"));
        stage.setTitle("Penguin Pursuit");
        stage.setResizable(false);
        stage.setX(350);
        stage.setY(100);

        Text text = new Text();
        text.setText("Penguin Pursuit");
        text.setX(175);
        text.setY(140);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        text.setFill(Color.NAVY);

        Image image = new Image("icon.png");
        ImageView imageView = new ImageView(image);
        imageView.setX(290);
        imageView.setY(220);

        Group root2 = new Group();
        Scene gameScene = new Scene(root2, 800, 600, Color.SKYBLUE);

        Platform platform = new Platform();
        platform.addPlatform(0, 550, 800, 50);
        platform.addPlatform(200, 400, 400, 50);

        Pane platformPane = new Pane();
        for (Rectangle rectangle : platform.getPlatforms()) {
            rectangle.setFill(Color.ALICEBLUE); // set platform color
            platformPane.getChildren().add(rectangle);
        }

        Button button = new Button("Start");
        button.setLayoutX(365);
        button.setLayoutY(500);
        button.setPrefWidth(80);
        button.setPrefHeight(40);
        button.setOnAction(event -> {
            stage.setScene(gameScene);
            stage.show();
        });

        root2.getChildren().add(platformPane);
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