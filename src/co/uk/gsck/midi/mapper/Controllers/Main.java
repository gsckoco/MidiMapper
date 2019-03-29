package co.uk.gsck.midi.mapper.Controllers;

import co.uk.gsck.midi.mapper.MidiDeviceInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;

public class Main {


    @FXML
    private TextArea logTextArea;
    @FXML
    private ComboBox deviceSelector;

    private void log(String message) {
        logTextArea.setText( logTextArea.getText() + message + "\n" );
    }

    public void initialize() {
        logTextArea.setText("");
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        log("Current devices plugged in are: ");
        ObservableList<MidiDeviceInfo> midiDevices = FXCollections.observableArrayList();
        for (int i = 0; i<infos.length; i++) {
            log("["+i+"] " + infos[i].getName() + " : " + infos[i].getDescription());
            midiDevices.add(new MidiDeviceInfo(infos[i],i));
        }

        deviceSelector.setItems(midiDevices);
    }
}
