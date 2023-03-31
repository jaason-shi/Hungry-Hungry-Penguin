package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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

        Group gameRoot = new Group();
        Scene gameScene = new Scene(gameRoot, 800, 600, Color.SKYBLUE);

        ArrayList<Platform> platformList = new ArrayList<Platform>();
//        int platformCount = 10;
//        for (int i=0; i<platformCount; i++){
//            Platform platforms = new Platform();
//            platforms.addPlatform(20, 20, 50, 50);
//            platformList.add(platforms);
//        }
//        Platform platform = new Platform();
        platformList.add(new Platform(0, 0, 50, 800));
        platform.addPlatform(0, 0, 800, 50);
        platform.addPlatform(0, 550, 800, 150);
        platform.addPlatform(750, 0, 50, 800);

        platform.addPlatform(110, 300, 50, 250);

        Pane platformPane = new Pane();
        for (Rectangle rectangle : platform.getPlatforms()) {
            rectangle.setFill(Color.ALICEBLUE);
            platformPane.getChildren().add(rectangle);
        }

        Platform icePlatform = new Platform();
        icePlatform.addPlatform(0, 550, 300, 50);
        Pane icePlatformPane = new Pane();
        icePlatformPane.getChildren().add(icePlatform.getIcePlatform());

////        Canvas canvas = new Canvas(600, 600);
////        GraphicsContext context = canvas.getGraphicsContext2D();
//        Sprite penguin = new Sprite();
//        penguin.position.set(100, 100);
//        penguin.setImage("penguin.png");
////        penguin.render(context);
//

        Player penguin = new Player(50, 50, Direction.RIGHT);
        Pane penguinPane = new Pane();
        penguinPane.getChildren().add(penguin.getPenguin());

//    EventHandler<KeyEvent> keyListener = new EventHandler<KeyEvent>() {
//        @Override
//        public void handle(KeyEvent keyEvent) {
//            if (keyEvent.getCode() == KeyCode.UP) {
//                penguin.jump();
//            }else if (keyEvent.getCode() == KeyCode.DOWN) {
//                penguin.moveDown();
//            } else if (keyEvent.getCode() == KeyCode.LEFT) {
//                penguin.moveLeft();
//            } else if (keyEvent.getCode() == KeyCode.RIGHT) {
//                penguin.moveRight();
//            }
//            }
//        };


        private boolean isColliding(Player player, Platform platform){
            Rectangle2D playerBounds = player.getBounds();
            Rectangle2D platformBounds = platform.getBounds();
            return playerBounds.intersects(platformBounds);
        }
//        check if penguin overlaps with platforms
        gameScene.setOnKeyPressed(keyEvent -> {
            switch(keyEvent.getCode()) {
                case UP:
                    penguin.moveUp(platformList);
                    break;
                case DOWN:
                    penguin.moveDown(scene);
                    break;
                case LEFT:
                    penguin.moveLeft();
                    break;
                case RIGHT:
                    penguin.moveRight(scene);
                    break;
                default:
                    break;
            }

            penguin.getPenguin().setX(penguin.getXCoordinate());
            penguin.getPenguin().setY(penguin.getYCoordinate());
        });


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