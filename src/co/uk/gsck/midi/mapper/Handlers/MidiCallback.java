package co.uk.gsck.midi.mapper.Handlers;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

public class MidiCallback implements Receiver {

    public MidiCallback() {

    }

    @Override
    public void send(MidiMessage message, long timeStamp) {
        byte type = message.getMessage()[0];
        byte address = message.getMessage()[1];
        byte value = message.getMessage()[2];

    }

    @Override
    public void close() {

    }
}
