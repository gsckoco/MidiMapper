package co.uk.gsck.midi.mapper.Controllers;

import co.uk.gsck.midi.mapper.Handlers.MidiCallback;
import co.uk.gsck.midi.mapper.Handlers.MidiDeviceInfo;
import co.uk.gsck.midi.mapper.Handlers.Popup;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Transmitter;

//import co.uk.gsck.midi.mapper.Instructions.;


public class Main {

    //private ArrayList<>
    @FXML
    private TextArea logTextArea;
    @FXML
    private ComboBox indeviceSelector;
    @FXML
    private ComboBox outdeviceSelector;
    @FXML
    private MenuItem aboutButton;
    @FXML
    private Label lastMessage;

    private Transmitter transmitter;

    public void log(String message) {
        logTextArea.setText( logTextArea.getText() + message + "\n" );
        System.out.println(message);
    }

    public void setLastMIDIMessage(String message) {
        lastMessage.setText(message);
    }

    public void initialize() {
        logTextArea.setText("");
        MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
        log("Current devices plugged in are: ");
        ObservableList<MidiDeviceInfo> inDevices = FXCollections.observableArrayList();
        ObservableList<MidiDeviceInfo> outDevices = FXCollections.observableArrayList();
        for (int i = 0; i<infos.length; i++) {
            log("["+i+"] " + infos[i].getName() + " : " + infos[i].getDescription());
            //inDevices.add(new MidiDeviceInfo(infos[i],i));
            try {
                if (MidiSystem.getMidiDevice(infos[i]).getMaxTransmitters() != 0) {
                    inDevices.add(new MidiDeviceInfo(infos[i],i));
                }
                if (MidiSystem.getMidiDevice(infos[i]).getMaxReceivers() != 0) {
                    outDevices.add(new MidiDeviceInfo(infos[i],i));
                }
            } catch (MidiUnavailableException e) {

            }
        }

        aboutButton.setOnAction(event -> Popup.info("About","About the Program","MidiMapper  Copyright (C) 2019  Ben Johnston (gsckoco)\n" +
                "This program comes with ABSOLUTELY NO WARRANTY.\n" +
                "This is free software, and you are welcome to redistribute it\n" +
                "under certain conditions. If you would like to learn more goto:\n" +
                "https://github.com/gsckoco/MidiMapper/LICENSE.md"));

        indeviceSelector.setItems(inDevices);
        outdeviceSelector.setItems(outDevices);
        indeviceSelector.valueProperty().addListener((obs,oldVal,newVal) -> {
            if (oldVal != null) {
                try {
                    //MidiDevice oldDev = ((MidiDeviceInfo)oldVal).getDevice();
                    MidiDevice oldDev = (MidiSystem.getMidiDevice(infos[5]));
                    if (oldDev.getTransmitter().getReceiver() != null) {
                        oldDev.getTransmitter().getReceiver().close();
                    }
                    //oldDev.getTransmitter().setReceiver(null);
                    oldDev.close();
                } catch (MidiUnavailableException e) {
                    Popup.error("Midi device is currently unavailable",e.toString(),true);
                    e.printStackTrace();
                }
            }
            try {
                MidiDevice newDev = ((MidiDeviceInfo)newVal).getDevice();
                newDev.open(); // Open it too allow the listener to
                transmitter = newDev.getTransmitter();
                transmitter.setReceiver(new MidiCallback(this));
            } catch (MidiUnavailableException e) {
                Popup.error("Midi device is currently unavailable",e.toString(),true);
                e.printStackTrace();
            }

        });
    }
}
