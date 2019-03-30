package co.uk.gsck.midi.mapper.Handlers;

import co.uk.gsck.midi.mapper.Controllers.Main;
import javafx.application.Platform;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

public class MidiCallback implements Receiver {
    private Main main;
    public MidiCallback(Main main) {
        this.main = main;
    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        byte type = message.getMessage()[0];
        byte address = message.getMessage()[1];
        byte value = message.getMessage()[2];
        //main.log("Midi Message: " + type + ", " + address + ", " + value);
        Platform.runLater(
            () -> {
                main.setLastMIDIMessage((int)type+ ", " + (int)address + ", " + (int)value);
            }
        );

    }

    @Override
    public void close() {

    }
}
