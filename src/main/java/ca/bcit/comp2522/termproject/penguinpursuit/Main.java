package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * The Main driver class for the Hungry Hungry Penguin Game.
 *
 * @author Natalie Yu and Jason Shi
 * @version 2023-04
 */
public class Main extends Application {

    /**
     * The penguin Sprite object that represents the player.
     */
    private Sprite penguin = new Sprite();

    /**
     * The ArrayList of fish Sprite objects that represent the food.
     */
    private ArrayList<Sprite> fishList = new ArrayList<>();

    /**
     * The ArrayList of wall Sprite objects that represent the obstacles.
     */
    private ArrayList<Sprite> wallList = new ArrayList<>();

    /**
     * The ArrayList of input String objects that represent the player's input in the game.
     */
    private ArrayList<String> inputList = new ArrayList<>();

    /**
     * The number of vertical walls in the game.
     */
    private static final int VERTICAL_WALL_COUNT = 4;

    /**
     * The number of horizontal walls in the game.
     */
    private static final int HORIZONTAL_WALL_COUNT = 4;

    /**
     * The number of fish in the game.
     */
    private static final int FISH_COUNT = 30;

    /**
     * The timer to keep track of the time elapsed in the game.
     */
    private Timer gameTimer;

    /**
     * Resets the game.
     */
    private void resetGame() {
        gameTimer.resetTimer();
        penguin.position.set(100, 100);
        inputList.clear();
        fishList.clear();
        wallList.clear();
        for (int i = 0; i < VERTICAL_WALL_COUNT; i++) {
            Sprite wall = new Sprite();
            wall.setImage("ice-platform-vertical.png");
            do {
                double x = Math.random() * 600 + 100;
                double y = Math.random() * 400 + 100;
                wall.position.set(x, y);
            } while (wall.intersectsAny(wallList) || wall.intersects(penguin) || wall.intersectsAny(fishList));
            wallList.add(wall);
        }

        for (int i = 0; i < HORIZONTAL_WALL_COUNT; i++) {
            Sprite wall = new Sprite();
            wall.setImage("ice-platform-horizontal.png");
            do {
                double x = Math.random() * 600 + 100;
                double y = Math.random() * 400 + 100;
                wall.position.set(x, y);
            } while (wall.intersectsAny(wallList) || wall.intersects(penguin) || wall.intersectsAny(fishList));
            wallList.add(wall);
        }

        for (int i = 0; i < FISH_COUNT; i++) {
            Sprite fish = new Sprite();
            fish.setImage("fish-small.png");
            do {
                double x = Math.random() * 600 + 100;
                double y = Math.random() * 400 + 100;
                fish.position.set(x, y);
            } while (fish.intersectsAny(wallList) || fish.intersectsAny(fishList) || fish.intersects(penguin));
            fishList.add(fish);
        }
    }

