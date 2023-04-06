package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.util.Duration;

/**
 * The Timer class.
 *
 * @author Natalie Yu and Jason Shi
 * @version 2023-04
 */
public class Timer {
    /**
     * The timeline of the timer.
     */
    private Timeline timeline;

    /**
     * The label of the timer.
     */
    private Label timerLabel;

    /**
     *  The number of seconds elapsed.
     */
    private int secondsElapsed;

    /**
     * Creates a new instance of Timer with specified label.
     *
     * @param timerLabel the label of the timer
     */
    public Timer(final Label timerLabel) {
        this.timerLabel = timerLabel;
        timerLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 30));
        timerLabel.setTextFill(Color.BLACK);
        timerLabel.setPrefSize(100, 50);

        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<>() {
            @Override
            public void handle(final ActionEvent event) {
                secondsElapsed++;
                updateTimerLabel();
            }
        }));
    }

    /**
     * Starts the timer.
     */
    public void startTimer() {
        timeline.play();
    }

    /**
     * Stops the timer.
     */
    public void stopTimer() {
        timeline.stop();
    }

    /**
     * Gets the number of seconds elapsed.
     *
     * @return the number of seconds elapsed
     */
    public int getSecondsElapsed() {
        return secondsElapsed;
    }

    /**
     * Resets the timer.
     */
    public void resetTimer() {
        secondsElapsed = 0;
        updateTimerLabel();
    }

    /**
     * Updates the label of the timer.
     */
    private void updateTimerLabel() {
        int minutes = secondsElapsed / 60;
        int seconds = secondsElapsed % 60;
        timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }
}
