package co.uk.gsck.midi.mapper.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;

public class Main {


    @FXML
    private TextArea logTextArea;

    private void log(String message) {
        logTextArea.setText( logTextArea.getText() + message + "\n" );
    }

    public void initialize() {
        logTextArea.setText("");

        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();

        for (int i = 0; i<infos.length; i++) {
            log("["+i+"] " + infos[i].getName() + " : " + infos[i].getDescription());
        }
    }
}