    /**
     * Starts the game and sets the scenes.
     * @param stage the stage to be displayed
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Hungry Hungry Penguin");
        stage.getIcons().add(new Image("penguin.png"));
        stage.setResizable(false);

        Group titleRoot = new Group();
        Scene titleScene = new Scene(titleRoot, 800, 600, Color.SKYBLUE);

        Group instructionRoot = new Group();
        Scene instructionScene = new Scene(instructionRoot, 800, 600, Color.SKYBLUE);

        BorderPane gameRoot = new BorderPane();
        StackPane stackPane = new StackPane();
        Scene gameScene = new Scene(stackPane, 800, 600);
        Label timerLabel = new Label("00:00");
        gameTimer = new Timer(timerLabel);
        stackPane.getChildren().addAll(gameRoot, timerLabel);
        StackPane.setAlignment(timerLabel, Pos.TOP_RIGHT);

        Group endRoot = new Group();
        Scene endScene = new Scene(endRoot, 800, 600, Color.SKYBLUE);

        stage.setScene(titleScene);

        Text titleText = new Text();
        titleText.setText("Hungry Hungry Penguin");
        titleText.setX(70);
        titleText.setY(140);
        titleText.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        titleText.setFill(Color.NAVY);

        Text instructionTitle = new Text();
        instructionTitle.setText("HOW TO PLAY:");
        instructionTitle.setWrappingWidth(700);
        instructionTitle.setTextAlignment(TextAlignment.CENTER);
        instructionTitle.setX(55);
        instructionTitle.setY(200);
        instructionTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        instructionTitle.setFill(Color.INDIANRED);

        Text instructionText = new Text();
        instructionText.setText("Mr. Penguin is very hungry... please help Mr. Penguin collect all the fish as fast as possible!"
                + "\n \nUse the arrow keys to move the penguin. \nYou can hit the Space Key to reset the game and the Escape Key to quit the game."
                + "\n \nClick Play to start the game.");
        instructionText.setWrappingWidth(700);
        instructionText.setTextAlignment(TextAlignment.CENTER);
        instructionText.setX(55);
        instructionText.setY(250);
        instructionText.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        instructionText.setFill(Color.NAVY);


        Text endingText = new Text();
        endingText.setX(100);
        endingText.setY(130);
        endingText.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        endingText.setFill(Color.NAVY);
        endingText.setWrappingWidth(600);
        endingText.setTextAlignment(TextAlignment.CENTER);

        Button startButton = new Button("Start");
        startButton.setLayoutX(365);
        startButton.setLayoutY(500);
        startButton.setPrefWidth(80);
        startButton.setPrefHeight(40);
        startButton.setOnAction(event -> {
            stage.setScene(instructionScene);
            stage.show();
        });

        Button playAgainButton = new Button("Play Again");
        playAgainButton.setLayoutX(365);
        playAgainButton.setLayoutY(500);
        playAgainButton.setPrefWidth(80);
        playAgainButton.setPrefHeight(40);
        playAgainButton.setOnAction(event -> {
            resetGame();
            stage.setScene(gameScene);
            stage.show();
        });

        Button playButton = new Button("Play");
        playButton.setLayoutX(365);
        playButton.setLayoutY(500);
        playButton.setPrefWidth(80);
        playButton.setPrefHeight(40);
        playButton.setOnAction(event -> {
            stage.setScene(gameScene);
            stage.show();
        });

        Image startImage = new Image("hungry-penguin.png");
        ImageView iconStartImage = new ImageView(startImage);
        iconStartImage.setX(260);
        iconStartImage.setY(175);

        titleRoot.getChildren().add(titleText);
        titleRoot.getChildren().add(startButton);
        titleRoot.getChildren().add(iconStartImage);

        instructionRoot.getChildren().addAll(playButton, instructionTitle, instructionText);

        Image endImage = new Image("full-penguin.png");
        ImageView iconEndImage = new ImageView(endImage);
        iconEndImage.setX(280);
        iconEndImage.setY(225);

        endRoot.getChildren().add(endingText);
        endRoot.getChildren().add(playAgainButton);
        endRoot.getChildren().add(iconEndImage);

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext context = canvas.getGraphicsContext2D();

        gameRoot.setCenter(canvas);

        context.setFill(Color.SKYBLUE);
        context.fillRect(0, 0, 800, 600);

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
        penguin.setImage("penguin-small.png");

        for (int i = 0; i < VERTICAL_WALL_COUNT; i++) {
            Sprite wall = new Sprite();
            wall.setImage("ice-platform-vertical.png");
            do {
                double x = Math.random() * 600 + 100;
                double y = Math.random() * 400 + 100;
                wall.position.set(x, y);
            } while (wall.intersectsAny(wallList) || wall.intersects(penguin) || wall.intersectsAny(fishList));
            wallList.add(wall);
        }

        for (int i = 0; i < HORIZONTAL_WALL_COUNT; i++) {
            Sprite wall = new Sprite();
            wall.setImage("ice-platform-horizontal.png");
            do {
                double x = Math.random() * 600 + 100;
                double y = Math.random() * 400 + 100;
                wall.position.set(x, y);
            } while (wall.intersectsAny(wallList) || wall.intersects(penguin) || wall.intersectsAny(fishList));
            wallList.add(wall);
        }

        for (int i = 0; i < FISH_COUNT; i++) {
            Sprite fish = new Sprite();
            fish.setImage("fish-small.png");
            do {
                double x = Math.random() * 600 + 100;
                double y = Math.random() * 400 + 100;
                fish.position.set(x, y);
            } while (fish.intersectsAny(wallList) || fish.intersectsAny(fishList) || fish.intersects(penguin));
            fishList.add(fish);
            }

        AnimationTimer gameLoop = new AnimationTimer() {

            /**
             * Creates the game loop.
             * @param now The current time in nanoseconds.
             */
            @Override
            public void handle(final long now) {
                penguin.render(context);

                gameTimer.startTimer();

                penguin.speed.set(0, 0);

                if (inputList.contains("LEFT") && penguin.position.xCoordinate > 0) {
                    penguin.speed.add(-75, 0);
                }
                if (inputList.contains("RIGHT") && penguin.position.xCoordinate < gameScene.getWidth() - penguin.image.getWidth()) {
                    penguin.speed.add(75, 0);
                }
                if (inputList.contains("UP") && penguin.position.yCoordinate > 0) {
                    penguin.speed.add(0, -75);
                }
                if (inputList.contains("DOWN") && penguin.position.yCoordinate < gameScene.getHeight() - penguin.image.getHeight()) {
                    penguin.speed.add(0, 75);
                }
                if (inputList.contains("SPACE")) {
                    resetGame();
                    stage.setScene(gameScene);
                    stage.show();
                }
                if (inputList.contains("ESCAPE")) {
                    stage.close();
                }

                penguin.speed.multiply(1 / 60.0);
                penguin.position.add(penguin.speed);

                for (int i = 0; i < fishList.size(); i++) {
                    Sprite fish = fishList.get(i);
                    if (penguin.intersects(fish)) {
                        fishList.remove(i);
                    }
                }

                for (Sprite wall : wallList) {
                    if (penguin.intersects(wall)) {
                        penguin.position.set(penguin.position.xCoordinate - penguin.speed.xCoordinate, penguin.position.yCoordinate - penguin.speed.yCoordinate);
                    }
                }
                context.setFill(Color.SKYBLUE);
                context.fillRect(0, 0, 800, 600);

                for (Sprite fish: fishList) {
                    fish.render(context);
                }

                for (Sprite wall: wallList) {
                    wall.render(context);
                }

                penguin.render(context);

                int fishLeft = fishList.size();
                context.setFont(new Font("Verdana", 30));
                context.setLineWidth(2);
                context.setFill(Color.BLACK);
                context.setStroke(Color.BLACK);
                if (fishLeft > 0) {
                    context.fillText("Fish Left: " + fishLeft, 25, 40);
                    context.strokeText("Fish Left: " + fishLeft, 25, 40);
                } else {
                    gameTimer.stopTimer();
                    int secondsElapsed = gameTimer.getSecondsElapsed();
                    endingText.setText("Mr. Penguin has collected all the fish! He got it all in " + secondsElapsed + " seconds!");
                    stage.setScene(endScene);
                }
            }

        };
        gameLoop.start();
        stage.show();
    }

    /**
     * Drives the program.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args) {
        launch();
    }
}
