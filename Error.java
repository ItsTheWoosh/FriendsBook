package sample;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.*;

public class Error {
    static void errorAlert() {
        Alert error = new Alert(AlertType.ERROR);
        error.setHeaderText("Input not valid");
        error.setContentText("You may only select one(1) option");
        error.showAndWait();
    }

    static void friendError() {
        Alert error = new Alert(AlertType.ERROR);
        error.setHeaderText("Missing input");
        error.setContentText("Please fill in all fields");
        error.showAndWait();
    }
}
