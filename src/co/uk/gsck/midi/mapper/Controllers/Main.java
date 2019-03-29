package co.uk.gsck.midi.mapper.Controllers;

import co.uk.gsck.midi.mapper.Handlers.Error;
import co.uk.gsck.midi.mapper.Handlers.MidiDeviceInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Transmitter;


public class Main {


    @FXML
    private TextArea logTextArea;
    @FXML
    private ComboBox deviceSelector;

    private Transmitter transmitter;

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
        deviceSelector.valueProperty().addListener((obs,oldVal,newVal) -> {
            if (oldVal != null) {
                try {
                    //MidiDevice oldDev = ((MidiDeviceInfo)oldVal).getDevice();
                    MidiDevice oldDev = (MidiSystem.getMidiDevice(infos[5]));
                    oldDev.close();
                } catch (MidiUnavailableException e) {
                    Error.error("Midi device is currently unavailable",e.toString(),true);
                    e.printStackTrace();
                }
            }
            try {
                MidiDevice newDev = ((MidiDeviceInfo)newVal).getDevice();
                newDev.open(); // Open it too allow the listener to
                transmitter = newDev.getTransmitter();
                //transmitter.setReceiver(new MidiCallback());
            } catch (MidiUnavailableException e) {
                Error.error("Midi device is currently unavailable",e.toString(),true);
                e.printStackTrace();
            }

        });
    }
}
