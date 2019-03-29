package co.uk.gsck.midi.mapper.Handlers;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class Error {
    public static void error(String description, String stacktrace, boolean close) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("An error occurred!");
        alert.setHeaderText("It appears an error has occured.");
        alert.setContentText(description);


        Label label = new Label("Here is the stacktrace:");

        TextArea textArea = new TextArea(stacktrace);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        alert.getDialogPane().setExpandableContent(expContent);

        alert.showAndWait();
        if (close) {
            System.exit(0);
        }
    }
}
