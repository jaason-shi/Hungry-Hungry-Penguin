module ca.bcit.comp2522.termproject.penguinpursuit {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.bcit.comp2522.termproject.penguinpursuit to javafx.fxml;
    exports ca.bcit.comp2522.termproject.penguinpursuit;
}