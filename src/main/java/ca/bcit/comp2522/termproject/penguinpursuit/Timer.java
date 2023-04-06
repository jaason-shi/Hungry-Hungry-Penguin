package ca.bcit.comp2522.termproject.penguinpursuit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class Timer {
    private Timeline timeline;
    private Label timerLabel;
    private int secondsElapsed;

    public Timer(Label timerLabel) {
        this.timerLabel = timerLabel;
        timeline = new Timeline();
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                secondsElapsed++;
                updateTimerLabel();
            }
        }));
    }

    public void startTimer() {
        timeline.play();
    }

    public void stopTimer() {
        timeline.stop();
    }

    public int getSecondsElapsed() {
        return secondsElapsed;
    }

    public void resetTimer() {
        secondsElapsed = 0;
        updateTimerLabel();
    }

    private void updateTimerLabel() {
        int minutes = secondsElapsed / 60;
        int seconds = secondsElapsed % 60;
        timerLabel.setText(String.format("%02d:%02d", minutes, seconds));
    }

}
